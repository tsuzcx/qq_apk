package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IRequestPermissionsResultListener;

class WifiJsPlugin$3
  implements IRequestPermissionsResultListener
{
  WifiJsPlugin$3(WifiJsPlugin paramWifiJsPlugin, WifiJsPlugin.LocationPermissionListener paramLocationPermissionListener) {}
  
  public boolean doOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = false;
    if (paramInt != 9528) {
      return false;
    }
    ActivityResultManager.g().removeRequestPermissionResultListener(this);
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      if ("android.permission.ACCESS_FINE_LOCATION".equals(paramArrayOfString[0]))
      {
        if (paramArrayOfInt[0] == 0) {
          bool = true;
        }
        this.val$listener.onExecute(bool);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.WifiJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */