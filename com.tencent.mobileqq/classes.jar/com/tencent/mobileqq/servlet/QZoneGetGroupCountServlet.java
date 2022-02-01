package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.GetQzoneGroupCountRequest;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneGetGroupCountServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      try
      {
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
          int[] arrayOfInt = new int[1];
          long l = paramIntent.getLongExtra("key_troop_uin", 0L);
          paramIntent = GetQzoneGroupCountRequest.onResponse(paramFromServiceMsg, arrayOfInt);
          if (paramIntent != null)
          {
            paramFromServiceMsg = new Bundle();
            paramFromServiceMsg.putSerializable("data", paramIntent);
            ((QZoneManagerImp)getAppRuntime().getManager(QQManagerFactory.QZONE_MANAGER)).a(String.valueOf(Long.valueOf(l)), paramIntent);
            notifyObserver(null, 1006, true, paramFromServiceMsg, QZoneObserver.class);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QZoneGetGroupCountServlet", 2, "inform QZoneGetGroupCountServlet isSuccess false");
          }
          notifyObserver(null, 1006, false, new Bundle(), QZoneObserver.class);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("QZoneGetGroupCountServlet", 1, paramIntent + "onReceive error");
        notifyObserver(null, 1006, false, new Bundle(), QZoneObserver.class);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneGetGroupCountServlet", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
    }
    notifyObserver(null, 1006, false, new Bundle(), QZoneObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l1 = paramIntent.getLongExtra("key_uin", 0L);
    long l2 = paramIntent.getLongExtra("key_troop_uin", 0L);
    GetQzoneGroupCountRequest localGetQzoneGroupCountRequest = new GetQzoneGroupCountRequest(Long.valueOf(l1).longValue(), Long.valueOf(l2).longValue(), new HashMap());
    byte[] arrayOfByte = localGetQzoneGroupCountRequest.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null)
    {
      QLog.e("NotifyQZoneServer", 1, "onSend request encode result is null.cmd=" + localGetQzoneGroupCountRequest.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(30000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "Feeds.getgroupcount");
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneGetGroupCountServlet
 * JD-Core Version:    0.7.0.1
 */