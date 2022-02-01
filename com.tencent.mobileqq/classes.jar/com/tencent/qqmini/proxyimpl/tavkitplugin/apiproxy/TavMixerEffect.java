package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.support.annotation.Nullable;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import java.util.List;

class TavMixerEffect
  implements TAVVideoMixEffect
{
  private PagMixerEffect jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyPagMixerEffect;
  private List<BaseEffectNode> jdField_a_of_type_JavaUtilList;
  private List<BaseEffectNode> b;
  
  PagMixerEffect a()
  {
    return this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyPagMixerEffect;
  }
  
  List<BaseEffectNode> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  void a(PagMixerEffect paramPagMixerEffect)
  {
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyPagMixerEffect = paramPagMixerEffect;
  }
  
  void a(List<BaseEffectNode> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public List<BaseEffectNode> b()
  {
    return this.b;
  }
  
  public void b(List<BaseEffectNode> paramList)
  {
    this.b = paramList;
  }
  
  public TAVVideoMixEffect.Filter createFilter()
  {
    return new TavMixerEffect.DispatcherFilter(this);
  }
  
  @Nullable
  public String effectId()
  {
    return "MixEffect" + Integer.toHexString(hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavMixerEffect
 * JD-Core Version:    0.7.0.1
 */