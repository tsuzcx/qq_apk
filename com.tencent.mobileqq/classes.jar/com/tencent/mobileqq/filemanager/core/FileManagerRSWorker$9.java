package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.sdk.download.DownloadJobContext.StatusInfo;
import cooperation.weiyun.sdk.download.WyDownloader.IDownloadStatusListener;

class FileManagerRSWorker$9
  implements WyDownloader.IDownloadStatusListener
{
  FileManagerRSWorker$9(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, DownloadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
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
        if (paramStatusInfo.jdField_a_of_type_Int == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted[" + this.a.c + "]");
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
          return;
        }
        if (paramStatusInfo.jdField_a_of_type_Int == 5)
        {
          if (paramStatusInfo.jdField_b_of_type_Int == 1810002)
          {
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is canceled[" + this.a.c + "],set trafficData size[" + this.a.jdField_a_of_type_Long + "]");
            }
            if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
            for (;;)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 3, null, 0, null);
              return;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onFailed[" + this.a.c + "],set trafficData size[" + this.a.jdField_a_of_type_Long + "]");
          }
          if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
          for (;;)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 36, null, paramStatusInfo.jdField_b_of_type_Int, paramStatusInfo.jdField_a_of_type_JavaLangString);
            return;
          }
        }
      } while (paramStatusInfo.jdField_a_of_type_Int != 4);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed[" + this.a.c + "],set trafficData size[" + this.a.jdField_a_of_type_Long + "]");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramStatusInfo.jdField_b_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      this.a.h = System.currentTimeMillis();
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 35, null, 0, null);
        paramString = new FileManagerReporter.FileAssistantReportData();
        paramString.jdField_b_of_type_JavaLangString = "rece_file_suc";
        paramString.jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
        return;
      }
      paramLong = System.currentTimeMillis();
      this.a.jdField_a_of_type_Long = paramStatusInfo.jdField_b_of_type_Long;
    } while (paramLong - this.a.f < 1000L);
    this.a.f = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.a.c + "]WeiYun download is onProgressChange mtransferedSize[" + this.a.jdField_a_of_type_Long + "/" + this.a.d + "]");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.a.jdField_a_of_type_Long / (float)this.a.d);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.9
 * JD-Core Version:    0.7.0.1
 */