package com.tencent.mobileqq.loginwelcome;

import aihy;
import amkv;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aovo;
import atrd;
import atrn;
import aush;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LoginUserGuideHelper
{
  private static String a(boolean paramBoolean, atrn paramatrn, atrd paramatrd)
  {
    int k = 1;
    int j = 0;
    StringBuilder localStringBuilder1 = new StringBuilder(200);
    localStringBuilder1.append(paramatrn.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("&ab_auth=");
    String str;
    int i;
    if (paramBoolean)
    {
      str = "1";
      localStringBuilder2.append(str);
      if (paramatrn.jdField_a_of_type_Int != -1) {
        localStringBuilder1.append("&friends_recommend_flag=").append(paramatrn.jdField_a_of_type_Int);
      }
      if (paramatrn.b != -1) {
        localStringBuilder1.append("&groups_recommend_flag=").append(paramatrn.b);
      }
      if ((paramatrd == null) || (!paramatrd.jdField_a_of_type_Boolean)) {
        break label196;
      }
      i = paramatrd.b;
      j = paramatrd.jdField_a_of_type_Int;
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
      paramatrn = amkv.a("Login.Guide");
      if ((paramatrn != null) && (paramatrn.a != null))
      {
        j = (int)(paramatrn.a.a * 1000000.0D);
        i = (int)(paramatrn.a.b * 1000000.0D);
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
    aovo.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.1(paramQQAppInterface), new DenyRunnable(paramActivity, new aihy(paramQQAppInterface)));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, atrd paramatrd)
  {
    aovo.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, true, paramatrd), new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, false, paramatrd));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, atrd paramatrd)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "openWebGuide hasAuth: " + paramBoolean);
    }
    paramQQAppInterface = a(paramBoolean, LoginWelcomeManager.a(paramQQAppInterface).a(), paramatrd);
    paramatrd = new Intent(paramActivity, QQBrowserActivity.class);
    paramatrd.putExtra("is_wrap_content", true);
    paramatrd.putExtra("url", paramQQAppInterface);
    paramatrd.putExtra("hide_more_button", true);
    paramatrd.putExtra("webStyle", "noBottomBar");
    paramatrd.putExtra("isScreenOrientationPortrait", true);
    paramatrd.addFlags(603979776);
    paramActivity.startActivity(paramatrd);
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    aush.a("upload_for_new_guide", paramString, 4).edit().putString("upload_for_new_guide", paramJSONObject.toString()).commit();
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, atrd paramatrd)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "goWithoutFindFriend");
    }
    a(paramActivity, paramQQAppInterface, false, paramatrd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper
 * JD-Core Version:    0.7.0.1
 */