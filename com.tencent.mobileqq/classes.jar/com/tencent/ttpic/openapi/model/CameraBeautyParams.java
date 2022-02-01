package com.tencent.ttpic.openapi.model;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean.BeautyConfigSet;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean.Param;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.BeautyAIParam;
import com.tencent.ttpic.openapi.filter.BeautyAIParam.AI_TYPE;
import com.tencent.ttpic.util.GsonUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CameraBeautyParams
  implements Serializable
{
  public static final int RESHAPE_FILTER_ID_CHEEKBONE_THIN = 24;
  public static final int RESHAPE_FILTER_ID_EYEBROW_ANGLE = 23;
  public static final int RESHAPE_FILTER_ID_EYEBROW_DISTANCE = 21;
  public static final int RESHAPE_FILTER_ID_EYEBROW_HEIGHT = 20;
  public static final int RESHAPE_FILTER_ID_EYES_ANGLE = 5;
  public static final int RESHAPE_FILTER_ID_EYES_DISTANCE = 6;
  public static final int RESHAPE_FILTER_ID_EYES_HEIGHT = 3;
  public static final int RESHAPE_FILTER_ID_EYES_SIZE = 4;
  public static final int RESHAPE_FILTER_ID_EYES_WIDTH = 2;
  public static final int RESHAPE_FILTER_ID_FACEOFF = 0;
  public static final int RESHAPE_FILTER_ID_FACE_JAW = 17;
  public static final int RESHAPE_FILTER_ID_FACE_SMILE = 16;
  public static final int RESHAPE_FILTER_ID_FACE_V = 19;
  public static final int RESHAPE_FILTER_ID_FACE_WIDTH = 18;
  public static final int RESHAPE_FILTER_ID_FOREHEAD_HEIGHT = 22;
  public static final int RESHAPE_FILTER_ID_LIPS_HEIGHT = 13;
  public static final int RESHAPE_FILTER_ID_LIPS_POSITION = 15;
  public static final int RESHAPE_FILTER_ID_LIPS_SIZE = 12;
  public static final int RESHAPE_FILTER_ID_LIPS_WIDTH = 14;
  public static final int RESHAPE_FILTER_ID_NOSE_BRIDGE_WIDTH = 9;
  public static final int RESHAPE_FILTER_ID_NOSE_OUTLINE_WIDTH = 8;
  public static final int RESHAPE_FILTER_ID_NOSE_POSITION = 10;
  public static final int RESHAPE_FILTER_ID_NOSE_SIZE = 7;
  public static final int RESHAPE_FILTER_ID_NOSE_TIP_SIZE = 11;
  public static final int RESHAPE_FILTER_ID_TOTAL = 1;
  private static List<Integer> RESHAPE_OTHER_FACE_PARAM;
  public static final int[] RESHAPE_WHOLE_FACE_PARAM = { 16, 17, 18, 19, 22, 24 };
  private static final String TAG = "CameraBeautyParams";
  private BeautyAIParam mBeautyAIParam = new BeautyAIParam();
  private float[] mProgress = new float[25];
  public Map<String, Object> param = new HashMap();
  
  static
  {
    RESHAPE_OTHER_FACE_PARAM = new ArrayList();
    int i = 0;
    while (i < 25)
    {
      if (!isInWholeFaceParam(i)) {
        RESHAPE_OTHER_FACE_PARAM.add(Integer.valueOf(i));
      }
      i += 1;
    }
  }
  
  private float[][] getAgeSexBeautyConfig(String paramString1, String paramString2)
  {
    paramString1 = getAgeSexBeautyConfigString(paramString1);
    String[][] arrayOfString = (String[][])Array.newInstance(String.class, new int[] { 10, 7 });
    float[][] arrayOfFloat1 = (float[][])Array.newInstance(Float.TYPE, new int[] { 10, 7 });
    float[][] arrayOfFloat2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 7, 10 });
    int i = 0;
    int j;
    while (i < 9)
    {
      arrayOfString[i] = getAgeSexBeautyConfigValue(paramString1[i]);
      j = 0;
      while (j < 7)
      {
        if (!arrayOfString[i][j].equals("")) {
          arrayOfFloat1[i][j] = (Float.parseFloat(json2Array(arrayOfString[i][j], paramString2)) / 100.0F);
        } else {
          arrayOfFloat1[i][j] = 0;
        }
        j += 1;
      }
      i += 1;
    }
    arrayOfString[9] = getAgeSexBeautyConfigValue(paramString1[9]);
    i = 0;
    while (i < 7)
    {
      if (arrayOfString[9][i].equals("true")) {
        arrayOfFloat1[9][i] = 1065353216;
      } else {
        arrayOfFloat1[9][i] = 0;
      }
      i += 1;
    }
    i = 0;
    while (i < 7)
    {
      j = 0;
      while (j < 10)
      {
        arrayOfFloat2[i][j] = arrayOfFloat1[j][i];
        j += 1;
      }
      i += 1;
    }
    return arrayOfFloat2;
  }
  
  private String[] getAgeSexBeautyConfigString(String paramString)
  {
    return new String[] { json2Array(paramString, "PackNature"), json2Array(paramString, "Thin"), json2Array(paramString, "ThinNose"), json2Array(paramString, "Short"), json2Array(paramString, "Smooth"), json2Array(paramString, "RemovePounch"), json2Array(paramString, "EyePounch"), json2Array(paramString, "WrinkleSmooth"), json2Array(paramString, "VFace"), json2Array(paramString, "Cosmetics") };
  }
  
  private String[] getAgeSexBeautyConfigValue(String paramString)
  {
    String str1 = json2Array(paramString, "0");
    String str2 = json2Array(paramString, "1");
    String str3 = json2Array(paramString, "2");
    paramString = json2Array(paramString, "3");
    return new String[] { str1, json2Array(str2, "M"), json2Array(str2, "F"), json2Array(str3, "M"), json2Array(str3, "F"), json2Array(paramString, "M"), json2Array(paramString, "F") };
  }
  
  private HashMap<String, Integer> getParamHashmap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("smooth", Integer.valueOf(4));
    localHashMap.put("wrinkle", Integer.valueOf(5));
    localHashMap.put("removePounch", Integer.valueOf(6));
    localHashMap.put("noseFold", Integer.valueOf(7));
    localHashMap.put("bigEyeThinFace", Integer.valueOf(0));
    localHashMap.put("vFace", Integer.valueOf(8));
    localHashMap.put("thinFace", Integer.valueOf(1));
    localHashMap.put("shortFace", Integer.valueOf(3));
    localHashMap.put("thinNose", Integer.valueOf(2));
    return localHashMap;
  }
  
  private static boolean isInWholeFaceParam(int paramInt)
  {
    int[] arrayOfInt = RESHAPE_WHOLE_FACE_PARAM;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private String json2Array(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = GsonUtils.json2JsonObject(paramString1);
      if (paramString1 != null)
      {
        paramString1 = GsonUtils.getStringUnsafe(paramString1, paramString2);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public void closeAIBeautyConfig()
  {
    this.mBeautyAIParam.closeAIBeauty();
  }
  
  public boolean needRender()
  {
    return (needRenderEyeNoseLips()) || (needRenderWholeFace());
  }
  
  public boolean needRenderEyeNoseLips()
  {
    Iterator localIterator = RESHAPE_OTHER_FACE_PARAM.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (Math.abs(this.mProgress[i]) > 0.001D) {
        return true;
      }
    }
    return false;
  }
  
  public boolean needRenderWholeFace()
  {
    int[] arrayOfInt = RESHAPE_WHOLE_FACE_PARAM;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (Math.abs(this.mProgress[k]) > 0.001D) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void setAIBeautyValid(boolean paramBoolean)
  {
    BeautyAIParam.setAIBeautyValid(paramBoolean);
  }
  
  public void setAgeGender(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.mBeautyAIParam.setBeautyParam(paramBoolean1, paramInt, paramBoolean2);
  }
  
  public void setFemalePercent(float paramFloat)
  {
    this.mBeautyAIParam.setFemalePercent(paramFloat);
  }
  
  public void setMalePercent(float paramFloat)
  {
    this.mBeautyAIParam.setMalePercent(paramFloat);
  }
  
  public void setParam(BeautyRealConfig.TYPE paramTYPE, float paramFloat)
  {
    switch (CameraBeautyParams.1.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    default: 
      return;
    case 14: 
      this.mProgress[24] = paramFloat;
      return;
    case 13: 
      this.mProgress[7] = paramFloat;
      return;
    case 12: 
      this.mProgress[14] = paramFloat;
      return;
    case 11: 
      this.mProgress[13] = paramFloat;
      return;
    case 10: 
      this.mProgress[10] = paramFloat;
      return;
    case 9: 
      this.mProgress[8] = paramFloat;
      return;
    case 8: 
      this.mProgress[19] = (paramFloat * 0.5F);
      return;
    case 7: 
      this.mProgress[18] = (paramFloat * 0.5F);
      return;
    case 6: 
      this.mProgress[17] = paramFloat;
      return;
    case 5: 
      this.mProgress[12] = (-paramFloat);
      return;
    case 4: 
      this.mProgress[5] = paramFloat;
      return;
    case 3: 
      this.mProgress[6] = (paramFloat * 0.35F);
      return;
    case 2: 
      this.mProgress[4] = (paramFloat * 0.5F);
      return;
    }
    this.mProgress[22] = paramFloat;
  }
  
  public void setParam4Pitu(int paramInt, float paramFloat)
  {
    if (paramInt == BeautyRealConfig.TYPE.FOREHEAD.value)
    {
      this.mProgress[22] = paramFloat;
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.EYE.value)
    {
      this.mProgress[4] = (paramFloat * 0.5F);
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.EYE_DISTANCE.value)
    {
      this.mProgress[6] = paramFloat;
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.EYE_ANGLE.value)
    {
      this.mProgress[5] = paramFloat;
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.MOUTH_SHAPE.value)
    {
      this.mProgress[12] = (-paramFloat);
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.CHIN.value)
    {
      this.mProgress[17] = paramFloat;
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.FACE_THIN.value)
    {
      this.mProgress[18] = paramFloat;
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.FACE_V.value)
    {
      this.mProgress[19] = (paramFloat * 0.5F);
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.NOSE_WING.value)
    {
      this.mProgress[8] = paramFloat;
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.NOSE_POSITION.value)
    {
      this.mProgress[10] = paramFloat;
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.LIPS_THICKNESS.value)
    {
      this.mProgress[13] = paramFloat;
      return;
    }
    if (paramInt == BeautyRealConfig.TYPE.LIPS_WIDTH.value) {
      this.mProgress[14] = paramFloat;
    }
  }
  
  public void updateAgeSexBeautyConfig(AIBeautyParamsJsonBean paramAIBeautyParamsJsonBean)
  {
    if (paramAIBeautyParamsJsonBean != null)
    {
      if (paramAIBeautyParamsJsonBean.aiBeautySets == null) {
        return;
      }
      HashMap localHashMap = getParamHashmap();
      float[][] arrayOfFloat1 = (float[][])Array.newInstance(Float.TYPE, new int[] { 7, 10 });
      float[][] arrayOfFloat2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 7, 10 });
      int i = 0;
      while (i < 7)
      {
        float[] arrayOfFloat3 = arrayOfFloat1[i];
        float[] arrayOfFloat4 = arrayOfFloat2[i];
        Iterator localIterator = paramAIBeautyParamsJsonBean.aiBeautySets.iterator();
        while (localIterator.hasNext())
        {
          localBeautyConfigSet = (AIBeautyParamsJsonBean.BeautyConfigSet)localIterator.next();
          if (localBeautyConfigSet != null) {
            if (localBeautyConfigSet.isCurrent(new int[] { 0, 6, 16, 36, 6, 16, 36 }[i], new int[] { 0, 2, 2, 2, 1, 1, 1 }[i])) {
              break label217;
            }
          }
        }
        AIBeautyParamsJsonBean.BeautyConfigSet localBeautyConfigSet = null;
        label217:
        if (localBeautyConfigSet == null) {
          LogUtils.e("CameraBeautyParams", "updateAgeSexBeautyConfig|paramSetting is null");
        }
        for (;;)
        {
          i = 0;
          break label442;
          int j;
          if (localBeautyConfigSet.faceCosmetic) {
            j = 1065353216;
          } else {
            j = 0;
          }
          arrayOfFloat3[9] = j;
          arrayOfFloat4[9] = arrayOfFloat3[9];
          localIterator = localHashMap.entrySet().iterator();
          if (localIterator != null) {
            break;
          }
          LogUtils.e("CameraBeautyParams", "updateAgeSexBeautyConfig|iterator is null");
        }
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          AIBeautyParamsJsonBean.Param localParam = (AIBeautyParamsJsonBean.Param)localBeautyConfigSet.params.get(localEntry.getKey());
          if (localParam != null)
          {
            arrayOfFloat3[((Integer)localEntry.getValue()).intValue()] = (localParam.def / 100.0F);
            arrayOfFloat4[((Integer)localEntry.getValue()).intValue()] = (localParam.max / 100.0F);
          }
          else
          {
            arrayOfFloat3[((Integer)localEntry.getValue()).intValue()] = 0;
            arrayOfFloat4[((Integer)localEntry.getValue()).intValue()] = 1065353216;
          }
        }
        i += 1;
      }
      i = 1;
      label442:
      if (i != 0)
      {
        this.mBeautyAIParam.setBeautyAITable(arrayOfFloat1);
        this.mBeautyAIParam.setbeautyAIMaxTable(arrayOfFloat2);
      }
    }
  }
  
  public void updateAgeSexBeautyConfig(String paramString)
  {
    this.mBeautyAIParam.setBeautyAITable(getAgeSexBeautyConfig(paramString, "d"));
    this.mBeautyAIParam.setbeautyAIMaxTable(getAgeSexBeautyConfig(paramString, "m"));
  }
  
  public void updateReshapeParams()
  {
    this.param.clear();
    this.param.put("eyesWidth", Float.valueOf(this.mProgress[2]));
    this.param.put("eyesHeight", Float.valueOf(this.mProgress[3]));
    this.param.put("eyesSize", Float.valueOf(this.mProgress[4]));
    this.param.put("eyesTiltAngle", Float.valueOf(this.mProgress[5]));
    this.param.put("eyesDistance", Float.valueOf(this.mProgress[6]));
    this.param.put("noseSize", Float.valueOf(this.mProgress[7]));
    this.param.put("noseOutlineWidth", Float.valueOf(this.mProgress[8]));
    this.param.put("noseBridgeWidth", Float.valueOf(this.mProgress[9]));
    this.param.put("nosePosition", Float.valueOf(this.mProgress[10]));
    this.param.put("noseTipSize", Float.valueOf(this.mProgress[11]));
    this.param.put("lipsSize", Float.valueOf(this.mProgress[12]));
    this.param.put("lipsWidth", Float.valueOf(this.mProgress[14]));
    this.param.put("lipsHeight", Float.valueOf(this.mProgress[13]));
    this.param.put("lipsYPosition", Float.valueOf(this.mProgress[15]));
    this.param.put("faceSmile", Float.valueOf(this.mProgress[16]));
    this.param.put("faceJaw", Float.valueOf(this.mProgress[17]));
    this.param.put("faceWidth", Float.valueOf(this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.FACE_THIN, this.mProgress[18] / 0.5F / 100.0F) * 50.0F));
    this.param.put("faceWidth2", Float.valueOf(this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.VFACE, this.mProgress[19] / 0.5F / 100.0F) * 50.0F));
    this.param.put("eyebrowHeight", Float.valueOf(this.mProgress[20]));
    this.param.put("eyebrowDistance", Float.valueOf(this.mProgress[21]));
    this.param.put("eyebrowAngle", Float.valueOf(this.mProgress[23]));
    this.param.put("foreheadHeight", Float.valueOf(this.mProgress[22]));
    this.param.put("cheekboneThin", Float.valueOf(this.mProgress[24]));
  }
  
  public void updateReshapeParams(float paramFloat)
  {
    this.param.clear();
    this.param.put("eyesWidth", Float.valueOf(this.mProgress[2] * paramFloat));
    this.param.put("eyesHeight", Float.valueOf(this.mProgress[3] * paramFloat));
    this.param.put("eyesSize", Float.valueOf(this.mProgress[4] * paramFloat));
    this.param.put("eyesTiltAngle", Float.valueOf(this.mProgress[5] * paramFloat));
    this.param.put("eyesDistance", Float.valueOf(this.mProgress[6] * paramFloat));
    this.param.put("noseSize", Float.valueOf(this.mProgress[7] * paramFloat));
    this.param.put("noseOutlineWidth", Float.valueOf(this.mProgress[8] * paramFloat));
    this.param.put("noseBridgeWidth", Float.valueOf(this.mProgress[9] * paramFloat));
    this.param.put("nosePosition", Float.valueOf(this.mProgress[10] * paramFloat));
    this.param.put("noseTipSize", Float.valueOf(this.mProgress[11] * paramFloat));
    this.param.put("lipsSize", Float.valueOf(this.mProgress[12] * paramFloat));
    this.param.put("lipsWidth", Float.valueOf(this.mProgress[14] * paramFloat));
    this.param.put("lipsHeight", Float.valueOf(this.mProgress[13] * paramFloat));
    this.param.put("lipsYPosition", Float.valueOf(this.mProgress[15] * paramFloat));
    this.param.put("faceSmile", Float.valueOf(this.mProgress[16] * paramFloat));
    this.param.put("faceJaw", Float.valueOf(this.mProgress[17] * paramFloat));
    this.param.put("faceWidth", Float.valueOf(this.mProgress[18] * paramFloat));
    this.param.put("faceWidth2", Float.valueOf(this.mProgress[19] * paramFloat));
    this.param.put("eyebrowHeight", Float.valueOf(this.mProgress[20] * paramFloat));
    this.param.put("eyebrowDistance", Float.valueOf(this.mProgress[21] * paramFloat));
    this.param.put("eyebrowAngle", Float.valueOf(this.mProgress[23] * paramFloat));
    this.param.put("foreheadHeight", Float.valueOf(this.mProgress[22] * paramFloat));
    this.param.put("cheekboneThin", Float.valueOf(this.mProgress[24] * paramFloat));
  }
  
  public void updateReshapeParams4()
  {
    this.param.clear();
    this.param.put("eyesWidth", Float.valueOf(this.mProgress[2]));
    this.param.put("eyesHeight", Float.valueOf(this.mProgress[3]));
    this.param.put("eyesSize", Float.valueOf(this.mProgress[4]));
    this.param.put("eyesTiltAngle", Float.valueOf(this.mProgress[5]));
    this.param.put("eyesDistance", Float.valueOf(this.mProgress[6]));
    this.param.put("noseSize", Float.valueOf(this.mProgress[7]));
    this.param.put("noseOutlineWidth", Float.valueOf(this.mProgress[8]));
    this.param.put("noseBridgeWidth", Float.valueOf(this.mProgress[9]));
    this.param.put("nosePosition", Float.valueOf(this.mProgress[10]));
    this.param.put("noseTipSize", Float.valueOf(this.mProgress[11]));
    this.param.put("lipsSize", Float.valueOf(this.mProgress[12]));
    this.param.put("lipsWidth", Float.valueOf(this.mProgress[14]));
    this.param.put("lipsHeight", Float.valueOf(this.mProgress[13]));
    this.param.put("lipsYPosition", Float.valueOf(this.mProgress[15]));
    this.param.put("eyebrowHeight", Float.valueOf(this.mProgress[20]));
    this.param.put("eyebrowDistance", Float.valueOf(this.mProgress[21]));
    this.param.put("eyebrowAngle", Float.valueOf(this.mProgress[23]));
    this.param.put("faceSmile", Float.valueOf(this.mProgress[16]));
    this.param.put("faceJaw", Float.valueOf(this.mProgress[17]));
    this.param.put("faceWidth", Float.valueOf(this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.FACE_THIN, this.mProgress[18] / 0.5F / 100.0F) * 50.0F));
    this.param.put("faceWidth2", Float.valueOf(this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.VFACE, this.mProgress[19] / 0.5F / 100.0F) * 50.0F));
    this.param.put("foreheadHeight", Float.valueOf(this.mProgress[22]));
    this.param.put("cheekboneThin", Float.valueOf(this.mProgress[24]));
  }
  
  public void updateReshapeParams4(float paramFloat)
  {
    this.param.clear();
    this.param.put("eyesWidth", Float.valueOf(this.mProgress[2] * paramFloat));
    this.param.put("eyesHeight", Float.valueOf(this.mProgress[3] * paramFloat));
    this.param.put("eyesSize", Float.valueOf(this.mProgress[4] * paramFloat));
    this.param.put("eyesTiltAngle", Float.valueOf(this.mProgress[5] * paramFloat));
    this.param.put("eyesDistance", Float.valueOf(this.mProgress[6] * paramFloat));
    this.param.put("noseSize", Float.valueOf(this.mProgress[7] * paramFloat));
    this.param.put("noseOutlineWidth", Float.valueOf(this.mProgress[8] * paramFloat));
    this.param.put("noseBridgeWidth", Float.valueOf(this.mProgress[9] * paramFloat));
    this.param.put("nosePosition", Float.valueOf(this.mProgress[10] * paramFloat));
    this.param.put("noseTipSize", Float.valueOf(this.mProgress[11] * paramFloat));
    this.param.put("lipsSize", Float.valueOf(this.mProgress[12] * paramFloat));
    this.param.put("lipsWidth", Float.valueOf(this.mProgress[14] * paramFloat));
    this.param.put("lipsHeight", Float.valueOf(this.mProgress[13] * paramFloat));
    this.param.put("lipsYPosition", Float.valueOf(this.mProgress[15] * paramFloat));
    this.param.put("eyebrowHeight", Float.valueOf(this.mProgress[20] * paramFloat));
    this.param.put("eyebrowDistance", Float.valueOf(this.mProgress[21] * paramFloat));
    this.param.put("eyebrowAngle", Float.valueOf(this.mProgress[23] * paramFloat));
    this.param.put("faceSmile", Float.valueOf(this.mProgress[16] * paramFloat));
    this.param.put("faceJaw", Float.valueOf(this.mProgress[17] * paramFloat));
    this.param.put("faceWidth", Float.valueOf(this.mProgress[18] * paramFloat));
    this.param.put("faceWidth2", Float.valueOf(this.mProgress[19] * paramFloat));
    this.param.put("foreheadHeight", Float.valueOf(this.mProgress[22] * paramFloat));
    this.param.put("cheekboneThin", Float.valueOf(this.mProgress[24] * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.CameraBeautyParams
 * JD-Core Version:    0.7.0.1
 */