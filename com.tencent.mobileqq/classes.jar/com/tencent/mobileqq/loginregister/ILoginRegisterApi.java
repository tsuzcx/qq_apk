package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ILoginRegisterApi
  extends QRouteApi
{
  public abstract Class<? extends QPublicBaseFragment> getHintDlgFragment();
  
  public abstract Class<? extends QPublicBaseFragment> getLHBuyFragment();
  
  public abstract Class<?> getLoginActivityClass();
  
  public abstract Class<?> getLoginPhoneNumActivityClass();
  
  public abstract Class<? extends QPublicBaseFragment> getNewAuthDevUgFragment();
  
  public abstract Class<?> getRegisterByNicknameAndPwdActivityClass();
  
  public abstract Class<?> getRegisterPersonalInfoActivityClass();
  
  public abstract Class<?> getRegisterPhoneNumActivityClass();
  
  public abstract Class<?> getRegisterQQNumberActivity();
  
  public abstract Class<?> getRegisterSendUpSmsClass();
  
  public abstract Class<?> getRegisterVerifyCodeActivityClass();
  
  public abstract void logout(Activity paramActivity, AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void showBottomDialog(Context paramContext, Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ILoginRegisterApi
 * JD-Core Version:    0.7.0.1
 */