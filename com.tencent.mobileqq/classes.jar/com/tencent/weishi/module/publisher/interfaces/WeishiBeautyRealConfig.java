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
    if (paramInt == WeishiBeautyRealConfig.TYPE.NONE.value)
    {
      if (paramBoolean)
      {
        localHashMap.put(WeishiBeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(0));
        localHashMap.put(WeishiBeautyRealConfig.TYPE.BASIC3, Integer.valueOf(0));
      }
      for (;;)
      {
        arrayOfTYPE = SINGLE_TRANS_TYPE_580;
        i = arrayOfTYPE.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localHashMap.put(arrayOfTYPE[paramInt], Integer.valueOf(0));
          paramInt += 1;
        }
        localHashMap.put(WeishiBeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(50));
        localHashMap.put(WeishiBeautyRealConfig.TYPE.BASIC3, Integer.valueOf(55));
      }
    }
    WeishiBeautyRealConfig.TYPE[] arrayOfTYPE = SINGLE_TRANS_TYPE_580;
    int i = arrayOfTYPE.length;
    paramInt = 0;
    while (paramInt < i)
    {
      WeishiBeautyRealConfig.TYPE localTYPE = arrayOfTYPE[paramInt];
      if (!localHashMap.containsKey(localTYPE)) {
        localHashMap.put(localTYPE, Integer.valueOf(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.interfaces.WeishiBeautyRealConfig
 * JD-Core Version:    0.7.0.1
 */