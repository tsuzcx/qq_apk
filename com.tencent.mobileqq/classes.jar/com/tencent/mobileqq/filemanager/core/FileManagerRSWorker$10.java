package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import com.tencent.qphone.base.util.QLog;

class FileManagerRSWorker$10
  implements IDownloadStatusListener
{
  FileManagerRSWorker$10(FileManagerRSWorker paramFileManagerRSWorker, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo, boolean paramBoolean)
  {
    paramString = ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).getWeiyunMiniappProcessName();
    Bundle localBundle;
    if (paramBoolean)
    {
      if (paramWeiyunDownloadStatusInfo.jdField_a_of_type_Int == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted");
        }
      }
      else
      {
        if (paramWeiyunDownloadStatusInfo.jdField_a_of_type_Int == 5)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is fail");
          }
          localBundle = new Bundle();
          localBundle.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
          localBundle.putInt("errorCode", paramWeiyunDownloadStatusInfo.jdField_b_of_type_Int);
          localBundle.putString("errorMsg", paramWeiyunDownloadStatusInfo.jdField_a_of_type_JavaLangString);
          QIPCServerHelper.getInstance().callClient(paramString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Fail", localBundle, null);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.c, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.e, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 36, null, paramWeiyunDownloadStatusInfo.jdField_b_of_type_Int, paramWeiyunDownloadStatusInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        if (paramWeiyunDownloadStatusInfo.jdField_a_of_type_Int == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed");
          }
          localBundle = new Bundle();
          localBundle.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
          localBundle.putString("filePath", paramWeiyunDownloadStatusInfo.jdField_b_of_type_JavaLangString);
          QIPCServerHelper.getInstance().callClient(paramString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", localBundle, null);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramWeiyunDownloadStatusInfo.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize = paramWeiyunDownloadStatusInfo.jdField_a_of_type_Long;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.c, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.e, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 35, null, 0, null);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is process");
      }
      localBundle = new Bundle();
      localBundle.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
      localBundle.putInt("progress", (int)((float)paramWeiyunDownloadStatusInfo.jdField_b_of_type_Long / (float)paramWeiyunDownloadStatusInfo.jdField_a_of_type_Long * 100.0F));
      localBundle.putLong("currSize", paramWeiyunDownloadStatusInfo.jdField_b_of_type_Long);
      localBundle.putLong("totalSize", paramWeiyunDownloadStatusInfo.jdField_a_of_type_Long);
      QIPCServerHelper.getInstance().callClient(paramString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Progress", localBundle, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.d);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.c, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.e, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 16, null, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.10
 * JD-Core Version:    0.7.0.1
 */