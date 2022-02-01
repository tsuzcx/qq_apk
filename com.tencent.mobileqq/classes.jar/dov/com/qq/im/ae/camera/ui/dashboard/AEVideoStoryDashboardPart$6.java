package dov.com.qq.im.ae.camera.ui.dashboard;

import com.tencent.mobileqq.app.ThreadManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.os.MqqHandler;

class AEVideoStoryDashboardPart$6
  implements EIPCResultCallback
{
  AEVideoStoryDashboardPart$6(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.6.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.6
 * JD-Core Version:    0.7.0.1
 */