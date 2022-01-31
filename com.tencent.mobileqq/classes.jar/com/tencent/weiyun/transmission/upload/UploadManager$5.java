package com.tencent.weiyun.transmission.upload;

import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.HashSet;
import java.util.Iterator;

class UploadManager$5
  implements ThreadPool.Job<Void>
{
  UploadManager$5(UploadManager paramUploadManager, HashSet paramHashSet) {}
  
  public Void run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.val$failedJobs.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      UploadManager.access$100(this.this$0, l, false, false, false, false);
    }
    UploadManager.access$200(this.this$0, -1L, true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadManager.5
 * JD-Core Version:    0.7.0.1
 */