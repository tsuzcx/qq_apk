package com.tencent.mobileqq.gesturelock;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
    paramContext = getSharedPreferences(paramContext);
    StringBuilder localStringBuilder = AIOUtils.a();
    localStringBuilder.append("gesturepassword_gesture_mode");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 21);
    boolean bool = true;
    if (i == 21)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("gesturepassword_gesture_state");
      localStringBuilder.append(paramString);
      if (paramContext.getInt(localStringBuilder.toString(), 0) == 2) {
        break label113;
      }
    }
    else
    {
      if ((i == 20) && (paramContext.getBoolean("gesturepassword_locking", false))) {
        break label113;
      }
    }
    bool = false;
    label113:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getJumpLock.uin=");
      paramContext.append(paramString);
      paramContext.append(",isjumplock=");
      paramContext.append(bool);
      QLog.d("Q.gesturelock.util", 2, paramContext.toString());
    }
    return bool;
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
      arrayOfByte[i] = ((byte)(localCell.a() * 3 + localCell.b()));
      i += 1;
    }
    return Arrays.toString(arrayOfByte);
  }
  
  public static void setAppForground(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAppForground.uin=,isAppFroground=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.gesturelock.util", 2, ((StringBuilder)localObject).toString());
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
    else if (paramContext != null)
    {
      ThreadManager.post(new GesturePWDUtils.2(paramContext), 8, null, false);
    }
  }
  
  public static void setGesturePWDState(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGesturePWDState.uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",state=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.gesturelock.util", 2, localStringBuilder.toString());
    }
    paramContext = getSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gesturepassword_gesture_state");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    if ((paramContext.commit()) && (paramInt == 2)) {
      com.tencent.mobileqq.app.BaseActivity.isUnLockSuccess = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.GesturePWDUtils
 * JD-Core Version:    0.7.0.1
 */