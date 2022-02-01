package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.QFragmentActivity;
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
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("no_btn_text", paramString2);
    localIntent.putExtra("account_info", paramAccountInfo);
    localIntent.putExtra("from_account_manager", paramBundle.getBoolean("from_account_manager", false));
    localIntent.putExtra("key_from", paramBundle.getInt("key_from", 1));
    localIntent.putExtra("login_tvl_value", paramArrayOfByte);
    QPublicFragmentActivity.a(paramActivity, localIntent, LoginAccountFragment.class, paramInt);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Int == 1) {
      PhoneNumQuickLoginManager.b("0X800B8D9");
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800B93D", "0X800B93D", 0, 0, "", "", paramString, "");
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    String str;
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      str = "";
      paramArrayOfByte = "";
      if (this.jdField_a_of_type_Int == 1)
      {
        paramArrayOfByte = localRspBody.msg_rsp_self_phone.msg_rsp_phone_login;
        i = paramArrayOfByte.int32_phone_bind_result.get();
        str = paramArrayOfByte.str_phone_bind_msg_content.get();
        paramArrayOfByte = paramArrayOfByte.str_phone_bind_msg_title.get();
      }
      while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramArrayOfByte)))
      {
        QLog.d("LoginAccountFragment", 1, new Object[] { "storeOpenLoginPhoneInfo, content or title is null, content : ", str });
        return;
        if (this.jdField_a_of_type_Int == 2)
        {
          paramArrayOfByte = localRspBody.msg_rsp_cmd_9.msg_rsp_phone_sms_extend_login;
          i = paramArrayOfByte.int32_phone_bind_result.get();
          str = paramArrayOfByte.str_phone_bind_msg_content.get();
          paramArrayOfByte = paramArrayOfByte.str_phone_bind_msg_title.get();
        }
      }
      if (i != 0)
      {
        QLog.d("LoginAccountFragment", 1, new Object[] { "storeOpenLoginPhoneInfo, result error , result : ", Integer.valueOf(i) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.d("LoginAccountFragment", 1, "storeOpenLoginPhoneInfo error : ", paramArrayOfByte);
      return;
    }
    LoginStaticField.a(new LoginSuccDialogMessage(i, str, paramArrayOfByte));
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        QLog.d("LoginAccountFragment", 1, "activity invalid");
      }
      return bool;
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Int == 2) {
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800B93C", "0X800B93C", 0, 0, "", "", paramString, "");
    }
  }
  
  private void c()
  {
    int i = 2;
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      QLog.e("LoginAccountFragment", 1, "loginByUinToken, app is null");
      return;
    }
    if ((WtloginManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(1) == null)
    {
      QLog.e("LoginAccountFragment", 1, "loginByUinToken, manager is null");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (((String)localObject1).isEmpty())
    {
      QQToast.a(getActivity(), 2131694725, 0).a();
      return;
    }
    l();
    Object localObject2 = new GatewayVerify.ReqBody();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getUinToken());
    ((GatewayVerify.ReqBody)localObject2).msg_req_mask_qq_login.bytes_encrypt_uin_info.set(localByteStringMicro);
    ((GatewayVerify.ReqBody)localObject2).msg_req_mask_qq_login.setHasFlag(true);
    ((GatewayVerify.ReqBody)localObject2).setHasFlag(true);
    localObject2 = ((GatewayVerify.ReqBody)localObject2).toByteArray();
    libsafeedit.getLoginLegal((String)localObject1);
    localObject1 = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    if (this.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.login((byte[])localObject2, this.jdField_a_of_type_ArrayOfByte, i, this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getMaskUin(), (byte[])localObject1, null);
      return;
      if (this.jdField_a_of_type_Int == 2) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int == 1) {
      PhoneNumQuickLoginManager.b("0X800B8D4");
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    PhoneNumQuickLoginManager.b("0X800B93A");
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Int == 1) {
      PhoneNumQuickLoginManager.b("0X800B8D5");
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    PhoneNumQuickLoginManager.b("0X800B93B");
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      QLog.e("LoginAccountFragment", 1, "showLoadingDialog, dialog is null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
    {
      QLog.e("LoginAccountFragment", 1, "showLoadingDialog, dialog is showing");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
  }
  
  public boolean d_()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370817)
    {
      if (NetworkUtil.a()) {
        break label39;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694457, 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label39:
      b();
      j();
      c();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559443, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy = new LoginProxy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime())
    {
      this.jdField_a_of_type_MqqAppAppRuntime = paramLayoutInflater;
      if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
        break;
      }
      QLog.d("LoginAccountFragment", 1, "onCreateView app interface is null");
      if (!a()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      }
      return paramViewGroup;
    }
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131699695));
    paramViewGroup.findViewById(2131377159).setBackgroundResource(2130850511);
    paramLayoutInflater = paramViewGroup.findViewById(2131370821);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramViewGroup.getContext()), 0, 0);
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("from_account_manager", false);
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_from", 1);
    this.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArrayExtra("login_tvl_value");
    ((TextView)paramLayoutInflater.findViewById(2131369534)).setText(paramBundle.getStringExtra("title"));
    TextView localTextView = (TextView)paramLayoutInflater.findViewById(2131369518);
    localTextView.setVisibility(0);
    localTextView.setText(paramBundle.getStringExtra("no_btn_text"));
    localTextView.setOnClickListener(new LoginAccountFragment.1(this));
    paramLayoutInflater.findViewById(2131369487).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramViewGroup.findViewById(2131372766));
    paramViewGroup.findViewById(2131370817).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo = ((PhoneNumQuickLoginManager.AccountInfo)paramBundle.getSerializableExtra("account_info"));
    if (this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo == null)
    {
      QLog.e("LoginAccountFragment", 1, "onCreateView, info is null");
      QQToast.a(getActivity(), getString(2131699076), 0).a();
      getActivity().finish();
      return paramViewGroup;
    }
    paramLayoutInflater = (DropdownView)paramViewGroup.findViewById(2131366068);
    paramBundle = paramLayoutInflater.a();
    paramBundle.setFocusableInTouchMode(false);
    paramBundle.setFocusable(false);
    paramBundle.setText(this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getMaskUin());
    paramLayoutInflater.setContentDescription(getString(2131689502) + this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getMaskUin());
    paramBundle.setContentDescription(getString(2131689502) + this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$AccountInfo.getMaskUin());
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("input_method"));
    paramViewGroup.postDelayed(new LoginAccountFragment.2(this), 100L);
    d();
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LoginAccountFragment
 * JD-Core Version:    0.7.0.1
 */