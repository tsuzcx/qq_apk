package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionRsp;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QbossErrorReportServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i;
    if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    } else {
      i = -1;
    }
    if (i == 1000)
    {
      paramIntent = QbossErrorReportRequest.a(paramFromServiceMsg.getWupBuffer());
      if (paramIntent != null)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("report qboss success state = ");
          paramFromServiceMsg.append(paramIntent.iRet);
          QLog.d("QbossErrorReportServlet", 2, paramFromServiceMsg.toString());
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("QbossErrorReportServlet", 2, "report qboss exception fail, decode result is null");
      }
    }
    else if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("QZONE_GET_QBOSS_DATA fail, resultCode=");
      paramIntent.append(i);
      QLog.d("QbossErrorReportServlet", 2, paramIntent.toString());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("uin", 0L);
    int i = paramIntent.getIntExtra("appId", 0);
    int j = paramIntent.getIntExtra("taskId", 0);
    Object localObject = paramIntent.getStringExtra("message");
    QbossErrorReportRequest localQbossErrorReportRequest = new QbossErrorReportRequest(l, i, j, paramIntent.getIntExtra("code", 0), (String)localObject);
    localObject = localQbossErrorReportRequest.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend request encode result is null.cmd=");
      paramIntent.append(localQbossErrorReportRequest.uniKey());
      QLog.e("QbossErrorReportServlet", 1, paramIntent.toString());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(localQbossErrorReportRequest.uniKey());
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.impl.qboss.QbossErrorReportServlet
 * JD-Core Version:    0.7.0.1
 */