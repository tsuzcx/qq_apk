package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneNewestFeedRequest;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneFeedsServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent.getStringExtra("key_cmd_string");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = paramFromServiceMsg.getWupBuffer();
      arrayOfInt = new int[1];
      paramIntent = QZoneNewestFeedRequest.a(paramIntent, (QQAppInterface)getAppRuntime(), arrayOfInt);
      if (paramIntent != null)
      {
        paramFromServiceMsg = new Bundle();
        paramFromServiceMsg.putSerializable("data", paramIntent);
        notifyObserver(null, 1001, true, paramFromServiceMsg, QZoneObserver.class);
      }
    }
    while (paramFromServiceMsg == null)
    {
      int[] arrayOfInt;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFeedsServlet", 2, new Object[] { "inform QZoneFeedsServlet isSuccess false:", paramFromServiceMsg.getBusinessFailMsg() });
      }
      notifyObserver(null, 1001, false, new Bundle(), QZoneObserver.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFeedsServlet", 2, "inform QZoneFeedsServlet resultcode fail.");
    }
    notifyObserver(null, 1001, false, new Bundle(), QZoneObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {}
    long l;
    do
    {
      return;
      l = paramIntent.getLongExtra("selfuin", 0L);
      localObject1 = paramIntent.getLongArrayExtra("hostuin");
    } while (localObject1 == null);
    Object localObject2 = new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject2).add(Long.valueOf(localObject1[i]));
      i += 1;
    }
    localObject2 = new QZoneNewestFeedRequest(l, (ArrayList)localObject2, paramIntent.getLongExtra("lasttime", 0L), paramIntent.getStringExtra("refer"));
    Object localObject1 = ((QZoneNewestFeedRequest)localObject2).encode();
    paramIntent.putExtra("key_cmd_string", ((QZoneNewestFeedRequest)localObject2).getCmdString());
    if (localObject1 == null) {}
    for (paramIntent = new byte[4];; paramIntent = (Intent)localObject1)
    {
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + "getAIONewestFeed");
      paramPacket.putSendData(paramIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneFeedsServlet
 * JD-Core Version:    0.7.0.1
 */