package com.tencent.mobileqq.filemanager.core;

import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$StateRefuseByPCWhenPause
  extends OnlineFileSessionWorker.StateBase
{
  public OnlineFileSessionWorker$StateRefuseByPCWhenPause(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateRefuseByPCWhenPause";
  }
  
  protected void b()
  {
    if (this.a.c == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. recvOnLineFile entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    OnlineFileSessionWorker.b(this.a, 11, 6);
    OnlineFileSessionWorker.c(this.a, 11, 6);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateRefuseByPC)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateRefuseByPC(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateRefuseByPCWhenPause
 * JD-Core Version:    0.7.0.1
 */