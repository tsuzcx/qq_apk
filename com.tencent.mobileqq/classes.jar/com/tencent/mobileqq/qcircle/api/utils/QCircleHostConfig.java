package com.tencent.mobileqq.qcircle.api.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QCircleHostConfig
{
  private static final String TAG = "QCircleHostConfig";
  
  public static long getGetFollowUserTime()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("sp_last_getfollowuser_time", 0L);
    }
    return l;
  }
  
  public static long getPushFuleCountTime()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("qcircle_fule_count_push_time", 0L);
    }
    return l;
  }
  
  public static SharedPreferences getQCircleSp()
  {
    String str = ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
    str = "sp_qqcirlce_business" + str;
    return MobileQQ.sMobileQQ.getSharedPreferences(str, 0);
  }
  
  public static int isNeedShowMessageEntranceTips()
  {
    int i = -1;
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("qcircle_show_message_enter_guide_tips", -1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleHostConfig", 1, "isNeedShowMessageEntranceTips: " + i);
    }
    return i;
  }
  
  public static void saveGetFollowUserTime(long paramLong)
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("sp_last_getfollowuser_time", paramLong).apply();
    }
  }
  
  public static void savePushFuleCountTime(long paramLong)
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qcircle_fule_count_push_time", paramLong).apply();
    }
  }
  
  public static void setNeedShowMessageEntranceTips(boolean paramBoolean)
  {
    Object localObject = getQCircleSp();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int i = 1;; i = 0)
    {
      ((SharedPreferences.Editor)localObject).putInt("qcircle_show_message_enter_guide_tips", i).apply();
      if (QLog.isColorLevel()) {
        QLog.d("QCircleHostConfig", 1, "setShowMessageEntranceTips: " + paramBoolean);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig
 * JD-Core Version:    0.7.0.1
 */