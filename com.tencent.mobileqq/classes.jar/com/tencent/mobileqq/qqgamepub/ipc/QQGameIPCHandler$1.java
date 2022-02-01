package com.tencent.mobileqq.qqgamepub.ipc;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class QQGameIPCHandler$1
  implements EIPCResultCallback
{
  QQGameIPCHandler$1(QQGameIPCHandler paramQQGameIPCHandler, QQGameIPCHandler.QGameIPCTask paramQGameIPCTask, String paramString, boolean paramBoolean) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGameIPCHandler.1.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler.1
 * JD-Core Version:    0.7.0.1
 */