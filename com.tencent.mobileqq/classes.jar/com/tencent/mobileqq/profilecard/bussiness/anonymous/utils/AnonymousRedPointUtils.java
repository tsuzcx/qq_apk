package com.tencent.mobileqq.profilecard.bussiness.anonymous.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.api.IAnonymousService;
import com.tencent.qphone.base.util.QLog;

public class AnonymousRedPointUtils
{
  private static final String KEY_PROFILE_RED_POINT_GUIDE_PREFIX = "anonymous_profile_red_point_guide_";
  private static final String KEY_SETTING_ME_RED_POINT_GUIDE_PREFIX = "anonymous_setting_me_red_point_guide_";
  private static final String RED_POINT_VALID_VERSION = "8.4.8";
  private static final String TAG = "AnonymousRedPointUtils";
  
  private static boolean checkRedPointValidVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousRedPointUtils", 2, String.format("checkRedPointValidVersion valid=%s", new Object[] { Boolean.valueOf(false) }));
    }
    return false;
  }
  
  public static void checkToCleanSettingMeRedPointGuide(AppInterface paramAppInterface)
  {
    boolean bool = showSettingMeRedPointGuide(paramAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousRedPointUtils", 2, String.format("checkToCleanSettingMeRedPointGuide showRedPoint=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    if ((bool) && (paramAppInterface != null))
    {
      Object localObject = paramAppInterface.getApp();
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("anonymous_setting_me_red_point_guide_");
      localStringBuilder.append(paramAppInterface);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static void cleanProfileRedPointGuide(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      Object localObject = paramAppInterface.getApp();
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("anonymous_profile_red_point_guide_");
      localStringBuilder.append(paramAppInterface);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousRedPointUtils", 2, String.format("cleanProfileRedPointGuide uin=%s", new Object[] { paramAppInterface }));
      }
    }
  }
  
  public static boolean showProfileRedPointGuide(AppInterface paramAppInterface)
  {
    boolean bool;
    if ((paramAppInterface != null) && (checkRedPointValidVersion()))
    {
      Object localObject = paramAppInterface.getApp();
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("anonymous_profile_red_point_guide_");
      localStringBuilder.append(paramAppInterface);
      bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    }
    else
    {
      paramAppInterface = null;
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousRedPointUtils", 2, String.format("showProfileRedPointGuide uin=%s show=%s", new Object[] { paramAppInterface, Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  public static boolean showSettingMeRedPointGuide(AppInterface paramAppInterface)
  {
    if ((paramAppInterface != null) && (checkRedPointValidVersion()))
    {
      Object localObject = paramAppInterface.getApp();
      String str = paramAppInterface.getCurrentAccountUin();
      paramAppInterface = (IAnonymousService)paramAppInterface.getRuntimeService(IAnonymousService.class, "");
      if (paramAppInterface != null) {
        bool1 = paramAppInterface.getSettingMeRedPointEnable();
      } else {
        bool1 = false;
      }
      paramAppInterface = str;
      bool2 = bool1;
      if (bool1)
      {
        paramAppInterface = PreferenceManager.getDefaultSharedPreferences((Context)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("anonymous_setting_me_red_point_guide_");
        ((StringBuilder)localObject).append(str);
        bool2 = paramAppInterface.getBoolean(((StringBuilder)localObject).toString(), true);
        paramAppInterface = str;
        break label119;
      }
    }
    else
    {
      paramAppInterface = null;
      bool2 = false;
    }
    boolean bool3 = false;
    boolean bool1 = bool2;
    boolean bool2 = bool3;
    label119:
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousRedPointUtils", 2, String.format("showSettingMeRedPointGuide uin=%s enable=%s show=%s", new Object[] { paramAppInterface, Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousRedPointUtils
 * JD-Core Version:    0.7.0.1
 */