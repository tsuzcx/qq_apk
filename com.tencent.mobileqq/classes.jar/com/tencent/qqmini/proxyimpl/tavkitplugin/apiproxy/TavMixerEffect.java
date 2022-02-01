package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.support.annotation.Nullable;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import java.util.List;

class TavMixerEffect
  implements TAVVideoMixEffect
{
  private PagMixerEffect a;
  private List<BaseEffectNode> b;
  private List<BaseEffectNode> c;
  
  PagMixerEffect a()
  {
    return this.a;
  }
  
  void a(PagMixerEffect paramPagMixerEffect)
  {
    this.a = paramPagMixerEffect;
  }
  
  void a(List<BaseEffectNode> paramList)
  {
    this.b = paramList;
  }
  
  List<BaseEffectNode> b()
  {
    return this.b;
  }
  
  public void b(List<BaseEffectNode> paramList)
  {
    this.c = paramList;
  }
  
  public List<BaseEffectNode> c()
  {
    return this.c;
  }
  
  public TAVVideoMixEffect.Filter createFilter()
  {
    return new TavMixerEffect.DispatcherFilter(this);
  }
  
  @Nullable
  public String effectId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MixEffect");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavMixerEffect
 * JD-Core Version:    0.7.0.1
 */