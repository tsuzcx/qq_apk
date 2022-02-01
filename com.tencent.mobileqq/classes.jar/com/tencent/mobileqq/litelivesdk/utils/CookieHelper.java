package com.tencent.mobileqq.litelivesdk.utils;

import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.login.LoginManager;

public class CookieHelper
{
  public static String a()
  {
    Object localObject = BusinessManager.a.b();
    LoginResult localLoginResult = LoginManager.c.c();
    String str2 = "";
    if (localLoginResult == null) {
      str1 = "";
    } else {
      str1 = String.valueOf(LoginManager.c.c().e);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append(str1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append("");
    String str1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(";versioncode=10001");
    str1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(";__client_type=");
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((BusinessConfig)localObject).f;
    }
    localStringBuilder.append(i);
    str1 = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(";ilive_uin=");
    long l;
    if (localLoginResult == null) {
      l = 0L;
    } else {
      l = localLoginResult.e;
    }
    ((StringBuilder)localObject).append(l);
    str1 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(";ilive_tinyid=");
    if (localLoginResult == null) {
      str1 = "";
    } else {
      str1 = localLoginResult.g;
    }
    ((StringBuilder)localObject).append(str1);
    str1 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(";ilive_a2=");
    if (localLoginResult == null) {
      str1 = str2;
    } else {
      str1 = localLoginResult.f;
    }
    ((StringBuilder)localObject).append(str1);
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.CookieHelper
 * JD-Core Version:    0.7.0.1
 */