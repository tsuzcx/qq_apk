package com.tencent.qqlive.module.videoreport.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.reflect.Method;
import java.util.Random;

public class ReportUtils
{
  private static final String BUGLY_APP_ID = "c7924ada07";
  private static final String BUGLY_SDK_SP = "BuglySdkInfos";
  private static final String TAG = "ReportUtils";
  private static volatile boolean sBuglyInited = false;
  private static volatile Context sContext;
  private static volatile Application sCurrentApplication;
  private static volatile boolean sGetCurrentApplicationChecked;
  private static PackageInfo sPackageInfo;
  
  public static long calcElementUniqueId(View paramView)
  {
    if (paramView == null) {
      return 0L;
    }
    String str2 = DataRWProxy.getElementId(paramView);
    if (TextUtils.isEmpty(str2)) {
      return 0L;
    }
    Object localObject = DataRWProxy.getInnerParam(paramView, "element_identifier");
    String str1;
    if ((localObject instanceof String)) {
      str1 = (String)localObject;
    } else {
      str1 = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append("_");
    if (!TextUtils.isEmpty(str1)) {
      paramView = localObject;
    } else {
      paramView = Integer.valueOf(paramView.hashCode());
    }
    localStringBuilder.append(paramView.toString());
    return localStringBuilder.toString().hashCode();
  }
  
  public static String generateSessionId()
  {
    int i = new Random().nextInt(900);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    localStringBuilder.append(i + 100);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public static Context getContext()
  {
    if (sContext == null) {
      sContext = getCurrentApplication();
    }
    return sContext;
  }
  
  private static Application getCurrentApplication()
  {
    if (!sGetCurrentApplicationChecked) {
      try
      {
        boolean bool = sGetCurrentApplicationChecked;
        if (!bool) {
          try
          {
            sCurrentApplication = (Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            if (sCurrentApplication != null) {
              sGetCurrentApplicationChecked = true;
            }
          }
          catch (Throwable localThrowable)
          {
            sGetCurrentApplicationChecked = true;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getCurrentApplication error ");
            localStringBuilder.append(localThrowable);
            Log.e("ReportUtils", localStringBuilder.toString());
          }
        }
      }
      finally {}
    }
    return sCurrentApplication;
  }
  
  public static int getPackageCode()
  {
    PackageInfo localPackageInfo = getPackageInfo();
    if (localPackageInfo != null) {
      return localPackageInfo.versionCode;
    }
    return -1;
  }
  
  private static PackageInfo getPackageInfo()
  {
    try
    {
      if (sPackageInfo == null) {
        sPackageInfo = sContext.getPackageManager().getPackageInfo(sContext.getPackageName(), 0);
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPackageInfo exception ");
      localStringBuilder.append(localException);
      Log.e("ReportUtils", localStringBuilder.toString());
    }
    return sPackageInfo;
  }
  
  public static String getPackageName()
  {
    PackageInfo localPackageInfo = getPackageInfo();
    if (localPackageInfo != null) {
      return localPackageInfo.versionName;
    }
    return "";
  }
  
  public static void initCrashReport(Context paramContext)
  {
    if (!sBuglyInited) {
      try
      {
        if (!sBuglyInited)
        {
          writeBuglySpInfo(paramContext);
          sBuglyInited = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public static void printStack(String paramString)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        Log.d(paramString, arrayOfStackTraceElement[i].toString());
        i += 1;
      }
    }
  }
  
  public static void setContext(Context paramContext)
  {
    sContext = paramContext.getApplicationContext();
  }
  
  private static void writeBuglySpInfo(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("BuglySdkInfos", 0);
    String str1 = paramContext.getString("c7924ada07", "");
    String str2 = String.valueOf(2225);
    if (TextUtils.equals(str1, str2)) {
      return;
    }
    paramContext.edit().putString("c7924ada07", str2).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ReportUtils
 * JD-Core Version:    0.7.0.1
 */