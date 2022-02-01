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
    UploadLog.d("UploadTaskManager", "remove task, flowId: " + this.val$out.flowId + ", path:" + this.val$out.uploadFilePath);
    for (;;)
    {
      Iterator localIterator;
      synchronized (UploadTaskManager.access$100(this.this$0))
      {
        localIterator = UploadTaskManager.access$100(this.this$0).iterator();
        if (!localIterator.hasNext()) {
          break label228;
        }
        AbstractUploadTask localAbstractUploadTask1 = (AbstractUploadTask)localIterator.next();
        if (localAbstractUploadTask1.flowId != this.val$out.flowId) {
          continue;
        }
        if (localAbstractUploadTask1 != null)
        {
          UploadTaskManager.access$100(this.this$0).remove(localAbstractUploadTask1);
          return;
        }
      }
      for (;;)
      {
        synchronized (UploadTaskManager.access$200(this.this$0))
        {
          localIterator = UploadTaskManager.access$200(this.this$0).iterator();
          if (localIterator.hasNext())
          {
            AbstractUploadTask localAbstractUploadTask2 = (AbstractUploadTask)localIterator.next();
            if (localAbstractUploadTask2.flowId != this.val$out.flowId) {
              continue;
            }
            if (localAbstractUploadTask2 != null)
            {
              UploadTaskManager.access$200(this.this$0).remove(localAbstractUploadTask2);
              localAbstractUploadTask2.cancel();
            }
            UploadTaskManager.access$000(this.this$0);
            return;
          }
        }
        localObject3 = null;
      }
      label228:
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.impl.UploadTaskManager.3
 * JD-Core Version:    0.7.0.1
 */