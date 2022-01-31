package com.tencent.mobileqq.troop.filemanager;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.Random;
import mqq.app.AppRuntime;

public class TroopFileTransferUtil
{
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return 0;
        } while (!paramString.startsWith("H_"));
        i = paramString.indexOf("_");
      } while (i == -1);
      j = paramString.lastIndexOf("_");
    } while (i == j);
    paramString = paramString.substring(j);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static long a()
  {
    return (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static TroopFileTransferUtil.HostInfo a(String paramString)
  {
    int i = 1;
    TroopFileTransferUtil.HostInfo localHostInfo = new TroopFileTransferUtil.HostInfo();
    if (TextUtils.isEmpty(paramString)) {
      return localHostInfo;
    }
    for (;;)
    {
      try
      {
        int j = paramString.indexOf("://");
        if (j == -1)
        {
          j = 0;
          String str1 = paramString.substring(j);
          int m = str1.indexOf("/");
          int k = m;
          if (-1 == m) {
            k = str1.length() - 1;
          }
          m = paramString.indexOf("&bHost=");
          if (-1 == m)
          {
            i = 0;
            str1 = null;
            str2 = str1;
            if (str1 == null) {
              str2 = paramString.substring(j, k + j);
            }
            if (str2 == null) {
              break;
            }
            j = str2.indexOf(":");
            if (j < 0) {
              continue;
            }
            paramString = str2.substring(0, j);
            str1 = str2.substring(j + 1);
            localHostInfo.jdField_a_of_type_JavaLangString = paramString;
            localHostInfo.jdField_a_of_type_Int = Integer.valueOf(str1).intValue();
            if (i == 0) {
              break;
            }
            localHostInfo.b = 1;
            return localHostInfo;
          }
          int n = paramString.indexOf("&bPort=", m);
          if (-1 == n)
          {
            i = 0;
            str1 = null;
            continue;
          }
          str1 = paramString.substring("&bHost=".length() + m, n);
          String str2 = paramString.substring("&bPort=".length() + n);
          str1 = str1 + ":" + str2;
          continue;
          localHostInfo.jdField_a_of_type_JavaLangString = str2;
          localHostInfo.jdField_a_of_type_Int = 0;
          continue;
        }
        j += 3;
      }
      catch (Exception paramString)
      {
        return localHostInfo;
      }
    }
  }
  
  public static TroopFileManager a(long paramLong)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return null;
    }
    return TroopFileManager.a(localQQAppInterface, paramLong);
  }
  
  public static String a()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      return "none";
    }
    if (AppNetConnInfo.isWifiConn()) {
      return "wifi";
    }
    if (AppNetConnInfo.isMobileConn())
    {
      switch (AppNetConnInfo.getMobileInfo())
      {
      default: 
        return "unkonw";
      case -1: 
        return "none";
      case 0: 
      case 1: 
        return "2g";
      case 2: 
        return "3g";
      }
      return "4g";
    }
    return "none";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("/")) {
      return paramString.substring(1);
    }
    return "/" + paramString;
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        do
        {
          return 0;
          i = paramString.indexOf("User-ReturnCode=[");
        } while (i == -1);
        paramString = paramString.substring("User-ReturnCode=[".length() + i);
      } while (TextUtils.isEmpty(paramString));
      i = paramString.indexOf("]");
    } while (i == -1);
    paramString = paramString.substring(0, i);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return 0;
        } while (!paramString.startsWith("H_"));
        i = paramString.indexOf("_");
      } while (i == -1);
      j = paramString.lastIndexOf("_");
    } while (i == j);
    paramString = paramString.substring(i, j - 1);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil
 * JD-Core Version:    0.7.0.1
 */