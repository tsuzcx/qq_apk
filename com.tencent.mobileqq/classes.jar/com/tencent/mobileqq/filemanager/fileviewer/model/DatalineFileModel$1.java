package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.qphone.base.util.QLog;

class DatalineFileModel$1
  extends DataLineObserver
{
  DatalineFileModel$1(DatalineFileModel paramDatalineFileModel) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    Object localObject = this.a.c.r();
    if (localObject == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DataLine onProgress : opType[");
      localStringBuilder.append(this.a.c.q());
      localStringBuilder.append("], uniseq[");
      localStringBuilder.append(((FileManagerEntity)localObject).uniseq);
      localStringBuilder.append("], nSessionId[");
      localStringBuilder.append(((FileManagerEntity)localObject).nSessionId);
      localStringBuilder.append("], peerType[");
      localStringBuilder.append(this.a.c.f());
      localStringBuilder.append("]");
      QLog.d("DatalineFileModel<FileAssistant>", 2, localStringBuilder.toString());
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
    localObject = this.a.a.getMessageFacade().d(i).a(((FileManagerEntity)localObject).uniseq);
    if (localObject == null) {
      return;
    }
    if (paramLong != ((DataLineMsgRecord)localObject).sessionid) {
      return;
    }
    if (this.a.q != null) {
      this.a.q.a(paramFloat);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.c.r();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DataLine onRecvFile : isSuccess[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], uniseq[");
      ((StringBuilder)localObject).append(localFileManagerEntity.uniseq);
      ((StringBuilder)localObject).append("], nSessionId[");
      ((StringBuilder)localObject).append(localFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("], peerType[");
      ((StringBuilder)localObject).append(this.a.c.f());
      ((StringBuilder)localObject).append("]");
      QLog.d("DatalineFileModel<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    Object localObject = this.a.a.getMessageFacade().d(i).a(localFileManagerEntity.uniseq);
    if (localObject == null) {
      return;
    }
    if (paramLong != ((DataLineMsgRecord)localObject).sessionid)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("DatalineFileModel<FileAssistant>", 1, "this recv file done is not current visit file");
      }
      return;
    }
    localFileManagerEntity.setFilePath(paramString);
    if (this.a.q != null)
    {
      if (paramBoolean)
      {
        localFileManagerEntity.status = 1;
        this.a.q.f();
        return;
      }
      localFileManagerEntity.status = 3;
      this.a.q.g();
    }
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    paramString = this.a.c.r();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DataLine onSendFile : isSuccess[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], uniseq[");
      ((StringBuilder)localObject).append(paramString.uniseq);
      ((StringBuilder)localObject).append("], nSessionId[");
      ((StringBuilder)localObject).append(paramString.nSessionId);
      ((StringBuilder)localObject).append("], peerType[");
      ((StringBuilder)localObject).append(this.a.c.f());
      ((StringBuilder)localObject).append("]");
      QLog.d("DatalineFileModel<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramString.uniseq);
    Object localObject = this.a.a.getMessageFacade().d(i).a(paramString.uniseq);
    if (localObject == null) {
      return;
    }
    if (paramLong != ((DataLineMsgRecord)localObject).sessionid)
    {
      QLog.i("DatalineFileModel<FileAssistant>", 1, "this send file done is not current visit file");
      return;
    }
    if (this.a.q != null)
    {
      if (paramBoolean)
      {
        paramString.status = 1;
        this.a.q.f();
        return;
      }
      this.a.q.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel.1
 * JD-Core Version:    0.7.0.1
 */