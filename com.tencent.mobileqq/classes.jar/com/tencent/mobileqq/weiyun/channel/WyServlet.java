package com.tencent.mobileqq.weiyun.channel;

import android.content.Intent;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public final class WyServlet
  extends MSFServlet
{
  private static void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getWupBuffer() != null)
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      if (i < 0) {
        return;
      }
      byte[] arrayOfByte = new byte[i];
      PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      paramFromServiceMsg.putWupBuffer(arrayOfByte);
    }
  }
  
  private static void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l = paramToServiceMsg.getWupBuffer().length;
      int i = (int)l;
      byte[] arrayOfByte = new byte[i + 4];
      PkgTools.dWord2Byte(arrayOfByte, 0, l + 4L);
      PkgTools.copyData(arrayOfByte, 4, paramToServiceMsg.getWupBuffer(), i);
      paramToServiceMsg.putWupBuffer(arrayOfByte);
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "WeiyunV2Svc.TransCmd" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    a(paramFromServiceMsg);
    if (paramIntent == null)
    {
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
    else
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    WySender.a().a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null)
    {
      QLog.e("WyServlet", 1, "onSend : req is null");
      return;
    }
    paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
    if (paramIntent != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSend : cmd[");
        localStringBuilder.append(paramIntent.getServiceCmd());
        localStringBuilder.append("]");
        QLog.d("WyServlet", 1, localStringBuilder.toString());
      }
      a(paramIntent);
      paramPacket.setSSOCommand("WeiyunV2Svc.TransCmd");
      paramPacket.putSendData(paramIntent.getWupBuffer());
      paramPacket.setTimeout(paramIntent.getTimeout());
      paramPacket.setAttributes(paramIntent.getAttributes());
      if (!paramIntent.isNeedCallback()) {
        paramPacket.setNoResponse();
      }
    }
    else
    {
      QLog.e("WyServlet", 1, "onSend : toMsg is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.channel.WyServlet
 * JD-Core Version:    0.7.0.1
 */