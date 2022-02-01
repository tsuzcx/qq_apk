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
    boolean bool1 = false;
    if (!TextUtils.isEmpty(paramString1)) {
      bool1 = paramString1.equalsIgnoreCase(Build.MANUFACTURER);
    }
    boolean bool2;
    if (!bool1) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        return bool2;
        if (!TextUtils.isEmpty(paramString2)) {
          bool1 = paramString2.equalsIgnoreCase(Build.BRAND);
        }
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (TextUtils.isEmpty(paramString3));
    return paramString3.equalsIgnoreCase(Build.MODEL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.DeviceInfoUtil2
 * JD-Core Version:    0.7.0.1
 */