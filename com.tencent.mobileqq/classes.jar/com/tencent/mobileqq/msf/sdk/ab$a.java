package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ab$a
  implements Runnable
{
  public ab$a(ab paramab) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, "delay send queueSize: " + ab.g.size());
    }
    this.a.q = false;
    if (ab.g.size() > 0) {
      while (!ab.g.isEmpty())
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)ab.g.poll();
        this.a.sendMsg(localToServiceMsg);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, "delay send finished queueSize: " + ab.g.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ab.a
 * JD-Core Version:    0.7.0.1
 */