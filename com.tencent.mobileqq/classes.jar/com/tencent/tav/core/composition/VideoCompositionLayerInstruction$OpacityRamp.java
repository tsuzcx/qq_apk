package com.tencent.tav.core.composition;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTimeRange;

public class VideoCompositionLayerInstruction$OpacityRamp
{
  @NonNull
  public boolean available = true;
  public float endOpacity = 1.0F;
  public float startOpacity = 1.0F;
  @NonNull
  public CMTimeRange timeRange;
  
  public VideoCompositionLayerInstruction$OpacityRamp(@NonNull CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoCompositionLayerInstruction.OpacityRamp
 * JD-Core Version:    0.7.0.1
 */