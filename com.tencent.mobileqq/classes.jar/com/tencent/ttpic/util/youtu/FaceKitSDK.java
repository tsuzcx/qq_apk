package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;
import java.util.List;

public enum FaceKitSDK
{
  INSTANCE;
  
  public static final int[] FACEKIT_INDEX_MAP = { 4413, 4433, 1413, 1409, 4432, 1420, 1417, 4440, 4426, 1410, 1414, 4427, 1421, 4444, 1418, 4443, 4436, 1411, 1423, 1415, 4447, 4430, 1422, 4415, 1416, 1419, 4423, 4439, 1412, 4452, 1424, 4421, 1425, 4419, 635, 2842, 2854, 645, 2843, 642, 647, 2853, 2859, 639, 2860, 646, 638, 2850, 641, 634, 644, 2852, 2837, 637, 2849, 640, 633, 2844, 2835, 636, 643, 2866, 649, 2864, 2863, 648, 2839, 4871, 3411, 4882, 3418, 3388, 3424, 4883, 3415, 4884, 4880, 3400, 3412, 3402, 4879, 4873, 4872, 3390, 4885, 3420, 4877, 4870, 3394, 3408, 4881, 4876, 4878, 3405, 3395, 4869, 3386, 4875, 4874, 4868, 5695, 1803, 1809, 5685, 1813, 1816, 1825, 5698, 5707, 1828, 1812, 5689, 5699, 5710, 1805, 5688, 1831, 1837, 1842, 5705, 5715, 5704, 1819, 1834, 5692, 1821, 5693, 5714, 1840, 3397, 3392, 5701, 1839, 5711, 1808 };
  public static final int FACE_COUNT = 12060;
  private static final String TAG = "FaceKitSDK";
  public static final int VERTICES_COUNT_RENDER = 6445;
  public static final int VERTICES_COUNT_TRACK = 6310;
  private boolean initSucess = false;
  private long nativeHandle = 0L;
  
  private FaceKitSDK() {}
  
