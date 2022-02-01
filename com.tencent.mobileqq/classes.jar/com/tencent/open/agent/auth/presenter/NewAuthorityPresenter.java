package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.BaseOpenSdkQIPCClient;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.auth.INewAuthorityContract.Presenter;
import com.tencent.open.agent.auth.INewAuthorityContract.View;
import com.tencent.open.agent.auth.model.ILocalDataSource;
import com.tencent.open.agent.auth.model.INewAuthDataSource;
import com.tencent.open.agent.auth.model.NewAuthDataSourceImpl;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.entity.AppInfoResponse;
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
import com.tencent.open.model.AccountManage;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import org.json.JSONObject;

@RequiresApi(api=3)
public class NewAuthorityPresenter
  extends BaseAuthorityPresenter
  implements INewAuthorityContract.Presenter
{
  private final INewAuthorityContract.View jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View;
  private AuthCallback jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback = new NewAuthorityPresenter.6(this);
  private Handler b;
  private int d;
  private long g;
  private long h;
  private long jdField_i_of_type_Long;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  
  public NewAuthorityPresenter(INewAuthorityContract.View paramView, ILocalDataSource paramILocalDataSource)
  {
    super(paramView, paramILocalDataSource);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(new NewAuthorityPresenter.1(this));
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View = paramView;
  }
  
  private List<Permission> a()
  {
    Object localObject = AuthMemoryCache.a().a(a());
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Permission localPermission1 = (Permission)((Iterator)localObject).next();
        Permission localPermission2 = new Permission();
        localPermission2.jdField_b_of_type_JavaLangString = localPermission1.jdField_b_of_type_JavaLangString;
        localPermission2.jdField_a_of_type_Int = localPermission1.jdField_a_of_type_Int;
        localPermission2.jdField_b_of_type_Int = localPermission1.jdField_b_of_type_Int;
        localPermission2.jdField_a_of_type_Boolean = localPermission1.jdField_a_of_type_Boolean;
        localPermission2.jdField_a_of_type_JavaLangString = localPermission1.jdField_a_of_type_JavaLangString;
        localPermission2.jdField_b_of_type_Boolean = true;
        localArrayList.add(localPermission2);
      }
    }
    return localArrayList;
  }
  
  private void a(AppInfoResponse paramAppInfoResponse)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "parseAppInfoResponse hasAppIcon=", Boolean.valueOf(this.jdField_c_of_type_Boolean), ", response=", paramAppInfoResponse });
    if (paramAppInfoResponse == null) {
      return;
    }
    String str = paramAppInfoResponse.a();
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(str, null);
      SSOLog.a("NewAuthorityPresenter", new Object[] { "parseGetAppInfoResponse appName=", str });
    }
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    paramAppInfoResponse = paramAppInfoResponse.a();
    if (paramAppInfoResponse.isEmpty())
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "parseGetAppInfoResponse iconsURL none" });
      return;
    }
    a((IconUrlSize)paramAppInfoResponse.get(a(paramAppInfoResponse)));
  }
  
  private void a(GetVirtualListResult paramGetVirtualListResult)
  {
    boolean bool;
    if ((paramGetVirtualListResult != null) && (paramGetVirtualListResult.jdField_a_of_type_Int == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    SSOLog.a("NewAuthorityPresenter", new Object[] { "-->onGetVirtualList isSuccess=", Boolean.valueOf(bool) });
    AuthReporter.a("KEY_GET_VIRTUAL_LIST_D24", this.jdField_a_of_type_ComTencentOpenModelAccountInfo, bool);
    if (!b())
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { " activity is isInvalid" });
      return;
    }
    if (paramGetVirtualListResult == null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(0, null, this.jdField_g_of_type_Long);
      return;
    }
    if (paramGetVirtualListResult.jdField_a_of_type_Int != 0)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "getVirtualList errorCode ===", Integer.valueOf(paramGetVirtualListResult.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(paramGetVirtualListResult.jdField_a_of_type_Int, null, this.jdField_g_of_type_Long);
      return;
    }
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a() == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramGetVirtualListResult = AuthModelUtil.a(paramGetVirtualListResult, bool);
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onGetVirtualList setData accountInfoList.size=", Integer.valueOf(paramGetVirtualListResult.size()) });
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(0, paramGetVirtualListResult, this.jdField_g_of_type_Long);
    this.jdField_g_of_type_Long = 0L;
  }
  
  private void a(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    if (paramPreAuthResponse == null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.b();
      SSOLog.a("NewAuthorityPresenter", new Object[] { "GET_API_LIST_DONE  response = null" });
      return;
    }
    int k = paramPreAuthResponse.ret.get();
    SSOLog.a("NewAuthorityPresenter", new Object[] { "parseGetAuthListResult ret=", Integer.valueOf(k) });
    if (k == 0)
    {
      b(paramPreAuthResponse);
      return;
    }
    b(paramPreAuthResponse.msg.get(), k);
  }
  
  private void a(List<Permission> paramList)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onClick doAuthorize" });
    int k;
    if (this.f) {
      k = 2;
    } else {
      k = 1;
    }
    long l = this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a();
    String str;
    if (l == 0L) {
      str = "0X800A117";
    } else {
      str = "0X800A116";
    }
    ReportController.b(null, "dc00898", "", "", str, str, k, 0, "", "", "", "");
    AuthReporter.a("KEY_AUTHORIZE_REQUEST");
    AuthReporter.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
    AuthReporter.a("KEY_LOGIN_STAGE_3_TOTAL");
    this.jdField_d_of_type_Int = 0;
    new SSOSdkAuthApiPresenter().a(this.f, b(), c(), paramList, l, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback, AuthParamUtil.a(this.jdField_a_of_type_AndroidAppActivity));
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "handle110509 mIn110509Retry=", Boolean.valueOf(this.j), ", errorCode=", Integer.valueOf(paramInt1), ", triggerReason=", Integer.valueOf(paramInt2), "mAccount=", this.jdField_a_of_type_ComTencentOpenModelAccountInfo });
    if (paramInt1 == 110509)
    {
      if (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null) {
        return false;
      }
      if (this.j)
      {
        this.j = false;
        c(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
        return true;
      }
      this.j = true;
      b(paramInt2);
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "handle110537 mIn110537Retry=", Boolean.valueOf(this.jdField_i_of_type_Boolean), ", errorCode=", Integer.valueOf(paramInt), ", isGetVirtualList=", Boolean.valueOf(paramBoolean), "mAccount=", this.jdField_a_of_type_ComTencentOpenModelAccountInfo });
    if (paramInt == 110537)
    {
      if (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null) {
        return false;
      }
      BaseOpenSdkQIPCClient.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
      if ((!this.jdField_i_of_type_Boolean) && (AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppRuntime, false) != null))
      {
        if (paramBoolean)
        {
          this.jdField_i_of_type_Boolean = true;
          o();
          return true;
        }
        this.jdField_i_of_type_Boolean = true;
        n();
        return true;
      }
      this.jdField_i_of_type_Boolean = false;
      c(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
      return true;
    }
    return false;
  }
  
  private String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  private void b(int paramInt)
  {
    SSOLog.b("NewAuthorityPresenter", new Object[] { "refreshTicketBySSOFailed triggerReason=", Integer.valueOf(paramInt) });
    AccountInfo localAccountInfo = AuthMemoryCache.a().a(a());
    AccountManage.a().a(localAccountInfo.jdField_a_of_type_JavaLangString, a(), 3, new NewAuthorityPresenter.5(this, paramInt));
  }
  
  private void b(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    this.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_d_of_type_Boolean = false;
    AuthMemoryCache.a().a(a(), this.jdField_h_of_type_Long);
    List localList = AuthMemoryCache.a().a(a());
    a(this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(localList, paramPreAuthResponse.authorized_union_text.get()));
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(true);
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.b();
    p();
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing());
  }
  
  private String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_h_of_type_Boolean)
    {
      AuthModelUtil.a(paramBundle);
      i();
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a();
      return;
    }
    if (!"action_login".equals(AuthParamUtil.a(this.jdField_a_of_type_AndroidContentIntent, "key_action")))
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a();
      return;
    }
    if (a())
    {
      this.e = false;
      return;
    }
    i();
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a();
  }
  
  private void c(String paramString, int paramInt)
  {
    try
    {
      int k = new JSONObject(paramString).optInt("ErrorCode");
      paramInt = k;
      if (k == 0) {
        return;
      }
    }
    catch (Exception paramString)
    {
      SSOLog.c("NewAuthorityPresenter", "Exception", paramString);
      a(paramInt);
    }
  }
  
  private boolean c()
  {
    Object localObject = AuthMemoryCache.a().a(a());
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Permission localPermission = (Permission)((Iterator)localObject).next();
        if ((localPermission.jdField_a_of_type_Int == 2) || (localPermission.jdField_a_of_type_Int == 3)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void l()
  {
    AuthReporter.a("KEY_LOGIN_STAGE_2_NEW_TOTAL");
    AuthReporter.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL");
    int k;
    if (this.f) {
      k = 2;
    } else {
      k = 1;
    }
    AuthReporter.a("0X800A115", k);
    AuthReporter.a(this.jdField_d_of_type_JavaLangString, "0X800B65C");
    AuthReporter.a(this.jdField_d_of_type_JavaLangString, a(), "1", "0", false);
    AuthorityUtil.a(null, "0X800B934", new String[] { "", "", this.jdField_a_of_type_AndroidOsBundle.getString("oauth_app_name"), "" });
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "queryAuthList mAccount == null" });
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(30000L);
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = AuthMemoryCache.a().a(a());
    SSOLog.a("NewAuthorityPresenter", new Object[] { "queryAuthorityUseCache response=", localPreAuthResponse });
    if (localPreAuthResponse == null)
    {
      this.jdField_i_of_type_Boolean = false;
      this.j = false;
      n();
      return;
    }
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 4, localPreAuthResponse).sendToTarget();
  }
  
  private void n()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "-->updatePreAuthFromServer--" });
    if (!b())
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "updatePreAuthFromServer for activity is finished" });
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "-->updatePreAuthFromServer isNetworkAvailable false--" });
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(0L);
      return;
    }
    if (this.jdField_a_of_type_ComTencentOpenModelAccountInfo == null)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "-->updatePreAuthFromServer mAccount == null" });
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(30000L);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_ArrayOfByte.length != 0))
    {
      this.jdField_c_of_type_Int = 2;
      new SSOPreAuthPresenter().a(b(), a(), this.jdField_a_of_type_AndroidAppActivity, AuthParamUtil.a(this.jdField_a_of_type_AndroidAppActivity), this.jdField_a_of_type_AndroidOsBundle, new NewAuthorityPresenter.2(this));
      return;
    }
    SSOLog.a("NewAuthorityPresenter", new Object[] { "-->updatePreAuthFromServer mAccount.st == null || mAccount.st.length == 0" });
    a(3000, 2131694639);
  }
  
  private void o()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "getVirtualListFromServer" });
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "getVirtualListFromServer no network" });
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(0L);
      return;
    }
    new SSOPreAuthPresenter().a(b(), a(), this.jdField_a_of_type_AndroidAppActivity, AuthParamUtil.a(this.jdField_a_of_type_AndroidAppActivity), this.jdField_a_of_type_AndroidOsBundle, new NewAuthorityPresenter.3(this));
  }
  
  private void p()
  {
    if (!b())
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "getAppInfo return for activity is finished" });
      return;
    }
    this.jdField_c_of_type_Int = 2;
    AppInfoResponse localAppInfoResponse = AuthMemoryCache.a().a(a());
    SSOLog.a("NewAuthorityPresenter", new Object[] { "getAppInfo use cached appid=", a(), ", appInfo=", localAppInfoResponse });
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 5, localAppInfoResponse).sendToTarget();
  }
  
  private void q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showUserInfo uin=");
    localStringBuilder.append(AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString));
    SSOLog.a("NewAuthorityPresenter", new Object[] { localStringBuilder.toString() });
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
    AvatarUpdateService.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_b_of_type_JavaLangString, new NewAuthorityPresenter.4(this));
  }
  
  private void r()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "getVirtualList" });
    this.jdField_i_of_type_Boolean = false;
    this.j = false;
    o();
  }
  
  private void s()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onClick to OpenSelectPermissionFragment" });
    Object localObject = AuthMemoryCache.a().a(a());
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_proxy_appid", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("vid", this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a());
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((preAuth.PreAuthResponse)localObject).app_name.get();
    }
    localIntent.putExtra("appName", (String)localObject);
    localIntent.putExtra("hasIcon", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("login_cost", this.jdField_c_of_type_Long - this.jdField_b_of_type_Long);
    long l = this.jdField_h_of_type_Long;
    if (l == 0L) {
      l = SystemClock.elapsedRealtime();
    }
    localIntent.putExtra("authStartTime", l);
    localIntent.putExtra("authListCostTime", this.jdField_d_of_type_Long);
    localIntent.putExtra("is_from_qr_login", this.f);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("packagename", this.jdField_a_of_type_AndroidOsBundle.getString("packagename"));
    localIntent.putExtra("packagesign", this.jdField_a_of_type_AndroidOsBundle.getString("packagesign"));
    localIntent.putExtra("pkg_name", AuthParamUtil.a(this.jdField_a_of_type_AndroidAppActivity));
    AuthReporter.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL");
    QPublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, PublicFragmentActivityForOpenSDK.class, OpenSelectPermissionFragment.class, 102);
  }
  
  public void a(int paramInt)
  {
    r();
    if (paramInt == 151)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(HardCodeUtil.a(2131707854), false);
      c(this.jdField_d_of_type_JavaLangString);
      return;
    }
    INewAuthorityContract.View localView = this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131707856));
    localStringBuilder.append(paramInt);
    localView.a(localStringBuilder.toString(), false);
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
      c(paramIntent);
      if (0L != ParseUtil.a(this.jdField_b_of_type_JavaLangString)) {
        p();
      }
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
      if (this.jdField_a_of_type_MqqManagerWtloginManager != null) {
        this.jdField_d_of_type_JavaLangString = Long.toString(a(this.jdField_d_of_type_JavaLangString)._uin);
      }
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a();
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(null, this.jdField_d_of_type_JavaLangString);
      b(this.jdField_d_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1);
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
      this.e = true;
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(false);
      if ((paramIntent.getBooleanExtra("fromLoginPhoneNum", false)) && (this.jdField_a_of_type_ComTencentOpenModelAccountInfo != null) && (this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_b_of_type_ArrayOfByte == null))
      {
        a(this.jdField_d_of_type_JavaLangString);
        return;
      }
      AuthMemoryCache.a().a(a(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      this.jdField_i_of_type_Boolean = false;
      this.j = false;
      if ((paramIntent.getBooleanExtra("isLogin", false)) || (this.jdField_g_of_type_Boolean))
      {
        this.jdField_g_of_type_Boolean = false;
        SSOLog.a("NewAuthorityPresenter", new Object[] { "hasQQD2=", Boolean.valueOf(AuthorityUtil.a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppRuntime)) });
        AuthMemoryCache.a().a(this.jdField_d_of_type_JavaLangString);
      }
      n();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(0L);
      return;
    }
    AccountInfo localAccountInfo = AuthMemoryCache.a().a(a());
    if (localAccountInfo == null)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "deleteVirtual fail for account is null" });
      a(-1);
      return;
    }
    SSOLog.a("NewAuthorityPresenter", new Object[] { "deleteVirtual start uin=", AuthorityUtil.a(localAccountInfo.jdField_a_of_type_JavaLangString) });
    AuthReporter.a("KEY_DELETE_VIRTUAL_D18");
    new NewAuthDataSourceImpl().a(paramLong, localAccountInfo, paramBoolean, new NewAuthorityPresenter.7(this, localAccountInfo));
  }
  
  public void a(Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("createVirtualAccount", 0);
    if (k == 1)
    {
      this.jdField_g_of_type_Long = paramIntent.getLongExtra("createVirtualVid", 0L);
      r();
    }
    else if (k == 2)
    {
      c(this.jdField_d_of_type_JavaLangString);
    }
    paramIntent = new StringBuilder();
    paramIntent.append("onActivityResult, CreateVirtualAccount code = ");
    paramIntent.append(this.jdField_d_of_type_JavaLangString);
    SSOLog.a("NewAuthorityPresenter", new Object[] { paramIntent.toString() });
  }
  
  public void a(Bundle paramBundle)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onCreate44" });
    if (paramBundle == null)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "param is null, finish activity" });
      a(-5, "params is null", "params is null", "params is null");
      return;
    }
    b(paramBundle);
    l();
    c(paramBundle);
  }
  
  protected void a(AuthResponse paramAuthResponse)
  {
    AuthorityUtil.a("0X800BA80");
    super.a(paramAuthResponse);
  }
  
  protected void a(String paramString, int paramInt, Bundle paramBundle)
  {
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, System.currentTimeMillis());
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(true);
    if (!this.jdField_h_of_type_Boolean) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    paramString = AuthMemoryCache.a().a(a());
    if ((paramString == null) || (!paramString.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString)))
    {
      if (paramString == null) {
        paramString = "null";
      } else {
        paramString = AuthorityUtil.a(paramString.jdField_a_of_type_JavaLangString);
      }
      SSOLog.a("NewAuthorityPresenter", new Object[] { "loginSuccess, changeAccount old uin=", paramString, ", new uin=", AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString) });
      AuthMemoryCache.a().a(a(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      r();
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      new SSOSdkAuthApiPresenter().a(this.f, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, new ArrayList(), this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(), this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback, AuthParamUtil.a(this.jdField_a_of_type_AndroidAppActivity));
      return;
    }
    m();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    AuthorityUtil.a("0X800BA7C");
    a(paramString, paramBoolean);
  }
  
  public void b(Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("key_cancel_auth", 0);
    int m = paramIntent.getIntExtra("key_error_code", 0);
    if (paramIntent.getIntExtra("key_need_login", 0) == 1)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "OpenVirtual.onActivityResult  REQUEST_CODE_SELECT_PERMISSION needLogin " });
      c(this.jdField_d_of_type_JavaLangString);
      return;
    }
    if (k == 1)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(0);
    }
    else if ((m == 0) && (this.f))
    {
      QQLiteStatusUtil.a(this.jdField_a_of_type_AndroidOsBundle);
    }
    else
    {
      String str1 = paramIntent.getStringExtra("key_error_msg");
      String str2 = paramIntent.getStringExtra("key_error_detail");
      paramIntent = paramIntent.getStringExtra("key_response");
      SSOLog.a("NewAuthorityPresenter", new Object[] { "OpenVirtual.onActivityResult, error: ", Integer.valueOf(m), ", msg:", str1, ", detail:", str2 });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_error_code", m);
      localIntent.putExtra("key_error_msg", str1);
      localIntent.putExtra("key_error_detail", str2);
      localIntent.putExtra("key_response", paramIntent);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected void b(String paramString)
  {
    SSOLog.b("NewAuthorityPresenter", new Object[] { "showLocalInfo uin=", AuthorityUtil.a(paramString) });
    if (!this.jdField_h_of_type_Boolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = Long.toString(a(paramString)._uin);
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("0")))
      {
        this.jdField_d_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(this.jdField_d_of_type_JavaLangString);
        return;
      }
      SSOLog.b("NewAuthorityPresenter", new Object[] { "showLocalInfo uin=", paramString });
    }
  }
  
  public void c()
  {
    super.c();
    AuthorityUtil.a("0X800BA79");
  }
  
  public void f()
  {
    super.f();
    AuthorityUtil.a("0X800BA7D");
  }
  
  public void g()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onLoginBtnClick mGetTicketFailed=", Boolean.valueOf(this.jdField_g_of_type_Boolean) });
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "onClick isNetworkAvailable false" });
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(0L);
      return;
    }
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentOpenModelAccountInfo != null))
    {
      if (this.jdField_c_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(2131694640);
        m();
        return;
      }
      AuthReporter.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL", this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      List localList = a();
      AuthMemoryCache.a().a(a(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      AuthMemoryCache.a().a(a(), this.jdField_a_of_type_AndroidOsBundle);
      if (c()) {
        s();
      } else {
        a(localList);
      }
      AuthReporter.a(this.jdField_d_of_type_JavaLangString, a(), "2", "0", false);
      AuthorityUtil.a(null, "0X800BA77", new String[] { String.valueOf(this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$View.a(5)), "", "", "" });
      return;
    }
    a(this.jdField_d_of_type_JavaLangString);
  }
  
  public void h()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onClick to CreateVirtualAccountFragment" });
    AuthorityUtil.a("0X800BA7A");
    if (System.currentTimeMillis() - this.jdField_i_of_type_Long <= 1000L) {
      return;
    }
    this.jdField_i_of_type_Long = System.currentTimeMillis();
    Intent localIntent = new Intent();
    localIntent.putExtra("appid", a());
    localIntent.putExtra("key_proxy_appid", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, PublicFragmentActivityForOpenSDK.class, CreateVirtualAccountFragment.class, 101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter
 * JD-Core Version:    0.7.0.1
 */