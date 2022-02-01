package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.BaseOpenSdkQIPCClient;
import com.tencent.open.agent.auth.IBaseView;
import com.tencent.open.agent.auth.model.FileDataSource;
import com.tencent.open.agent.auth.model.ILocalDataSource;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.entity.IconUrlSize;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.ParseUtil;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseAuthorityPresenter
{
  protected final Activity A;
  protected final Intent B;
  protected final AppRuntime C;
  protected final WtloginManager D;
  protected final ILocalDataSource E;
  protected Handler a = new Handler(Looper.myLooper());
  protected long b;
  protected long c;
  protected long d;
  protected long e;
  protected long f;
  protected long g;
  protected int h;
  protected String i;
  protected boolean j;
  protected boolean k;
  protected boolean l;
  protected boolean m;
  protected boolean n;
  protected boolean o;
  protected boolean p;
  protected boolean q;
  protected int r = -1;
  protected int s = 0;
  protected String t;
  protected String u;
  protected String v;
  protected AccountInfo w;
  protected List<String> x;
  protected Bundle y;
  protected final IBaseView z;
  
  protected BaseAuthorityPresenter(IBaseView paramIBaseView, ILocalDataSource paramILocalDataSource)
  {
    this.z = paramIBaseView;
    this.E = paramILocalDataSource;
    this.C = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.D = ((WtloginManager)this.C.getManager(1));
    this.A = ((Activity)paramIBaseView.b(3));
    this.B = this.A.getIntent();
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "app=", this.C, ", mWtLoginManager=", this.D });
  }
  
  private void a(int paramInt, String paramString1, String paramString2, AccountInfo paramAccountInfo, String paramString3)
  {
    AuthReporter.a(paramInt, paramAccountInfo);
    paramAccountInfo = "0";
    if (paramInt == 0)
    {
      AuthReporter.a(paramString3, "0X800B65E");
      AuthReporter.a(paramString3, l(), "6", "0", false);
      paramString1 = paramAccountInfo;
    }
    else
    {
      AuthReporter.a(paramString3, "0X800B65F");
      AuthReporter.a(this.A, paramInt, paramString1, paramString3, l(), paramString2);
      paramString1 = "1";
    }
    AuthReporter.a(paramInt, l(), paramString3);
    if (AuthParamUtil.a(this.B)) {
      AuthReporter.a(paramString3, l(), "9", paramString1, true);
    }
    if ((!TextUtils.isEmpty(this.C.getAccount())) && (!this.C.getAccount().equals(paramString3))) {
      AuthReporter.a(paramString3, l(), "10", paramString1, true);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    this.p = true;
    if ((paramInt1 != -1000) && (paramInt1 != 154))
    {
      c(paramString);
      return;
    }
    if (paramInt2 == 1002)
    {
      paramInt1 = this.h;
      if (paramInt1 < 2)
      {
        this.h = (paramInt1 + 1);
        this.d = SystemClock.elapsedRealtime();
        a(paramString);
        return;
      }
    }
    this.d = SystemClock.elapsedRealtime();
    a(3003, 2131892333);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    long l1 = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ret: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" | error: ");
    localStringBuilder.append(paramString2);
    AuthReporter.a("agent_login", l1, 0L, 0L, paramInt2, paramString1, localStringBuilder.toString());
    AuthReporter.a(1, "LOGIN_GETTICKT", paramString1, l(), paramInt2, paramString2);
    paramString2 = l();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    AuthReporter.a(paramString1, paramString2, "1", localStringBuilder.toString(), false);
    paramString2 = l();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    AuthReporter.a(paramString1, paramString2, "6", localStringBuilder.toString(), false);
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString1, false);
    AuthReporter.a("KEY_LOGIN_STAGE_1_TOTAL", paramString1, this.b, null, false);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.w);
    AuthReporter.a("KEY_LOGIN_STAGE_1_TOTAL", this.v, this.b, null, true);
    if (!paramBundle.getBoolean("fake_callback"))
    {
      SSOLog.a("BaseAuthorityPresenter", new Object[] { "onRefreshTicketSuccess fake callback" });
      long l1 = System.currentTimeMillis();
      long l2 = this.g;
      int i1 = paramBundle.getInt("code");
      AuthReporter.a(l1 - l2, i1, l(), paramString);
      AuthReporter.a("agent_login", this.g, paramString.length(), paramArrayOfByte.length, 0, paramString, null);
      AuthReporter.a(0, "LOGIN_GETTICKT", paramString, l(), i1, null);
      AuthReporter.a(paramString, l(), "1", "0", false);
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    b(paramInt, paramString1);
    byte[] arrayOfByte = FileDataSource.a(l(), this.w.a);
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      SdkAuthorize.AuthorizeResponse localAuthorizeResponse = new SdkAuthorize.AuthorizeResponse();
      try
      {
        b(AuthResponse.a((SdkAuthorize.AuthorizeResponse)localAuthorizeResponse.mergeFrom(arrayOfByte)));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        SSOLog.c("BaseAuthorityPresenter", "InvalidProtocolBufferMicroException", localInvalidProtocolBufferMicroException);
        a(paramInt, paramString1, paramString2);
        return;
      }
    }
    a(paramInt, paramString1, paramString2);
  }
  
  private void c(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshTicket uin=");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityPresenter", new Object[] { localStringBuilder.toString() });
    this.g = System.currentTimeMillis();
    AccountManage.a().a(paramString, new BaseAuthorityPresenter.3(this), l(), paramInt);
  }
  
  private void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send | cmd: g_t_n_p | uin :*");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityPresenter", new Object[] { localStringBuilder.toString() });
    this.z.a(2131892332);
    if (TextUtils.isEmpty(paramString))
    {
      f(paramString);
      this.j = true;
      a("wtl_notlogged", "0");
      return;
    }
    if (AuthorityUtil.a(this.D, paramString))
    {
      c(paramString);
      return;
    }
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
    c(paramString, 1);
    b(paramString);
  }
  
  private void f(String paramString)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "changeAccountActivity uin=", AuthorityUtil.a(paramString) });
    Intent localIntent = new Intent();
    List localList = this.x;
    if ((localList != null) && (localList.size() > 1))
    {
      localIntent.putExtra("third_app_id", l());
      localIntent.putExtra("param_uin", paramString);
      paramString = "/base/switchAccount";
    }
    else
    {
      localIntent.putExtra("appid", l());
      localIntent.putExtra("is_first_login", true);
      paramString = "/base/openSdkLogin";
    }
    localIntent.putExtra("key_req_src", 1);
    localIntent.putExtra("param_qr_code_url", this.B.getStringExtra("param_qr_code_url"));
    localIntent.putExtra("oauth_app_name", AuthParamUtil.a(this.y, "oauth_app_name"));
    RouteUtils.a(this.A, localIntent, paramString, 1);
  }
  
  protected int a(List<IconUrlSize> paramList)
  {
    int i6 = paramList.size();
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    while (i1 < i6)
    {
      int i5 = ParseUtil.b(((IconUrlSize)paramList.get(i1)).b.get());
      if (i5 >= 100) {
        return i1;
      }
      int i4 = i2;
      if (i5 > i2)
      {
        i3 = i1;
        i4 = i5;
      }
      i1 += 1;
      i2 = i4;
    }
    return i3;
  }
  
  public void a()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "doOnPause" });
    this.b = 0L;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, MobileQQ.sMobileQQ.getResources().getString(paramInt2));
  }
  
  protected void a(int paramInt, String paramString)
  {
    this.a.post(new BaseAuthorityPresenter.6(this, paramInt, paramString));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new BaseAuthorityPresenter.4(this, paramInt, paramString1);
    AuthUIUtil.a(this.A, paramString2, new BaseAuthorityPresenter.5(this, paramString1));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "setSdkResult, error=", Integer.valueOf(paramInt), ", mCurrentAccount=", AuthorityUtil.a(this.v) });
    if ((paramInt != 110405) && (paramInt != 110513)) {
      break label60;
    }
    paramInt = 0;
    label60:
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString2);
    localIntent.putExtra("key_error_detail", paramString3);
    localIntent.putExtra("key_response", paramString1);
    this.A.setResult(-1, localIntent);
    this.A.finish();
    a(paramInt, paramString2, paramString3, this.w, this.v);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    this.a.post(new BaseAuthorityPresenter.1(this, paramBitmap));
  }
  
  protected void a(AuthResponse paramAuthResponse)
  {
    this.E.a(paramAuthResponse.e.get(), l(), this.w.a);
    this.E.a(paramAuthResponse.e.get(), paramAuthResponse.g.get());
    Object localObject;
    if (this.j)
    {
      if (this.k) {
        localObject = "wtl_lognback";
      } else {
        localObject = "wtl_lognauthorizenback";
      }
      a((String)localObject, this.w.a);
    }
    else
    {
      if (this.k) {
        localObject = "wtl_loggednunauthorizedback";
      } else {
        localObject = "wtl_loggednauthorizedback";
      }
      a((String)localObject, this.w.a);
    }
    AuthReporter.a(this.A, l(), this.v, this.f, this.j, this.k);
    if (this.o)
    {
      AuthReporter.a(paramAuthResponse.a.get(), this.w);
      QQLiteStatusUtil.a(this.y);
      if (paramAuthResponse.a.get() == 0) {
        paramAuthResponse = "0X800B65E";
      } else {
        paramAuthResponse = "0X800B65F";
      }
      AuthReporter.a(this.v, paramAuthResponse);
      return;
    }
    for (;;)
    {
      try
      {
        long l1 = this.d;
        long l2 = this.c;
        long l3 = this.e;
        long l4 = this.f;
        if (!TextUtils.isEmpty(this.u))
        {
          bool = true;
          localObject = AuthorityUtil.a(paramAuthResponse, l1 - l2, l3, l4, bool);
          a(paramAuthResponse.a.get(), ((JSONObject)localObject).toString(), null, null);
          return;
        }
      }
      catch (JSONException paramAuthResponse)
      {
        SSOLog.a("BaseAuthorityPresenter", "JSONException", paramAuthResponse);
        return;
      }
      boolean bool = false;
    }
  }
  
  protected void a(IconUrlSize paramIconUrlSize)
  {
    if (paramIconUrlSize == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchAppIcon imgUrl is ");
    localStringBuilder.append(paramIconUrlSize);
    SSOLog.b("BaseAuthorityPresenter", localStringBuilder.toString());
    ThreadManager.executeOnNetWorkThread(new BaseAuthorityPresenter.2(this, paramIconUrlSize));
  }
  
  protected void a(String paramString)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "login uin=", AuthorityUtil.a(paramString) });
    this.c = SystemClock.elapsedRealtime();
    this.z.a(true);
    if (!NetworkUtil.isNetworkAvailable(this.A))
    {
      this.z.a(0L);
      return;
    }
    if ((this.C.isLogin()) && (!AuthorityUtil.a(this.D, paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send | cmd: g_t_n_p | uin : *");
      localStringBuilder.append(AuthorityUtil.a(paramString));
      SSOLog.a("BaseAuthorityPresenter", new Object[] { localStringBuilder.toString() });
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      c(paramString, 1);
      this.z.a(2131892324);
      b(paramString);
      return;
    }
    e(paramString);
  }
  
  protected void a(String paramString, int paramInt)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "onAuthFailed ret=", Integer.valueOf(paramInt), ", uin=", AuthorityUtil.a(this.w.a) });
    String str = c(paramInt, paramString);
    switch (paramInt)
    {
    default: 
      a(paramInt, str);
      return;
    case 1105030: 
      b(paramInt, paramString, str);
      return;
    case 110537: 
      AuthUIUtil.a(this.A, 2131905671);
      c(this.v);
      a(paramInt, str);
      return;
    case 110509: 
      j();
      return;
    case 110405: 
      AuthUIUtil.a(this.A, str, new BaseAuthorityPresenter.7(this));
      a(paramInt, str);
      return;
    }
    a(paramInt, paramString, str);
    a(paramInt, str);
  }
  
  protected abstract void a(String paramString, int paramInt, Bundle paramBundle);
  
  protected void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    AuthReporter.a(this.A, l(), this.v, paramString1, paramLong, paramString2, paramString3);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = this.C;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l());
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(this.i);
    AuthReporter.a(localAppRuntime, paramString1, localStringBuilder.toString());
  }
  
  protected void a(boolean paramBoolean)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "onGetApiListSuccess authorized=", Boolean.valueOf(paramBoolean) });
    this.k = paramBoolean;
    String str;
    if (paramBoolean) {
      str = "wtl_loggednunauthorized";
    } else {
      str = "wtl_loggednauthorized";
    }
    a(str, this.w.a);
    long l1 = System.currentTimeMillis();
    long l2 = this.b;
    if (paramBoolean) {
      str = "auth";
    } else {
      str = "uauth";
    }
    a("connect_sso_pageview", l1 - l2, "logged", str);
  }
  
  public void b()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "doOnResume" });
    if (this.b == 0L) {
      this.b = System.currentTimeMillis();
    }
  }
  
  public void b(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      if (paramIntent == null) {
        paramIntent = this.C.getAccount();
      } else {
        paramIntent = paramIntent.getStringExtra("uin");
      }
      this.v = paramIntent;
      i();
      return;
    }
    c();
  }
  
  protected void b(int paramInt, String paramString)
  {
    AuthReporter.a(this.A, paramInt, paramString, this.v, l());
    AuthReporter.a(this.v, "0X800B65F");
  }
  
  protected void b(Bundle paramBundle)
  {
    this.y = paramBundle;
    this.t = AuthParamUtil.a(paramBundle, "client_id");
    this.u = AuthParamUtil.a(paramBundle, "key_proxy_appid");
    this.i = AuthParamUtil.a(paramBundle, "sdkv");
    this.o = AuthParamUtil.a(paramBundle, "key_login_by_qr_scan", false);
    this.q = AuthParamUtil.a(this.B, "internal_authority", false);
    this.n = AuthParamUtil.a(this.B);
    this.b = System.currentTimeMillis();
    this.x = SharedPrefs.b();
    this.v = AuthorityUtil.a(this.x, this.B);
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "init internal=", Boolean.valueOf(this.q), ", fromSdk=", Boolean.valueOf(this.n), ", appId=", this.t, ", fromQr=", Boolean.valueOf(this.o) });
  }
  
  protected void b(AuthResponse paramAuthResponse)
  {
    int i1 = paramAuthResponse.a.get();
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "parseAuthorizeResponse ret=", Integer.valueOf(i1) });
    if (i1 == 0)
    {
      a(paramAuthResponse);
      return;
    }
    a(paramAuthResponse.b.get(), i1);
  }
  
  protected abstract void b(String paramString);
  
  protected void b(String paramString, int paramInt)
  {
    String str1 = this.w.a;
    String str2 = l();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    AuthReporter.a(str1, str2, "6", localStringBuilder.toString(), false);
    str1 = c(paramInt, paramString);
    switch (paramInt)
    {
    default: 
      a(paramInt, paramString, str1);
      a(paramInt, str1);
      return;
    case 110537: 
      SSOLog.a("BaseAuthorityPresenter", new Object[] { "PRE_AUTH_110537 110537" });
      AuthUIUtil.a(this.A, 2131905671);
      BaseOpenSdkQIPCClient.a(this.v);
      c(this.v);
      return;
    case 110513: 
      a(110513, "", "", "");
      return;
    case 110509: 
      k();
      return;
    case 110405: 
      AuthUIUtil.a(this.A, str1, new BaseAuthorityPresenter.8(this));
      a(paramInt, str1);
      return;
    }
    AuthReporter.a(this.w.a, l(), this.y.getString("packagename"), this.y.getString("packagesign"));
    a(paramInt, paramString, str1);
    a(paramInt, str1);
  }
  
  protected boolean b(String paramString, boolean paramBoolean)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "changeAccountLogin newUin=", AuthorityUtil.a(paramString), ", canAutoLogin=", Boolean.valueOf(paramBoolean) });
    if (!NetworkUtil.isNetworkAvailable(this.A))
    {
      this.z.a(0L);
      return false;
    }
    if (AuthorityUtil.a(this.D, paramString))
    {
      c(paramString);
    }
    else
    {
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      c(paramString, 1);
      AuthorityUtil.a(this.C, paramString);
    }
    this.n = paramBoolean;
    return true;
  }
  
  protected String c(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return String.format(this.A.getString(2131892320), new Object[] { Integer.valueOf(paramInt) });
    }
    return String.format(this.A.getString(2131894269), new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void c()
  {
    this.A.setResult(0);
    this.A.finish();
    String str1;
    if (this.j) {
      str1 = "notlogged";
    } else {
      str1 = "logged";
    }
    String str2;
    if (this.k) {
      str2 = "auth";
    } else {
      str2 = "uauth";
    }
    a("connect_sso_backto3rd", 0L, str1, str2);
  }
  
  protected void c(Intent paramIntent)
  {
    try
    {
      JSONObject localJSONObject = HttpBaseUtil.a(paramIntent.getStringExtra("result_data"));
      AccountInfo localAccountInfo = new AccountInfo();
      localAccountInfo.a = localJSONObject.getString("uin");
      localAccountInfo.b = localJSONObject.getString("skey");
      localAccountInfo.c = paramIntent.getByteArrayExtra("st_temp");
      localAccountInfo.d = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localAccountInfo.a != null) && (localAccountInfo.b != null))
      {
        this.w = localAccountInfo;
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      SSOLog.c("BaseAuthorityPresenter", "JSONException", paramIntent);
      a(3004, 2131892314);
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showLoginActivity, uin=");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityPresenter", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = new Intent();
    ((Intent)localObject).putExtra("appid", l());
    ((Intent)localObject).putExtra("param_qr_code_url", this.B.getStringExtra("param_qr_code_url"));
    ((Intent)localObject).putExtra("oauth_app_name", AuthParamUtil.a(this.y, "oauth_app_name"));
    ((Intent)localObject).putExtra("param_uin", paramString);
    RouteUtils.a(this.A, (Intent)localObject, "/base/openSdkLogin", 1);
  }
  
  protected WloginSimpleInfo d(String paramString)
  {
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    WtloginManager localWtloginManager = this.D;
    if (localWtloginManager != null) {
      localWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
    }
    return localWloginSimpleInfo;
  }
  
  public void d()
  {
    boolean bool;
    if (this.s == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.m = bool;
  }
  
  public void e()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "onDeleteAccount" });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_req_src", 1);
    localIntent.putExtra("is_first_login", true);
    localIntent.putExtra("param_qr_code_url", this.B.getStringExtra("param_qr_code_url"));
    localIntent.putExtra("oauth_app_name", AuthParamUtil.a(this.y, "oauth_app_name"));
    localIntent.putExtra("appid", l());
    this.v = null;
    RouteUtils.a(this.A, localIntent, "/base/openSdkLogin", 1);
  }
  
  public void f()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "onAddAccount" });
    c(this.v);
  }
  
  protected void i()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "startAccountActivity" });
    if (SharedPrefs.d())
    {
      a(this.v);
      return;
    }
    f(this.v);
    a("connect_sso_pageview", System.currentTimeMillis() - this.b, "notlogged", "uauth");
  }
  
  protected void j()
  {
    if (this.r < 1)
    {
      this.r = 1;
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      c(this.v, 3);
      return;
    }
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "showLoginActivity AUTHORIZE_DONE 110509" });
    AuthUIUtil.a(this.A, 2131905669);
    c(this.v);
    AuthReporter.a(this.v, "0X800B65F");
  }
  
  protected void k()
  {
    if (this.r < 0)
    {
      this.r = 0;
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      c(this.v, 3);
      return;
    }
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "showLoginActivity GET_API_LIST_DONE 110509" });
    AuthUIUtil.a(this.A, 2131905669);
    c(this.v);
  }
  
  protected String l()
  {
    if (TextUtils.isEmpty(this.u)) {
      return this.t;
    }
    return this.u;
  }
  
  protected boolean m()
  {
    if (!QQLiteStatusUtil.a(MobileQQ.sMobileQQ))
    {
      SSOLog.a("BaseAuthorityPresenter", new Object[] { "jumpToPWDUnlock false" });
      return false;
    }
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "jumpToPWDUnlock true" });
    AuthorityUtil.a(this.A);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter
 * JD-Core Version:    0.7.0.1
 */