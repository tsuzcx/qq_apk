package com.tencent.mobileqq.servlet;

import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QZoneApiProxyImpl;
import cooperation.qzone.GetQzonePublicMsgRequest;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

public class QzonePublicMsgServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          paramFromServiceMsg = GetQzonePublicMsgRequest.onResponse(paramFromServiceMsg.getWupBuffer(), new int[1]);
          if (paramFromServiceMsg != null)
          {
            if ((getAppRuntime() != null) && (getAppRuntime().getApplication() != null))
            {
              MobileQQ localMobileQQ = getAppRuntime().getApplication();
              if ((paramFromServiceMsg.map_ext != null) && ("1".equals(paramFromServiceMsg.map_ext.get("show_feeds"))))
              {
                bool = true;
                if (paramFromServiceMsg.map_ext == null) {
                  paramIntent = null;
                } else {
                  paramIntent = (String)paramFromServiceMsg.map_ext.get("title_name");
                }
                QZoneApiProxyImpl.recordSubFeedConfig(localMobileQQ, bool, paramIntent);
              }
            }
            else
            {
              paramIntent = new Bundle();
              paramIntent.putSerializable("data", paramFromServiceMsg);
              notifyObserver(null, 1004, true, paramIntent, QZoneObserver.class);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet isSuccess false");
            }
            notifyObserver(null, 1004, false, new Bundle(), QZoneObserver.class);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet resultcode fail.");
          }
          notifyObserver(null, 1004, false, new Bundle(), QZoneObserver.class);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append(paramIntent);
        paramFromServiceMsg.append("onReceive error");
        QLog.e("QzonePublicMsgServlet", 1, paramFromServiceMsg.toString());
        notifyObserver(null, 1004, false, new Bundle(), QZoneObserver.class);
        return;
      }
      boolean bool = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("key_uin", 0L);
    paramIntent = paramIntent.getStringExtra("has_photo");
    Object localObject = new HashMap();
    ((Map)localObject).put("has_photo", paramIntent);
    GetQzonePublicMsgRequest localGetQzonePublicMsgRequest = new GetQzonePublicMsgRequest(l, (Map)localObject);
    localObject = localGetQzonePublicMsgRequest.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend request encode result is null.cmd=");
      paramIntent.append(localGetQzonePublicMsgRequest.uniKey());
      QLog.e("NotifyQZoneServer", 1, paramIntent.toString());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(30000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(localGetQzonePublicMsgRequest.uniKey());
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QzonePublicMsgServlet
 * JD-Core Version:    0.7.0.1
 */