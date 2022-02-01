package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.core.WeiyunDownloadService;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.sdk.download.DownloadJobContext.StatusInfo;
import cooperation.weiyun.sdk.download.WyDownloader.IDownloadStatusListener;

class FileManagerRSWorker$10
  implements WyDownloader.IDownloadStatusListener
{
  FileManagerRSWorker$10(FileManagerRSWorker paramFileManagerRSWorker, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, DownloadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramStatusInfo.jdField_a_of_type_Int == 2) {
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted");
        }
      }
      do
      {
        return;
        if (paramStatusInfo.jdField_a_of_type_Int == 5)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is fail");
          }
          paramString = new Bundle();
          paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
          paramString.putInt("errorCode", paramStatusInfo.jdField_b_of_type_Int);
          paramString.putString("errorMsg", paramStatusInfo.jdField_a_of_type_JavaLangString);
          QIPCServerHelper.getInstance().callClient(WeiyunDownloadService.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Fail", paramString, null);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.c, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.e, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 36, null, paramStatusInfo.jdField_b_of_type_Int, paramStatusInfo.jdField_a_of_type_JavaLangString);
          return;
        }
      } while (paramStatusInfo.jdField_a_of_type_Int != 4);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed");
      }
      paramString = new Bundle();
      paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
      paramString.putString("filePath", paramStatusInfo.jdField_b_of_type_JavaLangString);
      QIPCServerHelper.getInstance().callClient(WeiyunDownloadService.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", paramString, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramStatusInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize = paramStatusInfo.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.c, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.e, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 35, null, 0, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is process");
    }
    paramString = new Bundle();
    paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
    paramString.putInt("progress", (int)((float)paramStatusInfo.jdField_b_of_type_Long / (float)paramStatusInfo.jdField_a_of_type_Long * 100.0F));
    paramString.putLong("currSize", paramStatusInfo.jdField_b_of_type_Long);
    paramString.putLong("totalSize", paramStatusInfo.jdField_a_of_type_Long);
    QIPCServerHelper.getInstance().callClient(WeiyunDownloadService.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Progress", paramString, null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.d);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.c, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.e, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.10
 * JD-Core Version:    0.7.0.1
 */