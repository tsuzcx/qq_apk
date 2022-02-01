package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;

public class ImageParams$ImageTrackPair
{
  private CIImage a;
  private final TAVVideoCompositionTrack b;
  
  public ImageParams$ImageTrackPair(CIImage paramCIImage, TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    this.a = paramCIImage;
    this.b = paramTAVVideoCompositionTrack;
  }
  
  public TAVVideoCompositionTrack a()
  {
    return this.b;
  }
  
  public void a(CIImage paramCIImage)
  {
    this.a = paramCIImage;
  }
  
  public CIImage b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.ImageParams.ImageTrackPair
 * JD-Core Version:    0.7.0.1
 */