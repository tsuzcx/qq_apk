package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneGetQbossServlet
  extends MSFServlet
{
  private String a;
  private ArrayList<Integer> b;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i;
    if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    } else {
      i = -1;
    }
    paramIntent = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("servlet result code is ");
    localStringBuilder.append(i);
    paramIntent.putString("msg", localStringBuilder.toString());
    paramIntent.putString("requestType", this.a);
    paramIntent.putIntegerArrayList("appid", this.b);
    if (i == 1000)
    {
      paramFromServiceMsg = GetQbossRequest.a(paramFromServiceMsg.getWupBuffer());
      if (paramFromServiceMsg != null)
      {
        paramIntent.putInt("ret", 0);
        paramIntent.putSerializable("data", paramFromServiceMsg);
        notifyObserver(null, 1007, true, paramIntent, QZoneObserver.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneGetQbossServlet", 2, "QZONE_GET_QBOSS_DATA fail, decode result is null");
      }
      paramIntent.putInt("ret", -2);
      notifyObserver(null, 1007, false, paramIntent, QZoneObserver.class);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("QZONE_GET_QBOSS_DATA fail, resultCode=");
      paramFromServiceMsg.append(i);
      QLog.d("QzoneGetQbossServlet", 2, paramFromServiceMsg.toString());
    }
    paramIntent.putInt("ret", -3);
    notifyObserver(null, 1007, false, paramIntent, QZoneObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("selfuin", 0L);
    Object localObject = paramIntent.getIntegerArrayListExtra("appid");
    boolean bool = paramIntent.getBooleanExtra("needReport", false);
    this.a = paramIntent.getStringExtra("requestType");
    this.b = ((ArrayList)localObject);
    if (localObject == null) {
      return;
    }
    GetQbossRequest localGetQbossRequest = new GetQbossRequest(Long.valueOf(l).longValue(), (ArrayList)localObject, bool);
    localObject = localGetQbossRequest.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend request encode result is null.cmd=");
      paramIntent.append(localGetQbossRequest.uniKey());
      QLog.e("QzoneGetQbossServlet", 1, paramIntent.toString());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(localGetQbossRequest.uniKey());
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QzoneGetQbossServlet
 * JD-Core Version:    0.7.0.1
 */