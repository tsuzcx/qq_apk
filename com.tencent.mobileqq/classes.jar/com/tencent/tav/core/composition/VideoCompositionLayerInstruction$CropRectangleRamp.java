package com.tencent.tav.core.composition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTimeRange;

public class VideoCompositionLayerInstruction$CropRectangleRamp
{
  @NonNull
  public boolean available = true;
  @Nullable
  public CGRect endCropRectangle;
  @Nullable
  public CGRect startCropRectangle;
  @NonNull
  public CMTimeRange timeRange;
  
  public VideoCompositionLayerInstruction$CropRectangleRamp(@NonNull CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoCompositionLayerInstruction.CropRectangleRamp
 * JD-Core Version:    0.7.0.1
 */