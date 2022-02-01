package com.tencent.mobileqq.qwallet.report.impl;

import VACDReport.ReportReq;
import VACDReport.ReportRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class VACDReportServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg == null) || (paramIntent == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "onReceive request or response is null");
      }
    }
    while (!"QQWalletPayReportSvc.vacdReportProxy".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (ReportRsp localReportRsp = (ReportRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ReportRsp());; localReportRsp = null)
    {
      Bundle localBundle = new Bundle();
      if (localReportRsp != null) {
        localBundle.putSerializable("rsp", localReportRsp);
      }
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      notifyObserver(paramIntent, 1, paramFromServiceMsg.isSuccess(), localBundle, null);
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getExtras().getInt("cmd_type"))
    {
    default: 
      return;
    }
    try
    {
      paramPacket.addRequestPacket("req", (ReportReq)paramIntent.getSerializableExtra("req"));
      paramPacket.setSSOCommand("QQWalletPayReportSvc.vacdReportProxy");
      paramPacket.setFuncName("vacdReportProxy");
      paramPacket.setServantName("MQQ.VACDReportServer.VACDReportObj");
      paramPacket.setTimeout(15000L);
      return;
    }
    catch (OutOfMemoryError paramIntent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportServlet
 * JD-Core Version:    0.7.0.1
 */