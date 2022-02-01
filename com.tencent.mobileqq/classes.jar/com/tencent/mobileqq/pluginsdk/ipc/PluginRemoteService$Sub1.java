package com.tencent.mobileqq.pluginsdk.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class PluginRemoteService$Sub1
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_binder_type", -1);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("PluginRemoteService$Sub1.onBind. ");
      paramIntent.append(i);
      paramIntent.append(", ");
      paramIntent.append(Binder.getCallingPid());
      paramIntent.append(", ");
      paramIntent.append(this);
      QLog.d("plugin_tag", 2, paramIntent.toString());
    }
    return PluginCommunicationHandler.getInstance().getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PluginRemoteService$Sub1.onCreate ");
      localStringBuilder.append(this);
      QLog.i("plugin_tag", 2, localStringBuilder.toString());
    }
    super.onCreate();
    MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PluginRemoteService$Sub1.onDestroy. ");
      localStringBuilder.append(this);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PluginRemoteService$Sub1.onUnbind. ");
      localStringBuilder.append(Binder.getCallingPid());
      localStringBuilder.append(", ");
      localStringBuilder.append(this);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService.Sub1
 * JD-Core Version:    0.7.0.1
 */