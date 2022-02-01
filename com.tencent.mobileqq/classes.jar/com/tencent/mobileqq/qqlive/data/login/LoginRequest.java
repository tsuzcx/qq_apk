package com.tencent.mobileqq.qqlive.data.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class LoginRequest
{
  private static final String SP_KEY_EXT_DATA = "qq_live_login_customExtData";
  private static final String SP_KEY_QQ_A2 = "qq_live_login_QQ_A2";
  private static final String SP_KEY_UIN = "qq_live_login_uin";
  public String accessToken;
  public String extData;
  public String openId;
  public String qqA2;
  public String uin;
  
  public static LoginRequest getFromSp(Context paramContext)
  {
    LoginRequest localLoginRequest = new LoginRequest();
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    localLoginRequest.uin = paramContext.getString("qq_live_login_uin", "");
    localLoginRequest.qqA2 = paramContext.getString("qq_live_login_QQ_A2", "");
    localLoginRequest.extData = paramContext.getString("qq_live_login_customExtData", "");
    return localLoginRequest;
  }
  
  public void flushToSp(Context paramContext)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("qq_live_login_uin", this.uin).putString("qq_live_login_QQ_A2", this.qqA2).putString("qq_live_login_customExtData", this.extData).commit();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoginRequest{, uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", QQA2='");
    localStringBuilder.append(this.qqA2);
    localStringBuilder.append('\'');
    localStringBuilder.append(", customExtData='");
    localStringBuilder.append(this.extData);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.login.LoginRequest
 * JD-Core Version:    0.7.0.1
 */