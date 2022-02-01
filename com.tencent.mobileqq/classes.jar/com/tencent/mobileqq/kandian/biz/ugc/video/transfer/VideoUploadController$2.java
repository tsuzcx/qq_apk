package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class VideoUploadController$2
  extends TransProcessorHandler
{
  VideoUploadController$2(VideoUploadController paramVideoUploadController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg != null) && (localFileMsg.fileType == 24))
    {
      if (localFileMsg.commandId != 54) {
        return;
      }
      if (VideoUploadController.a(this.a) != null)
      {
        if (VideoUploadController.a(this.a).mUniseq != localFileMsg.uniseq) {
          return;
        }
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
        case 1005: 
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("mVideoTransProcessorHandler send error:");
            paramMessage.append(localFileMsg.errorCode);
            QLog.d("VideoUploadController", 2, paramMessage.toString());
          }
          VideoUploadController.a(this.a, 1004, null, null, null);
          VideoUploadController.a(this.a, null);
          return;
        case 1003: 
          this.a.a(localFileMsg);
          return;
        case 1002: 
          if (this.a.a != null)
          {
            this.a.a.a(localFileMsg.transferedSize, localFileMsg.fileSize);
            return;
          }
          break;
        case 1001: 
          VideoUploadController.a(this.a, System.currentTimeMillis());
          if (this.a.a != null) {
            this.a.a.a();
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.VideoUploadController.2
 * JD-Core Version:    0.7.0.1
 */