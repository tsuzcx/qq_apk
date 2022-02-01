package com.tencent.mobileqq.qqlive.plugin;

import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;

final class QQLiveAnchorPluginLoginHelper$1
  implements IQQLiveLoginCallback
{
  public void onFailed(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login failed: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      QLog.d("QQLiveAnchor_PluginLogin", 1, localStringBuilder.toString());
    }
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_PluginLogin", 1, "login success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.plugin.QQLiveAnchorPluginLoginHelper.1
 * JD-Core Version:    0.7.0.1
 */