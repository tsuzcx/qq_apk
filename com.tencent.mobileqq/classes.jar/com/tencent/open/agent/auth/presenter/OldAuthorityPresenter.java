package com.tencent.open.agent.auth.presenter;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.auth.IOldAuthorityContract.Presenter;
import com.tencent.open.agent.auth.IOldAuthorityContract.View;
import com.tencent.open.agent.auth.model.FileDataSource;
import com.tencent.open.agent.auth.model.ILocalDataSource;
import com.tencent.open.agent.auth.model.IOldAuthDataSource;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.entity.IconUrlSize;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.util.AuthModelUtil;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.ParseUtil;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class OldAuthorityPresenter
  extends BaseAuthorityPresenter
  implements IOldAuthorityContract.Presenter
{
  private final IOldAuthorityContract.View jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View;
  private final IOldAuthDataSource jdField_a_of_type_ComTencentOpenAgentAuthModelIOldAuthDataSource;
  private AuthResponse jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse;
  private int d;
  private int e;
  private long g;
  
  public OldAuthorityPresenter(IOldAuthorityContract.View paramView, IOldAuthDataSource paramIOldAuthDataSource, ILocalDataSource paramILocalDataSource)
  {
    super(paramView, paramILocalDataSource);
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View = paramView;
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelIOldAuthDataSource = paramIOldAuthDataSource;
  }
  
  private void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse = null;
    if (paramInt == 1002)
    {
      int i = this.jdField_d_of_type_Int;
      if (i < 2)
      {
        this.jdField_d_of_type_Int = (i + 1);
        h();
        return;
      }
    }
    a(3001, 2131694639);
    a("KEY_GET_AUTH_API_LIST_REQUEST", this.jdField_d_of_type_Int, false);
    String str = MobileQQ.sMobileQQ.getResources().getString(2131694639);
    AuthReporter.a("agent_query_authority", paramLong, 0L, 0L, paramInt, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, str);
    AuthReporter.a(1, "LOGIN_GETAUTHLIST_AGENT", this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramInt, str);
    AuthReporter.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "2", String.valueOf(paramInt), false);
    AuthReporter.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "6", String.valueOf(paramInt), false);
  }
  
  private void a(int paramInt, List<Permission> paramList)
  {
    if (paramInt == 1002)
    {
      int i = this.jdField_e_of_type_Int;
      if (i < 1)
      {
        this.jdField_e_of_type_Int = (i + 1);
        a(paramList);
        return;
      }
    }
    this.jdField_e_of_type_Int = 0;
    a(3002, 2131694647);
    a("KEY_AUTHORIZE_REQUEST", this.jdField_e_of_type_Int, false);
    paramList = MobileQQ.sMobileQQ.getResources().getString(2131694647);
    AuthReporter.a("agent_authority", this.jdField_g_of_type_Long, 0L, 0L, paramInt, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, paramList);
    AuthReporter.a(1, "LOGIN_AUTH", this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 3002, paramList);
    paramList = this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString;
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(3002);
    AuthReporter.a(paramList, str, "6", localStringBuilder.toString(), false);
  }
  
  private void a(Bundle paramBundle, String paramString)
  {
    this.jdField_e_of_type_Int = 0;
    try
    {
      byte[] arrayOfByte = AuthorityUtil.a(paramBundle, "ConnAuthSvr.sdk_auth_api_emp".equals(paramString), this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      if (arrayOfByte == null)
      {
        SSOLog.b("OldAuthorityPresenter", new Object[] { "onSdkAuthApiSuccess null == data" });
        return;
      }
      SdkAuthorize.AuthorizeResponse localAuthorizeResponse = (SdkAuthorize.AuthorizeResponse)new SdkAuthorize.AuthorizeResponse().mergeFrom(arrayOfByte);
      this.jdField_a_of_type_AndroidOsHandler.post(new OldAuthorityPresenter.7(this, localAuthorizeResponse));
      if (localAuthorizeResponse.ret.get() == 0) {
        FileDataSource.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, localAuthorizeResponse.expires_in.get(), arrayOfByte);
      }
      int i = localAuthorizeResponse.ret.get();
      AuthReporter.a(paramBundle, this.jdField_e_of_type_Long, i, 13, paramString, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      long l1 = this.jdField_g_of_type_Long;
      long l2 = arrayOfByte.length;
      long l3 = localAuthorizeResponse.toByteArray().length;
      paramBundle = this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString;
      paramString = new StringBuilder();
      paramString.append("ret: ");
      paramString.append(i);
      AuthReporter.a("agent_authority", l1, l2, l3, 0, paramBundle, paramString.toString());
      AuthReporter.a(0, "LOGIN_AUTH", this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, i, null);
      a("KEY_AUTHORIZE_REQUEST", this.jdField_e_of_type_Int, true);
      return;
    }
    catch (Exception paramBundle)
    {
      SSOLog.c("OldAuthorityPresenter", "Exception", paramBundle);
      a(3002, 2131694647);
      a("KEY_AUTHORIZE_REQUEST", this.jdField_e_of_type_Int, false);
    }
  }
  
  private void a(Bundle paramBundle, String paramString, long paramLong)
  {
    try
    {
      byte[] arrayOfByte = AuthorityUtil.a(paramBundle, "ConnAuthSvr.get_app_info_emp".equals(paramString), this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      if (arrayOfByte == null) {
        return;
      }
      GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
      localGetAppinfoResponse.mergeFrom(arrayOfByte);
      if (!localGetAppinfoResponse.has()) {
        return;
      }
      int i = localGetAppinfoResponse.ret.get();
      AuthReporter.a(paramBundle, paramLong, i, 12, paramString, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      if (i != 0) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new OldAuthorityPresenter.5(this, localGetAppinfoResponse));
      return;
    }
    catch (Exception paramBundle)
    {
      SSOLog.c("OldAuthorityPresenter", "getAppInfo", paramBundle);
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean, String paramString, long paramLong)
  {
    this.jdField_d_of_type_Int = 0;
    try
    {
      byte[] arrayOfByte = AuthorityUtil.a(paramBundle, paramBoolean, this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      if (arrayOfByte == null) {
        return;
      }
      SdkAuthorize.GetAuthApiListResponse localGetAuthApiListResponse = new SdkAuthorize.GetAuthApiListResponse();
      localGetAuthApiListResponse.mergeFrom(arrayOfByte);
      this.jdField_a_of_type_AndroidOsHandler.post(new OldAuthorityPresenter.2(this, localGetAuthApiListResponse));
      int i = localGetAuthApiListResponse.ret.get();
      AuthReporter.a(paramBundle, this.jdField_d_of_type_Long, i, 11, paramString, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      long l1 = arrayOfByte.length;
      long l2 = localGetAuthApiListResponse.toByteArray().length;
      paramBundle = this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString;
      paramString = new StringBuilder();
      paramString.append("ret: ");
      paramString.append(i);
      AuthReporter.a("agent_query_authority", paramLong, l1, l2, 0, paramBundle, paramString.toString());
      AuthReporter.a(0, "LOGIN_GETAUTHLIST_AGENT", this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, i, null);
      AuthReporter.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "2", "0", false);
      a("KEY_GET_AUTH_API_LIST_REQUEST", this.jdField_d_of_type_Int, true);
      AuthReporter.b(System.currentTimeMillis() - this.jdField_a_of_type_Long, 14, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      return;
    }
    catch (Exception paramBundle)
    {
      SSOLog.c("OldAuthorityPresenter", "Exception", paramBundle);
      a(3001, 2131694639);
      a("KEY_GET_AUTH_API_LIST_REQUEST", this.jdField_d_of_type_Int, false);
    }
  }
  
  private void a(GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    SSOLog.a("OldAuthorityPresenter", new Object[] { "parseGetAppInfoResponse mHasAppIcon=", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
    if (!TextUtils.isEmpty(paramGetAppinfoResponse.appName.get()))
    {
      String str = paramGetAppinfoResponse.appName.get();
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(str, null);
      SSOLog.a("OldAuthorityPresenter", new Object[] { "parseGetAppInfoResponse appName=", str });
    }
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    paramGetAppinfoResponse = AuthModelUtil.a(paramGetAppinfoResponse.iconsURL);
    if (paramGetAppinfoResponse.isEmpty())
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "parseGetAppInfoResponse iconsURL none" });
      return;
    }
    a((IconUrlSize)paramGetAppinfoResponse.get(a(paramGetAppinfoResponse)));
  }
  
  private void a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    int i = paramGetAuthApiListResponse.ret.get();
    SSOLog.a("OldAuthorityPresenter", new Object[] { "parseGetAuthListResult ret=", Integer.valueOf(i) });
    if (i == 0)
    {
      b(paramGetAuthApiListResponse);
      return;
    }
    b(paramGetAuthApiListResponse.msg.get(), i);
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_RETRY_COUNT", Integer.toString(paramInt));
    AuthReporter.a(paramString, this.jdField_a_of_type_ComTencentOpenModelAccountInfo, localHashMap, paramBoolean);
  }
  
  private void a(List<Permission> paramList)
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_g_of_type_Long = SystemClock.elapsedRealtime();
    Bundle localBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    localBundle.putString("openapi", "");
    localBundle.putBoolean("doAuthorize", true);
    localBundle.putString("need_pay", "1");
    localBundle.putString("appid_for_getting_config", localBundle.getString("client_id"));
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(2131694646);
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_login_by_qr_scan", false))
    {
      SSOLog.b("OldAuthorityPresenter", "doAuthorize confirmQRLogin");
      QQLiteStatusUtil.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(30000L);
    AuthReporter.a("KEY_AUTHORIZE_REQUEST");
    a(paramList, localBundle);
  }
  
  private void a(List<Permission> paramList, Bundle paramBundle)
  {
    Object[] arrayOfObject = AuthorityUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, "ConnAuthSvr.sdk_auth_api", "ConnAuthSvr.sdk_auth_api_emp");
    String str = (String)arrayOfObject[0];
    SSOLog.a("OldAuthorityPresenter", new Object[] { "doAuthorize cmd=", str, ", uin=", AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString) });
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelIOldAuthDataSource.a(paramList, paramBundle, this.jdField_a_of_type_ComTencentOpenModelAccountInfo, arrayOfObject, new OldAuthorityPresenter.6(this, str, paramList));
  }
  
  private void a(boolean paramBoolean1, Bundle paramBundle, long paramLong, boolean paramBoolean2, String paramString)
  {
    this.jdField_d_of_type_Long = (SystemClock.elapsedRealtime() - paramLong);
    String str = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString.equals(str))
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "onGetAuthApiBack account changed, ssoAccount=", str });
      return;
    }
    if (!this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(true);
    }
    if (paramBoolean1)
    {
      a(paramBundle, paramBoolean2, paramString, paramLong);
      return;
    }
    a(paramBundle.getInt("code"), paramLong);
  }
  
  private void b(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(paramGetAuthApiListResponse, this.jdField_b_of_type_JavaLangString))
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "parseAuthListResultSuccess authorized" });
      a(true);
      c(AuthResponse.a((SdkAuthorize.AuthorizeResponse)paramGetAuthApiListResponse.auth_response.get()));
    }
    else
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "parseAuthListResultSuccess not authorized" });
      a(false);
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(true);
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.b();
    l();
  }
  
  private void b(String paramString1, String paramString2)
  {
    ThreadManager.executeOnSubThread(new OldAuthorityPresenter.8(this, paramString2));
  }
  
  private boolean b(Bundle paramBundle)
  {
    if (this.h)
    {
      AuthModelUtil.a(paramBundle);
      i();
      return false;
    }
    if (!"action_login".equals(AuthParamUtil.a(this.jdField_a_of_type_AndroidContentIntent, "key_action"))) {
      return false;
    }
    if (a())
    {
      this.jdField_e_of_type_Boolean = false;
      return true;
    }
    i();
    return false;
  }
  
  private void c(AuthResponse paramAuthResponse)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse = paramAuthResponse;
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new OldAuthorityPresenter.3(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null)
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "queryAuthList mAccount == null" });
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(30000L);
      return;
    }
    Object[] arrayOfObject = AuthorityUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, "ConnAuthSvr.get_auth_api_list", "ConnAuthSvr.get_auth_api_list_emp");
    String str = (String)arrayOfObject[0];
    boolean bool = "ConnAuthSvr.get_auth_api_list_emp".equals(str);
    if ((bool) && ((this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_ArrayOfByte.length == 0)))
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "queryAuthList useEmp && (mAccount.st == null || mAccount.st.length == 0)" });
      a(3000, 2131694639);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    SSOLog.a("OldAuthorityPresenter", new Object[] { "queryAuthList cmd=", str, ", uin=", AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString) });
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(30000L);
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelIOldAuthDataSource.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenModelAccountInfo, arrayOfObject, new OldAuthorityPresenter.1(this, l, bool, str));
  }
  
  private void l()
  {
    Object[] arrayOfObject = AuthorityUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, "ConnAuthSvr.get_app_info", "ConnAuthSvr.get_app_info_emp");
    String str = (String)arrayOfObject[0];
    SSOLog.a("OldAuthorityPresenter", new Object[] { "getAppInfo cmd=", str });
    AuthReporter.a("KEY_GET_APP_INFO_REQUEST");
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(30000L);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelIOldAuthDataSource.b(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenModelAccountInfo, arrayOfObject, new OldAuthorityPresenter.4(this, str, l));
  }
  
  private void m()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showUserInfo uin=");
    ((StringBuilder)localObject).append(AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString));
    SSOLog.a("OldAuthorityPresenter", new Object[] { ((StringBuilder)localObject).toString() });
    String str1 = new String(a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString)._nick);
    IOldAuthorityContract.View localView = this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View;
    String str2 = this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString;
    localObject = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject = this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString;
    }
    localView.a(str2, (String)localObject, null);
    AvatarUpdateService.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_b_of_type_JavaLangString, new OldAuthorityPresenter.9(this));
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    if (paramInt == 0)
    {
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        c();
      }
    }
    else if (-1 == paramInt)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse = null;
      c(paramIntent);
      if (0L != ParseUtil.a(this.jdField_b_of_type_JavaLangString)) {
        l();
      }
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
      if (this.jdField_a_of_type_MqqManagerWtloginManager != null) {
        this.jdField_d_of_type_JavaLangString = Long.toString(a(this.jdField_d_of_type_JavaLangString)._uin);
      }
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(this.jdField_b_of_type_JavaLangString);
      b(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsHandler.post(new OldAuthorityPresenter.11(this));
      if (paramIntent.getBooleanExtra("isLogin", false))
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthModelILocalDataSource.a(this.jdField_d_of_type_JavaLangString);
        AuthorityUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_d_of_type_JavaLangString);
      }
      Object localObject = AuthParamUtil.a(paramIntent, "ssobundle");
      if (localObject != null)
      {
        byte[] arrayOfByte = ((Bundle)localObject).getByteArray("st_temp");
        localObject = ((Bundle)localObject).getByteArray("st_temp_key");
        if ((arrayOfByte != null) && (localObject != null))
        {
          this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_ArrayOfByte = arrayOfByte;
          this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_b_of_type_ArrayOfByte = ((byte[])localObject);
        }
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(false);
      if ((paramIntent.getBooleanExtra("fromLoginPhoneNum", false)) && (this.jdField_a_of_type_ComTencentOpenModelAccountInfo != null) && (this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_b_of_type_ArrayOfByte == null))
      {
        a(this.jdField_d_of_type_JavaLangString);
        return;
      }
      this.jdField_g_of_type_Boolean = false;
      AuthMemoryCache.a().a(this.jdField_d_of_type_JavaLangString);
      h();
    }
  }
  
  protected void a(String paramString, int paramInt, Bundle paramBundle)
  {
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, System.currentTimeMillis());
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(true);
    if (!this.h) {
      this.jdField_a_of_type_AndroidOsHandler.post(new OldAuthorityPresenter.10(this));
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      a((List)this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(4));
      return;
    }
    h();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (a(paramString, paramBoolean)) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse = null;
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    SSOLog.a("OldAuthorityPresenter", new Object[] { "onCreate" });
    if (paramBundle == null)
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "Params are null, finish activity" });
      a(-5, "params is null", "params is null", "params is null");
      return true;
    }
    b(paramBundle);
    AuthReporter.a("KEY_LOGIN_STAGE_2_OLD_TOTAL");
    AuthReporter.a(this.jdField_d_of_type_JavaLangString, "0X800B65C");
    AuthReporter.a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "1", "0", false);
    AuthorityUtil.a("0X800BA81");
    return b(paramBundle);
  }
  
  protected void b(String paramString)
  {
    SSOLog.b("OldAuthorityPresenter", new Object[] { "showLocalInfo currentAccount=", AuthorityUtil.a(paramString) });
    if (!this.h)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      WloginSimpleInfo localWloginSimpleInfo = a(paramString);
      Object localObject1 = Long.toString(localWloginSimpleInfo._uin);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("0")))
      {
        Object localObject2 = new String(localWloginSimpleInfo._nick);
        paramString = (String)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString = (String)localObject1;
        }
        this.jdField_d_of_type_JavaLangString = Long.toString(localWloginSimpleInfo._uin);
        localObject2 = OpenSdkVirtualUtil.a((String)localObject1, 58, true);
        if (localObject2 != null)
        {
          localObject1 = AuthorityUtil.a(this.jdField_a_of_type_AndroidAppActivity, (Bitmap)localObject2, 63, 63);
          ((Bitmap)localObject2).recycle();
          this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(this.jdField_d_of_type_JavaLangString, paramString, (Bitmap)localObject1);
          return;
        }
        b((String)localObject1, paramString);
        return;
      }
      SSOLog.b("OldAuthorityPresenter", new Object[] { "showLocalInfo uin=", localObject1 });
    }
  }
  
  public void g()
  {
    SSOLog.a("OldAuthorityPresenter", new Object[] { "onLoginBtnClick mGetTicketFailed=", Boolean.valueOf(this.jdField_g_of_type_Boolean) });
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentOpenModelAccountInfo != null))
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(false);
      if (this.jdField_c_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(2131694640);
        h();
        return;
      }
      AuthReporter.a("KEY_LOGIN_STAGE_2_OLD_TOTAL", this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      AuthReporter.a("KEY_LOGIN_STAGE_3_TOTAL");
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse != null)
      {
        SSOLog.a("OldAuthorityPresenter", new Object[] { "ClickAuthButton: " });
        this.jdField_a_of_type_AndroidOsHandler.post(new OldAuthorityPresenter.12(this));
      }
      else
      {
        SSOLog.a("OldAuthorityPresenter", new Object[] { "ClickAuthButton -- doAuthorize(): " });
        a((List)this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$View.a(4));
      }
      AuthReporter.a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "2", "0", false);
      AuthorityUtil.a("0X800BA82");
      return;
    }
    a(this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.OldAuthorityPresenter
 * JD-Core Version:    0.7.0.1
 */