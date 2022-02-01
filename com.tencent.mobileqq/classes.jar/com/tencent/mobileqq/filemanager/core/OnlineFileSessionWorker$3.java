package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$3
  implements Runnable
{
  OnlineFileSessionWorker$3(OnlineFileSessionWorker paramOnlineFileSessionWorker, float paramFloat) {}
  
  public void run()
  {
    if (this.this$0.c == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = this.this$0.c;
    while ((localFileManagerEntity.fProgress < this.a) && (this.this$0.c != null))
    {
      float f1 = localFileManagerEntity.fProgress + 0.05F;
      float f2 = this.a;
      if (f1 > f2) {
        localFileManagerEntity.fProgress = f2;
      } else {
        localFileManagerEntity.fProgress = f1;
      }
      this.this$0.a.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 16, null, 0, null);
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    if ((localFileManagerEntity.fProgress >= 1.0F) && (this.this$0.c != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(localFileManagerEntity.nSessionId);
      localStringBuilder.append("] state:");
      localStringBuilder.append(OnlineFileSessionWorker.a(this.this$0).a());
      localStringBuilder.append(" make progress. direct pass to 1.0 and notify make done");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.this$0.a.getFileManagerNotifyCenter().a(true, 41, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.3
 * JD-Core Version:    0.7.0.1
 */