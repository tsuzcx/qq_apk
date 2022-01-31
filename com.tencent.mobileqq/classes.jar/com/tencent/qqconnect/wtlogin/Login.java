package com.tencent.qqconnect.wtlogin;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import azri;
import bdgm;
import bdjz;
import bety;
import bfbj;
import bfii;
import bgkz;
import bgla;
import bglb;
import bglc;
import bgld;
import bgle;
import bglf;
import bglg;
import bglh;
import bgli;
import bglj;
import bglk;
import bgll;
import bhuf;
import bhus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
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
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new bglh(this);
  protected View.OnClickListener a;
  View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new bglf(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bglg(this);
  public View a;
  public Button a;
  public EditText a;
  public TextView a;
  protected bety a;
  private bhuf jdField_a_of_type_Bhuf;
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
  protected boolean c;
  boolean d = false;
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
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bgkz(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new bgli(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bglj(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bglk(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new bgll(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bgla(this);
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
      bdgm.b(this, 230).setMessageWithUrl(paramString).setTitle(getString(2131719379)).setPositiveButton(17039370, new bglb(this)).show();
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.Login", 2, "-->loginSucess--mReqSrc = " + this.jdField_a_of_type_Int + ", userAccount = *" + bfii.a(paramString1));
    }
    bfbj.a().a(paramString1);
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      paramString2 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
      paramString1 = new Intent();
      paramString1.putExtra("last_account", paramString2);
      paramString1.putExtra("isLogin", true);
      if (paramBundle != null)
      {
        paramString2 = paramBundle.getByteArray("st_temp");
        localObject1 = paramBundle.getByteArray("st_temp_key");
        paramString1.putExtra("st_temp", paramString2);
        paramString1.putExtra("st_temp_key", (byte[])localObject1);
      }
      paramString1.putExtra("ssobundle", paramBundle);
      setResult(-1, paramString1);
      finish();
      return;
    }
    Object localObject2 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString1, (WloginSimpleInfo)localObject2);
    String str = "" + ((WloginSimpleInfo)localObject2)._uin;
    Object localObject1 = new Intent();
    localObject2 = new String(((WloginSimpleInfo)localObject2)._nick);
    if (paramString2 != null) {}
    for (paramString1 = new String(paramString2);; paramString1 = null)
    {
      ((Intent)localObject1).putExtra("result_data", a(str, paramString1));
      ((Intent)localObject1).putExtra("last_account", str);
      ((Intent)localObject1).putExtra("isLogin", true);
      ((Intent)localObject1).putExtra("nick", (String)localObject2);
      if (paramBundle != null)
      {
        paramString1 = paramBundle.getByteArray("st_temp");
        paramString2 = paramBundle.getByteArray("st_temp_key");
        ((Intent)localObject1).putExtra("st_temp", paramString1);
        ((Intent)localObject1).putExtra("st_temp_key", paramString2);
      }
      setResult(-1, (Intent)localObject1);
      break;
    }
  }
  
  public void b()
  {
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131696959), new Object[] { getResources().getString(2131694905), Integer.valueOf(3103) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3103");
      azri.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    if ("".equals(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131696959), new Object[] { getResources().getString(2131695125), Integer.valueOf(3104) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3104");
      azri.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_b_of_type_Long = (((String)localObject).length() + str.length());
    if (QLog.isColorLevel()) {
      QLog.d("Login", 2, "-->doLogin--account = *" + bfii.a((String)localObject) + "mReqSrc = " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      boolean bool;
      if (this.jdField_a_of_type_Int == 2) {
        bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1((String)localObject, 16L);
      }
      while (bool) {
        if (this.jdField_b_of_type_Boolean)
        {
          QLog.d("Q.quicklogin.Login", 1, "has aone");
          a((String)localObject, null, null);
          return;
          if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd((String)localObject, 16)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else
        {
          QLog.d("Login", 1, new Object[] { "send | cmd: s_s_o_l | uin : *", bfii.a((String)localObject) });
          a(true);
          this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
          c();
          return;
        }
      }
      QLog.d("Login", 1, new Object[] { "send | cmd: s_s_o_l | uin : *", bfii.a((String)localObject) });
      a(true);
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      c();
      return;
    }
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd((String)localObject, 16))
    {
      a(true);
      QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + bfii.a((String)localObject));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
    }
    for (;;)
    {
      c();
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        QLog.d("Login", 1, "send | cmd: g_t_n_p | uin : *" + bfii.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd((String)localObject, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      }
      else
      {
        a(true);
        QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + bfii.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      }
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Bety.a(getResources().getString(2131695063));
    if (!this.jdField_a_of_type_Bety.isShowing()) {
      this.jdField_a_of_type_Bety.show();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bety == null) {}
    while (!this.jdField_a_of_type_Bety.isShowing()) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bety.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bhuf == null)
    {
      this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(this, null));
      this.jdField_a_of_type_Bhuf.b(2131692676);
      this.jdField_a_of_type_Bhuf.b(2131720233);
      this.jdField_a_of_type_Bhuf.c(2131690648);
      this.jdField_a_of_type_Bhuf.setOnDismissListener(new bglc(this));
      this.jdField_a_of_type_Bhuf.a(new bgld(this));
    }
    if (!this.jdField_a_of_type_Bhuf.isShowing())
    {
      this.f = false;
      this.jdField_a_of_type_Bhuf.show();
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
      do
      {
        do
        {
          return;
          Message localMessage = new Message();
          paramIntent = paramIntent.getExtras();
          localMessage.what = 6;
          localMessage.setData(paramIntent);
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
          return;
        } while (paramInt2 != 0);
        d();
        return;
      } while (paramInt1 != 10000);
      if (paramInt2 == -1)
      {
        a(paramIntent.getStringExtra("last_account"), paramIntent.getStringExtra("wtTicket"), paramIntent.getBundleExtra("ssobundle"));
        return;
      }
    } while (paramInt2 != 0);
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.Login", 2, "oncreate mReqSrc:" + this.jdField_a_of_type_Int);
    }
    setContentView(2131562659);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363833));
    if (getIntent().getBooleanExtra("is_first_login", false))
    {
      setTitle(2131695047);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690623);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365099);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131365073);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379113));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379277));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131361822));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131371611));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371400));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Bety = new bety(this, getTitleBarHeight());
      findViewById(2131366616).requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bgle(this));
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
      setTitle(2131695067);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login
 * JD-Core Version:    0.7.0.1
 */