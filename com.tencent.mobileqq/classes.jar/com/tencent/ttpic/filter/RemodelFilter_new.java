package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.ReshapeType;
import com.tencent.ttpic.openapi.model.CameraBeautyParams;
import com.tencent.ttpic.openapi.model.DistortParam;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.util.List<Landroid.graphics.PointF;>;>;
import java.util.Map;

public class RemodelFilter_new
{
  private static final String PERF_LOG = "[showPreview]";
  private String[] GPU_LIST = { "Mali", "PowerVR Rogue G6200" };
  private CameraBeautyParams cameraBeautyParams = new CameraBeautyParams();
  private BaseFilter copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame copyFrame = new Frame();
  private BaseFilter cropFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame cropFrame = new Frame();
  private BaseFilter drawFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame eyesFrame = new Frame();
  private int[][] faceOutline = (int[][])null;
  private List<PointF> facePoints = new ArrayList();
  private BeautyTransformList_new mBeautyTransformList = null;
  private byte[] mData;
  private Frame noseFrame = new Frame();
  private float[] posV1 = new float[40];
  private float[] posV2 = new float[72];
  private ReshapeCombineFilter_new reshapeCombineFilter_new;
  private Frame reshapeCombineFrame = new Frame();
  private ReshapeEyeNoseLips_new reshapeEyeNoseLipsFilter_new;
  private ReshapeWholeFace_new reshapeWholeFaceFilter_new;
  private BaseFilter transformCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private ReshapeType useMeshType;
  
