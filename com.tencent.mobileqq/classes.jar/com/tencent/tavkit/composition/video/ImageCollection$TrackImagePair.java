package com.tencent.tavkit.composition.video;

import android.support.annotation.NonNull;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;

public class ImageCollection$TrackImagePair
{
  @NonNull
  private CIImage image;
  @NonNull
  private TAVVideoCompositionTrack track;
  
  public ImageCollection$TrackImagePair(@NonNull CIImage paramCIImage, @NonNull TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
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
  
  public void setImage(@NonNull CIImage paramCIImage)
  {
    this.image = paramCIImage;
  }
  
  public void setTrack(@NonNull TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    this.track = paramTAVVideoCompositionTrack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair
 * JD-Core Version:    0.7.0.1
 */