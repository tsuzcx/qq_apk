package com.tencent.mobileqq.msf.core.auth;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.util;

public final class m
{
  private static final String a = "WtLoginDeviceToken";
  private static final String b = "mobileQQ_device_token";
  
  public static String a(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ_device_token", 0).getString(paramString, null);
  }
  
  static void a(String paramString, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.d("WtLoginDeviceToken", 1, "MSF save device token failed, uin=" + paramString + ",md5=" + paramArrayOfByte);
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ_device_token", 0);
    paramArrayOfByte = util.buf_to_string(paramArrayOfByte);
    localSharedPreferences.edit().putString(paramString, paramArrayOfByte).commit();
    QLog.d("WtLoginDeviceToken", 1, "MSF save device token success, uin=" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.m
 * JD-Core Version:    0.7.0.1
 */