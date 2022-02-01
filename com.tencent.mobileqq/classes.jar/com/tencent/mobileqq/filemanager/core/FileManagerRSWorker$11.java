package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanageraux.core.WeiyunTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;

class FileManagerRSWorker$11
  implements UploadManager.IUploadStatusListener
{
  FileManagerRSWorker$11(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void onUploadJobAdded(String paramString, long paramLong) {}
  
  public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        if (paramStatusInfo.state == 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onStarted[" + this.a.c + "]");
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
          return;
        }
        if (paramStatusInfo.state == 6)
        {
          if (paramStatusInfo.errorCode == 1810002)
          {
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is canceled[" + this.a.c + "],set trafficData size[" + this.a.jdField_a_of_type_Long + "]");
            }
            if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
            for (;;)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 3, null, 0, null);
              return;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onFailed[" + this.a.c + "],set trafficData size[" + this.a.jdField_a_of_type_Long + "]");
          }
          if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
          for (;;)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 38, null, paramStatusInfo.errorCode, paramStatusInfo.errorMsg);
            return;
          }
        }
      } while (paramStatusInfo.state != 5);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask.a(paramStatusInfo.fileId);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onSucceed[" + this.a.c + "],set trafficData size[" + this.a.d + "]");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId = paramStatusInfo.fileId;
      if (paramStatusInfo.jobContext != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunDirKey = paramStatusInfo.jobContext.file().pDirKey;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = paramStatusInfo.jobContext.file().sha;
        if (!TextUtils.isEmpty(paramStatusInfo.jobContext.file().thumbUrl)) {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramStatusInfo.jobContext.file().thumbUrl;
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(2);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.a.h = System.currentTimeMillis();
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 37, null, 0, null);
        paramString = new FileManagerReporter.FileAssistantReportData();
        paramString.b = "send_file_suc";
        paramString.jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
        return;
      }
      paramLong = System.currentTimeMillis();
      this.a.jdField_a_of_type_Long = paramStatusInfo.currSize;
      this.a.d = paramStatusInfo.totalSize;
    } while (paramLong - this.a.f < 1000L);
    this.a.f = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.a.c + "]WeiYun upload is onProgressChange mtransferedSize[" + this.a.jdField_a_of_type_Long + "/" + this.a.d + "]");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.a.jdField_a_of_type_Long / (float)this.a.d);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.b, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.11
 * JD-Core Version:    0.7.0.1
 */