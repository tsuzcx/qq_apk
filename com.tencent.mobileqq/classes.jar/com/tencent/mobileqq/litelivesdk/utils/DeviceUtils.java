package com.tencent.mobileqq.litelivesdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.UUID;

public class DeviceUtils
{
  static String a;
  static int b;
  public static String c;
  private static String d;
  
  public static String a()
  {
    if (a == null) {}
    try
    {
      a = BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(BaseApplicationImpl.getContext().getPackageName(), 0).versionName;
    }
    catch (Exception localException)
    {
      label31:
      break label31;
    }
    a = "unknown";
    return a;
  }
  
  public static String a(Context paramContext)
  {
    SharePreferenceUtil localSharePreferenceUtil;
    Object localObject1;
    StringBuilder localStringBuilder;
    String str;
    if (d == null)
    {
      localSharePreferenceUtil = new SharePreferenceUtil(paramContext, "saveUser");
      localObject1 = localSharePreferenceUtil.a().getString("device_id", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        d = (String)localObject1;
        return localObject1;
      }
      Object localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(DeviceInfoUtil.b());
        localObject1 = ((StringBuilder)localObject1).toString();
        try
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(PhoneInfoMonitor.getSimSerialNumber((TelephonyManager)localObject2));
          localObject2 = localStringBuilder.toString();
        }
        catch (Exception localException1) {}
        localException2.printStackTrace();
      }
      catch (Exception localException2)
      {
        localObject1 = "";
      }
      str = "";
    }
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
      paramContext = localStringBuilder.toString();
    }
    catch (Exception paramContext)
    {
      label174:
      break label174;
    }
    paramContext = (Context)localObject1;
    paramContext = new UUID(paramContext.hashCode(), ((String)localObject1).hashCode() << 32 | str.hashCode()).toString().replaceAll("-", "");
    localSharePreferenceUtil.a().edit().putString("device_id", paramContext);
    localSharePreferenceUtil.a().edit().commit();
    d = paramContext;
    return d;
  }
  
  public static int b()
  {
    if (b == 0) {}
    try
    {
      b = BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(BaseApplicationImpl.getContext().getPackageName(), 0).versionCode;
      label28:
      return b;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */