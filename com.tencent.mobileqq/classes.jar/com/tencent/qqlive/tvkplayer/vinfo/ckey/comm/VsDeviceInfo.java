package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;

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
    try
    {
      str1 = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
      if (str1 == null) {
        return "";
      }
    }
    catch (Throwable localThrowable1)
    {
      String str1;
      String str2;
      label27:
      return "";
    }
    try
    {
      str2 = str1.toLowerCase();
      return str2;
    }
    catch (Throwable localThrowable2)
    {
      break label27;
    }
    return str1;
  }
  
  public String getImei()
  {
    String str = "";
    try
    {
      localObject = this.context;
      i = 0;
      j = 0;
      if (localObject != null)
      {
        i = this.context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid());
        if (i == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {}
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject;
      int i;
      int j;
      label117:
      return "";
    }
    try
    {
      localObject = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4096).requestedPermissions;
      if (localObject != null)
      {
        int k = localObject.length;
        while (j < k)
        {
          boolean bool = "android.permission.READ_PHONE_STATE".equals(localObject[j]);
          if (bool)
          {
            i = 1;
            break;
          }
          j += 1;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      break label117;
    }
    if (i != 0)
    {
      str = PhoneInfoMonitor.getDeviceId((TelephonyManager)this.context.getSystemService("phone"));
      if (str == null) {
        return "";
      }
      str = str.toLowerCase();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsDeviceInfo
 * JD-Core Version:    0.7.0.1
 */