package com.tencent.mobileqq.loginregister.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.NewAuthDevUgFragment;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;
import java.util.Map;

public class LoginRegisterApiImpl
  implements ILoginRegisterApi
{
  public Class<? extends QPublicBaseFragment> getLHBuyFragment()
  {
    return LiangHaoBuyFragment.class;
  }
  
  public Class<?> getLoginActivityClass()
  {
    return LoginActivity.class;
  }
  
  public Class<?> getLoginPhoneNumActivityClass()
  {
    return LoginPhoneNumActivity.class;
  }
  
  public Class<? extends QPublicBaseFragment> getNewAuthDevUgFragment()
  {
    return NewAuthDevUgFragment.class;
  }
  
  public Class<?> getRegisterByNicknameAndPwdActivityClass()
  {
    return RegisterByNicknameAndPwdActivity.class;
  }
  
  public Class<?> getRegisterPersonalInfoActivityClass()
  {
    return RegisterPersonalInfoActivity.class;
  }
  
  public Class<?> getRegisterPhoneNumActivityClass()
  {
    return RegisterPhoneNumActivity.class;
  }
  
  public Class<?> getRegisterQQNumberActivity()
  {
    return RegisterQQNumberActivity.class;
  }
  
  public Class<?> getRegisterSendUpSmsClass()
  {
    return RegisterSendUpSms.class;
  }
  
  public Class<?> getRegisterVerifyCodeActivityClass()
  {
    return RegisterVerifyCodeActivity.class;
  }
  
  public void showBottomDialog(Context paramContext, Map<String, Object> paramMap)
  {
    PhoneNumQuickLoginManager.c(paramContext, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.impl.LoginRegisterApiImpl
 * JD-Core Version:    0.7.0.1
 */