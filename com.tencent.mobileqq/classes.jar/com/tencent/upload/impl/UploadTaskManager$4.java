package com.tencent.upload.impl;

import com.tencent.upload.uinterface.AbstractUploadTask;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

class UploadTaskManager$4
  implements Runnable
{
  UploadTaskManager$4(UploadTaskManager paramUploadTaskManager) {}
  
  public void run()
  {
    synchronized (UploadTaskManager.access$100(this.this$0))
    {
      UploadTaskManager.access$100(this.this$0).clear();
      synchronized (UploadTaskManager.access$200(this.this$0))
      {
        Iterator localIterator = UploadTaskManager.access$200(this.this$0).iterator();
        if (localIterator.hasNext()) {
          ((AbstractUploadTask)localIterator.next()).cancel();
        }
      }
    }
    UploadTaskManager.access$200(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.impl.UploadTaskManager.4
 * JD-Core Version:    0.7.0.1
 */