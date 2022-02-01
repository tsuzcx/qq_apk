package com.tencent.mobileqq.filemanager.app;

import java.util.HashMap;

class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    QFileMsgForwardManager.QFileUploadRequest localQFileUploadRequest;
    if (QFileMsgForwardManager.b(this.this$0).containsKey(Long.valueOf(this.a))) {
      localQFileUploadRequest = (QFileMsgForwardManager.QFileUploadRequest)QFileMsgForwardManager.b(this.this$0).get(Long.valueOf(this.a));
    } else {
      localQFileUploadRequest = null;
    }
    if (localQFileUploadRequest != null)
    {
      localQFileUploadRequest.b();
      localQFileUploadRequest.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */