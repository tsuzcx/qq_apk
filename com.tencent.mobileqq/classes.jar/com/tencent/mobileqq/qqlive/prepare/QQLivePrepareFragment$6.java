package com.tencent.mobileqq.qqlive.prepare;

import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;

class QQLivePrepareFragment$6
  implements IQQLiveLoginCallback
{
  QQLivePrepareFragment$6(QQLivePrepareFragment paramQQLivePrepareFragment) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("the user login action is fail errorCode ");
    paramString.append(paramInt);
    QLog.d("QQLivePrepareFragment", 1, paramString.toString());
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    QQLivePrepareFragment.m(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.6
 * JD-Core Version:    0.7.0.1
 */