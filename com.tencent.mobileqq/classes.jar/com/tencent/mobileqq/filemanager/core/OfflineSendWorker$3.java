package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class OfflineSendWorker$3
  extends FileTransferObserver
{
  OfflineSendWorker$3(OfflineSendWorker paramOfflineSendWorker) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [CC Replay] nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      OfflineSendWorker.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      OfflineSendWorker.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild retCode:" + paramLong1);
      OfflineSendWorker.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild retCode:" + paramLong1);
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      OfflineSendWorker.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      OfflineSendWorker.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      OfflineSendWorker.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null)
    {
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a() > 0) {
        localObject1 = "ChanedUrlCount[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a() + "]";
      }
    }
    this.a.b((String)localObject1);
    ForwardOrderManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3);
  }
  
  public void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, StatictisInfo paramStatictisInfo)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      OfflineSendWorker.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      int i = 9045;
      if (-100001 == paramFileUploadInfo.jdField_a_of_type_Int) {
        i = 9043;
      }
      OfflineSendWorker.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      OfflineSendWorker.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [SetFileStatus Step]Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, OfflineSendWorker.a(this.a));
  }
  
  public void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, StatictisInfo paramStatictisInfo, List<String> paramList)
  {
    if (this.a.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "=_= ^! Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    if (!paramBoolean)
    {
      OfflineSendWorker.a(this.a, paramFileUploadInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if (OfflineSendWorker.a(this.a, paramFileUploadInfo))
    {
      OfflineSendWorker.b(this.a, paramFileUploadInfo);
      return;
    }
    OfflineSendWorker.a(this.a, paramFileUploadInfo, paramList);
  }
  
  public void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, StatictisInfo paramStatictisInfo, List<String> paramList)
  {
    if (this.a.a()) {}
    while (paramFileUploadInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (paramFileUploadInfo.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(paramFileUploadInfo.jdField_a_of_type_ArrayOfByte);
      this.a.b();
      this.a.b = true;
      OfflineSendWorker.a(this.a);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineSendWorker.3
 * JD-Core Version:    0.7.0.1
 */