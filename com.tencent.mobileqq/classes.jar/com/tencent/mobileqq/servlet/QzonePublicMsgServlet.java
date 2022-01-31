package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.GetQzonePublicMsgRequest;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzonePublicMsgServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      try
      {
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          paramIntent = GetQzonePublicMsgRequest.a(paramFromServiceMsg.getWupBuffer(), new int[1]);
          if (paramIntent != null)
          {
            paramFromServiceMsg = new Bundle();
            paramFromServiceMsg.putSerializable("data", paramIntent);
            notifyObserver(null, 1004, true, paramFromServiceMsg, QZoneObserver.class);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet isSuccess false");
          }
          notifyObserver(null, 1004, false, new Bundle(), QZoneObserver.class);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("QzonePublicMsgServlet", 1, paramIntent + "onReceive error");
        notifyObserver(null, 1004, false, new Bundle(), QZoneObserver.class);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet resultcode fail.");
    }
    notifyObserver(null, 1004, false, new Bundle(), QZoneObserver.class);
    if (paramFromServiceMsg != null) {}
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    GetQzonePublicMsgRequest localGetQzonePublicMsgRequest = new GetQzonePublicMsgRequest(Long.valueOf(paramIntent.getLongExtra("key_uin", 0L)).longValue(), new HashMap());
    byte[] arrayOfByte = localGetQzonePublicMsgRequest.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null)
    {
      QLog.e("NotifyQZoneServer", 1, "onSend request encode result is null.cmd=" + localGetQzonePublicMsgRequest.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(30000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localGetQzonePublicMsgRequest.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QzonePublicMsgServlet
 * JD-Core Version:    0.7.0.1
 */