package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.filter.ReshapeEyeNoseLips;
import com.tencent.ttpic.filter.ReshapeWholeFace;
import com.tencent.ttpic.model.FaceBeautyItem;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.model.CameraBeautyParams;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RemodelFilter
  implements AEFilterI
{
  private String[] GPU_LIST = { "Mali", "PowerVR Rogue G6200" };
  private int age = 0;
  private CameraBeautyParams cameraBeautyParams = new CameraBeautyParams();
  private BaseFilter copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame copyFrame = new Frame();
  private BaseFilter cropFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame cropFrame = new Frame();
  private BaseFilter drawFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame eyesFrame = new Frame();
  private PTFaceAttr faceAttr;
  private int[][] faceOutline = (int[][])null;
  private List<PointF> facePoints = new ArrayList();
  private boolean isFemale = true;
  private FaceBeautyItem item;
  private int mCropWidth;
  private boolean needReCaculateFace = false;
  private Frame noseFrame = new Frame();
  private ReshapeCombineFilter reshapeCombineFilter = new ReshapeCombineFilter();
  private Frame reshapeCombineFrame = new Frame();
  private float reshapeCropWidth = 0.0F;
  private ReshapeEyeNoseLips reshapeEyeNoseLipsFilter;
  private float reshapeLeft = 0.0F;
  private float reshapeTop = 0.0F;
  private ReshapeWholeFace reshapeWholeFaceFilter;
  private int singleItemStartIndex = 2;
  private ReshapeType useMeshType;
  
  private float getDistance(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat1[0] - paramArrayOfFloat2[0];
    float f2 = paramArrayOfFloat1[1] - paramArrayOfFloat2[1];
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private float getDistance(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    float f1 = paramArrayOfFloat[0] - paramArrayOfInt[0];
    float f2 = paramArrayOfFloat[1] - paramArrayOfInt[1];
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private float getDistance(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    float f1 = paramArrayOfInt1[0] - paramArrayOfInt2[0];
    float f2 = paramArrayOfInt1[1] - paramArrayOfInt2[1];
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void initFilter(List<PointF> paramList, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if ((this.faceOutline == null) || (this.faceOutline.length != paramList.size()))
    {
      i = paramList.size();
      this.faceOutline = ((int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 }));
    }
    int i1 = 2147483647;
    int m = 2147483647;
    int j = -2147483648;
    int i = -2147483648;
    int k = 0;
    while (k < paramList.size())
    {
      n = i1;
      if (i1 > ((PointF)paramList.get(k)).x) {
        n = (int)((PointF)paramList.get(k)).x;
      }
      i1 = m;
      if (m > ((PointF)paramList.get(k)).y) {
        i1 = (int)((PointF)paramList.get(k)).y;
      }
      m = j;
      if (j < ((PointF)paramList.get(k)).x) {
        m = (int)((PointF)paramList.get(k)).x;
      }
      j = i;
      if (i < ((PointF)paramList.get(k)).y) {
        j = (int)((PointF)paramList.get(k)).y;
      }
      k += 1;
      i = j;
      j = m;
      m = i1;
      i1 = n;
    }
    int i2 = (j + i1) / 2;
    k = (i + m) / 2;
    j = (int)(Math.max(j - i1, i - m) * 2.5D);
    i = j / 2;
    m = i2 - i;
    int n = k - i;
    i1 = i2 + i;
    k = i + k;
    i = 0;
    while (i < paramList.size())
    {
      this.faceOutline[i][0] = ((int)(((PointF)paramList.get(i)).x - m));
      this.faceOutline[i][1] = ((int)(((PointF)paramList.get(i)).y - n));
      i += 1;
    }
    paramList = new float[8];
    paramList[0] = (m / paramInt1);
    paramList[1] = (n / paramInt2);
    paramList[2] = (m / paramInt1);
    paramList[3] = (k / paramInt2);
    paramList[4] = (i1 / paramInt1);
    paramList[5] = (k / paramInt2);
    paramList[6] = (i1 / paramInt1);
    paramList[7] = (n / paramInt2);
    this.cropFilter.setTexCords(paramList);
    paramInt1 = 0;
    while (paramInt1 < 8)
    {
      paramList[paramInt1] = (paramList[paramInt1] * 2.0F - 1.0F);
      paramInt1 += 1;
    }
    this.drawFilter.setPositions(paramList);
    this.mCropWidth = j;
    innerInitFilter(this.faceOutline, paramArrayOfFloat, j, j);
  }
  
  private void initFilter4(List<PointF> paramList, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if ((this.faceOutline == null) || (this.faceOutline.length != paramList.size()))
    {
      i = paramList.size();
      this.faceOutline = ((int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 }));
    }
    int i1 = 2147483647;
    int m = 2147483647;
    int j = -2147483648;
    int i = -2147483648;
    int k = 0;
    while (k < paramList.size())
    {
      n = i1;
      if (i1 > ((PointF)paramList.get(k)).x) {
        n = (int)((PointF)paramList.get(k)).x;
      }
      i1 = m;
      if (m > ((PointF)paramList.get(k)).y) {
        i1 = (int)((PointF)paramList.get(k)).y;
      }
      m = j;
      if (j < ((PointF)paramList.get(k)).x) {
        m = (int)((PointF)paramList.get(k)).x;
      }
      j = i;
      if (i < ((PointF)paramList.get(k)).y) {
        j = (int)((PointF)paramList.get(k)).y;
      }
      k += 1;
      i = j;
      j = m;
      m = i1;
      i1 = n;
    }
    k = (j + i1) / 2;
    int n = (i + m) / 2;
    j = (int)(Math.max(j - i1, i - m) * 2.5F);
    m = j / 2;
    i1 = k - m;
    int i2 = n - m;
    i = 0;
    while (i < paramList.size())
    {
      this.faceOutline[i][0] = ((int)(((PointF)paramList.get(i)).x - i1));
      this.faceOutline[i][1] = ((int)(((PointF)paramList.get(i)).y - i2));
      i += 1;
    }
    this.reshapeCropWidth = j;
    this.reshapeLeft = i1;
    this.reshapeTop = i2;
    paramList = this.cameraBeautyParams.param;
    paramList.clear();
    paramList.put("size", new float[] { paramInt1, paramInt2 });
    paramList.put("vectorMapSize", new float[] { j, j });
    this.reshapeCombineFilter.updateSize(i1 / paramInt1, (k + m) / paramInt1, i2 / paramInt2, (m + n) / paramInt2);
    this.reshapeCombineFilter.setParam(paramList);
    innerInitFilter(this.faceOutline, paramArrayOfFloat, j, j);
  }
  
  private void innerInitFilter(int[][] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat16 = new float[2];
    arrayOfFloat16[0] = ((paramArrayOfInt[55][0] + paramArrayOfInt[63][0]) / 2.0F);
    arrayOfFloat16[1] = ((paramArrayOfInt[55][1] + paramArrayOfInt[63][1]) / 2.0F);
    float f23 = (paramArrayOfInt[23][0] + paramArrayOfInt[31][0]) / 2.0F;
    float f24 = (paramArrayOfInt[23][1] + paramArrayOfInt[31][1]) / 2.0F;
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = (getDistance(paramArrayOfInt[39], paramArrayOfInt[35]) / paramInt1);
    arrayOfFloat1[1] = (getDistance(paramArrayOfInt[41], paramArrayOfInt[37]) / paramInt2);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = (paramArrayOfInt[43][0] / paramInt1);
    arrayOfFloat2[1] = (paramArrayOfInt[43][1] / paramInt2);
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = (getDistance(paramArrayOfInt[45], paramArrayOfInt[49]) / paramInt1);
    arrayOfFloat3[1] = (getDistance(paramArrayOfInt[51], paramArrayOfInt[47]) / paramInt2);
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = (paramArrayOfInt[53][0] / paramInt1);
    arrayOfFloat4[1] = (paramArrayOfInt[53][1] / paramInt2);
    float[] arrayOfFloat5 = new float[2];
    arrayOfFloat5[0] = ((arrayOfFloat16[0] + paramArrayOfInt[59][0]) / 2.0F / paramInt1);
    arrayOfFloat5[1] = ((arrayOfFloat16[1] + paramArrayOfInt[59][1]) / 2.0F / paramInt2);
    float[] arrayOfFloat6 = new float[2];
    arrayOfFloat6[0] = (getDistance(paramArrayOfInt[61], paramArrayOfInt[57]) / paramInt1);
    arrayOfFloat6[1] = (getDistance(arrayOfFloat16, new float[] { paramArrayOfInt[59][0], paramArrayOfInt[59][1] }) / paramInt2);
    float f3 = paramArrayOfInt[64][0] / paramInt1;
    float f4 = paramArrayOfInt[64][1] / paramInt2;
    float f1 = (paramArrayOfInt[56][0] + paramArrayOfInt[62][0]) / 2.0F;
    float f2 = (paramArrayOfInt[56][1] + paramArrayOfInt[62][1]) / 2.0F;
    float f5 = (getDistance(paramArrayOfInt[62], paramArrayOfInt[56]) + getDistance(paramArrayOfInt[61], paramArrayOfInt[57])) / 2.0F / paramInt1;
    Object localObject = paramArrayOfInt[59];
    float f6 = getDistance(new float[] { f1, f2 }, (int[])localObject) / paramInt2;
    float f7 = (paramArrayOfInt[61][0] + paramArrayOfInt[57][0]) / 2.0F / paramInt1;
    float f8 = (paramArrayOfInt[61][1] + paramArrayOfInt[57][1]) / 2.0F / paramInt2;
    f1 = (paramArrayOfInt[75][0] + paramArrayOfInt[79][0] + paramArrayOfInt[67][0] + paramArrayOfInt[71][0]) / 4.0F;
    f2 = (paramArrayOfInt[75][1] + paramArrayOfInt[79][1] + paramArrayOfInt[67][1] + paramArrayOfInt[71][1]) / 4.0F;
    localObject = new float[2];
    localObject[0] = (f1 / paramInt1);
    localObject[1] = (f2 / paramInt2);
    float[] arrayOfFloat7 = new float[2];
    arrayOfFloat7[0] = (getDistance(paramArrayOfInt[66], paramArrayOfInt[65]) / paramInt1);
    arrayOfFloat7[1] = (getDistance(paramArrayOfInt[77], paramArrayOfInt[69]) / paramInt2);
    float f9 = paramArrayOfInt[65][0] / paramInt1;
    float f10 = paramArrayOfInt[65][1] / paramInt2;
    float f11 = paramArrayOfInt[66][0] / paramInt1;
    float f12 = paramArrayOfInt[66][1] / paramInt2;
    float f13 = arrayOfFloat7[0] / 3.0F;
    float f14 = getDistance(paramArrayOfInt[2], paramArrayOfInt[8]) / paramInt2;
    float f15 = (paramArrayOfInt[4][0] + paramArrayOfInt[3][0]) / 2.0F / paramInt1;
    float f16 = (paramArrayOfInt[4][1] + paramArrayOfInt[3][1]) / 2.0F / paramInt2;
    float f17 = (float)(Math.atan2(paramArrayOfInt[8][1] - paramArrayOfInt[1][1], paramArrayOfInt[8][0] - paramArrayOfInt[1][0]) + 1.570796326794897D);
    float f18 = arrayOfFloat7[0] / 3.0F;
    float f19 = getDistance(paramArrayOfInt[16], paramArrayOfInt[10]) / paramInt2;
    float f20 = (paramArrayOfInt[15][0] + paramArrayOfInt[14][0]) / 2.0F / paramInt1;
    float f21 = (paramArrayOfInt[15][1] + paramArrayOfInt[14][1]) / 2.0F / paramInt2;
    float f22 = (float)(Math.atan2(paramArrayOfInt[17][1] - paramArrayOfInt[10][1], paramArrayOfInt[17][0] - paramArrayOfInt[10][0]) + 1.570796326794897D);
    f2 = 0.0F;
    f1 = 0.0F;
    int i = 19;
    while (i <= 26)
    {
      f2 += paramArrayOfInt[i][0];
      f1 += paramArrayOfInt[i][1];
      i += 1;
    }
    f2 /= 8.0F;
    f1 /= 8.0F;
    float[] arrayOfFloat8 = new float[2];
    arrayOfFloat8[0] = (f2 / paramInt1);
    arrayOfFloat8[1] = (f1 / paramInt2);
    float[] arrayOfFloat9 = new float[2];
    arrayOfFloat9[0] = (getDistance(paramArrayOfInt[19], paramArrayOfInt[23]) / paramInt1);
    arrayOfFloat9[1] = (getDistance(paramArrayOfInt[21], paramArrayOfInt[25]) / paramInt2);
    f2 = 0.0F;
    f1 = 0.0F;
    i = 27;
    while (i <= 34)
    {
      f2 += paramArrayOfInt[i][0];
      f1 += paramArrayOfInt[i][1];
      i += 1;
    }
    f2 /= 8.0F;
    f1 /= 8.0F;
    float[] arrayOfFloat10 = new float[2];
    arrayOfFloat10[0] = (f2 / paramInt1);
    arrayOfFloat10[1] = (f1 / paramInt2);
    float[] arrayOfFloat11 = new float[2];
    arrayOfFloat11[0] = (getDistance(paramArrayOfInt[27], paramArrayOfInt[31]) / paramInt1);
    arrayOfFloat11[1] = (getDistance(paramArrayOfInt[29], paramArrayOfInt[33]) / paramInt2);
    f1 = getDistance(paramArrayOfInt[0], paramArrayOfInt[18]) / paramInt1;
    f2 = getDistance(new float[] { paramArrayOfInt[9][0], paramArrayOfInt[9][1] }, new float[] { f23, f24 }) * 1.1F / paramInt2;
    f23 = (paramArrayOfInt[1][0] + paramArrayOfInt[17][0]) / 2.0F / paramInt1;
    f24 = (paramArrayOfInt[1][1] + paramArrayOfInt[17][1]) / 2.0F / paramInt2;
    float[] arrayOfFloat12 = new float[2];
    arrayOfFloat12[0] = ((paramArrayOfInt[56][0] + paramArrayOfInt[62][0]) / 2.0F / paramInt1);
    arrayOfFloat12[1] = ((paramArrayOfInt[56][1] + paramArrayOfInt[62][1]) / 2.0F / paramInt2);
    float f25 = getDistance(paramArrayOfInt[2], paramArrayOfInt[57]) / paramInt1;
    float f26 = getDistance(paramArrayOfInt[1], paramArrayOfInt[8]) / paramInt2;
    float[] arrayOfFloat13 = new float[2];
    arrayOfFloat13[0] = ((paramArrayOfInt[4][0] + paramArrayOfInt[5][0]) / 2.0F / paramInt1);
    arrayOfFloat13[1] = ((paramArrayOfInt[4][1] + paramArrayOfInt[5][1]) / 2.0F / paramInt2);
    i = 0;
    while (i < arrayOfFloat13.length)
    {
      arrayOfFloat13[i] += (arrayOfFloat12[i] - arrayOfFloat13[i]) * 0.07F;
      i += 1;
    }
    float f27 = (float)(Math.atan2(paramArrayOfInt[8][1] - paramArrayOfInt[2][1], paramArrayOfInt[8][0] - paramArrayOfInt[2][0]) + 1.570796326794897D);
    float f28 = getDistance(paramArrayOfInt[16], paramArrayOfInt[61]) / paramInt1;
    float f29 = getDistance(paramArrayOfInt[17], paramArrayOfInt[10]) / paramInt2;
    float[] arrayOfFloat14 = new float[2];
    arrayOfFloat14[0] = ((paramArrayOfInt[13][0] + paramArrayOfInt[14][0]) / 2.0F / paramInt1);
    arrayOfFloat14[1] = ((paramArrayOfInt[13][1] + paramArrayOfInt[14][1]) / 2.0F / paramInt2);
    i = 0;
    while (i < arrayOfFloat14.length)
    {
      arrayOfFloat14[i] += (arrayOfFloat12[i] - arrayOfFloat14[i]) * 0.07F;
      i += 1;
    }
    float f30 = (float)(Math.atan2(paramArrayOfInt[16][1] - paramArrayOfInt[10][1], paramArrayOfInt[16][0] - paramArrayOfInt[10][0]) + 1.570796326794897D);
    float f31 = getDistance(paramArrayOfInt[0], paramArrayOfInt[35]) / paramInt1;
    float f32 = getDistance(paramArrayOfInt[0], paramArrayOfInt[2]) / paramInt2;
    float f33 = (paramArrayOfInt[0][0] + paramArrayOfInt[1][0]) / 2.0F / paramInt1;
    float f34 = (paramArrayOfInt[0][1] + paramArrayOfInt[1][1]) / 2.0F / paramInt2;
    float f35 = (float)(Math.atan2(paramArrayOfInt[2][1] - paramArrayOfInt[0][1], paramArrayOfInt[2][0] - paramArrayOfInt[0][0]) + 1.570796326794897D);
    float f36 = getDistance(paramArrayOfInt[18], paramArrayOfInt[45]) / paramInt1;
    float f37 = getDistance(paramArrayOfInt[18], paramArrayOfInt[16]) / paramInt2;
    float f38 = (paramArrayOfInt[18][0] + paramArrayOfInt[17][0]) / 2.0F / paramInt1;
    float f39 = (paramArrayOfInt[18][1] + paramArrayOfInt[17][1]) / 2.0F / paramInt2;
    float f40 = (float)(Math.atan2(paramArrayOfInt[18][1] - paramArrayOfInt[16][1], paramArrayOfInt[18][0] - paramArrayOfInt[16][0]) + 1.570796326794897D);
    float f41 = (paramArrayOfInt[4][0] * 0.5F + paramArrayOfInt[14][0] * 0.5F) / paramInt1;
    float f42 = (paramArrayOfInt[4][1] * 0.6F + paramArrayOfInt[14][1] * 0.4F) / paramInt2;
    float f43 = getDistance(paramArrayOfInt[15], paramArrayOfInt[3]) / paramInt1;
    float f44 = getDistance(paramArrayOfInt[9], paramArrayOfInt[59]) / paramInt2;
    float[] arrayOfFloat17 = new float[2];
    arrayOfFloat17[0] = ((paramArrayOfInt[3][0] + paramArrayOfInt[15][0]) / 2.0F);
    arrayOfFloat17[1] = ((paramArrayOfInt[3][1] + paramArrayOfInt[15][1]) / 2.0F);
    float[] arrayOfFloat18 = new float[2];
    arrayOfFloat18[0] = ((paramArrayOfInt[0][0] + paramArrayOfInt[18][0]) / 2.0F);
    arrayOfFloat18[1] = ((paramArrayOfInt[0][1] + paramArrayOfInt[18][1]) / 2.0F);
    float[] arrayOfFloat15 = new float[2];
    arrayOfFloat15[0] = (getDistance(paramArrayOfInt[0], paramArrayOfInt[18]) / paramInt1);
    arrayOfFloat15[1] = (getDistance(arrayOfFloat17, arrayOfFloat18) / paramInt2);
    float f45 = arrayOfFloat16[0];
    f45 = arrayOfFloat16[0];
    f45 = paramArrayOfInt[9][0];
    f45 = arrayOfFloat16[1];
    f45 = arrayOfFloat16[1];
    f45 = paramArrayOfInt[9][1];
    arrayOfFloat16 = new float[3];
    arrayOfFloat16[0] = paramArrayOfFloat[0];
    arrayOfFloat16[1] = paramArrayOfFloat[1];
    arrayOfFloat16[2] = paramArrayOfFloat[2];
    arrayOfFloat16[2] = ((float)Math.atan2(paramArrayOfInt[53][1] - paramArrayOfInt[43][1], paramArrayOfInt[53][0] - paramArrayOfInt[43][0]));
    f45 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, arrayOfFloat16[1] * 1.0D));
    float f46 = (float)Math.cos(f45);
    paramArrayOfFloat = new float[2];
    paramArrayOfFloat[0] = (paramArrayOfInt[0][0] + (arrayOfFloat18[0] - arrayOfFloat17[0]) * 1.5F);
    paramArrayOfFloat[1] = (paramArrayOfInt[0][1] + (arrayOfFloat18[1] - arrayOfFloat17[1]) * 1.5F);
    float[] arrayOfFloat19 = new float[2];
    arrayOfFloat19[0] = (paramArrayOfInt[18][0] + (arrayOfFloat18[0] - arrayOfFloat17[0]) * 1.5F);
    float f47 = paramArrayOfInt[18][1];
    arrayOfFloat19[1] = ((arrayOfFloat18[1] - arrayOfFloat17[1]) * 1.5F + f47);
    if (f45 < 0.0F)
    {
      paramArrayOfInt = new float[2];
      paramArrayOfFloat[0] += (arrayOfFloat19[0] - paramArrayOfFloat[0]) / f46 / 2.0F;
      paramArrayOfFloat[1] += (arrayOfFloat19[1] - paramArrayOfFloat[1]) / f46 / 2.0F;
    }
    for (;;)
    {
      paramArrayOfInt[0] /= paramInt1;
      paramArrayOfInt[1] /= paramInt2;
      arrayOfFloat15[0] /= f46;
      paramArrayOfFloat = this.cameraBeautyParams.param;
      paramArrayOfFloat.clear();
      paramArrayOfFloat.put("angles", arrayOfFloat16);
      paramArrayOfFloat.put("size", new float[] { paramInt1, paramInt2 });
      paramArrayOfFloat.put("leftEyePlainSize", arrayOfFloat1);
      paramArrayOfFloat.put("leftEyeCenter", arrayOfFloat2);
      paramArrayOfFloat.put("rightEyePlainSize", arrayOfFloat3);
      paramArrayOfFloat.put("rightEyeCenter", arrayOfFloat4);
      paramArrayOfFloat.put("nose3DCenter", arrayOfFloat5);
      paramArrayOfFloat.put("nosePlainSize", arrayOfFloat6);
      paramArrayOfFloat.put("noseTipCenter", new float[] { f3, f4 });
      paramArrayOfFloat.put("noseTipPlaneSize", new float[] { f5, f6 });
      paramArrayOfFloat.put("noseBottomCenter", new float[] { f7, f8 });
      paramArrayOfFloat.put("lipsCenter", localObject);
      paramArrayOfFloat.put("lipsPlainSize", arrayOfFloat7);
      paramArrayOfFloat.put("leftEyebrowCenter", arrayOfFloat8);
      paramArrayOfFloat.put("leftEyebrowPlainSize", arrayOfFloat9);
      paramArrayOfFloat.put("rightEyebrowCenter", arrayOfFloat10);
      paramArrayOfFloat.put("rightEyebrowPlainSize", arrayOfFloat11);
      paramArrayOfFloat.put("lipsProtectSizeLeft", new float[] { f13, f14 });
      paramArrayOfFloat.put("lipsProtectCenterLeft", new float[] { f15, f16 });
      paramArrayOfFloat.put("lipsProtectAngleLeft", Float.valueOf(f17));
      paramArrayOfFloat.put("lipsProtectSizeRight", new float[] { f18, f19 });
      paramArrayOfFloat.put("lipsProtectCenterRight", new float[] { f20, f21 });
      paramArrayOfFloat.put("lipsProtectAngleRight", Float.valueOf(f22));
      this.reshapeEyeNoseLipsFilter.setParam(paramArrayOfFloat);
      paramArrayOfFloat.clear();
      paramArrayOfFloat.put("angles", arrayOfFloat16);
      paramArrayOfFloat.put("size", new float[] { paramInt1, paramInt2 });
      paramArrayOfFloat.put("leftEyePlainSize", arrayOfFloat1);
      paramArrayOfFloat.put("leftEyeCenter", arrayOfFloat2);
      paramArrayOfFloat.put("rightEyePlainSize", arrayOfFloat3);
      paramArrayOfFloat.put("rightEyeCenter", arrayOfFloat4);
      paramArrayOfFloat.put("leftEyebrowCenter", arrayOfFloat8);
      paramArrayOfFloat.put("leftEyebrowPlainSize", arrayOfFloat9);
      paramArrayOfFloat.put("rightEyebrowCenter", arrayOfFloat10);
      paramArrayOfFloat.put("rightEyebrowPlainSize", arrayOfFloat11);
      paramArrayOfFloat.put("nose3DCenter", arrayOfFloat5);
      paramArrayOfFloat.put("nosePlainSize", arrayOfFloat6);
      paramArrayOfFloat.put("lipsCenter", localObject);
      paramArrayOfFloat.put("lipsPlainSize", arrayOfFloat7);
      paramArrayOfFloat.put("lipsLeftEdge", new float[] { f9, f10 });
      paramArrayOfFloat.put("lipsRightEdge", new float[] { f11, f12 });
      paramArrayOfFloat.put("facePlainSize", new float[] { f1, f2 });
      paramArrayOfFloat.put("faceCenter", new float[] { f23, f24 });
      paramArrayOfFloat.put("facePlainSizeLeft2", new float[] { f25, f26 });
      paramArrayOfFloat.put("faceCenterLeft2", arrayOfFloat13);
      paramArrayOfFloat.put("leftAngle2", Float.valueOf(f27));
      paramArrayOfFloat.put("facePlainSizeRight2", new float[] { f28, f29 });
      paramArrayOfFloat.put("faceCenterRight2", arrayOfFloat14);
      paramArrayOfFloat.put("rightAngle2", Float.valueOf(f30));
      paramArrayOfFloat.put("faceMoveCenter2", arrayOfFloat12);
      paramArrayOfFloat.put("facePlainSizeUpLeft2", new float[] { f31, f32 });
      paramArrayOfFloat.put("faceCenterUpLeft2", new float[] { f33, f34 });
      paramArrayOfFloat.put("upLeftAngle2", Float.valueOf(f35));
      paramArrayOfFloat.put("facePlainSizeUpRight2", new float[] { f36, f37 });
      paramArrayOfFloat.put("faceCenterUpRight2", new float[] { f38, f39 });
      paramArrayOfFloat.put("upRightAngle2", Float.valueOf(f40));
      paramArrayOfFloat.put("jawCenterOfGravity", new float[] { f41, f42 });
      paramArrayOfFloat.put("jawSize", new float[] { f43, f44 });
      paramArrayOfFloat.put("foreheadCenter", paramArrayOfInt);
      paramArrayOfFloat.put("foreheadSize", arrayOfFloat15);
      if (this.reshapeWholeFaceFilter != null) {
        this.reshapeWholeFaceFilter.setParam(paramArrayOfFloat);
      }
      return;
      paramArrayOfInt = new float[2];
      arrayOfFloat19[0] += (paramArrayOfFloat[0] - arrayOfFloat19[0]) / f46 / 2.0F;
      arrayOfFloat19[1] += (paramArrayOfFloat[1] - arrayOfFloat19[1]) / f46 / 2.0F;
    }
  }
  
  private boolean isFilterValid(ReshapeType paramReshapeType)
  {
    switch (RemodelFilter.1.$SwitchMap$com$tencent$ttpic$openapi$filter$ReshapeType[paramReshapeType.ordinal()])
    {
    default: 
      if ((!this.reshapeEyeNoseLipsFilter.isValid()) || (!this.reshapeWholeFaceFilter.isValid()) || (!this.reshapeCombineFilter.isValid())) {
        break;
      }
    case 1: 
      do
      {
        return true;
      } while ((this.reshapeEyeNoseLipsFilter.isValid()) && (this.reshapeWholeFaceFilter.isValid()));
      return false;
    }
    return false;
  }
  
  private Frame processReshape(Frame paramFrame, List<List<PointF>> paramList, List<FaceStatus> paramList1, List<float[]> paramList2, double paramDouble, boolean paramBoolean)
  {
    Object localObject;
    if (!isFilterValid(this.useMeshType))
    {
      localObject = paramFrame;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      localObject = paramFrame;
      if (i >= paramList.size()) {
        break;
      }
      boolean bool;
      if ((paramList1 != null) && (paramList1.size() > i))
      {
        if (((FaceStatus)paramList1.get(i)).gender != 1) {
          break label238;
        }
        bool = true;
        this.isFemale = bool;
        if (!BeautyAIParam.needAIBeautyValid()) {
          break label244;
        }
      }
      label238:
      label244:
      for (int j = ((FaceStatus)paramList1.get(i)).age;; j = 0)
      {
        this.age = j;
        this.cameraBeautyParams.setAgeGender(this.isFemale, this.age, paramBoolean);
        this.cameraBeautyParams.updateReshapeParams();
        localObject = this.cameraBeautyParams.param;
        this.reshapeEyeNoseLipsFilter.setParam((Map)localObject);
        this.reshapeWholeFaceFilter.setParam((Map)localObject);
        localObject = FaceDetectUtil.facePointf83to90(VideoMaterial.copyList((List)paramList.get(i)));
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          PointF localPointF = (PointF)localIterator.next();
          localPointF.x = ((float)(localPointF.x / paramDouble));
          localPointF.y = ((float)(localPointF.y / paramDouble));
        }
        bool = false;
        break;
      }
      initFilter((List)localObject, (float[])paramList2.get(i), paramFrame.width, paramFrame.height);
      this.cropFilter.RenderProcess(paramFrame.getTextureId(), this.mCropWidth, this.mCropWidth, -1, 0.0D, this.cropFrame);
      localObject = this.cropFrame;
      this.reshapeEyeNoseLipsFilter.RenderProcess(((Frame)localObject).getTextureId(), this.mCropWidth, this.mCropWidth, -1, 0.0D, this.eyesFrame);
      localObject = this.eyesFrame;
      this.reshapeWholeFaceFilter.RenderProcess(((Frame)localObject).getTextureId(), this.mCropWidth, this.mCropWidth, -1, 0.0D, this.noseFrame);
      localObject = this.noseFrame;
      this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.reshapeCombineFrame);
      this.drawFilter.RenderProcess(((Frame)localObject).getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.reshapeCombineFrame);
      paramFrame.unlock();
      paramFrame = this.reshapeCombineFrame;
      i += 1;
    }
  }
  
  private Frame processReshape4(Frame paramFrame, List<List<PointF>> paramList, List<FaceStatus> paramList1, List<float[]> paramList2, double paramDouble, boolean paramBoolean)
  {
    if (!isFilterValid(this.useMeshType)) {}
    while (!this.cameraBeautyParams.needRender()) {
      return paramFrame;
    }
    Object localObject1 = FrameBufferCache.getInstance().get(128, 128);
    int i = 0;
    Object localObject2 = paramFrame;
    paramFrame = (Frame)localObject1;
    Map localMap;
    if (i < paramList.size())
    {
      if ((paramList1 != null) && (paramList1.size() > i)) {
        if (((FaceStatus)paramList1.get(i)).gender != 1) {
          break label259;
        }
      }
      label259:
      for (boolean bool = true;; bool = false)
      {
        this.isFemale = bool;
        this.age = ((FaceStatus)paramList1.get(i)).age;
        this.cameraBeautyParams.setAgeGender(this.isFemale, this.age, paramBoolean);
        this.cameraBeautyParams.updateReshapeParams4();
        localMap = this.cameraBeautyParams.param;
        this.reshapeEyeNoseLipsFilter.setParam(localMap);
        this.reshapeWholeFaceFilter.setParam(localMap);
        this.facePoints = VideoMaterial.copyList((List)paramList.get(i));
        localObject1 = FaceDetectUtil.facePointf83to90(this.facePoints);
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          PointF localPointF = (PointF)localIterator.next();
          localPointF.x = ((float)(localPointF.x / paramDouble));
          localPointF.y = ((float)(localPointF.y / paramDouble));
        }
      }
      initFilter4((List)localObject1, (float[])paramList2.get(i), ((Frame)localObject2).width, ((Frame)localObject2).height);
      FrameUtil.clearFrame(paramFrame, 0.4980392F, 0.4980392F, 0.5019608F, 0.5019608F, 128, 128);
      localObject1 = paramFrame;
      if (this.cameraBeautyParams.needRenderEyeNoseLips())
      {
        localObject1 = this.reshapeEyeNoseLipsFilter.RenderProcess(paramFrame.getTextureId(), 128, 128);
        paramFrame.unlock();
      }
      if (!this.cameraBeautyParams.needRenderWholeFace()) {
        break label563;
      }
      paramFrame = this.reshapeWholeFaceFilter.RenderProcess(((Frame)localObject1).getTextureId(), 128, 128);
      ((Frame)localObject1).unlock();
    }
    for (;;)
    {
      localMap.clear();
      localMap.put("inputImageTexture2", Integer.valueOf(paramFrame.getTextureId()));
      localObject1 = this.copyFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height);
      this.reshapeCombineFilter.setParam(localMap);
      this.reshapeCombineFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height, -1, 0.0D, (Frame)localObject1);
      ((Frame)localObject2).unlock();
      if ((this.needReCaculateFace) && (this.faceAttr != null) && (this.faceAttr.getTransformFacePoints().size() > i)) {
        this.faceAttr.setTransformFacePoints(i, calFacePointAfterTransform(paramFrame, (List)this.faceAttr.getTransformFacePoints().get(i), (float)paramDouble));
      }
      i += 1;
      localObject2 = localObject1;
      break;
      paramFrame.unlock();
      return localObject2;
      label563:
      paramFrame = (Frame)localObject1;
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    if (this.faceAttr == null) {
      return paramFrame;
    }
    return process(paramFrame, this.faceAttr.getAllFacePoints(), this.faceAttr.getFaceStatusList(), this.faceAttr.getAllFaceAngles(), this.faceAttr.getFaceDetectScale(), false);
  }
  
  public List<PointF> calFacePointAfterTransform(Frame paramFrame, List<PointF> paramList, float paramFloat)
  {
    int i6 = paramFrame.width;
    int i7 = paramFrame.height;
    float f3 = this.reshapeCropWidth / (i6 - 1);
    float f4 = this.reshapeCropWidth / (i7 - 1);
    Object localObject1 = new byte[i6 * i7 * 4];
    GlUtil.saveTextureToRgbaBuffer(paramFrame.getTextureId(), 0, 0, i6, i7, (byte[])localObject1, paramFrame.getFBO());
    paramFrame = (float[][][])Array.newInstance(Float.TYPE, new int[] { i7, i6, 2 });
    int i = 0;
    while (i < i7)
    {
      j = 0;
      while (j < i6)
      {
        paramFrame[i][j][0] = (getPixel((byte[])localObject1, i, j, i6).x * this.reshapeCropWidth + j * f3);
        paramFrame[i][j][1] = (getPixel((byte[])localObject1, i, j, i6).y * this.reshapeCropWidth + i * f4);
        j += 1;
      }
      i += 1;
    }
    localObject1 = new ArrayList();
    int i3 = 0;
    float f5;
    float f6;
    int i4;
    int n;
    label325:
    int k;
    int m;
    label381:
    Object localObject2;
    int i1;
    float f1;
    if (i3 < paramList.size())
    {
      f5 = ((PointF)paramList.get(i3)).x / paramFloat - this.reshapeLeft;
      f6 = ((PointF)paramList.get(i3)).y / paramFloat - this.reshapeTop;
      int i8 = (int)(f6 / f4);
      int i9 = (int)(f5 / f3);
      int i10 = Math.max(Math.max(i8, i7 - i8), Math.max(i9, i6 - i9));
      j = 0;
      i4 = 0;
      i = -1;
      n = -1;
      if (i4 >= i10) {
        break label1460;
      }
      int i2 = i8 - i4;
      k = i;
      i = j;
      j = n;
      if (i2 > i8 + i4) {
        break label1445;
      }
      if (i2 < 0) {
        break label1434;
      }
      if (i2 >= i7)
      {
        m = i;
        i = k;
      }
      label847:
      do
      {
        i2 += 1;
        k = i;
        i = m;
        break;
        m = i9 - i4;
        if (m > i9 + i4) {
          break label1423;
        }
        if ((m < 0) || (m >= i6)) {}
        do
        {
          do
          {
            m += 1;
            break;
          } while ((i2 > i8 - i4) && (i2 < i8 + i4) && (m > i9 - i4) && (m < i9 + i4));
          localObject2 = new float[4][];
          localObject2[0] = { paramFrame[i2][m][0], paramFrame[i2][m][1] };
          localObject2[1] = { paramFrame[i2][(m + 1)][0], paramFrame[i2][(m + 1)][1] };
          localObject2[2] = { paramFrame[(i2 + 1)][(m + 1)][0], paramFrame[(i2 + 1)][(m + 1)][1] };
          localObject2[3] = { paramFrame[(i2 + 1)][m][0], paramFrame[(i2 + 1)][m][1] };
          i1 = 0;
          n = 0;
          if (n < 4)
          {
            float[] arrayOfFloat1 = new float[2];
            arrayOfFloat1[0] = localObject2[n][0];
            arrayOfFloat1[1] = localObject2[n][1];
            float[] arrayOfFloat2 = new float[2];
            arrayOfFloat2[0] = localObject2[((n + 1) % 4)][0];
            arrayOfFloat2[1] = localObject2[((n + 1) % 4)][1];
            int i5;
            if (arrayOfFloat1[1] == arrayOfFloat2[1]) {
              i5 = i1;
            }
            for (;;)
            {
              n += 1;
              i1 = i5;
              break;
              if (f6 < arrayOfFloat1[1])
              {
                i5 = i1;
                if (f6 < arrayOfFloat2[1]) {}
              }
              else if (f6 >= arrayOfFloat1[1])
              {
                i5 = i1;
                if (f6 >= arrayOfFloat2[1]) {}
              }
              else
              {
                f1 = (f6 - arrayOfFloat1[1]) * (arrayOfFloat2[0] - arrayOfFloat1[0]) / (arrayOfFloat2[1] - arrayOfFloat1[1]);
                i5 = i1;
                if (arrayOfFloat1[0] + f1 > f5) {
                  i5 = i1 + 1;
                }
              }
            }
          }
        } while (i1 % 2 != 1);
        i1 = 1;
        k = m;
        n = i2;
        i = k;
        j = n;
        m = i1;
      } while (i1 == 0);
      i = k;
      label868:
      if (i1 == 0) {}
    }
    label1026:
    label1423:
    label1434:
    label1445:
    label1460:
    for (int j = n;; j = n)
    {
      float f7;
      float f8;
      float f9;
      float f10;
      float f2;
      float f11;
      if ((j != -1) && (i != -1))
      {
        localObject2 = new float[4];
        tmp896_894 = localObject2;
        tmp896_894[0] = 0.0F;
        tmp900_896 = tmp896_894;
        tmp900_896[1] = 0.0F;
        tmp904_900 = tmp900_896;
        tmp904_900[2] = 0.0F;
        tmp908_904 = tmp904_900;
        tmp908_904[3] = 0.0F;
        tmp908_904;
        f7 = paramFrame[j][(i + 1)][0];
        f8 = paramFrame[j][(i + 1)][1];
        f9 = paramFrame[(j + 1)][i][0];
        f10 = paramFrame[(j + 1)][i][1];
        f2 = paramFrame[(j + 1)][(i + 1)][0];
        f1 = paramFrame[(j + 1)][(i + 1)][1];
        if ((f9 - f5) * (f8 - f6) - (f10 - f6) * (f7 - f5) > 0.0F) {
          break label1396;
        }
        k = 1;
        if (k != 0)
        {
          f2 = paramFrame[j][i][0];
          f1 = paramFrame[j][i][1];
        }
        f11 = Math.abs((f9 - f7) * (f1 - f8) - (f10 - f8) * (f2 - f7));
        if (f11 > 1.0E-007D)
        {
          f2 -= f5;
          f1 -= f6;
          localObject2[1] = (Math.abs((f9 - f5) * f1 - (f10 - f6) * f2) / f11);
          localObject2[2] = (Math.abs(f1 * (f7 - f5) - f2 * (f8 - f6)) / f11);
          if (k == 0) {
            break label1402;
          }
          localObject2[0] = (1.0F - localObject2[1] - localObject2[2]);
        }
      }
      for (;;)
      {
        f1 = i;
        f2 = j;
        f5 = i + 1;
        f6 = j;
        f7 = i + 1;
        f8 = j + 1;
        f9 = i;
        f10 = j + 1;
        f11 = localObject2[0];
        float f12 = localObject2[1];
        float f13 = localObject2[2];
        float f14 = localObject2[3];
        float f15 = localObject2[0];
        float f16 = localObject2[1];
        float f17 = localObject2[2];
        float f18 = localObject2[3];
        ((List)localObject1).add(new PointF((f1 * f3 * f11 + f5 * f3 * f12 + f13 * (f9 * f3) + f14 * (f7 * f3) + this.reshapeLeft) * paramFloat, (f2 * f4 * f15 + f16 * (f6 * f4) + f17 * (f10 * f4) + f18 * (f8 * f4) + this.reshapeTop) * paramFloat));
        i3 += 1;
        break;
        i4 += 1;
        j = i1;
        break label325;
        label1396:
        k = 0;
        break label1026;
        label1402:
        localObject2[3] = (1.0F - localObject2[1] - localObject2[2]);
      }
      return localObject1;
      n = j;
      i1 = i;
      break label847;
      m = i;
      i = k;
      break label381;
      i1 = i;
      i = k;
      n = j;
      break label868;
    }
  }
  
  public void clear()
  {
    if (this.reshapeCombineFilter != null) {
      this.reshapeCombineFilter.clearGLSLSelf();
    }
    if (this.reshapeEyeNoseLipsFilter != null) {
      this.reshapeEyeNoseLipsFilter.clearGLSLSelf();
    }
    if (this.reshapeWholeFaceFilter != null) {
      this.reshapeWholeFaceFilter.clearGLSLSelf();
    }
    if (this.copyFilter != null) {
      this.copyFilter.clearGLSLSelf();
    }
    if (this.cropFilter != null) {
      this.cropFilter.clearGLSLSelf();
    }
    if (this.drawFilter != null) {
      this.drawFilter.clearGLSLSelf();
    }
    if (this.eyesFrame != null) {
      this.eyesFrame.clear();
    }
    if (this.noseFrame != null) {
      this.noseFrame.clear();
    }
    if (this.reshapeCombineFrame != null) {
      this.reshapeCombineFrame.clear();
    }
    if (this.cropFrame != null) {
      this.cropFrame.clear();
    }
    if (this.copyFrame != null) {
      this.copyFrame.clear();
    }
    this.needReCaculateFace = false;
  }
  
  public void closeAIBeautyConfig()
  {
    this.cameraBeautyParams.closeAIBeautyConfig();
  }
  
  public FaceBeautyItem getFaceBeautyItem()
  {
    return this.item;
  }
  
  public PointF getPixel(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (paramInt1 * paramInt3 + paramInt2) * 4;
    paramInt1 = setColor(paramArrayOfByte[i] & 0xFF);
    paramInt2 = setColor(paramArrayOfByte[(i + 1)] & 0xFF);
    paramInt3 = setColor(paramArrayOfByte[(i + 2)] & 0xFF);
    i = setColor(paramArrayOfByte[(i + 3)] & 0xFF);
    return new PointF((float)(1.0D * paramInt1 / 127.5D + paramInt3 * 1.0D / 255.0D / 127.5D - 1.0D), (float)(paramInt2 * 1.0D / 127.5D + i * 1.0D / 255.0D / 127.5D - 1.0D));
  }
  
  public void init()
  {
    float[] arrayOfFloat = VideoMaterial.toFlatArray(VideoMaterial.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F));
    init(arrayOfFloat, arrayOfFloat);
  }
  
  public void init(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (GLCapabilities.supportVTF())
    {
      this.useMeshType = ReshapeType.VTF;
      this.reshapeCombineFilter.setInitMesh(paramArrayOfFloat1, paramArrayOfFloat2);
      this.reshapeCombineFilter.ApplyGLSLFilter();
    }
    for (;;)
    {
      this.reshapeEyeNoseLipsFilter = new ReshapeEyeNoseLips(this.useMeshType);
      this.reshapeWholeFaceFilter = new ReshapeWholeFace(this.useMeshType);
      this.reshapeEyeNoseLipsFilter.setInitMesh(paramArrayOfFloat1, paramArrayOfFloat2);
      this.reshapeWholeFaceFilter.setInitMesh(paramArrayOfFloat1, paramArrayOfFloat2);
      this.reshapeEyeNoseLipsFilter.ApplyGLSLFilter();
      this.reshapeWholeFaceFilter.ApplyGLSLFilter();
      this.copyFilter.apply();
      this.cropFilter.apply();
      this.drawFilter.apply();
      this.needReCaculateFace = false;
      return;
      this.useMeshType = ReshapeType.NORMAL;
    }
  }
  
  public Frame process(Frame paramFrame, List<List<PointF>> paramList, List<FaceStatus> paramList1, List<float[]> paramList2, double paramDouble, boolean paramBoolean)
  {
    if (this.useMeshType == ReshapeType.VTF) {
      return processReshape4(paramFrame, paramList, paramList1, paramList2, paramDouble, paramBoolean);
    }
    return processReshape(paramFrame, paramList, paramList1, paramList2, paramDouble, paramBoolean);
  }
  
  public void setAIBeautyValid(boolean paramBoolean)
  {
    this.cameraBeautyParams.setAIBeautyValid(paramBoolean);
  }
  
  public int setColor(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + 255;
    }
    return i;
  }
  
  public void setFaceBeautyItem(FaceBeautyItem paramFaceBeautyItem)
  {
    this.item = paramFaceBeautyItem;
  }
  
  public void setFemalePercent(float paramFloat)
  {
    this.cameraBeautyParams.setFemalePercent(paramFloat);
  }
  
  public void setMalePercent(float paramFloat)
  {
    this.cameraBeautyParams.setMalePercent(paramFloat);
  }
  
  public void setNeedReCaculateFace(boolean paramBoolean)
  {
    this.needReCaculateFace = paramBoolean;
  }
  
  public void setParam(BeautyRealConfig.TYPE paramTYPE, float paramFloat)
  {
    this.cameraBeautyParams.setParam(paramTYPE, paramFloat);
  }
  
  public void setParam4Pitu(int paramInt, float paramFloat)
  {
    this.cameraBeautyParams.setParam4Pitu(paramInt, paramFloat);
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.reshapeEyeNoseLipsFilter != null) {
      this.reshapeEyeNoseLipsFilter.setRenderMode(paramInt);
    }
    if (this.reshapeWholeFaceFilter != null) {
      this.reshapeWholeFaceFilter.setRenderMode(paramInt);
    }
    if (this.reshapeCombineFilter != null) {
      this.reshapeCombineFilter.setRenderMode(paramInt);
    }
    this.copyFilter.setRenderMode(paramInt);
    this.cropFilter.setRenderMode(paramInt);
    this.drawFilter.setRenderMode(paramInt);
  }
  
  public void updateAgeSexBeautyConfig(AIBeautyParamsJsonBean paramAIBeautyParamsJsonBean)
  {
    this.cameraBeautyParams.updateAgeSexBeautyConfig(paramAIBeautyParamsJsonBean);
  }
  
  public void updateAgeSexBeautyConfig(String paramString)
  {
    this.cameraBeautyParams.updateAgeSexBeautyConfig(paramString);
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if (paramObject.aiAttr != null) {
        this.faceAttr = ((PTFaceAttr)paramObject.aiAttr.getFaceAttr());
      }
    }
    while (!(paramObject instanceof PTFaceAttr)) {
      return;
    }
    this.faceAttr = ((PTFaceAttr)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.RemodelFilter
 * JD-Core Version:    0.7.0.1
 */