  public static void convertPoints(float[][] paramArrayOfFloat, List<Float> paramList1, List<Float> paramList2)
  {
    Object localObject = new int[34];
    Object tmp8_6 = localObject;
    tmp8_6[0] = 0;
    Object tmp12_8 = tmp8_6;
    tmp12_8[1] = 0;
    Object tmp16_12 = tmp12_8;
    tmp16_12[2] = 1;
    Object tmp20_16 = tmp16_12;
    tmp20_16[3] = 1;
    Object tmp24_20 = tmp20_16;
    tmp24_20[4] = 2;
    Object tmp28_24 = tmp24_20;
    tmp28_24[5] = 2;
    Object tmp32_28 = tmp28_24;
    tmp32_28[6] = 3;
    Object tmp37_32 = tmp32_28;
    tmp37_32[7] = 3;
    Object tmp42_37 = tmp37_32;
    tmp42_37[8] = 4;
    Object tmp47_42 = tmp42_37;
    tmp47_42[9] = 4;
    Object tmp52_47 = tmp47_42;
    tmp52_47[10] = 5;
    Object tmp57_52 = tmp52_47;
    tmp57_52[11] = 5;
    Object tmp62_57 = tmp57_52;
    tmp62_57[12] = 6;
    Object tmp68_62 = tmp62_57;
    tmp68_62[13] = 6;
    Object tmp74_68 = tmp68_62;
    tmp74_68[14] = 7;
    Object tmp80_74 = tmp74_68;
    tmp80_74[15] = 8;
    Object tmp86_80 = tmp80_74;
    tmp86_80[16] = 9;
    Object tmp92_86 = tmp86_80;
    tmp92_86[17] = 9;
    Object tmp98_92 = tmp92_86;
    tmp98_92[18] = 10;
    Object tmp104_98 = tmp98_92;
    tmp104_98[19] = 11;
    Object tmp110_104 = tmp104_98;
    tmp110_104[20] = 12;
    Object tmp116_110 = tmp110_104;
    tmp116_110[21] = 12;
    Object tmp122_116 = tmp116_110;
    tmp122_116[22] = 13;
    Object tmp128_122 = tmp122_116;
    tmp128_122[23] = 13;
    Object tmp134_128 = tmp128_122;
    tmp134_128[24] = 14;
    Object tmp140_134 = tmp134_128;
    tmp140_134[25] = 14;
    Object tmp146_140 = tmp140_134;
    tmp146_140[26] = 15;
    Object tmp152_146 = tmp146_140;
    tmp152_146[27] = 15;
    Object tmp158_152 = tmp152_146;
    tmp158_152[28] = 16;
    Object tmp164_158 = tmp158_152;
    tmp164_158[29] = 16;
    Object tmp170_164 = tmp164_158;
    tmp170_164[30] = 17;
    Object tmp176_170 = tmp170_164;
    tmp176_170[31] = 17;
    Object tmp182_176 = tmp176_170;
    tmp182_176[32] = 18;
    Object tmp188_182 = tmp182_176;
    tmp188_182[33] = 18;
    tmp188_182;
    int i = 0;
    int j;
    while (i < 17)
    {
      j = localObject[(i * 2)];
      int k = localObject[(i * 2 + 1)];
      paramList1.add(Float.valueOf((paramArrayOfFloat[j][0] + paramArrayOfFloat[k][0]) * 0.5F));
      paramList2.add(Float.valueOf((paramArrayOfFloat[j][1] + paramArrayOfFloat[k][1]) * 0.5F));
      i += 1;
    }
    i = 0;
    while (i < 5)
    {
      j = new int[] { 19, 26, 25, 24, 23 }[i];
      paramList1.add(Float.valueOf(paramArrayOfFloat[j][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[j][1]));
      i += 1;
    }
    i = 0;
    while (i < 5)
    {
      j = new int[] { 31, 32, 33, 34, 27 }[i];
      paramList1.add(Float.valueOf(paramArrayOfFloat[j][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[j][1]));
      i += 1;
    }
    localObject = new PointF((paramArrayOfFloat[55][0] + paramArrayOfFloat[63][0]) * 0.5F, (paramArrayOfFloat[55][1] + paramArrayOfFloat[63][1]) * 0.5F);
    PointF localPointF = new PointF(paramArrayOfFloat[64][0], paramArrayOfFloat[64][1]);
    float f1 = localPointF.x;
    float f2 = ((PointF)localObject).x;
    float f3 = localPointF.y;
    float f4 = ((PointF)localObject).y;
    i = 0;
    while (i < 4)
    {
      paramList1.add(Float.valueOf(((PointF)localObject).x + (f1 - f2) / 3.0F * i));
      paramList2.add(Float.valueOf(((PointF)localObject).y + (f3 - f4) / 3.0F * i));
      i += 1;
    }
    i = 57;
    while (i <= 61)
    {
      paramList1.add(Float.valueOf(paramArrayOfFloat[i][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[i][1]));
      i += 1;
    }
    i = 0;
    while (i < 6)
    {
      j = new int[] { 35, 42, 40, 39, 38, 36 }[i];
      paramList1.add(Float.valueOf(paramArrayOfFloat[j][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[j][1]));
      i += 1;
    }
    i = 0;
    while (i < 6)
    {
      j = new int[] { 49, 50, 52, 45, 46, 48 }[i];
      paramList1.add(Float.valueOf(paramArrayOfFloat[j][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[j][1]));
      i += 1;
    }
    i = 0;
    while (i < 12)
    {
      j = new int[] { 65, 75, 76, 77, 78, 79, 66, 71, 70, 69, 68, 67 }[i];
      paramList1.add(Float.valueOf(paramArrayOfFloat[j][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[j][1]));
      i += 1;
    }
    paramList1.add(Float.valueOf(((paramArrayOfFloat[82][0] + paramArrayOfFloat[74][0]) * 0.5F + paramArrayOfFloat[65][0]) * 0.5F));
    paramList2.add(Float.valueOf(((paramArrayOfFloat[82][1] + paramArrayOfFloat[74][1]) * 0.5F + paramArrayOfFloat[65][1]) * 0.5F));
    i = 82;
    while (i >= 80)
    {
      paramList1.add(Float.valueOf(paramArrayOfFloat[i][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[i][1]));
      i -= 1;
    }
    paramList1.add(Float.valueOf(((paramArrayOfFloat[80][0] + paramArrayOfFloat[72][0]) * 0.5F + paramArrayOfFloat[66][0]) * 0.5F));
    paramList2.add(Float.valueOf(((paramArrayOfFloat[80][1] + paramArrayOfFloat[72][1]) * 0.5F + paramArrayOfFloat[66][1]) * 0.5F));
    i = 72;
    while (i <= 74)
    {
      paramList1.add(Float.valueOf(paramArrayOfFloat[i][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[i][1]));
      i += 1;
    }
  }
  
  public void doTrack(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    nativeDoTrack(paramArrayOfFloat1, paramInt1, paramInt2, paramArrayOfFloat2, paramArrayOfInt, paramBoolean);
  }
  
  public boolean isInitSucess()
  {
    return this.initSucess;
  }
  
  public native void nativeDoTrack(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int[] paramArrayOfInt, boolean paramBoolean);
  
  public native boolean nativeInit(String paramString1, String paramString2, String paramString3);
  
  public native void nativeReset();
  
  public native void nativeResetAndReTrack(float[] paramArrayOfFloat, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.FaceKitSDK
 * JD-Core Version:    0.7.0.1
 */