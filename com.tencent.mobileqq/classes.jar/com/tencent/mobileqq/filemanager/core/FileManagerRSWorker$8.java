package com.tencent.mobileqq.filemanager.core;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class FileManagerRSWorker$8
  implements Runnable
{
  FileManagerRSWorker$8(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Running RSWorker:");
      ((StringBuilder)localObject).append(MessageCache.c());
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("run task sessionid[");
      ((StringBuilder)localObject).append(String.valueOf(this.this$0.r));
      ((StringBuilder)localObject).append("],");
      ((StringBuilder)localObject).append(" actionType[");
      ((StringBuilder)localObject).append(String.valueOf(this.this$0.n));
      ((StringBuilder)localObject).append("], ");
      ((StringBuilder)localObject).append("strUin[");
      ((StringBuilder)localObject).append(this.this$0.f);
      if (((StringBuilder)localObject).toString() != null)
      {
        localObject = FileManagerUtil.k(this.this$0.f);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("null], filePath[");
        ((StringBuilder)localObject).append(this.this$0.c);
        if (((StringBuilder)localObject).toString() != null)
        {
          localObject = this.this$0.c;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("null], uniseq[");
          ((StringBuilder)localObject).append(String.valueOf(this.this$0.q));
          ((StringBuilder)localObject).append("]");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, (String)localObject);
    }
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      this.this$0.a(0);
      this.this$0.a.getFileManagerNotifyCenter().a(this.this$0.q, this.this$0.r, this.this$0.f, this.this$0.g, 1, null, 2, null);
      FileManagerUtil.a(this.this$0.a, this.this$0.B.nSessionId, this.this$0.K, this.this$0.C, FileManagerRSWorker.a(this.this$0), this.this$0.f, this.this$0.i, this.this$0.B.strFileMd5, 9004L, "", 0L, 0L, this.this$0.s, "", "", FileManagerRSWorker.b(this.this$0), "NoNetWork", null);
      FileManagerUtil.a(this.this$0.a, this.this$0.B.nSessionId, this.this$0.L, this.this$0.C, FileManagerRSWorker.a(this.this$0), this.this$0.f, this.this$0.i, this.this$0.B.strFileMd5, 9004L, "", 0L, 0L, this.this$0.s, "", "", FileManagerRSWorker.c(this.this$0), "NoNetWork", null);
      return;
    }
    this.this$0.C = System.currentTimeMillis();
    Object localObject = this.this$0;
    ((FileManagerRSWorker)localObject).Q = 0L;
    ((FileManagerRSWorker)localObject).B.status = 2;
    int i = this.this$0.n;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 5)
        {
          if (i != 6)
          {
            if (i != 8)
            {
              if (i != 50) {
                break label669;
              }
              FileManagerRSWorker.d(this.this$0);
              break label669;
            }
          }
          else
          {
            this.this$0.o();
            break label669;
          }
        }
        else
        {
          this.this$0.n();
          break label669;
        }
      }
      localObject = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject).b = "rece_file_number";
      FileManagerReporter.a(this.this$0.a.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
      this.this$0.d();
    }
    else
    {
      localObject = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject).b = "send_file_number";
      FileManagerReporter.a(this.this$0.a.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
      this.this$0.s();
    }
    label669:
    this.this$0.a.getFileManagerNotifyCenter().a(true, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.8
 * JD-Core Version:    0.7.0.1
 */