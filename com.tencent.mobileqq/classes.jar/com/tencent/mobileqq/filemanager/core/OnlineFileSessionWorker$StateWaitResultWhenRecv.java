package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$StateWaitResultWhenRecv
  extends OnlineFileSessionWorker.StateBase
{
  public OnlineFileSessionWorker$StateWaitResultWhenRecv(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenRecv";
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
              OnlineFileSessionWorker.b(this.a, 9, 11);
              OnlineFileSessionWorker.c(this.a, 9, 14);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("OLfilesession[");
              localStringBuilder.append(this.a.b);
              localStringBuilder.append("] state change :(");
              localStringBuilder.append(this.b.a());
              localStringBuilder.append("->StateUploadingWhenRecv)");
              QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
              this.b = new OnlineFileSessionWorker.StateUploadingWhenRecv(this.a);
            }
            paramInt = 0;
          }
          else
          {
            OnlineFileSessionWorker.b(this.a, 11, 7);
            OnlineFileSessionWorker.c(this.a, 11, 7);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("OLfilesession[");
            localStringBuilder.append(this.a.b);
            localStringBuilder.append("] state change :(");
            localStringBuilder.append(this.b.a());
            localStringBuilder.append("->StateSaveToWeiYunByPC)");
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
            this.b = new OnlineFileSessionWorker.StateSaveToWeiYunByPC(this.a);
            paramInt = i;
          }
        }
        else
        {
          OnlineFileSessionWorker.b(this.a, 11, 8);
          OnlineFileSessionWorker.c(this.a, 11, 8);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OLfilesession[");
          localStringBuilder.append(this.a.b);
          localStringBuilder.append("] state change :(");
          localStringBuilder.append(this.b.a());
          localStringBuilder.append("->StateSenderCancelSend)");
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
          this.b = new OnlineFileSessionWorker.StateSenderCancelSend(this.a);
          paramInt = i;
        }
      }
      else
      {
        OnlineFileSessionWorker.b(this.a, 11, 6);
        OnlineFileSessionWorker.c(this.a, 11, 6);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.a.b);
        localStringBuilder.append("] state change :(");
        localStringBuilder.append(this.b.a());
        localStringBuilder.append("->StateRefuseByPC)");
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
        this.b = new OnlineFileSessionWorker.StateRefuseByPC(this.a);
        paramInt = i;
      }
    }
    else
    {
      OnlineFileSessionWorker.b(this.a, 11, 5);
      OnlineFileSessionWorker.c(this.a, 11, 5);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append("->StateAcceptByPC)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.b = new OnlineFileSessionWorker.StateAcceptByPC(this.a);
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
    OnlineFileSessionWorker.a(this.a, 9, 11);
    OnlineFileSessionWorker.a(this.a, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.b = new OnlineFileSessionWorker.StateUploadingWhenRecv(this.a);
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
    OnlineFileSessionWorker.a(this.a, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenRecv(this.a);
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = this.a.c;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. StateWaitingRecvResult entity is null");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (paramBoolean == true)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("] state change :(");
      ((StringBuilder)localObject).append(this.b.a());
      ((StringBuilder)localObject).append(" recv  success response of accept,  waiting the cmd of starting upload");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.c(1);
    if (!this.a.t())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. state:");
      ((StringBuilder)localObject).append(this.b.a());
      ((StringBuilder)localObject).append(" recvonlinefile result = false and no handle it. here waiting response of asking progress");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.c(false);
    OnlineFileSessionWorker.b(this.a, 9, 10);
    OnlineFileSessionWorker.c(this.a, 9, 10);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateChangeToOffFailedWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenRecv(this.a);
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 6, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfile session[");
    ((StringBuilder)localObject).append(this.a.b);
    ((StringBuilder)localObject).append("]  recv failed!!");
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
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
    if ((FileManagerUtil.c(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.a.a.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    this.a.a(paramLong, localFileManagerEntity.peerUin);
    if (localFileManagerEntity.fProgress < 0.9F)
    {
      paramString = new StringBuilder();
      paramString.append("OLfilesession[");
      paramString.append(this.a.b);
      paramString.append("]. start make progress pass to 100% directly");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
      this.d = true;
      this.a.a(1.0F);
      return true;
    }
    i();
    return true;
  }
  
  protected void b(int paramInt)
  {
    Object localObject = this.a.c;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. onFailedOfLocalSomeThingHappen entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    OnlineFileSessionWorker.b(this.a, 9, 10);
    OnlineFileSessionWorker.c(this.a, 9, 10);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateChangeToOffFailedWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenRecv(this.a);
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 6, null);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (b("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("] state change :(");
      ((StringBuilder)localObject).append(this.b.a());
      ((StringBuilder)localObject).append(" recv  success response of ask progress,  waiting the notify of progress");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.c(2);
    if (!this.a.t())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. state:");
      ((StringBuilder)localObject).append(this.b.a());
      ((StringBuilder)localObject).append("ask progress server result = false and no handle it. here waiting response of sender on recv");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.c(false);
    OnlineFileSessionWorker.b(this.a, 9, 10);
    OnlineFileSessionWorker.c(this.a, 9, 10);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(this.a.b);
    ((StringBuilder)localObject).append("] state change :(");
    ((StringBuilder)localObject).append(this.b.a());
    ((StringBuilder)localObject).append("->StateChangeToOffFailedWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenRecv(this.a);
    localObject = this.a.c;
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 6, null);
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
    OnlineFileSessionWorker.a(this.a, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.b = new OnlineFileSessionWorker.StateCancelUploadWhenRecv(this.a);
  }
  
  protected void f()
  {
    if (this.a.c == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. onPauseTrans entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    OnlineFileSessionWorker.b(this.a, 10, -2);
    OnlineFileSessionWorker.c(this.a, 10, 15);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateWaitResultWhenPause)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateWaitResultWhenPause(this.a);
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
    OnlineFileSessionWorker.b(this.a, 9, 11);
    OnlineFileSessionWorker.c(this.a, 9, 14);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateUploadingWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateUploadingWhenRecv(this.a);
  }
  
  protected void h()
  {
    Object localObject = this.a.c;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. state:");
      ((StringBuilder)localObject).append(this.b.a());
      ((StringBuilder)localObject).append(" onRecvButSenderReplayTimeOut entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("]. state:");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append(" you had recv the file, but sender replay time out!!!!, recvCmdSucAndHadTryCount =");
    localStringBuilder.append(this.a.h.a);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.a.c(1);
    if (!this.a.t())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. state:");
      ((StringBuilder)localObject).append(this.b.a());
      ((StringBuilder)localObject).append(" sender replay time out and no handle it. here waiting response of asking progress");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.c(false);
    if (this.a.h.a < 9223372036854775807L)
    {
      OnlineFileSessionWorker.a(this.a, 9, 10, true);
      a("StateChangeToOffFailedWhenRecv");
      this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenRecv(this.a);
      this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 15, null);
      return;
    }
    OnlineFileSessionWorker.a(this.a, 9, 12, true);
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 5, null);
    a("StateExcepInvalidWhenRecv");
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenRecv(this.a);
  }
  
  protected void i()
  {
    Object localObject = this.a.c;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. doSomeThingOnUploadDone entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.a.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(((FileManagerEntity)localObject).nSessionId), Long.valueOf(((FileManagerEntity)localObject).nOLfileSessionId) });
    ((FileManagerEntity)localObject).fProgress = 0.0F;
    ((FileManagerEntity)localObject).setCloudType(1);
    OnlineFileSessionWorker.b(this.a, 1, 0);
    OnlineFileSessionWorker.c(this.a, 1, 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append(". doSomeThingOnUploadDone start recv offline file....)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.a.a.getFileManagerRSCenter().a(this.a.b, ((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 1);
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 10, null, 6, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(this.a.b);
    ((StringBuilder)localObject).append("] state change :(");
    ((StringBuilder)localObject).append(this.b.a());
    ((StringBuilder)localObject).append("->StateGotoOffFileProcess)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.b = new OnlineFileSessionWorker.StateGotoOffFileProcess(this.a);
  }
  
  protected void k()
  {
    if (b("onAskSenderUpProgressTimeOut")) {
      return;
    }
    Object localObject = this.a.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("]. state:");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append(" you had recv the file, but  ask progress time out!!!!, recvCmdSucAndHadTryCount =");
    localStringBuilder.append(this.a.h.a);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.a.c(2);
    if (!this.a.t())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. state:");
      ((StringBuilder)localObject).append(this.b.a());
      ((StringBuilder)localObject).append(" ask progress time out and no handle it. here waiting response of sender when recv");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.c(false);
    if (this.a.h.a < 9223372036854775807L)
    {
      OnlineFileSessionWorker.a(this.a, 9, 10, true);
      a("StateChangeToOffFailedWhenRecv");
      this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenRecv(this.a);
      this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 15, null);
      return;
    }
    OnlineFileSessionWorker.a(this.a, 9, 12, true);
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 5, null);
    a("StateExcepInvalidWhenRecv");
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenRecv(this.a);
  }
  
  protected void m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateWaitResultWhenRecv
 * JD-Core Version:    0.7.0.1
 */