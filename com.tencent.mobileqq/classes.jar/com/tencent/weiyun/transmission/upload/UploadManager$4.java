package com.tencent.weiyun.transmission.upload;

import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.HashSet;
import java.util.Iterator;

class UploadManager$4
  implements ThreadPool.Job<Void>
{
  UploadManager$4(UploadManager paramUploadManager, HashSet paramHashSet) {}
  
  public Void run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.val$failedJobs.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      UploadManager.access$400(this.this$0, l);
      UploadManager.access$200(this.this$0, l, false);
    }
    UploadManager.access$200(this.this$0, -1L, true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadManager.4
 * JD-Core Version:    0.7.0.1
 */