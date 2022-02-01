package com.tencent.mobileqq.gamecenter.protocol;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class GameCenterUnissoServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long l = 0L;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      QLog.d("GameCenterUnissoServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
    }
    byte[] arrayOfByte = null;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    GameCenterUnissoHandler localGameCenterUnissoHandler = GameCenterUnissoHandler.a();
    if (localGameCenterUnissoHandler != null) {
      localGameCenterUnissoHandler.a(paramIntent, paramFromServiceMsg, arrayOfByte);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterUnissoServlet", 2, "onReceive exit|cost: " + (System.currentTimeMillis() - l));
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    if (!TextUtils.isEmpty(str))
    {
      paramPacket.setSSOCommand(str);
      paramPacket.setTimeout(l);
      if (arrayOfByte == null) {
        break label117;
      }
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.DWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterUnissoServlet", 2, "onSend exit cmd=" + str);
      }
      return;
      label117:
      paramIntent = new byte[4];
      PkgTools.DWord2Byte(paramIntent, 0, 4L);
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoServlet
 * JD-Core Version:    0.7.0.1
 */