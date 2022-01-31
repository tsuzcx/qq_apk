package com.tencent.qqconnect.wtlogin;

import algi;
import algj;
import algk;
import algl;
import algm;
import algn;
import algo;
import algp;
import algq;
import algr;
import algs;
import algt;
import android.app.Dialog;
import android.content.Intent;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.util.HandlerPlus;
import java.util.HashMap;
import java.util.List;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class Login
  extends BaseActivity
{
  public static String a;
  public static boolean a;
  public static String b;
  public int a;
  public long a;
  protected Handler.Callback a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new algp(this);
  protected View.OnClickListener a;
  View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new algn(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new algo(this);
  public View a;
  public Button a;
  public EditText a;
  public TextView a;
  protected QQProgressDialog a;
  public OpenSDKAppInterface a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public HandlerPlus a;
  protected List a;
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
  boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
  }
  
  public Login()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new algi(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new algq(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new algr(this);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new algs(this);
    this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new algt(this);
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
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_MqqManagerWtloginManager.GetAllLoginInfo();
  }
  
  public void a(String paramString)
  {
    if (!isFinishing()) {
      DialogUtil.b(this, 230).setMessageWithUrl(paramString).setTitle(getString(2131434119)).setPositiveButton(17039370, new algj(this)).show();
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.Login", 2, "-->loginSucess--mReqSrc = " + this.jdField_a_of_type_Int + ", userAccount = *" + AuthorityUtil.a(paramString1));
    }
    OpenProxy.a().a(paramString1);
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
    boolean bool = false;
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131435592), new Object[] { getResources().getString(2131433203), Integer.valueOf(3103) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3103");
      StatisticCollector.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    if ("".equals(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131435592), new Object[] { getResources().getString(2131433205), Integer.valueOf(3104) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3104");
      StatisticCollector.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_b_of_type_Long = (((String)localObject).length() + str.length());
    if (QLog.isColorLevel()) {
      QLog.d("Login", 2, "-->doLogin--account = *" + AuthorityUtil.a((String)localObject) + "mReqSrc = " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      if (this.jdField_a_of_type_Int == 2) {
        bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1((String)localObject, 16L);
      }
      while (bool) {
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.quicklogin.Login", 2, "has aone");
          }
          a((String)localObject, null, null);
          return;
          if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd((String)localObject, 16)) {
            bool = true;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Login", 2, "send | cmd: s_s_o_l | uin : *" + AuthorityUtil.a((String)localObject));
          }
          this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
          c();
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Login", 2, "send | cmd: s_s_o_l | uin : *" + AuthorityUtil.a((String)localObject));
      }
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      c();
      return;
    }
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd((String)localObject, 16))
    {
      QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + AuthorityUtil.a((String)localObject));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
    }
    for (;;)
    {
      c();
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        QLog.d("Login", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd((String)localObject, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      }
      else
      {
        QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + AuthorityUtil.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      }
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131435588));
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {}
    while (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131433188);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131433189);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131432998);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new algk(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new algl(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.d = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    setContentView(2130971533);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372044));
    if (getIntent().getBooleanExtra("is_first_login", false))
    {
      setTitle(2131435579);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131433681);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131374927);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131374929);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374933));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374931));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131362737));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131364807));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365741));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      findViewById(2131374932).requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(new algm(this));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      a();
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.setHandler(Login.class, this.jdField_a_of_type_MqqOsMqqHandler);
      return;
      setTitle(2131435578);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d();
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.removeHandler(Login.class);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (jdField_a_of_type_Boolean == true)
    {
      jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login
 * JD-Core Version:    0.7.0.1
 */