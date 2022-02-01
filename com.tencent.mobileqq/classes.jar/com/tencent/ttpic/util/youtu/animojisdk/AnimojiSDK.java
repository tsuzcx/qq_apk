package com.tencent.ttpic.util.youtu.animojisdk;

import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import java.io.File;
import java.util.List;

public class AnimojiSDK
{
  private static final String TAG = AnimojiSDK.class.getSimpleName();
  private long nativeHandle = 0L;
  
  public static native boolean Face3dInit(String paramString);
  
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
    localObject = new int[5];
    Object tmp293_291 = localObject;
    tmp293_291[0] = 19;
    Object tmp298_293 = tmp293_291;
    tmp298_293[1] = 26;
    Object tmp303_298 = tmp298_293;
    tmp303_298[2] = 25;
    Object tmp308_303 = tmp303_298;
    tmp308_303[3] = 24;
    Object tmp313_308 = tmp308_303;
    tmp313_308[4] = 23;
    tmp313_308;
    i = 0;
    while (i < 5)
    {
      paramList1.add(Float.valueOf(paramArrayOfFloat[localObject[i]][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[localObject[i]][1]));
      i += 1;
    }
    localObject = new int[5];
    Object tmp382_380 = localObject;
    tmp382_380[0] = 31;
    Object tmp387_382 = tmp382_380;
    tmp387_382[1] = 32;
    Object tmp392_387 = tmp387_382;
    tmp392_387[2] = 33;
    Object tmp397_392 = tmp392_387;
    tmp397_392[3] = 34;
    Object tmp402_397 = tmp397_392;
    tmp402_397[4] = 27;
    tmp402_397;
    i = 0;
    while (i < 5)
    {
      paramList1.add(Float.valueOf(paramArrayOfFloat[localObject[i]][0]));
      paramList2.add(Float.valueOf(paramArrayOfFloat[localObject[i]][1]));
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
  
  public static void copyCatMaterial()
  {
    int j = 0;
    String[] arrayOfString = new String[14];
    arrayOfString[0] = "animoji.scene";
    arrayOfString[1] = "biaozhun3.gpb";
    arrayOfString[2] = "biaozhun3.material";
    arrayOfString[3] = "bizi.png";
    arrayOfString[4] = "bs3.gpb";
    arrayOfString[5] = "bs3.material";
    arrayOfString[6] = "bs3.xml";
    arrayOfString[7] = "Dya.png";
    arrayOfString[8] = "Lyan.png";
    arrayOfString[9] = "params.json";
    arrayOfString[10] = "Ryan.png";
    arrayOfString[11] = "she.png";
    arrayOfString[12] = "tou.png";
    arrayOfString[13] = "Uya.png";
    Object localObject = new File("/sdcard/MaterialDebug/");
    int i = j;
    if (!((File)localObject).isDirectory())
    {
      ((File)localObject).mkdirs();
      i = j;
    }
    while (i < arrayOfString.length)
    {
      localObject = "/sdcard/MaterialDebug/" + arrayOfString[i];
      if (!FileUtils.copyAssets(AEModule.getContext(), "material_52_new_29exp/" + arrayOfString[i], (String)localObject)) {
        LogUtils.e(TAG, "copyMaterial failed!");
      }
      i += 1;
    }
  }
  
  public native boolean Face3dTrack(int paramInt1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt2);
  
  public native boolean GetCurrentExpressionARKit(float[] paramArrayOfFloat, int paramInt);
  
  public native boolean GetCurrentPoseRotationARKit(float[] paramArrayOfFloat, int paramInt);
  
  public native boolean GetCurrentPoseRotationARKit1(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
  
  public native boolean GetCurrentPoseRotationFaceKit(float[] paramArrayOfFloat, int paramInt);
  
  public native boolean GetCurrentPoseRotationFaceKit1(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
  
  public native boolean GetCurrentPoseScale(float[] paramArrayOfFloat);
  
  public native boolean GetCurrentPoseTranslationFaceKit(float[] paramArrayOfFloat, int paramInt);
  
  public native boolean GetCurrentVertices(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean);
  
  public native boolean GetCurrentVerticesDiff(float[] paramArrayOfFloat, int paramInt);
  
  public native boolean GetFaceIndecies(int[] paramArrayOfInt, int paramInt);
  
  public native boolean GetFaceNum(int[] paramArrayOfInt);
  
  public native boolean GetMeanShapeVertices(float[] paramArrayOfFloat, int paramInt);
  
  public native String GetVersion();
  
  public native boolean GetVerticeNum(int[] paramArrayOfInt);
  
  public native boolean Uninit();
  
  public native boolean nativeInit(String paramString1, String paramString2, String paramString3);
  
  public native FaceStatus nativeRecognizeExpression(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3, float[] paramArrayOfFloat3);
  
  public native void nativeResetAndReTrack(float[] paramArrayOfFloat, int paramInt1, int paramInt2);
  
  public FaceStatus recognizeExpression(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    return nativeRecognizeExpression(paramArrayOfFloat, paramInt1, paramInt2, null, 0, null);
  }
  
  public native void test();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.animojisdk.AnimojiSDK
 * JD-Core Version:    0.7.0.1
 */