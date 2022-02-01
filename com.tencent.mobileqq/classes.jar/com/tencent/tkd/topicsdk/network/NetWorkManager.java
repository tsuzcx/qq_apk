package com.tencent.tkd.topicsdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.tkd.topicsdk.common.NetWorkStatus;
import com.tencent.tkd.topicsdk.common.NetworkUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/network/NetWorkManager;", "", "()V", "TAG", "", "context", "Landroid/content/Context;", "hasInit", "", "netWorkChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/tkd/topicsdk/network/NetWorkManager$INetWorkChangeListener;", "netWorkStateReceiver", "com/tencent/tkd/topicsdk/network/NetWorkManager$netWorkStateReceiver$1", "Lcom/tencent/tkd/topicsdk/network/NetWorkManager$netWorkStateReceiver$1;", "networkStatus", "Lcom/tencent/tkd/topicsdk/common/NetWorkStatus;", "handleMobileNetEvent", "", "handleNetWorkChangeEvent", "handleNoNetEvent", "handleWifiNetEvent", "init", "onNetMobile2None", "onNetMobile2Wifi", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "registerNetWorkChangeListener", "listener", "release", "unRegisterNetWorkChangeListener", "INetWorkChangeListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class NetWorkManager
{
  public static final NetWorkManager a = new NetWorkManager();
  private static Context b;
  private static NetWorkStatus c = NetWorkStatus.None;
  private static final CopyOnWriteArrayList<NetWorkManager.INetWorkChangeListener> d = new CopyOnWriteArrayList();
  private static boolean e;
  private static final NetWorkManager.netWorkStateReceiver.1 f = new NetWorkManager.netWorkStateReceiver.1();
  
  private final void b()
  {
    NetWorkStatus localNetWorkStatus = c;
    int i = NetWorkManager.WhenMappings.$EnumSwitchMapping$1[localNetWorkStatus.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {}
      }
      else {
        i();
      }
    }
    else {
      h();
    }
    c = NetWorkStatus.None;
  }
  
  private final void b(Context paramContext)
  {
    paramContext = NetworkUtils.a.c(paramContext);
    int i = NetWorkManager.WhenMappings.$EnumSwitchMapping$0[paramContext.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          TLog.b("QBNetWorkManagerAdapter", "the network type is unknown");
          return;
        }
        c();
        return;
      }
      d();
      return;
    }
    b();
  }
  
  private final void c()
  {
    NetWorkStatus localNetWorkStatus = c;
    int i = NetWorkManager.WhenMappings.$EnumSwitchMapping$2[localNetWorkStatus.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {}
      }
      else {
        a();
      }
    }
    else {
      g();
    }
    c = NetWorkStatus.Wifi;
  }
  
  private final void d()
  {
    NetWorkStatus localNetWorkStatus = c;
    int i = NetWorkManager.WhenMappings.$EnumSwitchMapping$3[localNetWorkStatus.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {}
      }
      else {
        e();
      }
    }
    else {
      f();
    }
    c = NetWorkStatus.Mobile;
  }
  
  private final void e()
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      ((NetWorkManager.INetWorkChangeListener)localIterator.next()).b();
    }
  }
  
  private final void f()
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      ((NetWorkManager.INetWorkChangeListener)localIterator.next()).f();
    }
  }
  
  private final void g()
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      ((NetWorkManager.INetWorkChangeListener)localIterator.next()).c();
    }
  }
  
  private final void h()
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      ((NetWorkManager.INetWorkChangeListener)localIterator.next()).d();
    }
  }
  
  private final void i()
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      ((NetWorkManager.INetWorkChangeListener)localIterator.next()).e();
    }
  }
  
  public final void a()
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      ((NetWorkManager.INetWorkChangeListener)localIterator.next()).a();
    }
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (e) {
      return;
    }
    e = false;
    b = paramContext;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver((BroadcastReceiver)f, localIntentFilter);
    c = NetworkUtils.a.c(paramContext);
  }
  
  public final void a(@NotNull NetWorkManager.INetWorkChangeListener paramINetWorkChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramINetWorkChangeListener, "listener");
    d.add(paramINetWorkChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.network.NetWorkManager
 * JD-Core Version:    0.7.0.1
 */