package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$StateUploadingWhenChangeToOff
  extends OnlineFileSessionWorker.StateBase
{
  public OnlineFileSessionWorker$StateUploadingWhenChangeToOff(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateUploadingWhenChangeToOff";
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
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
    OnlineFileSessionWorker.b(this.a, 11, 12);
    OnlineFileSessionWorker.c(this.a, 11, 12);
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(this.a.b);
    paramString.append("] state change :(");
    paramString.append(this.b.a());
    paramString.append("->StateExcepInvalidWhenChangeToOff");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenChangeToOff(this.a);
  }
  
  protected void a(long paramLong)
  {
    b(paramLong);
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
    OnlineFileSessionWorker.b(this.a, 11, 13);
    OnlineFileSessionWorker.c(this.a, 11, 13);
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(this.a.b);
    paramString.append("] state change :(");
    paramString.append(this.b.a());
    paramString.append("->StateUploadoneWhenChangeToOff)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
    this.a.a.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.b = new OnlineFileSessionWorker.StateUploadoneWhenChangeToOff(this.a);
    return true;
  }
  
  protected boolean d()
  {
    if (b("onRecvOnLineFile")) {
      return false;
    }
    OnlineFileSessionWorker.a(this.a, 9, 11);
    OnlineFileSessionWorker.a(this.a, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.b = new OnlineFileSessionWorker.StateUploadingWhenRecv(this.a);
    return true;
  }
  
  protected void e()
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
    OnlineFileSessionWorker.b(this.a, 11, 9);
    OnlineFileSessionWorker.c(this.a, 11, 9);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateCancelUploadWhenRecv)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateCancelUploadWhenRecv(this.a);
  }
  
  protected void m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateUploadingWhenChangeToOff
 * JD-Core Version:    0.7.0.1
 */