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
import avor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;

public class GesturePWDUtils
{
  public static final int GESTUREPWD_MODE_AUTO = 21;
  public static final int GESTUREPWD_MODE_MANUAL = 20;
  public static final int GESTUREPWD_STATE_CLOSED = 1;
  public static final int GESTUREPWD_STATE_NOTSET = 0;
  public static final int GESTUREPWD_STATE_OPEN = 2;
  public static final int GESTUREPWD_UNLOCKFAILED_TYPE_FORGET = 0;
  public static final int GESTUREPWD_UNLOCKFAILED_TYPE_WRONG = 1;
  public static final String GESTURE_SALT = "28DF17A9B837BAFD951724E325F6F86B5B6E477D";
  private static final String KEY_GESTURE_APP_FORGROUND = "gesturepassword_appforground";
  private static final String KEY_GESTURE_CURRENTUIN_FORPLUGIN = "gesturepassword_currentuin_forplugin";
  private static final String KEY_GESTURE_LOCKING = "gesturepassword_locking";
  private static final String KEY_GESTURE_MODE = "gesturepassword_gesture_mode";
  private static final String KEY_GESTURE_PWD = "gesturepassword_gesture_pwd";
  private static final String KEY_GESTURE_SHAREPRE_NAME = "gesturepassword_sharepreference";
  private static final String KEY_GESTURE_STATE = "gesturepassword_gesture_state";
  private static final String KEY_GESTURE_UNLOCK_FAILED = "gesturepassword_unlock_failed";
  private static final String KEY_GESTURE_UNLOCK_FAILED_TIME = "gesturepassword_unlock_failed_time";
  private static final String KEY_GESTURE_UNLOCK_FAILED_TYPE = "gesturepassword_unlock_failed_type";
  public static final int PROCESS_STATE_TOP = 2;
  private static final String UTIL_TAG = "Q.gesturelock.util";
  private static Field mProcStateField;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 21) && (mProcStateField == null)) {}
    try
    {
      mProcStateField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.gesturelock.util", 2, "getDeclaredField processState", localException);
    }
  }
  
  public static void clearGestureData(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "clearGestureData.uin=" + paramString);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putInt("gesturepassword_gesture_state" + paramString, 0);
    paramContext.putString("gesturepassword_gesture_pwd" + paramString, "");
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
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      } while (((ActivityManager.RunningAppProcessInfo)localObject).pid != i);
    }
    for (paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;; paramContext = "") {
      return (paramContext != null) && ((paramContext.equals(str + ":qzone")) || (paramContext.equals(str + ":picture")) || (paramContext.equals(str + ":qqfav")) || (paramContext.equals(str + ":qlink")));
    }
  }
  
  public static String encodeGesture(String paramString1, String paramString2)
  {
    paramString1 = MD5.toMD5(paramString1);
    int j = "28DF17A9B837BAFD951724E325F6F86B5B6E477D".length();
    if (!TextUtils.isEmpty(paramString2)) {}
    for (int i = paramString2.length();; i = 0)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new StringBuilder(paramString1);
        paramString1.insert(6, "28DF17A9B837BAFD951724E325F6F86B5B6E477D".substring(0, j / 2));
        paramString1.insert(paramString1.length() - 9, "28DF17A9B837BAFD951724E325F6F86B5B6E477D".substring(j / 2, j));
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1.insert(2, paramString2.substring(0, i / 2));
          paramString1.insert(paramString1.length() - 5, paramString2.substring(i / 2, i));
        }
      }
      for (paramString1 = paramString1.toString();; paramString1 = "") {
        return MD5.toMD5(paramString1);
      }
    }
  }
  
  public static boolean getAppForground(Context paramContext)
  {
    boolean bool = getAppSharedPreferences(paramContext).getBoolean("gesturepassword_appforground", false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getAppForground.uin=,isAppFroground=" + bool);
    }
    return bool;
  }
  
  private static SharedPreferences getAppSharedPreferences(Context paramContext)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("gesturepassword_sharepreference", 4);
  }
  
  public static boolean getGestureLocking(Context paramContext)
  {
    boolean bool = getSharedPreferences(paramContext).getBoolean("gesturepassword_locking", false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureLocking.uin=,islocking=" + bool);
    }
    return bool;
  }
  
  public static String getGesturePWD(Context paramContext, String paramString)
  {
    paramContext = getSharedPreferences(paramContext).getString("gesturepassword_gesture_pwd" + paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGesturePWD.uin=" + paramString + ",pw=" + paramContext);
    }
    return paramContext;
  }
  
  public static int getGesturePWDMode(Context paramContext, String paramString)
  {
    int i = getSharedPreferences(paramContext).getInt("gesturepassword_gesture_mode" + paramString, 21);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGesturePWDMode.uin=" + paramString + ",mode=" + i);
    }
    return i;
  }
  
  public static int getGesturePWDState(Context paramContext, String paramString)
  {
    int i = getSharedPreferences(paramContext).getInt("gesturepassword_gesture_state" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGesturePWDState.uin=" + paramString + ",state=" + i);
    }
    return i;
  }
  
  public static boolean getGestureUnlockFailed(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = getSharedPreferences(paramContext);
    String str = paramContext.getString("gesturepassword_unlock_failed", "");
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.equals(paramString))
        {
          bool1 = bool2;
          if (paramContext.getInt("gesturepassword_gesture_state" + paramString, 0) == 0) {
            bool1 = true;
          }
        }
      }
    }
    paramContext = paramContext.edit();
    paramContext.putString("gesturepassword_unlock_failed", "");
    paramContext.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGestureUnlockFailed.uin=" + paramString + ",ret=" + bool1);
    }
    return bool1;
  }
  
  public static int getGestureUnlockFailedTime(Context paramContext, String paramString)
  {
    int i = getSharedPreferences(paramContext).getInt("gesturepassword_unlock_failed_time" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGestureUnlockFailedTime.uin=" + paramString + ",failedTime=" + i);
    }
    return i;
  }
  
  public static int getGestureUnlockFailedType(Context paramContext)
  {
    int i = getSharedPreferences(paramContext).getInt("gesturepassword_unlock_failed_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGestureUnlockFailedType.type=" + i);
    }
    return i;
  }
  
  public static boolean getJumpLock(Context paramContext, String paramString)
  {
    boolean bool = true;
    paramContext = getSharedPreferences(paramContext);
    int i = paramContext.getInt("gesturepassword_gesture_mode" + paramString, 21);
    if (i == 21) {
      if (paramContext.getInt("gesturepassword_gesture_state" + paramString, 0) != 2) {
        break label129;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.gesturelock.util", 2, "getJumpLock.uin=" + paramString + ",isjumplock=" + bool);
      }
      return bool;
      if ((i != 20) || (!paramContext.getBoolean("gesturepassword_locking", false))) {
        label129:
        bool = false;
      }
    }
  }
  
  private static SharedPreferences getSharedPreferences(Context paramContext)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("gesturepassword_sharepreference", 4);
  }
  
  public static boolean getSplashLock(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      paramContext = getSharedPreferences(paramContext);
      i = paramContext.getInt("gesturepassword_gesture_mode" + paramString, 21);
      if (i != 21) {
        break label132;
      }
      if (paramContext.getInt("gesturepassword_gesture_state" + paramString, 0) != 2) {
        break label161;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.gesturelock.util", 2, "getSplashLock.uin=" + paramString + ",islock=" + bool1);
      }
      return bool1;
      label132:
      bool1 = bool3;
      if (i == 20)
      {
        bool1 = bool3;
        if (paramContext.getBoolean("gesturepassword_locking", false))
        {
          bool1 = true;
          continue;
          label161:
          bool1 = false;
        }
      }
    }
  }
  
  public static String getUinForPlugin(Context paramContext)
  {
    paramContext = getSharedPreferences(paramContext).getString("gesturepassword_currentuin_forplugin", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getUinForPlugin.uin=" + paramContext);
    }
    return paramContext;
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    if (Foreground.sCountActivity > 0) {
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
    if (Foreground.sCountActivity > 0) {
      return true;
    }
    ActivityManager localActivityManager = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject = localActivityManager.getRunningTasks(1);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
          if ((localObject != null) && (((ActivityManager.RunningTaskInfo)localObject).baseActivity != null) && (!paramContext.equals(((ActivityManager.RunningTaskInfo)localObject).baseActivity.getPackageName())))
          {
            QLog.d("Q.gesturelock.util", 2, "qq runningTaskI is not top");
            return false;
          }
        }
        localObject = localActivityManager.getRunningAppProcesses();
        if (localObject == null) {
          return false;
        }
        int k = Process.myPid();
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label433;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo == null) || (k == localRunningAppProcessInfo.pid) || (!localRunningAppProcessInfo.processName.startsWith(paramContext)) || (localRunningAppProcessInfo.processName.endsWith("MSF")) || (localRunningAppProcessInfo.processName.endsWith("TMAssistantDownloadSDKService"))) {
          continue;
        }
        i = localRunningAppProcessInfo.importance;
        if (i != 100) {
          break label440;
        }
        try
        {
          if (mProcStateField != null)
          {
            i = mProcStateField.getInt(localRunningAppProcessInfo);
            j = i;
            if (i != 2) {
              continue;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("Q.gesturelock.util", 2, "isAppOnForegroundByTasks is true, realforeProcessName=" + localRunningAppProcessInfo.processName);
              printServiceInfos(localActivityManager, paramContext);
            }
            return true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.gesturelock.util", 2, "isAppOnForegroundByTasks, mProcStateField is null");
          }
          return true;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label435;
          }
        }
        QLog.e("Q.gesturelock.util", 2, "isAppOnForegroundByTasks", localException);
      }
      catch (Exception paramContext)
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        if (!QLog.isColorLevel()) {
          break label433;
        }
        QLog.e("Q.gesturelock.util", 2, "isAppOnForegroundByTasks.uin", paramContext);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("Q.gesturelock.util", 2, "isAppOnForegroundByTasks, procName=" + localRunningAppProcessInfo.processName + ",importance=" + localRunningAppProcessInfo.importance + ",reasonCode=" + localRunningAppProcessInfo.importanceReasonCode + ",procState=" + j + ",pid=" + localRunningAppProcessInfo.pid);
        continue;
        label433:
        return false;
        label435:
        i = 0;
        continue;
        label440:
        j = 0;
      }
    }
  }
  
  public static String patternToString(List<avor> paramList)
  {
    if (paramList == null) {
      return "";
    }
    int j = paramList.size();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      avor localavor = (avor)paramList.get(i);
      int k = localavor.a();
      arrayOfByte[i] = ((byte)(localavor.b() + k * 3));
      i += 1;
    }
    return Arrays.toString(arrayOfByte);
  }
  
  private static void printServiceInfos(ActivityManager paramActivityManager, String paramString)
  {
    Object localObject = null;
    if (paramActivityManager != null) {
      localObject = paramActivityManager.getRunningServices(1000);
    }
    if (localObject != null)
    {
      paramActivityManager = ((List)localObject).iterator();
      while (paramActivityManager.hasNext())
      {
        localObject = (ActivityManager.RunningServiceInfo)paramActivityManager.next();
        if ((localObject != null) && (((ActivityManager.RunningServiceInfo)localObject).foreground == true) && (((ActivityManager.RunningServiceInfo)localObject).process.startsWith(paramString))) {
          QLog.d("Q.gesturelock.util", 2, "foreground service=" + ((ActivityManager.RunningServiceInfo)localObject).service.getClassName());
        }
      }
    }
  }
  
  public static void setAppForground(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setAppForground.uin=,isAppFroground=" + paramBoolean);
    }
    Object localObject = getAppSharedPreferences(paramContext).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("gesturepassword_appforground", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (paramBoolean)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (DBFixManager)((QQAppInterface)localObject).getManager(205);
        if (localObject != null) {
          ((DBFixManager)localObject).a(paramContext);
        }
      }
      if (paramContext != null) {
        ThreadManager.post(new GesturePWDUtils.1(paramContext), 8, null, false);
      }
    }
    while (paramContext == null) {
      return;
    }
    ThreadManager.post(new GesturePWDUtils.2(paramContext), 8, null, false);
  }
  
  public static void setGestureLocking(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureLocking.uin=,islock=" + paramBoolean);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putBoolean("gesturepassword_locking", paramBoolean);
    paramContext.commit();
  }
  
  public static void setGesturePWD(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGesturePWD.uin=" + paramString1 + ",pw=" + paramString2);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putString("gesturepassword_gesture_pwd" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void setGesturePWDMode(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGesturePWDMode.uin=" + paramString + ",mode=" + paramInt);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putInt("gesturepassword_gesture_mode" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void setGesturePWDState(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGesturePWDState.uin=" + paramString + ",state=" + paramInt);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putInt("gesturepassword_gesture_state" + paramString, paramInt);
    if ((paramContext.commit()) && (paramInt == 2)) {
      com.tencent.mobileqq.app.BaseActivity.isUnLockSuccess = true;
    }
  }
  
  public static void setGestureUnlockFailed(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureUnlockFailed.uin=" + paramString);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putString("gesturepassword_unlock_failed", paramString);
    paramContext.commit();
  }
  
  public static void setGestureUnlockFailedTime(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureUnlockFailedTime.uin=" + paramString + ",failedTime=" + paramInt);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putInt("gesturepassword_unlock_failed_time" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void setGestureUnlockFailedType(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureUnlockFailedType.type=" + paramInt);
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putInt("gesturepassword_unlock_failed_type", paramInt);
    paramContext.commit();
  }
  
  public static void setUinForPlugin(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setUinForPlugin.uin=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramContext = getSharedPreferences(paramContext).edit();
    paramContext.putString("gesturepassword_currentuin_forplugin", paramString);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.GesturePWDUtils
 * JD-Core Version:    0.7.0.1
 */