package com.tencent.mobileqq.qwallet.utils;

import android.content.Context;
import java.lang.reflect.Method;

public class QWalletCrashUtils
{
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getClassLoader();
      if (paramContext == null) {
        return;
      }
      paramContext.loadClass("cooperation.qwallet.plugin.QWalletPluginProxyActivity").getMethod("handleNoCatchCrash", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.QWalletCrashUtils
 * JD-Core Version:    0.7.0.1
 */