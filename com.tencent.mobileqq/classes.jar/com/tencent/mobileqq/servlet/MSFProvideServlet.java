package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppConstants.Action;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class MSFProvideServlet
  extends MSFServlet
  implements AppConstants
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AppConstants.Action localAction = (AppConstants.Action)paramIntent.getSerializableExtra("action");
    Bundle localBundle = paramIntent.getExtras();
    if (MSFProvideServlet.1.a[localAction.ordinal()] != 1) {
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("info", (String)paramFromServiceMsg.getAttribute("App_NerworkTrafficDebugInfo"));
      notifyObserver(paramIntent, 0, true, localBundle, null);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket = (AppConstants.Action)paramIntent.getSerializableExtra("action");
    if (MSFProvideServlet.1.a[paramPacket.ordinal()] != 1) {
      return;
    }
    sendToMSF(paramIntent, MsfMsgUtil.getNetworkTrafficDebugInfo(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.MSFProvideServlet
 * JD-Core Version:    0.7.0.1
 */