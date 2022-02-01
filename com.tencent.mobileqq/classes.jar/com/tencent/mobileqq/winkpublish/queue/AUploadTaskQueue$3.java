package com.tencent.mobileqq.winkpublish.queue;

import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

class AUploadTaskQueue$3
  implements Runnable
{
  AUploadTaskQueue$3(AUploadTaskQueue paramAUploadTaskQueue) {}
  
  public void run()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.this$0.e();
    if (localCopyOnWriteArrayList != null)
    {
      int j = localCopyOnWriteArrayList.size();
      Object localObject = AUploadTaskQueue.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkRetryForOffline2Normarl taskList size:");
      localStringBuilder.append(j);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      int i = 0;
      while (i < j)
      {
        localObject = (IQueueTask)localCopyOnWriteArrayList.get(i);
        if ((AUploadTaskQueue.a(this.this$0, (IQueueTask)localObject)) && (!this.this$0.b((IQueueTask)localObject, true))) {
          this.this$0.e((IQueueTask)localObject);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue.3
 * JD-Core Version:    0.7.0.1
 */