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
  private int F;
  private int G;
  private long H;
  private AuthResponse I;
  private final IOldAuthDataSource J;
  private final IOldAuthorityContract.View K;
  
  public OldAuthorityPresenter(IOldAuthorityContract.View paramView, IOldAuthDataSource paramIOldAuthDataSource, ILocalDataSource paramILocalDataSource)
  {
    super(paramView, paramILocalDataSource);
    this.K = paramView;
    this.J = paramIOldAuthDataSource;
  }
  
  private void a(int paramInt, long paramLong)
  {
    this.I = null;
    if (paramInt == 1002)
    {
      int i = this.F;
      if (i < 2)
      {
        this.F = (i + 1);
        h();
        return;
      }
    }
    a(3001, 2131892323);
    a("KEY_GET_AUTH_API_LIST_REQUEST", this.F, false);
    String str = MobileQQ.sMobileQQ.getResources().getString(2131892323);
    AuthReporter.a("agent_query_authority", paramLong, 0L, 0L, paramInt, this.w.a, str);
    AuthReporter.a(1, "LOGIN_GETAUTHLIST_AGENT", this.w.a, this.t, paramInt, str);
    AuthReporter.a(this.w.a, this.t, "2", String.valueOf(paramInt), false);
    AuthReporter.a(this.w.a, this.t, "6", String.valueOf(paramInt), false);
  }
  
  private void a(int paramInt, List<Permission> paramList)
  {
    if (paramInt == 1002)
    {
      int i = this.G;
      if (i < 1)
      {
        this.G = (i + 1);
        b(paramList);
        return;
      }
    }
    this.G = 0;
    a(3002, 2131892333);
    a("KEY_AUTHORIZE_REQUEST", this.G, false);
    paramList = MobileQQ.sMobileQQ.getResources().getString(2131892333);
    AuthReporter.a("agent_authority", this.H, 0L, 0L, paramInt, this.w.a, paramList);
    AuthReporter.a(1, "LOGIN_AUTH", this.w.a, this.t, 3002, paramList);
    paramList = this.w.a;
    String str = this.t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(3002);
    AuthReporter.a(paramList, str, "6", localStringBuilder.toString(), false);
  }
  
  private void a(Bundle paramBundle, String paramString)
  {
    this.G = 0;
    try
    {
      byte[] arrayOfByte = AuthorityUtil.a(paramBundle, "ConnAuthSvr.sdk_auth_api_emp".equals(paramString), this.w);
      if (arrayOfByte == null)
      {
        SSOLog.b("OldAuthorityPresenter", new Object[] { "onSdkAuthApiSuccess null == data" });
        return;
      }
      SdkAuthorize.AuthorizeResponse localAuthorizeResponse = (SdkAuthorize.AuthorizeResponse)new SdkAuthorize.AuthorizeResponse().mergeFrom(arrayOfByte);
      this.a.post(new OldAuthorityPresenter.7(this, localAuthorizeResponse));
      if (localAuthorizeResponse.ret.get() == 0) {
        FileDataSource.a(this.t, this.w.a, localAuthorizeResponse.expires_in.get(), arrayOfByte);
      }
      int i = localAuthorizeResponse.ret.get();
      AuthReporter.a(paramBundle, this.f, i, 13, paramString, this.t, this.v);
      long l1 = this.H;
      long l2 = arrayOfByte.length;
      long l3 = localAuthorizeResponse.toByteArray().length;
      paramBundle = this.w.a;
      paramString = new StringBuilder();
      paramString.append("ret: ");
      paramString.append(i);
      AuthReporter.a("agent_authority", l1, l2, l3, 0, paramBundle, paramString.toString());
      AuthReporter.a(0, "LOGIN_AUTH", this.w.a, this.t, i, null);
      a("KEY_AUTHORIZE_REQUEST", this.G, true);
      return;
    }
    catch (Exception paramBundle)
    {
      SSOLog.c("OldAuthorityPresenter", "Exception", paramBundle);
      a(3002, 2131892333);
      a("KEY_AUTHORIZE_REQUEST", this.G, false);
    }
  }
  
  private void a(Bundle paramBundle, String paramString, long paramLong)
  {
    try
    {
      byte[] arrayOfByte = AuthorityUtil.a(paramBundle, "ConnAuthSvr.get_app_info_emp".equals(paramString), this.w);
      if (arrayOfByte == null) {
        return;
      }
      GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
      localGetAppinfoResponse.mergeFrom(arrayOfByte);
      if (!localGetAppinfoResponse.has()) {
        return;
      }
      int i = localGetAppinfoResponse.ret.get();
      AuthReporter.a(paramBundle, paramLong, i, 12, paramString, this.t, this.v);
      if (i != 0) {
        return;
      }
      this.a.post(new OldAuthorityPresenter.5(this, localGetAppinfoResponse));
      return;
    }
    catch (Exception paramBundle)
    {
      SSOLog.c("OldAuthorityPresenter", "getAppInfo", paramBundle);
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean, String paramString, long paramLong)
  {
    this.F = 0;
    try
    {
      byte[] arrayOfByte = AuthorityUtil.a(paramBundle, paramBoolean, this.w);
      if (arrayOfByte == null) {
        return;
      }
      SdkAuthorize.GetAuthApiListResponse localGetAuthApiListResponse = new SdkAuthorize.GetAuthApiListResponse();
      localGetAuthApiListResponse.mergeFrom(arrayOfByte);
      this.a.post(new OldAuthorityPresenter.2(this, localGetAuthApiListResponse));
      int i = localGetAuthApiListResponse.ret.get();
      AuthReporter.a(paramBundle, this.e, i, 11, paramString, this.t, this.v);
      long l1 = arrayOfByte.length;
      long l2 = localGetAuthApiListResponse.toByteArray().length;
      paramBundle = this.w.a;
      paramString = new StringBuilder();
      paramString.append("ret: ");
      paramString.append(i);
      AuthReporter.a("agent_query_authority", paramLong, l1, l2, 0, paramBundle, paramString.toString());
      AuthReporter.a(0, "LOGIN_GETAUTHLIST_AGENT", this.w.a, this.t, i, null);
      AuthReporter.a(this.w.a, this.t, "2", "0", false);
      a("KEY_GET_AUTH_API_LIST_REQUEST", this.F, true);
      AuthReporter.b(System.currentTimeMillis() - this.b, 14, this.t, this.v);
      return;
    }
    catch (Exception paramBundle)
    {
      SSOLog.c("OldAuthorityPresenter", "Exception", paramBundle);
      a(3001, 2131892323);
      a("KEY_GET_AUTH_API_LIST_REQUEST", this.F, false);
    }
  }
  
  private void a(GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    SSOLog.a("OldAuthorityPresenter", new Object[] { "parseGetAppInfoResponse mHasAppIcon=", Boolean.valueOf(this.l) });
    if (!TextUtils.isEmpty(paramGetAppinfoResponse.appName.get()))
    {
      String str = paramGetAppinfoResponse.appName.get();
      this.K.a(str, null);
      SSOLog.a("OldAuthorityPresenter", new Object[] { "parseGetAppInfoResponse appName=", str });
    }
    if (this.l) {
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
    AuthReporter.a(paramString, this.w, localHashMap, paramBoolean);
  }
  
  private void a(List<Permission> paramList, Bundle paramBundle)
  {
    Object[] arrayOfObject = AuthorityUtil.a(this.C, this.w.a, "ConnAuthSvr.sdk_auth_api", "ConnAuthSvr.sdk_auth_api_emp");
    String str = (String)arrayOfObject[0];
    SSOLog.a("OldAuthorityPresenter", new Object[] { "doAuthorize cmd=", str, ", uin=", AuthorityUtil.a(this.w.a) });
    this.J.a(paramList, paramBundle, this.w, arrayOfObject, new OldAuthorityPresenter.6(this, str, paramList));
  }
  
  private void a(boolean paramBoolean1, Bundle paramBundle, long paramLong, boolean paramBoolean2, String paramString)
  {
    this.e = (SystemClock.elapsedRealtime() - paramLong);
    String str = paramBundle.getString("ssoAccount");
    if (!this.w.a.equals(str))
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "onGetAuthApiBack account changed, ssoAccount=", str });
      return;
    }
    if (!this.n) {
      this.K.a(true);
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
    this.m = false;
    if (this.K.a(paramGetAuthApiListResponse, this.t))
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
    this.K.a(true);
    this.K.b();
    n();
  }
  
  private void b(String paramString1, String paramString2)
  {
    ThreadManager.executeOnSubThread(new OldAuthorityPresenter.8(this, paramString2));
  }
  
  private void b(List<Permission> paramList)
  {
    this.G = 0;
    this.H = SystemClock.elapsedRealtime();
    Bundle localBundle = new Bundle(this.y);
    localBundle.putString("openapi", "");
    localBundle.putBoolean("doAuthorize", true);
    localBundle.putString("need_pay", "1");
    localBundle.putString("appid_for_getting_config", localBundle.getString("client_id"));
    this.K.a(2131892332);
    if (this.y.getBoolean("key_login_by_qr_scan", false))
    {
      SSOLog.b("OldAuthorityPresenter", "doAuthorize confirmQRLogin");
      QQLiteStatusUtil.a(this.y);
      return;
    }
    this.s = 1;
    this.K.a(30000L);
    AuthReporter.a("KEY_AUTHORIZE_REQUEST");
    a(paramList, localBundle);
  }
  
  private void c(AuthResponse paramAuthResponse)
  {
    this.I = paramAuthResponse;
    if (!this.n) {
      return;
    }
    this.a.post(new OldAuthorityPresenter.3(this));
  }
  
  private boolean c(Bundle paramBundle)
  {
    if (this.q)
    {
      AuthModelUtil.b(paramBundle);
      i();
      return false;
    }
    if (!"action_login".equals(AuthParamUtil.b(this.B, "key_action"))) {
      return false;
    }
    if (m())
    {
      this.n = false;
      return true;
    }
    i();
    return false;
  }
  
  private void h()
  {
    if (this.w == null)
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "queryAuthList mAccount == null" });
      this.K.a(30000L);
      return;
    }
    Object[] arrayOfObject = AuthorityUtil.a(this.C, this.w.a, "ConnAuthSvr.get_auth_api_list", "ConnAuthSvr.get_auth_api_list_emp");
    String str = (String)arrayOfObject[0];
    boolean bool = "ConnAuthSvr.get_auth_api_list_emp".equals(str);
    if ((bool) && ((this.w.c == null) || (this.w.c.length == 0)))
    {
      SSOLog.a("OldAuthorityPresenter", new Object[] { "queryAuthList useEmp && (mAccount.st == null || mAccount.st.length == 0)" });
      a(3000, 2131892323);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    SSOLog.a("OldAuthorityPresenter", new Object[] { "queryAuthList cmd=", str, ", uin=", AuthorityUtil.a(this.w.a) });
    this.s = 0;
    this.K.a(30000L);
    this.J.a(this.y, this.w, arrayOfObject, new OldAuthorityPresenter.1(this, l, bool, str));
  }
  
  private void n()
  {
    Object[] arrayOfObject = AuthorityUtil.a(this.C, this.w.a, "ConnAuthSvr.get_app_info", "ConnAuthSvr.get_app_info_emp");
    String str = (String)arrayOfObject[0];
    SSOLog.a("OldAuthorityPresenter", new Object[] { "getAppInfo cmd=", str });
    AuthReporter.a("KEY_GET_APP_INFO_REQUEST");
    this.s = 2;
    this.K.a(30000L);
    long l = System.currentTimeMillis();
    this.J.b(this.y, this.w, arrayOfObject, new OldAuthorityPresenter.4(this, str, l));
  }
  
  private void o()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showUserInfo uin=");
    ((StringBuilder)localObject).append(AuthorityUtil.a(this.w.a));
    SSOLog.a("OldAuthorityPresenter", new Object[] { ((StringBuilder)localObject).toString() });
    String str1 = new String(d(this.w.a)._nick);
    IOldAuthorityContract.View localView = this.K;
    String str2 = this.w.a;
    localObject = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject = this.w.a;
    }
    localView.a(str2, (String)localObject, null);
    AvatarUpdateService.a().a(this.A, this.w.a, this.w.b, new OldAuthorityPresenter.9(this));
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
      this.I = null;
      c(paramIntent);
      if (0L != ParseUtil.a(this.t)) {
        n();
      }
      this.v = paramIntent.getStringExtra("last_account");
      if (this.D != null) {
        this.v = Long.toString(d(this.v)._uin);
      }
      this.K.a(this.t);
      b(this.v);
      this.a.post(new OldAuthorityPresenter.11(this));
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
      this.K.a(false);
      if ((paramIntent.getBooleanExtra("fromLoginPhoneNum", false)) && (this.w != null) && (this.w.d == null))
      {
        a(this.v);
        return;
      }
      this.p = false;
      AuthMemoryCache.a().a(this.v);
      h();
    }
  }
  
  protected void a(String paramString, int paramInt, Bundle paramBundle)
  {
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, System.currentTimeMillis());
    }
    this.h = 0;
    this.p = false;
    this.d = SystemClock.elapsedRealtime();
    this.K.a(true);
    if (!this.q) {
      this.a.post(new OldAuthorityPresenter.10(this));
    }
    if (this.r == 1)
    {
      b((List)this.K.b(4));
      return;
    }
    h();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (b(paramString, paramBoolean)) {
      this.I = null;
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
    AuthReporter.a(this.v, "0X800B65C");
    AuthReporter.a(this.v, this.t, "1", "0", false);
    AuthorityUtil.e("0X800BA81");
    return c(paramBundle);
  }
  
  protected void b(String paramString)
  {
    SSOLog.b("OldAuthorityPresenter", new Object[] { "showLocalInfo currentAccount=", AuthorityUtil.a(paramString) });
    if (!this.q)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      WloginSimpleInfo localWloginSimpleInfo = d(paramString);
      Object localObject1 = Long.toString(localWloginSimpleInfo._uin);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("0")))
      {
        Object localObject2 = new String(localWloginSimpleInfo._nick);
        paramString = (String)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString = (String)localObject1;
        }
        this.v = Long.toString(localWloginSimpleInfo._uin);
        localObject2 = OpenSdkVirtualUtil.a((String)localObject1, 58, true);
        if (localObject2 != null)
        {
          localObject1 = AuthorityUtil.a(this.A, (Bitmap)localObject2, 63, 63);
          ((Bitmap)localObject2).recycle();
          this.K.a(this.v, paramString, (Bitmap)localObject1);
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
    SSOLog.a("OldAuthorityPresenter", new Object[] { "onLoginBtnClick mGetTicketFailed=", Boolean.valueOf(this.p) });
    if ((!this.m) && (!this.p) && (this.w != null))
    {
      this.K.a(false);
      if (this.s == 0)
      {
        this.K.a(2131892324);
        h();
        return;
      }
      AuthReporter.a("KEY_LOGIN_STAGE_2_OLD_TOTAL", this.w);
      AuthReporter.a("KEY_LOGIN_STAGE_3_TOTAL");
      if (this.I != null)
      {
        SSOLog.a("OldAuthorityPresenter", new Object[] { "ClickAuthButton: " });
        this.a.post(new OldAuthorityPresenter.12(this));
      }
      else
      {
        SSOLog.a("OldAuthorityPresenter", new Object[] { "ClickAuthButton -- doAuthorize(): " });
        b((List)this.K.b(4));
      }
      AuthReporter.a(this.v, this.t, "2", "0", false);
      AuthorityUtil.e("0X800BA82");
      return;
    }
    a(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.OldAuthorityPresenter
 * JD-Core Version:    0.7.0.1
 */