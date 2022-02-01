package dov.com.qq.im.editipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class PeakIpcController$1
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null)
    {
      boolean bool = paramEIPCResult.data.getBoolean("key_result");
      QLog.d("PeakIpcController", 2, "sendVideo result:" + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcController.1
 * JD-Core Version:    0.7.0.1
 */