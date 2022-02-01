package com.tencent.mobileqq.flashshow.player;

import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleVideoSdkInitListener;
import com.tencent.qphone.base.util.QLog;

class FSVideoManager$1
  implements QCircleVideoSdkInitListener
{
  FSVideoManager$1(FSVideoManager paramFSVideoManager) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean) {
      QLog.e("FSVideoManager", 1, "onSDKInited failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.FSVideoManager.1
 * JD-Core Version:    0.7.0.1
 */