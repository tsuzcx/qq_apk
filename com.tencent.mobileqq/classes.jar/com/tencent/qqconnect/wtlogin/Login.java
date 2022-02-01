package com.tencent.qqconnect.wtlogin;

import Override;
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
import aozj;
import arct;
import bdla;
import bhdj;
import bisl;
import bizp;
import bjhh;
import bkjs;
import bkjt;
import bkju;
import bkjv;
import bkjw;
import bkjx;
import bkjy;
import bkjz;
import bkka;
import bkkb;
import bkkc;
import bkkd;
import bkke;
import bkkf;
import bkkg;
import bkkh;
import bkxz;
import bkzi;
import bkzz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.util.HandlerPlus;
import java.util.HashMap;
import java.util.List;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class Login
  extends BaseActivity
{
  public static String a;
  public static boolean a;
  public static String b;
  public int a;
  public long a;
  public BroadcastReceiver a;
  protected Handler.Callback a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new bkkd(this);
  protected View.OnClickListener a;
  View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new bkkb(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bkkc(this);
  public View a;
  public Button a;
  public EditText a;
  public TextView a;
  protected bisl a;
  private bkzi jdField_a_of_type_Bkzi;
  public OpenSDKAppInterface a;
  public HandlerPlus a;
  protected List<WloginLoginInfo> a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  public MqqHandler a;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  TextWatcher jdField_b_of_type_AndroidTextTextWatcher = new bkke(this);
  public View b;
  public EditText b;
  public TextView b;
  public boolean b;
  public TextView c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
  }
  
  public Login()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bkjs(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bkkf(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bkkg(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new bkjt(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bkju(this);
  }
  
  private Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (arct.a()) {
      localBundle.putInt("puzzle_verify_code", 130);
    }
    localBundle.putByteArray("connect_data", bjhh.a(this.jdField_c_of_type_JavaLangString));
    return localBundle;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("uin:'").append(paramString1).append("',");
    localStringBuilder.append("skey:'");
    if (paramString2 != null) {
      localStringBuilder.append(paramString2);
    }
    localStringBuilder.append("'}");
    return localStringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Login", 1, new Object[] { "ssoLogin | cmd: s_s_o_l | uin : *", bjhh.a(paramString1) });
    f();
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new bkkh(this);
    registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("mqq.opensdk.intent.action.PUZZLEVERIFYCODE"));
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin(paramString1, paramString2, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, a());
    c();
  }
  
  private void f()
  {
    QLog.d("Login", 1, new Object[] { "unregisterPuzzleVerifyCodeReceiver mPuzzleVerifyCodeReceiver=", this.jdField_b_of_type_AndroidContentBroadcastReceiver });
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Login", 1, "unregisterPuzzleVerifyCodeReceiver", localException);
      }
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_MqqManagerWtloginManager.getAllLoginInfo();
  }
  
  public void a(Bundle paramBundle)
  {
    if ((isFinishing()) || (paramBundle == null))
    {
      QLog.e("Login", 1, "showFrozenDlg error: params wrong");
      return;
    }
    bdla.a(null, "dc00898", "", "", "0X800B431", "0X800B431", 0, 0, "", "", "", "");
    String str1 = paramBundle.getString("loginalias");
    int j = aozj.a().a(paramBundle.getByteArray("tlverror"));
    String str2 = paramBundle.getString("msg");
    String str3 = paramBundle.getString("errortitle");
    String str4 = paramBundle.getString("errorUrl");
    paramBundle = "";
    int i = 2131694399;
    if (j == 2)
    {
      i = 2131719825;
      paramBundle = "你也可以对帐号进行<TITLE=\"资金管理\",URL=\"https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027\">。";
    }
    paramBundle = bhdj.a(this, 230, str3, aozj.a().a(str2 + paramBundle, this, 3), 2131690697, i, new bkjw(this, str4, str1), new bkjx(this));
    paramBundle.setCancelable(true);
    paramBundle.show();
  }
  
  public void a(String paramString)
  {
    if (!isFinishing()) {
      bhdj.b(this, 230).setMessageWithUrl(paramString).setTitle(getString(2131718185)).setPositiveButton(17039370, new bkjv(this)).show();
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.Login", 2, "-->loginSucess--mReqSrc = " + this.jdField_a_of_type_Int + ", userAccount = *" + bjhh.a(paramString1));
    }
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
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
      paramString2.putExtra("fromLoginPhoneNum", this.e);
      setResult(-1, paramString2);
      bizp.a().a(paramString1);
      finish();
      return;
    }
    Object localObject3 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString1, (WloginSimpleInfo)localObject3);
    Object localObject1 = "" + ((WloginSimpleInfo)localObject3)._uin;
    Object localObject2 = new Intent();
    localObject3 = new String(((WloginSimpleInfo)localObject3)._nick);
    if (paramString2 != null) {}
    for (paramString1 = new String(paramString2);; paramString1 = null)
    {
      ((Intent)localObject2).putExtra("result_data", a((String)localObject1, paramString1));
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
      ((Intent)localObject2).putExtra("fromLoginPhoneNum", this.e);
      setResult(-1, (Intent)localObject2);
      paramString1 = (String)localObject1;
      break;
    }
  }
  
  public void b()
  {
    boolean bool = false;
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131696223), new Object[] { getResources().getString(2131694366), Integer.valueOf(3103) }));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("error", "3103");
      StatisticCollector.getInstance(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject1, "");
      return;
    }
    if ("".equals(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131696223), new Object[] { getResources().getString(2131694506), Integer.valueOf(3104) }));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("error", "3104");
      StatisticCollector.getInstance(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject1, "");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Object localObject2 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_b_of_type_Long = (((String)localObject1).length() + ((String)localObject2).length());
    if (QLog.isColorLevel()) {
      QLog.d("Login", 2, "-->doLogin--account = *" + bjhh.a((String)localObject1) + "mReqSrc = " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      if (this.jdField_a_of_type_Int == 2) {
        bool = bjhh.b(this.jdField_a_of_type_MqqManagerWtloginManager, (String)localObject1);
      }
      while (bool) {
        if (this.jdField_b_of_type_Boolean)
        {
          QLog.d("Q.quicklogin.Login", 1, "has aone");
          a((String)localObject1, null, null);
          return;
          if (!bjhh.a(this.jdField_a_of_type_MqqManagerWtloginManager, (String)localObject1)) {
            bool = true;
          }
        }
        else
        {
          a((String)localObject1, (String)localObject2);
          return;
        }
      }
      a((String)localObject1, (String)localObject2);
      return;
    }
    if (bjhh.a(this.jdField_a_of_type_MqqManagerWtloginManager, (String)localObject1))
    {
      a((String)localObject1, (String)localObject2);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.d("Login", 1, "send | cmd: g_t_n_p | uin : *" + bjhh.a((String)localObject1));
      localObject2 = a();
      ((Bundle)localObject2).putLong("dwSrcAppid", 1600001540L);
      ((Bundle)localObject2).putLong("dwDstAppid", 1600001540L);
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd((String)localObject1, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, (Bundle)localObject2);
      ((Bundle)localObject2).putLong("dwSrcAppid", 1600001540L);
      c();
      return;
    }
    a((String)localObject1, (String)localObject2);
  }
  
  public void c()
  {
    QLog.d("Login", 1, "showLoginTip");
    this.jdField_a_of_type_Bisl.a(getResources().getString(2131694460));
    if (!this.jdField_a_of_type_Bisl.isShowing()) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  public void d()
  {
    QLog.d("Login", 1, "hideLoginTip");
    if (this.jdField_a_of_type_Bisl == null) {}
    while (!this.jdField_a_of_type_Bisl.isShowing()) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
  
  public void e()
  {
    if (this.jdField_a_of_type_Bkzi == null)
    {
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
      this.jdField_a_of_type_Bkzi.b(2131692399);
      this.jdField_a_of_type_Bkzi.b(2131718921);
      this.jdField_a_of_type_Bkzi.c(2131690697);
      this.jdField_a_of_type_Bkzi.setOnDismissListener(new bkjy(this));
      this.jdField_a_of_type_Bkzi.a(new bkjz(this));
    }
    if (!this.jdField_a_of_type_Bkzi.isShowing())
    {
      bkxz.a(this);
      this.f = false;
      this.jdField_a_of_type_Bkzi.show();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Login", 2, "-->onActivityResult--reqCode = " + paramInt1 + ", resCode = " + paramInt2);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100) {
      if (paramInt2 == -1) {
        if (paramIntent != null) {}
      }
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = new Message();
          paramIntent = paramIntent.getExtras();
          ((Message)localObject).what = 6;
          ((Message)localObject).setData(paramIntent);
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
          return;
        } while (paramInt2 != 0);
        d();
        return;
      } while (paramInt1 != 10000);
      if (paramInt2 == -1)
      {
        localObject = paramIntent.getStringExtra("last_account");
        String str = paramIntent.getStringExtra("wtTicket");
        Bundle localBundle = paramIntent.getBundleExtra("ssobundle");
        this.e = paramIntent.getBooleanExtra("fromLoginPhoneNum", false);
        a((String)localObject, str, localBundle);
        return;
      }
    } while (paramInt2 != 0);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.d("Login", 1, "onCreate");
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    getWindow().addFlags(1024);
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (getIntent().getExtras() != null) {
      this.jdField_a_of_type_Int = getIntent().getExtras().getInt("key_req_src", 1);
    }
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("appid");
    QLog.d("Q.quicklogin.Login", 1, "oncreate mReqSrc:" + this.jdField_a_of_type_Int + ", mAppId=" + this.jdField_c_of_type_JavaLangString);
    setContentView(2131562882);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364161));
    if (getIntent().getBooleanExtra("is_first_login", false))
    {
      setTitle(2131694446);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690676);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365506);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131365477);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380289));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380449));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131361858));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372456));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372242));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
      findViewById(2131367071).requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bkka(this));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      a();
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.setHandler(Login.class, this.jdField_a_of_type_MqqOsMqqHandler);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      }
      return;
      setTitle(2131694463);
    }
  }
  
  public void onDestroy()
  {
    QLog.d("Login", 1, "onDestroy");
    super.onDestroy();
    d();
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.removeHandler(Login.class);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    f();
  }
  
  public void onResume()
  {
    super.onResume();
    if (jdField_a_of_type_Boolean == true)
    {
      jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(jdField_b_of_type_JavaLangString);
    }
    if (this.d)
    {
      QLog.d("Login", 1, "mShouldAutoLogin: true, then login");
      this.d = false;
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.performClick();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login
 * JD-Core Version:    0.7.0.1
 */