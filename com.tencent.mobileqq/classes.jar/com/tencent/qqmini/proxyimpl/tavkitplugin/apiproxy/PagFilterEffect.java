package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavsticker.model.TAVSticker;

public class PagFilterEffect
  extends BaseEffectNode
{
  private final String a;
  private final TAVSticker b;
  
  PagFilterEffect(TAVSticker paramTAVSticker)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PagFilterEffect@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.a = localStringBuilder.toString();
    this.b = paramTAVSticker;
  }
  
  public BaseEffectNode.Filter a()
  {
    return new PagFilterEffect.MyFilter(this.b);
  }
  
  public String getReportKey()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagFilterEffect
 * JD-Core Version:    0.7.0.1
 */