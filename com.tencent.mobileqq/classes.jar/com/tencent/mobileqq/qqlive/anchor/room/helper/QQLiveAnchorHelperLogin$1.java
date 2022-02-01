package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;

class QQLiveAnchorHelperLogin$1
  implements IQQLiveLoginCallback
{
  QQLiveAnchorHelperLogin$1(QQLiveAnchorHelperLogin paramQQLiveAnchorHelperLogin, QQLiveAnchorHelperLogin.Callback paramCallback) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    QQLiveAnchorHelperLogin.a(this.b, paramInt, paramString, this.a);
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    if (paramLoginInfo == null)
    {
      QQLiveAnchorHelperLogin.a(this.b, "logined, but loginInfo is null", this.a);
      return;
    }
    QQLiveAnchorHelperLogin.a(this.b, paramLoginInfo, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperLogin.1
 * JD-Core Version:    0.7.0.1
 */