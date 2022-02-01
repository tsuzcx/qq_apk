package com.tencent.mobileqq.msf.core.net.d.a;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.b.a;
import com.tencent.mobileqq.msf.core.m.d;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class f
  implements m.d
{
  f(e parame) {}
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    MsfService.core.quicksender.b(paramToServiceMsg);
    QLog.d("MessageTimeoutFilter", 1, new Object[] { "[onTimeout] ", a.a(paramToServiceMsg) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a.f
 * JD-Core Version:    0.7.0.1
 */