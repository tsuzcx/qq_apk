package com.tencent.mobileqq.qqgamepub.ipc;

import eipc.EIPCResult;
import java.util.Map;

class QQGameIPCHandler$1$1
  implements Runnable
{
  QQGameIPCHandler$1$1(QQGameIPCHandler.1 param1, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    if (QQGameIPCHandler.QGameIPCTask.b(this.b.a) != null) {
      QQGameIPCHandler.QGameIPCTask.b(this.b.a).a(this.b.b, this.a);
    }
    if (this.b.c)
    {
      QQGameIPCHandler.a(this.b.d).remove(this.b.b);
      QQGameIPCHandler.b(this.b.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler.1.1
 * JD-Core Version:    0.7.0.1
 */