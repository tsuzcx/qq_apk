package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;

public abstract interface QQLiveAnchorHelperLogin$Callback
{
  public abstract void a(QQLiveErrorMsg paramQQLiveErrorMsg);
  
  public abstract void a(LoginInfo paramLoginInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperLogin.Callback
 * JD-Core Version:    0.7.0.1
 */