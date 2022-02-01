package com.tencent.mobileqq.subaccount.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import mqq.app.AppRuntime;

public class SubAccountAssistantForwardImpl
  implements ISubAccountAssistantForward
{
  public void closePhoneNumActivity(AppRuntime paramAppRuntime)
  {
    SubAccountAssistantForward.d(paramAppRuntime);
  }
  
  public void closeSubAccountBindActivity(AppRuntime paramAppRuntime)
  {
    SubAccountAssistantForward.b(paramAppRuntime);
  }
  
  public void closeSubAccountUgActivity(AppRuntime paramAppRuntime)
  {
    SubAccountAssistantForward.a(paramAppRuntime);
  }
  
  public void closeSubLoginActivity(AppRuntime paramAppRuntime)
  {
    SubAccountAssistantForward.c(paramAppRuntime);
  }
  
  public void doSomethingAfterSwitchAccount(AppRuntime paramAppRuntime, Context paramContext)
  {
    SubAccountAssistantForward.a(paramAppRuntime, paramContext);
  }
  
  public void doSomethingAfterSwitchAccountSuccess(AppInterface paramAppInterface, Context paramContext)
  {
    SubAccountAssistantForward.a(paramAppInterface, paramContext);
  }
  
  public void doSomethingBeforeAddAccount(AppInterface paramAppInterface, Context paramContext)
  {
    SubAccountAssistantForward.b(paramAppInterface, paramContext);
  }
  
  public void forwardTo(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    SubAccountAssistantForward.a(paramAppInterface, paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountAssistantForwardImpl
 * JD-Core Version:    0.7.0.1
 */