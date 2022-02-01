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
import apzq;
import bfur;
import bhht;
import bhow;
import bhwf;
import biyq;
import biyr;
import biys;
import biyt;
import biyu;
import biyv;
import biyw;
import biyx;
import biyy;
import biyz;
import biza;
import bizb;
import bizc;
import bizd;
import bjmm;
import bjnw;
import bjon;
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
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new biza(this);
  protected View.OnClickListener a;
  View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new biyy(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new biyz(this);
  public View a;
  public Button a;
  public EditText a;
  public TextView a;
  protected bhht a;
  private bjnw jdField_a_of_type_Bjnw;
  public OpenSDKAppInterface a;
  public HandlerPlus a;
  protected List<WloginLoginInfo> a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  public MqqHandler a;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new biyw(this);
  TextWatcher jdField_b_of_type_AndroidTextTextWatcher = new bizb(this);
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
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new biyq(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bizc(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bizd(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new biyr(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new biys(this);
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
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_MqqManagerWtloginManager.getAllLoginInfo();
  }
  
  public void a(String paramString)
  {
    if (!isFinishing()) {
      bfur.b(this, 230).setMessageWithUrl(paramString).setTitle(getString(2131717803)).setPositiveButton(17039370, new biyt(this)).show();
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.Login", 2, "-->loginSucess--mReqSrc = " + this.jdField_a_of_type_Int + ", userAccount = *" + bhwf.a(paramString1));
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
      bhow.a().a(paramString1);
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
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131695971), new Object[] { getResources().getString(2131694168), Integer.valueOf(3103) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3103");
      StatisticCollector.getInstance(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    if ("".equals(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131695971), new Object[] { getResources().getString(2131694305), Integer.valueOf(3104) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3104");
      StatisticCollector.getInstance(this).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_b_of_type_Long = (((String)localObject).length() + str.length());
    if (QLog.isColorLevel()) {
      QLog.d("Login", 2, "-->doLogin--account = *" + bhwf.a((String)localObject) + "mReqSrc = " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      boolean bool;
      if (this.jdField_a_of_type_Int == 2) {
        bool = bhwf.b(this.jdField_a_of_type_MqqManagerWtloginManager, (String)localObject);
      }
      while (bool) {
        if (this.jdField_b_of_type_Boolean)
        {
          QLog.d("Q.quicklogin.Login", 1, "has aone");
          a((String)localObject, null, null);
          return;
          if (!bhwf.a(this.jdField_a_of_type_MqqManagerWtloginManager, (String)localObject)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else
        {
          QLog.d("Login", 1, new Object[] { "send | cmd: s_s_o_l | uin : *", bhwf.a((String)localObject) });
          localBundle = new Bundle();
          if (apzq.a()) {
            localBundle.putInt("puzzle_verify_code", 130);
          }
          localBundle.putByteArray("connect_data", bhwf.a(this.jdField_c_of_type_JavaLangString));
          this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
          c();
          return;
        }
      }
      QLog.d("Login", 1, new Object[] { "send | cmd: s_s_o_l | uin : *", bhwf.a((String)localObject) });
      localBundle = new Bundle();
      if (apzq.a()) {
        localBundle.putInt("puzzle_verify_code", 130);
      }
      localBundle.putByteArray("connect_data", bhwf.a(this.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
      c();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("connect_data", bhwf.a(this.jdField_c_of_type_JavaLangString));
    if (apzq.a()) {
      localBundle.putInt("puzzle_verify_code", 130);
    }
    if (bhwf.a(this.jdField_a_of_type_MqqManagerWtloginManager, (String)localObject))
    {
      QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + bhwf.a((String)localObject));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
    }
    for (;;)
    {
      c();
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        QLog.d("Login", 1, "send | cmd: g_t_n_p | uin : *" + bhwf.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd((String)localObject, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
        localBundle.putLong("dwSrcAppid", 1600001540L);
      }
      else
      {
        QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + bhwf.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
      }
    }
  }
  
  public void c()
  {
    QLog.d("Login", 1, "showLoginTip");
    this.jdField_a_of_type_Bhht.a(getResources().getString(2131694262));
    if (!this.jdField_a_of_type_Bhht.isShowing()) {
      this.jdField_a_of_type_Bhht.show();
    }
  }
  
  public void d()
  {
    QLog.d("Login", 1, "hideLoginTip");
    if (this.jdField_a_of_type_Bhht == null) {}
    while (!this.jdField_a_of_type_Bhht.isShowing()) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bhht.dismiss();
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
    if (this.jdField_a_of_type_Bjnw == null)
    {
      this.jdField_a_of_type_Bjnw = ((bjnw)bjon.a(this, null));
      this.jdField_a_of_type_Bjnw.b(2131692306);
      this.jdField_a_of_type_Bjnw.b(2131718535);
      this.jdField_a_of_type_Bjnw.c(2131690620);
      this.jdField_a_of_type_Bjnw.setOnDismissListener(new biyu(this));
      this.jdField_a_of_type_Bjnw.a(new biyv(this));
    }
    if (!this.jdField_a_of_type_Bjnw.isShowing())
    {
      bjmm.a(this);
      this.f = false;
      this.jdField_a_of_type_Bjnw.show();
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
    setContentView(2131562811);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364086));
    if (getIntent().getBooleanExtra("is_first_login", false))
    {
      setTitle(2131694248);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690599);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365413);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131365384);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379950));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380114));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131361856));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372264));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372050));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Bhht = new bhht(this, getTitleBarHeight());
      findViewById(2131366953).requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(new biyx(this));
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
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("mqq.opensdk.intent.action.PUZZLEVERIFYCODE"));
      return;
      setTitle(2131694265);
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
    unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
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