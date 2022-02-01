package com.tencent.mobileqq.loginwelcome;

import ajcr;
import akif;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awox;
import awph;
import axqc;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LoginUserGuideHelper
{
  private static String a(boolean paramBoolean, awph paramawph, awox paramawox)
  {
    int k = 1;
    int j = 0;
    StringBuilder localStringBuilder1 = new StringBuilder(200);
    localStringBuilder1.append(paramawph.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("&ab_auth=");
    String str;
    int i;
    if (paramBoolean)
    {
      str = "1";
      localStringBuilder2.append(str);
      if (paramawph.jdField_a_of_type_Int != -1) {
        localStringBuilder1.append("&friends_recommend_flag=").append(paramawph.jdField_a_of_type_Int);
      }
      if (paramawph.b != -1) {
        localStringBuilder1.append("&groups_recommend_flag=").append(paramawph.b);
      }
      if ((paramawox == null) || (!paramawox.jdField_a_of_type_Boolean)) {
        break label196;
      }
      i = paramawox.b;
      j = paramawox.jdField_a_of_type_Int;
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
      paramawph = LbsManagerService.getCachedLbsInfo("Login.Guide");
      if ((paramawph != null) && (paramawph.mLocation != null))
      {
        j = (int)(paramawph.mLocation.mLat02 * 1000000.0D);
        i = (int)(paramawph.mLocation.mLon02 * 1000000.0D);
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
    ajcr.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.1(paramQQAppInterface), new DenyRunnable(paramActivity, new akif(paramQQAppInterface)));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, awox paramawox)
  {
    ajcr.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, true, paramawox), new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, false, paramawox));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, awox paramawox)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "openWebGuide hasAuth: " + paramBoolean);
    }
    paramQQAppInterface = a(paramBoolean, LoginWelcomeManager.a(paramQQAppInterface).a(), paramawox);
    paramawox = new Intent(paramActivity, QQBrowserActivity.class);
    paramawox.putExtra("is_wrap_content", true);
    paramawox.putExtra("url", paramQQAppInterface);
    paramawox.putExtra("hide_more_button", true);
    paramawox.putExtra("webStyle", "noBottomBar");
    paramawox.putExtra("isScreenOrientationPortrait", true);
    paramawox.addFlags(603979776);
    paramActivity.startActivity(paramawox);
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    axqc.a("upload_for_new_guide", paramString, 4).edit().putString("upload_for_new_guide", paramJSONObject.toString()).commit();
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, awox paramawox)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "goWithoutFindFriend");
    }
    a(paramActivity, paramQQAppInterface, false, paramawox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper
 * JD-Core Version:    0.7.0.1
 */