  private void _initFilter(int[][] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat39 = new float[2];
    arrayOfFloat39[0] = ((paramArrayOfInt[55][0] + paramArrayOfInt[63][0]) / 2.0F);
    arrayOfFloat39[1] = ((paramArrayOfInt[55][1] + paramArrayOfInt[63][1]) / 2.0F);
    float f5 = (paramArrayOfInt[23][0] + paramArrayOfInt[31][0]) / 2.0F;
    float f6 = (paramArrayOfInt[23][1] + paramArrayOfInt[31][1]) / 2.0F;
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
    arrayOfFloat5[0] = ((arrayOfFloat39[0] + paramArrayOfInt[59][0]) / 2.0F / paramInt1);
    arrayOfFloat5[1] = ((arrayOfFloat39[1] + paramArrayOfInt[59][1]) / 2.0F / paramInt2);
    float[] arrayOfFloat6 = new float[2];
    arrayOfFloat6[0] = (getDistance(paramArrayOfInt[61], paramArrayOfInt[57]) / paramInt1);
    arrayOfFloat6[1] = (getDistance(arrayOfFloat39, new float[] { paramArrayOfInt[59][0], paramArrayOfInt[59][1] }) / paramInt2);
    float[] arrayOfFloat7 = new float[2];
    arrayOfFloat7[0] = (paramArrayOfInt[64][0] / paramInt1);
    arrayOfFloat7[1] = (paramArrayOfInt[64][1] / paramInt2);
    float f1 = (paramArrayOfInt[56][0] + paramArrayOfInt[62][0]) / 2.0F;
    float f2 = (paramArrayOfInt[56][1] + paramArrayOfInt[62][1]) / 2.0F;
    float f3 = getDistance(paramArrayOfInt[62], paramArrayOfInt[56]);
    float f4 = getDistance(paramArrayOfInt[61], paramArrayOfInt[57]);
    float[] arrayOfFloat8 = new float[2];
    arrayOfFloat8[0] = ((f3 + f4) / 2.0F / paramInt1);
    Object localObject = paramArrayOfInt[59];
    arrayOfFloat8[1] = (getDistance(new float[] { f1, f2 }, (int[])localObject) / paramInt2);
    localObject = new float[2];
    localObject[0] = ((paramArrayOfInt[61][0] + paramArrayOfInt[57][0]) / 2.0F / paramInt1);
    localObject[1] = ((paramArrayOfInt[61][1] + paramArrayOfInt[57][1]) / 2.0F / paramInt2);
    f1 = (paramArrayOfInt[75][0] + paramArrayOfInt[79][0] + paramArrayOfInt[67][0] + paramArrayOfInt[71][0]) / 4.0F;
    f2 = (paramArrayOfInt[75][1] + paramArrayOfInt[79][1] + paramArrayOfInt[67][1] + paramArrayOfInt[71][1]) / 4.0F;
    float[] arrayOfFloat9 = new float[2];
    arrayOfFloat9[0] = (f1 / paramInt1);
    arrayOfFloat9[1] = (f2 / paramInt2);
    float[] arrayOfFloat10 = new float[2];
    arrayOfFloat10[0] = (getDistance(paramArrayOfInt[66], paramArrayOfInt[65]) / paramInt1);
    arrayOfFloat10[1] = (getDistance(paramArrayOfInt[77], paramArrayOfInt[69]) / paramInt2);
    float[] arrayOfFloat11 = new float[2];
    arrayOfFloat11[0] = (paramArrayOfInt[65][0] / paramInt1);
    arrayOfFloat11[1] = (paramArrayOfInt[65][1] / paramInt2);
    float[] arrayOfFloat12 = new float[2];
    arrayOfFloat12[0] = (paramArrayOfInt[66][0] / paramInt1);
    arrayOfFloat12[1] = (paramArrayOfInt[66][1] / paramInt2);
    float[] arrayOfFloat13 = new float[2];
    arrayOfFloat10[0] /= 3.0F;
    arrayOfFloat13[1] = (getDistance(paramArrayOfInt[2], paramArrayOfInt[8]) / paramInt2);
    float[] arrayOfFloat14 = new float[2];
    arrayOfFloat14[0] = ((paramArrayOfInt[4][0] + paramArrayOfInt[5][0]) / 2.0F / paramInt1);
    arrayOfFloat14[1] = ((paramArrayOfInt[4][1] + paramArrayOfInt[5][1]) / 2.0F / paramInt2);
    f3 = (float)(Math.atan2(paramArrayOfInt[8][1] - paramArrayOfInt[1][1], paramArrayOfInt[8][0] - paramArrayOfInt[1][0]) + 1.570796326794897D);
    float[] arrayOfFloat15 = new float[2];
    arrayOfFloat10[0] /= 3.0F;
    arrayOfFloat15[1] = (getDistance(paramArrayOfInt[16], paramArrayOfInt[10]) / paramInt2);
    float[] arrayOfFloat16 = new float[2];
    arrayOfFloat16[0] = ((paramArrayOfInt[13][0] + paramArrayOfInt[14][0]) / 2.0F / paramInt1);
    arrayOfFloat16[1] = ((paramArrayOfInt[13][1] + paramArrayOfInt[14][1]) / 2.0F / paramInt2);
    f4 = (float)(Math.atan2(paramArrayOfInt[17][1] - paramArrayOfInt[10][1], paramArrayOfInt[17][0] - paramArrayOfInt[10][0]) + 1.570796326794897D);
    float[] arrayOfFloat17 = new float[2];
    arrayOfFloat17[0] = f1;
    arrayOfFloat17[1] = f2;
    f1 = getDistance(arrayOfFloat17, paramArrayOfInt[9]);
    f2 = getDistance(arrayOfFloat17, paramArrayOfInt[59]);
    f1 = (float)Math.min(f1 * 0.9D, f2) / paramInt2;
    f2 = getDistance(arrayOfFloat17, paramArrayOfInt[4]);
    float f7 = getDistance(arrayOfFloat17, paramArrayOfInt[5]);
    float f8 = getDistance(arrayOfFloat17, paramArrayOfInt[13]);
    float f9 = getDistance(arrayOfFloat17, paramArrayOfInt[14]);
    f2 = Math.min(Math.min(f2, f7), Math.min(f8, f9)) / paramInt1;
    arrayOfFloat10[0] = Math.min(arrayOfFloat10[0], Math.max(arrayOfFloat10[0] * 0.75F, f2));
    arrayOfFloat10[1] = Math.min(arrayOfFloat10[1], f1);
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
    arrayOfFloat17 = new float[2];
    arrayOfFloat17[0] = (f2 / paramInt1);
    arrayOfFloat17[1] = (f1 / paramInt2);
    float[] arrayOfFloat18 = new float[2];
    arrayOfFloat18[0] = (getDistance(paramArrayOfInt[19], paramArrayOfInt[23]) / paramInt1);
    arrayOfFloat18[1] = (getDistance(paramArrayOfInt[21], paramArrayOfInt[25]) / paramInt2);
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
    float[] arrayOfFloat19 = new float[2];
    arrayOfFloat19[0] = (f2 / paramInt1);
    arrayOfFloat19[1] = (f1 / paramInt2);
    float[] arrayOfFloat20 = new float[2];
    arrayOfFloat20[0] = (getDistance(paramArrayOfInt[27], paramArrayOfInt[31]) / paramInt1);
    arrayOfFloat20[1] = (getDistance(paramArrayOfInt[29], paramArrayOfInt[33]) / paramInt2);
    float[] arrayOfFloat21 = new float[2];
    arrayOfFloat21[0] = (getDistance(paramArrayOfInt[0], paramArrayOfInt[18]) / paramInt1);
    arrayOfFloat21[1] = (getDistance(new float[] { paramArrayOfInt[9][0], paramArrayOfInt[9][1] }, new float[] { f5, f6 }) * 1.1F / paramInt2);
    float[] arrayOfFloat22 = new float[2];
    arrayOfFloat22[0] = ((paramArrayOfInt[1][0] + paramArrayOfInt[17][0]) / 2.0F / paramInt1);
    arrayOfFloat22[1] = ((paramArrayOfInt[1][1] + paramArrayOfInt[17][1]) / 2.0F / paramInt2);
    float[] arrayOfFloat23 = new float[2];
    arrayOfFloat23[0] = ((paramArrayOfInt[56][0] + paramArrayOfInt[62][0]) / 2.0F / paramInt1);
    arrayOfFloat23[1] = ((paramArrayOfInt[56][1] + paramArrayOfInt[62][1]) / 2.0F / paramInt2);
    float[] arrayOfFloat24 = new float[2];
    arrayOfFloat24[0] = (getDistance(paramArrayOfInt[2], paramArrayOfInt[57]) / paramInt1);
    arrayOfFloat24[1] = (getDistance(paramArrayOfInt[1], paramArrayOfInt[8]) / paramInt2);
    float[] arrayOfFloat25 = new float[2];
    arrayOfFloat25[0] = ((paramArrayOfInt[4][0] + paramArrayOfInt[5][0]) / 2.0F / paramInt1);
    arrayOfFloat25[1] = ((paramArrayOfInt[4][1] + paramArrayOfInt[5][1]) / 2.0F / paramInt2);
    i = 0;
    while (i < arrayOfFloat25.length)
    {
      arrayOfFloat25[i] += (arrayOfFloat23[i] - arrayOfFloat25[i]) * 0.07F;
      i += 1;
    }
    f1 = (float)(Math.atan2(paramArrayOfInt[8][1] - paramArrayOfInt[2][1], paramArrayOfInt[8][0] - paramArrayOfInt[2][0]) + 1.570796326794897D);
    float[] arrayOfFloat26 = new float[2];
    arrayOfFloat26[0] = (getDistance(paramArrayOfInt[16], paramArrayOfInt[61]) / paramInt1);
    arrayOfFloat26[1] = (getDistance(paramArrayOfInt[17], paramArrayOfInt[10]) / paramInt2);
    float[] arrayOfFloat27 = new float[2];
    arrayOfFloat27[0] = ((paramArrayOfInt[13][0] + paramArrayOfInt[14][0]) / 2.0F / paramInt1);
    arrayOfFloat27[1] = ((paramArrayOfInt[13][1] + paramArrayOfInt[14][1]) / 2.0F / paramInt2);
    i = 0;
    while (i < arrayOfFloat27.length)
    {
      arrayOfFloat27[i] += (arrayOfFloat23[i] - arrayOfFloat27[i]) * 0.07F;
      i += 1;
    }
    f2 = (float)(Math.atan2(paramArrayOfInt[16][1] - paramArrayOfInt[10][1], paramArrayOfInt[16][0] - paramArrayOfInt[10][0]) + 1.570796326794897D);
    float[] arrayOfFloat28 = new float[2];
    arrayOfFloat28[0] = (getDistance(paramArrayOfInt[0], paramArrayOfInt[35]) / paramInt1);
    arrayOfFloat28[1] = (getDistance(paramArrayOfInt[0], paramArrayOfInt[2]) / paramInt2);
    float[] arrayOfFloat29 = new float[2];
    arrayOfFloat29[0] = ((paramArrayOfInt[0][0] + paramArrayOfInt[1][0]) / 2.0F / paramInt1);
    arrayOfFloat29[1] = ((paramArrayOfInt[0][1] + paramArrayOfInt[1][1]) / 2.0F / paramInt2);
    f5 = (float)(Math.atan2(paramArrayOfInt[2][1] - paramArrayOfInt[0][1], paramArrayOfInt[2][0] - paramArrayOfInt[0][0]) + 1.570796326794897D);
    float[] arrayOfFloat30 = new float[2];
    arrayOfFloat30[0] = (getDistance(paramArrayOfInt[18], paramArrayOfInt[45]) / paramInt1);
    arrayOfFloat30[1] = (getDistance(paramArrayOfInt[18], paramArrayOfInt[16]) / paramInt2);
    float[] arrayOfFloat31 = new float[2];
    arrayOfFloat31[0] = ((paramArrayOfInt[18][0] + paramArrayOfInt[17][0]) / 2.0F / paramInt1);
    arrayOfFloat31[1] = ((paramArrayOfInt[18][1] + paramArrayOfInt[17][1]) / 2.0F / paramInt2);
    f6 = (float)(Math.atan2(paramArrayOfInt[18][1] - paramArrayOfInt[16][1], paramArrayOfInt[18][0] - paramArrayOfInt[16][0]) + 1.570796326794897D);
    float[] arrayOfFloat32 = new float[2];
    arrayOfFloat32[0] = (getDistance(paramArrayOfInt[0], paramArrayOfInt[35]) / paramInt1);
    arrayOfFloat32[1] = (getDistance(paramArrayOfInt[0], paramArrayOfInt[3]) / paramInt2);
    float[] arrayOfFloat33 = new float[2];
    arrayOfFloat33[0] = (paramArrayOfInt[1][0] / paramInt1);
    arrayOfFloat33[1] = (paramArrayOfInt[1][1] / paramInt2);
    f7 = (float)(Math.atan2(paramArrayOfInt[3][1] - paramArrayOfInt[0][1], paramArrayOfInt[3][0] - paramArrayOfInt[0][0]) + 1.570796326794897D);
    float[] arrayOfFloat34 = new float[2];
    arrayOfFloat34[0] = (getDistance(paramArrayOfInt[18], paramArrayOfInt[45]) / paramInt1);
    arrayOfFloat34[1] = (getDistance(paramArrayOfInt[18], paramArrayOfInt[15]) / paramInt2);
    float[] arrayOfFloat35 = new float[2];
    arrayOfFloat35[0] = (paramArrayOfInt[17][0] / paramInt1);
    arrayOfFloat35[1] = (paramArrayOfInt[17][1] / paramInt2);
    f8 = (float)(Math.atan2(paramArrayOfInt[18][1] - paramArrayOfInt[15][1], paramArrayOfInt[18][0] - paramArrayOfInt[15][0]) + 1.570796326794897D);
    float[] arrayOfFloat36 = new float[2];
    arrayOfFloat36[0] = ((paramArrayOfInt[4][0] * 0.5F + paramArrayOfInt[14][0] * 0.5F) / paramInt1);
    arrayOfFloat36[1] = ((paramArrayOfInt[4][1] * 0.6F + paramArrayOfInt[14][1] * 0.4F) / paramInt2);
    float[] arrayOfFloat37 = new float[2];
    arrayOfFloat37[0] = (getDistance(paramArrayOfInt[15], paramArrayOfInt[3]) / paramInt1);
    arrayOfFloat37[1] = (getDistance(paramArrayOfInt[9], paramArrayOfInt[59]) / paramInt2);
    float[] arrayOfFloat40 = new float[2];
    arrayOfFloat40[0] = ((paramArrayOfInt[3][0] + paramArrayOfInt[15][0]) / 2.0F);
    arrayOfFloat40[1] = ((paramArrayOfInt[3][1] + paramArrayOfInt[15][1]) / 2.0F);
    float[] arrayOfFloat41 = new float[2];
    arrayOfFloat41[0] = ((paramArrayOfInt[0][0] + paramArrayOfInt[18][0]) / 2.0F);
    arrayOfFloat41[1] = ((paramArrayOfInt[0][1] + paramArrayOfInt[18][1]) / 2.0F);
    float[] arrayOfFloat38 = new float[2];
    arrayOfFloat38[0] = (getDistance(paramArrayOfInt[0], paramArrayOfInt[18]) / paramInt1);
    arrayOfFloat38[1] = (getDistance(arrayOfFloat40, arrayOfFloat41) / paramInt2);
    f9 = arrayOfFloat39[0];
    f9 = arrayOfFloat39[0];
    f9 = paramArrayOfInt[9][0];
    f9 = arrayOfFloat39[1];
    f9 = arrayOfFloat39[1];
    f9 = paramArrayOfInt[9][1];
    arrayOfFloat39 = new float[3];
    arrayOfFloat39[0] = paramArrayOfFloat[0];
    arrayOfFloat39[1] = paramArrayOfFloat[1];
    arrayOfFloat39[2] = paramArrayOfFloat[2];
    arrayOfFloat39[2] = ((float)Math.atan2(paramArrayOfInt[53][1] - paramArrayOfInt[43][1], paramArrayOfInt[53][0] - paramArrayOfInt[43][0]));
    f9 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, arrayOfFloat39[1] * 1.0D));
    float f10 = (float)Math.cos(f9);
    paramArrayOfFloat = new float[2];
    paramArrayOfFloat[0] = (paramArrayOfInt[0][0] + (arrayOfFloat41[0] - arrayOfFloat40[0]) * 1.5F);
    paramArrayOfFloat[1] = (paramArrayOfInt[0][1] + (arrayOfFloat41[1] - arrayOfFloat40[1]) * 1.5F);
    float[] arrayOfFloat42 = new float[2];
    arrayOfFloat42[0] = (paramArrayOfInt[18][0] + (arrayOfFloat41[0] - arrayOfFloat40[0]) * 1.5F);
    float f11 = paramArrayOfInt[18][1];
    arrayOfFloat42[1] = ((arrayOfFloat41[1] - arrayOfFloat40[1]) * 1.5F + f11);
    if (f9 < 0.0F)
    {
      paramArrayOfInt = new float[2];
      paramArrayOfFloat[0] += (arrayOfFloat42[0] - paramArrayOfFloat[0]) / f10 / 2.0F;
      paramArrayOfFloat[1] += (arrayOfFloat42[1] - paramArrayOfFloat[1]) / f10 / 2.0F;
    }
    for (;;)
    {
      paramArrayOfInt[0] /= paramInt1;
      paramArrayOfInt[1] /= paramInt2;
      arrayOfFloat38[0] /= f10;
      paramArrayOfFloat = this.cameraBeautyParams.param;
      paramArrayOfFloat.clear();
      paramArrayOfFloat.put("angles", arrayOfFloat39);
      paramArrayOfFloat.put("size", new float[] { 65.0F, 65.0F });
      this.posV1[0] = arrayOfFloat1[0];
      this.posV1[1] = arrayOfFloat1[1];
      this.posV1[2] = arrayOfFloat2[0];
      this.posV1[3] = arrayOfFloat2[1];
      this.posV1[4] = arrayOfFloat3[0];
      this.posV1[5] = arrayOfFloat3[1];
      this.posV1[6] = arrayOfFloat4[0];
      this.posV1[7] = arrayOfFloat4[1];
      this.posV1[8] = arrayOfFloat5[0];
      this.posV1[9] = arrayOfFloat5[1];
      this.posV1[10] = arrayOfFloat6[0];
      this.posV1[11] = arrayOfFloat6[1];
      this.posV1[12] = arrayOfFloat7[0];
      this.posV1[13] = arrayOfFloat7[1];
      this.posV1[14] = arrayOfFloat8[0];
      this.posV1[15] = arrayOfFloat8[1];
      this.posV1[16] = localObject[0];
      this.posV1[17] = localObject[1];
      this.posV1[18] = arrayOfFloat9[0];
      this.posV1[19] = arrayOfFloat9[1];
      this.posV1[20] = arrayOfFloat10[0];
      this.posV1[21] = arrayOfFloat10[1];
      this.posV1[22] = arrayOfFloat17[0];
      this.posV1[23] = arrayOfFloat17[1];
      this.posV1[24] = arrayOfFloat18[0];
      this.posV1[25] = arrayOfFloat18[1];
      this.posV1[26] = arrayOfFloat19[0];
      this.posV1[27] = arrayOfFloat19[1];
      this.posV1[28] = arrayOfFloat20[0];
      this.posV1[29] = arrayOfFloat20[1];
      this.posV1[30] = arrayOfFloat13[0];
      this.posV1[31] = arrayOfFloat13[1];
      this.posV1[32] = arrayOfFloat14[0];
      this.posV1[33] = arrayOfFloat14[1];
      this.posV1[34] = f3;
      this.posV1[35] = f4;
      this.posV1[36] = arrayOfFloat15[0];
      this.posV1[37] = arrayOfFloat15[1];
      this.posV1[38] = arrayOfFloat16[0];
      this.posV1[39] = arrayOfFloat16[1];
      paramArrayOfFloat.put("posV1", this.posV1);
      this.reshapeEyeNoseLipsFilter_new.setParam(paramArrayOfFloat);
      paramArrayOfFloat.clear();
      paramArrayOfFloat.put("angles", arrayOfFloat39);
      paramArrayOfFloat.put("size", new float[] { 65.0F, 65.0F });
      this.posV2[0] = arrayOfFloat1[0];
      this.posV2[1] = arrayOfFloat1[1];
      this.posV2[2] = arrayOfFloat2[0];
      this.posV2[3] = arrayOfFloat2[1];
      this.posV2[4] = arrayOfFloat3[0];
      this.posV2[5] = arrayOfFloat3[1];
      this.posV2[6] = arrayOfFloat4[0];
      this.posV2[7] = arrayOfFloat4[1];
      this.posV2[8] = arrayOfFloat17[0];
      this.posV2[9] = arrayOfFloat17[1];
      this.posV2[10] = arrayOfFloat18[0];
      this.posV2[11] = arrayOfFloat18[1];
      this.posV2[12] = arrayOfFloat19[0];
      this.posV2[13] = arrayOfFloat19[1];
      this.posV2[14] = arrayOfFloat20[0];
      this.posV2[15] = arrayOfFloat20[1];
      this.posV2[16] = arrayOfFloat5[0];
      this.posV2[17] = arrayOfFloat5[1];
      this.posV2[18] = arrayOfFloat6[0];
      this.posV2[19] = arrayOfFloat6[1];
      this.posV2[20] = arrayOfFloat9[0];
      this.posV2[21] = arrayOfFloat9[1];
      this.posV2[22] = arrayOfFloat10[0];
      this.posV2[23] = arrayOfFloat10[1];
      this.posV2[24] = arrayOfFloat11[0];
      this.posV2[25] = arrayOfFloat11[1];
      this.posV2[26] = arrayOfFloat12[0];
      this.posV2[27] = arrayOfFloat12[1];
      this.posV2[28] = arrayOfFloat21[0];
      this.posV2[29] = arrayOfFloat21[1];
      this.posV2[30] = arrayOfFloat22[0];
      this.posV2[31] = arrayOfFloat22[1];
      this.posV2[32] = arrayOfFloat24[0];
      this.posV2[33] = arrayOfFloat24[1];
      this.posV2[34] = arrayOfFloat25[0];
      this.posV2[35] = arrayOfFloat25[1];
      this.posV2[36] = f1;
      this.posV2[37] = f2;
      this.posV2[38] = arrayOfFloat26[0];
      this.posV2[39] = arrayOfFloat26[1];
      this.posV2[40] = arrayOfFloat27[0];
      this.posV2[41] = arrayOfFloat27[1];
      this.posV2[42] = arrayOfFloat23[0];
      this.posV2[43] = arrayOfFloat23[1];
      this.posV2[44] = arrayOfFloat28[0];
      this.posV2[45] = arrayOfFloat28[1];
      this.posV2[46] = arrayOfFloat29[0];
      this.posV2[47] = arrayOfFloat29[1];
      this.posV2[48] = f5;
      this.posV2[49] = f6;
      this.posV2[50] = arrayOfFloat30[0];
      this.posV2[51] = arrayOfFloat30[1];
      this.posV2[52] = arrayOfFloat31[0];
      this.posV2[53] = arrayOfFloat31[1];
      this.posV2[54] = arrayOfFloat36[0];
      this.posV2[55] = arrayOfFloat36[1];
      this.posV2[56] = arrayOfFloat37[0];
      this.posV2[57] = arrayOfFloat37[1];
      this.posV2[58] = paramArrayOfInt[0];
      this.posV2[59] = paramArrayOfInt[1];
      this.posV2[60] = arrayOfFloat38[0];
      this.posV2[61] = arrayOfFloat38[1];
      this.posV2[62] = arrayOfFloat32[0];
      this.posV2[63] = arrayOfFloat32[1];
      this.posV2[64] = arrayOfFloat33[0];
      this.posV2[65] = arrayOfFloat33[1];
      this.posV2[66] = f7;
      this.posV2[67] = f8;
      this.posV2[68] = arrayOfFloat34[0];
      this.posV2[69] = arrayOfFloat34[1];
      this.posV2[70] = arrayOfFloat35[0];
      this.posV2[71] = arrayOfFloat35[1];
      paramArrayOfFloat.put("posV2", this.posV2);
      this.reshapeWholeFaceFilter_new.setParam(paramArrayOfFloat);
      return;
      paramArrayOfInt = new float[2];
      arrayOfFloat42[0] += (paramArrayOfFloat[0] - arrayOfFloat42[0]) / f10 / 2.0F;
      arrayOfFloat42[1] += (paramArrayOfFloat[1] - arrayOfFloat42[1]) / f10 / 2.0F;
    }
  }
  
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
  
  private void initFilter4(List<PointF> paramList, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.faceOutline == null) || (this.faceOutline.length != paramList.size()))
    {
      i = paramList.size();
      this.faceOutline = ((int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 }));
    }
    int i = 0;
    while (i < paramList.size())
    {
      this.faceOutline[i][0] = ((int)(((PointF)paramList.get(i)).x - paramInt1));
      this.faceOutline[i][1] = ((int)(((PointF)paramList.get(i)).y - paramInt2));
      i += 1;
    }
    _initFilter(this.faceOutline, paramArrayOfFloat, paramInt3, paramInt3);
  }
  
  private boolean isFilterValid()
  {
    return (this.reshapeEyeNoseLipsFilter_new.isValid()) && (this.reshapeWholeFaceFilter_new.isValid()) && (this.reshapeCombineFilter_new.isValid());
  }
  
  private Frame processReshape(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, float paramFloat)
  {
    if (!isFilterValid()) {
      return paramFrame;
    }
    if (this.cameraBeautyParams.needRender()) {}
    for (int i = 1;; i = 0)
    {
      Frame localFrame = FrameBufferCache.getInstance().get(65, 65);
      FrameUtil.clearFrame(localFrame, 0.0F, 0.0F, 0.0F, 0.0F, 65, 65);
      if (this.mBeautyTransformList != null)
      {
        this.mBeautyTransformList.updateVideoSize(paramFrame.width, paramFrame.height, paramDouble);
        localFrame = this.mBeautyTransformList.updateAndRender(localFrame, paramList, paramList1, paramFloat);
        i |= 0x2;
      }
      for (;;)
      {
        if (i == 0)
        {
          localFrame.unlock();
          return paramFrame;
        }
        BenchUtil.benchStart("[showPreview]processReshape4 prepare");
        Object localObject1 = FrameBufferCache.getInstance().get(65, 65);
        FrameUtil.clearFrame((Frame)localObject1, 0.0F, 0.0F, 0.0F, 0.0F, 65, 65);
        HashMap localHashMap = new HashMap();
        int k = Math.max(paramFrame.width, paramFrame.height);
        int m = (paramFrame.width - k) / 2;
        int n = (paramFrame.height - k) / 2;
        localHashMap.clear();
        localHashMap.put("srcSize", new float[] { paramFrame.width, paramFrame.height });
        localHashMap.put("cropSize", new float[] { k, k });
        localHashMap.put("texMapSize", new float[] { 67.0F, 67.0F });
        this.reshapeCombineFilter_new.updateSize(m / paramFrame.width, (m + k) / paramFrame.width, n / paramFrame.height, (n + k) / paramFrame.height);
        BenchUtil.benchEnd("[showPreview]processReshape4 prepare");
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if ((i == 1) || (i == 3))
        {
          this.cameraBeautyParams.updateReshapeParams4();
          localObject2 = this.cameraBeautyParams.param;
          this.reshapeEyeNoseLipsFilter_new.setParam((Map)localObject2);
          this.reshapeWholeFaceFilter_new.setParam((Map)localObject2);
          int j = 0;
          while (j < paramList.size())
          {
            BenchUtil.benchStart("[showPreview]processReshape4 initFilter 0");
            this.facePoints = VideoMaterialUtil.copyList((List)paramList.get(j));
            localObject2 = FaceDetectUtil.facePointf83to90(this.facePoints);
            localObject3 = ((List)localObject2).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PointF)((Iterator)localObject3).next();
              ((PointF)localObject4).x = ((float)(((PointF)localObject4).x / paramDouble));
              ((PointF)localObject4).y = ((float)(((PointF)localObject4).y / paramDouble));
            }
            BenchUtil.benchEnd("[showPreview]processReshape4 initFilter 0");
            BenchUtil.benchStart("[showPreview]processReshape4 initFilter4");
            initFilter4((List)localObject2, (float[])paramList1.get(j), m, n, k);
            BenchUtil.benchEnd("[showPreview]processReshape4 initFilter4");
            localObject2 = localObject1;
            if (this.cameraBeautyParams.needRenderEyeNoseLips())
            {
              BenchUtil.benchStart("[showPreview]processReshape4 reshapeEyeNoseLipsFilter");
              localObject2 = this.reshapeEyeNoseLipsFilter_new.RenderProcess(((Frame)localObject1).getTextureId(), 65, 65);
              ((Frame)localObject1).unlock();
              BenchUtil.benchEnd("[showPreview]processReshape4 reshapeEyeNoseLipsFilter");
            }
            if (!this.cameraBeautyParams.needRenderWholeFace()) {
              break label969;
            }
            BenchUtil.benchStart("[showPreview]processReshape4 reshapeWholeFaceFilter");
            localObject1 = this.reshapeWholeFaceFilter_new.RenderProcess(((Frame)localObject2).getTextureId(), 65, 65);
            ((Frame)localObject2).unlock();
            BenchUtil.benchEnd("[showPreview]processReshape4 reshapeWholeFaceFilter");
            j += 1;
          }
        }
        for (paramList = (List<List<PointF>>)localObject1;; paramList = (List<List<PointF>>)localObject1)
        {
          BenchUtil.benchStart("[showPreview]processReshape4 copyFilter 0");
          paramList1 = this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          BenchUtil.benchEnd("[showPreview]processReshape4 copyFilter 0");
          localObject1 = FrameBufferCache.getInstance().get(67, 67);
          FrameUtil.clearFrame((Frame)localObject1, 0.0F, 0.0F, 0.0F, 0.0F, 67, 67);
          this.transformCopyFilter.setPositions(AlgoUtils.calPositions(1.0F, 66.0F, 66.0F, 1.0F, 67, 67));
          this.transformCopyFilter.OnDrawFrameGLSL();
          this.transformCopyFilter.renderTexture(paramList.getTextureId(), 67, 67);
          localObject2 = FrameBufferCache.getInstance().get(67, 67);
          FrameUtil.clearFrame((Frame)localObject2, 0.0F, 0.0F, 0.0F, 0.0F, 67, 67);
          this.transformCopyFilter.OnDrawFrameGLSL();
          this.transformCopyFilter.renderTexture(localFrame.getTextureId(), 67, 67);
          BenchUtil.benchStart("[showPreview]processReshape4 reshapeCombineFilter");
          localHashMap.put("vType", Integer.valueOf(i));
          GlUtil.saveTextureToRgbaBuffer(paramList.getTextureId(), 0, 0, paramList.width, paramList.height, this.mData, paramList.getFBO());
          localObject3 = VideoMaterialUtil.toFlatArray(getImage(66, 66));
          GlUtil.saveTextureToRgbaBuffer(localFrame.getTextureId(), 0, 0, localFrame.width, localFrame.height, this.mData, localFrame.getFBO());
          localObject4 = VideoMaterialUtil.toFlatArray(getImage(66, 66));
          this.reshapeCombineFilter_new.updateImage((float[])localObject3, (float[])localObject4);
          this.reshapeCombineFilter_new.setParam(localHashMap);
          this.reshapeCombineFilter_new.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramList1);
          paramFrame.unlock();
          BenchUtil.benchEnd("[showPreview]processReshape4 reshapeCombineFilter");
          paramList.unlock();
          localFrame.unlock();
          ((Frame)localObject1).unlock();
          ((Frame)localObject2).unlock();
          return paramList1;
          label969:
          localObject1 = localObject2;
          break;
        }
      }
    }
  }
  
  private Frame processReshape4(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, float paramFloat)
  {
    if (!isFilterValid()) {
      return paramFrame;
    }
    if (this.cameraBeautyParams.needRender()) {}
    for (int i = 1;; i = 0)
    {
      Frame localFrame = FrameBufferCache.getInstance().get(65, 65);
      FrameUtil.clearFrame(localFrame, 0.0F, 0.0F, 0.0F, 0.0F, 65, 65);
      if (this.mBeautyTransformList != null)
      {
        this.mBeautyTransformList.updateVideoSize(paramFrame.width, paramFrame.height, paramDouble);
        localFrame = this.mBeautyTransformList.updateAndRender(localFrame, paramList, paramList1, paramFloat);
        i |= 0x2;
      }
      for (;;)
      {
        if (i == 0)
        {
          localFrame.unlock();
          return paramFrame;
        }
        BenchUtil.benchStart("[showPreview]processReshape4 prepare");
        Object localObject1 = FrameBufferCache.getInstance().get(65, 65);
        FrameUtil.clearFrame((Frame)localObject1, 0.0F, 0.0F, 0.0F, 0.0F, 65, 65);
        HashMap localHashMap = new HashMap();
        int k = Math.max(paramFrame.width, paramFrame.height);
        int m = (paramFrame.width - k) / 2;
        int n = (paramFrame.height - k) / 2;
        localHashMap.clear();
        localHashMap.put("srcSize", new float[] { paramFrame.width, paramFrame.height });
        localHashMap.put("cropSize", new float[] { k, k });
        localHashMap.put("texMapSize", new float[] { 67.0F, 67.0F });
        this.reshapeCombineFilter_new.updateSize(m / paramFrame.width, (m + k) / paramFrame.width, n / paramFrame.height, (n + k) / paramFrame.height);
        BenchUtil.benchEnd("[showPreview]processReshape4 prepare");
        Object localObject2;
        if ((i == 1) || (i == 3))
        {
          this.cameraBeautyParams.updateReshapeParams4();
          localObject2 = this.cameraBeautyParams.param;
          this.reshapeEyeNoseLipsFilter_new.setParam((Map)localObject2);
          this.reshapeWholeFaceFilter_new.setParam((Map)localObject2);
          int j = 0;
          while (j < paramList.size())
          {
            BenchUtil.benchStart("[showPreview]processReshape4 initFilter 0");
            this.facePoints = VideoMaterialUtil.copyList((List)paramList.get(j));
            localObject2 = FaceDetectUtil.facePointf83to90(this.facePoints);
            Iterator localIterator = ((List)localObject2).iterator();
            while (localIterator.hasNext())
            {
              PointF localPointF = (PointF)localIterator.next();
              localPointF.x = ((float)(localPointF.x / paramDouble));
              localPointF.y = ((float)(localPointF.y / paramDouble));
            }
            BenchUtil.benchEnd("[showPreview]processReshape4 initFilter 0");
            BenchUtil.benchStart("[showPreview]processReshape4 initFilter4");
            initFilter4((List)localObject2, (float[])paramList1.get(j), m, n, k);
            BenchUtil.benchEnd("[showPreview]processReshape4 initFilter4");
            localObject2 = localObject1;
            if (this.cameraBeautyParams.needRenderEyeNoseLips())
            {
              BenchUtil.benchStart("[showPreview]processReshape4 reshapeEyeNoseLipsFilter");
              localObject2 = this.reshapeEyeNoseLipsFilter_new.RenderProcess(((Frame)localObject1).getTextureId(), 65, 65);
              ((Frame)localObject1).unlock();
              BenchUtil.benchEnd("[showPreview]processReshape4 reshapeEyeNoseLipsFilter");
            }
            if (!this.cameraBeautyParams.needRenderWholeFace()) {
              break label915;
            }
            BenchUtil.benchStart("[showPreview]processReshape4 reshapeWholeFaceFilter");
            localObject1 = this.reshapeWholeFaceFilter_new.RenderProcess(((Frame)localObject2).getTextureId(), 65, 65);
            ((Frame)localObject2).unlock();
            BenchUtil.benchEnd("[showPreview]processReshape4 reshapeWholeFaceFilter");
            j += 1;
          }
        }
        for (paramList = (List<List<PointF>>)localObject1;; paramList = (List<List<PointF>>)localObject1)
        {
          BenchUtil.benchStart("[showPreview]processReshape4 copyFilter 0");
          paramList1 = this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          BenchUtil.benchEnd("[showPreview]processReshape4 copyFilter 0");
          localObject1 = FrameBufferCache.getInstance().get(67, 67);
          FrameUtil.clearFrame((Frame)localObject1, 0.0F, 0.0F, 0.0F, 0.0F, 67, 67);
          this.transformCopyFilter.setPositions(AlgoUtils.calPositions(1.0F, 66.0F, 66.0F, 1.0F, 67, 67));
          this.transformCopyFilter.OnDrawFrameGLSL();
          this.transformCopyFilter.renderTexture(paramList.getTextureId(), 67, 67);
          localObject2 = FrameBufferCache.getInstance().get(67, 67);
          FrameUtil.clearFrame((Frame)localObject2, 0.0F, 0.0F, 0.0F, 0.0F, 67, 67);
          this.transformCopyFilter.OnDrawFrameGLSL();
          this.transformCopyFilter.renderTexture(localFrame.getTextureId(), 67, 67);
          BenchUtil.benchStart("[showPreview]processReshape4 reshapeCombineFilter");
          localHashMap.put("vType", Integer.valueOf(i));
          localHashMap.put("inputImageTexture2", Integer.valueOf(paramList.getTextureId()));
          localHashMap.put("inputImageTexture3", Integer.valueOf(localFrame.getTextureId()));
          this.reshapeCombineFilter_new.setParam(localHashMap);
          this.reshapeCombineFilter_new.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramList1);
          paramFrame.unlock();
          BenchUtil.benchEnd("[showPreview]processReshape4 reshapeCombineFilter");
          paramList.unlock();
          localFrame.unlock();
          ((Frame)localObject1).unlock();
          ((Frame)localObject2).unlock();
          return paramList1;
          label915:
          localObject1 = localObject2;
          break;
        }
      }
    }
  }
  
  public boolean beautytransformIsNull()
  {
    return this.mBeautyTransformList == null;
  }
  
  public void clear()
  {
    if (this.mBeautyTransformList != null) {
      this.mBeautyTransformList.clear();
    }
    if (this.reshapeCombineFilter_new != null) {
      this.reshapeCombineFilter_new.clearGLSLSelf();
    }
    if (this.reshapeEyeNoseLipsFilter_new != null) {
      this.reshapeEyeNoseLipsFilter_new.clearGLSLSelf();
    }
    if (this.reshapeWholeFaceFilter_new != null) {
      this.reshapeWholeFaceFilter_new.clearGLSLSelf();
    }
    if (this.copyFilter != null) {
      this.copyFilter.clearGLSLSelf();
    }
    if (this.cropFilter != null) {
      this.cropFilter.clearGLSLSelf();
    }
    if (this.transformCopyFilter != null) {
      this.transformCopyFilter.clearGLSLSelf();
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
  }
  
  public List<PointF> getImage(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return localArrayList;
    }
    localArrayList.add(getPixel(0, 0));
    int i = 0;
    label36:
    int j;
    if (i < paramInt2)
    {
      if (i % 2 != 0) {
        break label122;
      }
      j = 0;
      while (j < paramInt1)
      {
        localArrayList.add(getPixel(j, i + 1));
        localArrayList.add(getPixel(j + 1, i));
        j += 1;
      }
      localArrayList.add(getPixel(paramInt1, i + 1));
    }
    for (;;)
    {
      i += 1;
      break label36;
      break;
      label122:
      j = paramInt1;
      while (j > 0)
      {
        localArrayList.add(getPixel(j, i + 1));
        localArrayList.add(getPixel(j - 1, i));
        j -= 1;
      }
      localArrayList.add(getPixel(0, i + 1));
    }
  }
  
  public PointF getPixel(int paramInt1, int paramInt2)
  {
    int j = (paramInt1 * 67 + paramInt2) * 4;
    paramInt1 = setColor(this.mData[j] & 0xFF);
    paramInt2 = setColor(this.mData[(j + 1)] & 0xFF);
    int i = setColor(this.mData[(j + 2)] & 0xFF);
    j = setColor(this.mData[(j + 3)] & 0xFF);
    return new PointF((float)(1.0D * paramInt1 / 127.5D + i * 1.0D / 255.0D / 127.5D - 1.0D), (float)(paramInt2 * 1.0D / 127.5D + j * 1.0D / 255.0D / 127.5D - 1.0D));
  }
  
  public void init()
  {
    this.mBeautyTransformList = new BeautyTransformList_new();
    this.mBeautyTransformList.initial();
    float[] arrayOfFloat = VideoMaterialUtil.toFlatArray(VideoMaterialUtil.genFullScreenVertices(64, 64, 0.0F, 1.0F, 0.0F, 1.0F));
    init(arrayOfFloat, arrayOfFloat);
  }
  
  public void init(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (GLCapabilities.supportVTF()) {
      this.useMeshType = ReshapeType.VTF;
    }
    for (;;)
    {
      this.reshapeCombineFilter_new = new ReshapeCombineFilter_new(this.useMeshType);
      this.reshapeCombineFilter_new.setInitMesh(paramArrayOfFloat1, paramArrayOfFloat2);
      this.reshapeCombineFilter_new.ApplyGLSLFilter();
      this.reshapeEyeNoseLipsFilter_new = new ReshapeEyeNoseLips_new();
      this.reshapeWholeFaceFilter_new = new ReshapeWholeFace_new();
      this.reshapeEyeNoseLipsFilter_new.setInitMesh(paramArrayOfFloat1, paramArrayOfFloat2);
      this.reshapeWholeFaceFilter_new.setInitMesh(paramArrayOfFloat1, paramArrayOfFloat2);
      this.reshapeEyeNoseLipsFilter_new.ApplyGLSLFilter();
      this.reshapeWholeFaceFilter_new.ApplyGLSLFilter();
      this.copyFilter.apply();
      this.cropFilter.apply();
      this.drawFilter.apply();
      this.transformCopyFilter.apply();
      return;
      this.useMeshType = ReshapeType.NORMAL;
      this.mData = new byte[17956];
      int i = 0;
      while (i < 17955)
      {
        this.mData[i] = 0;
        i += 1;
      }
    }
  }
  
  public boolean needRenderReshape()
  {
    return (this.cameraBeautyParams != null) && ((this.cameraBeautyParams.needRenderEyeNoseLips()) || (this.cameraBeautyParams.needRenderWholeFace()));
  }
  
  public Frame process(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, float paramFloat)
  {
    if (this.useMeshType == ReshapeType.VTF) {
      return processReshape4(paramFrame, paramList, paramList1, paramDouble, paramFloat);
    }
    return processReshape(paramFrame, paramList, paramList1, paramDouble, paramFloat);
  }
  
  public void setBeautyTransformParams(int paramInt, DistortParam paramDistortParam)
  {
    this.mBeautyTransformList.setBeautyParam(paramInt, paramDistortParam);
  }
  
  public int setColor(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + 255;
    }
    return i;
  }
  
  public void setParam(BeautyRealConfig.TYPE paramTYPE, float paramFloat)
  {
    this.cameraBeautyParams.setParam(paramTYPE, paramFloat);
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.mBeautyTransformList != null) {
      this.mBeautyTransformList.setRenderMode(paramInt);
    }
    if (this.reshapeEyeNoseLipsFilter_new != null) {
      this.reshapeEyeNoseLipsFilter_new.setRenderMode(paramInt);
    }
    if (this.reshapeWholeFaceFilter_new != null) {
      this.reshapeWholeFaceFilter_new.setRenderMode(paramInt);
    }
    if (this.reshapeCombineFilter_new != null) {
      this.reshapeCombineFilter_new.setRenderMode(paramInt);
    }
    this.copyFilter.setRenderMode(paramInt);
    this.cropFilter.setRenderMode(paramInt);
    this.drawFilter.setRenderMode(paramInt);
  }
  
  public void updateBeautyTransformSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.mBeautyTransformList != null) {
      this.mBeautyTransformList.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.RemodelFilter_new
 * JD-Core Version:    0.7.0.1
 */