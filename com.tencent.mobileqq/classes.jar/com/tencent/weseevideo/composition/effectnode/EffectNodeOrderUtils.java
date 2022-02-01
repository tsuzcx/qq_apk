package com.tencent.weseevideo.composition.effectnode;

import com.tencent.tav.coremedia.CMTime;
import java.util.HashMap;

public class EffectNodeOrderUtils
{
  private static HashMap<String, Integer> a = new HashMap();
  
  static
  {
    a.put(LightVideoRenderNote.class.getSimpleName(), Integer.valueOf(0));
  }
  
  public static boolean a(CMTime paramCMTime, long paramLong)
  {
    paramLong = Math.abs(paramCMTime.getTimeUs() - paramLong);
    return (paramLong <= 0L) || (paramLong >= 1000000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.EffectNodeOrderUtils
 * JD-Core Version:    0.7.0.1
 */