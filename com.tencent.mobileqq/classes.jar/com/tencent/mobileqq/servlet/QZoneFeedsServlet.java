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
      int[] arrayOfInt = new int[1];
      paramIntent = QZoneNewestFeedRequest.onResponse(paramIntent, (QQAppInterface)getAppRuntime(), arrayOfInt);
      if (paramIntent != null)
      {
        paramFromServiceMsg = new Bundle();
        paramFromServiceMsg.putSerializable("data", paramIntent);
        notifyObserver(null, 1001, true, paramFromServiceMsg, QZoneObserver.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFeedsServlet", 2, new Object[] { "inform QZoneFeedsServlet isSuccess false:", paramFromServiceMsg.getBusinessFailMsg() });
      }
      notifyObserver(null, 1001, false, new Bundle(), QZoneObserver.class);
      return;
    }
    if (paramFromServiceMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFeedsServlet", 2, "inform QZoneFeedsServlet resultcode fail.");
      }
      notifyObserver(null, 1001, false, new Bundle(), QZoneObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l1 = paramIntent.getLongExtra("selfuin", 0L);
    Object localObject1 = paramIntent.getLongArrayExtra("hostuin");
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject2).add(Long.valueOf(localObject1[i]));
      i += 1;
    }
    long l2 = paramIntent.getLongExtra("lasttime", 0L);
    i = paramIntent.getIntExtra("src", 0);
    localObject2 = new QZoneNewestFeedRequest(l1, (ArrayList)localObject2, l2, paramIntent.getStringExtra("refer"), i);
    localObject1 = ((QZoneNewestFeedRequest)localObject2).encode();
    paramIntent.putExtra("key_cmd_string", ((QZoneNewestFeedRequest)localObject2).getCmdString());
    paramIntent = (Intent)localObject1;
    if (localObject1 == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("SQQzoneSvc.");
    ((StringBuilder)localObject1).append("getAIONewestFeed");
    paramPacket.setSSOCommand(((StringBuilder)localObject1).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneFeedsServlet
 * JD-Core Version:    0.7.0.1
 */