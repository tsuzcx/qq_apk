package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class WebSSOAgentServlet
  extends MSFServlet
{
  public static long a;
  public static long b;
  public static long c;
  public static long d;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    c = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("WebSSOAgentServlet", 2, "onReceive");
    }
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("extra_result_code", paramFromServiceMsg.getResultCode());
      localBundle.putString("extra_result_err_msg", paramFromServiceMsg.getBusinessFailMsg());
      localBundle.putString("extra_cmd", paramIntent.getStringExtra("extra_cmd"));
      localBundle.putString("extra_callbackid", paramIntent.getStringExtra("extra_callbackid"));
      localBundle.putByteArray("extra_data", arrayOfByte);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSSOAgentServlet", 2, "onSend");
    }
    String str = paramIntent.getStringExtra("extra_cmd");
    if (str == null)
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
      return;
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("extra_data");
    paramPacket.setSSOCommand(str);
    long l = paramIntent.getLongExtra("extra_timeout", -1L);
    if (l > 0L) {
      paramPacket.setTimeout(l);
    }
    if (arrayOfByte != null)
    {
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.a(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.a(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebSSOAgentServlet
 * JD-Core Version:    0.7.0.1
 */