package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

final class j
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceConnected " + PluginManagerHelper.a().size());
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder alive");
      }
      PluginManagerHelper.a(new PluginManagerClient(RemotePluginManager.Stub.asInterface(paramIBinder)));
      PluginManagerHelper.b().setListener(PluginManagerHelper.d());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "binder not alive");
    }
    paramComponentName = ((ArrayList)PluginManagerHelper.a().clone()).iterator();
    while (paramComponentName.hasNext())
    {
      paramIBinder = (WeakReference)paramComponentName.next();
      if (paramIBinder != null)
      {
        paramIBinder = (PluginManagerHelper.OnPluginManagerLoadedListener)paramIBinder.get();
        if (paramIBinder != null) {
          paramIBinder.onPluginManagerLoaded(null);
        }
      }
    }
    PluginManagerHelper.c();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.i("plugin_tag", 1, "onServiceDisconnected" + paramComponentName);
    paramComponentName = ((ArrayList)PluginManagerHelper.a().clone()).iterator();
    while (paramComponentName.hasNext())
    {
      Object localObject = (WeakReference)paramComponentName.next();
      if (localObject != null)
      {
        localObject = (PluginManagerHelper.OnPluginManagerLoadedListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((PluginManagerHelper.OnPluginManagerLoadedListener)localObject).onPluginManagerLoaded(null);
        }
      }
    }
    PluginManagerHelper.c();
    if (PluginManagerHelper.b() != null)
    {
      PluginManagerHelper.b().destory();
      PluginManagerHelper.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.j
 * JD-Core Version:    0.7.0.1
 */