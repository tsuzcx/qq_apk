package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class OnlineFileSessionWorker$StateLocalFailedWhenChangeToOff
  extends OnlineFileSessionWorker.StateBase
{
  public OnlineFileSessionWorker$StateLocalFailedWhenChangeToOff(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateLocalFailedWhenChangeToOff";
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
    OnlineFileSessionWorker.a(this.a, 11, 12, true);
    a("StateExcepInvalidWhenChangeToOff");
    this.b = new OnlineFileSessionWorker.StateExcepInvalidWhenChangeToOff(this.a);
  }
  
  protected void a(long paramLong)
  {
    b(paramLong);
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
    localFileManagerEntity.setCloudType(1);
    OnlineFileSessionWorker.a(this.a, 11, 13, true);
    a("StateUploadoneWhenChangeToOff");
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
    FileManagerEntity localFileManagerEntity = this.a.c;
    this.a.a.getFileManagerNotifyCenter().a(this.a.c.uniseq, this.a.c.nSessionId, this.a.c.peerUin, this.a.c.peerType, 16, null, 0, null);
    return true;
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
  
  protected void m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateLocalFailedWhenChangeToOff
 * JD-Core Version:    0.7.0.1
 */