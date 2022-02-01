package com.tencent.rmonitor.common.util;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.common.thread.ThreadManager;

public class RMonitorUtil
{
  private static boolean a = true;
  
  public static void a(Runnable paramRunnable)
  {
    Looper localLooper;
    if (a) {
      localLooper = ThreadManager.e();
    } else {
      localLooper = null;
    }
    if (localLooper == null)
    {
      paramRunnable.run();
      return;
    }
    new Handler(localLooper).post(paramRunnable);
  }
  
  public static boolean a()
  {
    Application localApplication = BaseInfo.app;
    boolean bool2 = false;
    if (localApplication == null) {
      return false;
    }
    if (TextUtils.isEmpty(BaseInfo.userMeta.version)) {
      BaseInfo.userMeta.version = AppVersionHelper.a.a(BaseInfo.app.getApplicationContext());
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(BaseInfo.userMeta.appId))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(BaseInfo.userMeta.appKey))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(BaseInfo.userMeta.version)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String b()
  {
    if (BaseInfo.app == null) {
      localObject2 = "you should set PROPERTY_KEY_APP_INSTANCE. ";
    } else {
      localObject2 = "";
    }
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty(BaseInfo.userMeta.appId))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("you should set PROPERTY_KEY_APP_ID. ");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty(BaseInfo.userMeta.appKey))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("you should set PROPERTY_KEY_APP_ID. ");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty(BaseInfo.userMeta.version))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("we can not get your app version. ");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.RMonitorUtil
 * JD-Core Version:    0.7.0.1
 */