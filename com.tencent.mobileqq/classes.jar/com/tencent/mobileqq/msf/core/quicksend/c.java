package com.tencent.mobileqq.msf.core.quicksend;

import com.tencent.mobileqq.msf.core.b.a;
import com.tencent.mobileqq.msf.core.net.d.a.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class c
  implements a.a
{
  c(b paramb) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("MsfQuickUdpClient", 1, new Object[] { "[onMessageReceived] ", a.a(paramFromServiceMsg) });
    if (paramFromServiceMsg != null) {
      this.a.a(paramToServiceMsg, paramFromServiceMsg, -1);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, Exception paramException)
  {
    QLog.d("MsfQuickUdpClient", 1, new Object[] { "[onMessageFailure] ", paramToServiceMsg, ", error: ", paramException });
    if (this.a.c(paramToServiceMsg))
    {
      b.a(this.a, paramToServiceMsg);
      QLog.d("MsfQuickUdpClient", 1, new Object[] { "[onMessageFailure] resend msg: ", paramToServiceMsg });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.c
 * JD-Core Version:    0.7.0.1
 */