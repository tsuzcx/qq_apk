package com.tencent.thumbplayer.core.downloadproxy.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class WifiManagerDelegate
{
  private final Context mContext;
  private boolean mHasWifiPermission;
  private boolean mHasWifiPermissionComputed;
  private final Object mLock = new Object();
  private WifiManager mWifiManager;
  
  WifiManagerDelegate(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private WifiInfo getWifiInfoLocked()
  {
    try
    {
      localWifiInfo = this.mWifiManager.getConnectionInfo();
      return localWifiInfo;
    }
    catch (NullPointerException localNullPointerException1)
    {
      WifiInfo localWifiInfo;
      label10:
      label20:
      break label10;
    }
    try
    {
      localWifiInfo = this.mWifiManager.getConnectionInfo();
      return localWifiInfo;
    }
    catch (NullPointerException localNullPointerException2)
    {
      break label20;
    }
    return null;
  }
  
  @SuppressLint({"WifiManagerPotentialLeak"})
  private boolean hasPermissionLocked()
  {
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
          bool = true;
          this.mHasWifiPermission = bool;
          if (!this.mHasWifiPermission) {
            break label107;
          }
          WifiManager localWifiManager = (WifiManager)this.mContext.getSystemService("wifi");
          this.mWifiManager = localWifiManager;
          this.mHasWifiPermissionComputed = true;
          bool = this.mHasWifiPermission;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label107:
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
      return NetworkChangeNotifier.getWifiSSID();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.WifiManagerDelegate
 * JD-Core Version:    0.7.0.1
 */