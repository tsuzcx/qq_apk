package com.tencent.mobileqq.loginwelcome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.DenyRunnable.JumpSettingAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LoginUserGuideHelper
{
  private static String a(boolean paramBoolean, LoginWelcomeManager.ContactsGuideInfo paramContactsGuideInfo, LoginUserGuideHelper.LocationListener paramLocationListener)
  {
    int k = 1;
    int j = 0;
    StringBuilder localStringBuilder1 = new StringBuilder(200);
    localStringBuilder1.append(paramContactsGuideInfo.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("&ab_auth=");
    String str;
    int i;
    if (paramBoolean)
    {
      str = "1";
      localStringBuilder2.append(str);
      if (paramContactsGuideInfo.jdField_a_of_type_Int != -1) {
        localStringBuilder1.append("&friends_recommend_flag=").append(paramContactsGuideInfo.jdField_a_of_type_Int);
      }
      if (paramContactsGuideInfo.b != -1) {
        localStringBuilder1.append("&groups_recommend_flag=").append(paramContactsGuideInfo.b);
      }
      if ((paramLocationListener == null) || (!paramLocationListener.jdField_a_of_type_Boolean)) {
        break label196;
      }
      i = paramLocationListener.b;
      j = paramLocationListener.jdField_a_of_type_Int;
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
      paramContactsGuideInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("Login.Guide");
      if ((paramContactsGuideInfo != null) && (paramContactsGuideInfo.mLocation != null))
      {
        j = (int)(paramContactsGuideInfo.mLocation.mLat02 * 1000000.0D);
        i = (int)(paramContactsGuideInfo.mLocation.mLon02 * 1000000.0D);
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
    PermissionChecker.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.1(paramQQAppInterface), new DenyRunnable(paramActivity, new DenyRunnable.JumpSettingAction(paramQQAppInterface)));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, LoginUserGuideHelper.LocationListener paramLocationListener)
  {
    PermissionChecker.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, true, paramLocationListener), new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, false, paramLocationListener));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, LoginUserGuideHelper.LocationListener paramLocationListener)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "openWebGuide hasAuth: " + paramBoolean);
    }
    paramQQAppInterface = a(paramBoolean, LoginWelcomeManager.a(paramQQAppInterface).a(), paramLocationListener);
    paramLocationListener = new Intent(paramActivity, QQBrowserActivity.class);
    paramLocationListener.putExtra("is_wrap_content", true);
    paramLocationListener.putExtra("url", paramQQAppInterface);
    paramLocationListener.putExtra("hide_more_button", true);
    paramLocationListener.putExtra("webStyle", "noBottomBar");
    paramLocationListener.putExtra("isScreenOrientationPortrait", true);
    paramLocationListener.addFlags(603979776);
    paramActivity.startActivity(paramLocationListener);
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    NearbySPUtil.a("upload_for_new_guide", paramString, 4).edit().putString("upload_for_new_guide", paramJSONObject.toString()).commit();
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, LoginUserGuideHelper.LocationListener paramLocationListener)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "goWithoutFindFriend");
    }
    a(paramActivity, paramQQAppInterface, false, paramLocationListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper
 * JD-Core Version:    0.7.0.1
 */