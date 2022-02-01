package com.tencent.qqmini.sdk.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

@MiniKeep
public class DebugUtil
{
  public static boolean getDebugEnabled(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = StorageUtil.getPreference();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniAppInfo.appId);
    localStringBuilder.append("_debug");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static String getPrintableStackTrace(Throwable paramThrowable)
  {
    return getPrintableStackTrace(paramThrowable, false);
  }
  
  private static String getPrintableStackTrace(Throwable paramThrowable, boolean paramBoolean)
  {
    if (paramThrowable == null) {
      return "";
    }
    Object localObject1 = Thread.currentThread();
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramBoolean)
    {
      localStringBuilder.append("Exception in thread \"");
      localStringBuilder.append(((Thread)localObject1).getName());
      localStringBuilder.append("\"");
      localStringBuilder.append(paramThrowable.toString());
    }
    localObject1 = paramThrowable.getStackTrace();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localStringBuilder.append("\tat ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("\n");
      i += 1;
    }
    if ((paramThrowable instanceof InvocationTargetException)) {
      paramThrowable = ((InvocationTargetException)paramThrowable).getTargetException();
    } else {
      paramThrowable = paramThrowable.getCause();
    }
    if (paramThrowable != null)
    {
      localStringBuilder.append("caused by: ");
      localStringBuilder.append(paramThrowable.toString());
      localStringBuilder.append("\n");
      localStringBuilder.append(getPrintableStackTrace(paramThrowable, true));
    }
    return localStringBuilder.toString();
  }
  
  public static String getStackTrace()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringWriter localStringWriter = new StringWriter();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localStringWriter.write(arrayOfStackTraceElement[i].toString());
      localStringWriter.write("\n");
      i += 1;
    }
    localStringWriter.flush();
    return localStringWriter.toString();
  }
  
  public static boolean isDebugVersion()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
  }
  
  public static void setDebugEnabled(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    SharedPreferences.Editor localEditor = StorageUtil.getPreference().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniAppInfo.appId);
    localStringBuilder.append("_debug");
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.DebugUtil
 * JD-Core Version:    0.7.0.1
 */