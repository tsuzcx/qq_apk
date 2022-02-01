package com.tencent.mtt.abtestsdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;

public class SystemUtil
{
  public static String getAppInfo(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.packageName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String getDeviceBrand()
  {
    return Build.BRAND;
  }
  
  public static int getHeight(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  public static String getIPAddress(Context paramContext)
  {
    Object localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localObject != null) && (((NetworkInfo)localObject).isConnected())) {
      if (((NetworkInfo)localObject).getType() == 0) {
        try
        {
          InetAddress localInetAddress;
          do
          {
            paramContext = NetworkInterface.getNetworkInterfaces();
            while (!((Enumeration)localObject).hasMoreElements())
            {
              if (!paramContext.hasMoreElements()) {
                break;
              }
              localObject = ((NetworkInterface)paramContext.nextElement()).getInetAddresses();
            }
            localInetAddress = (InetAddress)((Enumeration)localObject).nextElement();
          } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
          paramContext = localInetAddress.getHostAddress();
          return paramContext;
        }
        catch (SocketException paramContext)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getIPAddress error: ");
          ((StringBuilder)localObject).append(paramContext.getMessage());
          ABTestLog.error(((StringBuilder)localObject).toString(), new Object[0]);
          return "";
        }
      } else if (((NetworkInfo)localObject).getType() == 1) {
        return intIP2StringIP(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getIpAddress());
      }
    }
    return "";
  }
  
  public static String getSystemLanguage()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public static Locale[] getSystemLanguageList()
  {
    return Locale.getAvailableLocales();
  }
  
  public static String getSystemModel()
  {
    return Build.MODEL;
  }
  
  public static String getSystemVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String getVersionName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static int getWidth(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static String intIP2StringIP(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
    }
    return false;
  }
  
  public String getSystemPlatform()
  {
    return "ANDROID";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.SystemUtil
 * JD-Core Version:    0.7.0.1
 */