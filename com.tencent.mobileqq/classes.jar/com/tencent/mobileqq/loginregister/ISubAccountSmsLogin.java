package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;

public abstract interface ISubAccountSmsLogin
{
  public abstract BusinessObserver a(QBaseActivity paramQBaseActivity, ILoginSmsPageView paramILoginSmsPageView);
  
  public abstract void a(QBaseActivity paramQBaseActivity);
  
  public abstract void a(QBaseActivity paramQBaseActivity, SubSmsLoginErrorInfo paramSubSmsLoginErrorInfo, ILoginSmsPageView paramILoginSmsPageView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ISubAccountSmsLogin
 * JD-Core Version:    0.7.0.1
 */