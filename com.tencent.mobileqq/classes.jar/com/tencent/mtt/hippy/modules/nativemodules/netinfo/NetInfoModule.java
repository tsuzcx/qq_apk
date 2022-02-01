package com.tencent.mtt.hippy.modules.nativemodules.netinfo;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;

@HippyNativeModule(name="NetInfo")
public class NetInfoModule
  extends HippyNativeModuleBase
{
  private NetInfoModule.a a;
  private final ConnectivityManager b;
  private boolean c = false;
  
  public NetInfoModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    this.b = ((ConnectivityManager)paramHippyEngineContext.getGlobalConfigs().getContext().getSystemService("connectivity"));
  }
  
  private String a()
  {
    try
    {
      NetworkInfo localNetworkInfo = this.b.getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
      {
        if (!ConnectivityManager.isNetworkTypeValid(localNetworkInfo.getType())) {
          break label55;
        }
        return localNetworkInfo.getTypeName().toUpperCase();
      }
      return "NONE";
    }
    catch (Exception localException)
    {
      label43:
      break label43;
    }
    this.c = true;
    return "UNKNOWN";
    label55:
    return "UNKNOWN";
  }
  
  private void b()
  {
    if (this.a == null) {
      this.a = new NetInfoModule.a(this, null);
    }
    if (!this.a.a()) {
      try
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mContext.getGlobalConfigs().getContext().registerReceiver(this.a, localIntentFilter);
        this.a.a(true);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("registerReceiver: ");
        localStringBuilder.append(localThrowable.getMessage());
        LogUtils.d("NetInfoModule", localStringBuilder.toString());
      }
    }
  }
  
  private void c()
  {
    try
    {
      if ((this.a != null) && (this.a.a()))
      {
        this.mContext.getGlobalConfigs().getContext().unregisterReceiver(this.a);
        this.a.a(false);
        this.a = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregisterReceiver: ");
      localStringBuilder.append(localThrowable.getMessage());
      LogUtils.d("NetInfoModule", localStringBuilder.toString());
    }
  }
  
  public void destroy()
  {
    super.destroy();
    c();
  }
  
  @HippyMethod(name="getCurrentConnectivity")
  public void getCurrentConnectivity(Promise paramPromise)
  {
    if (this.c)
    {
      paramPromise.reject("To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
      return;
    }
    String str = a();
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("network_info", str);
    paramPromise.resolve(localHippyMap);
  }
  
  public void handleAddListener(String paramString)
  {
    b();
  }
  
  public void handleRemoveListener(String paramString)
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.netinfo.NetInfoModule
 * JD-Core Version:    0.7.0.1
 */