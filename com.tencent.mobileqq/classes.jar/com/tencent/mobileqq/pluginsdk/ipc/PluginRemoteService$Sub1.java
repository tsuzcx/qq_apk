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
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "PluginRemoteService$Sub1.onBind. " + i + ", " + Binder.getCallingPid() + ", " + this);
    }
    return PluginCommunicationHandler.getInstance().getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginRemoteService$Sub1.onCreate " + this);
    }
    super.onCreate();
    MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "PluginRemoteService$Sub1.onDestroy. " + this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "PluginRemoteService$Sub1.onUnbind. " + Binder.getCallingPid() + ", " + this);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService.Sub1
 * JD-Core Version:    0.7.0.1
 */