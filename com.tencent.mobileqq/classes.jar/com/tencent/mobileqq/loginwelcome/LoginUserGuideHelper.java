package com.tencent.mobileqq.loginwelcome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.DenyRunnable.JumpSettingAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
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
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append(paramContactsGuideInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&ab_auth=");
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    localStringBuilder.append(str);
    if (paramContactsGuideInfo.jdField_a_of_type_Int != -1)
    {
      localStringBuilder.append("&friends_recommend_flag=");
      localStringBuilder.append(paramContactsGuideInfo.jdField_a_of_type_Int);
    }
    if (paramContactsGuideInfo.b != -1)
    {
      localStringBuilder.append("&groups_recommend_flag=");
      localStringBuilder.append(paramContactsGuideInfo.b);
    }
    int k = 1;
    int i = 0;
    int j;
    if ((paramLocationListener != null) && (paramLocationListener.jdField_a_of_type_Boolean))
    {
      i = paramLocationListener.b;
      j = paramLocationListener.jdField_a_of_type_Int;
    }
    else
    {
      paramContactsGuideInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("Login.Guide");
      if ((paramContactsGuideInfo != null) && (paramContactsGuideInfo.mLocation != null))
      {
        j = (int)(paramContactsGuideInfo.mLocation.mLat02 * 1000000.0D);
        i = (int)(paramContactsGuideInfo.mLocation.mLon02 * 1000000.0D);
      }
      else
      {
        k = 0;
        j = 0;
      }
    }
    if (k != 0)
    {
      localStringBuilder.append("&lat=");
      localStringBuilder.append(i);
      localStringBuilder.append("&lng=");
      localStringBuilder.append(j);
    }
    if (QLog.isColorLevel())
    {
      paramContactsGuideInfo = new StringBuilder();
      paramContactsGuideInfo.append("makeUrl: ");
      paramContactsGuideInfo.append(localStringBuilder.toString());
      QLog.i("LoginUserGuideHelper", 2, paramContactsGuideInfo.toString());
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if (paramActivity != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      PermissionChecker.a(paramActivity, new LoginUserGuideHelper.1(paramQQAppInterface), new DenyRunnable(paramActivity, new DenyRunnable.JumpSettingAction(paramQQAppInterface)));
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, LoginUserGuideHelper.LocationListener paramLocationListener)
  {
    PermissionChecker.a(paramActivity, new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, true, paramLocationListener), new LoginUserGuideHelper.GuideRunnable(paramActivity, paramQQAppInterface, false, paramLocationListener));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, LoginUserGuideHelper.LocationListener paramLocationListener)
  {
    if (paramActivity != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openWebGuide hasAuth: ");
        localStringBuilder.append(paramBoolean);
        QLog.i("LoginUserGuideHelper", 2, localStringBuilder.toString());
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
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getSharedPreferences("upload_for_new_guide", paramString, 4).edit().putString("upload_for_new_guide", paramJSONObject.toString()).commit();
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, LoginUserGuideHelper.LocationListener paramLocationListener)
  {
    if (paramActivity != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("LoginUserGuideHelper", 2, "goWithoutFindFriend");
      }
      a(paramActivity, paramQQAppInterface, false, paramLocationListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper
 * JD-Core Version:    0.7.0.1
 */