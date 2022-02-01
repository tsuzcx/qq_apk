package com.tencent.mobileqq.vas.onlinestatus.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ICustomOnlineStatusManager
  extends QRouteApi
{
  public static final int REQUEST_CODE_DEVICES = 299;
  
  public abstract boolean featureEnable();
  
  public abstract String getOwnerOnlineStatus();
  
  public abstract void openH5(Activity paramActivity, String paramString);
  
  public abstract void registerChangeWeakListener(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager
 * JD-Core Version:    0.7.0.1
 */