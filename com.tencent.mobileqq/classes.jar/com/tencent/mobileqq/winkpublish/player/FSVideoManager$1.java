package com.tencent.mobileqq.winkpublish.player;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class FSVideoManager$1
  implements SDKInitListener
{
  FSVideoManager$1(FSVideoManager paramFSVideoManager) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean) {
      QLog.e("QCircleVideoManager", 1, "onSDKInited failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSVideoManager.1
 * JD-Core Version:    0.7.0.1
 */