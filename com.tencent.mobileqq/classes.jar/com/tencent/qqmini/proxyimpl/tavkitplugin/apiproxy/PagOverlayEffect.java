package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavsticker.model.TAVSticker;
import java.util.List;

public class PagOverlayEffect
  extends BaseEffectNode
{
  private List<TAVSticker> a;
  
  public BaseEffectNode.Filter a()
  {
    return new PagOverlayEffect.MyFilter(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagOverlayEffect
 * JD-Core Version:    0.7.0.1
 */