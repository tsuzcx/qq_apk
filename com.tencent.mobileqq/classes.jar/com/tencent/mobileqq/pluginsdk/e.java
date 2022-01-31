package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class e
  implements ServiceConnection
{
  private void a()
  {
    if (PluginInterfaceHelper.a() != null)
    {
      PluginInterfaceHelper.a().clear();
      PluginInterfaceHelper.a(null);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceConnected");
    }
    if (PluginInterfaceHelper.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      a();
      return;
    }
    paramComponentName = (PluginInterfaceHelper.OnPluginInterfaceLoadedListener)PluginInterfaceHelper.a().get();
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder alive");
      }
      if (PluginInterfaceHelper.b() == null) {
        PluginInterfaceHelper.a(new PluginInterface());
      }
      PluginInterfaceHelper.b().a(paramIBinder);
      if (paramComponentName != null) {
        paramComponentName.onPluginInterfaceLoaded(PluginInterfaceHelper.b());
      }
    }
    for (;;)
    {
      a();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder not alive");
      }
      if (paramComponentName != null) {
        paramComponentName.onPluginInterfaceLoaded(PluginInterfaceHelper.b());
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceDisconnected");
    }
    paramComponentName = PluginInterfaceHelper.b();
    if (paramComponentName != null) {
      paramComponentName.destory();
    }
    PluginInterfaceHelper.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.e
 * JD-Core Version:    0.7.0.1
 */