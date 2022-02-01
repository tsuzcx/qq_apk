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
        if (ConnectivityManager.isNetworkTypeValid(localNetworkInfo.getType())) {
          return localNetworkInfo.getTypeName().toUpperCase();
        }
        return "UNKNOWN";
      }
    }
    catch (Exception localException)
    {
      this.c = true;
      return "UNKNOWN";
    }
    return "NONE";
  }
  
  private void b()
  {
    if (this.a == null) {
      this.a = new NetInfoModule.a(this, null);
    }
    if (!this.a.a()) {}
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.mContext.getGlobalConfigs().getContext().registerReceiver(this.a, localIntentFilter);
      this.a.a(true);
      return;
    }
    catch (Throwable localThrowable) {}
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
      }
      return;
    }
    catch (Throwable localThrowable) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.netinfo.NetInfoModule
 * JD-Core Version:    0.7.0.1
 */