package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

class PresenceInterfaceImpl$9
  implements TVK_SDKMgr.InstallListener
{
  PresenceInterfaceImpl$9(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    PresenceInterfaceImpl.a = false;
    this.a.a(HardCodeUtil.a(2131708394));
    if (QLog.isColorLevel()) {
      QLog.d("PresenceInterfaceImpl", 2, "tencent sdk onInstalledFail");
    }
  }
  
  public void onInstalledSuccessed()
  {
    PresenceInterfaceImpl.a = false;
    if (!this.a.c)
    {
      ThreadManager.getSubThreadHandler().post(new PresenceInterfaceImpl.9.1(this));
      QLog.d("PresenceInterfaceImpl", 2, "run installSDK here");
    }
    QLog.d("PresenceInterfaceImpl", 2, "tencent sdk onInstall sucess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.9
 * JD-Core Version:    0.7.0.1
 */