package com.tencent.tmediacodec.reuse;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/reuse/ReuseHelper$AdaptationWorkaroundMode;", "", "(Ljava/lang/String;I)V", "ADAPTATION_WORKAROUND_MODE_NEVER", "ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION", "ADAPTATION_WORKAROUND_MODE_ALWAYS", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public enum ReuseHelper$AdaptationWorkaroundMode
{
  static
  {
    AdaptationWorkaroundMode localAdaptationWorkaroundMode1 = new AdaptationWorkaroundMode("ADAPTATION_WORKAROUND_MODE_NEVER", 0);
    ADAPTATION_WORKAROUND_MODE_NEVER = localAdaptationWorkaroundMode1;
    AdaptationWorkaroundMode localAdaptationWorkaroundMode2 = new AdaptationWorkaroundMode("ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION", 1);
    ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = localAdaptationWorkaroundMode2;
    AdaptationWorkaroundMode localAdaptationWorkaroundMode3 = new AdaptationWorkaroundMode("ADAPTATION_WORKAROUND_MODE_ALWAYS", 2);
    ADAPTATION_WORKAROUND_MODE_ALWAYS = localAdaptationWorkaroundMode3;
    $VALUES = new AdaptationWorkaroundMode[] { localAdaptationWorkaroundMode1, localAdaptationWorkaroundMode2, localAdaptationWorkaroundMode3 };
  }
  
  private ReuseHelper$AdaptationWorkaroundMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.reuse.ReuseHelper.AdaptationWorkaroundMode
 * JD-Core Version:    0.7.0.1
 */