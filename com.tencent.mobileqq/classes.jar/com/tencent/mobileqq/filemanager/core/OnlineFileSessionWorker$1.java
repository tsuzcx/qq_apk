package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class OnlineFileSessionWorker$1
  extends TimerTask
{
  OnlineFileSessionWorker$1(OnlineFileSessionWorker paramOnlineFileSessionWorker) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.this$0.c.nSessionId);
    localStringBuilder.append("] state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.this$0).a());
    localStringBuilder.append(" WaitSenderReplayOnRecvTimer time out!!!!!!!");
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.this$0.a.getFileManagerNotifyCenter().a(true, 42, new Object[] { Long.valueOf(this.this$0.c.nSessionId) });
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.1
 * JD-Core Version:    0.7.0.1
 */