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
    if (this.a.U == null) {
      return;
    }
    if (paramBoolean)
    {
      if (paramStatusInfo.state == 3)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("WeiYun upload is onStarted[");
          paramString.append(this.a.r);
          paramString.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
        }
        this.a.a.getFileManagerNotifyCenter().a(this.a.q, this.a.r, this.a.f, this.a.g, 16, null, 0, null);
        return;
      }
      if (paramStatusInfo.state == 6)
      {
        if (paramStatusInfo.errorCode == 1810002)
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("WeiYun upload is canceled[");
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
          paramString.append("WeiYun upload is onFailed[");
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
        this.a.a.getFileManagerNotifyCenter().a(this.a.q, this.a.r, this.a.f, this.a.g, 38, null, paramStatusInfo.errorCode, paramStatusInfo.errorMsg);
        return;
      }
      if (paramStatusInfo.state == 5)
      {
        this.a.U.a(paramStatusInfo.fileId);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("WeiYun upload is onSucceed[");
          paramString.append(this.a.r);
          paramString.append("],set trafficData size[");
          paramString.append(this.a.s);
          paramString.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
        }
        this.a.B.WeiYunFileId = paramStatusInfo.fileId;
        if (paramStatusInfo.jobContext != null)
        {
          this.a.B.WeiYunDirKey = paramStatusInfo.jobContext.file().pDirKey;
          this.a.B.strFileSHA = paramStatusInfo.jobContext.file().sha;
          if (!TextUtils.isEmpty(paramStatusInfo.jobContext.file().thumbUrl)) {
            this.a.B.strLargeThumPath = paramStatusInfo.jobContext.file().thumbUrl;
          }
        }
        this.a.B.fProgress = 1.0F;
        this.a.B.setCloudType(2);
        this.a.B.status = 1;
        this.a.B.isReaded = false;
        this.a.D = System.currentTimeMillis();
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {}
        this.a.a.getFileManagerDataCenter().c(this.a.B);
        this.a.a.getFileManagerNotifyCenter().a(this.a.q, this.a.r, this.a.f, this.a.g, 37, null, 0, null);
        paramString = new FileManagerReporter.FileAssistantReportData();
        paramString.b = "send_file_suc";
        paramString.c = 1;
        FileManagerReporter.a(this.a.a.getCurrentAccountUin(), paramString);
      }
    }
    else
    {
      paramLong = System.currentTimeMillis();
      this.a.o = paramStatusInfo.currSize;
      this.a.s = paramStatusInfo.totalSize;
      if (paramLong - this.a.y < 1000L) {
        return;
      }
      this.a.y = paramLong;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("Id[");
        paramString.append(this.a.r);
        paramString.append("]WeiYun upload is onProgressChange mtransferedSize[");
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.11
 * JD-Core Version:    0.7.0.1
 */