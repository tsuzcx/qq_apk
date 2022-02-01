package com.tencent.mobileqq.winkpublish.player;

import android.os.Handler;
import android.view.Surface;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class FSPlayer$1
  implements SDKInitListener
{
  FSPlayer$1(FSPlayer paramFSPlayer, Surface paramSurface) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.e("FSPlayer", 1, "onSDKInited failed");
      return;
    }
    RFThreadManager.getUIHandler().post(new FSPlayer.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSPlayer.1
 * JD-Core Version:    0.7.0.1
 */