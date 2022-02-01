package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionCenter$2
  extends FMObserver
{
  OnlineFileSessionCenter$2(OnlineFileSessionCenter paramOnlineFileSessionCenter) {}
  
  protected void a(long paramLong)
  {
    if (0L == paramLong)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] OnOnlineFileProgressDirectDone sessionid error.return");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.a.a(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]. not find worker.OnOnlineFileProgressDirectDone");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ((OnlineFileSessionWorker)localObject).l();
    if (((OnlineFileSessionWorker)localObject).g()) {
      this.a.e(paramLong);
    }
  }
  
  protected void b(long paramLong)
  {
    if (0L == paramLong)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.a.a(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ((OnlineFileSessionWorker)localObject).n();
    if (((OnlineFileSessionWorker)localObject).g()) {
      this.a.e(paramLong);
    }
  }
  
  protected void c(long paramLong)
  {
    if (0L == paramLong)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.a.a(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ((OnlineFileSessionWorker)localObject).p();
    if (((OnlineFileSessionWorker)localObject).g()) {
      this.a.e(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.2
 * JD-Core Version:    0.7.0.1
 */