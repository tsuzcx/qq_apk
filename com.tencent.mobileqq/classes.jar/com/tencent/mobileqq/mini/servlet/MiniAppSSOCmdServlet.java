package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bhjl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppSSOCmdServlet
  extends MiniAppAbstractServlet
{
  private static final String TAG = "MiniAppSSOCmdServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    boolean bool;
    if (paramFromServiceMsg != null)
    {
      bool = paramFromServiceMsg.isSuccess();
      localBundle.putParcelable("msg", paramFromServiceMsg);
    }
    for (;;)
    {
      notifyObserver(paramIntent, 0, bool, localBundle, MiniAppSSOCmdObserver.class);
      super.onReceive(paramIntent, paramFromServiceMsg);
      return;
      bool = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject = paramIntent.getByteArrayExtra("key_data");
    String str = paramIntent.getStringExtra("key_cmd_name");
    paramIntent.getStringExtra("key_appid");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("MiniAppSSOCmdServlet", 2, "onSend empty cmd name");
      return;
    }
    if (localObject == null)
    {
      QLog.e("MiniAppSSOCmdServlet", 2, new Object[] { "onSend", " business data is empty" });
      return;
    }
    byte[] arrayOfByte = new MiniAppSSOCmdServlet.1(this, (byte[])localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand(str);
    paramPacket.putSendData(bhjl.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdServlet
 * JD-Core Version:    0.7.0.1
 */