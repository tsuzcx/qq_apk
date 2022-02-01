package com.tencent.ttpic.openapi.config;

import java.util.HashMap;
import java.util.Map;

public class BeautyRealConfig
{
  public static final BeautyRealConfig.TYPE[] SINGLE_TRANS_TYPE = { BeautyRealConfig.TYPE.COLOR_TONE, BeautyRealConfig.TYPE.REMOVE_POUNCH, BeautyRealConfig.TYPE.FACE_V, BeautyRealConfig.TYPE.FACE_THIN, BeautyRealConfig.TYPE.FACE_SHORTEN, BeautyRealConfig.TYPE.CHIN, BeautyRealConfig.TYPE.FOREHEAD, BeautyRealConfig.TYPE.EYE, BeautyRealConfig.TYPE.EYE_LIGHTEN, BeautyRealConfig.TYPE.EYE_DISTANCE, BeautyRealConfig.TYPE.EYE_ANGLE, BeautyRealConfig.TYPE.NOSE, BeautyRealConfig.TYPE.MOUTH_SHAPE, BeautyRealConfig.TYPE.TOOTH_WHITEN, BeautyRealConfig.TYPE.NOSE_WING, BeautyRealConfig.TYPE.NOSE_POSITION, BeautyRealConfig.TYPE.MOUTH_SHAPE, BeautyRealConfig.TYPE.LIPS_THICKNESS, BeautyRealConfig.TYPE.LIPS_WIDTH };
  public static final BeautyRealConfig.TYPE[] SINGLE_TRANS_TYPE_573 = { BeautyRealConfig.TYPE.FACE_V, BeautyRealConfig.TYPE.FACE_THIN, BeautyRealConfig.TYPE.FACE_SHORTEN, BeautyRealConfig.TYPE.CHIN, BeautyRealConfig.TYPE.EYE, BeautyRealConfig.TYPE.NOSE, BeautyRealConfig.TYPE.BASIC3 };
  public static final BeautyRealConfig.TYPE[] SINGLE_TRANS_TYPE_580 = { BeautyRealConfig.TYPE.FACE_V, BeautyRealConfig.TYPE.FACE_THIN, BeautyRealConfig.TYPE.FACE_SHORTEN, BeautyRealConfig.TYPE.CHIN, BeautyRealConfig.TYPE.FOREHEAD, BeautyRealConfig.TYPE.EYE, BeautyRealConfig.TYPE.EYE_LIGHTEN, BeautyRealConfig.TYPE.EYE_DISTANCE, BeautyRealConfig.TYPE.EYE_ANGLE, BeautyRealConfig.TYPE.NOSE, BeautyRealConfig.TYPE.NOSE_WING, BeautyRealConfig.TYPE.NOSE_POSITION, BeautyRealConfig.TYPE.MOUTH_SHAPE, BeautyRealConfig.TYPE.MOUTH_SHAPE, BeautyRealConfig.TYPE.TOOTH_WHITEN, BeautyRealConfig.TYPE.COLOR_TONE, BeautyRealConfig.TYPE.REMOVE_POUNCH, BeautyRealConfig.TYPE.LIPS_THICKNESS, BeautyRealConfig.TYPE.LIPS_WIDTH };
  
  public static Map<BeautyRealConfig.TYPE, Integer> getBeautyLevels(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(60));
    int j = BeautyRealConfig.TYPE.NONE.value;
    int i = 0;
    Integer localInteger = Integer.valueOf(0);
    if (paramInt == j)
    {
      if (paramBoolean)
      {
        localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, localInteger);
        localHashMap.put(BeautyRealConfig.TYPE.BASIC3, localInteger);
      }
      else
      {
        localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(50));
        localHashMap.put(BeautyRealConfig.TYPE.BASIC3, Integer.valueOf(55));
      }
      arrayOfTYPE = SINGLE_TRANS_TYPE_580;
      j = arrayOfTYPE.length;
      paramInt = 0;
      while (paramInt < j)
      {
        localHashMap.put(arrayOfTYPE[paramInt], localInteger);
        paramInt += 1;
      }
    }
    BeautyRealConfig.TYPE[] arrayOfTYPE = SINGLE_TRANS_TYPE_580;
    j = arrayOfTYPE.length;
    paramInt = i;
    while (paramInt < j)
    {
      BeautyRealConfig.TYPE localTYPE = arrayOfTYPE[paramInt];
      if (!localHashMap.containsKey(localTYPE)) {
        localHashMap.put(localTYPE, localInteger);
      }
      paramInt += 1;
    }
    return localHashMap;
  }
  
  public static boolean isFaceType(int paramInt)
  {
    return (paramInt == BeautyRealConfig.TYPE.BASIC3.value) || (paramInt == BeautyRealConfig.TYPE.BASIC4.value) || (paramInt == BeautyRealConfig.TYPE.BASIC5.value) || (paramInt == BeautyRealConfig.TYPE.BASIC6.value) || (paramInt == BeautyRealConfig.TYPE.BASIC7.value) || (paramInt == BeautyRealConfig.TYPE.BASIC8.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.config.BeautyRealConfig
 * JD-Core Version:    0.7.0.1
 */