package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.auth.model.FileDataSource;
import com.tencent.open.agent.auth.model.INewAuthDataSource;
import com.tencent.open.agent.auth.model.NewAuthDataSourceImpl;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.authority.ProxyAuthManager;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SSOSdkAuthApiPresenter
{
  private INewAuthDataSource jdField_a_of_type_ComTencentOpenAgentAuthModelINewAuthDataSource = new NewAuthDataSourceImpl();
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private Bundle a(Bundle paramBundle)
  {
    paramBundle = new Bundle(paramBundle);
    paramBundle.putString("openapi", "");
    paramBundle.putBoolean("doAuthorize", true);
    paramBundle.putString("need_pay", "1");
    paramBundle.putString("appid_for_getting_config", AuthParamUtil.a(paramBundle, "client_id"));
    return paramBundle;
  }
  
  private void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2, List<Permission> paramList, long paramLong, AuthCallback paramAuthCallback, String paramString3)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.intValue();
    }
    if ((paramInt == 1002) && (i < 1))
    {
      SSOLog.a("SSOSdkAuthApiPresenter", new Object[] { "OpenVirtual.doAuthorize retry" });
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, Integer.valueOf(i + 1));
      a(paramBoolean, paramString1, paramString2, paramList, paramLong, paramAuthCallback, paramString3);
      return;
    }
    if (paramAuthCallback != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, Integer.valueOf(0));
      paramAuthCallback.a(false, -1, null);
    }
  }
  
  private void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2, List<Permission> paramList, long paramLong, AuthCallback paramAuthCallback, String paramString3, AccountInfo paramAccountInfo)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.intValue();
    }
    if ((paramInt == 1002) && (i < 1))
    {
      SSOLog.a("SSOSdkAuthApiPresenter", new Object[] { "OpenVirtual.doAuthorize retry" });
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, Integer.valueOf(i + 1));
      a(paramBoolean, paramString1, paramString2, paramList, paramLong, paramAuthCallback, paramString3);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, Integer.valueOf(0));
    paramAuthCallback.a(false, paramInt, null);
    AuthReporter.a("agent_authority", AuthMemoryCache.a().a(paramString1), 0L, 0L, paramInt, paramAccountInfo.a, "");
    AuthReporter.a(1, "LOGIN_AUTH", paramAccountInfo.a, paramString1, 3002, "");
    paramString2 = ReportCenter.a();
    paramList = paramAccountInfo.a;
    paramAuthCallback = new StringBuilder();
    paramAuthCallback.append("");
    paramAuthCallback.append(3002);
    paramString2.a(paramList, "", paramString1, "1", "6", paramAuthCallback.toString(), false, true);
    SSOLog.a("SSOSdkAuthApiPresenter", new Object[] { "doAuthorize onReceive failed" });
  }
  
  private void a(Bundle paramBundle, long paramLong, int paramInt, String paramString1, String paramString2, AccountInfo paramAccountInfo, AuthCallback paramAuthCallback)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, Integer.valueOf(0));
    try
    {
      byte[] arrayOfByte = AuthorityUtil.a(paramBundle, "ConnAuthSvr.sdk_auth_api_emp".equals(paramString2), paramAccountInfo);
      if (arrayOfByte == null) {}
      try
      {
        paramAuthCallback.a(false, paramInt, null);
        return;
      }
      catch (Exception paramBundle) {}
      SdkAuthorize.AuthorizeResponse localAuthorizeResponse = (SdkAuthorize.AuthorizeResponse)new SdkAuthorize.AuthorizeResponse().mergeFrom(arrayOfByte);
      int i = localAuthorizeResponse.ret.get();
      if (i == 0) {}
      try
      {
        FileDataSource.a(paramString1, paramAccountInfo.a, localAuthorizeResponse.expires_in.get(), arrayOfByte);
        paramAuthCallback.a(true, i, AuthResponse.a(localAuthorizeResponse));
        break label131;
        paramAuthCallback.a(false, i, AuthResponse.a(localAuthorizeResponse));
        label131:
        long l1 = localAuthorizeResponse.toByteArray().length;
        AuthReporter.a(paramBundle, paramLong, i, 13, paramString2, paramString1, paramAccountInfo.a);
        paramLong = AuthMemoryCache.a().a(paramString1);
        long l2 = arrayOfByte.length;
        paramBundle = paramAccountInfo.a;
        paramString2 = new StringBuilder();
        paramString2.append("ret: ");
        paramString2.append(i);
        AuthReporter.a("agent_authority", paramLong, l2, l1, 0, paramBundle, paramString2.toString());
        AuthReporter.a(0, "LOGIN_AUTH", paramAccountInfo.a, paramString1, i, null);
        return;
      }
      catch (Exception paramBundle)
      {
        paramInt = i;
      }
      paramAuthCallback.a(false, paramInt, null);
    }
    catch (Exception paramBundle) {}
    SSOLog.c("SSOSdkAuthApiPresenter", "Exception", paramBundle);
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, List<Permission> paramList, long paramLong, AuthCallback paramAuthCallback, String paramString3, AccountInfo paramAccountInfo, Bundle paramBundle)
  {
    paramBundle = a(paramBundle);
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    long l = System.currentTimeMillis();
    localObject1 = AuthorityUtil.a((AppRuntime)localObject1, paramAccountInfo.a, "ConnAuthSvr.sdk_auth_api", "ConnAuthSvr.sdk_auth_api_emp");
    String str = (String)localObject1[0];
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("OpenVirtual.doAuthorize.send | cmd: ");
    ((StringBuilder)localObject2).append(str);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" | uin : *");
    localStringBuilder.append(AuthorityUtil.a(paramAccountInfo.a));
    SSOLog.a("SSOSdkAuthApiPresenter", new Object[] { localObject2, localStringBuilder.toString() });
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelINewAuthDataSource.a(paramBundle, paramAccountInfo, paramBoolean, paramString1, paramString2, paramList, paramLong, paramString3, (Object[])localObject1, new SSOSdkAuthApiPresenter.1(this, l, str, paramAccountInfo, paramString1, paramBoolean, paramString2, paramList, paramLong, paramAuthCallback, paramString3));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, List<Permission> paramList, long paramLong, AuthCallback paramAuthCallback, String paramString3)
  {
    SSOLog.a("SSOSdkAuthApiPresenter", new Object[] { "doAuthorize" });
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (TextUtils.isEmpty(paramString2)) {
      localObject = paramString1;
    } else {
      localObject = paramString2;
    }
    AccountInfo localAccountInfo = AuthMemoryCache.a().a((String)localObject);
    Object localObject = AuthMemoryCache.a().a((String)localObject);
    if ((localAppRuntime != null) && (localObject != null) && (localAccountInfo != null))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        new ProxyAuthManager().a(this.jdField_a_of_type_ComTencentOpenAgentAuthModelINewAuthDataSource, paramBoolean, paramString1, paramString2, paramList, paramLong, paramAuthCallback, paramString3, localAccountInfo, (Bundle)localObject);
        return;
      }
      a(paramBoolean, paramString1, paramString2, paramList, paramLong, paramAuthCallback, paramString3, localAccountInfo, (Bundle)localObject);
      return;
    }
    SSOLog.b("SSOSdkAuthApiPresenter", new Object[] { "OpenVirtual.doAuthorize return for param is null." });
    paramAuthCallback.a(false, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SSOSdkAuthApiPresenter
 * JD-Core Version:    0.7.0.1
 */