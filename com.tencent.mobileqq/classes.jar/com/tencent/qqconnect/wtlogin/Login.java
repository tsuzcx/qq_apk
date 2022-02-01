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
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
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
  extends BaseActivity
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
  private boolean actionSheetHasClick = false;
  protected OpenSDKAppInterface app;
  protected boolean autoFillInPasswd = true;
  View.OnFocusChangeListener focusListener = new Login.4(this);
  private boolean isFromForgetSmsLogin;
  protected TextView leftView;
  protected Button login;
  MqqHandler loginHandler = new Login.8(this);
  protected List<WloginLoginInfo> loginInfoList;
  private ActionSheet mActionSheet = null;
  private String mAppId;
  public BroadcastReceiver mAutoLoginReceiver = new Login.9(this);
  protected View mDelBtn;
  protected View mDelPassBtn;
  protected HandlerPlus mHandler = new HandlerPlus(this.mMainCallback);
  protected long mLoginBTS;
  private LoginFailedHelper mLoginFailedHelper = new LoginFailedHelper();
  protected Handler.Callback mMainCallback = new Login.11(this);
  protected QQProgressDialog mProgress;
  private BroadcastReceiver mPuzzleVerifyCodeReceiver;
  protected TextView mQrCodeBtn;
  private BroadcastReceiver mQrCodeReceiver;
  private String mQrCodeUrl;
  protected long mReqSize = 0L;
  protected int mReqSrc = 1;
  private boolean mShouldAutoLogin = false;
  protected EditText name;
  protected View.OnClickListener onClick = new Login.12(this);
  TextWatcher onEnterPswd = new Login.7(this);
  TextWatcher onTextChangeForUpdating = new Login.6(this);
  View.OnTouchListener onTouchListener = new Login.5(this);
  protected EditText pswd;
  protected SSOAccountObserver ssoLoginObserver = new Login.1(this);
  protected TextView txtPhoneNumLogin;
  protected TextView unLoginTv;
  protected WtloginManager wtloginManager;
  
  private Bundle buildBundle()
  {
    Bundle localBundle = new Bundle();
    if (OpenSdkIFrameProcessor.a()) {
      localBundle.putInt("puzzle_verify_code", 130);
    }
    localBundle.putByteArray("connect_data", AuthorityUtil.a(this.mAppId));
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
    reportQrcodeLogin(0, "0X800BA18");
  }
  
  private void reportQrcodeLogin(int paramInt, String paramString)
  {
    AuthorityUtil.a(null, paramString, 0, paramInt, new String[] { "", this.mAppId, "", "" });
  }
  
  private void ssoLogin(String paramString1, String paramString2)
  {
    SSOLog.a("Login", new Object[] { "ssoLogin | cmd: s_s_o_l | uin : *", AuthorityUtil.a(paramString1) });
    unregisterPuzzleVerifyCodeReceiver();
    this.mPuzzleVerifyCodeReceiver = new Login.10(this);
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
  
  protected void doLogin()
  {
    if ("".equals(this.name.getText().toString().trim()))
    {
      showDialog(String.format(getResources().getString(2131696495), new Object[] { getResources().getString(2131694550), Integer.valueOf(3103) }));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("error", "3103");
      StatisticCollector.getInstance(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject1, "");
      return;
    }
    if ("".equals(this.pswd.getText().toString().trim()))
    {
      showDialog(String.format(getResources().getString(2131696495), new Object[] { getResources().getString(2131694702), Integer.valueOf(3104) }));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("error", "3104");
      StatisticCollector.getInstance(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject1, "");
      return;
    }
    Object localObject1 = this.name.getText().toString();
    Object localObject2 = this.pswd.getText().toString();
    this.mReqSize = (((String)localObject1).length() + ((String)localObject2).length());
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    getWindow().addFlags(1024);
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
    setContentView(2131562852);
    this.leftView = ((TextView)findViewById(2131364182));
    if (getIntent().getBooleanExtra("is_first_login", false))
    {
      setTitle(2131694632);
      this.leftView.setText(2131690706);
    }
    else
    {
      setTitle(2131694649);
    }
    this.leftView.setOnClickListener(this.onClick);
    this.mDelBtn = findViewById(2131365510);
    this.mDelPassBtn = findViewById(2131365482);
    this.txtPhoneNumLogin = ((TextView)findViewById(2131380000));
    this.unLoginTv = ((TextView)findViewById(2131380156));
    this.unLoginTv.setOnClickListener(this.onClick);
    this.mDelBtn.setOnClickListener(this.onClick);
    this.mDelPassBtn.setOnClickListener(this.onClick);
    this.txtPhoneNumLogin.setOnClickListener(this.onClick);
    this.name = ((EditText)findViewById(2131361863));
    this.pswd = ((EditText)findViewById(2131372343));
    this.login = ((Button)findViewById(2131372129));
    this.login.setOnClickListener(this.onClick);
    this.mProgress = new QQProgressDialog(this, getTitleBarHeight());
    this.name.requestFocus();
    this.name.setOnFocusChangeListener(this.focusListener);
    this.name.setOnTouchListener(this.onTouchListener);
    this.pswd.setOnTouchListener(this.onTouchListener);
    this.pswd.setOnFocusChangeListener(this.focusListener);
    this.pswd.setOnEditorActionListener(new Login.2(this));
    this.name.addTextChangedListener(this.onTextChangeForUpdating);
    this.pswd.addTextChangedListener(this.onEnterPswd);
    init();
    this.app.setHandler(LoginProgressClazz.class, this.loginHandler);
    if (this.mAutoLoginReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
      registerReceiver(this.mAutoLoginReceiver, paramBundle);
    }
    if (!TextUtils.isEmpty(this.mQrCodeUrl))
    {
      this.mQrCodeBtn = ((TextView)findViewById(2131374695));
      this.mQrCodeBtn.setOnClickListener(this.onClick);
      this.mQrCodeBtn.setVisibility(0);
      this.mQrCodeReceiver = new Login.3(this);
      reportQrcodeLogin(0, "0X800BA17");
      registerReceiver(this.mQrCodeReceiver, new IntentFilter("mqq.intent.action.QRCODE_LOGIN_FINISH"));
    }
    reportQrcodeLogin(0, "0X800BA16");
  }
  
  protected void onDestroy()
  {
    SSOLog.a("Login", new Object[] { "onDestroy" });
    super.onDestroy();
    hideLoginTip();
    this.name.removeTextChangedListener(this.onTextChangeForUpdating);
    this.pswd.removeTextChangedListener(this.onEnterPswd);
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
  
  protected void onResume()
  {
    super.onResume();
    SSOLog.a("Login", new Object[] { "onResume" });
    Object localObject = this.mQrCodeBtn;
    if (localObject != null) {
      ((TextView)localObject).setClickable(true);
    }
    if (gLoginNow)
    {
      gLoginNow = false;
      this.name.setText(gAccount);
      this.pswd.setText(gPasswd);
    }
    if (this.mShouldAutoLogin)
    {
      SSOLog.a("Login", new Object[] { "mShouldAutoLogin: true, then login" });
      this.mShouldAutoLogin = false;
      localObject = this.login;
      if (localObject != null) {
        ((Button)localObject).performClick();
      }
    }
  }
  
  protected void showActionSheet()
  {
    if (this.mActionSheet == null)
    {
      this.mActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.mActionSheet.addButton(2131692483);
      this.mActionSheet.addButton(2131719166);
      this.mActionSheet.addCancelButton(2131690728);
      this.mActionSheet.setOnDismissListener(new Login.16(this));
      this.mActionSheet.setOnButtonClickListener(new Login.17(this));
    }
    if (!this.mActionSheet.isShowing())
    {
      InputMethodUtil.a(this);
      this.actionSheetHasClick = false;
      this.mActionSheet.show();
    }
  }
  
  void showDialog(String paramString)
  {
    if (!isFinishing()) {
      DialogUtil.b(this, 230).setMessageWithUrl(paramString).setTitle(getString(2131718407)).setPositiveButton(17039370, new Login.13(this)).show();
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
      paramBundle = DialogUtil.a(this, 230, str3, localISafeBlockApi.handleNotifyMsg(localStringBuilder.toString(), this, k), 2131690728, j, new Login.14(this, localISafeBlockApi, i, str2, paramBundle, str1), new Login.15(this, localISafeBlockApi, i, str2));
      paramBundle.setCancelable(true);
      paramBundle.show();
      return;
    }
    SSOLog.b("Login", new Object[] { "showFrozenDlg error: params wrong" });
  }
  
  protected void showLoginTip()
  {
    SSOLog.a("Login", new Object[] { "showLoginTip" });
    this.mProgress.a(getResources().getString(2131694646));
    if (!this.mProgress.isShowing()) {
      this.mProgress.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login
 * JD-Core Version:    0.7.0.1
 */