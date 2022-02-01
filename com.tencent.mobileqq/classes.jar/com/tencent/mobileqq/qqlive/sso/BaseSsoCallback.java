package com.tencent.mobileqq.qqlive.sso;

import com.tencent.mobileqq.qqlive.callback.BaseCallback;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseSsoCallback
  implements BaseCallback
{
  private static final String TAG = "BaseSsoCallback";
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sso call back fail [business error] ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" error msg ");
      localStringBuilder.append(paramString);
      QLog.d("BaseSsoCallback", 2, localStringBuilder.toString());
    }
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sso call back fail [proxy error]");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" error msg ");
      localStringBuilder.append(paramString);
      QLog.d("BaseSsoCallback", 2, localStringBuilder.toString());
    }
  }
  
  public abstract void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.sso.BaseSsoCallback
 * JD-Core Version:    0.7.0.1
 */