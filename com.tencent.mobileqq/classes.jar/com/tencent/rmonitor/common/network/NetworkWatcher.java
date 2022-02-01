package com.tencent.rmonitor.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.thread.ThreadManager.Companion;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/network/NetworkWatcher;", "", "()V", "ACTION_CONN_CHANGE", "", "TAG", "apn", "Lcom/tencent/rmonitor/common/network/Apn;", "getApn", "()Lcom/tencent/rmonitor/common/network/Apn;", "setApn", "(Lcom/tencent/rmonitor/common/network/Apn;)V", "carrier", "carrierInterval", "", "ctx", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "isInited", "", "isNetMonitor", "()Z", "setNetMonitor", "(Z)V", "isWifiAvailable", "setWifiAvailable", "lastCarrierTime", "", "netStatusReceive", "com/tencent/rmonitor/common/network/NetworkWatcher$netStatusReceive$1", "Lcom/tencent/rmonitor/common/network/NetworkWatcher$netStatusReceive$1;", "activeNetworkCarrier", "checkConnInfo", "", "networkState", "Lcom/tencent/rmonitor/common/network/NetworkState;", "getNetworkState", "getOperatorName", "init", "context", "resetApn", "unInit", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class NetworkWatcher
{
  public static final NetworkWatcher a = new NetworkWatcher();
  private static WeakReference<Context> b;
  private static Handler c;
  private static String d = "00000";
  private static volatile boolean e;
  private static volatile boolean f;
  @NotNull
  private static volatile Apn g = Apn.TYPE_INIT;
  private static volatile boolean h;
  private static final NetworkWatcher.netStatusReceive.1 i = new NetworkWatcher.netStatusReceive.1();
  
  private final Apn a(NetworkState paramNetworkState)
  {
    String str = f();
    if (str != null)
    {
      int j = str.hashCode();
      if (j != 618558396)
      {
        if (j != 618596989)
        {
          if ((j == 618663094) && (str.equals("中国联通")))
          {
            j = NetworkWatcher.WhenMappings.$EnumSwitchMapping$3[paramNetworkState.ordinal()];
            if (j != 1)
            {
              if (j != 2)
              {
                paramNetworkState = Apn.T_APN_WONET;
                break label186;
              }
              paramNetworkState = Apn.T_APN_3GNET;
              break label186;
            }
            paramNetworkState = Apn.T_APN_UNINET;
            break label186;
          }
        }
        else if (str.equals("中国移动"))
        {
          j = NetworkWatcher.WhenMappings.$EnumSwitchMapping$1[paramNetworkState.ordinal()];
          if (j != 1)
          {
            if (j != 2)
            {
              paramNetworkState = Apn.T_APN_CMLTE;
              break label186;
            }
            paramNetworkState = Apn.T_APN_CM3G;
            break label186;
          }
          paramNetworkState = Apn.T_APN_CMNET;
          break label186;
        }
      }
      else if (str.equals("中国电信"))
      {
        j = NetworkWatcher.WhenMappings.$EnumSwitchMapping$2[paramNetworkState.ordinal()];
        if (j != 1)
        {
          if (j != 2)
          {
            paramNetworkState = Apn.T_APN_CTLTE;
            break label186;
          }
          paramNetworkState = Apn.T_APN_CTNET;
          break label186;
        }
        paramNetworkState = Apn.TYPE_UNKNOWN;
        break label186;
      }
      paramNetworkState = Apn.TYPE_NET;
      label186:
      if (paramNetworkState != null) {
        return paramNetworkState;
      }
    }
    return Apn.TYPE_NET;
  }
  
  private final void d()
  {
    e();
    Apn localApn = a();
    int j = NetworkWatcher.WhenMappings.$EnumSwitchMapping$0[localApn.ordinal()];
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    h = bool;
  }
  
  private final void e()
  {
    Apn localApn;
    try
    {
      Object localObject = g();
      int j = NetworkWatcher.WhenMappings.$EnumSwitchMapping$4[localObject.ordinal()];
      if (j != 1)
      {
        if (j != 2) {
          localObject = a((NetworkState)localObject);
        } else {
          localObject = Apn.TYPE_UNKNOWN;
        }
      }
      else {
        localObject = Apn.TYPE_WIFI;
      }
    }
    catch (Exception localException)
    {
      Logger localLogger = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException);
      localStringBuilder.append(": cannot get apn from network state, so use default");
      localLogger.w(new String[] { "RMonitor_common_NetworkWatcher", localStringBuilder.toString() });
      localApn = Apn.TYPE_UNKNOWN;
    }
    g = localApn;
  }
  
  private final String f()
  {
    Object localObject1 = b;
    Object localObject3 = null;
    if (localObject1 != null)
    {
      localObject1 = (Context)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        localObject1 = ((Context)localObject1).getSystemService("phone");
        break label34;
      }
    }
    localObject1 = null;
    label34:
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof TelephonyManager)) {
      localObject2 = null;
    }
    localObject2 = (TelephonyManager)localObject2;
    localObject1 = localObject3;
    if (localObject2 != null) {
      localObject1 = ((TelephonyManager)localObject2).getSimOperatorName();
    }
    return localObject1;
  }
  
  private final NetworkState g()
  {
    Object localObject1 = b;
    Object localObject3 = null;
    if (localObject1 != null)
    {
      localObject1 = (Context)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        localObject1 = ((Context)localObject1).getSystemService("connectivity");
        break label35;
      }
    }
    localObject1 = null;
    label35:
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof ConnectivityManager)) {
      localObject2 = null;
    }
    localObject1 = (ConnectivityManager)localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject2 != null) && (((NetworkInfo)localObject2).isAvailable()))
      {
        if (Build.VERSION.SDK_INT < 21)
        {
          if ((((NetworkInfo)localObject2).isConnectedOrConnecting()) && (((NetworkInfo)localObject2).getType() == 1)) {
            return NetworkState.NETWORK_WIFI;
          }
        }
        else
        {
          localObject2 = ((ConnectivityManager)localObject1).getAllNetworks();
          int k = localObject2.length;
          int j = 0;
          while (j < k)
          {
            NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject1).getNetworkInfo(localObject2[j]);
            if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1) && ((localNetworkInfo.getState() == NetworkInfo.State.CONNECTED) || (localNetworkInfo.getState() == NetworkInfo.State.CONNECTING))) {
              return NetworkState.NETWORK_WIFI;
            }
            j += 1;
          }
        }
        localObject1 = b;
        if (localObject1 != null)
        {
          localObject1 = (Context)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            localObject1 = ((Context)localObject1).getSystemService("phone");
            break label215;
          }
        }
        localObject1 = null;
        label215:
        localObject2 = localObject1;
        if (!(localObject1 instanceof TelephonyManager)) {
          localObject2 = null;
        }
        localObject2 = (TelephonyManager)localObject2;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = Integer.valueOf(((TelephonyManager)localObject2).getNetworkType());
        }
        if (((localObject1 != null) && (((Integer)localObject1).intValue() == 1)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 4)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 2)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 7)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 11))) {
          return NetworkState.NETWORK_2G;
        }
        if (((localObject1 != null) && (((Integer)localObject1).intValue() == 6)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 3)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 5)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 8)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 9)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 10)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 12)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 14)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 15))) {
          return NetworkState.NETWORK_3G;
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() == 13)) {
          return NetworkState.NETWORK_4G;
        }
        return NetworkState.NETWORK_MOBILE;
      }
      return NetworkState.NETWORK_NONE;
    }
    return NetworkState.NETWORK_NONE;
  }
  
  @NotNull
  public final Apn a()
  {
    if (g == Apn.TYPE_INIT) {
      e();
    }
    return g;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      if (!e)
      {
        paramContext = new WeakReference(paramContext);
        try
        {
          Context localContext = (Context)paramContext.get();
          if (localContext != null) {
            localContext.registerReceiver((BroadcastReceiver)i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
          }
        }
        catch (Throwable localThrowable)
        {
          Logger.b.e(new String[] { "RMonitor_common_NetworkWatcher", "unInit, ", localThrowable.toString() });
        }
        b = paramContext;
        c = new Handler(ThreadManager.a.c());
        e = true;
        a.d();
      }
      paramContext = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  public final boolean b()
  {
    return (h) || (f);
  }
  
  public final void c()
  {
    try
    {
      boolean bool = e;
      if (bool)
      {
        try
        {
          Object localObject1 = b;
          if (localObject1 != null)
          {
            localObject1 = (Context)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((Context)localObject1).unregisterReceiver((BroadcastReceiver)i);
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Logger.b.e(new String[] { "RMonitor_common_NetworkWatcher", "unInit, ", localIllegalArgumentException.toString() });
        }
        e = false;
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.network.NetworkWatcher
 * JD-Core Version:    0.7.0.1
 */