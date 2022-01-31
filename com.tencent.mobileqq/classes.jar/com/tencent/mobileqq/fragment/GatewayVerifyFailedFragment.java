package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import azqs;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class GatewayVerifyFailedFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
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
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
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
            break label563;
          }
          i = 1;
          label244:
          localObject2 = ((StringBuilder)localObject2).append(i).append("&isFromOpenSdk=");
          if (!"com.tencent.mobileqq:openSdk".equals(getActivity().getAppInterface().getApplication().getQQProcessName())) {
            break label568;
          }
          i = 1;
          label280:
          ((StringBuilder)localObject2).append(i);
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
        break label590;
      }
    }
    label444:
    label579:
    label590:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        QLog.d("GatewayVerifyFailedFragment", 1, "other_verify,  mMainAccount =" + this.d + " mUin =" + this.c + " isSubaccount=" + bool);
        localIntent.putExtra("isSubaccount", bool);
        localIntent.putExtra("avoidLoginWeb", bool);
        try
        {
          VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_AndroidAppActivity, "", 16384L, localIntent, false, -1);
          this.jdField_a_of_type_AndroidAppActivity.finish();
          if ((getActivity().getAppInterface() instanceof QQAppInterface))
          {
            localObject1 = (QQAppInterface)getActivity().getAppInterface();
            label476:
            azqs.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800ADE0", "0X800ADE0", 0, 0, "", "", "", "");
            if (!(getActivity().getAppInterface() instanceof QQAppInterface)) {
              break label579;
            }
          }
          for (localObject1 = (QQAppInterface)getActivity().getAppInterface();; localObject1 = null)
          {
            azqs.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
            return;
            ((StringBuilder)localObject1).append("?");
            break;
            i = 0;
            break label244;
            i = 0;
            break label280;
            localObject1 = null;
            break label476;
          }
        }
        catch (SecurityException localSecurityException)
        {
          break label444;
        }
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
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
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368624: 
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131560923, paramViewGroup, false);
    ((TextView)paramViewGroup.findViewById(2131378916)).setOnClickListener(this);
    ((TextView)paramViewGroup.findViewById(2131368670)).setText(getString(2131692214));
    paramLayoutInflater = paramViewGroup.findViewById(2131375987);
    paramBundle = (LinearLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramLayoutInflater.setLayoutParams(paramBundle);
    paramViewGroup.findViewById(2131368624).setOnClickListener(this);
    if ((getActivity().getAppInterface() instanceof QQAppInterface)) {}
    for (paramLayoutInflater = (QQAppInterface)getActivity().getAppInterface();; paramLayoutInflater = null)
    {
      azqs.a(paramLayoutInflater, "dc00898", "", "", "0X800ADDF", "0X800ADDF", 0, 0, "", "", "", "");
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.GatewayVerifyFailedFragment
 * JD-Core Version:    0.7.0.1
 */