package com.tencent.mobileqq.loginregister;

public abstract interface ICommonSmsView
{
  public abstract void clearWrongCode();
  
  public abstract void dismissDialog();
  
  public abstract void loginSuccessCallBack();
  
  public abstract void showLoadingDialog();
  
  public abstract void startTimer(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ICommonSmsView
 * JD-Core Version:    0.7.0.1
 */