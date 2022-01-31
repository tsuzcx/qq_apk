package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;

class ShortVideoUploadProcessor$TimeoutRunnable
  implements Runnable
{
  public volatile boolean a;
  
  ShortVideoUploadProcessor$TimeoutRunnable(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void run()
  {
    if (!this.a) {
      synchronized (this.this$0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> PreUpload timeout");
        }
        ShortVideoUploadProcessor.a(this.this$0, 2);
        ShortVideoUploadProcessor.c(this.this$0, 2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.TimeoutRunnable
 * JD-Core Version:    0.7.0.1
 */