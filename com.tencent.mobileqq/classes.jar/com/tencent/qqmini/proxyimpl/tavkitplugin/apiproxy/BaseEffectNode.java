package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavkit.report.IReportable;

public abstract class BaseEffectNode
  implements IReportable
{
  private int a = -1;
  
  public abstract BaseEffectNode.Filter a();
  
  public String getReportKey()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.BaseEffectNode
 * JD-Core Version:    0.7.0.1
 */