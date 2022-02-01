package com.tencent.mobileqq.subaccount.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ISubAccountAssistantForward
  extends QRouteApi
{
  public abstract void closePhoneNumActivity(AppRuntime paramAppRuntime);
  
  public abstract void closeSubAccountBindActivity(AppRuntime paramAppRuntime);
  
  public abstract void closeSubAccountUgActivity(AppRuntime paramAppRuntime);
  
  public abstract void closeSubLoginActivity(AppRuntime paramAppRuntime);
  
  public abstract void doSomethingAfterSwitchAccount(AppRuntime paramAppRuntime, Context paramContext);
  
  public abstract void doSomethingAfterSwitchAccountSuccess(AppInterface paramAppInterface, Context paramContext);
  
  public abstract void doSomethingBeforeAddAccount(AppInterface paramAppInterface, Context paramContext);
  
  public abstract void forwardTo(AppInterface paramAppInterface, Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward
 * JD-Core Version:    0.7.0.1
 */