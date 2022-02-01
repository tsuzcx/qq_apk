package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.open.agent.auth.model.INewAuthDataSource;
import com.tencent.open.agent.auth.model.NewAuthDataSourceImpl;
import com.tencent.open.agent.entity.AppInfoResponse;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.qconn.protofile.appType.AndroidInfo;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qconn.protofile.preAuth.VirtualProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class SSOPreAuthPresenter
{
  private int a;
  
  private GetVirtualListResult a(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    GetVirtualListResult localGetVirtualListResult = new GetVirtualListResult();
    SSOLog.a("SSOPreAuthPresenter", new Object[] { "onPreAuthResponse response.profiles.has()=", Boolean.valueOf(paramPreAuthResponse.profiles.has()) });
    if (!paramPreAuthResponse.profiles.has()) {
      return localGetVirtualListResult;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramPreAuthResponse.profiles.get().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (preAuth.VirtualProfile)localIterator.next();
      VirtualInfo localVirtualInfo = new VirtualInfo();
      localVirtualInfo.jdField_a_of_type_Long = ((preAuth.VirtualProfile)localObject).vid.get();
      localVirtualInfo.jdField_a_of_type_JavaLangString = ((preAuth.VirtualProfile)localObject).nick_name.get();
      localVirtualInfo.jdField_b_of_type_JavaLangString = ((preAuth.VirtualProfile)localObject).avatar_url.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localVirtualInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", avatarUrl=");
      SSOLog.a("SSOPreAuthPresenter", new Object[] { "onPreAuthResponse nickName=", ((StringBuilder)localObject).toString(), localVirtualInfo.jdField_b_of_type_JavaLangString });
      localArrayList.add(localVirtualInfo);
    }
    localGetVirtualListResult.jdField_a_of_type_Long = paramPreAuthResponse.vid.get();
    localGetVirtualListResult.jdField_a_of_type_Int = paramPreAuthResponse.ret.get();
    localGetVirtualListResult.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return localGetVirtualListResult;
  }
  
  private List<Permission> a(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    ArrayList localArrayList = new ArrayList();
    if (!paramPreAuthResponse.auth_items.has()) {
      return localArrayList;
    }
    paramPreAuthResponse = paramPreAuthResponse.auth_items.get().iterator();
    while (paramPreAuthResponse.hasNext())
    {
      appType.AuthItem localAuthItem = (appType.AuthItem)paramPreAuthResponse.next();
      Permission localPermission = new Permission();
      localPermission.jdField_b_of_type_JavaLangString = localAuthItem.api_list.get();
      localPermission.jdField_a_of_type_Int = localAuthItem.default_flag.get();
      localPermission.jdField_b_of_type_Int = localAuthItem.id.get();
      boolean bool;
      if (localAuthItem.is_new.get() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localPermission.jdField_a_of_type_Boolean = bool;
      localPermission.jdField_a_of_type_JavaLangString = localAuthItem.title.get();
      SSOLog.a("SSOPreAuthPresenter", new Object[] { "onPreAuthResponse Permission=", localPermission.toString() });
      localArrayList.add(localPermission);
    }
    return localArrayList;
  }
  
  private void a(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    SSOLog.a("SSOPreAuthPresenter", new Object[] { "onPreAuthResponse" });
    if (!paramPreAuthResponse.appid.has()) {
      return;
    }
    String str = Long.toString(paramPreAuthResponse.appid.get());
    AuthMemoryCache.a().a(str, paramPreAuthResponse);
    Object localObject = a(paramPreAuthResponse);
    AuthMemoryCache.a().a(str, (List)localObject);
    if (paramPreAuthResponse.android_info.has())
    {
      localObject = AppInfoResponse.a(paramPreAuthResponse, paramPreAuthResponse.android_info);
      AuthMemoryCache.a().a(str, (AppInfoResponse)localObject);
    }
    paramPreAuthResponse = a(paramPreAuthResponse);
    AuthMemoryCache.a().a(str, paramPreAuthResponse);
  }
  
  public void a(String paramString1, String paramString2, Activity paramActivity, String paramString3, Bundle paramBundle, SSOPreAuthPresenter.PreAuthCallback paramPreAuthCallback)
  {
    paramString2 = AuthMemoryCache.a().a(paramString2);
    if ((paramString2 != null) && (paramActivity != null))
    {
      a(paramString3, paramString1, AuthParamUtil.a(paramBundle, "key_proxy_appid"), paramBundle, paramString2, paramPreAuthCallback, 2);
      return;
    }
    SSOLog.a("SSOPreAuthPresenter", new Object[] { "updatePreAuthFromServer account=", paramString2, ", context=", paramActivity });
    paramPreAuthCallback.a(-1, "");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle, AccountInfo paramAccountInfo, SSOPreAuthPresenter.PreAuthCallback paramPreAuthCallback, int paramInt)
  {
    AuthReporter.a("KEY_PRE_AUTH");
    Object[] arrayOfObject = AuthorityUtil.a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramAccountInfo.jdField_a_of_type_JavaLangString, "QQConnectLogin.pre_auth", "QQConnectLogin.pre_auth_emp");
    String str = (String)arrayOfObject[0];
    boolean bool = "QQConnectLogin.pre_auth_emp".equals(str);
    SSOLog.a("SSOPreAuthPresenter", new Object[] { "preAuthWithRetry cmd=", str });
    new NewAuthDataSourceImpl().a(paramString1, paramString2, paramString3, paramBundle, paramAccountInfo, arrayOfObject, new SSOPreAuthPresenter.1(this, str, paramAccountInfo, bool, paramPreAuthCallback, paramInt, paramString1, paramString2, paramString3, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SSOPreAuthPresenter
 * JD-Core Version:    0.7.0.1
 */