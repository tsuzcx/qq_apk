package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionCenter$2
  extends FMObserver
{
  OnlineFileSessionCenter$2(OnlineFileSessionCenter paramOnlineFileSessionCenter) {}
  
  public void a(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileProgressDirectDone sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      return;
      localOnlineFileSessionWorker = this.a.a(paramLong);
      if (localOnlineFileSessionWorker == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileProgressDirectDone");
        return;
      }
      localOnlineFileSessionWorker.h();
    } while (!localOnlineFileSessionWorker.c());
    this.a.c(paramLong);
  }
  
  public void b(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      return;
      localOnlineFileSessionWorker = this.a.a(paramLong);
      if (localOnlineFileSessionWorker == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
        return;
      }
      localOnlineFileSessionWorker.j();
    } while (!localOnlineFileSessionWorker.c());
    this.a.c(paramLong);
  }
  
  public void c(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      return;
      localOnlineFileSessionWorker = this.a.a(paramLong);
      if (localOnlineFileSessionWorker == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
        return;
      }
      localOnlineFileSessionWorker.l();
    } while (!localOnlineFileSessionWorker.c());
    this.a.c(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.2
 * JD-Core Version:    0.7.0.1
 */