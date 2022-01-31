package com.tencent.mobileqq.loginwelcome;

import agju;
import akuf;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aneh;
import asad;
import asan;
import atbi;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LoginUserGuideHelper
{
  private static String a(boolean paramBoolean, asan paramasan, asad paramasad)
  {
    int k = 1;
    int j = 0;
    StringBuilder localStringBuilder1 = new StringBuilder(200);
    localStringBuilder1.append(paramasan.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("&ab_auth=");
    String str;
    int i;
    if (paramBoolean)
    {
      str = "1";
      localStringBuilder2.append(str);
      if (paramasan.jdField_a_of_type_Int != -1) {
        localStringBuilder1.append("&friends_recommend_flag=").append(paramasan.jdField_a_of_type_Int);
      }
      if (paramasan.b != -1) {
        localStringBuilder1.append("&groups_recommend_flag=").append(paramasan.b);
      }
      if ((paramasad == null) || (!paramasad.jdField_a_of_type_Boolean)) {
        break label196;
      }
      i = paramasad.b;
      j = paramasad.jdField_a_of_type_Int;
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
      paramasan = akuf.a("Login.Guide");
      if ((paramasan != null) && (paramasan.a != null))
      {
        j = (int)(paramasan.a.a * 1000000.0D);
        i = (int)(paramasan.a.b * 1000000.0D);
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
    aneh.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.1(paramQQAppInterface), new DenyRunnable(paramActivity, new agju(paramQQAppInterface)));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, asad paramasad)
  {
    aneh.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, true, paramasad), new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, false, paramasad));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, asad paramasad)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "openWebGuide hasAuth: " + paramBoolean);
    }
    paramQQAppInterface = a(paramBoolean, LoginWelcomeManager.a(paramQQAppInterface).a(), paramasad);
    paramasad = new Intent(paramActivity, QQBrowserActivity.class);
    paramasad.putExtra("is_wrap_content", true);
    paramasad.putExtra("url", paramQQAppInterface);
    paramasad.putExtra("hide_more_button", true);
    paramasad.putExtra("webStyle", "noBottomBar");
    paramasad.putExtra("isScreenOrientationPortrait", true);
    paramasad.addFlags(603979776);
    paramActivity.startActivity(paramasad);
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    atbi.a("upload_for_new_guide", paramString, 4).edit().putString("upload_for_new_guide", paramJSONObject.toString()).commit();
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, asad paramasad)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "goWithoutFindFriend");
    }
    a(paramActivity, paramQQAppInterface, false, paramasad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper
 * JD-Core Version:    0.7.0.1
 */