package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import bakc;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppOpenChannelAbstractServlet
  extends MiniAppAbstractServlet
{
  private static final String CMD_STRING = "LightAppSvc.mini_webapp.OpenChannel";
  private static final String TAG = "MiniAppOpenChannelAbstractServlet";
  
  public MiniAppOpenChannelAbstractServlet()
  {
    this.observerId = 1054;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg != null) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        localBundle.putByteArray("responsedata", bakc.b(paramFromServiceMsg.getWupBuffer()));
        notifyObserver(paramIntent, 1054, true, localBundle, MiniAppObserver.class);
      }
      for (;;)
      {
        doReport(paramIntent, paramFromServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppOpenChannelAbstractServlet", 2, "onReceive. rsp = " + paramFromServiceMsg);
        }
        notifyObserver(paramIntent, 1054, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MiniAppOpenChannelAbstractServlet", 1, localThrowable + "onReceive error");
        notifyObserver(paramIntent, 1054, false, localBundle, MiniAppObserver.class);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("key_data");
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_info.ReportLogFile");
    paramPacket.putSendData(bakc.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppOpenChannelAbstractServlet
 * JD-Core Version:    0.7.0.1
 */