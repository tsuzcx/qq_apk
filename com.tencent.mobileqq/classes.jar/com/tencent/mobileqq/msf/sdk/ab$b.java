package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ab$b
  implements Runnable
{
  private ToServiceMsg b;
  
  public ab$b(ab paramab, ToServiceMsg paramToServiceMsg)
  {
    this.b = paramToServiceMsg;
  }
  
  public void run()
  {
    if (("LongConn.OffPicUp".equalsIgnoreCase(this.b.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(this.b.getServiceCmd()))) {
      QLog.d("MSF.D.RemoteServiceProxy", 1, "enter MonitorTaskWrapper.run(), appseq is " + this.b.getAppSeq());
    }
    Object localObject = (ToServiceMsg)ab.f.get(Integer.valueOf(this.b.getAppSeq()));
    if ((localObject != null) && (((ToServiceMsg)localObject).getAttribute("appTimeoutReq", Integer.valueOf(-1)) == this.b.getAttribute("appTimeoutReq", Integer.valueOf(-2))) && ((ToServiceMsg)ab.f.remove(Integer.valueOf(this.b.getAppSeq())) != null))
    {
      QLog.d("MSF.D.RemoteServiceProxy", 1, "found timeout req, appseq is " + this.b.getAppSeq());
      localObject = this.a.a(this.b, this.b.getServiceName() + " timeout");
      this.a.a(this.b, (FromServiceMsg)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ab.b
 * JD-Core Version:    0.7.0.1
 */