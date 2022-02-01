package com.tencent.mobileqq.msf.core.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.sdk.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class j
{
  public static final String a = "MsfNetUtil";
  private static final int b = 16;
  private static final int c = 17;
  private static final int d = 18;
  private static final int e = 19;
  private static final int f = 20;
  private static final int g = 10;
  private static final int h = 11;
  private static final int i = 12;
  private static final int j = 14;
  private static final int k = 15;
  
  public static int a(NetworkInfo paramNetworkInfo)
  {
    int n;
    int m;
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isAvailable()))
    {
      n = paramNetworkInfo.getType();
      m = 4;
      if ((n == 0) || (n == 2) || (n == 3) || (n == 4) || (n == 5) || (n == 14) || (n == 15)) {}
    }
    switch (n)
    {
    default: 
      m = -1;
      paramNetworkInfo = new StringBuilder();
      paramNetworkInfo.append("Unexcepted Mobile Type:");
      paramNetworkInfo.append(n);
      QLog.d("MsfNetUtil", 1, paramNetworkInfo.toString());
      break;
    case 10: 
    case 11: 
    case 12: 
      paramNetworkInfo = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
      n = g.b(paramNetworkInfo);
      switch (n)
      {
      default: 
        m = g.a(paramNetworkInfo, n);
        paramNetworkInfo = new StringBuilder();
        paramNetworkInfo.append("Unexcepted networkType:");
        paramNetworkInfo.append(n);
        paramNetworkInfo.append(" ,mobileInfo:");
        paramNetworkInfo.append(m);
        QLog.d("MsfNetUtil", 1, paramNetworkInfo.toString());
        break;
      case 13: 
      case 18: 
      case 19: 
        m = 3;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
      case 17: 
        m = 2;
        break;
      case 0: 
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
      case 16: 
        m = 1;
        break;
        m = 0;
      }
      break;
    }
    paramNetworkInfo = new StringBuilder();
    paramNetworkInfo.append("Mobile Type:");
    paramNetworkInfo.append(m);
    QLog.d("MsfNetUtil", 1, paramNetworkInfo.toString());
    return m;
  }
  
  public static boolean a(d paramd)
  {
    boolean bool1 = false;
    if (paramd != null)
    {
      if (TextUtils.isEmpty(paramd.h)) {
        return false;
      }
      bool1 = "00000".equals(paramd.h);
      boolean bool2 = true;
      int m;
      if (bool1) {
        m = 2;
      } else {
        m = 1;
      }
      if (NetConnInfoCenter.isWifiConn())
      {
        bool1 = bool2;
        if (m == 1) {}
      }
      else if ((NetConnInfoCenter.isMobileConn()) && (m == 2))
      {
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
      if ("00000".equals(paramd.h)) {
        return false;
      }
    }
    return bool1;
  }
  
  public static NetworkInfo[] a()
  {
    try
    {
      NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getAllNetworkInfo();
      return arrayOfNetworkInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static byte b()
  {
    if (NetConnInfoCenter.isWifiConn()) {
      return 1;
    }
    if (NetConnInfoCenter.isMobileConn())
    {
      int n = NetConnInfoCenter.getMobileNetworkType();
      int m = n;
      if (n != 20) {
        m = n + 100;
      }
      n = m;
      if (m > 254)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("error,netWorkType is ");
          localStringBuilder.append(254);
          QLog.d("MsfNetUtil", 2, localStringBuilder.toString());
        }
        n = 254;
      }
      return (byte)n;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.j
 * JD-Core Version:    0.7.0.1
 */