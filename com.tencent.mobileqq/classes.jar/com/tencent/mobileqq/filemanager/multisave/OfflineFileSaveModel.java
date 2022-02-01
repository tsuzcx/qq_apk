package com.tencent.mobileqq.filemanager.multisave;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class OfflineFileSaveModel
  extends QFileSaveModel
{
  private MessageForFile d = (MessageForFile)this.b;
  private FileManagerEntity e = FileManagerUtil.a(paramQQAppInterface, this.d);
  
  public OfflineFileSaveModel(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    if (this.e == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "init: not find the target entity.");
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("init: uniseq[");
    paramQQAppInterface.append(paramChatMessage.uniseq);
    paramQQAppInterface.append("] session[");
    paramQQAppInterface.append(this.e.nSessionId);
    paramQQAppInterface.append("]");
    QLog.e("OfflineFileSaveModel<QFile>", 1, paramQQAppInterface.toString());
  }
  
  public boolean a()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "download: file entity is null.");
      return false;
    }
    int i = ((FileManagerEntity)localObject).getCloudType();
    int j = this.e.status;
    localObject = this.e.getFilePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download: uniseq[");
    localStringBuilder.append(this.d.uniseq);
    localStringBuilder.append("] session[");
    localStringBuilder.append(this.e.nSessionId);
    localStringBuilder.append("] cloudType[");
    localStringBuilder.append(i);
    localStringBuilder.append("] status[");
    localStringBuilder.append(j);
    localStringBuilder.append("]");
    QLog.e("OfflineFileSaveModel<QFile>", 1, localStringBuilder.toString());
    if ((!FileUtils.fileExistsAndNotEmpty((String)localObject)) && (i != 0))
    {
      if (j == 3)
      {
        this.a.getFileManagerEngine().b(this.e.nSessionId);
        return true;
      }
      this.a.getFileManagerEngine().h(this.e);
      return true;
    }
    QLog.e("OfflineFileSaveModel<QFile>", 1, "download: error, file status is not right.");
    return false;
  }
  
  public boolean b()
  {
    if (this.e == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "stopDownload: file entity is null.");
      return false;
    }
    this.a.getFileManagerEngine().a(this.e.nSessionId);
    return true;
  }
  
  public String c()
  {
    FileManagerEntity localFileManagerEntity = this.e;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.getFilePath();
    }
    return "";
  }
  
  public boolean d()
  {
    FileManagerEntity localFileManagerEntity = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFileManagerEntity != null)
    {
      bool1 = bool2;
      if (localFileManagerEntity.getStatus() == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public QFileControlReq e()
  {
    OfflineFileControlReq localOfflineFileControlReq = new OfflineFileControlReq(this.e);
    localOfflineFileControlReq.a(new OfflineFileSaveModel.1(this));
    return localOfflineFileControlReq;
  }
  
  public String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.frienduin);
    localStringBuilder.append(this.d.uniseq);
    return localStringBuilder.toString();
  }
  
  public long g()
  {
    FileManagerEntity localFileManagerEntity = this.e;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileSize;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.OfflineFileSaveModel
 * JD-Core Version:    0.7.0.1
 */