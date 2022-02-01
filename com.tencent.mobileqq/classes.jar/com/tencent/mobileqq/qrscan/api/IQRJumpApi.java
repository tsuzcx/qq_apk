package com.tencent.mobileqq.qrscan.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.QRActionEntity;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQRJumpApi
  extends QRouteApi
{
  public abstract void displayQRCard(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, int paramInt);
  
  public abstract Class<?> getScannerActivityCls();
  
  public abstract int handleResult(AppRuntime paramAppRuntime, Activity paramActivity, QRActionEntity paramQRActionEntity, String paramString, Bundle paramBundle);
  
  public abstract void startQRJumpActivity(Context paramContext, String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IQRJumpApi
 * JD-Core Version:    0.7.0.1
 */