package com.tencent.mobileqq.minigame.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;

public class AppUtil
{
  private static final String KEY_LAST_STARTTIME = "lastStartTime";
  public static final int LMODE_AGAIN = 3;
  public static final int LMODE_NEW_INSTALL = 1;
  public static final int LMODE_UPDATE = 2;
  private static AppUtil sInstance;
  private boolean isOpenMarked = false;
  private int mLaunchMode = 3;
  
  public static AppUtil getInstance()
  {
    if (sInstance == null) {
      sInstance = new AppUtil();
    }
    return sInstance;
  }
  
  public static long getPackageFirstInstallTime(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public static long getPackageLastUpdateTime(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public static String getProcessName()
  {
    return BaseApplicationImpl.getApplication().getQQProcessName();
  }
  
  public static boolean isMainProcess()
  {
    return "com.tencent.mobileqq".equals(getProcessName());
  }
  
  public int getAppLaunchMode(Context paramContext)
  {
    if (this.isOpenMarked) {
      return this.mLaunchMode;
    }
    this.isOpenMarked = true;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("tt_launch_sp", 0);
    long l1 = localSharedPreferences.getLong("lastStartTime", 0L);
    long l2 = System.currentTimeMillis();
    localSharedPreferences.edit().putLong("lastStartTime", l2).apply();
    l2 = getPackageFirstInstallTime(paramContext);
    long l3 = getPackageLastUpdateTime(paramContext);
    if (l1 == 0L) {
      this.mLaunchMode = 1;
    } else if (l2 >= l1) {
      this.mLaunchMode = 1;
    } else if (l3 >= l1) {
      this.mLaunchMode = 2;
    } else {
      this.mLaunchMode = 3;
    }
    return this.mLaunchMode;
  }
  
  public int getLaunchMode()
  {
    return this.mLaunchMode;
  }
  
  public boolean isFirstOpen(Context paramContext)
  {
    return getAppLaunchMode(paramContext) != 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.AppUtil
 * JD-Core Version:    0.7.0.1
 */