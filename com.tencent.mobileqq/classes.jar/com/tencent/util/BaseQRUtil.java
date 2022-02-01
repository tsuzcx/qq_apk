package com.tencent.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class BaseQRUtil
{
  public static String f = "qm.qq.com";
  protected static String g = "183.61.32.185";
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("host", 0).getString(paramString, null);
    if (paramContext != null) {
      return paramContext;
    }
    if (paramString.equals(f)) {
      return g;
    }
    return null;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getSharedPreferences("host", 0);
    try
    {
      paramContext = InetAddress.getByName(paramString).getHostAddress();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, paramContext);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("lookup address: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", ip: ");
        ((StringBuilder)localObject).append(paramContext);
        QLog.d("QRUtils", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (UnknownHostException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.BaseQRUtil
 * JD-Core Version:    0.7.0.1
 */