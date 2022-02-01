package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

final class PlayerCaptureProxy$1
  implements SDKInitListener
{
  public void onSDKInited(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSDKInited result:");
      localStringBuilder.append(paramBoolean);
      QLog.d("PlayerCaptureProxy", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.PlayerCaptureProxy.1
 * JD-Core Version:    0.7.0.1
 */