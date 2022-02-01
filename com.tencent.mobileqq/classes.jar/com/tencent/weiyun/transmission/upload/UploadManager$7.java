package com.tencent.weiyun.transmission.upload;

import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;

class UploadManager$7
  implements ThreadPool.Job<Void>
{
  UploadManager$7(UploadManager paramUploadManager) {}
  
  public Void run(ThreadPool.JobContext paramJobContext)
  {
    try
    {
      Thread.sleep(1000L);
      label6:
      UploadManager.access$800(this.this$0);
      return null;
    }
    catch (InterruptedException paramJobContext)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadManager.7
 * JD-Core Version:    0.7.0.1
 */