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
      if (paramWeiyunDownloadStatusInfo.a == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted");
        }
      }
      else
      {
        if (paramWeiyunDownloadStatusInfo.a == 5)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is fail");
          }
          localBundle = new Bundle();
          localBundle.putString("taskId", this.a.miniAppDownloadId);
          localBundle.putInt("errorCode", paramWeiyunDownloadStatusInfo.b);
          localBundle.putString("errorMsg", paramWeiyunDownloadStatusInfo.c);
          QIPCServerHelper.getInstance().callClient(paramString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Fail", localBundle, null);
          this.b.B.status = 0;
          this.b.B.isReaded = false;
          this.b.a.getFileManagerDataCenter().a();
          this.b.a.getFileManagerDataCenter().c(this.b.B);
          this.b.a.getFileManagerNotifyCenter().a(this.b.q, this.b.r, this.b.f, this.b.g, 36, null, paramWeiyunDownloadStatusInfo.b, paramWeiyunDownloadStatusInfo.c);
          return;
        }
        if (paramWeiyunDownloadStatusInfo.a == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed");
          }
          localBundle = new Bundle();
          localBundle.putString("taskId", this.a.miniAppDownloadId);
          localBundle.putString("filePath", paramWeiyunDownloadStatusInfo.f);
          QIPCServerHelper.getInstance().callClient(paramString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", localBundle, null);
          this.b.B.setFilePath(paramWeiyunDownloadStatusInfo.f);
          this.b.B.fProgress = 1.0F;
          this.b.B.isReaded = false;
          this.b.B.setCloudType(3);
          this.b.B.status = 1;
          this.b.B.fileName = FileManagerUtil.a(this.b.B.getFilePath());
          this.b.B.fileSize = paramWeiyunDownloadStatusInfo.d;
          this.b.a.getFileManagerDataCenter().c(this.b.B);
          this.b.a.getFileManagerNotifyCenter().a(this.b.q, this.b.r, this.b.f, this.b.g, 35, null, 0, null);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is process");
      }
      localBundle = new Bundle();
      localBundle.putString("taskId", this.a.miniAppDownloadId);
      localBundle.putInt("progress", (int)((float)paramWeiyunDownloadStatusInfo.e / (float)paramWeiyunDownloadStatusInfo.d * 100.0F));
      localBundle.putLong("currSize", paramWeiyunDownloadStatusInfo.e);
      localBundle.putLong("totalSize", paramWeiyunDownloadStatusInfo.d);
      QIPCServerHelper.getInstance().callClient(paramString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Progress", localBundle, null);
      this.b.B.fProgress = ((float)this.b.o / (float)this.b.s);
      this.b.a.getFileManagerNotifyCenter().a(this.b.q, this.b.r, this.b.f, this.b.g, 16, null, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.10
 * JD-Core Version:    0.7.0.1
 */