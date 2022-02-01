package dov.com.qq.im.editipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelItemInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class PeakIpcController$2
  implements EIPCResultCallback
{
  PeakIpcController$2(SendPanelItemInfo paramSendPanelItemInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEIPCResult != null)
    {
      bool1 = bool2;
      if (paramEIPCResult.data != null) {
        bool1 = paramEIPCResult.data.getBoolean("key_result");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcController", 2, "cancelSendVideoOrPhoto result:" + bool1 + ", uinseq:" + this.a.a + ", status:" + this.a.b + ", progress:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcController.2
 * JD-Core Version:    0.7.0.1
 */