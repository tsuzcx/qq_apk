package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.WupUtil;
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
        localBundle.putByteArray("responsedata", WupUtil.b(paramFromServiceMsg.getWupBuffer()));
        notifyObserver(paramIntent, 1054, true, localBundle, MiniAppObserver.class);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("onReceive. rsp = ");
          localStringBuilder1.append(paramFromServiceMsg);
          QLog.d("MiniAppOpenChannelAbstractServlet", 2, localStringBuilder1.toString());
        }
        notifyObserver(paramIntent, 1054, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(localThrowable);
      localStringBuilder2.append("onReceive error");
      QLog.e("MiniAppOpenChannelAbstractServlet", 1, localStringBuilder2.toString());
      notifyObserver(paramIntent, 1054, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("key_data");
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_webapp.OpenChannel");
    paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppOpenChannelAbstractServlet
 * JD-Core Version:    0.7.0.1
 */