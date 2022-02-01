package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$StateWaitResultWhenPause
  extends OnlineFileSessionWorker.StateBase
{
  public OnlineFileSessionWorker$StateWaitResultWhenPause(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenPause";
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.a.c;
    int i = 1;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. onFileRequestBeHandledByPC entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (5 != paramInt) {
      this.a.d();
    } else {
      this.a.d();
    }
    StringBuilder localStringBuilder;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("OLfile session[");
              localStringBuilder.append(this.a.b);
              localStringBuilder.append("]  is not foud . handledbypc type error:");
              localStringBuilder.append(paramInt);
              QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
            }
            else
            {
              OnlineFileSessionWorker.b(this.a);
              OnlineFileSessionWorker.b(this.a, 10, 11);
              OnlineFileSessionWorker.c(this.a, 10, 14);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("OLfilesession[");
              localStringBuilder.append(this.a.b);
              localStringBuilder.append("] state change :(");
              localStringBuilder.append(this.b.a());
              localStringBuilder.append("->StateUploadingWhenPause)");
              QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
              this.b = new OnlineFileSessionWorker.StateUploadingWhenPause(this.a);
            }
            paramInt = 0;
          }
          else
          {
            OnlineFileSessionWorker.b(this.a, 10, 7);
            OnlineFileSessionWorker.c(this.a, 10, 7);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("OLfilesession[");
            localStringBuilder.append(this.a.b);
            localStringBuilder.append("] state change :(");
            localStringBuilder.append(this.b.a());
            localStringBuilder.append("->StateSaveToWeiYunByPCWhenPause)");
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
            this.b = new OnlineFileSessionWorker.StateSaveToWeiYunByPCWhenPause(this.a);
            paramInt = i;
          }
        }
        else
        {
          OnlineFileSessionWorker.b(this.a, 10, 8);
          OnlineFileSessionWorker.c(this.a, 10, 8);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OLfilesession[");
          localStringBuilder.append(this.a.b);
          localStringBuilder.append("] state change :(");
          localStringBuilder.append(this.b.a());
          localStringBuilder.append("->StateSenderCancelSendWhenPause)");
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
          this.b = new OnlineFileSessionWorker.StateSenderCancelSendWhenPause(this.a);
          paramInt = i;
        }
      }
      else
      {
        OnlineFileSessionWorker.b(this.a, 10, 6);
        OnlineFileSessionWorker.c(this.a, 10, 6);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.a.b);
        localStringBuilder.append("] state change :(");
        localStringBuilder.append(this.b.a());
        localStringBuilder.append("->StateRefuseByPCWhenPause)");
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
        this.b = new OnlineFileSessionWorker.StateRefuseByPCWhenPause(this.a);
        paramInt = i;
      }
    }
    else
    {
      OnlineFileSessionWorker.b(this.a, 10, 5);
      OnlineFileSessionWorker.c(this.a, 10, 5);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append("->StateAcceptByPCWhenPause)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.b = new OnlineFileSessionWorker.StateAcceptByPCWhenPause(this.a);
      paramInt = i;
    }
    if (paramInt != 0) {
      this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 0, null);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (b("onSenderUploadProgressNotify")) {
      return;
    }
    this.a.c(true);
    OnlineFileSessionWorker.b(this.a);
    b(paramInt1, paramInt2);
    OnlineFileSessionWorker.a(this.a, 10, 11);
    OnlineFileSessionWorker.a(this.a, 10, 14, false);
    a("StateUploadingWhenPause");
    this.b = new OnlineFileSessionWorker.StateUploadingWhenPause(this.a);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.a.c == null)
    {
      paramString = new StringBuilder();
      paramString.append("OLfilesession[");
      paramString.append(this.a.b);
      paramString.append("]. recvOnLineFile entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
      return;
    }
    OnlineFileSessionWorker.a(this.a, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenPause(this.a);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.c == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. onRecvOnLineFileResult entity is null");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    if (paramBoolean == true)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append(" recv  success response of accept,  waiting the cmd of starting upload");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    this.a.c(1);
    if (!this.a.t())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. state:");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append(" recvonlinefile result = false and no handle it. here waiting response of asking progress");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    this.a.c(false);
    OnlineFileSessionWorker.b(this.a, 10, 10);
    OnlineFileSessionWorker.c(this.a, 10, 10);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateChangeToOffFailedWhenPause)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenPause(this.a);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfile session[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("]  recv failed!!");
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.a.c;
    if (localFileManagerEntity == null)
    {
      paramString = new StringBuilder();
      paramString.append("OLfilesession[");
      paramString.append(this.a.b);
      paramString.append("]. recvOnLineFile entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((FileManagerUtil.c(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.a.a.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    this.a.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    OnlineFileSessionWorker.b(this.a, 1, 3);
    OnlineFileSessionWorker.c(this.a, 1, 3);
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(this.a.b);
    paramString.append("] state change :(");
    paramString.append(this.b.a());
    paramString.append("->StateUploadoneWhenPause)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
    this.a.a.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.b = new OnlineFileSessionWorker.StateUploadoneWhenPause(this.a);
    return true;
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
    OnlineFileSessionWorker.b(this.a, 9, 10);
    OnlineFileSessionWorker.c(this.a, 9, 15);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateWaitResultWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateWaitResultWhenRecv(this.a);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (b("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append(" recv  success response of ask progress,  waiting the notify of progress");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    this.a.c(2);
    if (!this.a.t())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. state:");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append(" ask progress server result = false and no handle it. here waiting response of sender on recv");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    this.a.c(false);
    OnlineFileSessionWorker.b(this.a, 10, 10);
    OnlineFileSessionWorker.c(this.a, 10, 10);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateChangeToOffFailedWhenPause)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenPause(this.a);
  }
  
  protected void e()
  {
    if (this.a.c == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. recvOnLineFile entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    OnlineFileSessionWorker.a(this.a, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.b = new OnlineFileSessionWorker.StateCancelUploadWhenPause(this.a);
  }
  
  protected void g()
  {
    if (this.a.c == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. onSenderReplayComeOnRecv entity is null");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    this.a.c(true);
    OnlineFileSessionWorker.b(this.a);
    OnlineFileSessionWorker.b(this.a, 10, 11);
    OnlineFileSessionWorker.c(this.a, 10, 14);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateUploadingWhenPause)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateUploadingWhenPause(this.a);
  }
  
  protected void h()
  {
    if (this.a.c == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. state:");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append("onRecvButSenderReplayTimeOut entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("]. state:");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append(" you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=");
    localStringBuilder.append(this.a.h.a);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.a.c(1);
    if (!this.a.t())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. state:");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append(" sender replay time out and no handle it. here waiting response of asking progress");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    this.a.c(false);
    if (this.a.h.a < 9223372036854775807L)
    {
      OnlineFileSessionWorker.a(this.a, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenPause(this.a);
      return;
    }
    OnlineFileSessionWorker.a(this.a, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenPause(this.a);
  }
  
  protected void k()
  {
    if (b("onAskSenderUpProgressTimeOut")) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("]. state:");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append(" you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =");
    localStringBuilder.append(this.a.h.a);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.a.c(2);
    if (!this.a.t())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. state:");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append(" ask progress time out and no handle it. here waiting response of sender when recv");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    this.a.c(false);
    if (this.a.h.a < 9223372036854775807L)
    {
      OnlineFileSessionWorker.a(this.a, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenPause(this.a);
      return;
    }
    OnlineFileSessionWorker.a(this.a, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenPause(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateWaitResultWhenPause
 * JD-Core Version:    0.7.0.1
 */