package com.tencent.thumbplayer.core.downloadproxy.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;

public class WifiManagerDelegate
{
  private final Context mContext;
  private boolean mHasWifiPermission;
  private boolean mHasWifiPermissionComputed;
  private final Object mLock = new Object();
  private WifiManager mWifiManager;
  
  static
  {
    if (!WifiManagerDelegate.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  WifiManagerDelegate(Context paramContext)
  {
    assert (Build.VERSION.SDK_INT < 23);
    this.mContext = paramContext;
  }
  
  private WifiInfo getWifiInfoLocked()
  {
    try
    {
      WifiInfo localWifiInfo1 = this.mWifiManager.getConnectionInfo();
      return localWifiInfo1;
    }
    catch (NullPointerException localNullPointerException1)
    {
      try
      {
        WifiInfo localWifiInfo2 = this.mWifiManager.getConnectionInfo();
        return localWifiInfo2;
      }
      catch (NullPointerException localNullPointerException2) {}
    }
    return null;
  }
  
  @SuppressLint({"WifiManagerPotentialLeak"})
  private boolean hasPermissionLocked()
  {
    boolean bool = true;
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mHasWifiPermissionComputed)
        {
          bool = this.mHasWifiPermission;
          return bool;
        }
        if (this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) == 0)
        {
          this.mHasWifiPermission = bool;
          if (!this.mHasWifiPermission) {
            break label101;
          }
          WifiManager localWifiManager = (WifiManager)this.mContext.getSystemService("wifi");
          this.mWifiManager = localWifiManager;
          this.mHasWifiPermissionComputed = true;
          bool = this.mHasWifiPermission;
          return bool;
        }
      }
      bool = false;
      continue;
      label101:
      Object localObject2 = null;
    }
  }
  
  String getWifiSsid()
  {
    synchronized (this.mLock)
    {
      if (hasPermissionLocked())
      {
        Object localObject2 = getWifiInfoLocked();
        if (localObject2 != null)
        {
          localObject2 = ((WifiInfo)localObject2).getSSID();
          return localObject2;
        }
        return "";
      }
    }
    return NetworkChangeNotifier.getWifiSSID();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.WifiManagerDelegate
 * JD-Core Version:    0.7.0.1
 */