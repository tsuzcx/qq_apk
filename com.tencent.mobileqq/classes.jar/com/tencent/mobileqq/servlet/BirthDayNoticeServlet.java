package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.GetBirthDayNoticeRequest;
import cooperation.vip.manager.MonitorManager;
import java.io.Serializable;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class BirthDayNoticeServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null))
    {
      int i = paramFromServiceMsg.getResultCode();
      paramIntent = new Bundle();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("servlet result code is ");
      ((StringBuilder)localObject).append(i);
      paramIntent.putString("msg", ((StringBuilder)localObject).toString());
      if (i == 1000)
      {
        paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
        localObject = GetBirthDayNoticeRequest.a(paramFromServiceMsg, new int[1]);
        if (localObject != null)
        {
          paramIntent.putInt("ret", 0);
          paramIntent.putSerializable("data", (Serializable)localObject);
          notifyObserver(null, 1009, true, paramIntent, QZoneObserver.class);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BirthDayNoticeServlet", 2, "GET_BIRTHDAY_DATA fail, decode result is null");
        }
        paramIntent.putInt("ret", -2);
        localObject = MonitorManager.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" 解包失败 ");
        localStringBuilder.append(paramFromServiceMsg);
        ((MonitorManager)localObject).a(19, 2, localStringBuilder.toString(), false);
        notifyObserver(null, 1009, false, paramIntent, QZoneObserver.class);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GET_BIRTHDAY_DATA fail, resultCode=");
        ((StringBuilder)localObject).append(i);
        QLog.d("BirthDayNoticeServlet", 2, ((StringBuilder)localObject).toString());
      }
      localObject = MonitorManager.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" 后台返回失败， 错误码 ");
      localStringBuilder.append(i);
      localStringBuilder.append(" 错误信息 ");
      localStringBuilder.append(paramFromServiceMsg.getBusinessFailMsg());
      ((MonitorManager)localObject).a(19, 3, localStringBuilder.toString(), false);
      paramIntent.putInt("ret", -3);
      notifyObserver(null, 1009, false, paramIntent, QZoneObserver.class);
      return;
    }
    Object localObject = MonitorManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" 请求失败 intent =");
    localStringBuilder.append(paramIntent);
    localStringBuilder.append("  respone= ");
    localStringBuilder.append(paramFromServiceMsg);
    ((MonitorManager)localObject).a(19, 1, localStringBuilder.toString(), false);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    GetBirthDayNoticeRequest localGetBirthDayNoticeRequest = new GetBirthDayNoticeRequest(Long.valueOf(paramIntent.getLongExtra("selfuin", 0L)).longValue(), new HashMap());
    Object localObject = localGetBirthDayNoticeRequest.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend request encode result is null.cmd=");
      paramIntent.append(localGetBirthDayNoticeRequest.uniKey());
      QLog.e("BirthDayNoticeServlet", 1, paramIntent.toString());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(localGetBirthDayNoticeRequest.uniKey());
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.BirthDayNoticeServlet
 * JD-Core Version:    0.7.0.1
 */