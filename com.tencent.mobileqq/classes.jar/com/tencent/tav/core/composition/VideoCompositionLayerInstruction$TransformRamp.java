package com.tencent.tav.core.composition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Transform;

public class VideoCompositionLayerInstruction$TransformRamp
{
  @NonNull
  public boolean available = true;
  @Nullable
  public Transform endTransform;
  @Nullable
  public Transform startTransform;
  @NonNull
  public CMTimeRange timeRange;
  
  public VideoCompositionLayerInstruction$TransformRamp(@NonNull CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoCompositionLayerInstruction.TransformRamp
 * JD-Core Version:    0.7.0.1
 */