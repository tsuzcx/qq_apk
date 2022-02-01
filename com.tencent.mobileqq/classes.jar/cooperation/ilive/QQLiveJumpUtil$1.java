package cooperation.ilive;

import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;

final class QQLiveJumpUtil$1
  implements IQQLiveLoginCallback
{
  public void onFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initSdk login onFailed errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errorMsg:");
    localStringBuilder.append(paramString);
    QLog.e("QQLiveJumpUtil", 1, localStringBuilder.toString());
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    QLog.e("QQLiveJumpUtil", 1, "initSdk login onSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.QQLiveJumpUtil.1
 * JD-Core Version:    0.7.0.1
 */