package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavkit.ciimage.CIImage;
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
  BaseEffectNode.Filter jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyBaseEffectNode$Filter;
  final ImageParams jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyImageParams = new ImageParams();
  final List<BaseEffectNode.Filter> jdField_a_of_type_JavaUtilList = new ArrayList();
  final List<BaseEffectNode.Filter> b;
  
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
        this.jdField_a_of_type_JavaUtilList.add(localBaseEffectNode.a());
      }
    }
    this.b = new ArrayList();
    if (TavMixerEffect.b(paramTavMixerEffect) != null)
    {
      localIterator = TavMixerEffect.b(paramTavMixerEffect).iterator();
      while (localIterator.hasNext())
      {
        localBaseEffectNode = (BaseEffectNode)localIterator.next();
        this.b.add(localBaseEffectNode.a());
      }
    }
    if (TavMixerEffect.a(paramTavMixerEffect) != null) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyBaseEffectNode$Filter = TavMixerEffect.a(paramTavMixerEffect).a();
    }
  }
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyImageParams.jdField_a_of_type_JavaUtilList.clear();
    paramTAVVideoMixEffect = paramImageCollection.getVideoChannelImages().iterator();
    while (paramTAVVideoMixEffect.hasNext())
    {
      ImageCollection.TrackImagePair localTrackImagePair = (ImageCollection.TrackImagePair)paramTAVVideoMixEffect.next();
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyImageParams.jdField_a_of_type_JavaUtilList.add(new ImageParams.ImageTrackPair(localTrackImagePair.getImage(), localTrackImagePair.getTrack()));
    }
    paramTAVVideoMixEffect = paramImageCollection.getOverlayImages().iterator();
    while (paramTAVVideoMixEffect.hasNext())
    {
      paramImageCollection = (ImageCollection.TrackImagePair)paramTAVVideoMixEffect.next();
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyImageParams.jdField_a_of_type_JavaUtilList.add(new ImageParams.ImageTrackPair(paramImageCollection.getImage(), paramImageCollection.getTrack()));
    }
    paramTAVVideoMixEffect = this.b.iterator();
    while (paramTAVVideoMixEffect.hasNext()) {
      ((BaseEffectNode.Filter)paramTAVVideoMixEffect.next()).a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyImageParams, paramRenderInfo);
    }
    if (this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyBaseEffectNode$Filter != null) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyBaseEffectNode$Filter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyImageParams, paramRenderInfo);
    }
    paramTAVVideoMixEffect = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramTAVVideoMixEffect.hasNext()) {
      ((BaseEffectNode.Filter)paramTAVVideoMixEffect.next()).a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyImageParams, paramRenderInfo);
    }
    if (this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyImageParams.jdField_a_of_type_JavaUtilList.size() > 0) {
      return ((ImageParams.ImageTrackPair)this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyImageParams.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
    return null;
  }
  
  public void release()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseEffectNode.Filter)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavMixerEffect.DispatcherFilter
 * JD-Core Version:    0.7.0.1
 */