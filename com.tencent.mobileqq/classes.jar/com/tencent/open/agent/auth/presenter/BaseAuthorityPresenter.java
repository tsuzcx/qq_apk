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
  protected int a;
  protected long a;
  protected final Activity a;
  protected final Intent a;
  protected Bundle a;
  protected Handler a;
  protected final IBaseView a;
  protected final ILocalDataSource a;
  protected AccountInfo a;
  protected String a;
  protected List<String> a;
  protected final AppRuntime a;
  protected final WtloginManager a;
  protected boolean a;
  protected int b;
  protected long b;
  protected String b;
  protected boolean b;
  protected int c;
  protected long c;
  protected String c;
  protected boolean c;
  protected long d;
  protected String d;
  protected boolean d;
  protected long e;
  protected boolean e;
  protected long f;
  protected boolean f;
  protected boolean g;
  protected boolean h;
  
  protected BaseAuthorityPresenter(IBaseView paramIBaseView, ILocalDataSource paramILocalDataSource)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.myLooper());
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentOpenAgentAuthIBaseView = paramIBaseView;
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelILocalDataSource = paramILocalDataSource;
    this.jdField_a_of_type_MqqAppAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(1));
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramIBaseView.a(3));
    this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "app=", this.jdField_a_of_type_MqqAppAppRuntime, ", mWtLoginManager=", this.jdField_a_of_type_MqqManagerWtloginManager });
  }
  
  private void a(int paramInt, String paramString1, String paramString2, AccountInfo paramAccountInfo, String paramString3)
  {
    AuthReporter.a(paramInt, paramAccountInfo);
    paramAccountInfo = "0";
    if (paramInt == 0)
    {
      AuthReporter.a(paramString3, "0X800B65E");
      AuthReporter.a(paramString3, a(), "6", "0", false);
      paramString1 = paramAccountInfo;
    }
    else
    {
      AuthReporter.a(paramString3, "0X800B65F");
      AuthReporter.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, paramString1, paramString3, a(), paramString2);
      paramString1 = "1";
    }
    AuthReporter.a(paramInt, a(), paramString3);
    if (AuthParamUtil.a(this.jdField_a_of_type_AndroidContentIntent)) {
      AuthReporter.a(paramString3, a(), "9", paramString1, true);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_MqqAppAppRuntime.getAccount())) && (!this.jdField_a_of_type_MqqAppAppRuntime.getAccount().equals(paramString3))) {
      AuthReporter.a(paramString3, a(), "10", paramString1, true);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    this.g = true;
    if ((paramInt1 != -1000) && (paramInt1 != 154))
    {
      c(paramString);
      return;
    }
    if (paramInt2 == 1002)
    {
      paramInt1 = this.jdField_a_of_type_Int;
      if (paramInt1 < 2)
      {
        this.jdField_a_of_type_Int = (paramInt1 + 1);
        this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
        a(paramString);
        return;
      }
    }
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    a(3003, 2131694647);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    long l = this.jdField_b_of_type_Long;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ret: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" | error: ");
    localStringBuilder.append(paramString2);
    AuthReporter.a("agent_login", l, 0L, 0L, paramInt2, paramString1, localStringBuilder.toString());
    AuthReporter.a(1, "LOGIN_GETTICKT", paramString1, a(), paramInt2, paramString2);
    paramString2 = a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    AuthReporter.a(paramString1, paramString2, "1", localStringBuilder.toString(), false);
    paramString2 = a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    AuthReporter.a(paramString1, paramString2, "6", localStringBuilder.toString(), false);
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString1, false);
    AuthReporter.a("KEY_LOGIN_STAGE_1_TOTAL", paramString1, this.jdField_a_of_type_Long, null, false);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
    AuthReporter.a("KEY_LOGIN_STAGE_1_TOTAL", this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, null, true);
    if (!paramBundle.getBoolean("fake_callback"))
    {
      SSOLog.a("BaseAuthorityPresenter", new Object[] { "onRefreshTicketSuccess fake callback" });
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_f_of_type_Long;
      int i = paramBundle.getInt("code");
      AuthReporter.a(l1 - l2, i, a(), paramString);
      AuthReporter.a("agent_login", this.jdField_f_of_type_Long, paramString.length(), paramArrayOfByte.length, 0, paramString, null);
      AuthReporter.a(0, "LOGIN_GETTICKT", paramString, a(), i, null);
      AuthReporter.a(paramString, a(), "1", "0", false);
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    b(paramInt, paramString1);
    byte[] arrayOfByte = FileDataSource.a(a(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
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
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    AccountManage.a().a(paramString, new BaseAuthorityPresenter.3(this), a(), paramInt);
  }
  
  private void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send | cmd: g_t_n_p | uin :*");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityPresenter", new Object[] { localStringBuilder.toString() });
    this.jdField_a_of_type_ComTencentOpenAgentAuthIBaseView.a(2131694646);
    if (TextUtils.isEmpty(paramString))
    {
      e(paramString);
      this.jdField_a_of_type_Boolean = true;
      a("wtl_notlogged", "0");
      return;
    }
    if (AuthorityUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString))
    {
      c(paramString);
      return;
    }
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
    c(paramString, 1);
    b(paramString);
  }
  
  private void e(String paramString)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "changeAccountActivity uin=", AuthorityUtil.a(paramString) });
    Intent localIntent = new Intent();
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 1))
    {
      localIntent.putExtra("third_app_id", a());
      localIntent.putExtra("param_uin", paramString);
      paramString = "/base/switchAccount";
    }
    else
    {
      localIntent.putExtra("appid", a());
      localIntent.putExtra("is_first_login", true);
      paramString = "/base/openSdkLogin";
    }
    localIntent.putExtra("key_req_src", 1);
    localIntent.putExtra("param_qr_code_url", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_qr_code_url"));
    RouteUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, paramString, 1);
  }
  
  protected int a(List<IconUrlSize> paramList)
  {
    int i1 = paramList.size();
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < i1)
    {
      int n = ParseUtil.a(((IconUrlSize)paramList.get(i)).b.get());
      if (n >= 100) {
        return i;
      }
      int m = j;
      if (n > j)
      {
        k = i;
        m = n;
      }
      i += 1;
      j = m;
    }
    return k;
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected String a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131694636), new Object[] { Integer.valueOf(paramInt) });
    }
    return String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131696495), new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  protected WloginSimpleInfo a(String paramString)
  {
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    WtloginManager localWtloginManager = this.jdField_a_of_type_MqqManagerWtloginManager;
    if (localWtloginManager != null) {
      localWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
    }
    return localWloginSimpleInfo;
  }
  
  public void a()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "doOnPause" });
    this.jdField_a_of_type_Long = 0L;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, MobileQQ.sMobileQQ.getResources().getString(paramInt2));
  }
  
  protected void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new BaseAuthorityPresenter.6(this, paramInt, paramString));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new BaseAuthorityPresenter.4(this, paramInt, paramString1);
    AuthUIUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramString2, new BaseAuthorityPresenter.5(this, paramString1));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "setSdkResult, error=", Integer.valueOf(paramInt), ", mCurrentAccount=", AuthorityUtil.a(this.jdField_d_of_type_JavaLangString) });
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
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    a(paramInt, paramString2, paramString3, this.jdField_a_of_type_ComTencentOpenModelAccountInfo, this.jdField_d_of_type_JavaLangString);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new BaseAuthorityPresenter.1(this, paramBitmap));
  }
  
  protected void a(AuthResponse paramAuthResponse)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelILocalDataSource.a(paramAuthResponse.c.get(), a(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelILocalDataSource.a(paramAuthResponse.c.get(), paramAuthResponse.e.get());
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        localObject = "wtl_lognback";
      } else {
        localObject = "wtl_lognauthorizenback";
      }
      a((String)localObject, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
    }
    else
    {
      if (this.jdField_b_of_type_Boolean) {
        localObject = "wtl_loggednunauthorizedback";
      } else {
        localObject = "wtl_loggednauthorizedback";
      }
      a((String)localObject, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
    }
    AuthReporter.a(this.jdField_a_of_type_AndroidAppActivity, a(), this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Long, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
    if (this.jdField_f_of_type_Boolean)
    {
      AuthReporter.a(paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get(), this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
      QQLiteStatusUtil.a(this.jdField_a_of_type_AndroidOsBundle);
      if (paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get() == 0) {
        paramAuthResponse = "0X800B65E";
      } else {
        paramAuthResponse = "0X800B65F";
      }
      AuthReporter.a(this.jdField_d_of_type_JavaLangString, paramAuthResponse);
      return;
    }
    for (;;)
    {
      try
      {
        long l1 = this.jdField_c_of_type_Long;
        long l2 = this.jdField_b_of_type_Long;
        long l3 = this.jdField_d_of_type_Long;
        long l4 = this.jdField_e_of_type_Long;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          bool = true;
          localObject = AuthorityUtil.a(paramAuthResponse, l1 - l2, l3, l4, bool);
          a(paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get(), ((JSONObject)localObject).toString(), null, null);
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
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentOpenAgentAuthIBaseView.a(true);
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIBaseView.a(0L);
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime.isLogin()) && (!AuthorityUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send | cmd: g_t_n_p | uin : *");
      localStringBuilder.append(AuthorityUtil.a(paramString));
      SSOLog.a("BaseAuthorityPresenter", new Object[] { localStringBuilder.toString() });
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      c(paramString, 1);
      this.jdField_a_of_type_ComTencentOpenAgentAuthIBaseView.a(2131694640);
      b(paramString);
      return;
    }
    d(paramString);
  }
  
  protected void a(String paramString, int paramInt)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "onAuthFailed ret=", Integer.valueOf(paramInt), ", uin=", AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString) });
    String str = a(paramInt, paramString);
    switch (paramInt)
    {
    default: 
      a(paramInt, str);
      return;
    case 1105030: 
      b(paramInt, paramString, str);
      return;
    case 110537: 
      AuthUIUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131707857);
      c(this.jdField_d_of_type_JavaLangString);
      a(paramInt, str);
      return;
    case 110509: 
      j();
      return;
    case 110405: 
      AuthUIUtil.a(this.jdField_a_of_type_AndroidAppActivity, str, new BaseAuthorityPresenter.7(this));
      a(paramInt, str);
      return;
    }
    a(paramInt, paramString, str);
    a(paramInt, str);
  }
  
  protected abstract void a(String paramString, int paramInt, Bundle paramBundle);
  
  protected void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    AuthReporter.a(this.jdField_a_of_type_AndroidAppActivity, a(), this.jdField_d_of_type_JavaLangString, paramString1, paramLong, paramString2, paramString3);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    AuthReporter.a(localAppRuntime, paramString1, localStringBuilder.toString());
  }
  
  protected void a(boolean paramBoolean)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "onGetApiListSuccess authorized=", Boolean.valueOf(paramBoolean) });
    this.jdField_b_of_type_Boolean = paramBoolean;
    String str;
    if (paramBoolean) {
      str = "wtl_loggednunauthorized";
    } else {
      str = "wtl_loggednauthorized";
    }
    a(str, this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString);
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (paramBoolean) {
      str = "auth";
    } else {
      str = "uauth";
    }
    a("connect_sso_pageview", l1 - l2, "logged", str);
  }
  
  protected boolean a()
  {
    if (!QQLiteStatusUtil.a(MobileQQ.sMobileQQ))
    {
      SSOLog.a("BaseAuthorityPresenter", new Object[] { "jumpToPWDUnlock false" });
      return false;
    }
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "jumpToPWDUnlock true" });
    AuthorityUtil.a(this.jdField_a_of_type_AndroidAppActivity);
    return true;
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "changeAccountLogin newUin=", AuthorityUtil.a(paramString), ", canAutoLogin=", Boolean.valueOf(paramBoolean) });
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIBaseView.a(0L);
      return false;
    }
    if (AuthorityUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString))
    {
      c(paramString);
    }
    else
    {
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      c(paramString, 1);
      AuthorityUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString);
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    return true;
  }
  
  public void b()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "doOnResume" });
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void b(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      if (paramIntent == null) {
        paramIntent = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
      } else {
        paramIntent = paramIntent.getStringExtra("uin");
      }
      this.jdField_d_of_type_JavaLangString = paramIntent;
      i();
      return;
    }
    c();
  }
  
  protected void b(int paramInt, String paramString)
  {
    AuthReporter.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, paramString, this.jdField_d_of_type_JavaLangString, a());
    AuthReporter.a(this.jdField_d_of_type_JavaLangString, "0X800B65F");
  }
  
  protected void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_b_of_type_JavaLangString = AuthParamUtil.a(paramBundle, "client_id");
    this.jdField_c_of_type_JavaLangString = AuthParamUtil.a(paramBundle, "key_proxy_appid");
    this.jdField_a_of_type_JavaLangString = AuthParamUtil.a(paramBundle, "sdkv");
    this.jdField_f_of_type_Boolean = AuthParamUtil.a(paramBundle, "key_login_by_qr_scan", false);
    this.h = AuthParamUtil.a(this.jdField_a_of_type_AndroidContentIntent, "internal_authority", false);
    this.jdField_e_of_type_Boolean = AuthParamUtil.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList = SharedPrefs.a();
    this.jdField_d_of_type_JavaLangString = AuthorityUtil.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidContentIntent);
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "init internal=", Boolean.valueOf(this.h), ", fromSdk=", Boolean.valueOf(this.jdField_e_of_type_Boolean), ", appId=", this.jdField_b_of_type_JavaLangString, ", fromQr=", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
  }
  
  protected void b(AuthResponse paramAuthResponse)
  {
    int i = paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get();
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "parseAuthorizeResponse ret=", Integer.valueOf(i) });
    if (i == 0)
    {
      a(paramAuthResponse);
      return;
    }
    a(paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get(), i);
  }
  
  protected abstract void b(String paramString);
  
  protected void b(String paramString, int paramInt)
  {
    String str1 = this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString;
    String str2 = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    AuthReporter.a(str1, str2, "6", localStringBuilder.toString(), false);
    str1 = a(paramInt, paramString);
    switch (paramInt)
    {
    default: 
      a(paramInt, paramString, str1);
      a(paramInt, str1);
      return;
    case 110537: 
      SSOLog.a("BaseAuthorityPresenter", new Object[] { "PRE_AUTH_110537 110537" });
      AuthUIUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131707857);
      BaseOpenSdkQIPCClient.a(this.jdField_d_of_type_JavaLangString);
      c(this.jdField_d_of_type_JavaLangString);
      return;
    case 110513: 
      a(110513, "", "", "");
      return;
    case 110509: 
      k();
      return;
    case 110405: 
      AuthUIUtil.a(this.jdField_a_of_type_AndroidAppActivity, str1, new BaseAuthorityPresenter.8(this));
      a(paramInt, str1);
      return;
    }
    AuthReporter.a(this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString, a(), this.jdField_a_of_type_AndroidOsBundle.getString("packagename"), this.jdField_a_of_type_AndroidOsBundle.getString("packagesign"));
    a(paramInt, paramString, str1);
    a(paramInt, str1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidAppActivity.setResult(0);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    String str1;
    if (this.jdField_a_of_type_Boolean) {
      str1 = "notlogged";
    } else {
      str1 = "logged";
    }
    String str2;
    if (this.jdField_b_of_type_Boolean) {
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
      localAccountInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("uin");
      localAccountInfo.jdField_b_of_type_JavaLangString = localJSONObject.getString("skey");
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localAccountInfo.jdField_a_of_type_JavaLangString != null) && (localAccountInfo.jdField_b_of_type_JavaLangString != null))
      {
        this.jdField_a_of_type_ComTencentOpenModelAccountInfo = localAccountInfo;
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      SSOLog.c("BaseAuthorityPresenter", "JSONException", paramIntent);
      a(3004, 2131694630);
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showLoginActivity, uin=");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityPresenter", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = new Intent();
    ((Intent)localObject).putExtra("appid", a());
    ((Intent)localObject).putExtra("param_qr_code_url", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_qr_code_url"));
    ((Intent)localObject).putExtra("param_uin", paramString);
    RouteUtils.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, "/base/openSdkLogin", 1);
  }
  
  public void d()
  {
    boolean bool;
    if (this.jdField_c_of_type_Int == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_d_of_type_Boolean = bool;
  }
  
  public void e()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "onDeleteAccount" });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_req_src", 1);
    localIntent.putExtra("is_first_login", true);
    localIntent.putExtra("param_qr_code_url", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_qr_code_url"));
    localIntent.putExtra("appid", a());
    this.jdField_d_of_type_JavaLangString = null;
    RouteUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, "/base/openSdkLogin", 1);
  }
  
  public void f()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "onAddAccount" });
    c(this.jdField_d_of_type_JavaLangString);
  }
  
  protected void i()
  {
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "startAccountActivity" });
    if (SharedPrefs.a())
    {
      a(this.jdField_d_of_type_JavaLangString);
      return;
    }
    e(this.jdField_d_of_type_JavaLangString);
    a("connect_sso_pageview", System.currentTimeMillis() - this.jdField_a_of_type_Long, "notlogged", "uauth");
  }
  
  protected void j()
  {
    if (this.jdField_b_of_type_Int < 1)
    {
      this.jdField_b_of_type_Int = 1;
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      c(this.jdField_d_of_type_JavaLangString, 3);
      return;
    }
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "showLoginActivity AUTHORIZE_DONE 110509" });
    AuthUIUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131707855);
    c(this.jdField_d_of_type_JavaLangString);
    AuthReporter.a(this.jdField_d_of_type_JavaLangString, "0X800B65F");
  }
  
  protected void k()
  {
    if (this.jdField_b_of_type_Int < 0)
    {
      this.jdField_b_of_type_Int = 0;
      AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      c(this.jdField_d_of_type_JavaLangString, 3);
      return;
    }
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "showLoginActivity GET_API_LIST_DONE 110509" });
    AuthUIUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131707855);
    c(this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter
 * JD-Core Version:    0.7.0.1
 */