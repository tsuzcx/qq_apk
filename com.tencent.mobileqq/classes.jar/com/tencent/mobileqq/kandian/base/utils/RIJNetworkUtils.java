package com.tencent.mobileqq.kandian.base.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;

public class RIJNetworkUtils
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static String b = "";
  
  public static int a(Context paramContext)
  {
    int j = NetworkUtil.getSystemNetwork(paramContext);
    int i;
    if (j >= 1)
    {
      i = j;
      if (j <= 4) {}
    }
    else
    {
      i = 5;
    }
    return i;
  }
  
  public static String a(Context paramContext)
  {
    b(paramContext);
    return jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(Context paramContext)
  {
    return NetworkUtil.isNetworkAvailable(paramContext);
  }
  
  public static int b(Context paramContext)
  {
    return NetworkUtil.getNetworkType(paramContext);
  }
  
  public static String b(Context paramContext)
  {
    b(paramContext);
    return b;
  }
  
  private static void b(Context paramContext)
  {
    if ((!jdField_a_of_type_Boolean) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      jdField_a_of_type_Boolean = true;
      AppNetConnInfo.registerNetChangeReceiver(paramContext, new RIJNetworkUtils.1(paramContext));
      c(paramContext);
    }
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getConnectionInfo().getBSSID();
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  private static void c(Context paramContext)
  {
    if (paramContext != null)
    {
      WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        boolean bool = TextUtils.isEmpty(localWifiInfo.getBSSID());
        String str = "";
        if (bool) {
          paramContext = "";
        } else {
          paramContext = localWifiInfo.getBSSID();
        }
        jdField_a_of_type_JavaLangString = paramContext;
        if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          paramContext = str;
        } else {
          paramContext = localWifiInfo.getSSID();
        }
        b = paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils
 * JD-Core Version:    0.7.0.1
 */