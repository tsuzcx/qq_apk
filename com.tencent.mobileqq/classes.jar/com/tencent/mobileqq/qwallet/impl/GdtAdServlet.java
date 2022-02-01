package com.tencent.mobileqq.qwallet.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class GdtAdServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onReceive] cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      ((StringBuilder)localObject).append(",success=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject).append(", retCode=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      QLog.d("GdtAdServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("extra_result_code", paramFromServiceMsg.getResultCode());
    localBundle.putString("cmd", paramIntent.getStringExtra("cmd"));
    localBundle.putByteArray("data", (byte[])localObject);
    notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(l);
    paramPacket.putSendData(arrayOfByte);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("[onSend] cmd=");
      paramIntent.append(str);
      QLog.d("GdtAdServlet", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.GdtAdServlet
 * JD-Core Version:    0.7.0.1
 */