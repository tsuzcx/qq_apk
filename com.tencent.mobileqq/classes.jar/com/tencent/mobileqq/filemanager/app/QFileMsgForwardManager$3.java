package com.tencent.mobileqq.filemanager.app;

import java.util.HashMap;

class QFileMsgForwardManager$3
  implements Runnable
{
  QFileMsgForwardManager$3(QFileMsgForwardManager paramQFileMsgForwardManager, String paramString) {}
  
  public void run()
  {
    QFileMsgForwardManager.QFileUploadRequest localQFileUploadRequest;
    if (QFileMsgForwardManager.b(this.this$0).containsKey(this.a)) {
      localQFileUploadRequest = (QFileMsgForwardManager.QFileUploadRequest)QFileMsgForwardManager.b(this.this$0).get(this.a);
    } else {
      localQFileUploadRequest = null;
    }
    if (localQFileUploadRequest != null) {
      localQFileUploadRequest.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */