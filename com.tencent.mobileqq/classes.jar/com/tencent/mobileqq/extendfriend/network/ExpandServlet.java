package com.tencent.mobileqq.extendfriend.network;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ExpandServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable(ToServiceMsg.class.getSimpleName(), paramIntent);
      localBundle.putParcelable(FromServiceMsg.class.getSimpleName(), paramFromServiceMsg);
      ((ExtendFriendManager)ExtendFriendManager.a().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a().a(paramIntent, paramFromServiceMsg);
      return;
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
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
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.network.ExpandServlet
 * JD-Core Version:    0.7.0.1
 */