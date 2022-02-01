package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.os.MqqHandler;

final class PicShareToWX$2
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCallback, eipcResult.code = ");
      localStringBuilder.append(paramEIPCResult.code);
      QLog.d("PicShareToWX", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new PicShareToWX.2.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.2
 * JD-Core Version:    0.7.0.1
 */