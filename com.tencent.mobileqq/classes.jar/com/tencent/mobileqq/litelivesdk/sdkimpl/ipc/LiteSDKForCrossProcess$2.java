package com.tencent.mobileqq.litelivesdk.sdkimpl.ipc;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class LiteSDKForCrossProcess$2
  implements Runnable
{
  LiteSDKForCrossProcess$2(LiteSDKForCrossProcess paramLiteSDKForCrossProcess) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getApplication(), "直播进程启动中，请稍等", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteSDKForCrossProcess.2
 * JD-Core Version:    0.7.0.1
 */