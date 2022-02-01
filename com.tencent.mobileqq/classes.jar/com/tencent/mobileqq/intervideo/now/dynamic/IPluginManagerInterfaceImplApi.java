package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPluginManagerInterfaceImplApi
  extends QRouteApi
{
  public abstract IPluginManagerInterfaceImpl getInstance();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.IPluginManagerInterfaceImplApi
 * JD-Core Version:    0.7.0.1
 */