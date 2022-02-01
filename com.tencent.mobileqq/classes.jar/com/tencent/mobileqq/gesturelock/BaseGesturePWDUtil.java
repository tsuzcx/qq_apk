package com.tencent.mobileqq.gesturelock;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;

public class BaseGesturePWDUtil
{
  public static final int GESTUREPWD_MODE_AUTO = 21;
  public static final int GESTUREPWD_MODE_MANUAL = 20;
  public static final int GESTUREPWD_STATE_CLOSED = 1;
  public static final int GESTUREPWD_STATE_NOTSET = 0;
  public static final int GESTUREPWD_STATE_OPEN = 2;
  public static final int GESTUREPWD_UNLOCKFAILED_TYPE_FORGET = 0;
  public static final int GESTUREPWD_UNLOCKFAILED_TYPE_WRONG = 1;
  public static final String GESTURE_SALT = "28DF17A9B837BAFD951724E325F6F86B5B6E477D";
  static final String KEY_GESTURE_APP_FORGROUND = "gesturepassword_appforground";
  static final String KEY_GESTURE_CURRENTUIN_FORPLUGIN = "gesturepassword_currentuin_forplugin";
  static final String KEY_GESTURE_LOCKING = "gesturepassword_locking";
  static final String KEY_GESTURE_MODE = "gesturepassword_gesture_mode";
  static final String KEY_GESTURE_PWD = "gesturepassword_gesture_pwd";
  static final String KEY_GESTURE_SHAREPRE_NAME = "gesturepassword_sharepreference";
  static final String KEY_GESTURE_STATE = "gesturepassword_gesture_state";
  static final String KEY_GESTURE_UNLOCK_FAILED = "gesturepassword_unlock_failed";
  static final String KEY_GESTURE_UNLOCK_FAILED_TIME = "gesturepassword_unlock_failed_time";
  static final String KEY_GESTURE_UNLOCK_FAILED_TYPE = "gesturepassword_unlock_failed_type";
  public static final int PROCESS_STATE_TOP = 2;
  static final String UTIL_TAG = "Q.gesturelock.util";
  static Field mProcStateField;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 21) && (mProcStateField == null)) {
      try
      {
        mProcStateField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.gesturelock.util", 2, "getDeclaredField processState", localException);
        }
      }
    }
  }
  
  public static void clearGestureData(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearGestureData.uin=");
      localStringBuilder.append(paramString);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_gesture_state");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_gesture_pwd");
    localStringBuilder.append(paramString);
    paramContext.putString(localStringBuilder.toString(), "");
    paramContext.commit();
  }
  
  public static boolean enableGestureLock(Context paramContext)
  {
    int i = Process.myPid();
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    String str = paramContext.getApplicationContext().getPackageName();
    paramContext = ((ActivityManager)localObject).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i)
        {
          paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          break label79;
        }
      }
      paramContext = "";
      label79:
      if (paramContext != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(":qzone");
        if (!paramContext.equals(((StringBuilder)localObject).toString()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":picture");
          if (!paramContext.equals(((StringBuilder)localObject).toString()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(":qqfav");
            if (!paramContext.equals(((StringBuilder)localObject).toString()))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append(":qlink");
              if (!paramContext.equals(((StringBuilder)localObject).toString())) {
                break label213;
              }
            }
          }
        }
        return true;
      }
    }
    label213:
    return false;
  }
  
  public static String encodeGesture(String paramString1, String paramString2)
  {
    paramString1 = MD5.toMD5(paramString1);
    int i;
    if (!TextUtils.isEmpty(paramString2)) {
      i = paramString2.length();
    } else {
      i = 0;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder(paramString1);
      paramString1.insert(6, "28DF17A9B837BAFD951724E325F6F86B5B6E477D".substring(0, 20));
      paramString1.insert(paramString1.length() - 9, "28DF17A9B837BAFD951724E325F6F86B5B6E477D".substring(20, 40));
      if (!TextUtils.isEmpty(paramString2))
      {
        int j = i / 2;
        paramString1.insert(2, paramString2.substring(0, j));
        paramString1.insert(paramString1.length() - 5, paramString2.substring(j, i));
      }
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = "";
    }
    return MD5.toMD5(paramString1);
  }
  
  public static boolean getAppForground(Context paramContext)
  {
    boolean bool = getAppSharedPreferences(paramContext).getBoolean("gesturepassword_appforground", false);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getAppForground.uin=,isAppFroground=");
      paramContext.append(bool);
      QLog.d("Q.gesturelock.util", 2, paramContext.toString());
    }
    return bool;
  }
  
  static SharedPreferences getAppSharedPreferences(Context paramContext)
  {
    return BaseApplication.getContext().getSharedPreferences("gesturepassword_sharepreference", 4);
  }
  
  public static boolean getGestureLocking(Context paramContext)
  {
    boolean bool = getSharedPreferences(paramContext).getBoolean("gesturepassword_locking", false);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("setGestureLocking.uin=,islocking=");
      paramContext.append(bool);
      QLog.d("Q.gesturelock.util", 2, paramContext.toString());
    }
    return bool;
  }
  
  public static String getGesturePWD(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_gesture_pwd");
    localStringBuilder.append(paramString);
    paramContext = paramContext.getString(localStringBuilder.toString(), "");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGesturePWD.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",pw=");
      localStringBuilder.append(paramContext);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    return paramContext;
  }
  
  public static int getGesturePWDMode(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_gesture_mode");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 21);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getGesturePWDMode.uin=");
      paramContext.append(paramString);
      paramContext.append(",mode=");
      paramContext.append(i);
      QLog.d("Q.gesturelock.util", 2, paramContext.toString());
    }
    return i;
  }
  
  public static int getGesturePWDState(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_gesture_state");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getGesturePWDState.uin=");
      paramContext.append(paramString);
      paramContext.append(",state=");
      paramContext.append(i);
      QLog.d("Q.gesturelock.util", 2, paramContext.toString());
    }
    return i;
  }
  
  public static boolean getGestureUnlockFailed(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    Object localObject = paramContext.getString("gesturepassword_unlock_failed", "");
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool2;
        if (((String)localObject).equals(paramString))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("gesturepassword_gesture_state");
          ((StringBuilder)localObject).append(paramString);
          bool1 = bool2;
          if (paramContext.getInt(((StringBuilder)localObject).toString(), 0) == 0) {
            bool1 = true;
          }
        }
      }
    }
    paramContext = paramContext.edit();
    paramContext.putString("gesturepassword_unlock_failed", "");
    paramContext.commit();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getGestureUnlockFailed.uin=");
      paramContext.append(paramString);
      paramContext.append(",ret=");
      paramContext.append(bool1);
      QLog.d("Q.gesturelock.util", 2, paramContext.toString());
    }
    return bool1;
  }
  
  public static int getGestureUnlockFailedTime(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_unlock_failed_time");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getGestureUnlockFailedTime.uin=");
      paramContext.append(paramString);
      paramContext.append(",failedTime=");
      paramContext.append(i);
      QLog.d("Q.gesturelock.util", 2, paramContext.toString());
    }
    return i;
  }
  
  public static int getGestureUnlockFailedType(Context paramContext)
  {
    int i = getSharedPreferences(paramContext).getInt("gesturepassword_unlock_failed_type", 0);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getGestureUnlockFailedType.type=");
      paramContext.append(i);
      QLog.d("Q.gesturelock.util", 2, paramContext.toString());
    }
    return i;
  }
  
  static SharedPreferences getSharedPreferences(Context paramContext)
  {
    return BaseApplication.getContext().getSharedPreferences("gesturepassword_sharepreference", 4);
  }
  
  public static boolean getSplashLock(Context paramContext, String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if (!bool2)
    {
      paramContext = getSharedPreferences(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gesturepassword_gesture_mode");
      localStringBuilder.append(paramString);
      int i = paramContext.getInt(localStringBuilder.toString(), 21);
      if (i == 21)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("gesturepassword_gesture_state");
        localStringBuilder.append(paramString);
        if (paramContext.getInt(localStringBuilder.toString(), 0) == 2) {
          break label128;
        }
      }
      else
      {
        if ((i == 20) && (paramContext.getBoolean("gesturepassword_locking", false))) {
          break label128;
        }
      }
    }
    bool1 = false;
    label128:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getSplashLock.uin=");
      paramContext.append(paramString);
      paramContext.append(",islock=");
      paramContext.append(bool1);
      QLog.d("Q.gesturelock.util", 2, paramContext.toString());
    }
    return bool1;
  }
  
  public static String getUinForPlugin(Context paramContext)
  {
    paramContext = getSharedPreferences(paramContext).getString("gesturepassword_currentuin_forplugin", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUinForPlugin.uin=");
      localStringBuilder.append(paramContext);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    return paramContext;
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    if (Foreground.getActivityCount() > 0) {
      return true;
    }
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.startsWith(paramContext))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isAppOnForegroundByTasks(Context paramContext)
  {
    return isAppOnForegroundByTasks(paramContext, 0);
  }
  
  public static boolean isAppOnForegroundByTasks(Context paramContext, int paramInt)
  {
    if (Foreground.getActivityCountFromLifecycle(paramInt) > 0) {
      return true;
    }
    ActivityManager localActivityManager = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    label481:
    label483:
    label490:
    label493:
    for (;;)
    {
      try
      {
        localObject1 = localActivityManager.getRunningTasks(1);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (ActivityManager.RunningTaskInfo)((List)localObject1).get(0);
          if ((localObject1 != null) && (((ActivityManager.RunningTaskInfo)localObject1).baseActivity != null) && (!paramContext.equals(((ActivityManager.RunningTaskInfo)localObject1).baseActivity.getPackageName())))
          {
            QLog.d("Q.gesturelock.util", 2, "qq runningTaskI is not top");
            return false;
          }
        }
        localObject1 = localActivityManager.getRunningAppProcesses();
        if (localObject1 == null) {
          return false;
        }
        int j = Process.myPid();
        localObject2 = ((List)localObject1).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label481;
        }
        localObject1 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
        if ((localObject1 == null) || (j == ((ActivityManager.RunningAppProcessInfo)localObject1).pid) || (!((ActivityManager.RunningAppProcessInfo)localObject1).processName.startsWith(paramContext)) || (((ActivityManager.RunningAppProcessInfo)localObject1).processName.endsWith("MSF")) || (((ActivityManager.RunningAppProcessInfo)localObject1).processName.endsWith("TMAssistantDownloadSDKService"))) {
          continue;
        }
        paramInt = ((ActivityManager.RunningAppProcessInfo)localObject1).importance;
        if (paramInt != 100) {
          break label490;
        }
        try
        {
          if (mProcStateField != null)
          {
            paramInt = mProcStateField.getInt(localObject1);
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.gesturelock.util", 2, "isAppOnForegroundByTasks, mProcStateField is null");
          }
          return true;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label483;
          }
        }
        QLog.e("Q.gesturelock.util", 2, "isAppOnForegroundByTasks", localException);
      }
      catch (Exception paramContext)
      {
        Object localObject1;
        Object localObject2;
        StringBuilder localStringBuilder;
        if (!QLog.isColorLevel()) {
          break label481;
        }
        QLog.e("Q.gesturelock.util", 2, "isAppOnForegroundByTasks.uin", paramContext);
      }
      int i = paramInt;
      if (paramInt == 2)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("isAppOnForegroundByTasks is true, realforeProcessName=");
          ((StringBuilder)localObject2).append(((ActivityManager.RunningAppProcessInfo)localObject1).processName);
          QLog.d("Q.gesturelock.util", 2, ((StringBuilder)localObject2).toString());
          printServiceInfos(localActivityManager, paramContext);
          return true;
        }
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break label493;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isAppOnForegroundByTasks, procName=");
        localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject1).processName);
        localStringBuilder.append(",importance=");
        localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject1).importance);
        localStringBuilder.append(",reasonCode=");
        localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject1).importanceReasonCode);
        localStringBuilder.append(",procState=");
        localStringBuilder.append(i);
        localStringBuilder.append(",pid=");
        localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject1).pid);
        QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
        continue;
        return false;
        paramInt = 0;
        continue;
      }
      return true;
      i = 0;
    }
  }
  
  private static void printServiceInfos(ActivityManager paramActivityManager, String paramString)
  {
    if (paramActivityManager != null) {
      paramActivityManager = paramActivityManager.getRunningServices(1000);
    } else {
      paramActivityManager = null;
    }
    if (paramActivityManager != null)
    {
      paramActivityManager = paramActivityManager.iterator();
      while (paramActivityManager.hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramActivityManager.next();
        if ((localRunningServiceInfo != null) && (localRunningServiceInfo.foreground == true) && (localRunningServiceInfo.process.startsWith(paramString)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("foreground service=");
          localStringBuilder.append(localRunningServiceInfo.service.getClassName());
          QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public static void setGestureLocking(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGestureLocking.uin=,islock=");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putBoolean("gesturepassword_locking", paramBoolean);
    paramContext.commit();
  }
  
  public static void setGesturePWD(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGesturePWD.uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",pw=");
      localStringBuilder.append(paramString2);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_gesture_pwd");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public static void setGesturePWDMode(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGesturePWDMode.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",mode=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_gesture_mode");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void setGestureUnlockFailed(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGestureUnlockFailed.uin=");
      localStringBuilder.append(paramString);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putString("gesturepassword_unlock_failed", paramString);
    paramContext.commit();
  }
  
  public static void setGestureUnlockFailedTime(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGestureUnlockFailedTime.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",failedTime=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_unlock_failed_time");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void setGestureUnlockFailedType(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGestureUnlockFailedType.type=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putInt("gesturepassword_unlock_failed_type", paramInt);
    paramContext.commit();
  }
  
  public static void setUinForPlugin(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUinForPlugin.uin=");
      localStringBuilder.append(paramString);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putString("gesturepassword_currentuin_forplugin", paramString);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil
 * JD-Core Version:    0.7.0.1
 */