package com.tencent.mobileqq.wink.edit.service;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.wink.QQWinkEnvironment;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class WinkMsfServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = WinkDataServiceHandler.class.getName();
    if (paramIntent != null)
    {
      localObject2 = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("receive_handler"))) {
        localObject1 = paramIntent.getStringExtra("receive_handler");
      }
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), localObject2);
      paramIntent = (Intent)localObject2;
    }
    else
    {
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onReceive... handler:");
    ((StringBuilder)localObject2).append((String)localObject1);
    WinkQLog.a("WinkMsfServlet", ((StringBuilder)localObject2).toString());
    localObject1 = (WinkDataBaseServiceHandler)QQWinkEnvironment.c().getBusinessHandler((String)localObject1);
    ((WinkDataBaseServiceHandler)localObject1).onReceive(paramIntent, paramFromServiceMsg, ((WinkDataBaseServiceHandler)localObject1).a(paramIntent, paramFromServiceMsg));
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onSend runhw:");
      localStringBuilder.append(paramIntent);
      WinkQLog.a("WinkMsfServlet", localStringBuilder.toString());
      if (paramIntent != null)
      {
        paramPacket.setSSOCommand(paramIntent.getServiceCmd());
        paramPacket.putSendData(paramIntent.getWupBuffer());
        paramPacket.setTimeout(paramIntent.getTimeout());
        paramPacket.setAttributes(paramIntent.getAttributes());
        if (!paramIntent.isNeedCallback()) {
          paramPacket.setNoResponse();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.service.WinkMsfServlet
 * JD-Core Version:    0.7.0.1
 */