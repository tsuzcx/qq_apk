package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class PluginInterfaceHelper$1
  implements ServiceConnection
{
  private void clear()
  {
    if (PluginInterfaceHelper.access$000() != null)
    {
      PluginInterfaceHelper.access$000().clear();
      PluginInterfaceHelper.access$002(null);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceConnected");
    }
    if (PluginInterfaceHelper.access$000() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      clear();
      return;
    }
    paramComponentName = (PluginInterfaceHelper.OnPluginInterfaceLoadedListener)PluginInterfaceHelper.access$000().get();
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder alive");
      }
      if (PluginInterfaceHelper.access$100() == null) {
        PluginInterfaceHelper.access$102(new PluginInterface());
      }
      PluginInterfaceHelper.access$100().setBinder(paramIBinder);
      if (paramComponentName != null) {
        paramComponentName.onPluginInterfaceLoaded(PluginInterfaceHelper.access$100());
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder not alive");
      }
      if (paramComponentName != null) {
        paramComponentName.onPluginInterfaceLoaded(PluginInterfaceHelper.access$100());
      }
    }
    clear();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceDisconnected");
    }
    paramComponentName = PluginInterfaceHelper.access$100();
    if (paramComponentName != null) {
      paramComponentName.destory();
    }
    PluginInterfaceHelper.access$102(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.1
 * JD-Core Version:    0.7.0.1
 */