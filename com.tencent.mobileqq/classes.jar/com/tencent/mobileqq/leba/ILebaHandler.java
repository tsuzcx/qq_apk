package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ILebaHandler
  extends QRouteApi
{
  public abstract String getCommPluginHandlerClassName();
  
  public abstract String getLebaSettingHandlerClassName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.ILebaHandler
 * JD-Core Version:    0.7.0.1
 */