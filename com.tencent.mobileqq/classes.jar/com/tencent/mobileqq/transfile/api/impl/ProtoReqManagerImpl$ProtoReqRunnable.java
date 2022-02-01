package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

public class ProtoReqManagerImpl$ProtoReqRunnable
  implements Runnable
{
  boolean activated = false;
  long finishTime;
  boolean finished = false;
  NewIntent intent;
  ProtoReqManagerImpl.ProtoResp resp;
  boolean scheduled = false;
  long startTime;
  long timeOut;
  
  public ProtoReqManagerImpl$ProtoReqRunnable(ProtoReqManagerImpl paramProtoReqManagerImpl) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ProtoReqRunnable.run() : resp.startTime");
    ((StringBuilder)localObject).append(this.resp.startTime);
    QLog.d("Q.richmedia.ProtoReqManager", 2, ((StringBuilder)localObject).toString());
    this.activated = true;
    this.startTime = System.currentTimeMillis();
    this.intent.putExtra("key_timeout", this.timeOut);
    localObject = this.resp.statisInfo;
    ((StatictisInfo)localObject).c += 1;
    this.this$0.requests.put(this.intent, this.resp);
    this.this$0.sendToMsf(this.intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReqRunnable
 * JD-Core Version:    0.7.0.1
 */