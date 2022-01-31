package com.tencent.tavkit.composition.video;

import android.support.annotation.NonNull;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;

public class ImageCollection$TrackImagePair
{
  @NonNull
  private final CIImage image;
  @NonNull
  private final TAVVideoCompositionTrack track;
  
  ImageCollection$TrackImagePair(@NonNull CIImage paramCIImage, @NonNull TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    this.image = paramCIImage;
    this.track = paramTAVVideoCompositionTrack;
  }
  
  @NonNull
  public CIImage getImage()
  {
    return this.image;
  }
  
  @NonNull
  public TAVVideoCompositionTrack getTrack()
  {
    return this.track;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair
 * JD-Core Version:    0.7.0.1
 */