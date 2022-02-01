package com.tencent.mobileqq.earlydownload.api.impl;

import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceRespV2;

class EarlyDownloadServiceImpl$1
  extends ServerConfigObserver
{
  EarlyDownloadServiceImpl$1(EarlyDownloadServiceImpl paramEarlyDownloadServiceImpl) {}
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    super.onGetPluginConfig(paramBoolean, paramInt, paramGetResourceRespV2);
    this.a.handleOnGetPluginConfig(paramBoolean, paramInt, paramGetResourceRespV2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.api.impl.EarlyDownloadServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */