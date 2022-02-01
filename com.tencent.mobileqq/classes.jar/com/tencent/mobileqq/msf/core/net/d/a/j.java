package com.tencent.mobileqq.msf.core.net.d.a;

import com.tencent.qphone.base.remote.ToServiceMsg;

public class j
  implements d
{
  public ToServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    if (paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbSendMsg")) {
      paramToServiceMsg.setNeedCallback(true);
    }
    return paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a.j
 * JD-Core Version:    0.7.0.1
 */