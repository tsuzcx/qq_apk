package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.LoginProxy;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.loginregister.LoginSuccDialogMessage;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager.AccountInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.AccountObserver;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqMaskQQLogin;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspBodySelfPhone;
import tencent.im.login.GatewayVerify.RspBodySelfPhoneLogin;
import tencent.im.login.GatewayVerify.RspCmd9;
import tencent.im.login.GatewayVerify.RspPhoneSmsExtendLogin;

public class LoginAccountFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  protected QBaseActivity a;
  AppRuntime b;
  PhoneNumQuickLoginManager.AccountInfo c;
  EditText d;
  int e;
  InputMethodManager f;
  protected final AccountObserver g = new LoginAccountFragment.3(this);
  private boolean h;
  private byte[] i;
  private QQProgressDialog j;
  private LoginProxy k;
  
  public static Bundle a(int paramInt, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_account_manager", paramBoolean);
    localBundle.putInt("key_from", paramInt);
    return localBundle;
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, PhoneNumQuickLoginManager.AccountInfo paramAccountInfo, Bundle paramBundle, byte[] paramArrayOfByte, int paramInt)
  {
    QLog.d("LoginAccountFragment", 1, new Object[] { "-->startFragment curActivity=", paramActivity, ", title=", paramString1, ", noBtnText=", paramString2 });
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramString1);
      localIntent.putExtra("no_btn_text", paramString2);
      localIntent.putExtra("account_info", paramAccountInfo);
      localIntent.putExtra("from_account_manager", paramBundle.getBoolean("from_account_manager", false));
      localIntent.putExtra("key_from", paramBundle.getInt("key_from", 1));
      localIntent.putExtra("login_tvl_value", paramArrayOfByte);
      QPublicFragmentActivity.startForResult(paramActivity, localIntent, LoginAccountFragment.class, paramInt);
    }
  }
  
  private void a(String paramString)
  {
    int m = this.e;
    if (m == 1)
    {
      PhoneNumQuickLoginManager.b("0X800B8D9");
      return;
    }
    if (m == 2) {
      ReportController.a(this.b, "dc00898", "", "", "0X800B93D", "0X800B93D", 0, 0, "", "", paramString, "");
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        localObject = new GatewayVerify.RspBody();
        ((GatewayVerify.RspBody)localObject).mergeFrom(paramArrayOfByte);
        m = this.e;
        paramArrayOfByte = "";
        if (m == 1)
        {
          localObject = ((GatewayVerify.RspBody)localObject).msg_rsp_self_phone.msg_rsp_phone_login;
          m = ((GatewayVerify.RspBodySelfPhoneLogin)localObject).int32_phone_bind_result.get();
          paramArrayOfByte = ((GatewayVerify.RspBodySelfPhoneLogin)localObject).str_phone_bind_msg_content.get();
          localObject = ((GatewayVerify.RspBodySelfPhoneLogin)localObject).str_phone_bind_msg_title.get();
        }
        else
        {
          if (this.e != 2) {
            break label194;
          }
          localObject = ((GatewayVerify.RspBody)localObject).msg_rsp_cmd_9.msg_rsp_phone_sms_extend_login;
          m = ((GatewayVerify.RspPhoneSmsExtendLogin)localObject).int32_phone_bind_result.get();
          paramArrayOfByte = ((GatewayVerify.RspPhoneSmsExtendLogin)localObject).str_phone_bind_msg_content.get();
          localObject = ((GatewayVerify.RspPhoneSmsExtendLogin)localObject).str_phone_bind_msg_title.get();
        }
        if ((!TextUtils.isEmpty(paramArrayOfByte)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          if (m != 0)
          {
            QLog.d("LoginAccountFragment", 1, new Object[] { "storeOpenLoginPhoneInfo, result error , result : ", Integer.valueOf(m) });
            return;
          }
          LoginStaticField.a(new LoginSuccDialogMessage(m, paramArrayOfByte, (String)localObject));
          return;
        }
        QLog.d("LoginAccountFragment", 1, new Object[] { "storeOpenLoginPhoneInfo, content or title is null, content : ", paramArrayOfByte });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.d("LoginAccountFragment", 1, "storeOpenLoginPhoneInfo error : ", paramArrayOfByte);
        return;
      }
      label194:
      Object localObject = "";
      int m = 0;
    }
  }
  
  private void b(String paramString)
  {
    if (this.e == 2) {
      ReportController.a(this.b, "dc00898", "", "", "0X800B93C", "0X800B93C", 0, 0, "", "", paramString, "");
    }
  }
  
  private boolean f()
  {
    QBaseActivity localQBaseActivity = this.a;
    boolean bool;
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing())) {
      bool = false;
    } else {
      bool = true;
    }
    if (bool) {
      QLog.d("LoginAccountFragment", 1, "activity invalid");
    }
    return bool;
  }
  
  private void g()
  {
    int m = this.e;
    if (m == 1)
    {
      PhoneNumQuickLoginManager.b("0X800B8D4");
      return;
    }
    if (m == 2) {
      PhoneNumQuickLoginManager.b("0X800B93A");
    }
  }
  
  private void h()
  {
    int m = this.e;
    if (m == 1)
    {
      PhoneNumQuickLoginManager.b("0X800B8D5");
      return;
    }
    if (m == 2) {
      PhoneNumQuickLoginManager.b("0X800B93B");
    }
  }
  
  public void a()
  {
    if (this.f != null)
    {
      EditText localEditText = this.d;
      if (localEditText == null) {
        return;
      }
      localEditText.requestFocus();
      this.f.showSoftInput(this.d, 2);
    }
  }
  
  public void b()
  {
    InputMethodManager localInputMethodManager = this.f;
    if (localInputMethodManager != null)
    {
      QBaseActivity localQBaseActivity = this.a;
      if (localQBaseActivity == null) {
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(localQBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
  }
  
  protected void c()
  {
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      QLog.e("LoginAccountFragment", 1, "loginByUinToken, app is null");
      return;
    }
    if ((WtloginManager)((AppRuntime)localObject1).getManager(1) == null)
    {
      QLog.e("LoginAccountFragment", 1, "loginByUinToken, manager is null");
      return;
    }
    localObject1 = this.d.getText().toString();
    if (((String)localObject1).isEmpty())
    {
      QQToast.makeText(getQBaseActivity(), 2131892395, 0).show();
      return;
    }
    e();
    Object localObject2 = new GatewayVerify.ReqBody();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFrom(this.c.getUinToken());
    ((GatewayVerify.ReqBody)localObject2).msg_req_mask_qq_login.bytes_encrypt_uin_info.set(localByteStringMicro);
    ((GatewayVerify.ReqBody)localObject2).msg_req_mask_qq_login.setHasFlag(true);
    ((GatewayVerify.ReqBody)localObject2).setHasFlag(true);
    localObject2 = ((GatewayVerify.ReqBody)localObject2).toByteArray();
    libsafeedit.getLoginLegal((String)localObject1);
    localObject1 = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    int m = this.e;
    if (m == 1) {
      m = 2;
    } else if (m == 2) {
      m = 3;
    } else {
      m = 0;
    }
    this.b.login((byte[])localObject2, this.i, m, this.c.getMaskUin(), (byte[])localObject1, null);
  }
  
  protected void d()
  {
    QQProgressDialog localQQProgressDialog = this.j;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.j.dismiss();
    }
  }
  
  protected void e()
  {
    QQProgressDialog localQQProgressDialog = this.j;
    if (localQQProgressDialog == null)
    {
      QLog.e("LoginAccountFragment", 1, "showLoadingDialog, dialog is null");
      return;
    }
    if (localQQProgressDialog.isShowing())
    {
      QLog.e("LoginAccountFragment", 1, "showLoadingDialog, dialog is showing");
      return;
    }
    this.j.show();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437716) {
      if (!NetworkUtil.isNetworkAvailable())
      {
        QQToast.makeText(this.a, 2131892102, 0).show();
      }
      else
      {
        b();
        h();
        c();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131625266, paramViewGroup, false);
    this.a = getQBaseActivity();
    this.k = new LoginProxy();
    paramLayoutInflater = this.a;
    if (paramLayoutInflater == null) {
      paramLayoutInflater = null;
    } else {
      paramLayoutInflater = paramLayoutInflater.getAppRuntime();
    }
    this.b = paramLayoutInflater;
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null)
    {
      QLog.d("LoginAccountFragment", 1, "onCreateView app interface is null");
      if (!f()) {
        this.a.finish();
      }
    }
    else
    {
      paramLayoutInflater.registObserver(this.g);
      paramLayoutInflater = this.a;
      this.j = new QQProgressDialog(paramLayoutInflater, paramLayoutInflater.getTitleBarHeight());
      this.j.a(HardCodeUtil.a(2131897873));
      paramViewGroup.findViewById(2131444897).setBackgroundResource(2130852233);
      paramLayoutInflater = paramViewGroup.findViewById(2131437721);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramLayoutInflater.setFitsSystemWindows(true);
        paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramViewGroup.getContext()), 0, 0);
      }
      paramBundle = this.a.getIntent();
      this.h = paramBundle.getBooleanExtra("from_account_manager", false);
      this.e = paramBundle.getIntExtra("key_from", 1);
      this.i = paramBundle.getByteArrayExtra("login_tvl_value");
      ((TextView)paramLayoutInflater.findViewById(2131436227)).setText(paramBundle.getStringExtra("title"));
      Object localObject = (TextView)paramLayoutInflater.findViewById(2131436211);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramBundle.getStringExtra("no_btn_text"));
      ((TextView)localObject).setOnClickListener(new LoginAccountFragment.1(this));
      paramLayoutInflater.findViewById(2131436180).setVisibility(8);
      this.d = ((EditText)paramViewGroup.findViewById(2131439858));
      paramViewGroup.findViewById(2131437716).setOnClickListener(this);
      this.c = ((PhoneNumQuickLoginManager.AccountInfo)paramBundle.getSerializableExtra("account_info"));
      if (this.c == null)
      {
        QLog.e("LoginAccountFragment", 1, "onCreateView, info is null");
        QQToast.makeText(this.a, getString(2131897199), 0).show();
        this.a.finish();
      }
      else
      {
        paramBundle = (DropdownView)paramViewGroup.findViewById(2131432255);
        paramLayoutInflater = paramBundle.getView();
        paramLayoutInflater.setFocusableInTouchMode(false);
        paramLayoutInflater.setFocusable(false);
        paramLayoutInflater.setText(this.c.getMaskUin());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getString(2131886137));
        ((StringBuilder)localObject).append(this.c.getMaskUin());
        paramBundle.setContentDescription(((StringBuilder)localObject).toString());
        paramBundle = new StringBuilder();
        paramBundle.append(getString(2131886137));
        paramBundle.append(this.c.getMaskUin());
        paramLayoutInflater.setContentDescription(paramBundle.toString());
        this.f = ((InputMethodManager)this.a.getSystemService("input_method"));
        paramViewGroup.postDelayed(new LoginAccountFragment.2(this), 100L);
        g();
      }
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.unRegistObserver(this.g);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LoginAccountFragment
 * JD-Core Version:    0.7.0.1
 */