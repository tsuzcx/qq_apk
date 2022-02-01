package com.tencent.mobileqq.writetogether.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IWTStartup
  extends QRouteApi
{
  public abstract void launchEditor(Context paramContext, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void launchWriteTogetherEditor(AppRuntime paramAppRuntime, Context paramContext, Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.IWTStartup
 * JD-Core Version:    0.7.0.1
 */