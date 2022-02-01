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
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (!paramString.startsWith("H_")) {
      return 0;
    }
    int i = paramString.indexOf("_");
    if (i == -1) {
      return 0;
    }
    int j = paramString.lastIndexOf("_");
    if (i == j) {
      return 0;
    }
    paramString = paramString.substring(j);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static TroopFileManager a(long paramLong)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return null;
    }
    return TroopFileManager.a(localQQAppInterface, paramLong);
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int i = paramString.indexOf("User-ReturnCode=[");
    if (i == -1) {
      return 0;
    }
    paramString = paramString.substring(i + 17);
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    i = paramString.indexOf("]");
    if (i == -1) {
      return 0;
    }
    paramString = paramString.substring(0, i);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static long b()
  {
    return (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
  }
  
  public static int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (!paramString.startsWith("H_")) {
      return 0;
    }
    int i = paramString.indexOf("_");
    if (i == -1) {
      return 0;
    }
    int j = paramString.lastIndexOf("_");
    if (i == j) {
      return 0;
    }
    paramString = paramString.substring(i, j - 1);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static String c()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      return "none";
    }
    if (AppNetConnInfo.isWifiConn()) {
      return "wifi";
    }
    if (AppNetConnInfo.isMobileConn())
    {
      int i = AppNetConnInfo.getMobileInfo();
      if (i != -1)
      {
        if ((i != 0) && (i != 1))
        {
          if (i != 2)
          {
            if (i != 3) {
              return "unkonw";
            }
            return "4g";
          }
          return "3g";
        }
        return "2g";
      }
    }
    return "none";
  }
  
  public static TroopFileTransferUtil.HostInfo d(String paramString)
  {
    TroopFileTransferUtil.HostInfo localHostInfo = new TroopFileTransferUtil.HostInfo();
    if (TextUtils.isEmpty(paramString)) {
      return localHostInfo;
    }
    String str1 = null;
    String str2;
    label271:
    label278:
    do
    {
      for (;;)
      {
        try
        {
          i = paramString.indexOf("://");
          if (i != -1) {
            break label271;
          }
          i = 0;
          str2 = paramString.substring(i);
          k = str2.indexOf("/");
          int j = k;
          if (-1 == k) {
            j = str2.length() - 1;
          }
          k = paramString.indexOf("&bHost=");
          if (-1 == k) {
            break label278;
          }
          int m = paramString.indexOf("&bPort=", k);
          if (-1 == m) {
            break label278;
          }
          str1 = paramString.substring(k + 7, m);
          str2 = paramString.substring(m + 7);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          localStringBuilder.append(":");
          localStringBuilder.append(str2);
          str1 = localStringBuilder.toString();
          k = 1;
          str2 = str1;
          if (str1 != null) {
            break;
          }
          str2 = paramString.substring(i, j + i);
        }
        catch (Exception paramString)
        {
          return localHostInfo;
        }
        int i = str2.indexOf(":");
        if (i >= 0)
        {
          paramString = str2.substring(0, i);
          str1 = str2.substring(i + 1);
          localHostInfo.a = paramString;
          localHostInfo.b = Integer.valueOf(str1).intValue();
        }
        else
        {
          localHostInfo.a = str2;
          localHostInfo.b = 0;
        }
        if (k != 0) {
          localHostInfo.c = 1;
        }
        return localHostInfo;
        i += 3;
        continue;
        int k = 0;
      }
    } while (str2 != null);
    return localHostInfo;
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("/")) {
      return paramString.substring(1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil
 * JD-Core Version:    0.7.0.1
 */