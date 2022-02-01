package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestWorker$RequestListener$4
  implements Runnable
{
  RequestWorker$RequestListener$4(RequestWorker.RequestListener paramRequestListener) {}
  
  public void run()
  {
    if (RequestWorker.RequestListener.access$200(this.this$1).isCancel.get()) {
      return;
    }
    this.this$1.this$0.engine.mConnManager.wakeupConnectionToWrite(this.this$1.this$0.mCurrentRequests, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestWorker.RequestListener.4
 * JD-Core Version:    0.7.0.1
 */