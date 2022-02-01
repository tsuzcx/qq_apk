package com.tencent.mobileqq.transfile;

import android.content.Intent;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ProtoServlet
  extends MSFServlet
{
  public static final String KEY_BODY = "key_body";
  public static final String KEY_CMD = "key_cmd";
  public static final String KEY_FAST_RESEND_ENABLE = "key_fastresend";
  public static final String KEY_TIMEOUT = "key_timeout";
  public static final String QUICK_SEND_ENABLE = "quickSendEnable";
  public static final String QUICK_SEND_STRATEGY = "quickSendStrategy";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (("LongConn.OffPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecieve.");
      localStringBuilder.append(paramFromServiceMsg.getStringForLog());
      QLog.d("Q.richmedia.ProtoReqManager", 1, localStringBuilder.toString());
    }
    ((IProtoReqManager)getAppRuntime().getRuntimeService(IProtoReqManager.class, "")).onReceive(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      paramPacket.setSSOCommand(paramIntent.getStringExtra("key_cmd"));
      paramPacket.putSendData(paramIntent.getByteArrayExtra("key_body"));
      paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 30000L));
      boolean bool = paramIntent.getBooleanExtra("key_fastresend", false);
      paramPacket.addAttribute("fastresend", Boolean.valueOf(bool));
      paramPacket.autoResend = bool;
      paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(paramIntent.getBooleanExtra("remind_slown_network", true)));
      paramPacket.setQuickSend(paramIntent.getBooleanExtra("quickSendEnable", false), paramIntent.getIntExtra("quickSendStrategy", 0));
    }
  }
  
  protected void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend.");
      localStringBuilder.append(paramToServiceMsg.getStringForLog());
      QLog.d("Q.richmedia.ProtoReqManager", 1, localStringBuilder.toString());
    }
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoServlet
 * JD-Core Version:    0.7.0.1
 */