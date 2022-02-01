package com.tencent.tav.core.composition;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;

public abstract interface VideoCompositionLayerInstruction
{
  @NonNull
  public abstract VideoCompositionLayerInstruction.CropRectangleRamp getCropRectangleRampForTime(CMTime paramCMTime);
  
  @NonNull
  public abstract VideoCompositionLayerInstruction.OpacityRamp getOpacityRampForTime(CMTime paramCMTime);
  
  public abstract int getTrackID();
  
  @NonNull
  public abstract VideoCompositionLayerInstruction.TransformRamp getTransformRampForTime(CMTime paramCMTime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoCompositionLayerInstruction
 * JD-Core Version:    0.7.0.1
 */