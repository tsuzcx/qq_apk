package com.tencent.mobileqq.filemanager.core;

import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

class FileManagerRSWorker$12
  implements Runnable
{
  FileManagerRSWorker$12(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("running OfflineFileHitReq:");
      ((StringBuilder)localObject).append(MessageCache.c());
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new OfflineFileUploadPara();
    ((OfflineFileUploadPara)localObject).a = this.this$0.f;
    ((OfflineFileUploadPara)localObject).b = this.this$0.s;
    FileManagerRSWorker localFileManagerRSWorker = this.this$0;
    localFileManagerRSWorker.l = FileManagerUtil.g(localFileManagerRSWorker.c);
    localFileManagerRSWorker = this.this$0;
    localFileManagerRSWorker.G = FileManagerUtil.d(localFileManagerRSWorker.c);
    localFileManagerRSWorker = this.this$0;
    localFileManagerRSWorker.H = FileManagerUtil.f(localFileManagerRSWorker.c);
    if ((this.this$0.l != null) && (this.this$0.G != null) && (this.this$0.H != null))
    {
      this.this$0.B.strFileSha3 = HexUtil.bytes2HexStr(this.this$0.H);
      this.this$0.B.str10Md5 = HexUtil.bytes2HexStr(this.this$0.l);
      ((OfflineFileUploadPara)localObject).g = this.this$0.l;
      ((OfflineFileUploadPara)localObject).i = this.this$0.G;
      ((OfflineFileUploadPara)localObject).j = this.this$0.H;
      try
      {
        ((OfflineFileUploadPara)localObject).f = FileManagerUtil.a(this.this$0.c).getBytes("utf-8");
        ((OfflineFileUploadPara)localObject).e = this.this$0.c.getBytes("utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      this.this$0.a.getFileTransferHandler().b((OfflineFileUploadPara)localObject, FileManagerRSWorker.e(this.this$0), this.this$0.B);
      return;
    }
    this.this$0.a(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.12
 * JD-Core Version:    0.7.0.1
 */