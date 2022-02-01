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
import bctj;
import bglp;
import bgpa;
import biau;
import biij;
import bipr;
import bjsl;
import bjsm;
import bjsn;
import bjso;
import bjsp;
import bjsq;
import bjsr;
import bjss;
import bjst;
import bjsu;
import bjsv;
import bjsw;
import bjsx;
import bkho;
import bkif;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
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
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new bjst(this);
  protected View.OnClickListener a;
  View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new bjsr(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bjss(this);
  public View a;
  public Button a;
  public EditText a;
  public TextView a;
  protected biau a;
  private bkho jdField_a_of_type_Bkho;
  public OpenSDKAppInterface a;
  public HandlerPlus a;
  protected List<WloginLoginInfo> a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  public MqqHandler a;
  public long b;
  TextWatcher b;
  public View b;
  public EditText b;
  public TextView b;
  public boolean b;
  public TextView c;
  private String c;
  protected boolean c;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
  }
  
  public Login()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bjsl(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new bjsu(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bjsv(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bjsw(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new bjsx(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bjsm(this);
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
  
  private void a(boolean paramBoolean)
  {
    QLog.d("Login", 1, new Object[] { "updateLoginStatus, mReqSrc=", Integer.valueOf(this.jdField_a_of_type_Int), ", isLoginning=", Boolean.valueOf(paramBoolean), ", process=", BaseApplicationImpl.getApplication().getQQProcessName() });
    if (!"com.tencent.mobileqq:openSdk".equals(BaseApplicationImpl.getApplication().getQQProcessName())) {
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_MqqManagerWtloginManager.GetAllLoginInfo();
  }
  
  public void a(String paramString)
  {
    if (!isFinishing()) {
      bglp.b(this, 230).setMessageWithUrl(paramString).setTitle(getString(2131717436)).setPositiveButton(17039370, new bjsn(this)).show();
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.Login", 2, "-->loginSucess--mReqSrc = " + this.jdField_a_of_type_Int + ", userAccount = *" + bipr.a(paramString1));
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
      paramString2.putExtra("fromLoginPhoneNum", this.f);
      setResult(-1, paramString2);
      biij.a().a(paramString1);
      finish();
      return;
    }
    Object localObject3 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString1, (WloginSimpleInfo)localObject3);
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
      ((Intent)localObject2).putExtra("fromLoginPhoneNum", this.f);
      setResult(-1, (Intent)localObject2);
      paramString1 = (String)localObject1;
      break;
    }
  }
  
  public void b()
  {
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131695788), new Object[] { getResources().getString(2131694049), Integer.valueOf(3103) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3103");
      bctj.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    if ("".equals(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131695788), new Object[] { getResources().getString(2131694173), Integer.valueOf(3104) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3104");
      bctj.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_b_of_type_Long = (((String)localObject).length() + str.length());
    if (QLog.isColorLevel()) {
      QLog.d("Login", 2, "-->doLogin--account = *" + bipr.a((String)localObject) + "mReqSrc = " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      boolean bool;
      if (this.jdField_a_of_type_Int == 2) {
        bool = bipr.b(this.jdField_a_of_type_MqqManagerWtloginManager, (String)localObject);
      }
      while (bool) {
        if (this.jdField_b_of_type_Boolean)
        {
          QLog.d("Q.quicklogin.Login", 1, "has aone");
          a((String)localObject, null, null);
          return;
          if (!bipr.a(this.jdField_a_of_type_MqqManagerWtloginManager, (String)localObject)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else
        {
          QLog.d("Login", 1, new Object[] { "send | cmd: s_s_o_l | uin : *", bipr.a((String)localObject) });
          a(true);
          localBundle = new Bundle();
          localBundle.putByteArray("connect_data", bipr.a(this.jdField_c_of_type_JavaLangString));
          this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
          c();
          return;
        }
      }
      QLog.d("Login", 1, new Object[] { "send | cmd: s_s_o_l | uin : *", bipr.a((String)localObject) });
      a(true);
      localBundle = new Bundle();
      localBundle.putByteArray("connect_data", bipr.a(this.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
      c();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("connect_data", bipr.a(this.jdField_c_of_type_JavaLangString));
    if (bipr.a(this.jdField_a_of_type_MqqManagerWtloginManager, (String)localObject))
    {
      a(true);
      QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + bipr.a((String)localObject));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
    }
    for (;;)
    {
      c();
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        QLog.d("Login", 1, "send | cmd: g_t_n_p | uin : *" + bipr.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd((String)localObject, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
        localBundle.putLong("dwSrcAppid", 1600001540L);
      }
      else
      {
        a(true);
        QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + bipr.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver, localBundle);
      }
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Biau.a(getResources().getString(2131694141));
    if (!this.jdField_a_of_type_Biau.isShowing()) {
      this.jdField_a_of_type_Biau.show();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Biau == null) {}
    while (!this.jdField_a_of_type_Biau.isShowing()) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Biau.dismiss();
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bkho == null)
    {
      this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this, null));
      this.jdField_a_of_type_Bkho.b(2131692253);
      this.jdField_a_of_type_Bkho.b(2131718160);
      this.jdField_a_of_type_Bkho.c(2131690582);
      this.jdField_a_of_type_Bkho.setOnDismissListener(new bjso(this));
      this.jdField_a_of_type_Bkho.a(new bjsp(this));
    }
    if (!this.jdField_a_of_type_Bkho.isShowing())
    {
      this.g = false;
      this.jdField_a_of_type_Bkho.show();
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
        this.f = paramIntent.getBooleanExtra("fromLoginPhoneNum", false);
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
    setContentView(2131562898);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364039));
    if (getIntent().getBooleanExtra("is_first_login", false))
    {
      setTitle(2131694127);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690563);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365337);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131365310);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380037));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380204));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131361856));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372184));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371971));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
      findViewById(2131366881).requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bjsq(this));
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
      setTitle(2131694144);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d();
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.removeHandler(Login.class);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
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
    if (this.jdField_c_of_type_Boolean)
    {
      d();
      a(false);
    }
    if (this.e)
    {
      QLog.d("Login", 1, "mShouldAutoLogin: true, then login");
      this.e = false;
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