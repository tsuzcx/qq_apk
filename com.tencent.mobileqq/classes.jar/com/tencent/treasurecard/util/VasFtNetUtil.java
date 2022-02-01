package com.tencent.treasurecard.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.treasurecard.manager.TcSdkManager;
import java.util.List;

public class VasFtNetUtil
{
  public static List<String> a = new VasFtNetUtil.1();
  public static List<String> b = new VasFtNetUtil.2();
  public static List<String> c = new VasFtNetUtil.3();
  
  public static int a()
  {
    String str = a();
    if (a.contains(str)) {
      return 1;
    }
    if (b.contains(str)) {
      return 2;
    }
    if (c.contains(str)) {
      return 3;
    }
    return 0;
  }
  
  public static String a()
  {
    return ((TelephonyManager)((TcSdkManager)TcSdkManager.a()).a().getSystemService("phone")).getSimOperator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.treasurecard.util.VasFtNetUtil
 * JD-Core Version:    0.7.0.1
 */