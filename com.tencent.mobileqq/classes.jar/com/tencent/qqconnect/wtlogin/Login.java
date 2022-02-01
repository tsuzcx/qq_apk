package com.tencent.qqconnect.wtlogin;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI.OnInteractionListener;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.util.HandlerPlus;
import java.util.HashMap;
import java.util.List;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

@RoutePage(desc="互联添加帐号页面", path="/base/openSdkLogin")
public class Login
  extends QBaseActivity
  implements AddAccountBaseUI.OnInteractionListener
{
  protected static final int CHECK_SUCCESS = 6;
  public static final int CLEAR_PROGRESS_DIALOG = 2001;
  protected static final int ERROR_EMPTY_ACCOUNT = 3103;
  protected static final int ERROR_EMPTY_PASSWD = 3104;
  protected static final int ERROR_NETWORK_ERROR = 3100;
  protected static final int ERROR_OTHER_ERROR = 3101;
  protected static final int LEFT_BACK_DELAY = 0;
  public static final int REQUEST_CODE_PHONE_LOGIN = 10000;
  protected static final int RET_NETWORK_ERROR = 1;
  protected static final int RET_OTHER_ERROR = 2;
  public static final int SHOW_PROGRESS_DIALOG = 2002;
  private static final String TAG = "Login";
  public static String gAccount = "";
  public static boolean gLoginNow = false;
  public static String gPasswd = "";
  protected OpenSDKAppInterface app;
  protected boolean autoFillInPasswd = true;
  private boolean isFromForgetSmsLogin;
  MqqHandler loginHandler = new Login.6(this);
  protected List<WloginLoginInfo> loginInfoList;
  private String mAppId;
  public BroadcastReceiver mAutoLoginReceiver = new Login.7(this);
  protected AddAccountBaseUI mBaseUI = new AddAccountBaseUI(this, this);
  protected HandlerPlus mHandler = new HandlerPlus(this.mMainCallback);
  protected long mLoginBTS;
  private LoginFailedHelper mLoginFailedHelper = new LoginFailedHelper();
  protected Handler.Callback mMainCallback = new Login.9(this);
  protected QQProgressDialog mProgress;
  private BroadcastReceiver mPuzzleVerifyCodeReceiver;
  protected TextView mQrCodeBtn;
  private BroadcastReceiver mQrCodeReceiver;
  private String mQrCodeUrl;
  protected long mReqSize = 0L;
  protected int mReqSrc = 1;
  private boolean mShouldAutoLogin = false;
  protected SSOAccountObserver ssoLoginObserver = new Login.1(this);
  protected WtloginManager wtloginManager;
  
  private Bundle buildBundle()
  {
    Bundle localBundle = new Bundle();
    if (OpenSdkIFrameProcessor.a()) {
      localBundle.putInt("puzzle_verify_code", 130);
    }
    localBundle.putByteArray("connect_data", AuthorityUtil.b(this.mAppId));
    return localBundle;
  }
  
  public static String convertUserInfoToJson(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("uin:'");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("',");
    localStringBuilder.append("skey:'");
    if (paramString2 != null) {
      localStringBuilder.append(paramString2);
    }
    localStringBuilder.append("'}");
    return localStringBuilder.toString();
  }
  
  private void gotoQrCodeUI()
  {
    SSOLog.a("Login", new Object[] { "gotoQrCodeUI" });
    this.mQrCodeBtn.setClickable(false);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", this.mQrCodeUrl);
    localIntent.putExtra("key_from_opensdk_qrcode", true);
    localIntent.putExtra("hide_more_button", true);
    startActivity(localIntent);
    report(0, "0X800BA18");
  }
  
  private void handleQRLogin()
  {
    if (TextUtils.isEmpty(this.mQrCodeUrl)) {
      return;
    }
    this.mQrCodeBtn = this.mBaseUI.a(getString(2131891432), new Login.2(this));
    this.mQrCodeReceiver = new Login.3(this);
    report(0, "0X800BA17");
    registerReceiver(this.mQrCodeReceiver, new IntentFilter("mqq.intent.action.QRCODE_LOGIN_FINISH"));
  }
  
  private void report(int paramInt, String paramString)
  {
    Object localObject2 = this.mAppId;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str = getIntent().getStringExtra("oauth_app_name");
    localObject2 = str;
    if (str == null) {
      localObject2 = "";
    }
    AuthorityUtil.a(null, paramString, 0, paramInt, new String[] { localObject1, "", localObject2, "" });
  }
  
  private void ssoLogin(String paramString1, String paramString2)
  {
    SSOLog.a("Login", new Object[] { "ssoLogin | cmd: s_s_o_l | uin : *", AuthorityUtil.a(paramString1) });
    unregisterPuzzleVerifyCodeReceiver();
    this.mPuzzleVerifyCodeReceiver = new Login.8(this);
    registerReceiver(this.mPuzzleVerifyCodeReceiver, new IntentFilter("mqq.opensdk.intent.action.PUZZLEVERIFYCODE"));
    this.app.ssoLogin(paramString1, paramString2, 4096, this.ssoLoginObserver, buildBundle());
    showLoginTip();
  }
  
  private void unregisterPuzzleVerifyCodeReceiver()
  {
    SSOLog.a("Login", new Object[] { "unregisterPuzzleVerifyCodeReceiver mPuzzleVerifyCodeReceiver=", this.mPuzzleVerifyCodeReceiver });
    BroadcastReceiver localBroadcastReceiver = this.mPuzzleVerifyCodeReceiver;
    if (localBroadcastReceiver != null)
    {
      try
      {
        unregisterReceiver(localBroadcastReceiver);
      }
      catch (Exception localException)
      {
        SSOLog.c("Login", "unregisterPuzzleVerifyCodeReceiver", localException);
      }
      this.mPuzzleVerifyCodeReceiver = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doLogin()
  {
    Object localObject1 = this.mBaseUI.m();
    Object localObject2 = this.mBaseUI.n();
    if ("".equals(((String)localObject1).trim()))
    {
      showDialog(String.format(getResources().getString(2131894269), new Object[] { getResources().getString(2131892234), Integer.valueOf(3103) }));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("error", "3103");
      StatisticCollector.getInstance(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject1, "");
      return;
    }
    if ("".equals(((String)localObject2).trim()))
    {
      showDialog(String.format(getResources().getString(2131894269), new Object[] { getResources().getString(2131892394), Integer.valueOf(3104) }));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("error", "3104");
      StatisticCollector.getInstance(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject1, "");
      return;
    }
    this.mReqSize = (((String)localObject1).length() + ((String)localObject2).length());
    LoginStaticField.a(4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->doLogin--account = *");
    localStringBuilder.append(AuthorityUtil.a((String)localObject1));
    localStringBuilder.append("mReqSrc = ");
    localStringBuilder.append(this.mReqSrc);
    SSOLog.a("Login", new Object[] { localStringBuilder.toString() });
    int i = this.mReqSrc;
    if ((i != 2) && (i != 3))
    {
      if (AuthorityUtil.a(this.wtloginManager, (String)localObject1))
      {
        ssoLogin((String)localObject1, (String)localObject2);
        return;
      }
      if (this.autoFillInPasswd)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("send | cmd: g_t_n_p | uin : *");
        ((StringBuilder)localObject2).append(AuthorityUtil.a((String)localObject1));
        SSOLog.a("Login", new Object[] { ((StringBuilder)localObject2).toString() });
        localObject2 = buildBundle();
        ((Bundle)localObject2).putLong("dwSrcAppid", 1600001540L);
        ((Bundle)localObject2).putLong("dwDstAppid", 1600001540L);
        this.app.ssoGetTicketNoPasswd((String)localObject1, 4096, this.ssoLoginObserver, (Bundle)localObject2);
        ((Bundle)localObject2).putLong("dwSrcAppid", 1600001540L);
        showLoginTip();
        return;
      }
      ssoLogin((String)localObject1, (String)localObject2);
      return;
    }
    boolean bool;
    if (this.mReqSrc == 2) {
      bool = AuthorityUtil.b(this.wtloginManager, (String)localObject1);
    } else {
      bool = AuthorityUtil.a(this.wtloginManager, (String)localObject1) ^ true;
    }
    if (bool)
    {
      if (this.autoFillInPasswd)
      {
        SSOLog.a("Login", new Object[] { "has a one" });
        loginSucess((String)localObject1, null, null);
        return;
      }
      ssoLogin((String)localObject1, (String)localObject2);
      return;
    }
    ssoLogin((String)localObject1, (String)localObject2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mLoginBTS = SystemClock.elapsedRealtime();
    if (getIntent().getExtras() != null) {
      this.mReqSrc = getIntent().getExtras().getInt("key_req_src", 1);
    }
    this.mAppId = getIntent().getStringExtra("appid");
    this.mQrCodeUrl = getIntent().getStringExtra("param_qr_code_url");
    paramBundle = new StringBuilder();
    paramBundle.append("onCreate mReqSrc:");
    paramBundle.append(this.mReqSrc);
    paramBundle.append(", mAppId=");
    paramBundle.append(this.mAppId);
    SSOLog.a("Login", new Object[] { paramBundle.toString() });
    this.mProgress = new QQProgressDialog(this, getTitleBarHeight());
    this.mBaseUI.a(2131896582);
    init();
    this.app.setHandler(LoginProgressClazz.class, this.loginHandler);
    if (this.mAutoLoginReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
      registerReceiver(this.mAutoLoginReceiver, paramBundle);
    }
    handleQRLogin();
    report(0, "0X800BA16");
    return true;
  }
  
  protected void doOnDestroy()
  {
    SSOLog.a("Login", new Object[] { "onDestroy" });
    super.doOnDestroy();
    hideLoginTip();
    this.app.removeHandler(LoginProgressClazz.class);
    BroadcastReceiver localBroadcastReceiver = this.mAutoLoginReceiver;
    if (localBroadcastReceiver != null) {
      unregisterReceiver(localBroadcastReceiver);
    }
    unregisterPuzzleVerifyCodeReceiver();
    localBroadcastReceiver = this.mQrCodeReceiver;
    if (localBroadcastReceiver != null)
    {
      unregisterReceiver(localBroadcastReceiver);
      this.mQrCodeReceiver = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SSOLog.a("Login", new Object[] { "onResume" });
    TextView localTextView = this.mQrCodeBtn;
    if (localTextView != null) {
      localTextView.setClickable(true);
    }
    if (gLoginNow)
    {
      gLoginNow = false;
      this.mBaseUI.a(gAccount);
      this.mBaseUI.b(gPasswd);
    }
    if (this.mShouldAutoLogin)
    {
      SSOLog.a("Login", new Object[] { "mShouldAutoLogin: true, then login" });
      this.mShouldAutoLogin = false;
      doLogin();
    }
  }
  
  public void doPhoneLogin()
  {
    ReportController.a(null, "dc00898", "", "", "0X800AFE5", "0X800AFE5", 0, 0, "", "", "", "");
    LoginStaticField.a(4);
    Intent localIntent = new Intent();
    localIntent.putExtra("entrance", "fromLogin");
    RouteUtils.a(this, localIntent, "/base/safe/loginPhoneNumActivity", 10000);
  }
  
  protected void hideLoginTip()
  {
    SSOLog.a("Login", new Object[] { "hideLoginTip" });
    QQProgressDialog localQQProgressDialog = this.mProgress;
    if (localQQProgressDialog == null) {
      return;
    }
    if (localQQProgressDialog.isShowing()) {
      try
      {
        this.mProgress.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void init()
  {
    this.app = ((OpenSDKAppInterface)getAppRuntime());
    this.wtloginManager = ((WtloginManager)this.app.getManager(1));
    this.loginInfoList = this.wtloginManager.getAllLoginInfo();
    EditText localEditText = this.mBaseUI.k();
    localEditText.setInputType(2);
    localEditText.setHint(2131896987);
    localEditText.setContentDescription(getString(2131897877));
    localEditText.addTextChangedListener(new Login.4(this));
    this.mBaseUI.l().addTextChangedListener(new Login.5(this));
  }
  
  protected void loginSucess(String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("-->loginSucess--mReqSrc = ");
    ((StringBuilder)localObject1).append(this.mReqSrc);
    ((StringBuilder)localObject1).append(", userAccount = *");
    ((StringBuilder)localObject1).append(AuthorityUtil.a(paramString1));
    SSOLog.a("Login", new Object[] { ((StringBuilder)localObject1).toString() });
    int i = this.mReqSrc;
    Object localObject2;
    if ((i != 2) && (i != 3))
    {
      Object localObject3 = new WloginSimpleInfo();
      this.wtloginManager.getBasicUserInfo(paramString1, (WloginSimpleInfo)localObject3);
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(((WloginSimpleInfo)localObject3)._uin);
      localObject1 = paramString1.toString();
      localObject2 = new Intent();
      localObject3 = new String(((WloginSimpleInfo)localObject3)._nick);
      if (paramString2 != null) {
        paramString1 = new String(paramString2);
      } else {
        paramString1 = null;
      }
      ((Intent)localObject2).putExtra("result_data", convertUserInfoToJson((String)localObject1, paramString1));
      ((Intent)localObject2).putExtra("last_account", (String)localObject1);
      ((Intent)localObject2).putExtra("isLogin", true);
      ((Intent)localObject2).putExtra("nick", (String)localObject3);
      if (paramBundle != null)
      {
        paramString1 = paramBundle.getByteArray("st_temp");
        paramString2 = paramBundle.getByteArray("st_temp_key");
        ((Intent)localObject2).putExtra("st_temp", paramString1);
        ((Intent)localObject2).putExtra("st_temp_key", paramString2);
      }
      ((Intent)localObject2).putExtra("fromLoginPhoneNum", this.isFromForgetSmsLogin);
      setResult(-1, (Intent)localObject2);
      paramString1 = (String)localObject1;
    }
    else
    {
      paramString1 = OpenSdkVirtualUtil.a(this.wtloginManager, paramString1);
      paramString2 = new Intent();
      paramString2.putExtra("last_account", paramString1);
      paramString2.putExtra("isLogin", true);
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getByteArray("st_temp");
        localObject2 = paramBundle.getByteArray("st_temp_key");
        paramString2.putExtra("st_temp", (byte[])localObject1);
        paramString2.putExtra("st_temp_key", (byte[])localObject2);
      }
      paramString2.putExtra("ssobundle", paramBundle);
      paramString2.putExtra("fromLoginPhoneNum", this.isFromForgetSmsLogin);
      setResult(-1, paramString2);
    }
    OpenProxy.a().a(paramString1);
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->onActivityResult--reqCode = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", resCode = ");
    ((StringBuilder)localObject).append(paramInt2);
    SSOLog.a("Login", new Object[] { ((StringBuilder)localObject).toString() });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {
          return;
        }
        localObject = new Message();
        paramIntent = paramIntent.getExtras();
        ((Message)localObject).what = 6;
        ((Message)localObject).setData(paramIntent);
        this.loginHandler.sendMessage((Message)localObject);
        return;
      }
      if (paramInt2 == 0) {
        hideLoginTip();
      }
    }
    else if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("last_account");
      String str = paramIntent.getStringExtra("wtTicket");
      Bundle localBundle = paramIntent.getBundleExtra("ssobundle");
      this.isFromForgetSmsLogin = paramIntent.getBooleanExtra("fromLoginPhoneNum", false);
      loginSucess((String)localObject, str, localBundle);
    }
  }
  
  public void onBackClick() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onFindPwdClick()
  {
    ReportController.a(null, "dc00898", "", "", "0X800B291", "0X800B291", 0, 0, "", "", "", "");
  }
  
  public void onPwdClear() {}
  
  void showDialog(String paramString)
  {
    if (!isFinishing()) {
      DialogUtil.b(this, 230).setMessageWithUrl(paramString).setTitle(getString(2131915899)).setPositiveButton(17039370, new Login.10(this)).show();
    }
  }
  
  void showFrozenDlg(Bundle paramBundle)
  {
    if ((!isFinishing()) && (paramBundle != null))
    {
      ISafeBlockApi localISafeBlockApi = (ISafeBlockApi)QRoute.api(ISafeBlockApi.class);
      if (localISafeBlockApi == null)
      {
        SSOLog.b("Login", new Object[] { "showFrozenDlg error: ISafeBlockApi null" });
        return;
      }
      String str1 = paramBundle.getString("loginalias");
      int i = localISafeBlockApi.getForbidScene(paramBundle.getByteArray("tlverror"));
      String str2 = paramBundle.getString("msg");
      String str3 = paramBundle.getString("errortitle");
      paramBundle = paramBundle.getString("errorUrl");
      localISafeBlockApi.reportFrozenDlg(null, i, 5, str2);
      String str4 = localISafeBlockApi.getAppendMsgWithSceneId(i);
      int j = localISafeBlockApi.getTipResIdWithSceneId(i);
      int k = localISafeBlockApi.getLinkTypeForReport(str2, i, 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(str4);
      paramBundle = DialogUtil.a(this, 230, str3, localISafeBlockApi.handleNotifyMsg(localStringBuilder.toString(), this, k), 2131887648, j, new Login.11(this, localISafeBlockApi, i, str2, paramBundle, str1), new Login.12(this, localISafeBlockApi, i, str2));
      paramBundle.setCancelable(true);
      paramBundle.show();
      return;
    }
    SSOLog.b("Login", new Object[] { "showFrozenDlg error: params wrong" });
  }
  
  protected void showLoginTip()
  {
    SSOLog.a("Login", new Object[] { "showLoginTip" });
    this.mProgress.a(getResources().getString(2131892332));
    if (!this.mProgress.isShowing()) {
      this.mProgress.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login
 * JD-Core Version:    0.7.0.1
 */