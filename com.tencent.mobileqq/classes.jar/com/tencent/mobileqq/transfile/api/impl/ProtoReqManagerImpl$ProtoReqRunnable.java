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
    QLog.d("Q.richmedia.ProtoReqManager", 2, "ProtoReqRunnable.run() : resp.startTime" + this.resp.startTime);
    this.activated = true;
    this.startTime = System.currentTimeMillis();
    this.intent.putExtra("key_timeout", this.timeOut);
    StatictisInfo localStatictisInfo = this.resp.statisInfo;
    localStatictisInfo.c += 1;
    this.this$0.requests.put(this.intent, this.resp);
    this.this$0.sendToMsf(this.intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReqRunnable
 * JD-Core Version:    0.7.0.1
 */