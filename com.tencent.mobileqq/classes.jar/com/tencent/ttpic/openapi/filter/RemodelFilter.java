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
    int[][] arrayOfInt = this.faceOutline;
    if ((arrayOfInt == null) || (arrayOfInt.length != paramList.size())) {
      this.faceOutline = ((int[][])Array.newInstance(Integer.TYPE, new int[] { paramList.size(), 2 }));
    }
    int i4 = 0;
    int m = 0;
    int j = -2147483648;
    int i1 = 2147483647;
    int i = -2147483648;
    for (int k = 2147483647; m < paramList.size(); k = i2)
    {
      n = i1;
      if (i1 > ((PointF)paramList.get(m)).x) {
        n = (int)((PointF)paramList.get(m)).x;
      }
      i2 = k;
      if (k > ((PointF)paramList.get(m)).y) {
        i2 = (int)((PointF)paramList.get(m)).y;
      }
      k = j;
      if (j < ((PointF)paramList.get(m)).x) {
        k = (int)((PointF)paramList.get(m)).x;
      }
      int i3 = i;
      if (i < ((PointF)paramList.get(m)).y) {
        i3 = (int)((PointF)paramList.get(m)).y;
      }
      m += 1;
      j = k;
      i1 = n;
      i = i3;
    }
    m = (j + i1) / 2;
    int n = (i + k) / 2;
    double d = Math.max(j - i1, i - k);
    Double.isNaN(d);
    j = (int)(d * 2.5D);
    k = j / 2;
    i1 = m - k;
    int i2 = n - k;
    i = 0;
    while (i < paramList.size())
    {
      this.faceOutline[i][0] = ((int)(((PointF)paramList.get(i)).x - i1));
      this.faceOutline[i][1] = ((int)(((PointF)paramList.get(i)).y - i2));
      i += 1;
    }
    paramList = new float[8];
    float f2 = i1;
    float f1 = paramInt1;
    float f3 = f2 / f1;
    paramList[0] = f3;
    f2 = i2;
    float f4 = paramInt2;
    f2 /= f4;
    paramList[1] = f2;
    paramList[2] = f3;
    f3 = (n + k) / f4;
    paramList[3] = f3;
    f1 = (m + k) / f1;
    paramList[4] = f1;
    paramList[5] = f3;
    paramList[6] = f1;
    paramList[7] = f2;
    this.cropFilter.setTexCords(paramList);
    paramInt1 = i4;
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
    int[][] arrayOfInt = this.faceOutline;
    if ((arrayOfInt == null) || (arrayOfInt.length != paramList.size())) {
      this.faceOutline = ((int[][])Array.newInstance(Integer.TYPE, new int[] { paramList.size(), 2 }));
    }
    int m = 0;
    int j = -2147483648;
    int i1 = 2147483647;
    int i = -2147483648;
    for (int k = 2147483647; m < paramList.size(); k = i2)
    {
      n = i1;
      if (i1 > ((PointF)paramList.get(m)).x) {
        n = (int)((PointF)paramList.get(m)).x;
      }
      i2 = k;
      if (k > ((PointF)paramList.get(m)).y) {
        i2 = (int)((PointF)paramList.get(m)).y;
      }
      k = j;
      if (j < ((PointF)paramList.get(m)).x) {
        k = (int)((PointF)paramList.get(m)).x;
      }
      int i3 = i;
      if (i < ((PointF)paramList.get(m)).y) {
        i3 = (int)((PointF)paramList.get(m)).y;
      }
      m += 1;
      j = k;
      i1 = n;
      i = i3;
    }
    m = (j + i1) / 2;
    int n = (i + k) / 2;
    j = (int)(Math.max(j - i1, i - k) * 2.5F);
    k = j / 2;
    i1 = m - k;
    int i2 = n - k;
    i = 0;
    while (i < paramList.size())
    {
      this.faceOutline[i][0] = ((int)(((PointF)paramList.get(i)).x - i1));
      this.faceOutline[i][1] = ((int)(((PointF)paramList.get(i)).y - i2));
      i += 1;
    }
    float f1 = j;
    this.reshapeCropWidth = f1;
    float f2 = i1;
    this.reshapeLeft = f2;
    float f3 = i2;
    this.reshapeTop = f3;
    paramList = this.cameraBeautyParams.param;
    paramList.clear();
    float f4 = paramInt1;
    float f5 = paramInt2;
    paramList.put("size", new float[] { f4, f5 });
    paramList.put("vectorMapSize", new float[] { f1, f1 });
    this.reshapeCombineFilter.updateSize(f2 / f4, (m + k) / f4, f3 / f5, (n + k) / f5);
    this.reshapeCombineFilter.setParam(paramList);
    innerInitFilter(this.faceOutline, paramArrayOfFloat, j, j);
  }
  
  private void innerInitFilter(int[][] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat16 = new float[2];
    arrayOfFloat16[0] = ((paramArrayOfInt[55][0] + paramArrayOfInt[63][0]) / 2.0F);
    arrayOfFloat16[1] = ((paramArrayOfInt[55][1] + paramArrayOfInt[63][1]) / 2.0F);
    float f25 = (paramArrayOfInt[23][0] + paramArrayOfInt[31][0]) / 2.0F;
    float f26 = (paramArrayOfInt[23][1] + paramArrayOfInt[31][1]) / 2.0F;
    float[] arrayOfFloat1 = new float[2];
    float f1 = getDistance(paramArrayOfInt[39], paramArrayOfInt[35]);
    float f3 = paramInt1;
    arrayOfFloat1[0] = (f1 / f3);
    f1 = getDistance(paramArrayOfInt[41], paramArrayOfInt[37]);
    float f4 = paramInt2;
    arrayOfFloat1[1] = (f1 / f4);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = (paramArrayOfInt[43][0] / f3);
    arrayOfFloat2[1] = (paramArrayOfInt[43][1] / f4);
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = (getDistance(paramArrayOfInt[45], paramArrayOfInt[49]) / f3);
    arrayOfFloat3[1] = (getDistance(paramArrayOfInt[51], paramArrayOfInt[47]) / f4);
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = (paramArrayOfInt[53][0] / f3);
    arrayOfFloat4[1] = (paramArrayOfInt[53][1] / f4);
    float[] arrayOfFloat5 = new float[2];
    arrayOfFloat5[0] = ((arrayOfFloat16[0] + paramArrayOfInt[59][0]) / 2.0F / f3);
    arrayOfFloat5[1] = ((arrayOfFloat16[1] + paramArrayOfInt[59][1]) / 2.0F / f4);
    float[] arrayOfFloat6 = new float[2];
    arrayOfFloat6[0] = (getDistance(paramArrayOfInt[61], paramArrayOfInt[57]) / f3);
    arrayOfFloat6[1] = (getDistance(arrayOfFloat16, new float[] { paramArrayOfInt[59][0], paramArrayOfInt[59][1] }) / f4);
    float f5 = paramArrayOfInt[64][0] / f3;
    float f6 = paramArrayOfInt[64][1] / f4;
    f1 = (paramArrayOfInt[56][0] + paramArrayOfInt[62][0]) / 2.0F;
    float f2 = (paramArrayOfInt[56][1] + paramArrayOfInt[62][1]) / 2.0F;
    float f7 = (getDistance(paramArrayOfInt[62], paramArrayOfInt[56]) + getDistance(paramArrayOfInt[61], paramArrayOfInt[57])) / 2.0F / f3;
    Object localObject = paramArrayOfInt[59];
    float f8 = getDistance(new float[] { f1, f2 }, (int[])localObject) / f4;
    float f9 = (paramArrayOfInt[61][0] + paramArrayOfInt[57][0]) / 2.0F / f3;
    float f10 = (paramArrayOfInt[61][1] + paramArrayOfInt[57][1]) / 2.0F / f4;
    f1 = (paramArrayOfInt[75][0] + paramArrayOfInt[79][0] + paramArrayOfInt[67][0] + paramArrayOfInt[71][0]) / 4.0F;
    f2 = (paramArrayOfInt[75][1] + paramArrayOfInt[79][1] + paramArrayOfInt[67][1] + paramArrayOfInt[71][1]) / 4.0F;
    localObject = new float[2];
    localObject[0] = (f1 / f3);
    localObject[1] = (f2 / f4);
    float[] arrayOfFloat7 = new float[2];
    arrayOfFloat7[0] = (getDistance(paramArrayOfInt[66], paramArrayOfInt[65]) / f3);
    arrayOfFloat7[1] = (getDistance(paramArrayOfInt[77], paramArrayOfInt[69]) / f4);
    float f11 = paramArrayOfInt[65][0] / f3;
    float f12 = paramArrayOfInt[65][1] / f4;
    float f13 = paramArrayOfInt[66][0] / f3;
    float f14 = paramArrayOfInt[66][1] / f4;
    float f15 = arrayOfFloat7[0] / 3.0F;
    float f16 = getDistance(paramArrayOfInt[2], paramArrayOfInt[8]) / f4;
    float f17 = (paramArrayOfInt[4][0] + paramArrayOfInt[3][0]) / 2.0F / f3;
    float f18 = (paramArrayOfInt[4][1] + paramArrayOfInt[3][1]) / 2.0F / f4;
    float f19 = (float)(Math.atan2(paramArrayOfInt[8][1] - paramArrayOfInt[1][1], paramArrayOfInt[8][0] - paramArrayOfInt[1][0]) + 1.570796326794897D);
    float f20 = arrayOfFloat7[0] / 3.0F;
    float f21 = getDistance(paramArrayOfInt[16], paramArrayOfInt[10]) / f4;
    float f22 = (paramArrayOfInt[15][0] + paramArrayOfInt[14][0]) / 2.0F / f3;
    float f23 = (paramArrayOfInt[15][1] + paramArrayOfInt[14][1]) / 2.0F / f4;
    float f24 = (float)(Math.atan2(paramArrayOfInt[17][1] - paramArrayOfInt[10][1], paramArrayOfInt[17][0] - paramArrayOfInt[10][0]) + 1.570796326794897D);
    f2 = 0.0F;
    f1 = 0.0F;
    paramInt1 = 19;
    while (paramInt1 <= 26)
    {
      f2 += paramArrayOfInt[paramInt1][0];
      f1 += paramArrayOfInt[paramInt1][1];
      paramInt1 += 1;
    }
    f2 /= 8.0F;
    f1 /= 8.0F;
    float[] arrayOfFloat8 = new float[2];
    arrayOfFloat8[0] = (f2 / f3);
    arrayOfFloat8[1] = (f1 / f4);
    float[] arrayOfFloat9 = new float[2];
    arrayOfFloat9[0] = (getDistance(paramArrayOfInt[19], paramArrayOfInt[23]) / f3);
    arrayOfFloat9[1] = (getDistance(paramArrayOfInt[21], paramArrayOfInt[25]) / f4);
    paramInt1 = 27;
    f2 = 0.0F;
    f1 = 0.0F;
    while (paramInt1 <= 34)
    {
      f2 += paramArrayOfInt[paramInt1][0];
      f1 += paramArrayOfInt[paramInt1][1];
      paramInt1 += 1;
    }
    f2 /= 8.0F;
    f1 /= 8.0F;
    float[] arrayOfFloat10 = new float[2];
    arrayOfFloat10[0] = (f2 / f3);
    arrayOfFloat10[1] = (f1 / f4);
    float[] arrayOfFloat11 = new float[2];
    arrayOfFloat11[0] = (getDistance(paramArrayOfInt[27], paramArrayOfInt[31]) / f3);
    arrayOfFloat11[1] = (getDistance(paramArrayOfInt[29], paramArrayOfInt[33]) / f4);
    f1 = getDistance(paramArrayOfInt[0], paramArrayOfInt[18]) / f3;
    f2 = getDistance(new float[] { paramArrayOfInt[9][0], paramArrayOfInt[9][1] }, new float[] { f25, f26 }) * 1.1F / f4;
    f25 = (paramArrayOfInt[1][0] + paramArrayOfInt[17][0]) / 2.0F / f3;
    f26 = (paramArrayOfInt[1][1] + paramArrayOfInt[17][1]) / 2.0F / f4;
    float[] arrayOfFloat12 = new float[2];
    arrayOfFloat12[0] = ((paramArrayOfInt[56][0] + paramArrayOfInt[62][0]) / 2.0F / f3);
    arrayOfFloat12[1] = ((paramArrayOfInt[56][1] + paramArrayOfInt[62][1]) / 2.0F / f4);
    float f27 = getDistance(paramArrayOfInt[2], paramArrayOfInt[57]) / f3;
    float f28 = getDistance(paramArrayOfInt[1], paramArrayOfInt[8]) / f4;
    float[] arrayOfFloat13 = new float[2];
    arrayOfFloat13[0] = ((paramArrayOfInt[4][0] + paramArrayOfInt[5][0]) / 2.0F / f3);
    arrayOfFloat13[1] = ((paramArrayOfInt[4][1] + paramArrayOfInt[5][1]) / 2.0F / f4);
    paramInt1 = 0;
    while (paramInt1 < arrayOfFloat13.length)
    {
      arrayOfFloat13[paramInt1] += (arrayOfFloat12[paramInt1] - arrayOfFloat13[paramInt1]) * 0.07F;
      paramInt1 += 1;
    }
    float f29 = (float)(Math.atan2(paramArrayOfInt[8][1] - paramArrayOfInt[2][1], paramArrayOfInt[8][0] - paramArrayOfInt[2][0]) + 1.570796326794897D);
    float f30 = getDistance(paramArrayOfInt[16], paramArrayOfInt[61]) / f3;
    float f31 = getDistance(paramArrayOfInt[17], paramArrayOfInt[10]) / f4;
    float[] arrayOfFloat14 = new float[2];
    arrayOfFloat14[0] = ((paramArrayOfInt[13][0] + paramArrayOfInt[14][0]) / 2.0F / f3);
    arrayOfFloat14[1] = ((paramArrayOfInt[13][1] + paramArrayOfInt[14][1]) / 2.0F / f4);
    paramInt1 = 0;
    while (paramInt1 < arrayOfFloat14.length)
    {
      arrayOfFloat14[paramInt1] += (arrayOfFloat12[paramInt1] - arrayOfFloat14[paramInt1]) * 0.07F;
      paramInt1 += 1;
    }
    float f32 = (float)(Math.atan2(paramArrayOfInt[16][1] - paramArrayOfInt[10][1], paramArrayOfInt[16][0] - paramArrayOfInt[10][0]) + 1.570796326794897D);
    float f33 = getDistance(paramArrayOfInt[0], paramArrayOfInt[35]) / f3;
    float f34 = getDistance(paramArrayOfInt[0], paramArrayOfInt[2]) / f4;
    float f35 = (paramArrayOfInt[0][0] + paramArrayOfInt[1][0]) / 2.0F / f3;
    float f36 = (paramArrayOfInt[0][1] + paramArrayOfInt[1][1]) / 2.0F / f4;
    float f37 = (float)(Math.atan2(paramArrayOfInt[2][1] - paramArrayOfInt[0][1], paramArrayOfInt[2][0] - paramArrayOfInt[0][0]) + 1.570796326794897D);
    float f38 = getDistance(paramArrayOfInt[18], paramArrayOfInt[45]) / f3;
    float f39 = getDistance(paramArrayOfInt[18], paramArrayOfInt[16]) / f4;
    float f40 = (paramArrayOfInt[18][0] + paramArrayOfInt[17][0]) / 2.0F / f3;
    float f41 = (paramArrayOfInt[18][1] + paramArrayOfInt[17][1]) / 2.0F / f4;
    float f42 = (float)(Math.atan2(paramArrayOfInt[18][1] - paramArrayOfInt[16][1], paramArrayOfInt[18][0] - paramArrayOfInt[16][0]) + 1.570796326794897D);
    float f43 = (paramArrayOfInt[4][0] * 0.5F + paramArrayOfInt[14][0] * 0.5F) / f3;
    float f44 = (paramArrayOfInt[4][1] * 0.6F + paramArrayOfInt[14][1] * 0.4F) / f4;
    float f45 = getDistance(paramArrayOfInt[15], paramArrayOfInt[3]) / f3;
    float f46 = getDistance(paramArrayOfInt[9], paramArrayOfInt[59]) / f4;
    float[] arrayOfFloat17 = new float[2];
    arrayOfFloat17[0] = ((paramArrayOfInt[3][0] + paramArrayOfInt[15][0]) / 2.0F);
    arrayOfFloat17[1] = ((paramArrayOfInt[3][1] + paramArrayOfInt[15][1]) / 2.0F);
    float[] arrayOfFloat18 = new float[2];
    arrayOfFloat18[0] = ((paramArrayOfInt[0][0] + paramArrayOfInt[18][0]) / 2.0F);
    arrayOfFloat18[1] = ((paramArrayOfInt[0][1] + paramArrayOfInt[18][1]) / 2.0F);
    float[] arrayOfFloat15 = new float[2];
    arrayOfFloat15[0] = (getDistance(paramArrayOfInt[0], paramArrayOfInt[18]) / f3);
    arrayOfFloat15[1] = (getDistance(arrayOfFloat17, arrayOfFloat18) / f4);
    float f47 = arrayOfFloat16[0];
    f47 = arrayOfFloat16[0];
    f47 = paramArrayOfInt[9][0];
    f47 = arrayOfFloat16[1];
    f47 = arrayOfFloat16[1];
    f47 = paramArrayOfInt[9][1];
    arrayOfFloat16 = new float[3];
    arrayOfFloat16[0] = paramArrayOfFloat[0];
    arrayOfFloat16[1] = paramArrayOfFloat[1];
    arrayOfFloat16[2] = paramArrayOfFloat[2];
    arrayOfFloat16[2] = ((float)Math.atan2(paramArrayOfInt[53][1] - paramArrayOfInt[43][1], paramArrayOfInt[53][0] - paramArrayOfInt[43][0]));
    double d = arrayOfFloat16[1];
    Double.isNaN(d);
    f47 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d * 1.0D));
    float f48 = (float)Math.cos(f47);
    paramArrayOfFloat = new float[2];
    paramArrayOfFloat[0] = (paramArrayOfInt[0][0] + (arrayOfFloat18[0] - arrayOfFloat17[0]) * 1.5F);
    paramArrayOfFloat[1] = (paramArrayOfInt[0][1] + (arrayOfFloat18[1] - arrayOfFloat17[1]) * 1.5F);
    float[] arrayOfFloat19 = new float[2];
    arrayOfFloat19[0] = (paramArrayOfInt[18][0] + (arrayOfFloat18[0] - arrayOfFloat17[0]) * 1.5F);
    arrayOfFloat19[1] = (paramArrayOfInt[18][1] + (arrayOfFloat18[1] - arrayOfFloat17[1]) * 1.5F);
    if (f47 < 0.0F)
    {
      paramArrayOfInt = new float[] { paramArrayOfFloat[0] + (arrayOfFloat19[0] - paramArrayOfFloat[0]) / f48 / 2.0F, paramArrayOfFloat[1] + (arrayOfFloat19[1] - paramArrayOfFloat[1]) / f48 / 2.0F };
    }
    else
    {
      paramArrayOfInt = new float[2];
      arrayOfFloat19[0] += (paramArrayOfFloat[0] - arrayOfFloat19[0]) / f48 / 2.0F;
      arrayOfFloat19[1] += (paramArrayOfFloat[1] - arrayOfFloat19[1]) / f48 / 2.0F;
    }
    paramArrayOfInt[0] /= f3;
    paramArrayOfInt[1] /= f4;
    arrayOfFloat15[0] /= f48;
    paramArrayOfFloat = this.cameraBeautyParams.param;
    paramArrayOfFloat.clear();
    paramArrayOfFloat.put("angles", arrayOfFloat16);
    paramArrayOfFloat.put("size", new float[] { f3, f4 });
    paramArrayOfFloat.put("leftEyePlainSize", arrayOfFloat1);
    paramArrayOfFloat.put("leftEyeCenter", arrayOfFloat2);
    paramArrayOfFloat.put("rightEyePlainSize", arrayOfFloat3);
    paramArrayOfFloat.put("rightEyeCenter", arrayOfFloat4);
    paramArrayOfFloat.put("nose3DCenter", arrayOfFloat5);
    paramArrayOfFloat.put("nosePlainSize", arrayOfFloat6);
    paramArrayOfFloat.put("noseTipCenter", new float[] { f5, f6 });
    paramArrayOfFloat.put("noseTipPlaneSize", new float[] { f7, f8 });
    paramArrayOfFloat.put("noseBottomCenter", new float[] { f9, f10 });
    paramArrayOfFloat.put("lipsCenter", localObject);
    paramArrayOfFloat.put("lipsPlainSize", arrayOfFloat7);
    paramArrayOfFloat.put("leftEyebrowCenter", arrayOfFloat8);
    paramArrayOfFloat.put("leftEyebrowPlainSize", arrayOfFloat9);
    paramArrayOfFloat.put("rightEyebrowCenter", arrayOfFloat10);
    paramArrayOfFloat.put("rightEyebrowPlainSize", arrayOfFloat11);
    paramArrayOfFloat.put("lipsProtectSizeLeft", new float[] { f15, f16 });
    paramArrayOfFloat.put("lipsProtectCenterLeft", new float[] { f17, f18 });
    paramArrayOfFloat.put("lipsProtectAngleLeft", Float.valueOf(f19));
    paramArrayOfFloat.put("lipsProtectSizeRight", new float[] { f20, f21 });
    paramArrayOfFloat.put("lipsProtectCenterRight", new float[] { f22, f23 });
    paramArrayOfFloat.put("lipsProtectAngleRight", Float.valueOf(f24));
    this.reshapeEyeNoseLipsFilter.setParam(paramArrayOfFloat);
    paramArrayOfFloat.clear();
    paramArrayOfFloat.put("angles", arrayOfFloat16);
    paramArrayOfFloat.put("size", new float[] { f3, f4 });
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
    paramArrayOfFloat.put("lipsLeftEdge", new float[] { f11, f12 });
    paramArrayOfFloat.put("lipsRightEdge", new float[] { f13, f14 });
    paramArrayOfFloat.put("facePlainSize", new float[] { f1, f2 });
    paramArrayOfFloat.put("faceCenter", new float[] { f25, f26 });
    paramArrayOfFloat.put("facePlainSizeLeft2", new float[] { f27, f28 });
    paramArrayOfFloat.put("faceCenterLeft2", arrayOfFloat13);
    paramArrayOfFloat.put("leftAngle2", Float.valueOf(f29));
    paramArrayOfFloat.put("facePlainSizeRight2", new float[] { f30, f31 });
    paramArrayOfFloat.put("faceCenterRight2", arrayOfFloat14);
    paramArrayOfFloat.put("rightAngle2", Float.valueOf(f32));
    paramArrayOfFloat.put("faceMoveCenter2", arrayOfFloat12);
    paramArrayOfFloat.put("facePlainSizeUpLeft2", new float[] { f33, f34 });
    paramArrayOfFloat.put("faceCenterUpLeft2", new float[] { f35, f36 });
    paramArrayOfFloat.put("upLeftAngle2", Float.valueOf(f37));
    paramArrayOfFloat.put("facePlainSizeUpRight2", new float[] { f38, f39 });
    paramArrayOfFloat.put("faceCenterUpRight2", new float[] { f40, f41 });
    paramArrayOfFloat.put("upRightAngle2", Float.valueOf(f42));
    paramArrayOfFloat.put("jawCenterOfGravity", new float[] { f43, f44 });
    paramArrayOfFloat.put("jawSize", new float[] { f45, f46 });
    paramArrayOfFloat.put("foreheadCenter", paramArrayOfInt);
    paramArrayOfFloat.put("foreheadSize", arrayOfFloat15);
    paramArrayOfInt = this.reshapeWholeFaceFilter;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.setParam(paramArrayOfFloat);
    }
  }
  
  private boolean isFilterValid(ReshapeType paramReshapeType)
  {
    int i = RemodelFilter.1.$SwitchMap$com$tencent$ttpic$openapi$filter$ReshapeType[paramReshapeType.ordinal()];
    boolean bool3 = false;
    boolean bool2 = false;
    if (i != 1)
    {
      bool1 = bool2;
      if (this.reshapeEyeNoseLipsFilter.isValid())
      {
        bool1 = bool2;
        if (this.reshapeWholeFaceFilter.isValid())
        {
          bool1 = bool2;
          if (this.reshapeCombineFilter.isValid()) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    boolean bool1 = bool3;
    if (this.reshapeEyeNoseLipsFilter.isValid())
    {
      bool1 = bool3;
      if (this.reshapeWholeFaceFilter.isValid()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private Frame processReshape(Frame paramFrame, List<List<PointF>> paramList, List<FaceStatus> paramList1, List<float[]> paramList2, double paramDouble, boolean paramBoolean)
  {
    if (!isFilterValid(this.useMeshType)) {
      return paramFrame;
    }
    int i = 0;
    while (i < paramList.size())
    {
      if ((paramList1 != null) && (paramList1.size() > i))
      {
        j = ((FaceStatus)paramList1.get(i)).gender;
        boolean bool = true;
        if (j != 1) {
          bool = false;
        }
        this.isFemale = bool;
        if (BeautyAIParam.needAIBeautyValid()) {
          j = ((FaceStatus)paramList1.get(i)).age;
        } else {
          j = 0;
        }
        this.age = j;
      }
      this.cameraBeautyParams.setAgeGender(this.isFemale, this.age, paramBoolean);
      this.cameraBeautyParams.updateReshapeParams();
      Object localObject1 = this.cameraBeautyParams.param;
      this.reshapeEyeNoseLipsFilter.setParam((Map)localObject1);
      this.reshapeWholeFaceFilter.setParam((Map)localObject1);
      localObject1 = FaceDetectUtil.facePointf83to90(VideoMaterial.copyList((List)paramList.get(i)));
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PointF localPointF = (PointF)((Iterator)localObject2).next();
        double d = localPointF.x;
        Double.isNaN(d);
        localPointF.x = ((float)(d / paramDouble));
        d = localPointF.y;
        Double.isNaN(d);
        localPointF.y = ((float)(d / paramDouble));
      }
      initFilter((List)localObject1, (float[])paramList2.get(i), paramFrame.width, paramFrame.height);
      localObject1 = this.cropFilter;
      int j = paramFrame.getTextureId();
      int k = this.mCropWidth;
      ((BaseFilter)localObject1).RenderProcess(j, k, k, -1, 0.0D, this.cropFrame);
      localObject1 = this.cropFrame;
      localObject2 = this.reshapeEyeNoseLipsFilter;
      j = ((Frame)localObject1).getTextureId();
      k = this.mCropWidth;
      ((ReshapeEyeNoseLips)localObject2).RenderProcess(j, k, k, -1, 0.0D, this.eyesFrame);
      localObject1 = this.eyesFrame;
      localObject2 = this.reshapeWholeFaceFilter;
      j = ((Frame)localObject1).getTextureId();
      k = this.mCropWidth;
      ((ReshapeWholeFace)localObject2).RenderProcess(j, k, k, -1, 0.0D, this.noseFrame);
      localObject1 = this.noseFrame;
      this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.reshapeCombineFrame);
      this.drawFilter.RenderProcess(((Frame)localObject1).getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.reshapeCombineFrame);
      paramFrame.unlock();
      paramFrame = this.reshapeCombineFrame;
      i += 1;
    }
    return paramFrame;
  }
  
  private Frame processReshape4(Frame paramFrame, List<List<PointF>> paramList, List<FaceStatus> paramList1, List<float[]> paramList2, double paramDouble, boolean paramBoolean)
  {
    if (!isFilterValid(this.useMeshType)) {
      return paramFrame;
    }
    if (!this.cameraBeautyParams.needRender()) {
      return paramFrame;
    }
    Object localObject1 = FrameBufferCache.getInstance().get(128, 128);
    int i = 0;
    Object localObject2 = paramFrame;
    paramFrame = (Frame)localObject1;
    while (i < paramList.size())
    {
      if ((paramList1 != null) && (paramList1.size() > i))
      {
        int j = ((FaceStatus)paramList1.get(i)).gender;
        boolean bool = true;
        if (j != 1) {
          bool = false;
        }
        this.isFemale = bool;
        this.age = ((FaceStatus)paramList1.get(i)).age;
      }
      this.cameraBeautyParams.setAgeGender(this.isFemale, this.age, paramBoolean);
      this.cameraBeautyParams.updateReshapeParams4();
      Map localMap = this.cameraBeautyParams.param;
      this.reshapeEyeNoseLipsFilter.setParam(localMap);
      this.reshapeWholeFaceFilter.setParam(localMap);
      this.facePoints = VideoMaterial.copyList((List)paramList.get(i));
      localObject1 = FaceDetectUtil.facePointf83to90(this.facePoints);
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        PointF localPointF = (PointF)localIterator.next();
        double d = localPointF.x;
        Double.isNaN(d);
        localPointF.x = ((float)(d / paramDouble));
        d = localPointF.y;
        Double.isNaN(d);
        localPointF.y = ((float)(d / paramDouble));
      }
      initFilter4((List)localObject1, (float[])paramList2.get(i), ((Frame)localObject2).width, ((Frame)localObject2).height);
      FrameUtil.clearFrame(paramFrame, 0.4980392F, 0.4980392F, 0.5019608F, 0.5019608F, 128, 128);
      if (this.cameraBeautyParams.needRenderEyeNoseLips())
      {
        localObject1 = this.reshapeEyeNoseLipsFilter.RenderProcess(paramFrame.getTextureId(), 128, 128);
        paramFrame.unlock();
      }
      else
      {
        localObject1 = paramFrame;
      }
      paramFrame = (Frame)localObject1;
      if (this.cameraBeautyParams.needRenderWholeFace())
      {
        paramFrame = this.reshapeWholeFaceFilter.RenderProcess(((Frame)localObject1).getTextureId(), 128, 128);
        ((Frame)localObject1).unlock();
      }
      localMap.clear();
      localMap.put("inputImageTexture2", Integer.valueOf(paramFrame.getTextureId()));
      localObject1 = this.copyFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height);
      this.reshapeCombineFilter.setParam(localMap);
      this.reshapeCombineFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height, -1, 0.0D, (Frame)localObject1);
      ((Frame)localObject2).unlock();
      if (this.needReCaculateFace)
      {
        localObject2 = this.faceAttr;
        if ((localObject2 != null) && (((PTFaceAttr)localObject2).getTransformFacePoints().size() > i))
        {
          localObject2 = this.faceAttr;
          ((PTFaceAttr)localObject2).setTransformFacePoints(i, calFacePointAfterTransform(paramFrame, (List)((PTFaceAttr)localObject2).getTransformFacePoints().get(i), (float)paramDouble));
        }
      }
      i += 1;
      localObject2 = localObject1;
    }
    paramFrame.unlock();
    return localObject2;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    PTFaceAttr localPTFaceAttr = this.faceAttr;
    if (localPTFaceAttr == null) {
      return paramFrame;
    }
    return process(paramFrame, localPTFaceAttr.getAllFacePoints(), this.faceAttr.getFaceStatusList(), this.faceAttr.getAllFaceAngles(), this.faceAttr.getFaceDetectScale(), false);
  }
  
  public List<PointF> calFacePointAfterTransform(Frame paramFrame, List<PointF> paramList, float paramFloat)
  {
    Object localObject2 = this;
    int k = paramFrame.width;
    int i2 = paramFrame.height;
    float f1 = ((RemodelFilter)localObject2).reshapeCropWidth;
    float f3 = f1 / (k - 1);
    float f4 = f1 / (i2 - 1);
    Object localObject1 = new byte[k * i2 * 4];
    GlUtil.saveTextureToRgbaBuffer(paramFrame.getTextureId(), 0, 0, k, i2, (byte[])localObject1, paramFrame.getFBO());
    float[][][] arrayOfFloat = (float[][][])Array.newInstance(Float.TYPE, new int[] { i2, k, 2 });
    int i = 0;
    while (i < i2)
    {
      j = 0;
      while (j < k)
      {
        arrayOfFloat[i][j][0] = (((RemodelFilter)localObject2).getPixel((byte[])localObject1, i, j, k).x * ((RemodelFilter)localObject2).reshapeCropWidth + j * f3);
        arrayOfFloat[i][j][1] = (((RemodelFilter)localObject2).getPixel((byte[])localObject1, i, j, k).y * ((RemodelFilter)localObject2).reshapeCropWidth + i * f4);
        j += 1;
      }
      i += 1;
    }
    localObject1 = new ArrayList();
    int j = 0;
    i = k;
    k = j;
    paramFrame = (Frame)localObject2;
    for (;;)
    {
      localObject2 = paramList;
      if (k >= paramList.size()) {
        break;
      }
      float f10 = ((PointF)((List)localObject2).get(k)).x / paramFloat - paramFrame.reshapeLeft;
      float f9 = ((PointF)((List)localObject2).get(k)).y / paramFloat - paramFrame.reshapeTop;
      int i5 = (int)(f9 / f4);
      j = (int)(f10 / f3);
      int i9 = Math.max(Math.max(i5, i2 - i5), Math.max(j, i - j));
      int i10 = 0;
      int m = -1;
      int n = -1;
      int i1 = 0;
      while (i10 < i9)
      {
        int i3 = i5 - i10;
        int i6 = i3;
        i4 = i2;
        i2 = i5;
        i5 = k;
        for (;;)
        {
          int i12 = i2 + i10;
          if (i6 > i12) {
            break;
          }
          int i11;
          int i8;
          if ((i6 >= 0) && (i6 < i4))
          {
            i11 = j - i10;
            int i7 = i11;
            k = i3;
            i3 = i;
            for (;;)
            {
              i = j + i10;
              if (i7 > i) {
                break;
              }
              if ((i7 >= 0) && (i7 < i3) && ((i6 <= k) || (i6 >= i12) || (i7 <= i11) || (i7 >= i)))
              {
                localObject2 = new float[4][];
                localObject2[0] = { arrayOfFloat[i6][i7][0], arrayOfFloat[i6][i7][1] };
                Object localObject3 = arrayOfFloat[i6];
                i = i7 + 1;
                localObject2[1] = { localObject3[i][0], arrayOfFloat[i6][i][1] };
                i8 = i6 + 1;
                localObject2[2] = { arrayOfFloat[i8][i][0], arrayOfFloat[i8][i][1] };
                localObject2[3] = { arrayOfFloat[i8][i7][0], arrayOfFloat[i8][i7][1] };
                i8 = 0;
                int i13 = 0;
                i = k;
                while (i8 < 4)
                {
                  localObject3 = new float[2];
                  localObject3[0] = localObject2[i8][0];
                  localObject3[1] = localObject2[i8][1];
                  float[] arrayOfFloat1 = new float[2];
                  i8 += 1;
                  k = i8 % 4;
                  arrayOfFloat1[0] = localObject2[k][0];
                  arrayOfFloat1[1] = localObject2[k][1];
                  if (localObject3[1] == arrayOfFloat1[1])
                  {
                    k = i13;
                  }
                  else if ((f9 < localObject3[1]) && (f9 < arrayOfFloat1[1]))
                  {
                    k = i13;
                  }
                  else if ((f9 >= localObject3[1]) && (f9 >= arrayOfFloat1[1]))
                  {
                    k = i13;
                  }
                  else
                  {
                    k = i13;
                    if ((f9 - localObject3[1]) * (arrayOfFloat1[0] - localObject3[0]) / (arrayOfFloat1[1] - localObject3[1]) + localObject3[0] > f10) {
                      k = i13 + 1;
                    }
                  }
                  i13 = k;
                }
                i8 = i;
                k = j;
                if (i13 % 2 == 1)
                {
                  m = i6;
                  n = i7;
                  i1 = 1;
                  k = i;
                  i = j;
                  break label923;
                }
              }
              else
              {
                i8 = k;
                k = j;
              }
              i7 += 1;
              j = k;
              k = i8;
            }
            i = j;
            label923:
            i7 = i3;
            i12 = m;
            i11 = n;
            i8 = i1;
            i3 = i7;
            j = i;
            if (i1 != 0)
            {
              j = i7;
              break label1020;
            }
          }
          else
          {
            k = i3;
            i3 = i;
            i8 = i1;
            i11 = n;
            i12 = m;
          }
          i6 += 1;
          i = i3;
          i3 = k;
          m = i12;
          n = i11;
          i1 = i8;
        }
        k = i;
        i = j;
        j = k;
        label1020:
        if (i1 != 0) {
          break label1077;
        }
        i10 += 1;
        i3 = i2;
        i2 = i4;
        k = i5;
        i4 = j;
        j = i;
        i5 = i3;
        i = i4;
      }
      j = i;
      i5 = k;
      int i4 = i2;
      label1077:
      if ((m != -1) && (n != -1))
      {
        paramFrame = new float[4];
        tmp1094_1093 = paramFrame;
        tmp1094_1093[0] = 0.0F;
        tmp1098_1094 = tmp1094_1093;
        tmp1098_1094[1] = 0.0F;
        tmp1102_1098 = tmp1098_1094;
        tmp1102_1098[2] = 0.0F;
        tmp1106_1102 = tmp1102_1098;
        tmp1106_1102[3] = 0.0F;
        tmp1106_1102;
        localObject2 = arrayOfFloat[m];
        k = n + 1;
        float f11 = localObject2[k][0];
        float f12 = arrayOfFloat[m][k][1];
        i1 = m + 1;
        float f13 = arrayOfFloat[i1][n][0];
        float f14 = arrayOfFloat[i1][n][1];
        float f2 = arrayOfFloat[i1][k][0];
        f1 = arrayOfFloat[i1][k][1];
        float f5 = f13 - f10;
        float f6 = f12 - f9;
        float f7 = f14 - f9;
        float f8 = f11 - f10;
        if (f5 * f6 - f7 * f8 <= 0.0F) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          f2 = arrayOfFloat[m][n][0];
          f1 = arrayOfFloat[m][n][1];
        }
        f11 = Math.abs((f13 - f11) * (f1 - f12) - (f14 - f12) * (f2 - f11));
        if (f11 > 1.0E-007D)
        {
          f2 -= f10;
          f1 -= f9;
          paramFrame[1] = (Math.abs(f5 * f1 - f7 * f2) / f11);
          paramFrame[2] = (Math.abs(f8 * f1 - f6 * f2) / f11);
          if (i != 0) {
            paramFrame[0] = (1.0F - paramFrame[1] - paramFrame[2]);
          } else {
            paramFrame[3] = (1.0F - paramFrame[1] - paramFrame[2]);
          }
        }
        f1 = n * f3;
        f2 = m * f4;
        f5 = k * f3;
        f6 = i1 * f4;
        f7 = paramFrame[0];
        f8 = paramFrame[1];
        f9 = paramFrame[2];
        f10 = paramFrame[3];
        f11 = paramFrame[0];
        f12 = paramFrame[1];
        f13 = paramFrame[2];
        f14 = paramFrame[3];
        paramFrame = this;
        ((List)localObject1).add(new PointF((f7 * f1 + f8 * f5 + f1 * f9 + f5 * f10 + paramFrame.reshapeLeft) * paramFloat, (f11 * f2 + f2 * f12 + f13 * f6 + f6 * f14 + paramFrame.reshapeTop) * paramFloat));
      }
      k = i5 + 1;
      i2 = i4;
      i = j;
    }
    return localObject1;
  }
  
  public void clear()
  {
    Object localObject = this.reshapeCombineFilter;
    if (localObject != null) {
      ((ReshapeCombineFilter)localObject).clearGLSLSelf();
    }
    localObject = this.reshapeEyeNoseLipsFilter;
    if (localObject != null) {
      ((ReshapeEyeNoseLips)localObject).clearGLSLSelf();
    }
    localObject = this.reshapeWholeFaceFilter;
    if (localObject != null) {
      ((ReshapeWholeFace)localObject).clearGLSLSelf();
    }
    localObject = this.copyFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSLSelf();
    }
    localObject = this.cropFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSLSelf();
    }
    localObject = this.drawFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSLSelf();
    }
    localObject = this.eyesFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
    localObject = this.noseFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
    localObject = this.reshapeCombineFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
    localObject = this.cropFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
    localObject = this.copyFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
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
    double d1 = paramInt1;
    Double.isNaN(d1);
    d1 = d1 * 1.0D / 127.5D;
    double d2 = paramInt3;
    Double.isNaN(d2);
    float f = (float)(d1 + d2 * 1.0D / 255.0D / 127.5D - 1.0D);
    d1 = paramInt2;
    Double.isNaN(d1);
    d1 = d1 * 1.0D / 127.5D;
    d2 = i;
    Double.isNaN(d2);
    return new PointF(f, (float)(d1 + d2 * 1.0D / 255.0D / 127.5D - 1.0D));
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
    else
    {
      this.useMeshType = ReshapeType.NORMAL;
    }
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
    Object localObject = this.reshapeEyeNoseLipsFilter;
    if (localObject != null) {
      ((ReshapeEyeNoseLips)localObject).setRenderMode(paramInt);
    }
    localObject = this.reshapeWholeFaceFilter;
    if (localObject != null) {
      ((ReshapeWholeFace)localObject).setRenderMode(paramInt);
    }
    localObject = this.reshapeCombineFilter;
    if (localObject != null) {
      ((ReshapeCombineFilter)localObject).setRenderMode(paramInt);
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
    else if ((paramObject instanceof PTFaceAttr))
    {
      this.faceAttr = ((PTFaceAttr)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.RemodelFilter
 * JD-Core Version:    0.7.0.1
 */