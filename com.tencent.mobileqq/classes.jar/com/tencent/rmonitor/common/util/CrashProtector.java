package com.tencent.rmonitor.common.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;

public class CrashProtector
{
  private static final Handler a = new Handler(ThreadManager.e());
  
  public static boolean a(int paramInt, long paramLong)
  {
    Object localObject1 = BaseInfo.sharePreference;
    if (localObject1 == null) {
      return true;
    }
    Object localObject2 = ((SharedPreferences)localObject1).edit();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("disable_forever_");
    ((StringBuilder)localObject3).append(BaseInfo.userMeta.sdkVersion);
    ((StringBuilder)localObject3).append("_");
    ((StringBuilder)localObject3).append(paramInt);
    localObject3 = ((StringBuilder)localObject3).toString();
    if (((SharedPreferences)localObject1).getBoolean((String)localObject3, false))
    {
      localObject1 = Logger.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start plugin");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" fail due to disabled forever");
      ((Logger)localObject1).d(new String[] { "CrashProtector", ((StringBuilder)localObject2).toString() });
      return true;
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("start_failed_times_");
    ((StringBuilder)localObject4).append(BaseInfo.userMeta.sdkVersion);
    ((StringBuilder)localObject4).append("_");
    ((StringBuilder)localObject4).append(paramInt);
    localObject4 = ((StringBuilder)localObject4).toString();
    int i = ((SharedPreferences)localObject1).getInt((String)localObject4, 0);
    if (i > 3)
    {
      ((SharedPreferences.Editor)localObject2).putBoolean((String)localObject3, true);
      ((SharedPreferences.Editor)localObject2).commit();
      localObject1 = Logger.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start plugin");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" fail duo to too many failed times");
      ((Logger)localObject1).d(new String[] { "CrashProtector", ((StringBuilder)localObject2).toString() });
      return true;
    }
    ((SharedPreferences.Editor)localObject2).putInt((String)localObject4, i + 1);
    ((SharedPreferences.Editor)localObject2).commit();
    a.postDelayed(new CrashProtector.1((SharedPreferences)localObject1, (String)localObject4), paramLong);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.CrashProtector
 * JD-Core Version:    0.7.0.1
 */