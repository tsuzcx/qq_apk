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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delay send queueSize: ");
      ((StringBuilder)localObject).append(ab.f.size());
      QLog.d("MSF.D.RemoteServiceProxy", 2, ((StringBuilder)localObject).toString());
    }
    this.a.p = false;
    if (ab.f.size() > 0) {
      while (!ab.f.isEmpty())
      {
        localObject = (ToServiceMsg)ab.f.poll();
        this.a.sendMsg((ToServiceMsg)localObject);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delay send finished queueSize: ");
      ((StringBuilder)localObject).append(ab.f.size());
      QLog.d("MSF.D.RemoteServiceProxy", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ab.a
 * JD-Core Version:    0.7.0.1
 */