package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import bguc;
import mqq.app.Packet;

public class MiniAppGetPhoneNumberServlet
  extends MiniAppAbstractServlet
{
  private static final String CMD_STRING = "LightAppSvc.mini_user_info.GetPhoneNumber";
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    super.onProcessData(paramIntent, paramBundle, paramArrayOfByte);
    paramBundle.putByteArray("data", paramArrayOfByte);
    notifyObserver(paramIntent, 1053, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.observerId = 1053;
    Object localObject = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new MiniAppGetPhoneNumberServlet.1(this, (String)localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetPhoneNumber");
    paramPacket.putSendData(bguc.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetPhoneNumberServlet
 * JD-Core Version:    0.7.0.1
 */