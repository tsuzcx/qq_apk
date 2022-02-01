package com.tencent.mobileqq.msf.core.net.d.a;

import com.tencent.mobileqq.msf.core.b.a;
import com.tencent.mobileqq.msf.core.i;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class m
  implements d
{
  private static final String a = "UdpSwitchFilter";
  
  public ToServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UdpSwitchFilter", 2, new Object[] { "[filter] udp switch: ", Boolean.valueOf(i.a().k()), a.a(paramToServiceMsg) });
    }
    if (!i.a().k()) {
      return null;
    }
    return paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a.m
 * JD-Core Version:    0.7.0.1
 */