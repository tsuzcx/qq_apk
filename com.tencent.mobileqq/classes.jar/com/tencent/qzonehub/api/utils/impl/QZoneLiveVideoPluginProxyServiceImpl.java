package com.tencent.qzonehub.api.utils.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.qzonehub.api.utils.IQZoneLiveVideoPluginProxyService;
import cooperation.qzone.video.QZoneLiveVideoPluginProxyBroadcastReceiver;
import cooperation.qzone.video.QZoneLiveVideoPluginProxyService;

public class QZoneLiveVideoPluginProxyServiceImpl
  implements IQZoneLiveVideoPluginProxyService
{
  public void bindService(Context paramContext, String paramString1, Intent paramIntent, ServiceConnection paramServiceConnection, String paramString2)
  {
    QZoneLiveVideoPluginProxyService.bindService(paramContext, paramString1, paramIntent, paramServiceConnection, paramString2);
  }
  
  public Intent getQZoneLiveVideoPluginProxyServiceIntent(Context paramContext)
  {
    return new Intent(paramContext, QZoneLiveVideoPluginProxyService.class);
  }
  
  public void sendBroadcast(Context paramContext, String paramString1, Intent paramIntent, String paramString2)
  {
    QZoneLiveVideoPluginProxyBroadcastReceiver.sendBroadcast(paramContext, paramString1, paramIntent, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.impl.QZoneLiveVideoPluginProxyServiceImpl
 * JD-Core Version:    0.7.0.1
 */