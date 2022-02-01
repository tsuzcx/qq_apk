package com.tencent.mobileqq.gamecenter.web;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class QQGameIpcHandle$1
  implements EIPCResultCallback
{
  QQGameIpcHandle$1(QQGameIpcHandle paramQQGameIpcHandle, QQGameIpcHandle.QGameIPCTask paramQGameIPCTask, String paramString, boolean paramBoolean) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGameIpcHandle.1.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameIpcHandle.1
 * JD-Core Version:    0.7.0.1
 */