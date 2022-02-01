package com.tencent.qapmsdk.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadManager.Companion;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/network/NetworkWatcher;", "", "()V", "ACTION_CONN_CHANGE", "", "TAG", "apn", "Lcom/tencent/qapmsdk/common/network/Apn;", "getApn", "()Lcom/tencent/qapmsdk/common/network/Apn;", "setApn", "(Lcom/tencent/qapmsdk/common/network/Apn;)V", "carrier", "carrierInterval", "", "ctx", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "isInited", "", "isNetMonitor", "()Z", "setNetMonitor", "(Z)V", "isWifiAvailable", "setWifiAvailable", "lastCarrierTime", "", "netStatusReceive", "com/tencent/qapmsdk/common/network/NetworkWatcher$netStatusReceive$1", "Lcom/tencent/qapmsdk/common/network/NetworkWatcher$netStatusReceive$1;", "activeNetworkCarrier", "checkConnInfo", "", "getNetworkState", "Lcom/tencent/qapmsdk/common/network/NetworkState;", "getOperatorName", "init", "context", "resetApn", "unInit", "common_release"}, k=1, mv={1, 1, 15})
public final class NetworkWatcher
{
  private static final String ACTION_CONN_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
  public static final NetworkWatcher INSTANCE = new NetworkWatcher();
  private static final String TAG = "QAPM_common_NetworkWatcher";
  @NotNull
  private static volatile Apn apn = Apn.TYPE_INIT;
  private static String carrier = "00000";
  private static final int carrierInterval = 120000;
  private static WeakReference<Context> ctx;
  private static Handler handler;
  private static volatile boolean isInited;
  private static volatile boolean isNetMonitor;
  private static volatile boolean isWifiAvailable;
  private static long lastCarrierTime;
  private static final NetworkWatcher.netStatusReceive.1 netStatusReceive = new NetworkWatcher.netStatusReceive.1();
  
  private final void checkConnInfo()
  {
    resetApn();
    Apn localApn = getApn();
    int i = NetworkWatcher.WhenMappings.$EnumSwitchMapping$0[localApn.ordinal()];
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    isWifiAvailable = bool;
  }
  
