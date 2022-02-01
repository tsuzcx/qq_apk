package com.tencent.mobileqq.writetogether.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IWriteTogetherConfig
  extends QRouteApi
{
  public abstract boolean isAllowShowEntrance(AppRuntime paramAppRuntime, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.IWriteTogetherConfig
 * JD-Core Version:    0.7.0.1
 */