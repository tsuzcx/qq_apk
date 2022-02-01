package com.tencent.mobileqq.kandian.base.video.plugin;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerSDKEventListener;
import com.tencent.qphone.base.util.QLog;

class VideoPluginInstall$SDKInstallListener
  implements IPlayerSDKEventListener
{
  private Handler a;
  
  public VideoPluginInstall$SDKInstallListener(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.excute(new VideoPluginInstall.SDKInstallListener.1(this, paramBoolean, paramInt), 16, null, true);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onInstalledSuccessed: ");
    }
    a(true, 0);
    Handler localHandler = this.a;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(0);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInstalledFailed: code=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    a(false, paramInt);
    Object localObject = this.a;
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall.SDKInstallListener
 * JD-Core Version:    0.7.0.1
 */