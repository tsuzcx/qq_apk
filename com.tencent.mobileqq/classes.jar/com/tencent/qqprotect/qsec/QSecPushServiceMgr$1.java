package com.tencent.qqprotect.qsec;

class QSecPushServiceMgr$1
  implements Runnable
{
  QSecPushServiceMgr$1(QSecPushServiceMgr paramQSecPushServiceMgr, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    QSecPushServiceMgr.PushCmdData localPushCmdData = QSecPushServiceMgr.a(this.this$0, this.a);
    if (localPushCmdData != null) {
      QSecPushServiceMgr.a(this.this$0, localPushCmdData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecPushServiceMgr.1
 * JD-Core Version:    0.7.0.1
 */