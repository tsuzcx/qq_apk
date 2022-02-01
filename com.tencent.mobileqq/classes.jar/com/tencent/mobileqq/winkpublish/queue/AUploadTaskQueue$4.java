package com.tencent.mobileqq.winkpublish.queue;

import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.NetworkState;
import java.util.concurrent.CopyOnWriteArrayList;

class AUploadTaskQueue$4
  implements Runnable
{
  AUploadTaskQueue$4(AUploadTaskQueue paramAUploadTaskQueue) {}
  
  public void run()
  {
    if (!NetworkState.isNetSupport()) {
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.this$0.e();
    if (localCopyOnWriteArrayList != null)
    {
      int j = localCopyOnWriteArrayList.size();
      Object localObject = AUploadTaskQueue.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkRetry taskList size:");
      localStringBuilder.append(j);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      int i = 0;
      while (i < j)
      {
        localObject = (IQueueTask)localCopyOnWriteArrayList.get(i);
        if (!this.this$0.b((IQueueTask)localObject, true)) {
          this.this$0.e((IQueueTask)localObject);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue.4
 * JD-Core Version:    0.7.0.1
 */