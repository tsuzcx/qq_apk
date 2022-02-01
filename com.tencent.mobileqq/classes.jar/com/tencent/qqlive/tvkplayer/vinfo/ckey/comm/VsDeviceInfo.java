package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

public class VsDeviceInfo
{
  protected static VsDeviceInfo instance;
  protected Context context;
  
  private VsDeviceInfo(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static VsDeviceInfo getVsDeviceInfo(Context paramContext)
  {
    try
    {
      if ((instance == null) && (paramContext != null)) {
        instance = new VsDeviceInfo(paramContext);
      }
      paramContext = instance;
      return paramContext;
    }
    finally {}
  }
  
  public boolean checkIsHaveCard()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public String getAndroidId()
  {
    Object localObject = "";
    try
    {
      String str = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
      if (str == null) {
        return "";
      }
      localObject = str;
      str = str.toLowerCase();
      return str;
    }
    catch (Throwable localThrowable) {}
    return localObject;
  }
  
  public String getImei()
  {
    int k = 1;
    int m = 0;
    int i;
    Object localObject;
    label78:
    label102:
    label104:
    try
    {
      if (this.context == null) {
        break label170;
      }
      i = this.context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid());
      if (i != 0) {
        break label158;
      }
      i = 1;
      j = i;
      if (i != 0) {}
    }
    catch (Throwable localThrowable1) {}
    try
    {
      localObject = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4096).requestedPermissions;
      if (localObject != null)
      {
        int n = localObject.length;
        j = m;
        if (j < n)
        {
          boolean bool = "android.permission.READ_PHONE_STATE".equals(localObject[j]);
          if (!bool) {
            break label163;
          }
          i = k;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      j = i;
      break label104;
      break label102;
    }
    label158:
    label163:
    label170:
    for (int j = i;; j = 0)
    {
      if (j != 0)
      {
        localObject = ((TelephonyManager)this.context.getSystemService("phone")).getDeviceId();
        if (localObject == null) {
          return "";
        }
        localObject = ((String)localObject).toLowerCase();
        return localObject;
      }
      return "";
      i = 0;
      break;
      j += 1;
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsDeviceInfo
 * JD-Core Version:    0.7.0.1
 */