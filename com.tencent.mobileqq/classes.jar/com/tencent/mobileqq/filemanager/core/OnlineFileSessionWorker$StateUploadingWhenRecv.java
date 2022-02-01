package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$StateUploadingWhenRecv
  extends OnlineFileSessionWorker.StateBase
{
  public OnlineFileSessionWorker$StateUploadingWhenRecv(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateUploadingWhenRecv";
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt, String paramString)
  {
    paramString = this.a.c;
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("OLfilesession[");
      paramString.append(this.a.b);
      paramString.append("]. recvOnLineFile entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
      return;
    }
    OnlineFileSessionWorker.b(this.a, 9, 12);
    OnlineFileSessionWorker.c(this.a, 9, 12);
    this.a.a.getFileManagerNotifyCenter().a(paramString.uniseq, paramString.nSessionId, paramString.peerUin, paramString.peerType, 12, null, 5, null);
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(this.a.b);
    paramString.append("] state change :(");
    paramString.append(this.b.a());
    paramString.append("->StateExcepInvalidWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenRecv(this.a);
  }
  
  protected void a(long paramLong)
  {
    b(paramLong);
  }
  
  protected void a(boolean paramBoolean)
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
    if (paramBoolean == true)
    {
      OnlineFileSessionWorker.b(this.a);
      OnlineFileSessionWorker.b(this.a, 9, 11);
      OnlineFileSessionWorker.c(this.a, 9, 14);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("] state change :(");
      ((StringBuilder)localObject).append(this.b.a());
      ((StringBuilder)localObject).append("->StateUploadingWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.b = new StateUploadingWhenRecv(this.a);
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
    OnlineFileSessionWorker.b(this.a, 9, 11);
    OnlineFileSessionWorker.c(this.a, 9, 11);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateLocalFailedWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateLocalFailedWhenRecv(this.a);
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 6, null);
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
    OnlineFileSessionWorker.b(this.a, 11, 9);
    OnlineFileSessionWorker.c(this.a, 11, 9);
    this.a.a.getFileManagerNotifyCenter().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 12, null, 0, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(this.a.b);
    ((StringBuilder)localObject).append("] state change :(");
    ((StringBuilder)localObject).append(this.b.a());
    ((StringBuilder)localObject).append("->StateCancelUploadWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.b = new OnlineFileSessionWorker.StateCancelUploadWhenRecv(this.a);
  }
  
  protected void f()
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
    OnlineFileSessionWorker.b(this.a, 10, -2);
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
  
  protected void m()
  {
    if (b("onStop")) {
      return;
    }
    OnlineFileSessionWorker.a(this.a, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.b = new OnlineFileSessionWorker.StateLocalFailedWhenRecv(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateUploadingWhenRecv
 * JD-Core Version:    0.7.0.1
 */