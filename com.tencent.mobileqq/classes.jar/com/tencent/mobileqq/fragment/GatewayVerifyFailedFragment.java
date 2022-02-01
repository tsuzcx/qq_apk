package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.EquipLockProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class GatewayVerifyFailedFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private EquipLockProxy jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy;
  private String jdField_a_of_type_JavaLangString;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  private void a()
  {
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl)))
    {
      QLog.e("GatewayVerifyFailedFragment", 1, "jumpToOtherVerify, mDevlockInfo or OtherDevLockVerifyUrl is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("portraitOnly", true);
    Object localObject1 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl;
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
    {
      localObject1 = new StringBuilder(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl);
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl.contains("?"))
      {
        ((StringBuilder)localObject1).append("&");
        Object localObject2 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile.split("\\*+");
        if (localObject2.length > 1)
        {
          i = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile.length();
          int j = localObject2[0].length();
          int k = localObject2[1].length();
          localObject2 = ((StringBuilder)localObject1).append("pp=").append(localObject2[0]).append("&tp=").append(localObject2[1]).append("&ccode=").append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode).append("&vseq=").append(this.jdField_b_of_type_Int).append("&starnum=").append(i - j - k).append("&isFromLogin=");
          if (!this.jdField_a_of_type_Boolean) {
            break label520;
          }
          i = 1;
          label238:
          localObject2 = ((StringBuilder)localObject2).append(i).append("&isFromOpenSdk=");
          if (!"com.tencent.mobileqq:openSdk".equals(MobileQQ.processName)) {
            break label525;
          }
          i = 1;
          ((StringBuilder)localObject2).append(i).append("&mentrance=").append(1);
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localIntent.putExtra("url", (String)localObject1);
      localIntent.putExtra("subAccountUin", this.c);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      if ((this.d == null) || (this.d.equals(this.c))) {
        break label535;
      }
    }
    label520:
    label525:
    label535:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        QLog.d("GatewayVerifyFailedFragment", 1, "other_verify,  mMainAccount =" + this.d + " mUin =" + this.c + " isSubaccount=" + bool);
        localIntent.putExtra("isSubaccount", bool);
        localIntent.putExtra("avoidLoginWeb", bool);
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "", 16384L, localIntent, false, -1);
          label441:
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800ADE0", "0X800ADE0", 0, 0, "", "", "", "");
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
          return;
          ((StringBuilder)localObject1).append("?");
          break;
          i = 0;
          break label238;
          i = 0;
        }
        catch (SecurityException localSecurityException)
        {
          break label441;
        }
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity = getArguments();
    this.jdField_a_of_type_JavaLangString = paramActivity.getString("phone_num");
    this.jdField_b_of_type_JavaLangString = paramActivity.getString("country_code");
    this.jdField_a_of_type_Int = paramActivity.getInt("mobile_type");
    this.jdField_a_of_type_Boolean = paramActivity.getBoolean("from_login");
    this.c = paramActivity.getString("uin");
    this.jdField_b_of_type_Int = paramActivity.getInt("seq");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)paramActivity.getParcelable("DevlockInfo"));
    this.d = paramActivity.getString("mainaccount");
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369487) {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131380503) {
        a();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy = new EquipLockProxy();
    paramLayoutInflater = paramLayoutInflater.inflate(2131561186, paramViewGroup, false);
    ((TextView)paramLayoutInflater.findViewById(2131380503)).setOnClickListener(this);
    ((TextView)paramLayoutInflater.findViewById(2131369534)).setText(getString(2131692100));
    paramViewGroup = paramLayoutInflater.findViewById(2131377297);
    paramBundle = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramViewGroup.setLayoutParams(paramBundle);
    paramLayoutInflater.findViewById(2131369487).setOnClickListener(this);
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800ADDF", "0X800ADDF", 0, 0, "", "", "", "");
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.GatewayVerifyFailedFragment
 * JD-Core Version:    0.7.0.1
 */