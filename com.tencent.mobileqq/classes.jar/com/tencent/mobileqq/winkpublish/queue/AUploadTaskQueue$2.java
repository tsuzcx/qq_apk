package com.tencent.mobileqq.winkpublish.queue;

import com.tencent.qphone.base.util.QLog;

class AUploadTaskQueue$2
  implements Runnable
{
  AUploadTaskQueue$2(AUploadTaskQueue paramAUploadTaskQueue) {}
  
  public void run()
  {
    QLog.i(AUploadTaskQueue.a, 1, "checkRetryForOffline");
    AUploadTaskQueue.a(this.this$0);
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue.2
 * JD-Core Version:    0.7.0.1
 */