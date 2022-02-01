package dov.com.qq.im.editipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class PeakIpcController$5
  implements EIPCResultCallback
{
  PeakIpcController$5(String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null)
    {
      paramEIPCResult = paramEIPCResult.data.getString("uinname");
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "getTroopMemberName success name = " + paramEIPCResult);
      }
      SendPanelManager.a().a(this.a, paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcController.5
 * JD-Core Version:    0.7.0.1
 */