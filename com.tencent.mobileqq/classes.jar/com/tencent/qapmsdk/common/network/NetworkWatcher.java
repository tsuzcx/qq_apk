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
    switch (NetworkWatcher.WhenMappings.$EnumSwitchMapping$0[localApn.ordinal()])
    {
    }
    for (boolean bool = false;; bool = true)
    {
      isWifiAvailable = bool;
      return;
    }
  }
  
  private final NetworkState getNetworkState()
  {
    Object localObject3 = null;
    Object localObject1 = ctx;
    if (localObject1 != null)
    {
      localObject1 = (Context)((WeakReference)localObject1).get();
      if (localObject1 == null) {}
    }
    Object localObject2;
    for (localObject1 = ((Context)localObject1).getSystemService("connectivity");; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof ConnectivityManager)) {
        localObject2 = null;
      }
      localObject1 = (ConnectivityManager)localObject2;
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject2 != null) && (((NetworkInfo)localObject2).isAvailable())) {
        break label85;
      }
      return NetworkState.NETWORK_NONE;
    }
    return NetworkState.NETWORK_NONE;
    label85:
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
        localObject2 = localObject1;
        if (!(localObject1 instanceof TelephonyManager)) {
          localObject2 = null;
        }
        localObject2 = (TelephonyManager)localObject2;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = Integer.valueOf(((TelephonyManager)localObject2).getNetworkType());
        }
        if (localObject1 != null) {
          break label321;
        }
        label256:
        if (localObject1 != null) {
          break label333;
        }
        if (localObject1 != null) {
          break label344;
        }
        label264:
        if (localObject1 != null) {
          break label355;
        }
        label268:
        if (localObject1 != null) {
          break label367;
        }
        label272:
        if (localObject1 != null) {
          break label379;
        }
        label276:
        if (localObject1 != null) {
          break label392;
        }
        if (localObject1 != null) {
          break label403;
        }
        label284:
        if (localObject1 != null) {
          break label414;
        }
        label288:
        if (localObject1 != null) {
          break label426;
        }
        label292:
        if (localObject1 != null) {
          break label438;
        }
        label296:
        if (localObject1 != null) {
          break label450;
        }
        label300:
        if (localObject1 != null) {
          break label462;
        }
        label304:
        if (localObject1 != null) {
          break label474;
        }
        label308:
        if (localObject1 != null) {
          break label486;
        }
      }
    }
    label321:
    label333:
    label344:
    label355:
    label367:
    label379:
    while (((Integer)localObject1).intValue() != 13)
    {
      return NetworkState.NETWORK_MOBILE;
      localObject1 = null;
      break;
      if (((Integer)localObject1).intValue() != 1) {
        break label256;
      }
      for (;;)
      {
        return NetworkState.NETWORK_2G;
        if (((Integer)localObject1).intValue() != 4) {
          break;
        }
        continue;
        if (((Integer)localObject1).intValue() != 2) {
          break label264;
        }
        continue;
        if (((Integer)localObject1).intValue() != 7) {
          break label268;
        }
        continue;
        if (((Integer)localObject1).intValue() != 11) {
          break label272;
        }
      }
      if (((Integer)localObject1).intValue() != 6) {
        break label276;
      }
      for (;;)
      {
        return NetworkState.NETWORK_3G;
        if (((Integer)localObject1).intValue() != 3) {
          break;
        }
        continue;
        if (((Integer)localObject1).intValue() != 5) {
          break label284;
        }
        continue;
        if (((Integer)localObject1).intValue() != 8) {
          break label288;
        }
        continue;
        if (((Integer)localObject1).intValue() != 9) {
          break label292;
        }
        continue;
        if (((Integer)localObject1).intValue() != 10) {
          break label296;
        }
        continue;
        if (((Integer)localObject1).intValue() != 12) {
          break label300;
        }
        continue;
        if (((Integer)localObject1).intValue() != 14) {
          break label304;
        }
        continue;
        if (((Integer)localObject1).intValue() != 15) {
          break label308;
        }
      }
    }
    label392:
    label403:
    label414:
    label426:
    label438:
    label450:
    label462:
    label474:
    label486:
    return NetworkState.NETWORK_4G;
  }
  
  private final String getOperatorName()
  {
    Object localObject3 = null;
    Object localObject1 = ctx;
    if (localObject1 != null)
    {
      localObject1 = (Context)((WeakReference)localObject1).get();
      if (localObject1 == null) {}
    }
    for (localObject1 = ((Context)localObject1).getSystemService("phone");; localObject1 = null)
    {
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
  }
  
  private final void resetApn()
  {
    for (;;)
    {
      try
      {
        Object localObject = getOperatorName();
        NetworkState localNetworkState = getNetworkState();
        if (localObject != null) {}
        switch (((String)localObject).hashCode())
        {
        case 618596989: 
          localObject = Apn.TYPE_NET;
          break label355;
          apn = (Apn)localObject;
          switch (NetworkWatcher.WhenMappings.$EnumSwitchMapping$4[localNetworkState.ordinal()])
          {
          case 1: 
            localObject = getApn();
            apn = (Apn)localObject;
            return;
            if (!((String)localObject).equals("中国移动")) {
              continue;
            }
            switch (NetworkWatcher.WhenMappings.$EnumSwitchMapping$1[localNetworkState.ordinal()])
            {
            case 1: 
              localObject = Apn.T_APN_CMLTE;
            }
            break;
          }
          break;
        case 618558396: 
          if (!((String)localObject).equals("中国电信")) {
            continue;
          }
          switch (NetworkWatcher.WhenMappings.$EnumSwitchMapping$2[localNetworkState.ordinal()])
          {
          case 1: 
            localObject = Apn.T_APN_CTLTE;
          }
          break;
        case 618663094: 
          if (!((String)localObject).equals("中国联通")) {
            continue;
          }
          switch (NetworkWatcher.WhenMappings.$EnumSwitchMapping$3[localNetworkState.ordinal()])
          {
          case 1: 
            localObject = Apn.T_APN_WONET;
            break;
            localObject = Apn.T_APN_CMNET;
            break;
            localObject = Apn.T_APN_CM3G;
            break;
            localObject = Apn.TYPE_UNKNOWN;
            break;
            localObject = Apn.T_APN_CTNET;
            break;
            localObject = Apn.T_APN_UNINET;
            break;
          case 2: 
            localObject = Apn.T_APN_3GNET;
            break;
            localObject = Apn.TYPE_NET;
            continue;
            localObject = Apn.TYPE_WIFI;
            continue;
            localObject = Apn.TYPE_UNKNOWN;
          }
          break;
        }
        continue;
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_common_NetworkWatcher", localException + ": cannot get apn from network state, so use default" });
        apn = Apn.TYPE_UNKNOWN;
        return;
      }
      label355:
      if (localException != null)
      {
        continue;
        continue;
        continue;
      }
    }
  }
  
  @NotNull
  public final String activeNetworkCarrier()
  {
    Object localObject3 = null;
    if (((Intrinsics.areEqual(carrier, "00000") ^ true)) && (System.currentTimeMillis() - lastCarrierTime < 120000)) {
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
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof TelephonyManager)) {
          localObject2 = null;
        }
        localObject2 = (TelephonyManager)localObject2;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((TelephonyManager)localObject2).getSimOperator();
        }
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label135;
        }
      }
    }
    label135:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localObject1 = "00000";
      }
      carrier = (String)localObject1;
      return carrier;
      localObject1 = null;
      break;
    }
  }
  
  @NotNull
  public final Apn getApn()
  {
    if (apn == Apn.TYPE_INIT) {
      resetApn();
    }
    return apn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.network.NetworkWatcher
 * JD-Core Version:    0.7.0.1
 */