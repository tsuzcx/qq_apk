package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;

class SuperVisionImpl$1
  implements IQQLiveLoginCallback
{
  SuperVisionImpl$1(SuperVisionImpl paramSuperVisionImpl) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("the login module is fail errorCode ");
    paramString.append(paramInt);
    QLog.d("SuperVisionImpl", 1, paramString.toString());
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    QLog.d("SuperVisionImpl", 1, "the login module is success");
    paramLoginInfo = this.this$0;
    SuperVisionImpl.access$000(paramLoginInfo, paramLoginInfo.getReasonFlag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.SuperVisionImpl.1
 * JD-Core Version:    0.7.0.1
 */