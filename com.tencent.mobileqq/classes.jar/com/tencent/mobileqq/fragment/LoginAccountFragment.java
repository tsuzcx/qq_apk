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
  private int jdField_a_of_type_Int;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private LoginProxy jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy;
  private PhoneNumQuickLoginManager.AccountInfo jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private final AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new LoginAccountFragment.3(this);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
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
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      PhoneNumQuickLoginManager.b("0X800B8D9");
      return;
    }
    if (i == 2) {
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800B93D", "0X800B93D", 0, 0, "", "", paramString, "");
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
        i = this.jdField_a_of_type_Int;
        paramArrayOfByte = "";
        if (i == 1)
        {
          localObject = ((GatewayVerify.RspBody)localObject).msg_rsp_self_phone.msg_rsp_phone_login;
          i = ((GatewayVerify.RspBodySelfPhoneLogin)localObject).int32_phone_bind_result.get();
          paramArrayOfByte = ((GatewayVerify.RspBodySelfPhoneLogin)localObject).str_phone_bind_msg_content.get();
          localObject = ((GatewayVerify.RspBodySelfPhoneLogin)localObject).str_phone_bind_msg_title.get();
        }
        else
        {
          if (this.jdField_a_of_type_Int != 2) {
            break label194;
          }
          localObject = ((GatewayVerify.RspBody)localObject).msg_rsp_cmd_9.msg_rsp_phone_sms_extend_login;
          i = ((GatewayVerify.RspPhoneSmsExtendLogin)localObject).int32_phone_bind_result.get();
          paramArrayOfByte = ((GatewayVerify.RspPhoneSmsExtendLogin)localObject).str_phone_bind_msg_content.get();
          localObject = ((GatewayVerify.RspPhoneSmsExtendLogin)localObject).str_phone_bind_msg_title.get();
        }
        if ((!TextUtils.isEmpty(paramArrayOfByte)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          if (i != 0)
          {
            QLog.d("LoginAccountFragment", 1, new Object[] { "storeOpenLoginPhoneInfo, result error , result : ", Integer.valueOf(i) });
            return;
          }
          LoginStaticField.a(new LoginSuccDialogMessage(i, paramArrayOfByte, (String)localObject));
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
      int i = 0;
    }
  }
  
  private boolean a()
  {
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
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
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Int == 2) {
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800B93C", "0X800B93C", 0, 0, "", "", paramString, "");
    }
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
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
    localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (((String)localObject1).isEmpty())
    {
      QQToast.a(getQBaseActivity(), 2131694703, 0).a();
      return;
    }
    g();
    Object localObject2 = new GatewayVerify.ReqBody();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getUinToken());
    ((GatewayVerify.ReqBody)localObject2).msg_req_mask_qq_login.bytes_encrypt_uin_info.set(localByteStringMicro);
    ((GatewayVerify.ReqBody)localObject2).msg_req_mask_qq_login.setHasFlag(true);
    ((GatewayVerify.ReqBody)localObject2).setHasFlag(true);
    localObject2 = ((GatewayVerify.ReqBody)localObject2).toByteArray();
    libsafeedit.getLoginLegal((String)localObject1);
    localObject1 = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    int i = this.jdField_a_of_type_Int;
    if (i == 1) {
      i = 2;
    } else if (i == 2) {
      i = 3;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_MqqAppAppRuntime.login((byte[])localObject2, this.jdField_a_of_type_ArrayOfByte, i, this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getMaskUin(), (byte[])localObject1, null);
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      PhoneNumQuickLoginManager.b("0X800B8D4");
      return;
    }
    if (i == 2) {
      PhoneNumQuickLoginManager.b("0X800B93A");
    }
  }
  
  private void e()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      PhoneNumQuickLoginManager.b("0X800B8D5");
      return;
    }
    if (i == 2) {
      PhoneNumQuickLoginManager.b("0X800B93B");
    }
  }
  
  private void f()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void g()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
    {
      EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
      if (localEditText == null) {
        return;
      }
      localEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
    }
  }
  
  public void b()
  {
    InputMethodManager localInputMethodManager = this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
    if (localInputMethodManager != null)
    {
      QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if (localQBaseActivity == null) {
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(localQBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370448) {
      if (!NetworkUtil.isNetworkAvailable())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694422, 0).a();
      }
      else
      {
        b();
        e();
        c();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559317, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy = new LoginProxy();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (paramLayoutInflater == null) {
      paramLayoutInflater = null;
    } else {
      paramLayoutInflater = paramLayoutInflater.getAppRuntime();
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramLayoutInflater;
    paramLayoutInflater = this.jdField_a_of_type_MqqAppAppRuntime;
    if (paramLayoutInflater == null)
    {
      QLog.d("LoginAccountFragment", 1, "onCreateView app interface is null");
      if (!a()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      }
    }
    else
    {
      paramLayoutInflater.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramLayoutInflater, paramLayoutInflater.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131699828));
      paramViewGroup.findViewById(2131376636).setBackgroundResource(2130850437);
      paramLayoutInflater = paramViewGroup.findViewById(2131370452);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramLayoutInflater.setFitsSystemWindows(true);
        paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramViewGroup.getContext()), 0, 0);
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent();
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("from_account_manager", false);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_from", 1);
      this.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArrayExtra("login_tvl_value");
      ((TextView)paramLayoutInflater.findViewById(2131369249)).setText(paramBundle.getStringExtra("title"));
      Object localObject = (TextView)paramLayoutInflater.findViewById(2131369233);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramBundle.getStringExtra("no_btn_text"));
      ((TextView)localObject).setOnClickListener(new LoginAccountFragment.1(this));
      paramLayoutInflater.findViewById(2131369202).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramViewGroup.findViewById(2131372343));
      paramViewGroup.findViewById(2131370448).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo = ((PhoneNumQuickLoginManager.AccountInfo)paramBundle.getSerializableExtra("account_info"));
      if (this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo == null)
      {
        QLog.e("LoginAccountFragment", 1, "onCreateView, info is null");
        QQToast.a(getQBaseActivity(), getString(2131699183), 0).a();
        getQBaseActivity().finish();
      }
      else
      {
        paramBundle = (DropdownView)paramViewGroup.findViewById(2131365985);
        paramLayoutInflater = paramBundle.a();
        paramLayoutInflater.setFocusableInTouchMode(false);
        paramLayoutInflater.setFocusable(false);
        paramLayoutInflater.setText(this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getMaskUin());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getString(2131689529));
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getMaskUin());
        paramBundle.setContentDescription(((StringBuilder)localObject).toString());
        paramBundle = new StringBuilder();
        paramBundle.append(getString(2131689529));
        paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getMaskUin());
        paramLayoutInflater.setContentDescription(paramBundle.toString());
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("input_method"));
        paramViewGroup.postDelayed(new LoginAccountFragment.2(this), 100L);
        d();
      }
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LoginAccountFragment
 * JD-Core Version:    0.7.0.1
 */