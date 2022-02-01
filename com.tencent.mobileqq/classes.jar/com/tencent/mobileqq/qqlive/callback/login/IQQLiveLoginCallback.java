package com.tencent.mobileqq.qqlive.callback.login;

import com.tencent.mobileqq.qqlive.callback.BaseCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;

public abstract interface IQQLiveLoginCallback
  extends BaseCallback
{
  public abstract void onSuccess(LoginInfo paramLoginInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
 * JD-Core Version:    0.7.0.1
 */