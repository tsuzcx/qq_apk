package com.tencent.qzonehub.api.utils;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQZoneLiveVideoPluginProxyService
  extends QRouteApi
{
  public static final String PRELOAD_ACTION = "com.qzone.preloadLiveVideo";
  
  public abstract void bindService(Context paramContext, String paramString1, Intent paramIntent, ServiceConnection paramServiceConnection, String paramString2);
  
  public abstract Intent getQZoneLiveVideoPluginProxyServiceIntent(Context paramContext);
  
  public abstract void sendBroadcast(Context paramContext, String paramString1, Intent paramIntent, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.IQZoneLiveVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */