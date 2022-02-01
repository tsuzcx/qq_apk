package com.tencent.mobileqq.profilecard.bussiness.anonymous.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AnonymousRedPointUtils
{
  private static final String KEY_PROFILE_RED_POINT_GUIDE_PREFIX = "anonymous_profile_red_point_guide_";
  private static final String KEY_SETTING_ME_RED_POINT_GUIDE_PREFIX = "anonymous_setting_me_red_point_guide_";
  private static final String RED_POINT_VALID_VERSION = "8.4.8";
  private static final String TAG = "AnonymousRedPointUtils";
  
  private static boolean checkRedPointValidVersion()
  {
    boolean bool = "8.4.8".equals("8.5.5");
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousRedPointUtils", 2, String.format("checkRedPointValidVersion valid=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  public static void checkToCleanSettingMeRedPointGuide(QQAppInterface paramQQAppInterface)
  {
    boolean bool = showSettingMeRedPointGuide(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousRedPointUtils", 2, String.format("checkToCleanSettingMeRedPointGuide showRedPoint=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    if ((bool) && (paramQQAppInterface != null))
    {
      Object localObject = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("anonymous_setting_me_red_point_guide_" + paramQQAppInterface, false);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static void cleanProfileRedPointGuide(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("anonymous_profile_red_point_guide_" + paramQQAppInterface, false);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousRedPointUtils", 2, String.format("cleanProfileRedPointGuide uin=%s", new Object[] { paramQQAppInterface }));
      }
    }
  }
  
  public static boolean showProfileRedPointGuide(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = null;
    boolean bool;
    if ((paramQQAppInterface != null) && (checkRedPointValidVersion()))
    {
      localBaseApplication = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      bool = PreferenceManager.getDefaultSharedPreferences(localBaseApplication).getBoolean("anonymous_profile_red_point_guide_" + paramQQAppInterface, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousRedPointUtils", 2, String.format("showProfileRedPointGuide uin=%s show=%s", new Object[] { paramQQAppInterface, Boolean.valueOf(bool) }));
      }
      return bool;
      bool = false;
      paramQQAppInterface = localBaseApplication;
    }
  }
  
  public static boolean showSettingMeRedPointGuide(QQAppInterface paramQQAppInterface)
  {
    String str;
    boolean bool1;
    boolean bool2;
    if ((paramQQAppInterface != null) && (checkRedPointValidVersion()))
    {
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      str = paramQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = (AnonymousManager)paramQQAppInterface.getManager(QQManagerFactory.ANONYMOUS_ANSWER_MANAGER);
      if (paramQQAppInterface != null)
      {
        bool1 = paramQQAppInterface.getSettingMeRedPointEnable();
        if (bool1)
        {
          bool2 = PreferenceManager.getDefaultSharedPreferences(localBaseApplication).getBoolean("anonymous_setting_me_red_point_guide_" + str, true);
          paramQQAppInterface = str;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousRedPointUtils", 2, String.format("showSettingMeRedPointGuide uin=%s enable=%s show=%s", new Object[] { paramQQAppInterface, Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      return bool2;
      bool2 = false;
      paramQQAppInterface = str;
      continue;
      bool1 = false;
      break;
      paramQQAppInterface = null;
      bool2 = false;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.manager.AnonymousRedPointUtils
 * JD-Core Version:    0.7.0.1
 */