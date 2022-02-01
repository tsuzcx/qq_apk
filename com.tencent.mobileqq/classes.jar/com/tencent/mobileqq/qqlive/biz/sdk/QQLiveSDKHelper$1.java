package com.tencent.mobileqq.qqlive.biz.sdk;

import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;

final class QQLiveSDKHelper$1
  implements IQQLiveLoginCallback
{
  QQLiveSDKHelper$1(IQQLiveLoginCallback paramIQQLiveLoginCallback) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("login fail code ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" msg ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQLiveSDKHelper", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((IQQLiveLoginCallback)localObject).onFailed(paramInt, paramString);
    }
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("login info ");
      ((StringBuilder)localObject).append(paramLoginInfo);
      QLog.d("QQLiveSDKHelper", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((IQQLiveLoginCallback)localObject).onSuccess(paramLoginInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.biz.sdk.QQLiveSDKHelper.1
 * JD-Core Version:    0.7.0.1
 */