package com.tencent.mobileqq.qqlive.runtime;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqlive.utils.QQLiveCaptureContext;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QQLiveSdkServlet
  extends MSFServlet
{
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive, cmd[");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      ((StringBuilder)localObject).append("]");
      QLog.i("QQLiveSdkServlet", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = QQLiveCaptureContext.a();
    if (localObject != null)
    {
      ((AppInterface)localObject).receiveToService(paramIntent, paramFromServiceMsg);
      return;
    }
    QLog.e("QQLiveSdkServlet", 1, "[onReceive] appInterface is null!");
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
        if (QLog.isDevelopLevel())
        {
          paramPacket = new StringBuilder();
          paramPacket.append("send, cmd[");
          paramPacket.append(paramIntent.getServiceCmd());
          paramPacket.append("]");
          QLog.i("QQLiveSdkServlet", 4, paramPacket.toString());
        }
      }
      else
      {
        QLog.e("QQLiveSdkServlet", 1, "[onSend] toMsg is null");
      }
    }
    else
    {
      QLog.e("QQLiveSdkServlet", 1, "[onSend] request is null");
    }
  }
  
  protected void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramToServiceMsg.extraData.putString("moduleId", QQLiveCaptureContext.b());
    }
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.runtime.QQLiveSdkServlet
 * JD-Core Version:    0.7.0.1
 */