package com.tencent.mobileqq.gesturelock;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class GesturePWDUtils
  extends BaseGesturePWDUtil
{
  public static boolean getJumpLock(Context paramContext, String paramString)
  {
    boolean bool = true;
    paramContext = getSharedPreferences(paramContext);
    int i = paramContext.getInt("gesturepassword_gesture_mode" + paramString, 21);
    if (i == 21) {
      if (paramContext.getInt("gesturepassword_gesture_state" + paramString, 0) != 2) {
        break label127;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.gesturelock.util", 2, "getJumpLock.uin=" + paramString + ",isjumplock=" + bool);
      }
      return bool;
      if ((i != 20) || (!paramContext.getBoolean("gesturepassword_locking", false))) {
        label127:
        bool = false;
      }
    }
  }
  
  public static String patternToString(List<LockPatternView.Cell> paramList)
  {
    if (paramList == null) {
      return "";
    }
    int j = paramList.size();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      LockPatternView.Cell localCell = (LockPatternView.Cell)paramList.get(i);
      int k = localCell.a();
      arrayOfByte[i] = ((byte)(localCell.b() + k * 3));
      i += 1;
    }
    return Arrays.toString(arrayOfByte);
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
        localObject = (DBFixManager)((QQAppInterface)localObject).getManager(QQManagerFactory.DB_FIX_MANAGER);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.GesturePWDUtils
 * JD-Core Version:    0.7.0.1
 */