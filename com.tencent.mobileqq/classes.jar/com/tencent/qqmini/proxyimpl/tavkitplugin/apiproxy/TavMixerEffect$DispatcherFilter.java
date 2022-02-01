package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.PointF;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TavMixerEffect$DispatcherFilter
  implements TAVVideoMixEffect.Filter
{
  final ImageParams a = new ImageParams();
  final List<BaseEffectNode.Filter> b = new ArrayList();
  final List<BaseEffectNode.Filter> c;
  BaseEffectNode.Filter d;
  
  TavMixerEffect$DispatcherFilter(TavMixerEffect paramTavMixerEffect)
  {
    Iterator localIterator;
    BaseEffectNode localBaseEffectNode;
    if (TavMixerEffect.a(paramTavMixerEffect) != null)
    {
      localIterator = TavMixerEffect.a(paramTavMixerEffect).iterator();
      while (localIterator.hasNext())
      {
        localBaseEffectNode = (BaseEffectNode)localIterator.next();
        this.b.add(localBaseEffectNode.a());
      }
    }
    this.c = new ArrayList();
    if (TavMixerEffect.b(paramTavMixerEffect) != null)
    {
      localIterator = TavMixerEffect.b(paramTavMixerEffect).iterator();
      while (localIterator.hasNext())
      {
        localBaseEffectNode = (BaseEffectNode)localIterator.next();
        this.c.add(localBaseEffectNode.a());
      }
    }
    if (TavMixerEffect.c(paramTavMixerEffect) != null) {
      this.d = TavMixerEffect.c(paramTavMixerEffect).a();
    }
  }
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    this.a.a.clear();
    paramTAVVideoMixEffect = paramImageCollection.getVideoChannelImages().iterator();
    while (paramTAVVideoMixEffect.hasNext())
    {
      ImageCollection.TrackImagePair localTrackImagePair = (ImageCollection.TrackImagePair)paramTAVVideoMixEffect.next();
      this.a.a.add(new ImageParams.ImageTrackPair(localTrackImagePair.getImage(), localTrackImagePair.getTrack()));
    }
    paramTAVVideoMixEffect = paramImageCollection.getOverlayImages().iterator();
    while (paramTAVVideoMixEffect.hasNext())
    {
      paramImageCollection = (ImageCollection.TrackImagePair)paramTAVVideoMixEffect.next();
      this.a.a.add(new ImageParams.ImageTrackPair(paramImageCollection.getImage(), paramImageCollection.getTrack()));
    }
    paramTAVVideoMixEffect = this.c.iterator();
    while (paramTAVVideoMixEffect.hasNext()) {
      ((BaseEffectNode.Filter)paramTAVVideoMixEffect.next()).a(this.a, paramRenderInfo);
    }
    paramTAVVideoMixEffect = this.d;
    if (paramTAVVideoMixEffect != null) {
      paramTAVVideoMixEffect.a(this.a, paramRenderInfo);
    }
    paramTAVVideoMixEffect = this.b.iterator();
    while (paramTAVVideoMixEffect.hasNext()) {
      ((BaseEffectNode.Filter)paramTAVVideoMixEffect.next()).a(this.a, paramRenderInfo);
    }
    if (this.a.a.size() > 0) {
      return ((ImageParams.ImageTrackPair)this.a.a.get(0)).b().imageApplyFillInFrame(new CGRect(new PointF(), paramRenderInfo.getRenderSize()), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit);
    }
    return null;
  }
  
  public void release()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseEffectNode.Filter)localIterator.next()).a();
    }
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavMixerEffect.DispatcherFilter
 * JD-Core Version:    0.7.0.1
 */