  private final void resetApn()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = getOperatorName();
        localObject2 = getNetworkState();
        int i;
        if (localObject1 != null)
        {
          i = ((String)localObject1).hashCode();
          if (i != 618558396)
          {
            if (i != 618596989)
            {
              if ((i == 618663094) && (((String)localObject1).equals("中国联通")))
              {
                i = NetworkWatcher.WhenMappings.$EnumSwitchMapping$3[localObject2.ordinal()];
                if (i != 1)
                {
                  if (i != 2)
                  {
                    localObject1 = Apn.T_APN_WONET;
                    break label302;
                  }
                  localObject1 = Apn.T_APN_3GNET;
                  break label302;
                }
                localObject1 = Apn.T_APN_UNINET;
                break label302;
              }
            }
            else if (((String)localObject1).equals("中国移动"))
            {
              i = NetworkWatcher.WhenMappings.$EnumSwitchMapping$1[localObject2.ordinal()];
              if (i != 1)
              {
                if (i != 2)
                {
                  localObject1 = Apn.T_APN_CMLTE;
                  break label302;
                }
                localObject1 = Apn.T_APN_CM3G;
                break label302;
              }
              localObject1 = Apn.T_APN_CMNET;
              break label302;
            }
          }
          else if (((String)localObject1).equals("中国电信"))
          {
            i = NetworkWatcher.WhenMappings.$EnumSwitchMapping$2[localObject2.ordinal()];
            if (i != 1)
            {
              if (i != 2)
              {
                localObject1 = Apn.T_APN_CTLTE;
                break label302;
              }
              localObject1 = Apn.T_APN_CTNET;
              break label302;
            }
            localObject1 = Apn.TYPE_UNKNOWN;
            break label302;
          }
          localObject1 = Apn.TYPE_NET;
        }
        else
        {
          localObject1 = Apn.TYPE_NET;
          apn = (Apn)localObject1;
          i = NetworkWatcher.WhenMappings.$EnumSwitchMapping$4[localObject2.ordinal()];
          if (i != 1)
          {
            if (i != 2) {
              localObject1 = getApn();
            } else {
              localObject1 = Apn.TYPE_UNKNOWN;
            }
          }
          else {
            localObject1 = Apn.TYPE_WIFI;
          }
          apn = (Apn)localObject1;
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = Logger.INSTANCE;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localException);
        localStringBuilder.append(": cannot get apn from network state, so use default");
        ((Logger)localObject2).w(new String[] { "QAPM_common_NetworkWatcher", localStringBuilder.toString() });
        apn = Apn.TYPE_UNKNOWN;
        return;
      }
      label302:
      if (localException == null) {}
    }
  }
  
  @NotNull
  public final String activeNetworkCarrier()
  {
    boolean bool = Intrinsics.areEqual(carrier, "00000");
    int j = 1;
    if (((bool ^ true)) && (System.currentTimeMillis() - lastCarrierTime < 120000)) {
      return carrier;
    }
    lastCarrierTime = System.currentTimeMillis();
    Object localObject1 = ctx;
    if (localObject1 != null)
    {
      localObject1 = (Context)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        localObject1 = ((Context)localObject1).getSystemService("phone");
        break label81;
      }
    }
    localObject1 = null;
    label81:
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof TelephonyManager)) {
      localObject2 = null;
    }
    localObject1 = (TelephonyManager)localObject2;
    if (localObject1 != null) {
      localObject1 = ((TelephonyManager)localObject1).getSimOperator();
    } else {
      localObject1 = null;
    }
    localObject2 = (CharSequence)localObject1;
    int i = j;
    if (localObject2 != null) {
      if (((CharSequence)localObject2).length() == 0) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0) {
      localObject1 = "00000";
    }
    carrier = (String)localObject1;
    return carrier;
  }
  
  @NotNull
  public final Apn getApn()
  {
    if (apn == Apn.TYPE_INIT) {
      resetApn();
    }
    return apn;
  }
  
  @NotNull
  public final NetworkState getNetworkState()
  {
    Object localObject1 = ctx;
    Object localObject3 = null;
    if (localObject1 != null)
    {
      localObject1 = (Context)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        localObject1 = ((Context)localObject1).getSystemService("connectivity");
        break label36;
      }
    }
    localObject1 = null;
    label36:
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
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject1).getNetworkInfo(localObject2[i]);
            if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1) && ((localNetworkInfo.getState() == NetworkInfo.State.CONNECTED) || (localNetworkInfo.getState() == NetworkInfo.State.CONNECTING))) {
              return NetworkState.NETWORK_WIFI;
            }
            i += 1;
          }
        }
        localObject1 = ctx;
        if (localObject1 != null)
        {
          localObject1 = (Context)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            localObject1 = ((Context)localObject1).getSystemService("phone");
            break label216;
          }
        }
        localObject1 = null;
        label216:
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
  
  @Nullable
  public final String getOperatorName()
  {
    Object localObject1 = ctx;
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
  
  public final void init(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      if (!isInited)
      {
        paramContext = new WeakReference(paramContext);
        Context localContext = (Context)paramContext.get();
        if (localContext != null) {
          localContext.registerReceiver((BroadcastReceiver)netStatusReceive, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        ctx = paramContext;
        handler = new Handler(ThreadManager.Companion.getReporterThreadLooper());
        isInited = true;
        INSTANCE.checkConnInfo();
      }
      paramContext = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  public final boolean isNetMonitor()
  {
    return isNetMonitor;
  }
  
  public final boolean isWifiAvailable()
  {
    return (isWifiAvailable) || (isNetMonitor);
  }
  
  public final void setApn(@NotNull Apn paramApn)
  {
    Intrinsics.checkParameterIsNotNull(paramApn, "<set-?>");
    apn = paramApn;
  }
  
  public final void setNetMonitor(boolean paramBoolean)
  {
    isNetMonitor = paramBoolean;
  }
  
  public final void setWifiAvailable(boolean paramBoolean)
  {
    isWifiAvailable = paramBoolean;
  }
  
  public final void unInit()
  {
    try
    {
      if (isInited)
      {
        localObject1 = ctx;
        if (localObject1 != null)
        {
          localObject1 = (Context)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((Context)localObject1).unregisterReceiver((BroadcastReceiver)netStatusReceive);
          }
        }
        isInited = false;
      }
      Object localObject1 = Unit.INSTANCE;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.network.NetworkWatcher
 * JD-Core Version:    0.7.0.1
 */