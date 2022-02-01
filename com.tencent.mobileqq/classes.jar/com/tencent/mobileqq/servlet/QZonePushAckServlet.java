package com.tencent.mobileqq.servlet;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneMsfPushAckRequest;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZonePushAckServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l = paramIntent.getLongExtra("timestamp", 0L);
    Object localObject = new QZoneMsfPushAckRequest(paramIntent.getLongExtra("hostuin", 0L), l, paramIntent.getStringExtra("refer"), paramIntent.getLongExtra("flag", 0L), paramIntent.getStringExtra("mark")).encode();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append("wns.pushrsp");
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
    paramIntent = new StringBuilder();
    paramIntent.append("发送push ack 时间:");
    paramIntent.append(l);
    QLog.d("MessageSvc.WNSQzone.Push", 2, paramIntent.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZonePushAckServlet
 * JD-Core Version:    0.7.0.1
 */