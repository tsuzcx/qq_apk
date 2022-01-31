package com.tencent.weiyun.transmission.upload;

import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.Iterator;
import java.util.List;

class UploadManager$3
  implements ThreadPool.Job<Void>
{
  UploadManager$3(UploadManager paramUploadManager, List paramList) {}
  
  public Void run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.val$suspendJobs.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      UploadManager.access$300(this.this$0, l);
      UploadManager.access$200(this.this$0, l, false);
    }
    UploadManager.access$200(this.this$0, -1L, true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadManager.3
 * JD-Core Version:    0.7.0.1
 */