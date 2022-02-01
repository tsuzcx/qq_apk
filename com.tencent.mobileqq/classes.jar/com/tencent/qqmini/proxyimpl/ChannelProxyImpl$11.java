package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class ChannelProxyImpl$11
  implements SDKInitListener
{
  ChannelProxyImpl$11(ChannelProxyImpl paramChannelProxyImpl) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.e("ChannelProxyImpl", 1, "initSDKAsync failed!");
      return;
    }
    QLog.d("ChannelProxyImpl", 1, "initSDKAsync succeed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.11
 * JD-Core Version:    0.7.0.1
 */