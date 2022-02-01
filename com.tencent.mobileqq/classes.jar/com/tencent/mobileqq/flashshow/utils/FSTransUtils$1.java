package com.tencent.mobileqq.flashshow.utils;

import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleVideoSdkInitListener;

final class FSTransUtils$1
  implements QCircleVideoSdkInitListener
{
  FSTransUtils$1(QCircleVideoSdkInitListener paramQCircleVideoSdkInitListener) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QCircleVideoSdkInitListener localQCircleVideoSdkInitListener = this.a;
    if (localQCircleVideoSdkInitListener != null) {
      localQCircleVideoSdkInitListener.onSDKInited(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSTransUtils.1
 * JD-Core Version:    0.7.0.1
 */