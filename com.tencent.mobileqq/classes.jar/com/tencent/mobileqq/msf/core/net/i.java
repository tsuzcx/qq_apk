package com.tencent.mobileqq.msf.core.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.sdk.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class i
{
  public static final String a = "MsfNetUtil";
  private static final int b = 16;
  private static final int c = 17;
  private static final int d = 18;
  private static final int e = 19;
  private static final int f = 10;
  private static final int g = 11;
  private static final int h = 12;
  private static final int i = 14;
  private static final int j = 15;
  
  public static int a(NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isAvailable()))
    {
      int k = paramNetworkInfo.getType();
      switch (k)
      {
      case 1: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 13: 
      default: 
        QLog.d("MsfNetUtil", 1, "Unexcepted Mobile Type:" + k);
        return -1;
      }
      paramNetworkInfo = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
      k = g.b(paramNetworkInfo);
      switch (k)
      {
      default: 
        int m = g.a(paramNetworkInfo, k);
        QLog.d("MsfNetUtil", 1, "Unexcepted networkType:" + k + " ,mobileInfo:" + m);
        return m;
      case 13: 
      case 18: 
      case 19: 
        return 3;
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
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public static boolean a(d paramd)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramd == null)
    {
      bool1 = false;
      return bool1;
    }
    if ("00000".equals(paramd.j)) {}
    for (int k = 2;; k = 1)
    {
      if (NetConnInfoCenter.isWifiConn())
      {
        bool1 = bool2;
        if (k == 1) {
          break;
        }
      }
      if (NetConnInfoCenter.isMobileConn())
      {
        bool1 = bool2;
        if (k == 2) {
          break;
        }
      }
      return false;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.i
 * JD-Core Version:    0.7.0.1
 */