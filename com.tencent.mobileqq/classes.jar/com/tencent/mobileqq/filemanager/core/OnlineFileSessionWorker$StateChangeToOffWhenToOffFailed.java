package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class OnlineFileSessionWorker$StateChangeToOffWhenToOffFailed
  extends OnlineFileSessionWorker.StateBase
{
  public OnlineFileSessionWorker$StateChangeToOffWhenToOffFailed(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateChangeToOffWhenToOffFailed";
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
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
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (b("onSenderUploadCompleted")) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = this.a.c;
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((FileManagerUtil.c(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.a.a.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    this.a.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    OnlineFileSessionWorker.a(this.a, 1, 0, true);
    a("StateGotoOffFileProcess");
    this.a.a.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.b = new OnlineFileSessionWorker.StateGotoOffFileProcess(this.a);
    return true;
  }
  
  protected void b()
  {
    if (b("onResumeTrans")) {
      return;
    }
    OnlineFileSessionWorker.a(this.a, 9, 11);
    OnlineFileSessionWorker.a(this.a, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.b = new OnlineFileSessionWorker.StateUploadingWhenRecv(this.a);
    this.a.a(true, 0L);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateChangeToOffWhenToOffFailed
 * JD-Core Version:    0.7.0.1
 */