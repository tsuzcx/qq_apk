package com.tencent.tavkit.composition.video;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import java.util.Iterator;
import java.util.List;

class DefaultVideoMixFilter
  implements TAVVideoMixEffect.Filter
{
  private void checkFillInRenderSize(RenderInfo paramRenderInfo, ImageCollection.TrackImagePair paramTrackImagePair, CIImage paramCIImage)
  {
    if (!(paramTrackImagePair.getTrack() instanceof TAVClip)) {}
    do
    {
      return;
      paramTrackImagePair = ((TAVClip)paramTrackImagePair.getTrack()).getVideoConfiguration();
    } while (paramTrackImagePair.frameEnable());
    paramCIImage.applyFillInFrame(new CGRect(new PointF(0.0F, 0.0F), paramRenderInfo.getRenderSize()), paramTrackImagePair.getContentMode());
  }
  
  @NonNull
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    paramTAVVideoMixEffect = new CIImage(paramRenderInfo.getRenderSize());
    Object localObject1 = paramImageCollection.getVideoChannelImages().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ImageCollection.TrackImagePair)((Iterator)localObject1).next();
      CIImage localCIImage = ((ImageCollection.TrackImagePair)localObject2).getImage();
      checkFillInRenderSize(paramRenderInfo, (ImageCollection.TrackImagePair)localObject2, localCIImage);
      localCIImage.imageByCompositingOverImage(paramTAVVideoMixEffect);
    }
    paramImageCollection = paramImageCollection.getOverlayImages().iterator();
    while (paramImageCollection.hasNext())
    {
      localObject1 = (ImageCollection.TrackImagePair)paramImageCollection.next();
      localObject2 = ((ImageCollection.TrackImagePair)localObject1).getImage();
      checkFillInRenderSize(paramRenderInfo, (ImageCollection.TrackImagePair)localObject1, (CIImage)localObject2);
      ((CIImage)localObject2).imageByCompositingOverImage(paramTAVVideoMixEffect);
    }
    return paramTAVVideoMixEffect;
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.DefaultVideoMixFilter
 * JD-Core Version:    0.7.0.1
 */