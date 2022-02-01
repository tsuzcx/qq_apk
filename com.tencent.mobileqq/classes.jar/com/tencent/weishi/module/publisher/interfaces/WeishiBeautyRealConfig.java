package com.tencent.weishi.module.publisher.interfaces;

import java.util.HashMap;
import java.util.Map;

public class WeishiBeautyRealConfig
{
  public static final WeishiBeautyRealConfig.TYPE[] SINGLE_TRANS_TYPE = { WeishiBeautyRealConfig.TYPE.COLOR_TONE, WeishiBeautyRealConfig.TYPE.REMOVE_POUNCH, WeishiBeautyRealConfig.TYPE.FACE_V, WeishiBeautyRealConfig.TYPE.FACE_THIN, WeishiBeautyRealConfig.TYPE.FACE_SHORTEN, WeishiBeautyRealConfig.TYPE.CHIN, WeishiBeautyRealConfig.TYPE.FOREHEAD, WeishiBeautyRealConfig.TYPE.EYE, WeishiBeautyRealConfig.TYPE.EYE_LIGHTEN, WeishiBeautyRealConfig.TYPE.EYE_DISTANCE, WeishiBeautyRealConfig.TYPE.EYE_ANGLE, WeishiBeautyRealConfig.TYPE.NOSE, WeishiBeautyRealConfig.TYPE.MOUTH_SHAPE, WeishiBeautyRealConfig.TYPE.TOOTH_WHITEN, WeishiBeautyRealConfig.TYPE.NOSE_WING, WeishiBeautyRealConfig.TYPE.NOSE_POSITION, WeishiBeautyRealConfig.TYPE.MOUTH_SHAPE, WeishiBeautyRealConfig.TYPE.LIPS_THICKNESS, WeishiBeautyRealConfig.TYPE.LIPS_WIDTH };
  public static final WeishiBeautyRealConfig.TYPE[] SINGLE_TRANS_TYPE_573 = { WeishiBeautyRealConfig.TYPE.FACE_V, WeishiBeautyRealConfig.TYPE.FACE_THIN, WeishiBeautyRealConfig.TYPE.FACE_SHORTEN, WeishiBeautyRealConfig.TYPE.CHIN, WeishiBeautyRealConfig.TYPE.EYE, WeishiBeautyRealConfig.TYPE.NOSE, WeishiBeautyRealConfig.TYPE.BASIC3 };
  public static final WeishiBeautyRealConfig.TYPE[] SINGLE_TRANS_TYPE_580 = { WeishiBeautyRealConfig.TYPE.FACE_V, WeishiBeautyRealConfig.TYPE.FACE_THIN, WeishiBeautyRealConfig.TYPE.FACE_SHORTEN, WeishiBeautyRealConfig.TYPE.CHIN, WeishiBeautyRealConfig.TYPE.FOREHEAD, WeishiBeautyRealConfig.TYPE.EYE, WeishiBeautyRealConfig.TYPE.EYE_LIGHTEN, WeishiBeautyRealConfig.TYPE.EYE_DISTANCE, WeishiBeautyRealConfig.TYPE.EYE_ANGLE, WeishiBeautyRealConfig.TYPE.NOSE, WeishiBeautyRealConfig.TYPE.NOSE_WING, WeishiBeautyRealConfig.TYPE.NOSE_POSITION, WeishiBeautyRealConfig.TYPE.MOUTH_SHAPE, WeishiBeautyRealConfig.TYPE.MOUTH_SHAPE, WeishiBeautyRealConfig.TYPE.TOOTH_WHITEN, WeishiBeautyRealConfig.TYPE.COLOR_TONE, WeishiBeautyRealConfig.TYPE.REMOVE_POUNCH, WeishiBeautyRealConfig.TYPE.LIPS_THICKNESS, WeishiBeautyRealConfig.TYPE.LIPS_WIDTH };
  
  public static Map<WeishiBeautyRealConfig.TYPE, Integer> getBeautyLevels(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(WeishiBeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(60));
    int j = WeishiBeautyRealConfig.TYPE.NONE.value;
    int i = 0;
    Integer localInteger = Integer.valueOf(0);
    if (paramInt == j)
    {
      if (paramBoolean)
      {
        localHashMap.put(WeishiBeautyRealConfig.TYPE.BEAUTY, localInteger);
        localHashMap.put(WeishiBeautyRealConfig.TYPE.BASIC3, localInteger);
      }
      else
      {
        localHashMap.put(WeishiBeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(50));
        localHashMap.put(WeishiBeautyRealConfig.TYPE.BASIC3, Integer.valueOf(55));
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
    WeishiBeautyRealConfig.TYPE[] arrayOfTYPE = SINGLE_TRANS_TYPE_580;
    j = arrayOfTYPE.length;
    paramInt = i;
    while (paramInt < j)
    {
      WeishiBeautyRealConfig.TYPE localTYPE = arrayOfTYPE[paramInt];
      if (!localHashMap.containsKey(localTYPE)) {
        localHashMap.put(localTYPE, localInteger);
      }
      paramInt += 1;
    }
    return localHashMap;
  }
  
  public static boolean isFaceType(int paramInt)
  {
    return (paramInt == WeishiBeautyRealConfig.TYPE.BASIC3.value) || (paramInt == WeishiBeautyRealConfig.TYPE.BASIC4.value) || (paramInt == WeishiBeautyRealConfig.TYPE.BASIC5.value) || (paramInt == WeishiBeautyRealConfig.TYPE.BASIC6.value) || (paramInt == WeishiBeautyRealConfig.TYPE.BASIC7.value) || (paramInt == WeishiBeautyRealConfig.TYPE.BASIC8.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.interfaces.WeishiBeautyRealConfig
 * JD-Core Version:    0.7.0.1
 */