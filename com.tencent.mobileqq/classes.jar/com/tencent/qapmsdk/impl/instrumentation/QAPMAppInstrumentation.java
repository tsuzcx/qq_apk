package com.tencent.qapmsdk.impl.instrumentation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.impl.appstate.QAPMMonitorThreadLocal;
import com.tencent.qapmsdk.impl.appstate.h;
import java.util.concurrent.atomic.AtomicBoolean;

public class QAPMAppInstrumentation
{
  private static final String TAG = "QAPM_Impl_QAPMAppInstrumentation";
  public static h activityTrace = new h();
  public static com.tencent.qapmsdk.impl.appstate.b appStateTimeInfo;
  public static volatile boolean isAppInBackground;
  
  static
  {
    try
    {
      appStateTimeInfo = com.tencent.qapmsdk.impl.appstate.b.a();
      label16:
      isAppInBackground = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label16;
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityCreateBeginIns(String paramString)
  {
    try
    {
      activityTrace.c(paramString);
      activityTrace.a(paramString, "#onCreate");
      com.tencent.qapmsdk.impl.g.b.f.set(true);
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.a(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityCreateBeginIns() has an error :", paramString);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityCreateEndIns()
  {
    try
    {
      activityTrace.a();
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.e();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityCreateEndIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityCreateForOnFocusChanged(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView().getViewTreeObserver();
      if ((paramActivity != null) && (paramActivity.isAlive()) && (AndroidVersion.isKitKat()))
      {
        paramActivity.addOnWindowFocusChangeListener(new QAPMAppInstrumentation.1());
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", paramActivity);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityRestartBeginIns(String paramString)
  {
    try
    {
      if (com.tencent.qapmsdk.impl.g.b.e()) {
        QAPMMonitorThreadLocal.getInstance().d();
      }
      com.tencent.qapmsdk.impl.g.b.f.set(true);
      activityTrace.c(paramString);
      activityTrace.a(paramString, "#onRestart");
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.c(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityRestartBeginIns() has an error :", paramString);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityRestartEndIns()
  {
    activityTrace.a();
    try
    {
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.g();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityRestartEndIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityResumeBeginIns(String paramString)
  {
    try
    {
      activityTrace.b(paramString);
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.d(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityResumeBeginIns() has an error :", paramString);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityResumeEndIns()
  {
    try
    {
      if (isAppInBackground) {
        appStateTimeInfo.h();
      }
      activityTrace.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityResumeEndIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityStartBeginIns(String paramString)
  {
    try
    {
      activityTrace.a(paramString);
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.b(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityStartBeginIns() has an error :", paramString);
    }
  }
  
  public static void activityStartEndIns()
  {
    try
    {
      activityTrace.b();
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.f();
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityStartEndIns() has an error :", localException);
    }
  }
  
  @QAPMReplaceCallSite
  public static void applicationCreateBeginIns()
  {
    try
    {
      appStateTimeInfo.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  applicationCreateBeginIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void applicationCreateEndIns()
  {
    try
    {
      appStateTimeInfo.d();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  applicationCreateEndIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void attachBaseContextBeginIns(Context paramContext)
  {
    try
    {
      appStateTimeInfo.a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  attachBaseContextBeginIns() has an error :", paramContext);
    }
  }
  
  @QAPMReplaceCallSite
  public static void attachBaseContextEndIns()
  {
    try
    {
      appStateTimeInfo.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  attachBaseContextEndIns() has an error :", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation
 * JD-Core Version:    0.7.0.1
 */