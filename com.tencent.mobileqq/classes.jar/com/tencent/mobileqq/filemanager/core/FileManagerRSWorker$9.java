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
    if (this.a.U == null) {
      return;
    }
    if (paramBoolean)
    {
      if (paramWeiyunDownloadStatusInfo.a == 2)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("WeiYun download is onStarted[");
          paramString.append(this.a.r);
          paramString.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
        }
        this.a.a.getFileManagerNotifyCenter().a(this.a.q, this.a.r, this.a.f, this.a.g, 16, null, 0, null);
        return;
      }
      if (paramWeiyunDownloadStatusInfo.a == 5)
      {
        if (paramWeiyunDownloadStatusInfo.b == 1810002)
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("WeiYun download is canceled[");
            paramString.append(this.a.r);
            paramString.append("],set trafficData size[");
            paramString.append(this.a.o);
            paramString.append("]");
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
          }
          if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {}
          this.a.a.getFileManagerNotifyCenter().a(this.a.q, this.a.r, this.a.f, this.a.g, 3, null, 0, null);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("WeiYun download is onFailed[");
          paramString.append(this.a.r);
          paramString.append("],set trafficData size[");
          paramString.append(this.a.o);
          paramString.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
        }
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {}
        this.a.B.status = 0;
        this.a.B.isReaded = false;
        this.a.a.getFileManagerDataCenter().a();
        this.a.a.getFileManagerDataCenter().c(this.a.B);
        this.a.a.getFileManagerNotifyCenter().a(this.a.q, this.a.r, this.a.f, this.a.g, 36, null, paramWeiyunDownloadStatusInfo.b, paramWeiyunDownloadStatusInfo.c);
        return;
      }
      if (paramWeiyunDownloadStatusInfo.a == 4)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("WeiYun download is onSucceed[");
          paramString.append(this.a.r);
          paramString.append("],set trafficData size[");
          paramString.append(this.a.o);
          paramString.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
        }
        this.a.B.setFilePath(paramWeiyunDownloadStatusInfo.f);
        this.a.B.fProgress = 1.0F;
        this.a.B.isReaded = false;
        this.a.B.setCloudType(3);
        this.a.B.status = 1;
        this.a.B.fileName = FileManagerUtil.a(this.a.B.getFilePath());
        this.a.D = System.currentTimeMillis();
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {}
        this.a.a.getFileManagerDataCenter().c(this.a.B);
        this.a.a.getFileManagerNotifyCenter().a(this.a.q, this.a.r, this.a.f, this.a.g, 35, null, 0, null);
        paramString = new FileManagerReporter.FileAssistantReportData();
        paramString.b = "rece_file_suc";
        paramString.c = 1;
        FileManagerReporter.a(this.a.a.getCurrentAccountUin(), paramString);
      }
    }
    else
    {
      paramLong = System.currentTimeMillis();
      this.a.o = paramWeiyunDownloadStatusInfo.e;
      if (paramLong - this.a.y < 1000L) {
        return;
      }
      this.a.y = paramLong;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("Id[");
        paramString.append(this.a.r);
        paramString.append("]WeiYun download is onProgressChange mtransferedSize[");
        paramString.append(this.a.o);
        paramString.append("/");
        paramString.append(this.a.s);
        paramString.append("]");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
      }
      this.a.B.fProgress = ((float)this.a.o / (float)this.a.s);
      this.a.a.getFileManagerNotifyCenter().a(this.a.q, this.a.r, this.a.f, this.a.g, 16, null, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.9
 * JD-Core Version:    0.7.0.1
 */