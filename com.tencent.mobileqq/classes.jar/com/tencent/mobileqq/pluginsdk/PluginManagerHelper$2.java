package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class PluginManagerHelper$2
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel())
    {
      paramComponentName = new StringBuilder();
      paramComponentName.append("onServiceConnected ");
      paramComponentName.append(PluginManagerHelper.access$000().size());
      QLog.i("plugin_tag", 2, paramComponentName.toString());
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder alive");
      }
      PluginManagerHelper.access$102(new PluginManagerClient(RemotePluginManager.Stub.asInterface(paramIBinder)));
      PluginManagerHelper.access$100().setListener(PluginManagerHelper.access$300());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "binder not alive");
    }
    paramComponentName = new ArrayList(PluginManagerHelper.access$000()).iterator();
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
    PluginManagerHelper.access$200();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onServiceDisconnected");
    ((StringBuilder)localObject).append(paramComponentName);
    QLog.i("plugin_tag", 1, ((StringBuilder)localObject).toString());
    paramComponentName = new ArrayList(PluginManagerHelper.access$000()).iterator();
    while (paramComponentName.hasNext())
    {
      localObject = (WeakReference)paramComponentName.next();
      if (localObject != null)
      {
        localObject = (PluginManagerHelper.OnPluginManagerLoadedListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((PluginManagerHelper.OnPluginManagerLoadedListener)localObject).onPluginManagerLoaded(null);
        }
      }
    }
    PluginManagerHelper.access$200();
    if (PluginManagerHelper.access$100() != null)
    {
      PluginManagerHelper.access$100().destory();
      PluginManagerHelper.access$102(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerHelper.2
 * JD-Core Version:    0.7.0.1
 */