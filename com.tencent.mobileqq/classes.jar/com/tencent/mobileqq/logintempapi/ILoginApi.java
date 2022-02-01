package com.tencent.mobileqq.logintempapi;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;

@QAPI(process={"all"})
public abstract interface ILoginApi
  extends QRouteApi
{
  public abstract int getDevLockStatus(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract Object getFaceBitmap(AppRuntime paramAppRuntime, String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void preloadThirdService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.logintempapi.ILoginApi
 * JD-Core Version:    0.7.0.1
 */