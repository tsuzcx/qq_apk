package com.tencent.mobileqq.loginwelcome;

import afxy;
import akfu;
import amnv;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import area;
import arek;
import asfc;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LoginUserGuideHelper
{
  private static String a(boolean paramBoolean, arek paramarek, area paramarea)
  {
    int k = 1;
    int j = 0;
    StringBuilder localStringBuilder1 = new StringBuilder(200);
    localStringBuilder1.append(paramarek.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("&ab_auth=");
    String str;
    int i;
    if (paramBoolean)
    {
      str = "1";
      localStringBuilder2.append(str);
      if (paramarek.jdField_a_of_type_Int != -1) {
        localStringBuilder1.append("&friends_recommend_flag=").append(paramarek.jdField_a_of_type_Int);
      }
      if (paramarek.b != -1) {
        localStringBuilder1.append("&groups_recommend_flag=").append(paramarek.b);
      }
      if ((paramarea == null) || (!paramarea.jdField_a_of_type_Boolean)) {
        break label196;
      }
      i = paramarea.b;
      j = paramarea.jdField_a_of_type_Int;
    }
    for (;;)
    {
      if (k != 0) {
        localStringBuilder1.append("&lat=").append(i).append("&lng=").append(j);
      }
      if (QLog.isColorLevel()) {
        QLog.i("LoginUserGuideHelper", 2, "makeUrl: " + localStringBuilder1.toString());
      }
      return localStringBuilder1.toString();
      str = "0";
      break;
      label196:
      paramarek = akfu.a("Login.Guide");
      if ((paramarek != null) && (paramarek.a != null))
      {
        j = (int)(paramarek.a.a * 1000000.0D);
        i = (int)(paramarek.a.b * 1000000.0D);
      }
      else
      {
        i = 0;
        k = 0;
      }
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    amnv.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.1(paramQQAppInterface), new DenyRunnable(paramActivity, new afxy(paramQQAppInterface)));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, area paramarea)
  {
    amnv.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, true, paramarea), new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, false, paramarea));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, area paramarea)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "openWebGuide hasAuth: " + paramBoolean);
    }
    paramQQAppInterface = a(paramBoolean, LoginWelcomeManager.a(paramQQAppInterface).a(), paramarea);
    paramarea = new Intent(paramActivity, QQBrowserActivity.class);
    paramarea.putExtra("is_wrap_content", true);
    paramarea.putExtra("url", paramQQAppInterface);
    paramarea.putExtra("hide_more_button", true);
    paramarea.putExtra("webStyle", "noBottomBar");
    paramarea.putExtra("isScreenOrientationPortrait", true);
    paramarea.addFlags(603979776);
    paramActivity.startActivity(paramarea);
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    asfc.a("upload_for_new_guide", paramString, 4).edit().putString("upload_for_new_guide", paramJSONObject.toString()).commit();
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, area paramarea)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "goWithoutFindFriend");
    }
    a(paramActivity, paramQQAppInterface, false, paramarea);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper
 * JD-Core Version:    0.7.0.1
 */