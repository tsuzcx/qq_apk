package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class QQLiveSDKManagerImpl$1
  implements SDKInitListener
{
  QQLiveSDKManagerImpl$1(QQLiveSDKManagerImpl paramQQLiveSDKManagerImpl) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQVideoPlaySDKManagerInit ");
    localStringBuilder.append(paramBoolean);
    QLog.d("QQLiveSDKManagerImpl", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.QQLiveSDKManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */