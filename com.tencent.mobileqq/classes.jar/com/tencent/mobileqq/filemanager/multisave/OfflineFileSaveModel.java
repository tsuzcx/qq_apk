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
  private MessageForFile jdField_a_of_type_ComTencentMobileqqDataMessageForFile = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileManagerUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
  
  public OfflineFileSaveModel(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "init: not find the target entity.");
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("init: uniseq[");
    paramQQAppInterface.append(paramChatMessage.uniseq);
    paramQQAppInterface.append("] session[");
    paramQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    paramQQAppInterface.append("]");
    QLog.e("OfflineFileSaveModel<QFile>", 1, paramQQAppInterface.toString());
  }
  
  public long a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileSize;
    }
    return 0L;
  }
  
  public QFileControlReq a()
  {
    OfflineFileControlReq localOfflineFileControlReq = new OfflineFileControlReq(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localOfflineFileControlReq.a(new OfflineFileSaveModel.1(this));
    return localOfflineFileControlReq;
  }
  
  public String a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.getFilePath();
    }
    return "";
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "download: file entity is null.");
      return false;
    }
    int i = ((FileManagerEntity)localObject).getCloudType();
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download: uniseq[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq);
    localStringBuilder.append("] session[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return true;
    }
    QLog.e("OfflineFileSaveModel<QFile>", 1, "download: error, file status is not right.");
    return false;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq);
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "stopDownload: file entity is null.");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    return true;
  }
  
  public boolean c()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.OfflineFileSaveModel
 * JD-Core Version:    0.7.0.1
 */