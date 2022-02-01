package com.tencent.mobileqq.troop.troopmanager.api.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class TroopManagerBizHandler$PbServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess()) {
      arrayOfByte = WupUtil.b(paramFromServiceMsg.getWupBuffer());
    } else {
      arrayOfByte = null;
    }
    new Bundle().putByteArray("data", arrayOfByte);
    Object localObject = getAppRuntime();
    if ((localObject instanceof AppInterface))
    {
      localObject = (TroopManagerBizHandler)((AppInterface)localObject).getBusinessHandler(TroopManagerBizHandler.class.getName());
      if (localObject != null) {
        ((TroopManagerBizHandler)localObject).a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(WupUtil.a(arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler.PbServlet
 * JD-Core Version:    0.7.0.1
 */