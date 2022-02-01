package com.tencent.mobileqq.qqlive.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LoginCacheManager
{
  public String a = "";
  public String b = "";
  SharedPreferences c;
  private String d = "qq_live_cache";
  private String e = "qq_live_client_type";
  private String f = "qq_live_login_uid";
  private String g = "qq_live_login_A2";
  private String h = "qq_live_tiny_id";
  private String i = "qq_live_open_id";
  private String j = "qq_live_login_access_token";
  private String k = "qq_live_login_A2_expire_time";
  private String l = "qq_live_business_uid";
  private String m = "qq_live_last_login_time";
  private String n = "qq_live_user_nick";
  private String o = "qq_live_user_head_url";
  private String p = "qq_live_user_sex";
  
  public LoginCacheManager(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.a = paramString2;
    this.d = a(this.d);
    this.c = a(paramAppRuntime);
    this.g = a(this.g);
    this.e = a(this.e);
    this.f = a(this.f);
    this.h = a(this.h);
    this.i = a(this.i);
    this.j = a(this.j);
    this.k = a(this.k);
    this.l = a(this.l);
    this.m = a(this.m);
    this.n = a(this.n);
    this.o = a(this.o);
    this.p = a(this.p);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("the sp name: ");
    paramAppRuntime.append(this.d);
    QLog.d("LoginCacheManager", 4, paramAppRuntime.toString());
  }
  
  private final String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
  
  public SharedPreferences a(AppRuntime paramAppRuntime)
  {
    return paramAppRuntime.getApplicationContext().getSharedPreferences(this.d, 4);
  }
  
  public LoginInfo a()
  {
    LoginInfo localLoginInfo = new LoginInfo();
    localLoginInfo.originUin = this.c.getString("qq_live_qq_uin", "0");
    localLoginInfo.clientType = this.c.getInt(this.e, 0);
    localLoginInfo.uid = this.c.getLong(this.f, 0L);
    localLoginInfo.a2 = this.c.getString(this.g, "");
    localLoginInfo.a2ExpireTime = this.c.getLong(this.k, 0L);
    localLoginInfo.tinyid = this.c.getLong(this.h, 0L);
    localLoginInfo.openId = this.c.getString(this.i, "");
    localLoginInfo.businessUid = this.c.getString(this.l, "");
    localLoginInfo.accessToken = this.c.getString(this.j, "");
    localLoginInfo.lastLoginTime = this.c.getLong(this.m, 0L);
    return localLoginInfo;
  }
  
  public void a(LoginInfo paramLoginInfo, LiveUserInfo paramLiveUserInfo)
  {
    this.c.edit().putLong(this.f, paramLoginInfo.uid).putString("qq_live_qq_uin", this.a).putInt(this.e, paramLoginInfo.clientType).putString(this.g, paramLoginInfo.a2).putLong(this.h, paramLoginInfo.tinyid).putString(this.i, paramLoginInfo.openId).putString(this.j, paramLoginInfo.accessToken).putLong(this.k, paramLoginInfo.a2ExpireTime).putString(this.l, paramLoginInfo.businessUid).putLong(this.m, paramLoginInfo.lastLoginTime).putInt(this.p, paramLiveUserInfo.sex).putString(this.o, paramLiveUserInfo.headUrl).putString(this.n, paramLiveUserInfo.nick).apply();
  }
  
  public LiveUserInfo b()
  {
    LiveUserInfo localLiveUserInfo = new LiveUserInfo();
    localLiveUserInfo.nick = this.c.getString(this.n, "");
    localLiveUserInfo.headUrl = this.c.getString(this.o, "");
    localLiveUserInfo.sex = this.c.getInt(this.p, 1);
    localLiveUserInfo.uid = this.c.getLong(this.f, 0L);
    return localLiveUserInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.LoginCacheManager
 * JD-Core Version:    0.7.0.1
 */