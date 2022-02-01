package com.tencent.mobileqq.qqexpand.plugin.preload;

import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExpandPluginPreloadManager
  implements IBackgroundListener
{
  public final AtomicBoolean a = new AtomicBoolean(false);
  private final IGuardInterface b = new BackgroundListenerAdapter(this);
  private boolean c = false;
  
  public void a()
  {
    GuardManager localGuardManager = GuardManager.sInstance;
    if (localGuardManager == null)
    {
      QLog.e("ExpandPluginPreloadManager", 1, "start() error, guardManager is null");
      return;
    }
    if (this.a.compareAndSet(false, true)) {
      localGuardManager.registerCallBack(this.b);
    }
    QLog.d("ExpandPluginPreloadManager", 1, "start()");
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b()
  {
    GuardManager localGuardManager = GuardManager.sInstance;
    if (localGuardManager == null)
    {
      QLog.e("ExpandPluginPreloadManager", 1, "stop() error, guardManager is null");
      return;
    }
    if (this.a.compareAndSet(true, false)) {
      localGuardManager.unregisterCallback(this.b);
    }
    QLog.d("ExpandPluginPreloadManager", 1, "stop()");
  }
  
  public void c()
  {
    if (!this.c)
    {
      QLog.d("ExpandPluginPreloadManager", 1, "preloadPlugin: pre install is disable");
      return;
    }
    Object localObject = QRoute.plugin("expand");
    if ((localObject != null) && (((IQRoutePlugin)localObject).exist()))
    {
      QRoutePluginInfo localQRoutePluginInfo = ((IQRoutePlugin)localObject).queryPluginInfo();
      if (localQRoutePluginInfo == null)
      {
        QLog.w("ExpandPluginPreloadManager", 1, "preloadPlugin: fail, plugin info not exist!");
        return;
      }
      if (localQRoutePluginInfo.getState() != 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadPlugin: ignore, plugin state is not downloaded! getState: ");
        ((StringBuilder)localObject).append(localQRoutePluginInfo.getState());
        QLog.i("ExpandPluginPreloadManager", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if (((IQRoutePlugin)localObject).isInstalled())
      {
        QLog.i("ExpandPluginPreloadManager", 1, "preloadPlugin: ignore, plugin is already install!");
        return;
      }
      QLog.i("ExpandPluginPreloadManager", 1, "preloadPlugin: start pre install, pluginId: expand");
      ((IQRoutePlugin)localObject).install(new DummyPluginInstallListener(), true);
      return;
    }
    QLog.w("ExpandPluginPreloadManager", 1, "preloadPlugin: fail, plugin not exist!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.preload.ExpandPluginPreloadManager
 * JD-Core Version:    0.7.0.1
 */