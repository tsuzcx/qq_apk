package com.tencent.mobileqq.olympic;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class OlympicToolServlet
  extends MSFServlet
{
  public String[] getPreferSSOCommands()
  {
    return null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    else
    {
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive: ");
      localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
      QLog.i("OlympicToolServlet", 4, localStringBuilder.toString());
    }
    ((OlympicToolAppInterface)getAppRuntime()).receiveToService(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (paramIntent != null)
      {
        paramPacket.setSSOCommand(paramIntent.getServiceCmd());
        paramPacket.putSendData(paramIntent.getWupBuffer());
        paramPacket.setTimeout(paramIntent.getTimeout());
        paramPacket.setAttributes(paramIntent.getAttributes());
        if (!paramIntent.isNeedCallback()) {
          paramPacket.setNoResponse();
        }
        if (QLog.isDevelopLevel())
        {
          paramPacket = new StringBuilder();
          paramPacket.append("send: ");
          paramPacket.append(paramIntent.getServiceCmd());
          QLog.i("OlympicToolServlet", 4, paramPacket.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolServlet
 * JD-Core Version:    0.7.0.1
 */