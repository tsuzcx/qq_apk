package com.tencent.mobileqq.litelivesdk.utils;

import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.login.LoginManager;

public class CookieHelper
{
  public static String a()
  {
    Object localObject2 = BusinessManager.a.a();
    LoginResult localLoginResult = LoginManager.a.a();
    label60:
    int i;
    label114:
    long l;
    if (localLoginResult == null)
    {
      localObject1 = "";
      StringBuilder localStringBuilder = new StringBuilder().append("uin=o").append((String)localObject1).append(";skey=");
      if (0 == 0) {
        break label244;
      }
      localObject1 = new String(null);
      localObject1 = (String)localObject1;
      localObject1 = (String)localObject1 + ";versioncode=10001";
      localObject1 = new StringBuilder().append((String)localObject1).append(";__client_type=");
      if (localObject2 != null) {
        break label250;
      }
      i = 0;
      localObject1 = i;
      localObject1 = new StringBuilder().append((String)localObject1).append(";ilive_uin=");
      if (localLoginResult != null) {
        break label259;
      }
      l = 0L;
      label147:
      localObject1 = l;
      localObject2 = new StringBuilder().append((String)localObject1).append(";ilive_tinyid=");
      if (localLoginResult != null) {
        break label268;
      }
      localObject1 = "";
      label182:
      localObject1 = (String)localObject1;
      localObject2 = new StringBuilder().append((String)localObject1).append(";ilive_a2=");
      if (localLoginResult != null) {
        break label277;
      }
    }
    label259:
    label268:
    label277:
    for (Object localObject1 = "";; localObject1 = localLoginResult.e)
    {
      return (String)localObject1;
      localObject1 = String.valueOf(LoginManager.a.a().a);
      break;
      label244:
      localObject1 = "";
      break label60;
      label250:
      i = ((BusinessConfig)localObject2).d;
      break label114;
      l = localLoginResult.a;
      break label147;
      localObject1 = localLoginResult.f;
      break label182;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.CookieHelper
 * JD-Core Version:    0.7.0.1
 */