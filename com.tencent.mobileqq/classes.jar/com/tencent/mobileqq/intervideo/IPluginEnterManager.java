package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;

@QAPI(process={"all"})
public abstract interface IPluginEnterManager
  extends QRouteApi
{
  public abstract String getLastBizType();
  
  public abstract void switchBiz(String paramString, PluginProcessKiller paramPluginProcessKiller);
  
  public abstract void switchBiz(String paramString, DynamicPluginManager paramDynamicPluginManager);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IPluginEnterManager
 * JD-Core Version:    0.7.0.1
 */