package com.tencent.upload.impl;

import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.utils.UploadLog;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

class UploadTaskManager$3
  implements Runnable
{
  UploadTaskManager$3(UploadTaskManager paramUploadTaskManager, AbstractUploadTask paramAbstractUploadTask) {}
  
  public void run()
  {
    if (this.val$out == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("remove task, flowId: ");
    ((StringBuilder)localObject1).append(this.val$out.flowId);
    ((StringBuilder)localObject1).append(", path:");
    ((StringBuilder)localObject1).append(this.val$out.uploadFilePath);
    UploadLog.d("UploadTaskManager", ((StringBuilder)localObject1).toString());
    label245:
    Object localObject4;
    label250:
    synchronized (UploadTaskManager.access$100(this.this$0))
    {
      Iterator localIterator = UploadTaskManager.access$100(this.this$0).iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label245;
        }
        localObject1 = (AbstractUploadTask)localIterator.next();
        if (((AbstractUploadTask)localObject1).flowId == this.val$out.flowId) {
          break;
        }
      }
      if (localObject1 != null)
      {
        UploadTaskManager.access$100(this.this$0).remove(localObject1);
        return;
      }
      synchronized (UploadTaskManager.access$200(this.this$0))
      {
        localIterator = UploadTaskManager.access$200(this.this$0).iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label250;
          }
          localObject1 = (AbstractUploadTask)localIterator.next();
          if (((AbstractUploadTask)localObject1).flowId == this.val$out.flowId) {
            break;
          }
        }
        if (localObject1 != null)
        {
          UploadTaskManager.access$200(this.this$0).remove(localObject1);
          ((AbstractUploadTask)localObject1).cancel();
        }
        UploadTaskManager.access$000(this.this$0);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.impl.UploadTaskManager.3
 * JD-Core Version:    0.7.0.1
 */