package com.tencent.mobileqq.settings.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.MedalApiPlugin;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment;

public class PrivacySettingUtil
{
  public static Intent a()
  {
    return new Intent();
  }
  
  public static void a(AppInterface paramAppInterface, MedalApiPlugin paramMedalApiPlugin, Intent paramIntent, byte paramByte)
  {
    if (SettingsConfigHelper.a(paramAppInterface))
    {
      PublicFragmentActivity.a(paramMedalApiPlugin.a(), paramIntent, PermissionPrivacyFragment.class);
      return;
    }
    paramIntent.setClass(paramMedalApiPlugin.a(), PermisionPrivacyActivity.class);
    paramMedalApiPlugin.startActivityForResult(paramIntent, paramByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if (SettingsConfigHelper.a(paramQQAppInterface))
    {
      PublicFragmentActivity.a(paramContext, paramIntent, PermissionPrivacyFragment.class);
      return;
    }
    paramIntent.setClass(paramContext, PermisionPrivacyActivity.class);
    paramContext.startActivity(paramIntent);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return SettingsConfigHelper.a(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.util.PrivacySettingUtil
 * JD-Core Version:    0.7.0.1
 */