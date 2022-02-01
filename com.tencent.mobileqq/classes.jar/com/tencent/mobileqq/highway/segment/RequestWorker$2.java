package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.concurrent.ConcurrentHashMap;

class RequestWorker$2
  implements Runnable
{
  RequestWorker$2(RequestWorker paramRequestWorker, int paramInt1, HwRequest paramHwRequest, int paramInt2) {}
  
  public void run()
  {
    if (!this.this$0.engine.mConnManager.connections.containsKey(Integer.valueOf(this.val$connId))) {
      return;
    }
    RequestWorker.access$100(this.this$0, this.val$heartBreak);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnConnIdle: SendHeartBreak : ");
    localStringBuilder.append(this.val$heartBreak.dumpBaseInfo());
    localStringBuilder.append(" size:");
    localStringBuilder.append(this.this$0.mCurrentRequests);
    localStringBuilder.append(" delay:");
    localStringBuilder.append(this.val$delay);
    BdhLogUtil.LogEvent("N", localStringBuilder.toString());
    this.this$0.engine.mConnManager.heartBreaks.remove(Integer.valueOf(this.val$connId));
    this.this$0.engine.mConnManager.wakeupConnectionToWrite(this.this$0.mCurrentRequests, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestWorker.2
 * JD-Core Version:    0.7.0.1
 */