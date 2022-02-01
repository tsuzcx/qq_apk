package com.tencent.mobileqq.servlet;

import android.content.Intent;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class IPDomainGetServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ("ConfigPushSvc.GetIpDirect".equals(paramFromServiceMsg.getServiceCmd()))
    {
      BaseInnerDns.getInstance().onReceivePush(paramFromServiceMsg);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive response resultCode:");
        paramIntent.append(paramFromServiceMsg.getResultCode());
        paramIntent.append(" log:");
        paramIntent.append(paramFromServiceMsg.getStringForLog());
        QLog.i("IPDomainGet", 2, paramIntent.toString());
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IPDomainGet", 2, "IPDomainGet onSend() ");
    }
    paramPacket.setSSOCommand("ConfigPushSvc.GetIpDirect");
    paramPacket.setTimeout(15000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.IPDomainGetServlet
 * JD-Core Version:    0.7.0.1
 */