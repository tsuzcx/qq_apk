package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;

@QAPI(process={"all"})
public abstract interface IDataLocalTmpPmUpdaterFactory
  extends QRouteApi
{
  public abstract PluginManagerUpdater createDataLocalTmpPmUpdater(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IDataLocalTmpPmUpdaterFactory
 * JD-Core Version:    0.7.0.1
 */