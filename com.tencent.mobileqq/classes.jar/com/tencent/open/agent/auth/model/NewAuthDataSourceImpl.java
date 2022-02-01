package com.tencent.open.agent.auth.model;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.authority.CGICallback;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.util.AuthModelUtil;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.ParseUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.qconn.protofile.appType.LoginSig;
import com.tencent.qconn.protofile.auth.AuthRequest;
import com.tencent.qconn.protofile.auth.ProxyAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthProxyRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class NewAuthDataSourceImpl
  implements INewAuthDataSource
{
  private static String a = "NewAuthDataSourceImpl";
  
  public void a(long paramLong, AccountInfo paramAccountInfo, boolean paramBoolean, CGICallback paramCGICallback)
  {
    ThreadManagerV2.executeOnSubThread(new NewAuthDataSourceImpl.1(this, paramLong, paramAccountInfo, paramCGICallback, paramBoolean));
  }
  
  public void a(Bundle paramBundle, AccountInfo paramAccountInfo, boolean paramBoolean, String paramString1, String paramString2, List<Permission> paramList, long paramLong, String paramString3, String paramString4, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver)
  {
    auth.AuthRequest localAuthRequest = new auth.AuthRequest();
    localAuthRequest.appid.set(ParseUtil.a(paramString1));
    localAuthRequest.need_paytoken.set(1);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (Permission)paramString1.next();
        if (paramList.jdField_b_of_type_Boolean)
        {
          localAuthRequest.openapi.add(Integer.valueOf(paramList.jdField_b_of_type_Int));
          SSOLog.a(a, new Object[] { "doAuthorize Permission.id=", Integer.valueOf(paramList.jdField_b_of_type_Int) });
        }
      }
    }
    paramList = localAuthRequest.os;
    if (Build.VERSION.RELEASE == null) {
      paramString1 = "";
    } else {
      paramString1 = Build.VERSION.RELEASE;
    }
    paramList.set(paramString1);
    localAuthRequest.qqv.set(CommonDataAdapter.a().d());
    localAuthRequest.app_type.set(1);
    localAuthRequest.pf.set(AuthParamUtil.a(paramBundle, "pf", "openmobile_android"));
    paramList = paramBundle.getString("sdkp");
    PBStringField localPBStringField = localAuthRequest.sdkp;
    paramString1 = paramList;
    if (TextUtils.isEmpty(paramList)) {
      paramString1 = "android";
    }
    localPBStringField.set(paramString1);
    paramList = paramBundle.getString("sdkv");
    localPBStringField = localAuthRequest.sdkv;
    paramString1 = paramList;
    if (TextUtils.isEmpty(paramList)) {
      paramString1 = "1.5.9";
    }
    localPBStringField.set(paramString1);
    localAuthRequest.response_type.set(0);
    paramString1 = AuthParamUtil.a(paramBundle, "sign");
    if (!TextUtils.isEmpty(paramString1))
    {
      localAuthRequest.sign.set(paramString1);
      paramString1 = AuthParamUtil.a(paramBundle, "time");
      if (!TextUtils.isEmpty(paramString1)) {
        localAuthRequest.md5time.set(ParseUtil.a(paramString1));
      }
    }
    else
    {
      paramList = OpenSdkVirtualUtil.a(paramString3);
      paramString1 = paramList[1];
      paramList = paramList[2];
      SSOLog.a(a, new Object[] { "OpenVirtual.doAuthorize.getAuthorizeSign again" });
      if (TextUtils.isEmpty(paramString1))
      {
        SSOLog.a(a, new Object[] { "OpenVirtual.doAuthorize.getAuthorizeSign sign is null" });
      }
      else
      {
        localAuthRequest.sign.set(paramString1);
        if (!TextUtils.isEmpty(paramList)) {
          localAuthRequest.md5time.set(ParseUtil.a(paramList));
        }
      }
    }
    paramBundle = AuthModelUtil.a(paramBundle);
    if (!TextUtils.isEmpty(paramBundle)) {
      localAuthRequest.pass_data.set(paramBundle);
    }
    localAuthRequest.skey.set(paramAccountInfo.b);
    if (paramBoolean) {
      localAuthRequest.referer.set(4);
    }
    localAuthRequest.vid.set(paramLong);
    paramBundle = new auth.ProxyAuthRequest();
    paramBundle.appid.set(ParseUtil.a(paramString2));
    localAuthRequest.proxy_auth_req.set(paramBundle);
    if (!TextUtils.isEmpty(paramString3)) {
      localAuthRequest.app_unique_identifier.set(paramString3);
    } else {
      SSOLog.a(a, new Object[] { "OpenVirtual.doAuthorize.appUniqueIdentifier is null" });
    }
    localAuthRequest.state.set(paramString4);
    if ((paramArrayOfObject[1] instanceof appType.LoginSig)) {
      localAuthRequest.login_sig.set((appType.LoginSig)paramArrayOfObject[1]);
    }
    paramBundle = (String)paramArrayOfObject[0];
    paramString1 = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
    paramString1.setWithouLogin(true);
    paramString1.putExtra("uin", paramAccountInfo.a);
    paramString1.putExtra("data", AuthorityUtil.a(localAuthRequest, "QQConnectLogin.auth_emp".equals(paramBundle), paramAccountInfo));
    paramString1.putExtra("cmd", paramBundle);
    paramString1.setObserver(paramOpensdkBusinessObserver);
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(paramString1);
  }
  
  public void a(Bundle paramBundle, AccountInfo paramAccountInfo, boolean paramBoolean, String paramString1, String paramString2, List<Permission> paramList, long paramLong, String paramString3, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver)
  {
    SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
    localAuthorizeRequest.client_id.set(ParseUtil.a(paramString1));
    localAuthorizeRequest.need_pay.set(1);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (Permission)paramString1.next();
        if (paramString2.jdField_b_of_type_Boolean)
        {
          localAuthorizeRequest.openapi.add(Integer.valueOf(paramString2.jdField_b_of_type_Int));
          SSOLog.a(a, new Object[] { "doAuthorize Permission.id=", Integer.valueOf(paramString2.jdField_b_of_type_Int) });
        }
      }
    }
    paramString2 = localAuthorizeRequest.os;
    if (Build.VERSION.RELEASE == null) {
      paramString1 = "";
    } else {
      paramString1 = Build.VERSION.RELEASE;
    }
    paramString2.set(paramString1);
    localAuthorizeRequest.qqv.set(CommonDataAdapter.a().d());
    localAuthorizeRequest.app_type.set(1);
    localAuthorizeRequest.pf.set(AuthParamUtil.a(paramBundle, "pf", "openmobile_android"));
    paramString2 = paramBundle.getString("sdkp");
    paramList = localAuthorizeRequest.sdkp;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "android";
    }
    paramList.set(paramString1);
    paramString2 = paramBundle.getString("sdkv");
    paramList = localAuthorizeRequest.sdkv;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "1.5.9";
    }
    paramList.set(paramString1);
    localAuthorizeRequest.response_type.set("token");
    paramString1 = AuthParamUtil.a(paramBundle, "sign");
    if (!TextUtils.isEmpty(paramString1))
    {
      localAuthorizeRequest.sign.set(paramString1);
      paramString1 = AuthParamUtil.a(paramBundle, "time");
      if (!TextUtils.isEmpty(paramString1)) {
        localAuthorizeRequest.time.set(ParseUtil.a(paramString1));
      }
    }
    else
    {
      paramString2 = OpenSdkVirtualUtil.a(paramString3);
      paramString1 = paramString2[1];
      paramString2 = paramString2[2];
      SSOLog.a(a, new Object[] { "OpenVirtual.doAuthorize.getAuthorizeSign again" });
      if (TextUtils.isEmpty(paramString1))
      {
        SSOLog.a(a, new Object[] { "OpenVirtual.doAuthorize.getAuthorizeSign sign is null" });
      }
      else
      {
        localAuthorizeRequest.sign.set(paramString1);
        if (!TextUtils.isEmpty(paramString2)) {
          localAuthorizeRequest.time.set(ParseUtil.a(paramString2));
        }
      }
    }
    paramBundle = AuthModelUtil.a(paramBundle);
    if (!TextUtils.isEmpty(paramBundle)) {
      localAuthorizeRequest.passData.set(paramBundle);
    }
    localAuthorizeRequest.skey.set(paramAccountInfo.b);
    if (paramBoolean) {
      localAuthorizeRequest.referer.set(4);
    }
    localAuthorizeRequest.vID.set(paramLong);
    AuthorityUtil.a(localAuthorizeRequest.url_encoded_data, true);
    if (!TextUtils.isEmpty(paramString3)) {
      localAuthorizeRequest.appUniqueIdentifier.set(paramString3);
    } else {
      SSOLog.a(a, new Object[] { "OpenVirtual.doAuthorize.appUniqueIdentifier is null" });
    }
    if ((paramArrayOfObject[1] instanceof appType.LoginSig)) {
      localAuthorizeRequest.login_sig.set((appType.LoginSig)paramArrayOfObject[1]);
    }
    paramBundle = (String)paramArrayOfObject[0];
    paramString1 = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
    paramString1.setWithouLogin(true);
    paramString1.putExtra("uin", paramAccountInfo.a);
    paramString1.putExtra("data", AuthorityUtil.a(localAuthorizeRequest, "ConnAuthSvr.sdk_auth_api_emp".equals(paramBundle), paramAccountInfo));
    paramString1.putExtra("cmd", paramBundle);
    OpenSdkVirtualUtil.a(paramString1);
    paramString1.setObserver(paramOpensdkBusinessObserver);
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle, AccountInfo paramAccountInfo, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver)
  {
    preAuth.PreAuthRequest localPreAuthRequest = new preAuth.PreAuthRequest();
    localPreAuthRequest.appid.set(ParseUtil.a(paramString2));
    localPreAuthRequest.sdkp.set(AuthParamUtil.a(paramBundle, "sdkp", "android"));
    localPreAuthRequest.sdkv.set(AuthParamUtil.a(paramBundle, "sdkv", "1.5.9"));
    localPreAuthRequest.qqv.set(CommonDataAdapter.a().d());
    PBStringField localPBStringField = localPreAuthRequest.os;
    if (Build.VERSION.RELEASE == null) {
      paramString2 = "";
    } else {
      paramString2 = Build.VERSION.RELEASE;
    }
    localPBStringField.set(paramString2);
    localPreAuthRequest.scope.set(AuthParamUtil.a(paramBundle, "scope", ""));
    localPreAuthRequest.skey.set(paramAccountInfo.b);
    localPreAuthRequest.app_type.set(1);
    localPreAuthRequest.url_encoded_data.set("support_110509=1");
    boolean bool = TextUtils.isEmpty(paramString1);
    int i = 4;
    if (!bool)
    {
      localPreAuthRequest.appUniqueIdentifier.set(paramString1);
      paramString1 = OpenSdkVirtualUtil.a(paramString1);
      SSOLog.a(a, new Object[] { "preAuthWithRetry.getAuthorizeSign sign=", paramString1[1], ", timestr=", paramString1[2] });
      if (!TextUtils.isEmpty(paramString1[1]))
      {
        localPreAuthRequest.sign.set(paramString1[1]);
        if (!TextUtils.isEmpty(paramString1[2])) {
          localPreAuthRequest.md5time.set(ParseUtil.a(paramString1[2]));
        }
      }
    }
    bool = AuthParamUtil.a(paramBundle, "key_login_by_qr_scan", false);
    paramString1 = localPreAuthRequest.referer;
    if (!bool) {
      i = 1;
    }
    paramString1.set(i);
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = new preAuth.PreAuthProxyRequest();
      paramString1.appid.set(ParseUtil.a(paramString3));
      localPreAuthRequest.proxy_req.set(paramString1);
    }
    if ((paramArrayOfObject[1] instanceof appType.LoginSig)) {
      localPreAuthRequest.login_sig.set((appType.LoginSig)paramArrayOfObject[1]);
    }
    paramString1 = (String)paramArrayOfObject[0];
    paramString2 = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
    paramString2.putExtra("uin", paramAccountInfo.a);
    paramString2.putExtra("data", AuthorityUtil.a(localPreAuthRequest, "QQConnectLogin.pre_auth_emp".equals(paramString1), paramAccountInfo));
    paramString2.putExtra("cmd", paramString1);
    paramString2.putExtra("timeout", 15000L);
    paramString2.putExtra("key_support_retry", true);
    paramString2.setObserver(paramOpensdkBusinessObserver);
    paramString2.setWithouLogin(true);
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.NewAuthDataSourceImpl
 * JD-Core Version:    0.7.0.1
 */