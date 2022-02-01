package com.tencent.mobileqq.troop.filemanager;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class TroopFileProtoServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    ((QQAppInterface)getAppRuntime()).getTroopFileProtoReqMgr().a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(WupUtil.a(arrayOfByte));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    boolean bool = paramIntent.getBooleanExtra("fastresendenable", false);
    paramPacket.addAttribute("fastresend", Boolean.valueOf(bool));
    paramPacket.autoResend = bool;
    paramPacket.setQuickSend(paramIntent.getBooleanExtra("quickSendEnable", false), paramIntent.getIntExtra("quickSendStrategy", 0));
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(paramIntent.getBooleanExtra("remind_slown_network", true)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoServlet
 * JD-Core Version:    0.7.0.1
 */