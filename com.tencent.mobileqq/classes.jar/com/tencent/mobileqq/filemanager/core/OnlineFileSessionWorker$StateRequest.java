package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$StateRequest
  extends OnlineFileSessionWorker.StateBase
{
  public OnlineFileSessionWorker$StateRequest(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateRequest";
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
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("OLfile session[");
              localStringBuilder.append(this.a.b);
              localStringBuilder.append("]  is not foud . handledbypc type error:");
              localStringBuilder.append(paramInt);
              QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
            }
            else
            {
              OnlineFileSessionWorker.b(this.a);
              OnlineFileSessionWorker.a(this.a, 11, 11);
              OnlineFileSessionWorker.a(this.a, 11, 14, false);
              a("StateUploadingWhenChangeToOff");
              this.b = new OnlineFileSessionWorker.StateUploadingWhenChangeToOff(this.a);
            }
            paramInt = 0;
          }
          else
          {
            OnlineFileSessionWorker.a(this.a, 11, 7, true);
            a("StateSaveToWeiYunByPC");
            this.b = new OnlineFileSessionWorker.StateSaveToWeiYunByPC(this.a);
            paramInt = i;
          }
        }
        else
        {
          OnlineFileSessionWorker.a(this.a, 11, 8, true);
          a("StateSenderCancelSend");
          this.b = new OnlineFileSessionWorker.StateSenderCancelSend(this.a);
          paramInt = i;
        }
      }
      else
      {
        OnlineFileSessionWorker.a(this.a, 11, 6, true);
        a("StateRefuseByPC");
        this.b = new OnlineFileSessionWorker.StateRefuseByPC(this.a);
        paramInt = i;
      }
    }
    else
    {
      OnlineFileSessionWorker.a(this.a, 11, 5, true);
      a("StateAcceptByPC");
      this.b = new OnlineFileSessionWorker.StateAcceptByPC(this.a);
      paramInt = i;
    }
    if (paramInt != 0) {
      this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 0, null);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    OnlineFileSessionWorker.b(this.a);
    b(paramInt1, paramInt2);
    OnlineFileSessionWorker.a(this.a, 11, 11);
    OnlineFileSessionWorker.a(this.a, 11, 14, false);
    a("StateUploadingWhenChangeToOff");
    this.b = new OnlineFileSessionWorker.StateUploadingWhenChangeToOff(this.a);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
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
    localFileManagerEntity.setCloudType(1);
    OnlineFileSessionWorker.a(this.a, 1, -1, true);
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
  
  protected boolean d()
  {
    Object localObject = this.a.c;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("]. recvOnLineFile entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    OnlineFileSessionWorker.b(this.a, 9, 10);
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
    boolean bool = this.a.a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).nOLfileSessionId);
    if (bool)
    {
      OnlineFileSessionWorker.c(this.a, 9, 15);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append("->StateWaitResultWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.b = new OnlineFileSessionWorker.StateWaitResultWhenRecv(this.a);
    }
    else
    {
      OnlineFileSessionWorker.c(this.a, 9, 10);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append("->StateChangeToOffFailedWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.b = new OnlineFileSessionWorker.StateChangeToOffFailedWhenRecv(this.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]  failure to send recv cmd!!! ");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    }
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 10, null, 6, null);
    return bool;
  }
  
  protected void e()
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
    OnlineFileSessionWorker.a(this.a, 11, 9, true);
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 5, null);
    a("StateCancelUploadWhenRecv");
    this.b = new OnlineFileSessionWorker.StateCancelUploadWhenRecv(this.a);
  }
  
  protected void j()
  {
    if (this.a.c == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("]. onCheckIsTooLongSession entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    OnlineFileSessionWorker.a(this.a, 9, 12, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateExcepInvalidWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenRecv(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateRequest
 * JD-Core Version:    0.7.0.1
 */