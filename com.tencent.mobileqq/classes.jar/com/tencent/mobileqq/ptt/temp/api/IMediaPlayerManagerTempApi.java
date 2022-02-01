package com.tencent.mobileqq.ptt.temp.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IMediaPlayerManagerTempApi
  extends QRouteApi
{
  public abstract void mediaPlayer_doStop(boolean paramBoolean, AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.IMediaPlayerManagerTempApi
 * JD-Core Version:    0.7.0.1
 */