package com.tencent.qqmini.sdk.core.plugins;

import bgnk;
import bgnm;

class WifiJsPlugin$3
  implements bgnm
{
  WifiJsPlugin$3(WifiJsPlugin paramWifiJsPlugin, WifiJsPlugin.LocationPermissionListener paramLocationPermissionListener) {}
  
  public boolean doOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = false;
    if (paramInt != 9528) {}
    do
    {
      return false;
      bgnk.a().b(this);
    } while ((paramArrayOfString == null) || (paramArrayOfString.length == 0));
    if ("android.permission.ACCESS_FINE_LOCATION".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfInt[0] == 0) {
        bool = true;
      }
      this.val$listener.onExecute(bool);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.WifiJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */