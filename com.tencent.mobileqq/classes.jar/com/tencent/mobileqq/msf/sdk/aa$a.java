package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class aa$a
  implements Runnable
{
  public aa$a(aa paramaa) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, "delay send queueSize: " + aa.g.size());
    }
    this.a.q = false;
    if (aa.g.size() > 0) {
      while (!aa.g.isEmpty())
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)aa.g.poll();
        this.a.sendMsg(localToServiceMsg);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, "delay send finished queueSize: " + aa.g.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.aa.a
 * JD-Core Version:    0.7.0.1
 */