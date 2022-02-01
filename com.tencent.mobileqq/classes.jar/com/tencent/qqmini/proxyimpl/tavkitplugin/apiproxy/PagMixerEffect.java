package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavsticker.model.TAVSticker;
import java.util.List;

public class PagMixerEffect
  extends BaseEffectNode
{
  private List<TAVSticker> a;
  
  public BaseEffectNode.Filter a()
  {
    return new PagMixerEffect.MyFilter(this.a);
  }
  
  public List<TAVSticker> a()
  {
    return this.a;
  }
  
  public void a(List<TAVSticker> paramList)
  {
    this.a = paramList;
  }
  
  public String getReportKey()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagMixerEffect
 * JD-Core Version:    0.7.0.1
 */