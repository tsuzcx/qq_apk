package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

class TaskManager$14$1
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    TaskManager.a(this.c.b, paramNetResp, this.a, this.b, this.c.a);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager.14.1
 * JD-Core Version:    0.7.0.1
 */