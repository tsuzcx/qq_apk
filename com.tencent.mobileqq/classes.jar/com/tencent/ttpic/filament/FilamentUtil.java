package com.tencent.ttpic.filament;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.filament.Engine;
import com.google.android.filament.FilamentJNI;
import com.google.android.filament.Material;
import com.google.android.filament.Material.Builder;
import com.google.android.filament.RenderableManager;
import com.google.android.filament.gltfio.FilamentAsset;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.gameplaysdk.model.Range;
import com.tencent.ttpic.openapi.model.AnimojiExpressionJava;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.DecryptListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FilamentUtil
{
  public static final int COUNT_SKIP_FRAMES = 1;
  private static final boolean DEBUG = false;
  public static final String INDEX_FILE = "index.txt";
  private static final String TAG;
  public static final String TEST_FRAG_SHADER = "#version 300 es\nprecision highp float;\nlayout(location = 0) out vec4 fragColor;\n\n void main(void) {\n     const vec3 _347[2] = vec3[](vec3(1, 1, 1), vec3(1, 1, 1));\n\n     float _1025 = 0.0;\n     for (uint _1149 = 0u; _1149 < 2u; _1149++){\n         _1025 += _347[_1149].z;\n     }\n     fragColor = vec4(_1025 / 2.0);\n }";
  private static Set<String> debugExpression;
  private static Map<String, Range> defaultExpressionList;
  private static Map<String, Integer> expName2Index;
  private static String[] kapuOrderExpress;
  private static Set<String> smoothExpression;
  private static final Handler uiHandler = new Handler(Looper.getMainLooper());
  private static final Map<String, Float> valueMap = new HashMap();
  
  static
  {
    TAG = FilamentUtil.class.getSimpleName();
    expName2Index = new HashMap();
    debugExpression = new HashSet();
    smoothExpression = new HashSet();
    defaultExpressionList = new HashMap();
    kapuOrderExpress = new String[] { "eyeBlinkLeft", "eyeBlinkRight", "eyeSquintLeft", "eyeSquintRight", "eyeLookDownLeft", "eyeLookDownRight", "eyeLookInLeft", "eyeLookInRight", "eyeWideLeft", "eyeWideRight", "eyeLookOutLeft", "eyeLookOutRight", "eyeLookUpLeft", "eyeLookUpRight", "browDownLeft", "browDownRight", "browInnerUp", "browOuterUpLeft", "browOuterUpRight", "jawForward", "jawLeft", "jawOpen", "jawRight", "mouthLeft", "mouthRight", "mouthFrownLeft", "mouthFrownRight", "mouthSmileLeft", "mouthSmileRight", "mouthPressLeft", "mouthPressRight", "mouthDimpleLeft", "mouthDimpleRight", "mouthRollLower", "mouthRollUpper", "mouthUpperUp", "mouthLowerDown", "mouthClose", "mouthFunnel", "mouthPucker", "mouthShrugLower", "mouthShrugUpper", "noseSneer", "cheekPuff", "cheekSquintLeft", "cheekSquintRight" };
    expName2Index.put("browDownLeft", Integer.valueOf(0));
    expName2Index.put("browDownRight", Integer.valueOf(1));
    expName2Index.put("browInnerUp", Integer.valueOf(2));
    expName2Index.put("browOuterUpLeft", Integer.valueOf(3));
    expName2Index.put("browOuterUpRight", Integer.valueOf(4));
    expName2Index.put("cheekPuff", Integer.valueOf(5));
    expName2Index.put("cheekSquintLeft", Integer.valueOf(6));
    expName2Index.put("cheekSquintRight", Integer.valueOf(7));
    expName2Index.put("eyeBlinkLeft", Integer.valueOf(8));
    expName2Index.put("eyeBlinkRight", Integer.valueOf(9));
    expName2Index.put("eyeLookDownLeft", Integer.valueOf(10));
    expName2Index.put("eyeLookDownRight", Integer.valueOf(11));
    expName2Index.put("eyeLookInLeft", Integer.valueOf(12));
    expName2Index.put("eyeLookInRight", Integer.valueOf(13));
    expName2Index.put("eyeLookOutLeft", Integer.valueOf(14));
    expName2Index.put("eyeLookOutRight", Integer.valueOf(15));
    expName2Index.put("eyeLookUpLeft", Integer.valueOf(16));
    expName2Index.put("eyeLookUpRight", Integer.valueOf(17));
    expName2Index.put("eyeSquintLeft", Integer.valueOf(18));
    expName2Index.put("eyeSquintRight", Integer.valueOf(19));
    expName2Index.put("eyeWideLeft", Integer.valueOf(20));
    expName2Index.put("eyeWideRight", Integer.valueOf(21));
    expName2Index.put("jawForward", Integer.valueOf(22));
    expName2Index.put("jawLeft", Integer.valueOf(23));
    expName2Index.put("jawOpen", Integer.valueOf(24));
    expName2Index.put("jawRight", Integer.valueOf(25));
    expName2Index.put("mouthClose", Integer.valueOf(26));
    expName2Index.put("mouthDimpleLeft", Integer.valueOf(27));
    expName2Index.put("mouthDimpleRight", Integer.valueOf(28));
    expName2Index.put("mouthFrownLeft", Integer.valueOf(29));
    expName2Index.put("mouthFrownRight", Integer.valueOf(30));
    expName2Index.put("mouthFunnel", Integer.valueOf(31));
    expName2Index.put("mouthLeft", Integer.valueOf(32));
    expName2Index.put("mouthLowerDownLeft", Integer.valueOf(33));
    expName2Index.put("mouthLowerDownRight", Integer.valueOf(34));
    expName2Index.put("mouthPressLeft", Integer.valueOf(35));
    expName2Index.put("mouthPressRight", Integer.valueOf(36));
    expName2Index.put("mouthPucker", Integer.valueOf(37));
    expName2Index.put("mouthRight", Integer.valueOf(38));
    expName2Index.put("mouthRollLower", Integer.valueOf(39));
    expName2Index.put("mouthRollUpper", Integer.valueOf(40));
    expName2Index.put("mouthShrugLower", Integer.valueOf(41));
    expName2Index.put("mouthShrugUpper", Integer.valueOf(42));
    expName2Index.put("mouthSmileLeft", Integer.valueOf(43));
    expName2Index.put("mouthSmileRight", Integer.valueOf(44));
    expName2Index.put("mouthStretchLeft", Integer.valueOf(45));
    expName2Index.put("mouthStretchRight", Integer.valueOf(46));
    expName2Index.put("mouthUpperUpLeft", Integer.valueOf(47));
    expName2Index.put("mouthUpperUpRight", Integer.valueOf(48));
    expName2Index.put("noseSneerLeft", Integer.valueOf(49));
    expName2Index.put("noseSneerRight", Integer.valueOf(50));
    expName2Index.put("tongueOut", Integer.valueOf(51));
    debugExpression.add("eyeBlinkLeft");
    debugExpression.add("eyeBlinkRight");
    debugExpression.add("mouthPucker");
    smoothExpression.add("eyeBlinkLeft");
    smoothExpression.add("eyeBlinkRight");
    defaultExpressionList.put("browOuterUpRight", new Range(0.2F, 1.0F));
    defaultExpressionList.put("browOuterUpLeft", new Range(0.2F, 0.95F));
    defaultExpressionList.put("browDownRight", new Range(0.0F, 0.95F));
    defaultExpressionList.put("browDownLeft", new Range(0.0F, 0.95F));
    defaultExpressionList.put("mouthUpperUpRight", new Range(0.8F, 0.9F));
    defaultExpressionList.put("upgradeoneeyeblinkthreshold", new Range(0.3F, 0.3F));
    defaultExpressionList.put("disablemouthsmilewhenmouthpucker", new Range(0.3F, 0.3F));
    defaultExpressionList.put("upgradethresholdwhenspecificsituation", new Range(0.65F, 1.0F));
  }
  
  public static void adjustExpressionWeights(List<AnimojiExpressionJava> paramList, float[] paramArrayOfFloat1, float paramFloat, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat1[((Integer)expName2Index.get("jawOpen")).intValue()];
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AnimojiExpressionJava localAnimojiExpressionJava = (AnimojiExpressionJava)localIterator.next();
      if (!localHashSet.contains(localAnimojiExpressionJava.shapeName.toLowerCase()))
      {
        localHashSet.add(localAnimojiExpressionJava.shapeName.toLowerCase());
        paramList = new Range(0.0F, 1.0F);
        if (localAnimojiExpressionJava.shapeRange != null) {
          paramList = localAnimojiExpressionJava.shapeRange;
        }
        for (;;)
        {
          if (localAnimojiExpressionJava.shapeName.toLowerCase().equals("upgradeoneeyeblinkthreshold"))
          {
            float f2 = paramArrayOfFloat1[((Integer)expName2Index.get("eyeBlinkLeft")).intValue()];
            float f3 = paramArrayOfFloat1[((Integer)expName2Index.get("eyeBlinkRight")).intValue()];
            if ((f2 >= 0.95D) && (f3 < paramList.min))
            {
              paramArrayOfFloat1[((Integer)expName2Index.get("eyeBlinkRight")).intValue()] = 0.0F;
              break;
              if (!defaultExpressionList.containsKey(localAnimojiExpressionJava.shapeName)) {
                continue;
              }
              paramList = (Range)defaultExpressionList.get(localAnimojiExpressionJava.shapeName);
              continue;
            }
            if ((f3 < 0.95D) || (f2 >= paramList.min)) {
              break;
            }
            paramArrayOfFloat1[((Integer)expName2Index.get("eyeBlinkLeft")).intValue()] = 0.0F;
            break;
          }
        }
        if (localAnimojiExpressionJava.shapeName.toLowerCase().equals("disablemouthsmilewhenmouthpucker"))
        {
          if (paramArrayOfFloat1[((Integer)expName2Index.get("mouthPucker")).intValue()] > paramList.min)
          {
            paramArrayOfFloat1[((Integer)expName2Index.get("mouthSmileLeft")).intValue()] = 0.0F;
            paramArrayOfFloat1[((Integer)expName2Index.get("mouthSmileRight")).intValue()] = 0.0F;
          }
        }
        else if (localAnimojiExpressionJava.shapeName.toLowerCase().equals("disablemouthpuckerwhenjawopen"))
        {
          if (f1 > localAnimojiExpressionJava.shapeRange.min) {
            paramArrayOfFloat1[((Integer)expName2Index.get("mouthPucker")).intValue()] = 0.0F;
          }
        }
        else if (localAnimojiExpressionJava.shapeName.toLowerCase().equals("upgradethresholdwhenspecificsituation"))
        {
          if (Math.abs(paramArrayOfFloat2[1]) > 0.5235987755982988D)
          {
            adjustValue(paramArrayOfFloat1, ((Integer)expName2Index.get("mouthSmileLeft")).intValue(), paramList.min, paramList.max);
            adjustValue(paramArrayOfFloat1, ((Integer)expName2Index.get("mouthSmileRight")).intValue(), paramList.min, paramList.max);
            adjustValue(paramArrayOfFloat1, ((Integer)expName2Index.get("eyeBlinkLeft")).intValue(), paramList.min, paramList.max);
            adjustValue(paramArrayOfFloat1, ((Integer)expName2Index.get("eyeBlinkRight")).intValue(), paramList.min, paramList.max);
          }
          else if (Math.abs(paramArrayOfFloat2[0]) > 0.2617993877991494D)
          {
            adjustValue(paramArrayOfFloat1, ((Integer)expName2Index.get("eyeBlinkLeft")).intValue(), paramList.min, paramList.max);
            adjustValue(paramArrayOfFloat1, ((Integer)expName2Index.get("eyeBlinkRight")).intValue(), paramList.min, paramList.max);
          }
        }
        else if (expName2Index.containsKey(localAnimojiExpressionJava.shapeName)) {
          adjustValue(paramArrayOfFloat1, ((Integer)expName2Index.get(localAnimojiExpressionJava.shapeName)).intValue(), paramList.min, paramList.max);
        }
      }
    }
    if (f1 > paramFloat)
    {
      paramArrayOfFloat1[((Integer)expName2Index.get("eyeBlinkLeft")).intValue()] = 0.0F;
      paramArrayOfFloat1[((Integer)expName2Index.get("eyeBlinkRight")).intValue()] = 0.0F;
    }
  }
  
  private static float adjustValue(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramFloat1 <= paramFloat2) {
      return paramFloat4;
    }
    if (paramFloat1 >= paramFloat3) {
      return paramFloat5;
    }
    if (paramFloat3 > paramFloat2) {
      return paramFloat4 + (paramFloat1 - paramFloat2) / (paramFloat3 - paramFloat2) * (paramFloat5 - paramFloat4);
    }
    return 0.0F;
  }
  
  private static void adjustValue(float[] paramArrayOfFloat, int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramArrayOfFloat[paramInt] <= paramFloat1) {
      paramArrayOfFloat[paramInt] = 0.0F;
    }
    do
    {
      return;
      if (paramArrayOfFloat[paramInt] >= paramFloat2)
      {
        paramArrayOfFloat[paramInt] = 1.0F;
        return;
      }
    } while (paramFloat2 <= paramFloat1);
    paramArrayOfFloat[paramInt] = ((paramArrayOfFloat[paramInt] - paramFloat1) / (paramFloat2 - paramFloat1));
  }
  
  private static float blendAlpha(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null)) {}
    float f;
    do
    {
      return paramFloat1;
      f = mdist(paramArrayOfFloat1, paramArrayOfFloat2);
      if (f > paramFloat2) {
        return 1.0F;
      }
    } while (f <= paramFloat3);
    return Math.max(0.7F, paramFloat1);
  }
  
  public static boolean checkNeedRender(List<FaceStatus> paramList, List<GLBItemJava> paramList1)
  {
    if ((paramList == null) || (paramList1 == null)) {}
    for (;;)
    {
      return false;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FaceStatus localFaceStatus = (FaceStatus)paramList.next();
        if ((localFaceStatus.denseFaceModel != null) && (localFaceStatus.denseFaceModel[0] != 0.0F) && (localFaceStatus.transform[15] >= 1.0F))
        {
          i = 0;
          while (i < paramList1.size())
          {
            if (((GLBItemJava)paramList1.get(i)).positionType == FilamentUtil.PositionType.DYNAMIC.value) {
              return true;
            }
            i += 1;
          }
        }
      }
      int i = 0;
      while (i < paramList1.size())
      {
        if (((GLBItemJava)paramList1.get(i)).positionType == FilamentUtil.PositionType.STATIC.value) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static float[] convertMatrixToEulerZXY(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[3];
    quaternion2Eulerzxy(paramArrayOfFloat, arrayOfFloat);
    return new float[] { arrayOfFloat[1], arrayOfFloat[0], arrayOfFloat[2] };
  }
  
  public static float[] convertSimdQuaternionToEulerZXY(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = convertMatrixToEulerZXY(paramArrayOfFloat);
    return new float[] { -paramArrayOfFloat[2], -paramArrayOfFloat[1], paramArrayOfFloat[0] };
  }
  
  public static void decomposeMatrix2(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    paramArrayOfFloat2[0] = paramArrayOfFloat1[12];
    paramArrayOfFloat2[1] = paramArrayOfFloat1[13];
    paramArrayOfFloat2[2] = paramArrayOfFloat1[14];
    float f8 = paramArrayOfFloat1[0];
    float f9 = paramArrayOfFloat1[1];
    float f10 = paramArrayOfFloat1[2];
    float f5 = paramArrayOfFloat1[4];
    float f6 = paramArrayOfFloat1[5];
    float f7 = paramArrayOfFloat1[6];
    float f2 = paramArrayOfFloat1[8];
    float f3 = paramArrayOfFloat1[9];
    float f4 = paramArrayOfFloat1[10];
    float f1 = (f6 * f4 - f7 * f3) * f8 + (f7 * f2 - f5 * f4) * f9 + f10 * (f5 * f3 - f6 * f2);
    f8 = lengthVector3(f8, f9, f10);
    f5 = lengthVector3(f5, f6, f7);
    f2 = lengthVector3(f2, f3, f4);
    paramArrayOfFloat2 = new float[3];
    paramArrayOfFloat2[0] = f8;
    paramArrayOfFloat2[1] = f5;
    paramArrayOfFloat2[2] = f2;
    if (f1 < 0.0F)
    {
      paramArrayOfFloat2[0] = (-paramArrayOfFloat2[0]);
      paramArrayOfFloat2[1] = (-paramArrayOfFloat2[1]);
      paramArrayOfFloat2[2] = (-paramArrayOfFloat2[2]);
    }
    paramArrayOfFloat4[0] = paramArrayOfFloat2[0];
    paramArrayOfFloat4[1] = paramArrayOfFloat2[1];
    paramArrayOfFloat4[2] = paramArrayOfFloat2[2];
    paramArrayOfFloat4 = new float[16];
    int i = 0;
    while (i < 16)
    {
      paramArrayOfFloat4[i] = paramArrayOfFloat1[i];
      i += 1;
    }
    if (Math.abs(f1) > 1.E-005D)
    {
      paramArrayOfFloat4[0] /= paramArrayOfFloat2[0];
      paramArrayOfFloat4[4] /= paramArrayOfFloat2[0];
      paramArrayOfFloat4[8] /= paramArrayOfFloat2[0];
      paramArrayOfFloat4[12] /= paramArrayOfFloat2[0];
      paramArrayOfFloat4[1] /= paramArrayOfFloat2[1];
      paramArrayOfFloat4[5] /= paramArrayOfFloat2[1];
      paramArrayOfFloat4[9] /= paramArrayOfFloat2[1];
      paramArrayOfFloat4[13] /= paramArrayOfFloat2[1];
      paramArrayOfFloat4[2] /= paramArrayOfFloat2[2];
      paramArrayOfFloat4[6] /= paramArrayOfFloat2[2];
      paramArrayOfFloat4[10] /= paramArrayOfFloat2[2];
      paramArrayOfFloat4[14] /= paramArrayOfFloat2[2];
    }
    getRotationQuaternionFromMatrix2(paramArrayOfFloat4, paramArrayOfFloat3);
    double d = Math.sqrt(paramArrayOfFloat3[0] * paramArrayOfFloat3[0] + paramArrayOfFloat3[1] * paramArrayOfFloat3[1] + paramArrayOfFloat3[2] * paramArrayOfFloat3[2] + paramArrayOfFloat3[3] * paramArrayOfFloat3[3]);
    paramArrayOfFloat3[0] = ((float)(paramArrayOfFloat3[0] / d));
    paramArrayOfFloat3[1] = ((float)(paramArrayOfFloat3[1] / d));
    paramArrayOfFloat3[2] = ((float)(paramArrayOfFloat3[2] / d));
    paramArrayOfFloat3[3] = ((float)(paramArrayOfFloat3[3] / d));
  }
  
  private static InputStream fetchInputStream(String paramString)
  {
    try
    {
      if (FileUtils.exists(paramString)) {
        return new FileInputStream(paramString);
      }
      InputStream localInputStream = AEModule.getContext().getAssets().open(paramString);
      return localInputStream;
    }
    catch (Exception localException)
    {
      Log.d(TAG, "tryFetchInputStream: Fail to load " + paramString);
    }
    return null;
  }
  
  public static void flattenEars(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      paramArrayOfFloat[291] = -0.663791F;
      paramArrayOfFloat[294] = -0.663791F;
      paramArrayOfFloat[297] = -0.663791F;
      paramArrayOfFloat[300] = -0.663791F;
      paramArrayOfFloat[303] = -0.663791F;
      paramArrayOfFloat[306] = -0.663791F;
      paramArrayOfFloat[309] = -0.663791F;
      paramArrayOfFloat[312] = -0.663791F;
      paramArrayOfFloat[315] = -0.663791F;
      paramArrayOfFloat[318] = -0.663791F;
      paramArrayOfFloat[321] = -0.663791F;
      paramArrayOfFloat[324] = -0.663791F;
      paramArrayOfFloat[327] = -0.663791F;
      paramArrayOfFloat[330] = -0.663791F;
      paramArrayOfFloat[336] = -0.663791F;
      paramArrayOfFloat[1320] = -0.663791F;
      paramArrayOfFloat[1323] = -0.663791F;
      paramArrayOfFloat[1326] = -0.663791F;
      paramArrayOfFloat[1329] = -0.663791F;
      paramArrayOfFloat[1332] = -0.663791F;
      paramArrayOfFloat[2637] = -0.663791F;
      paramArrayOfFloat[2640] = -0.663791F;
      paramArrayOfFloat[2643] = -0.663791F;
      paramArrayOfFloat[2646] = -0.663791F;
      paramArrayOfFloat[2649] = -0.663791F;
      paramArrayOfFloat[2652] = -0.663791F;
      paramArrayOfFloat[2655] = -0.663791F;
      paramArrayOfFloat[2658] = -0.663791F;
      paramArrayOfFloat[2661] = -0.663791F;
      paramArrayOfFloat[2664] = -0.663791F;
      paramArrayOfFloat[2667] = -0.663791F;
      paramArrayOfFloat[2670] = -0.663791F;
      paramArrayOfFloat[2673] = -0.663791F;
      paramArrayOfFloat[2676] = -0.663791F;
      paramArrayOfFloat[2679] = -0.663791F;
      paramArrayOfFloat[2682] = -0.663791F;
      paramArrayOfFloat[2685] = -0.663791F;
      paramArrayOfFloat[2688] = -0.663791F;
      paramArrayOfFloat[2691] = -0.663791F;
      paramArrayOfFloat[2694] = -0.663791F;
      paramArrayOfFloat[2697] = -0.663791F;
      paramArrayOfFloat[2700] = -0.663791F;
      paramArrayOfFloat[2703] = -0.663791F;
      paramArrayOfFloat[2706] = -0.663791F;
      paramArrayOfFloat[2709] = -0.663791F;
      paramArrayOfFloat[2712] = -0.663791F;
      paramArrayOfFloat[2715] = -0.663791F;
      paramArrayOfFloat[2718] = -0.663791F;
      paramArrayOfFloat[2721] = -0.663791F;
      paramArrayOfFloat[2724] = -0.663791F;
      paramArrayOfFloat[1494] = 0.672753F;
      paramArrayOfFloat[2037] = 0.672753F;
      paramArrayOfFloat[2040] = 0.672753F;
      paramArrayOfFloat[1959] = 0.672753F;
      paramArrayOfFloat[1974] = 0.672753F;
      paramArrayOfFloat[1497] = 0.672753F;
      paramArrayOfFloat[2022] = 0.672753F;
      paramArrayOfFloat[2019] = 0.672753F;
      paramArrayOfFloat[2016] = 0.672753F;
      paramArrayOfFloat[879] = 0.672753F;
      paramArrayOfFloat[882] = 0.672753F;
      paramArrayOfFloat[2010] = 0.672753F;
      paramArrayOfFloat[2055] = 0.672753F;
      paramArrayOfFloat[1998] = 0.672753F;
      paramArrayOfFloat[1485] = 0.672753F;
      paramArrayOfFloat[873] = 0.672753F;
      paramArrayOfFloat[876] = 0.672753F;
      paramArrayOfFloat[855] = 0.672753F;
      paramArrayOfFloat[1992] = 0.672753F;
      paramArrayOfFloat[858] = 0.672753F;
      paramArrayOfFloat[864] = 0.672753F;
      paramArrayOfFloat[861] = 0.672753F;
      paramArrayOfFloat[1491] = 0.672753F;
      paramArrayOfFloat[894] = 0.672753F;
      paramArrayOfFloat[870] = 0.672753F;
      paramArrayOfFloat[1500] = 0.672753F;
      paramArrayOfFloat[1962] = 0.672753F;
      paramArrayOfFloat[1965] = 0.672753F;
      paramArrayOfFloat[2001] = 0.672753F;
      paramArrayOfFloat[849] = 0.672753F;
      paramArrayOfFloat[852] = 0.672753F;
      paramArrayOfFloat[867] = 0.672753F;
      paramArrayOfFloat[1971] = 0.672753F;
      paramArrayOfFloat[1980] = 0.672753F;
      paramArrayOfFloat[1977] = 0.672753F;
      paramArrayOfFloat[1995] = 0.672753F;
      paramArrayOfFloat[1986] = 0.672753F;
      paramArrayOfFloat[1989] = 0.672753F;
      paramArrayOfFloat[1983] = 0.672753F;
      paramArrayOfFloat[1488] = 0.672753F;
      paramArrayOfFloat[2004] = 0.672753F;
      paramArrayOfFloat[2028] = 0.672753F;
      paramArrayOfFloat[2025] = 0.672753F;
      paramArrayOfFloat[1968] = 0.672753F;
      paramArrayOfFloat[888] = 0.672753F;
      paramArrayOfFloat[2076] = 0.672753F;
      paramArrayOfFloat[897] = 0.672753F;
      paramArrayOfFloat[2043] = 0.672753F;
      paramArrayOfFloat[2007] = 0.672753F;
    }
  }
  
  public static void flattenNose(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      paramArrayOfFloat[1898] = -1.012814F;
      paramArrayOfFloat[1892] = -1.012814F;
      paramArrayOfFloat[1409] = -1.012814F;
      paramArrayOfFloat[659] = -1.012814F;
      paramArrayOfFloat[1199] = -1.012814F;
      paramArrayOfFloat[548] = -1.012814F;
      paramArrayOfFloat[1202] = -1.012814F;
      paramArrayOfFloat[2444] = -1.012814F;
      paramArrayOfFloat[656] = -1.012814F;
      paramArrayOfFloat[1703] = -1.012814F;
      paramArrayOfFloat[1700] = -1.012814F;
      paramArrayOfFloat[2435] = -1.012814F;
      paramArrayOfFloat[107] = -1.012814F;
      paramArrayOfFloat[1196] = -1.012814F;
      paramArrayOfFloat[1406] = -1.012814F;
      paramArrayOfFloat[662] = -1.012814F;
      paramArrayOfFloat[1697] = -1.012814F;
      paramArrayOfFloat[101] = -1.012814F;
      paramArrayOfFloat[104] = -1.012814F;
      paramArrayOfFloat['Ñ'] = -1.012814F;
      paramArrayOfFloat[1694] = -1.012814F;
      paramArrayOfFloat[1412] = -1.012814F;
      paramArrayOfFloat[1715] = -1.012814F;
      paramArrayOfFloat[1415] = -1.012814F;
      paramArrayOfFloat[1406] = -1.012814F;
      paramArrayOfFloat[1691] = -1.012814F;
      paramArrayOfFloat[1712] = -1.012814F;
      paramArrayOfFloat[1706] = -1.012814F;
      paramArrayOfFloat[1418] = -1.012814F;
      paramArrayOfFloat[650] = -1.012814F;
      paramArrayOfFloat[2438] = -1.012814F;
      paramArrayOfFloat[2429] = -1.012814F;
      paramArrayOfFloat[1205] = -1.012814F;
      paramArrayOfFloat[2432] = -1.012814F;
      paramArrayOfFloat[1208] = -1.012814F;
      paramArrayOfFloat[110] = -1.012814F;
      paramArrayOfFloat[2447] = -1.012814F;
      paramArrayOfFloat[2456] = -1.012814F;
      paramArrayOfFloat[2453] = -1.012814F;
      paramArrayOfFloat[1691] = -1.012814F;
      paramArrayOfFloat[665] = -1.035709F;
      paramArrayOfFloat[1709] = -1.035709F;
      paramArrayOfFloat[1688] = -1.035709F;
      paramArrayOfFloat[2450] = -1.035709F;
      paramArrayOfFloat[98] = -1.035709F;
      paramArrayOfFloat[2462] = -1.035709F;
      paramArrayOfFloat[''] = -1.059939F;
      paramArrayOfFloat[713] = -1.059939F;
    }
  }
  
  public static FilamentAsset[] genFilamentAssets(long[] paramArrayOfLong)
  {
    int i = 0;
    if (paramArrayOfLong == null) {
      return new FilamentAsset[0];
    }
    FilamentAsset[] arrayOfFilamentAsset = new FilamentAsset[paramArrayOfLong.length];
    while (i < paramArrayOfLong.length)
    {
      arrayOfFilamentAsset[i] = new FilamentAsset(paramArrayOfLong[i]);
      i += 1;
    }
    return arrayOfFilamentAsset;
  }
  
  public static float[] getBlendFloatArray(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat)
  {
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null)) {
      return paramArrayOfFloat2;
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat2.length];
    if (isAllZero(paramArrayOfFloat1)) {
      paramFloat = 1.0F;
    }
    Iterator localIterator = expName2Index.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int i = ((Integer)localEntry.getValue()).intValue();
      if (smoothExpression.contains(localEntry.getKey())) {
        arrayOfFloat[i] = (paramArrayOfFloat2[i] * paramFloat + (1.0F - paramFloat) * paramArrayOfFloat1[i]);
      }
      for (;;)
      {
        paramArrayOfFloat1[i] = arrayOfFloat[i];
        break;
        arrayOfFloat[i] = paramArrayOfFloat2[i];
      }
    }
    return arrayOfFloat;
  }
  
  public static float[] getBlendFloatArrayThres(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null)) {
      return paramArrayOfFloat2;
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat2.length];
    if (isAllZero(paramArrayOfFloat1)) {
      paramFloat1 = 1.0F;
    }
    int i = 0;
    float f1;
    if (i < arrayOfFloat.length)
    {
      f1 = Math.abs(paramArrayOfFloat1[i] - paramArrayOfFloat2[i]);
      if (f1 > paramFloat2) {
        f1 = 1.0F;
      }
    }
    for (;;)
    {
      float f2 = paramArrayOfFloat2[i];
      arrayOfFloat[i] = ((1.0F - f1) * paramArrayOfFloat1[i] + f2 * f1);
      paramArrayOfFloat1[i] = arrayOfFloat[i];
      i += 1;
      break;
      if (f1 > paramFloat3)
      {
        f1 = Math.max(0.7F, paramFloat1);
        continue;
        return arrayOfFloat;
      }
      else
      {
        f1 = paramFloat1;
      }
    }
  }
  
  public static float[] getBlendTransform(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, int[] paramArrayOfInt, float paramFloat)
  {
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    paramArrayOfFloat3 = getBlendFloatArrayThres(paramArrayOfFloat3, paramArrayOfFloat4, paramFloat, 0.3F, 0.05F);
    Matrix.translateM(arrayOfFloat, 0, paramArrayOfFloat3[0], paramArrayOfFloat3[1], paramArrayOfFloat3[2]);
    Matrix.scaleM(arrayOfFloat, 0, paramArrayOfFloat5[0], paramArrayOfFloat5[1], paramArrayOfFloat5[2]);
    paramArrayOfFloat1 = getBlendFloatArrayThres(paramArrayOfFloat1, paramArrayOfFloat2, paramFloat, 0.15F, 0.05F);
    paramArrayOfFloat1[0] = (-paramArrayOfFloat1[0]);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] == 1) {
        paramArrayOfFloat1[i] = (-paramArrayOfFloat1[i]);
      }
      paramArrayOfFloat1[i] = ((float)(paramArrayOfFloat1[i] * 180.0F / 3.141592653589793D));
      i += 1;
    }
    paramArrayOfFloat2 = new float[16];
    MatrixUtil.setRotateEulerM(paramArrayOfFloat2, 0, paramArrayOfFloat1[0], paramArrayOfFloat1[1], paramArrayOfFloat1[2]);
    paramArrayOfFloat1 = new float[16];
    Matrix.multiplyMM(paramArrayOfFloat1, 0, arrayOfFloat, 0, paramArrayOfFloat2, 0);
    return paramArrayOfFloat1;
  }
  
  public static float[] getBlendTransformNoBlend(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, int[] paramArrayOfInt)
  {
    float[] arrayOfFloat1 = new float[16];
    float[] arrayOfFloat2 = new float[16];
    float[] arrayOfFloat3 = new float[16];
    float[] arrayOfFloat4 = new float[16];
    Matrix.setIdentityM(arrayOfFloat1, 0);
    Matrix.translateM(arrayOfFloat1, 0, paramArrayOfFloat2[0], paramArrayOfFloat2[1], paramArrayOfFloat2[2]);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] == 1) {
        paramArrayOfFloat1[i] = (-paramArrayOfFloat1[i]);
      }
      paramArrayOfFloat1[i] = ((float)(paramArrayOfFloat1[i] * 180.0F / 3.141592653589793D));
      i += 1;
    }
    Matrix.rotateM(arrayOfFloat2, 0, arrayOfFloat1, 0, paramArrayOfFloat1[0], 0.0F, 0.0F, 1.0F);
    Matrix.rotateM(arrayOfFloat3, 0, arrayOfFloat2, 0, paramArrayOfFloat1[2], 1.0F, 0.0F, 0.0F);
    Matrix.rotateM(arrayOfFloat4, 0, arrayOfFloat3, 0, paramArrayOfFloat1[1], 0.0F, 1.0F, 0.0F);
    Matrix.scaleM(arrayOfFloat4, 0, paramArrayOfFloat3[0], paramArrayOfFloat3[1], paramArrayOfFloat3[2]);
    return arrayOfFloat4;
  }
  
  public static Range getDefaultExpressionRange(String paramString)
  {
    Range localRange = new Range(0.0F, 1.0F);
    if (defaultExpressionList.containsKey(paramString)) {
      localRange = (Range)defaultExpressionList.get(paramString);
    }
    return localRange;
  }
  
  private static byte[] getEncryptBytes(InputStream paramInputStream, int paramInt)
  {
    return FileUtils.readBytes(paramInputStream, paramInt);
  }
  
  private static int getEncryptLength(InputStream paramInputStream)
  {
    return ByteBuffer.wrap(FileUtils.readBytes(paramInputStream, 4)).getInt();
  }
  
  public static String getKapuExpNameByIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < kapuOrderExpress.length)) {
      return kapuOrderExpress[paramInt];
    }
    return null;
  }
  
  public static int getProcessWidth()
  {
    valueMap.clear();
    if (DeviceUtils.hasDeviceVHigh(AEModule.getContext())) {
      return 720;
    }
    return 540;
  }
  
  private static byte[] getRemainedBytes(InputStream paramInputStream)
  {
    return FileUtils.loadByteArray(paramInputStream);
  }
  
  public static void getRotationQuaternionFromMatrix(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = 1;
    float f1 = paramArrayOfFloat1[0] + paramArrayOfFloat1[5] + paramArrayOfFloat1[10];
    if (f1 > 0.0F)
    {
      f1 = (float)Math.sqrt(f1 + 1.0F);
      paramArrayOfFloat2[3] = (0.5F * f1);
      f1 = 0.5F / f1;
      paramArrayOfFloat2[0] = ((paramArrayOfFloat1[9] - paramArrayOfFloat1[6]) * f1);
      paramArrayOfFloat2[1] = ((paramArrayOfFloat1[2] - paramArrayOfFloat1[8]) * f1);
      paramArrayOfFloat2[2] = ((paramArrayOfFloat1[4] - paramArrayOfFloat1[1]) * f1);
      return;
    }
    if (paramArrayOfFloat1[5] > paramArrayOfFloat1[0]) {}
    for (;;)
    {
      int j = i;
      if (paramArrayOfFloat1[10] > paramArrayOfFloat1[(i * 4 + i)]) {
        j = 2;
      }
      int[] arrayOfInt = new int[3];
      int[] tmp126_124 = arrayOfInt;
      tmp126_124[0] = 1;
      int[] tmp130_126 = tmp126_124;
      tmp130_126[1] = 2;
      int[] tmp134_130 = tmp130_126;
      tmp134_130[2] = 0;
      tmp134_130;
      i = arrayOfInt[j];
      int k = arrayOfInt[i];
      float f2 = (float)Math.sqrt(paramArrayOfFloat1[(j * 4 + j)] - (paramArrayOfFloat1[(i * 4 + i)] + paramArrayOfFloat1[(k * 4 + k)]) + 1.0F);
      paramArrayOfFloat2[j] = (0.5F * f2);
      f1 = f2;
      if (f2 != 0.0F) {
        f1 = 0.5F / f2;
      }
      paramArrayOfFloat2[3] = ((paramArrayOfFloat1[(k * 4 + i)] - paramArrayOfFloat1[(i * 4 + k)]) * f1);
      paramArrayOfFloat2[i] = ((paramArrayOfFloat1[(i * 4 + j)] + paramArrayOfFloat1[(j * 4 + i)]) * f1);
      f2 = paramArrayOfFloat1[(k * 4 + j)];
      paramArrayOfFloat2[k] = ((paramArrayOfFloat1[(j * 4 + k)] + f2) * f1);
      return;
      i = 0;
    }
  }
  
  public static void getRotationQuaternionFromMatrix2(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int j = 1;
    float[] arrayOfFloat = new float[16];
    int i = 0;
    while (i < 16)
    {
      arrayOfFloat[i] = paramArrayOfFloat1[i];
      i += 1;
    }
    float f1 = arrayOfFloat[0] + arrayOfFloat[5] + arrayOfFloat[10];
    if (f1 > 0.0F)
    {
      f1 = (float)Math.sqrt(f1 + 1.0F);
      paramArrayOfFloat2[3] = (0.5F * f1);
      f1 = 0.5F / f1;
      paramArrayOfFloat2[0] = ((arrayOfFloat[9] - arrayOfFloat[6]) * f1);
      paramArrayOfFloat2[1] = ((arrayOfFloat[2] - arrayOfFloat[8]) * f1);
      paramArrayOfFloat2[2] = ((arrayOfFloat[4] - arrayOfFloat[1]) * f1);
      return;
    }
    if (arrayOfFloat[5] > arrayOfFloat[0]) {}
    for (i = j;; i = 0)
    {
      j = i;
      if (arrayOfFloat[10] > arrayOfFloat[(i * 4 + i)]) {
        j = 2;
      }
      paramArrayOfFloat1 = new int[3];
      paramArrayOfFloat1[0] = 1;
      paramArrayOfFloat1[1] = 2;
      paramArrayOfFloat1[2] = 0;
      paramArrayOfFloat1;
      i = paramArrayOfFloat1[j];
      int k = paramArrayOfFloat1[i];
      float f2 = (float)Math.sqrt(arrayOfFloat[(j * 4 + j)] - (arrayOfFloat[(i * 4 + i)] + arrayOfFloat[(k * 4 + k)]) + 1.0F);
      paramArrayOfFloat2[j] = (0.5F * f2);
      f1 = f2;
      if (f2 != 0.0F) {
        f1 = 0.5F / f2;
      }
      paramArrayOfFloat2[3] = ((arrayOfFloat[(k * 4 + i)] - arrayOfFloat[(i * 4 + k)]) * f1);
      paramArrayOfFloat2[i] = ((arrayOfFloat[(i * 4 + j)] + arrayOfFloat[(j * 4 + i)]) * f1);
      f2 = arrayOfFloat[(k * 4 + j)];
      paramArrayOfFloat2[k] = ((arrayOfFloat[(j * 4 + k)] + f2) * f1);
      return;
    }
  }
  
  public static float[] getTransformMatrix(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, int[] paramArrayOfInt)
  {
    return getBlendTransformNoBlend(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfInt);
  }
  
  private static boolean isAllZero(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      int j = paramArrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfFloat[i] != 0.0F) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static boolean isValidTransform(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 16)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        if (Float.compare(paramArrayOfFloat[i], 0.0F) != 0) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static float lengthVector3(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3);
  }
  
  public static float[] lglt2xyz(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramFloat1 * 3.141593F / 180.0F;
    float f2 = -paramFloat2 * 3.141593F / 180.0F;
    paramFloat2 = (float)Math.cos(f2);
    float f1 = (float)Math.sin(paramFloat1);
    f2 = (float)Math.sin(f2);
    paramFloat1 = (float)Math.cos(paramFloat1);
    return new float[] { Math.round(f1 * paramFloat2 * 100.0F) / 100.0F, Math.round(f2 * 100.0F) / 100.0F, Math.round(paramFloat1 * paramFloat2 * 100.0F) / 100.0F };
  }
  
  public static byte[] loadAndTryDecryptGlb(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[0];
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      return arrayOfByte;
    }
    for (;;)
    {
      try
      {
        String str1 = FileUtils.getRealDirPath(paramString1);
        String str2 = FileUtils.getFileName(paramString1);
        paramString2 = str1 + "/" + str2 + paramString2;
        str1 = str1 + "/" + str2 + paramString3;
        paramString3 = fetchInputStream(paramString2);
        paramString2 = paramString3;
        if (paramString3 == null)
        {
          paramString2 = fetchInputStream(str1);
          i = 1;
        }
        if (paramString2 == null) {
          break;
        }
        if (i != 0) {}
        paramString3 = FileUtils.loadByteArray(paramString2);
      }
      catch (Exception paramString1)
      {
        try
        {
          paramString3 = getEncryptBytes(paramString2, getEncryptLength(paramString2));
          paramString3 = mergeBytes(VideoTemplateParser.decryptListener.decrypt(paramString3), getRemainedBytes(paramString2));
          Log.d(TAG, "loadAndTryDecryptGlb: output decrypted bytes" + paramString1);
          paramString1 = paramString3;
          return paramString1;
        }
        finally
        {
          IOUtils.closeQuietly(paramString2);
        }
        paramString1 = paramString1;
        paramString1.printStackTrace();
        return arrayOfByte;
      }
      Log.d(TAG, "loadAndTryDecryptGlb: output raw bytes" + paramString1);
      paramString1 = paramString3;
    }
  }
  
  public static Material loadMaterial(Context paramContext, Engine paramEngine, String paramString)
  {
    paramContext = ByteBuffer.wrap(FileUtils.loadByteArray(paramContext, paramString));
    return new Material.Builder().payload(paramContext, paramContext.remaining()).build(paramEngine);
  }
  
  private static float mdist(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f2;
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat1.length != paramArrayOfFloat2.length))
    {
      f2 = 1.0F;
      return f2;
    }
    float f1 = 0.0F;
    int i = 0;
    for (;;)
    {
      f2 = f1;
      if (i >= paramArrayOfFloat1.length) {
        break;
      }
      f1 += Math.abs(paramArrayOfFloat1[i] - paramArrayOfFloat2[i]);
      i += 1;
    }
  }
  
  private static byte[] mergeBytes(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  private static void quaternion2Eulerzxy(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat1[0];
    float f2 = paramArrayOfFloat1[1];
    float f3 = paramArrayOfFloat1[2];
    float f4 = paramArrayOfFloat1[3];
    threeaxisrot((f1 * f2 - f4 * f3) * -2.0F, f4 * f4 - f1 * f1 + f2 * f2 - f3 * f3, 2.0F * (f2 * f3 + f4 * f1), (f1 * f3 - f4 * f2) * -2.0F, f4 * f4 - f1 * f1 - f2 * f2 + f3 * f3, paramArrayOfFloat2);
  }
  
  public static void seperateGlbs(List<GLBItemJava> paramList1, List<GLBItemJava> paramList2, List<GLBItemJava> paramList3)
  {
    if (paramList1 == null) {}
    for (;;)
    {
      return;
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        GLBItemJava localGLBItemJava = (GLBItemJava)paramList1.next();
        if (localGLBItemJava.positionType == FilamentUtil.PositionType.DYNAMIC.value) {
          paramList2.add(localGLBItemJava);
        } else {
          paramList3.add(localGLBItemJava);
        }
      }
    }
  }
  
  public static void setMorphWeights(FilamentJNI paramFilamentJNI, NodeItemJava paramNodeItemJava, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = new float[paramNodeItemJava.expressionOrderList.size()];
    int i = 0;
    if (i < paramNodeItemJava.expressionConfigList.size())
    {
      Integer localInteger1 = (Integer)expName2Index.get(((AnimojiExpressionJava)paramNodeItemJava.expressionConfigList.get(i)).shapeName);
      if (localInteger1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Integer localInteger2 = (Integer)paramNodeItemJava.expressionOrderList.get(((AnimojiExpressionJava)paramNodeItemJava.expressionConfigList.get(i)).controlledName);
        if (localInteger2 != null) {
          arrayOfFloat[localInteger2.intValue()] = paramArrayOfFloat[localInteger1.intValue()];
        }
      }
    }
    paramFilamentJNI.setMorphWeights(paramNodeItemJava.name, arrayOfFloat, paramInt1, paramInt2);
  }
  
  public static void setMorphWeights(FilamentAsset paramFilamentAsset, NodeItemJava paramNodeItemJava, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[paramNodeItemJava.expressionConfigList.size()];
    int i = 0;
    if (i < paramNodeItemJava.expressionConfigList.size())
    {
      Integer localInteger1 = (Integer)expName2Index.get(((AnimojiExpressionJava)paramNodeItemJava.expressionConfigList.get(i)).shapeName);
      if (localInteger1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Integer localInteger2 = (Integer)paramNodeItemJava.expressionOrderList.get(((AnimojiExpressionJava)paramNodeItemJava.expressionConfigList.get(i)).controlledName);
        if (localInteger2 != null) {
          arrayOfFloat[localInteger2.intValue()] = paramArrayOfFloat[localInteger1.intValue()];
        }
      }
    }
    paramFilamentAsset.setMorphWeights(paramNodeItemJava.name, arrayOfFloat);
  }
  
  public static void setMorphWeightsKapu(FilamentJNI paramFilamentJNI, float[] paramArrayOfFloat, int paramInt, List<AnimojiExpressionJava> paramList)
  {
    if ((paramArrayOfFloat == null) || (paramList == null))
    {
      paramFilamentJNI.setKapuWeights(paramInt, new String[0], new float[0]);
      return;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = kapuOrderExpress;
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (expName2Index.containsKey(localObject2)) {
        localHashMap.put(localObject2, Float.valueOf(paramArrayOfFloat[((Integer)expName2Index.get(localObject2)).intValue()]));
      }
      i += 1;
    }
    paramArrayOfFloat = paramList.iterator();
    float f;
    while (paramArrayOfFloat.hasNext())
    {
      paramList = (AnimojiExpressionJava)paramArrayOfFloat.next();
      if (localHashMap.containsKey(paramList.controlledName))
      {
        f = adjustValue(((Float)localHashMap.get(paramList.controlledName)).floatValue(), paramList.shapeRange.min, paramList.shapeRange.max, paramList.controlledRange.min, paramList.controlledRange.max);
        localHashMap.put(paramList.controlledName, Float.valueOf(f));
      }
    }
    paramArrayOfFloat = new String[localHashMap.size()];
    paramList = new float[localHashMap.size()];
    localObject1 = localHashMap.keySet().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramArrayOfFloat[i] = localObject2;
      localObject2 = (Float)localHashMap.get(localObject2);
      if (localObject2 != null) {}
      for (f = ((Float)localObject2).floatValue();; f = 0.0F)
      {
        paramList[i] = f;
        i += 1;
        break;
      }
    }
    paramFilamentJNI.setKapuWeights(paramInt, paramArrayOfFloat, paramList);
  }
  
  private static void threeaxisrot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = ((float)Math.atan2(paramFloat4, paramFloat5));
    paramArrayOfFloat[1] = ((float)Math.asin(paramFloat3));
    paramArrayOfFloat[2] = ((float)Math.atan2(paramFloat1, paramFloat2));
  }
  
  public static void updateExpressionWeights(RenderableManager paramRenderableManager, FilamentAsset paramFilamentAsset, NodeItemJava paramNodeItemJava, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[4];
    int i = 0;
    if (i < Math.min(paramNodeItemJava.expressionConfigList.size(), 4))
    {
      Integer localInteger = (Integer)expName2Index.get(((AnimojiExpressionJava)paramNodeItemJava.expressionConfigList.get(i)).shapeName);
      if (localInteger == null) {}
      for (;;)
      {
        i += 1;
        break;
        arrayOfFloat[i] = paramArrayOfFloat[localInteger.intValue()];
      }
    }
    paramRenderableManager.setMorphWeights(paramRenderableManager.getInstance(paramFilamentAsset.getEntity(paramNodeItemJava.name)), arrayOfFloat);
  }
  
  public static void updateMorphWeights(FilamentAsset paramFilamentAsset, NodeItemJava paramNodeItemJava, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[paramNodeItemJava.expressionConfigList.size()];
    int i = 0;
    if (i < paramNodeItemJava.expressionConfigList.size())
    {
      Integer localInteger1 = (Integer)expName2Index.get(((AnimojiExpressionJava)paramNodeItemJava.expressionConfigList.get(i)).shapeName);
      if (localInteger1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Integer localInteger2 = (Integer)paramNodeItemJava.expressionOrderList.get(((AnimojiExpressionJava)paramNodeItemJava.expressionConfigList.get(i)).controlledName);
        if (localInteger2 != null) {
          arrayOfFloat[localInteger2.intValue()] = paramArrayOfFloat[localInteger1.intValue()];
        }
      }
    }
    paramFilamentAsset.updateMorphWeights(paramNodeItemJava.name, arrayOfFloat);
  }
  
  public static float[] xyz2lglt(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat3 == 0.0F)
    {
      if (paramFloat1 > 0.0F) {}
      for (f2 = 90.0F;; f2 = -90.0F) {
        return new float[] { f2, -(float)Math.asin(paramFloat2) / 3.141593F * 180.0F };
      }
    }
    float f2 = (float)Math.atan(paramFloat1 / paramFloat3) / 3.141593F * 180.0F;
    float f1;
    if ((paramFloat1 > 0.0F) && (f2 < 0.0F)) {
      f1 = f2 + 180.0F;
    }
    for (;;)
    {
      f2 = f1;
      if (Math.abs(paramFloat1 - 0.0D) > 0.0001D) {
        break;
      }
      f2 = f1;
      if (Math.abs(paramFloat3 - 0.0D) > 0.0001D) {
        break;
      }
      f2 = 0.0F;
      break;
      f1 = f2;
      if (paramFloat1 < 0.0F)
      {
        f1 = f2;
        if (f2 > 0.0F) {
          f1 = f2 - 180.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentUtil
 * JD-Core Version:    0.7.0.1
 */