package com.tencent.open.agent.auth.model;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.adapter.CommonDataAdapter;
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
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.qconn.protofile.appType.LoginSig;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.open.agent.entity.Permission;>;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class OldAuthDataSourceImpl
  implements IOldAuthDataSource
{
  private static String a = "OldAuthorityDataSourceImpl";
  private AppRuntime b = MobileQQ.sMobileQQ.waitAppRuntime(null);
  
  public void a(Bundle paramBundle, AccountInfo paramAccountInfo, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver)
  {
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    localGetAuthApiListRequest.client_id.set(ParseUtil.a(paramBundle.getString("client_id")));
    Object localObject2 = localGetAuthApiListRequest.os;
    if (Build.VERSION.RELEASE == null) {
      localObject1 = "";
    } else {
      localObject1 = Build.VERSION.RELEASE;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localGetAuthApiListRequest.qqv.set(CommonDataAdapter.a().j());
    localGetAuthApiListRequest.app_type.set(1);
    localGetAuthApiListRequest.pf.set(AuthParamUtil.a(paramBundle, "pf", ""));
    localGetAuthApiListRequest.scope.set(AuthParamUtil.a(paramBundle, "scope", ""));
    if (paramBundle.getBoolean("key_login_by_qr_scan", false)) {
      localGetAuthApiListRequest.referer.set(4);
    }
    localObject2 = paramBundle.getString("sdkv");
    PBStringField localPBStringField = localGetAuthApiListRequest.sdkv;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "1.5.9";
    }
    localPBStringField.set((String)localObject1);
    localObject2 = paramBundle.getString("sdkp");
    localPBStringField = localGetAuthApiListRequest.sdkp;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "android";
    }
    localPBStringField.set((String)localObject1);
    localObject1 = paramBundle.getString("sign");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localGetAuthApiListRequest.sign.set((String)localObject1);
      localObject1 = paramBundle.getString("time");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localGetAuthApiListRequest.time.set(ParseUtil.a((String)localObject1));
      }
    }
    localGetAuthApiListRequest.need_pay.set(1);
    localGetAuthApiListRequest.skey.set(paramAccountInfo.b);
    paramBundle = AuthParamUtil.b(paramBundle);
    if (!TextUtils.isEmpty(paramBundle)) {
      localGetAuthApiListRequest.appUniqueIdentifier.set(paramBundle);
    }
    AuthorityUtil.a(localGetAuthApiListRequest.url_encoded_data, true);
    if ((paramArrayOfObject[1] instanceof appType.LoginSig)) {
      localGetAuthApiListRequest.login_sig.set((appType.LoginSig)paramArrayOfObject[1]);
    }
    paramBundle = (String)paramArrayOfObject[0];
    paramArrayOfObject = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
    paramArrayOfObject.setWithouLogin(true);
    paramArrayOfObject.putExtra("uin", paramAccountInfo.a);
    paramArrayOfObject.putExtra("data", AuthorityUtil.a(localGetAuthApiListRequest, "ConnAuthSvr.get_auth_api_list_emp".equals(paramBundle), paramAccountInfo));
    paramArrayOfObject.putExtra("cmd", paramBundle);
    paramArrayOfObject.setObserver(paramOpensdkBusinessObserver);
    this.b.startServlet(paramArrayOfObject);
  }
  
  public void a(List<Permission> paramList, Bundle paramBundle, AccountInfo paramAccountInfo, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver)
  {
    SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
    localAuthorizeRequest.client_id.set(ParseUtil.a(paramBundle.getString("client_id")));
    localAuthorizeRequest.need_pay.set(1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (Permission)paramList.next();
      if (((Permission)localObject).a > 0) {
        localAuthorizeRequest.openapi.add(Integer.valueOf(((Permission)localObject).e));
      }
    }
    Object localObject = localAuthorizeRequest.os;
    if (Build.VERSION.RELEASE == null) {
      paramList = "";
    } else {
      paramList = Build.VERSION.RELEASE;
    }
    ((PBStringField)localObject).set(paramList);
    localAuthorizeRequest.app_type.set(1);
    localAuthorizeRequest.qqv.set(CommonDataAdapter.a().j());
    localAuthorizeRequest.pf.set(AuthParamUtil.a(paramBundle, "pf", "openmobile_android"));
    localObject = paramBundle.getString("sdkp");
    PBStringField localPBStringField = localAuthorizeRequest.sdkp;
    paramList = (List<Permission>)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramList = "android";
    }
    localPBStringField.set(paramList);
    localObject = paramBundle.getString("sdkv");
    localPBStringField = localAuthorizeRequest.sdkv;
    paramList = (List<Permission>)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramList = "1.5.9";
    }
    localPBStringField.set(paramList);
    localAuthorizeRequest.response_type.set("token");
    paramList = AuthParamUtil.b(paramBundle);
    if (!TextUtils.isEmpty(paramList)) {
      localAuthorizeRequest.appUniqueIdentifier.set(paramList);
    } else {
      SSOLog.a(a, new Object[] { "doAuthorize.appUniqueIdentifier is null" });
    }
    localObject = paramBundle.getString("sign");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localAuthorizeRequest.sign.set((String)localObject);
      paramList = paramBundle.getString("time");
      if (!TextUtils.isEmpty(paramList)) {
        localAuthorizeRequest.time.set(ParseUtil.a(paramList));
      }
    }
    else
    {
      localObject = OpenSdkVirtualUtil.a(paramList);
      paramList = localObject[1];
      localObject = localObject[2];
      SSOLog.a(a, new Object[] { "doAuthorize.getAuthorizeSign again" });
      if (TextUtils.isEmpty(paramList))
      {
        SSOLog.a(a, new Object[] { "doAuthorize.getAuthorizeSign sign is null" });
      }
      else
      {
        localAuthorizeRequest.sign.set(paramList);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localAuthorizeRequest.time.set(ParseUtil.a((String)localObject));
        }
      }
    }
    paramList = AuthModelUtil.a(paramBundle);
    if (!TextUtils.isEmpty(paramList)) {
      localAuthorizeRequest.passData.set(paramList);
    }
    localAuthorizeRequest.skey.set(paramAccountInfo.b);
    if ((paramArrayOfObject[1] instanceof appType.LoginSig)) {
      localAuthorizeRequest.login_sig.set((appType.LoginSig)paramArrayOfObject[1]);
    }
    AuthorityUtil.a(localAuthorizeRequest.url_encoded_data, true);
    paramList = (String)paramArrayOfObject[0];
    paramBundle = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
    paramBundle.setWithouLogin(true);
    paramBundle.putExtra("uin", paramAccountInfo.a);
    paramBundle.putExtra("data", AuthorityUtil.a(localAuthorizeRequest, "ConnAuthSvr.sdk_auth_api_emp".equals(paramList), paramAccountInfo));
    paramBundle.putExtra("cmd", paramList);
    OpenSdkVirtualUtil.a(paramBundle);
    paramBundle.setObserver(paramOpensdkBusinessObserver);
    this.b.startServlet(paramBundle);
  }
  
  public void b(Bundle paramBundle, AccountInfo paramAccountInfo, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver)
  {
    long l = ParseUtil.a(AuthParamUtil.a(paramBundle, "client_id"));
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(l);
    localGetAppinfoRequest.sdkp.set(AuthParamUtil.a(paramBundle, "sdkp", "android"));
    PBStringField localPBStringField = localGetAppinfoRequest.os;
    String str;
    if (Build.VERSION.RELEASE == null) {
      str = "";
    } else {
      str = Build.VERSION.RELEASE;
    }
    localPBStringField.set(str);
    localGetAppinfoRequest.qqv.set(CommonDataAdapter.a().j());
    localGetAppinfoRequest.app_type.set(1);
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.need_ads.set(1);
    paramBundle = AuthParamUtil.b(paramBundle);
    if (!TextUtils.isEmpty(paramBundle)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramBundle);
    }
    localGetAppinfoRequest.referer.set(1);
    localGetAppinfoRequest.skey.set(paramAccountInfo.b);
    if ((paramArrayOfObject[1] instanceof appType.LoginSig)) {
      localGetAppinfoRequest.login_sig.set((appType.LoginSig)paramArrayOfObject[1]);
    }
    paramBundle = (String)paramArrayOfObject[0];
    paramArrayOfObject = new NewIntent(MobileQQ.sMobileQQ, OpensdkServlet.class);
    paramArrayOfObject.setWithouLogin(true);
    paramArrayOfObject.putExtra("uin", paramAccountInfo.a);
    paramArrayOfObject.putExtra("data", AuthorityUtil.a(localGetAppinfoRequest, "ConnAuthSvr.get_app_info_emp".equals(paramBundle), paramAccountInfo));
    paramArrayOfObject.putExtra("cmd", paramBundle);
    paramArrayOfObject.setObserver(paramOpensdkBusinessObserver);
    this.b.startServlet(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.OldAuthDataSourceImpl
 * JD-Core Version:    0.7.0.1
 */