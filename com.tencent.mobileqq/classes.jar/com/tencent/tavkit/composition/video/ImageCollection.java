package com.tencent.tavkit.composition.video;

import android.support.annotation.NonNull;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import java.util.ArrayList;
import java.util.List;

public class ImageCollection
{
  @NonNull
  private final List<ImageCollection.TrackImagePair> overlayImages = new ArrayList();
  @NonNull
  private final List<ImageCollection.TrackImagePair> videoChannelImages = new ArrayList();
  
  public void addChannelImage(CIImage paramCIImage, TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    this.videoChannelImages.add(new ImageCollection.TrackImagePair(paramCIImage, paramTAVVideoCompositionTrack));
  }
  
  public void addOverlayImage(CIImage paramCIImage, TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    this.overlayImages.add(new ImageCollection.TrackImagePair(paramCIImage, paramTAVVideoCompositionTrack));
  }
  
  @NonNull
  public List<ImageCollection.TrackImagePair> getOverlayImages()
  {
    return this.overlayImages;
  }
  
  @NonNull
  public List<ImageCollection.TrackImagePair> getVideoChannelImages()
  {
    return this.videoChannelImages;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageCollection{videoChannelImages=");
    localStringBuilder.append(this.videoChannelImages);
    localStringBuilder.append(", overlayImages=");
    localStringBuilder.append(this.overlayImages);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.ImageCollection
 * JD-Core Version:    0.7.0.1
 */