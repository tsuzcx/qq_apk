package com.tencent.weiyun.transmission.upload;

import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.Iterator;
import java.util.List;

class UploadManager$2
  implements ThreadPool.Job<Void>
{
  UploadManager$2(UploadManager paramUploadManager, List paramList, boolean paramBoolean) {}
  
  public Void run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.val$restartJobs.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      UploadManager localUploadManager = this.this$0;
      boolean bool = this.val$ignoreNetType;
      UploadManager.access$100(localUploadManager, l, false, false, bool, bool);
    }
    UploadManager.access$200(this.this$0, -1L, true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadManager.2
 * JD-Core Version:    0.7.0.1
 */