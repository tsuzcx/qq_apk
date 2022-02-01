package com.tencent.mobileqq.flashshow.helper;

import com.tencent.mobileqq.flashshow.callback.AccountIdentityCallBack;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.qphone.base.util.QLog;

final class FSBindPhoneNumberHelper$1
  implements AccountIdentityCallBack
{
  public void onSuccess(boolean paramBoolean, String paramString)
  {
    if (((paramString != null) && (paramString.trim().length() > 0)) || (paramBoolean))
    {
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      FSConfig.a(i);
      FSConfig.a(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshAccountState  getAccountIdentitySuccess  isAuthenticated : ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("  ， url ： ");
      localStringBuilder.append(paramString);
      QLog.i("QCircleBindPhoneNumberHelper", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSBindPhoneNumberHelper.1
 * JD-Core Version:    0.7.0.1
 */