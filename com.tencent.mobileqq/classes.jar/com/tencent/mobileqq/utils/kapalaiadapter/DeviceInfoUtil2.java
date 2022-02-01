package com.tencent.mobileqq.utils.kapalaiadapter;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

public class DeviceInfoUtil2
{
  public static boolean a()
  {
    return (a("meizu", null, null)) && (Build.VERSION.SDK_INT > 20);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool;
    if (!TextUtils.isEmpty(paramString1)) {
      bool = paramString1.equalsIgnoreCase(Build.MANUFACTURER);
    } else {
      bool = false;
    }
    if (!bool) {
      return bool;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      bool = paramString2.equalsIgnoreCase(Build.BRAND);
    }
    if (!bool) {
      return bool;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      bool = paramString3.equalsIgnoreCase(Build.MODEL);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.DeviceInfoUtil2
 * JD-Core Version:    0.7.0.1
 */