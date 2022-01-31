package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class z$a
  implements Runnable
{
  public z$a(z paramz) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, "delay send queueSize: " + z.g.size());
    }
    this.a.q = false;
    if (z.g.size() > 0) {
      while (!z.g.isEmpty())
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)z.g.poll();
        this.a.sendMsg(localToServiceMsg);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, "delay send finished queueSize: " + z.g.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.z.a
 * JD-Core Version:    0.7.0.1
 */