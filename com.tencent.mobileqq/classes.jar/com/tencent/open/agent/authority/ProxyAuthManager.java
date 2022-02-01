package com.tencent.open.agent.authority;

import android.os.Bundle;
import com.tencent.open.agent.auth.model.INewAuthDataSource;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import java.util.List;
import mqq.app.MobileQQ;

public class ProxyAuthManager
{
  public void a(INewAuthDataSource paramINewAuthDataSource, boolean paramBoolean, String paramString1, String paramString2, List<Permission> paramList, long paramLong, AuthCallback paramAuthCallback, String paramString3, AccountInfo paramAccountInfo, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    String str2 = String.valueOf(System.currentTimeMillis());
    Object[] arrayOfObject = AuthorityUtil.a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramAccountInfo.a, "QQConnectLogin.auth", "QQConnectLogin.auth_emp");
    String str1 = (String)arrayOfObject[0];
    paramINewAuthDataSource.a(paramBundle, paramAccountInfo, paramBoolean, paramString1, paramString2, paramList, paramLong, paramString3, str2, arrayOfObject, new ProxyAuthManager.1(this, l, paramAccountInfo, str1, paramAuthCallback, "QQConnectLogin.auth_emp".equals(str1), str2, paramString2));
    paramINewAuthDataSource = new StringBuilder();
    paramINewAuthDataSource.append("cmd=");
    paramINewAuthDataSource.append(str1);
    paramINewAuthDataSource = paramINewAuthDataSource.toString();
    paramString1 = new StringBuilder();
    paramString1.append(", uin=*");
    paramString1.append(AuthorityUtil.a(paramAccountInfo.a));
    SSOLog.a("ProxyAuthManager", new Object[] { paramINewAuthDataSource, paramString1.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.authority.ProxyAuthManager
 * JD-Core Version:    0.7.0.1
 */