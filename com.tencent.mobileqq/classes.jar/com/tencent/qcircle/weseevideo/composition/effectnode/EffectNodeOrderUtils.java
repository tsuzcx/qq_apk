package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.tav.coremedia.CMTime;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class EffectNodeOrderUtils
{
  private static HashMap<String, Integer> mDefaultOrderConfig = new HashMap();
  
  static
  {
    mDefaultOrderConfig.put(LightVideoRenderNote.class.getSimpleName(), Integer.valueOf(0));
  }
  
  public static HashMap<String, Integer> getDefaultOrderConfig()
  {
    return mDefaultOrderConfig;
  }
  
  @NotNull
  public static HashMap<String, Integer> getOrderConfigByScene(int paramInt)
  {
    return getDefaultOrderConfig();
  }
  
  public static boolean shouldSeek(CMTime paramCMTime, long paramLong)
  {
    paramLong = Math.abs(paramCMTime.getTimeUs() - paramLong);
    return (paramLong <= 0L) || (paramLong >= 1000000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.EffectNodeOrderUtils
 * JD-Core Version:    0.7.0.1
 */