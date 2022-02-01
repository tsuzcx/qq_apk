package com.tencent.mobileqq.qqexpand.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class CampusHelper
{
  public static SharedPreferences a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    BaseApplication localBaseApplication = paramBaseQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localStringBuilder.append("extend_friend_campus_file");
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://ti.qq.com/hybrid-h5/school_relation/extendeducation?fromid=2&_wv=16777220&_wwv=128&category=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("&schoolname=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&schoolid=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("&idx=");
      localStringBuilder.append(paramInt1);
      paramString1 = localStringBuilder.toString();
    }
    else
    {
      paramString1 = "https://ti.qq.com/hybrid-h5/school_relation/extendeducation?fromid=2&_wv=16777220&_wwv=128";
    }
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, String.format("jumpToEditSchoolInfoWebPage url=%s", new Object[] { paramString1 }));
    }
    paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramActivity.startActivity(paramString2);
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://h5.qzone.qq.com/v2/wezone/schoolauth?busitype=2&_wv=3&_proxy=1&idx=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&schoolname=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&schoolid=");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, String.format("jumpToSchoolCertificateWebPage url=%s", new Object[] { paramString1 }));
    }
    paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramActivity.startActivity(paramString2);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://ti.qq.com/hybrid-h5/school_relation/selectschool?fromid=2&_wv=16777222&_wwv=128&schoolname=");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramString = "https://ti.qq.com/hybrid-h5/school_relation/selectschool?fromid=2&_wv=16777222&_wwv=128";
    }
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, String.format("jumpToSchoolFillInWebPage url=%s", new Object[] { paramString }));
    }
    Object localObject = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    a(paramBaseQQAppInterface).edit().putBoolean("need_show_campus_certi_banner", paramBoolean).commit();
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("updateCampusCertificateBannerShowFlag result = ");
      paramBaseQQAppInterface.append(paramBoolean);
      QLog.d("CampusHelper", 2, paramBaseQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = a(paramQQAppInterface);
    int j = localSharedPreferences.getInt("campus_certi_status", -1);
    int i;
    if (paramInt1 != j) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localSharedPreferences.edit().putInt("campus_certi_status", paramInt1).commit();
      if (paramInt1 == 0) {
        a(paramQQAppInterface, true);
      } else if (paramInt2 == 2) {
        a(paramQQAppInterface, true);
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("updateCertificateBannerShowFlag  oldStatus = ");
      paramQQAppInterface.append(j);
      paramQQAppInterface.append(",newStatus = ");
      paramQQAppInterface.append(paramInt1);
      paramQQAppInterface.append(",certificateType = ");
      paramQQAppInterface.append(paramInt2);
      QLog.d("CampusHelper", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShowSchoolBeginnerTip ");
      localStringBuilder.append(paramBoolean);
      QLog.d("CampusHelper", 2, localStringBuilder.toString());
    }
    a(paramQQAppInterface).edit().putBoolean("extend_friend_school_beginner_guide", paramBoolean).commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = a(paramQQAppInterface).getBoolean("has_shown_fill_birthday_dialog_before", false);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("hasShownFillBirthdayDialogBefore result = ");
      paramQQAppInterface.append(bool);
      QLog.d("CampusHelper", 2, paramQQAppInterface.toString());
    }
    return bool;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface).edit().putBoolean("has_shown_fill_birthday_dialog_before", true).commit();
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "markHasShownFillBirthdayDialog ");
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool = a(paramQQAppInterface).getBoolean("need_show_campus_certi_banner", false);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getCampusCertificateBannerShowFlag result = ");
      paramQQAppInterface.append(bool);
      QLog.d("CampusHelper", 2, paramQQAppInterface.toString());
    }
    return bool;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return a(paramQQAppInterface).getBoolean("extend_friend_school_beginner_guide", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.CampusHelper
 * JD-Core Version:    0.7.0.1
 */