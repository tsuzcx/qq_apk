package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.tMobileQbossFeedBackInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QbossReportServlet
  extends MSFServlet
{
  private tMobileQbossFeedBackInfo a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, int paramInt3)
  {
    tMobileQbossFeedBackInfo localtMobileQbossFeedBackInfo = new tMobileQbossFeedBackInfo();
    localtMobileQbossFeedBackInfo.uiUin = paramLong;
    localtMobileQbossFeedBackInfo.sQBosstrace = paramString1;
    localtMobileQbossFeedBackInfo.iOperType = paramInt1;
    localtMobileQbossFeedBackInfo.iOperSource = paramInt2;
    localtMobileQbossFeedBackInfo.sQua = paramString3;
    localtMobileQbossFeedBackInfo.sUserID = paramString2;
    localtMobileQbossFeedBackInfo.iOperTimes = paramInt3;
    return localtMobileQbossFeedBackInfo;
  }
  
  private ArrayList<tMobileQbossFeedBackInfo> a(String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, int paramInt2)
  {
    paramString1 = a(paramString1, paramInt1, 2, paramString2, paramLong, paramString3, paramInt2);
    paramString2 = new ArrayList(1);
    paramString2.add(paramString1);
    return paramString2;
  }
  
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
    QLog.d("QbossReportServlet", 2, "qboss onReceive onSend");
    if (i == 1000)
    {
      paramFromServiceMsg = QbossReportRequest.a(paramFromServiceMsg.getWupBuffer());
      if (paramFromServiceMsg != null)
      {
        paramIntent.putInt("ret", 0);
        paramIntent.putSerializable("data", paramFromServiceMsg);
        QLog.d("QbossReportServlet", 2, "qboss onReceive ret");
        notifyObserver(null, 1008, true, paramIntent, QZoneObserver.class);
        return;
      }
      QLog.d("QbossReportServlet", 2, "qboss onReceive ok");
      if (QLog.isColorLevel()) {
        QLog.d("QbossReportServlet", 2, "QZONE_REPORT_QBOSS fail, decode result is null");
      }
      paramIntent.putInt("ret", -2);
      notifyObserver(null, 1008, false, paramIntent, QZoneObserver.class);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("QZONE_REPORT_QBOSS fail, resultCode=");
      paramFromServiceMsg.append(i);
      QLog.d("QbossReportServlet", 2, paramFromServiceMsg.toString());
    }
    QLog.d("QbossReportServlet", 2, "qboss onReceive not ok");
    paramIntent.putInt("ret", -3);
    notifyObserver(null, 1008, false, paramIntent, QZoneObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("sQBosstrace");
    int i = paramIntent.getIntExtra("iOperType", 0);
    Object localObject2 = paramIntent.getStringExtra("sUserID");
    long l = paramIntent.getLongExtra("uin", 0L);
    String str = paramIntent.getStringExtra("qua");
    int j = paramIntent.getIntExtra("times", 1);
    QLog.d("QbossReportServlet", 2, "qboss onSend");
    localObject2 = new QbossReportRequest(a((String)localObject1, i, (String)localObject2, l, str, j));
    localObject1 = ((QbossReportRequest)localObject2).encode();
    paramIntent = (Intent)localObject1;
    if (localObject1 == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend request encode result is null.cmd=");
      paramIntent.append(((QbossReportRequest)localObject2).uniKey());
      QLog.e("QbossReportServlet", 1, paramIntent.toString());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("SQQzoneSvc.");
    ((StringBuilder)localObject1).append(((QbossReportRequest)localObject2).uniKey());
    paramPacket.setSSOCommand(((StringBuilder)localObject1).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.impl.qboss.QbossReportServlet
 * JD-Core Version:    0.7.0.1
 */