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
  private int F;
  private long G;
  private long H;
  private boolean I;
  private boolean J;
  private long K;
  private final INewAuthorityContract.View L;
  private Handler M = new Handler(new NewAuthorityPresenter.1(this));
  private AuthCallback N = new NewAuthorityPresenter.6(this);
  
  public NewAuthorityPresenter(INewAuthorityContract.View paramView, ILocalDataSource paramILocalDataSource)
  {
    super(paramView, paramILocalDataSource);
    this.L = paramView;
  }
  
  private void a(AppInfoResponse paramAppInfoResponse)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "parseAppInfoResponse hasAppIcon=", Boolean.valueOf(this.l), ", response=", paramAppInfoResponse });
    if (paramAppInfoResponse == null) {
      return;
    }
    String str = paramAppInfoResponse.a();
    if (!TextUtils.isEmpty(str))
    {
      this.L.a(str, null);
      SSOLog.a("NewAuthorityPresenter", new Object[] { "parseGetAppInfoResponse appName=", str });
    }
    if (this.l) {
      return;
    }
    paramAppInfoResponse = paramAppInfoResponse.b();
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
    if ((paramGetVirtualListResult != null) && (paramGetVirtualListResult.a == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    SSOLog.a("NewAuthorityPresenter", new Object[] { "-->onGetVirtualList isSuccess=", Boolean.valueOf(bool) });
    AuthReporter.a("KEY_GET_VIRTUAL_LIST_D24", this.w, bool);
    if (!r())
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { " activity is isInvalid" });
      return;
    }
    if (paramGetVirtualListResult == null)
    {
      this.L.a(0, null, this.G);
      return;
    }
    if (paramGetVirtualListResult.a != 0)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "getVirtualList errorCode ===", Integer.valueOf(paramGetVirtualListResult.a) });
      this.L.a(paramGetVirtualListResult.a, null, this.G);
      return;
    }
    if (this.L.d() == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramGetVirtualListResult = AuthModelUtil.a(paramGetVirtualListResult, bool);
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onGetVirtualList setData accountInfoList.size=", Integer.valueOf(paramGetVirtualListResult.size()) });
    this.L.a(0, paramGetVirtualListResult, this.G);
    this.G = 0L;
  }
  
  private void a(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    if (paramPreAuthResponse == null)
    {
      this.L.b();
      SSOLog.a("NewAuthorityPresenter", new Object[] { "GET_API_LIST_DONE  response = null" });
      return;
    }
    int i = paramPreAuthResponse.ret.get();
    SSOLog.a("NewAuthorityPresenter", new Object[] { "parseGetAuthListResult ret=", Integer.valueOf(i) });
    if (i == 0)
    {
      b(paramPreAuthResponse);
      return;
    }
    b(paramPreAuthResponse.msg.get(), i);
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "handle110537 mIn110537Retry=", Boolean.valueOf(this.I), ", errorCode=", Integer.valueOf(paramInt), ", isGetVirtualList=", Boolean.valueOf(paramBoolean), "mAccount=", this.w });
    if (paramInt == 110537)
    {
      if (this.w == null) {
        return false;
      }
      BaseOpenSdkQIPCClient.a(this.w.a);
      if ((!this.I) && (AuthorityUtil.a(this.w.a, this.C, false) != null))
      {
        if (paramBoolean)
        {
          this.I = true;
          t();
          return true;
        }
        this.I = true;
        s();
        return true;
      }
      this.I = false;
      c(this.w.a);
      return true;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    SSOLog.b("NewAuthorityPresenter", new Object[] { "refreshTicketBySSOFailed triggerReason=", Integer.valueOf(paramInt) });
    AccountInfo localAccountInfo = AuthMemoryCache.a().d(l());
    AccountManage.a().a(localAccountInfo.a, l(), 3, new NewAuthorityPresenter.5(this, paramInt));
  }
  
  private void b(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    this.H = SystemClock.elapsedRealtime();
    this.m = false;
    AuthMemoryCache.a().a(l(), this.H);
    List localList = AuthMemoryCache.a().e(l());
    a(this.L.a(localList, paramPreAuthResponse.authorized_union_text.get()));
    this.L.a(true);
    this.L.b();
    u();
  }
  
  private void b(List<Permission> paramList)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onClick doAuthorize" });
    int i;
    if (this.o) {
      i = 2;
    } else {
      i = 1;
    }
    long l = this.L.d();
    String str;
    if (l == 0L) {
      str = "0X800A117";
    } else {
      str = "0X800A116";
    }
    ReportController.b(null, "dc00898", "", "", str, str, i, 0, "", "", "", "");
    AuthReporter.a("KEY_AUTHORIZE_REQUEST");
    AuthReporter.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.w);
    AuthReporter.a("KEY_LOGIN_STAGE_3_TOTAL");
    this.F = 0;
    new SSOSdkAuthApiPresenter().a(this.o, n(), o(), paramList, l, this.N, AuthParamUtil.a(this.A));
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "handle110509 mIn110509Retry=", Boolean.valueOf(this.J), ", errorCode=", Integer.valueOf(paramInt1), ", triggerReason=", Integer.valueOf(paramInt2), "mAccount=", this.w });
    if (paramInt1 == 110509)
    {
      if (this.w == null) {
        return false;
      }
      if (this.J)
      {
        this.J = false;
        c(this.w.a);
        return true;
      }
      this.J = true;
      b(paramInt2);
      return true;
    }
    return false;
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.q)
    {
      AuthModelUtil.b(paramBundle);
      i();
      this.L.a();
      return;
    }
    if (!"action_login".equals(AuthParamUtil.b(this.B, "key_action")))
    {
      this.L.a();
      return;
    }
    if (m())
    {
      this.n = false;
      return;
    }
    i();
    this.L.a();
  }
  
  private void c(String paramString, int paramInt)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("ErrorCode");
      paramInt = i;
      if (i == 0) {
        return;
      }
    }
    catch (Exception paramString)
    {
      SSOLog.c("NewAuthorityPresenter", "Exception", paramString);
      a(paramInt);
    }
  }
  
  private String n()
  {
    return this.t;
  }
  
  private String o()
  {
    return this.u;
  }
  
  private void p()
  {
    AuthReporter.a("KEY_LOGIN_STAGE_2_NEW_TOTAL");
    AuthReporter.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL");
    int i;
    if (this.o) {
      i = 2;
    } else {
      i = 1;
    }
    AuthReporter.a("0X800A115", i);
    AuthReporter.a(this.v, "0X800B65C");
    AuthReporter.a(this.v, l(), "1", "0", false);
    AuthorityUtil.a(null, "0X800B934", new String[] { "", "", this.y.getString("oauth_app_name"), "" });
  }
  
  private void q()
  {
    if (this.w == null)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "queryAuthList mAccount == null" });
      this.L.a(30000L);
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = AuthMemoryCache.a().g(l());
    SSOLog.a("NewAuthorityPresenter", new Object[] { "queryAuthorityUseCache response=", localPreAuthResponse });
    if (localPreAuthResponse == null)
    {
      this.I = false;
      this.J = false;
      s();
      return;
    }
    Message.obtain(this.M, 4, localPreAuthResponse).sendToTarget();
  }
  
  private boolean r()
  {
    return (this.A != null) && (!this.A.isFinishing());
  }
  
  private void s()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "-->updatePreAuthFromServer--" });
    if (!r())
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "updatePreAuthFromServer for activity is finished" });
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.A))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "-->updatePreAuthFromServer isNetworkAvailable false--" });
      this.L.a(0L);
      return;
    }
    if (this.w == null)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "-->updatePreAuthFromServer mAccount == null" });
      this.L.a(30000L);
      return;
    }
    if ((this.w.c != null) && (this.w.c.length != 0))
    {
      this.s = 2;
      new SSOPreAuthPresenter().a(n(), l(), this.A, AuthParamUtil.a(this.A), this.y, new NewAuthorityPresenter.2(this));
      return;
    }
    SSOLog.a("NewAuthorityPresenter", new Object[] { "-->updatePreAuthFromServer mAccount.st == null || mAccount.st.length == 0" });
    a(3000, 2131892323);
  }
  
  private void t()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "getVirtualListFromServer" });
    if (!NetworkUtil.isNetworkAvailable(this.A))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "getVirtualListFromServer no network" });
      this.L.a(0L);
      return;
    }
    new SSOPreAuthPresenter().a(n(), l(), this.A, AuthParamUtil.a(this.A), this.y, new NewAuthorityPresenter.3(this));
  }
  
  private void u()
  {
    if (!r())
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "getAppInfo return for activity is finished" });
      return;
    }
    this.s = 2;
    AppInfoResponse localAppInfoResponse = AuthMemoryCache.a().f(l());
    SSOLog.a("NewAuthorityPresenter", new Object[] { "getAppInfo use cached appid=", l(), ", appInfo=", localAppInfoResponse });
    Message.obtain(this.M, 5, localAppInfoResponse).sendToTarget();
  }
  
  private void v()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showUserInfo uin=");
    localStringBuilder.append(AuthorityUtil.a(this.w.a));
    SSOLog.a("NewAuthorityPresenter", new Object[] { localStringBuilder.toString() });
    this.L.a(this.w.a);
    AvatarUpdateService.a().a(this.A, this.w.a, this.w.b, new NewAuthorityPresenter.4(this));
  }
  
  private void w()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "getVirtualList" });
    this.I = false;
    this.J = false;
    t();
  }
  
  private void x()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onClick to OpenSelectPermissionFragment" });
    Object localObject = AuthMemoryCache.a().g(l());
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", this.t);
    localIntent.putExtra("key_proxy_appid", this.u);
    localIntent.putExtra("vid", this.L.d());
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((preAuth.PreAuthResponse)localObject).app_name.get();
    }
    localIntent.putExtra("appName", (String)localObject);
    localIntent.putExtra("hasIcon", this.l);
    localIntent.putExtra("login_cost", this.d - this.c);
    long l = this.H;
    if (l == 0L) {
      l = SystemClock.elapsedRealtime();
    }
    localIntent.putExtra("authStartTime", l);
    localIntent.putExtra("authListCostTime", this.e);
    localIntent.putExtra("is_from_qr_login", this.o);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("packagename", this.y.getString("packagename"));
    localIntent.putExtra("packagesign", this.y.getString("packagesign"));
    localIntent.putExtra("pkg_name", AuthParamUtil.a(this.A));
    AuthReporter.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL");
    QPublicFragmentActivity.Launcher.a(this.A, localIntent, PublicFragmentActivityForOpenSDK.class, OpenSelectPermissionFragment.class, 102);
  }
  
  private boolean y()
  {
    Object localObject = AuthMemoryCache.a().e(l());
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Permission localPermission = (Permission)((Iterator)localObject).next();
        if ((localPermission.a == 2) || (localPermission.a == 3)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private List<Permission> z()
  {
    Object localObject = AuthMemoryCache.a().e(l());
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Permission localPermission1 = (Permission)((Iterator)localObject).next();
        Permission localPermission2 = new Permission();
        localPermission2.d = localPermission1.d;
        localPermission2.a = localPermission1.a;
        localPermission2.e = localPermission1.e;
        localPermission2.c = localPermission1.c;
        localPermission2.b = localPermission1.b;
        localPermission2.f = true;
        localArrayList.add(localPermission2);
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    w();
    if (paramInt == 151)
    {
      this.L.a(HardCodeUtil.a(2131905668), false);
      c(this.v);
      return;
    }
    INewAuthorityContract.View localView = this.L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131905670));
    localStringBuilder.append(paramInt);
    localView.a(localStringBuilder.toString(), false);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.d = SystemClock.elapsedRealtime();
    if (paramInt == 0)
    {
      if (TextUtils.isEmpty(this.v)) {
        c();
      }
    }
    else if (-1 == paramInt)
    {
      c(paramIntent);
      if (0L != ParseUtil.a(this.t)) {
        u();
      }
      this.v = paramIntent.getStringExtra("last_account");
      if (this.D != null) {
        this.v = Long.toString(d(this.v)._uin);
      }
      this.L.a();
      this.L.b(null, this.v);
      b(this.v);
      this.M.sendEmptyMessage(1);
      if (paramIntent.getBooleanExtra("isLogin", false))
      {
        this.E.a(this.v);
        AuthorityUtil.a(this.C, this.v);
      }
      Object localObject = AuthParamUtil.a(paramIntent, "ssobundle");
      if (localObject != null)
      {
        byte[] arrayOfByte = ((Bundle)localObject).getByteArray("st_temp");
        localObject = ((Bundle)localObject).getByteArray("st_temp_key");
        if ((arrayOfByte != null) && (localObject != null))
        {
          this.w.c = arrayOfByte;
          this.w.d = ((byte[])localObject);
        }
      }
      this.n = true;
      this.L.a(false);
      if ((paramIntent.getBooleanExtra("fromLoginPhoneNum", false)) && (this.w != null) && (this.w.d == null))
      {
        a(this.v);
        return;
      }
      AuthMemoryCache.a().a(l(), this.w);
      this.I = false;
      this.J = false;
      if ((paramIntent.getBooleanExtra("isLogin", false)) || (this.p))
      {
        this.p = false;
        SSOLog.a("NewAuthorityPresenter", new Object[] { "hasQQD2=", Boolean.valueOf(AuthorityUtil.a(this.v, this.C)) });
        AuthMemoryCache.a().a(this.v);
      }
      s();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetworkAvailable(this.A))
    {
      this.L.a(0L);
      return;
    }
    AccountInfo localAccountInfo = AuthMemoryCache.a().d(l());
    if (localAccountInfo == null)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "deleteVirtual fail for account is null" });
      a(-1);
      return;
    }
    SSOLog.a("NewAuthorityPresenter", new Object[] { "deleteVirtual start uin=", AuthorityUtil.a(localAccountInfo.a) });
    AuthReporter.a("KEY_DELETE_VIRTUAL_D18");
    new NewAuthDataSourceImpl().a(paramLong, localAccountInfo, paramBoolean, new NewAuthorityPresenter.7(this, localAccountInfo));
  }
  
  public void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("createVirtualAccount", 0);
    if (i == 1)
    {
      this.G = paramIntent.getLongExtra("createVirtualVid", 0L);
      w();
    }
    else if (i == 2)
    {
      c(this.v);
    }
    paramIntent = new StringBuilder();
    paramIntent.append("onActivityResult, CreateVirtualAccount code = ");
    paramIntent.append(this.v);
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
    p();
    c(paramBundle);
  }
  
  protected void a(AuthResponse paramAuthResponse)
  {
    AuthorityUtil.e("0X800BA80");
    super.a(paramAuthResponse);
  }
  
  protected void a(String paramString, int paramInt, Bundle paramBundle)
  {
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, System.currentTimeMillis());
    }
    this.h = 0;
    this.p = false;
    this.d = SystemClock.elapsedRealtime();
    this.L.a(true);
    if (!this.q) {
      this.M.sendEmptyMessage(1);
    }
    paramString = AuthMemoryCache.a().d(l());
    if ((paramString == null) || (!paramString.a.equals(this.w.a)))
    {
      if (paramString == null) {
        paramString = "null";
      } else {
        paramString = AuthorityUtil.a(paramString.a);
      }
      SSOLog.a("NewAuthorityPresenter", new Object[] { "loginSuccess, changeAccount old uin=", paramString, ", new uin=", AuthorityUtil.a(this.w.a) });
      AuthMemoryCache.a().a(l(), this.w);
      w();
    }
    if (this.r == 1)
    {
      new SSOSdkAuthApiPresenter().a(this.o, this.t, this.u, new ArrayList(), this.L.d(), this.N, AuthParamUtil.a(this.A));
      return;
    }
    q();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    AuthorityUtil.e("0X800BA7C");
    b(paramString, paramBoolean);
  }
  
  public void b(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_cancel_auth", 0);
    int j = paramIntent.getIntExtra("key_error_code", 0);
    if (paramIntent.getIntExtra("key_need_login", 0) == 1)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "OpenVirtual.onActivityResult  REQUEST_CODE_SELECT_PERMISSION needLogin " });
      c(this.v);
      return;
    }
    if (i == 1)
    {
      this.A.setResult(0);
    }
    else if ((j == 0) && (this.o))
    {
      QQLiteStatusUtil.a(this.y);
    }
    else
    {
      String str1 = paramIntent.getStringExtra("key_error_msg");
      String str2 = paramIntent.getStringExtra("key_error_detail");
      paramIntent = paramIntent.getStringExtra("key_response");
      SSOLog.a("NewAuthorityPresenter", new Object[] { "OpenVirtual.onActivityResult, error: ", Integer.valueOf(j), ", msg:", str1, ", detail:", str2 });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_error_code", j);
      localIntent.putExtra("key_error_msg", str1);
      localIntent.putExtra("key_error_detail", str2);
      localIntent.putExtra("key_response", paramIntent);
      this.A.setResult(-1, localIntent);
    }
    this.A.finish();
  }
  
  protected void b(String paramString)
  {
    SSOLog.b("NewAuthorityPresenter", new Object[] { "showLocalInfo uin=", AuthorityUtil.a(paramString) });
    if (!this.q)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = Long.toString(d(paramString)._uin);
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("0")))
      {
        this.v = paramString;
        this.L.a(this.v);
        return;
      }
      SSOLog.b("NewAuthorityPresenter", new Object[] { "showLocalInfo uin=", paramString });
    }
  }
  
  public void c()
  {
    super.c();
    AuthorityUtil.e("0X800BA79");
  }
  
  public void f()
  {
    super.f();
    AuthorityUtil.e("0X800BA7D");
  }
  
  public void g()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onLoginBtnClick mGetTicketFailed=", Boolean.valueOf(this.p) });
    if (!NetworkUtil.isNetworkAvailable(this.A))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "onClick isNetworkAvailable false" });
      this.L.a(0L);
      return;
    }
    if ((!this.m) && (!this.p) && (this.w != null))
    {
      if (this.s == 0)
      {
        this.L.a(2131892324);
        q();
        return;
      }
      AuthReporter.a("KEY_LOGIN_STAGE_2_1_NEW_TOTAL", this.w);
      List localList = z();
      AuthMemoryCache.a().a(l(), this.w);
      AuthMemoryCache.a().a(l(), this.y);
      if (y()) {
        x();
      } else {
        b(localList);
      }
      AuthReporter.a(this.v, l(), "2", "0", false);
      AuthorityUtil.a(null, "0X800BA77", new String[] { String.valueOf(this.L.b(5)), "", "", "" });
      return;
    }
    a(this.v);
  }
  
  public void h()
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onClick to CreateVirtualAccountFragment" });
    AuthorityUtil.e("0X800BA7A");
    if (System.currentTimeMillis() - this.K <= 1000L) {
      return;
    }
    this.K = System.currentTimeMillis();
    Intent localIntent = new Intent();
    localIntent.putExtra("appid", l());
    localIntent.putExtra("key_proxy_appid", this.u);
    localIntent.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a(this.A, localIntent, PublicFragmentActivityForOpenSDK.class, CreateVirtualAccountFragment.class, 101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter
 * JD-Core Version:    0.7.0.1
 */