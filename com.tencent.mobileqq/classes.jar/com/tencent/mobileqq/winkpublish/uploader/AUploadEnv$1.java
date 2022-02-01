package com.tencent.mobileqq.winkpublish.uploader;

import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import cooperation.qqcircle.utils.NetworkState.NetworkStateListener;

class AUploadEnv$1
  implements NetworkState.NetworkStateListener
{
  AUploadEnv$1(AUploadEnv paramAUploadEnv, UploadConfiguration.NetworkStateObserver paramNetworkStateObserver) {}
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("upload2: onNetworkConnect registerNetworkStateObserver|onNetworkConnect：");
      localStringBuilder.append(paramBoolean);
      QLog.d("[upload2]AUploadEnv", 2, localStringBuilder.toString());
    }
    AUploadEnv.a(this.b, paramBoolean);
    this.a.onStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.uploader.AUploadEnv.1
 * JD-Core Version:    0.7.0.1
 */