package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$StateChangeToOffFailedWhenRecv
  extends OnlineFileSessionWorker.StateBase
{
  public OnlineFileSessionWorker$StateChangeToOffFailedWhenRecv(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateChangeToOffFailedWhenRecv";
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
      this.a.b();
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
              OnlineFileSessionWorker.b(this.a, 13, 11);
              OnlineFileSessionWorker.c(this.a, 13, 14);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("OLfilesession[");
              localStringBuilder.append(this.a.b);
              localStringBuilder.append("] state change :(");
              localStringBuilder.append(this.b.a());
              localStringBuilder.append("->StateChangeToOffWhenToOffFailed)");
              QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
              this.b = new OnlineFileSessionWorker.StateChangeToOffWhenToOffFailed(this.a);
            }
            paramInt = 0;
          }
          else
          {
            OnlineFileSessionWorker.b(this.a, 13, 7);
            OnlineFileSessionWorker.c(this.a, 13, 7);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("OLfilesession[");
            localStringBuilder.append(this.a.b);
            localStringBuilder.append("] state change :(");
            localStringBuilder.append(this.b.a());
            localStringBuilder.append("->StateSaveToWeiYunByPCWhenToOffFailed)");
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
            this.b = new OnlineFileSessionWorker.StateSaveToWeiYunByPCWhenToOffFailed(this.a);
            paramInt = i;
          }
        }
        else
        {
          OnlineFileSessionWorker.b(this.a, 13, 8);
          OnlineFileSessionWorker.c(this.a, 13, 8);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OLfilesession[");
          localStringBuilder.append(this.a.b);
          localStringBuilder.append("] state change :(");
          localStringBuilder.append(this.b.a());
          localStringBuilder.append("->StateSenderCancelSendWhenToOffFailed)");
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
          this.b = new OnlineFileSessionWorker.StateSenderCancelSendWhenToOffFailed(this.a);
          paramInt = i;
        }
      }
      else
      {
        OnlineFileSessionWorker.b(this.a, 13, 6);
        OnlineFileSessionWorker.c(this.a, 13, 6);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.a.b);
        localStringBuilder.append("] state change :(");
        localStringBuilder.append(this.b.a());
        localStringBuilder.append("->StateRefuseByPCWhenToOffFailed)");
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
        this.b = new OnlineFileSessionWorker.StateRefuseByPCWhenToOffFailed(this.a);
        paramInt = i;
      }
    }
    else
    {
      OnlineFileSessionWorker.b(this.a, 13, 5);
      OnlineFileSessionWorker.c(this.a, 13, 5);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append("->StateAcceptByPCWhenToOffFailed)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.b = new OnlineFileSessionWorker.StateAcceptByPCWhenToOffFailed(this.a);
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
    OnlineFileSessionWorker.b(this.a);
    b(paramInt1, paramInt2);
    OnlineFileSessionWorker.a(this.a, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.b = new OnlineFileSessionWorker.StateLocalFailedWhenRecv(this.a);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (b("onSenderUploadException")) {
      return;
    }
    OnlineFileSessionWorker.a(this.a, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenRecv(this.a);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.c == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. StateWaitingRecvResult entity is null");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    if (paramBoolean == true)
    {
      OnlineFileSessionWorker.b(this.a);
      OnlineFileSessionWorker.a(this.a, 9, 11, true);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append("->StateLocalFailedWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.b = new OnlineFileSessionWorker.StateLocalFailedWhenRecv(this.a);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateChangeToOffFailedWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
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
    OnlineFileSessionWorker.b(this.a, 1, 0);
    OnlineFileSessionWorker.c(this.a, 1, 0);
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(this.a.b);
    paramString.append("] state change :(");
    paramString.append(this.b.a());
    paramString.append("->StateGotoOffFileProcess)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
    this.a.a.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.b = new OnlineFileSessionWorker.StateGotoOffFileProcess(this.a);
    return true;
  }
  
  protected void b()
  {
    Object localObject = this.a.c;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. recvOnLineFile entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("start send recv cmd.... [");
    localStringBuilder.append(this.a.h.a);
    localStringBuilder.append("-");
    localStringBuilder.append(this.a.h.b);
    localStringBuilder.append("]");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    if (this.a.a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).nOLfileSessionId))
    {
      OnlineFileSessionWorker.c(this.a, 9, 14);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append("->StateWaitResultWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.b = new OnlineFileSessionWorker.StateWaitResultWhenRecv(this.a);
      this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 10, null, 6, null);
      this.a.a.getFileManagerNotifyCenter().a(this.a.c.uniseq, this.a.c.nSessionId, this.a.c.peerUin, this.a.c.peerType, 16, null, 0, null);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append(" recv  success response of ask progress, not handle it");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append(" recv  failed response of ask progress, not handle it");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void e()
  {
    if (b("onSenderCancelUpload")) {
      return;
    }
    OnlineFileSessionWorker.a(this.a, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.b = new OnlineFileSessionWorker.StateCancelUploadWhenRecv(this.a);
  }
  
  protected void g()
  {
    if (b("onSenderReplayComeOnRecv")) {
      return;
    }
    OnlineFileSessionWorker.b(this.a);
    OnlineFileSessionWorker.a(this.a, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.b = new OnlineFileSessionWorker.StateLocalFailedWhenRecv(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateChangeToOffFailedWhenRecv
 * JD-Core Version:    0.7.0.1
 */