package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class FileManagerRSWorker$9
  implements IDownloadStatusListener
{
  FileManagerRSWorker$9(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask == null) {
      return;
    }
    if (paramBoolean)
    {
      if (paramWeiyunDownloadStatusInfo.jdField_a_of_type_Int == 2)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("WeiYun download is onStarted[");
          paramString.append(this.a.c);
          paramString.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
        return;
      }
      if (paramWeiyunDownloadStatusInfo.jdField_a_of_type_Int == 5)
      {
        if (paramWeiyunDownloadStatusInfo.jdField_b_of_type_Int == 1810002)
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("WeiYun download is canceled[");
            paramString.append(this.a.c);
            paramString.append("],set trafficData size[");
            paramString.append(this.a.jdField_a_of_type_Long);
            paramString.append("]");
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
          }
          if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {}
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 3, null, 0, null);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("WeiYun download is onFailed[");
          paramString.append(this.a.c);
          paramString.append("],set trafficData size[");
          paramString.append(this.a.jdField_a_of_type_Long);
          paramString.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
        }
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {}
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 36, null, paramWeiyunDownloadStatusInfo.jdField_b_of_type_Int, paramWeiyunDownloadStatusInfo.jdField_a_of_type_JavaLangString);
        return;
      }
      if (paramWeiyunDownloadStatusInfo.jdField_a_of_type_Int == 4)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("WeiYun download is onSucceed[");
          paramString.append(this.a.c);
          paramString.append("],set trafficData size[");
          paramString.append(this.a.jdField_a_of_type_Long);
          paramString.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramWeiyunDownloadStatusInfo.jdField_b_of_type_JavaLangString);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
        this.a.h = System.currentTimeMillis();
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {}
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 35, null, 0, null);
        paramString = new FileManagerReporter.FileAssistantReportData();
        paramString.jdField_b_of_type_JavaLangString = "rece_file_suc";
        paramString.jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
      }
    }
    else
    {
      paramLong = System.currentTimeMillis();
      this.a.jdField_a_of_type_Long = paramWeiyunDownloadStatusInfo.jdField_b_of_type_Long;
      if (paramLong - this.a.f < 1000L) {
        return;
      }
      this.a.f = paramLong;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("Id[");
        paramString.append(this.a.c);
        paramString.append("]WeiYun download is onProgressChange mtransferedSize[");
        paramString.append(this.a.jdField_a_of_type_Long);
        paramString.append("/");
        paramString.append(this.a.d);
        paramString.append("]");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.a.jdField_a_of_type_Long / (float)this.a.d);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 16, null, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.9
 * JD-Core Version:    0.7.0.1
 */