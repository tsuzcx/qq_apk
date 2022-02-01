package com.tencent.mobileqq.filemanager.app;

import java.util.HashMap;

class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    QFileMsgForwardManager.QFileUploadRequest localQFileUploadRequest = null;
    if (QFileMsgForwardManager.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localQFileUploadRequest = (QFileMsgForwardManager.QFileUploadRequest)QFileMsgForwardManager.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localQFileUploadRequest != null)
    {
      localQFileUploadRequest.b();
      localQFileUploadRequest.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */