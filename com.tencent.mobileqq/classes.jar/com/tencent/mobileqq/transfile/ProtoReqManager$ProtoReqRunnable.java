package com.tencent.mobileqq.transfile;

import anza;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

class ProtoReqManager$ProtoReqRunnable
  implements Runnable
{
  boolean activated = false;
  long finishTime;
  boolean finished = false;
  NewIntent intent;
  ProtoReqManager.ProtoResp resp;
  boolean scheduled = false;
  long startTime;
  long timeOut;
  
  ProtoReqManager$ProtoReqRunnable(ProtoReqManager paramProtoReqManager) {}
  
  public void run()
  {
    QLog.d("Q.richmedia.ProtoReqManager", 2, "ProtoReqRunnable.run() : resp.startTime" + this.resp.startTime);
    this.activated = true;
    this.startTime = System.currentTimeMillis();
    this.intent.putExtra("key_timeout", this.timeOut);
    anza localanza = this.resp.statisInfo;
    localanza.c += 1;
    this.this$0.requests.put(this.intent, this.resp);
    this.this$0.sendToMsf(this.intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReqRunnable
 * JD-Core Version:    0.7.0.1
 */