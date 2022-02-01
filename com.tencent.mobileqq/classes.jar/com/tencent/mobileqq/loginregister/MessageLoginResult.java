package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.util.QQSettingUtil;
import mqq.app.AppRuntime;

public class MessageLoginResult
  extends BaseLoginResult
{
  public void a(Activity paramActivity, AppRuntime paramAppRuntime)
  {
    SharedPreferences.Editor localEditor = paramActivity.getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    int i = QQSettingUtil.a(paramActivity, paramAppRuntime.getCurrentAccountUin());
    QQSettingUtil.a(paramActivity, paramAppRuntime.getCurrentAccountUin(), i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.MessageLoginResult
 * JD-Core Version:    0.7.0.1
 */