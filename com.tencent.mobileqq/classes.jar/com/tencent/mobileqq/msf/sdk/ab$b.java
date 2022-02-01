package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.core.b.a;
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
    if (("LongConn.OffPicUp".equalsIgnoreCase(this.b.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(this.b.getServiceCmd())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enter MonitorTaskWrapper.run(), appseq is ");
      ((StringBuilder)localObject).append(this.b.getAppSeq());
      QLog.d("MSF.D.RemoteServiceProxy", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ToServiceMsg)ab.e.get(Integer.valueOf(this.b.getAppSeq()));
    if ((localObject != null) && (((ToServiceMsg)localObject).getAttribute("appTimeoutReq", Integer.valueOf(-1)) == this.b.getAttribute("appTimeoutReq", Integer.valueOf(-2))))
    {
      localObject = (ToServiceMsg)ab.e.remove(Integer.valueOf(this.b.getAppSeq()));
      if (localObject != null)
      {
        QLog.d("MSF.D.RemoteServiceProxy", 1, new Object[] { "found timeout req, ", a.a((ToServiceMsg)localObject) });
        localObject = this.a;
        ToServiceMsg localToServiceMsg = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b.getServiceName());
        localStringBuilder.append(" timeout");
        localObject = ((ab)localObject).a(localToServiceMsg, localStringBuilder.toString());
        this.a.a(this.b, (FromServiceMsg)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ab.b
 * JD-Core Version:    0.7.0.1
 */