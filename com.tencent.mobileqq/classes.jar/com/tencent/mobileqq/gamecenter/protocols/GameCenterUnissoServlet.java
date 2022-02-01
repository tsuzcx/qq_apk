package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class GameCenterUnissoServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long l;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      ((StringBuilder)localObject).append(",success=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      QLog.d("GameCenterUnissoServlet", 2, ((StringBuilder)localObject).toString());
    }
    else
    {
      l = 0L;
    }
    Object localObject = null;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    GameCenterUnissoHandler localGameCenterUnissoHandler = GameCenterUnissoHandler.a();
    if (localGameCenterUnissoHandler != null) {
      localGameCenterUnissoHandler.a(paramIntent, paramFromServiceMsg, (byte[])localObject);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive exit|cost: ");
      paramIntent.append(System.currentTimeMillis() - l);
      QLog.d("GameCenterUnissoServlet", 2, paramIntent.toString());
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
      if (arrayOfByte != null)
      {
        paramIntent = new byte[arrayOfByte.length + 4];
        PkgTools.DWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
        PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
        paramPacket.putSendData(paramIntent);
      }
      else
      {
        paramIntent = new byte[4];
        PkgTools.DWord2Byte(paramIntent, 0, 4L);
        paramPacket.putSendData(paramIntent);
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend exit cmd=");
      paramIntent.append(str);
      QLog.d("GameCenterUnissoServlet", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoServlet
 * JD-Core Version:    0.7.0.1
 */