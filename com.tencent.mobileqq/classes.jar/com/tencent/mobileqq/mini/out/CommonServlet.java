package com.tencent.mobileqq.mini.out;

import android.content.Intent;
import android.os.Bundle;
import bakc;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class CommonServlet
  extends MSFServlet
{
  public static final int GET_MAP_POI_LIST = 1;
  public static final int GET_USER_LOCATION = 2;
  public static final String IS_PB_PACKET = "is_pb_packet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str;
    boolean bool;
    Bundle localBundle;
    if (paramIntent != null)
    {
      str = paramFromServiceMsg.getServiceCmd();
      bool = paramFromServiceMsg.isSuccess();
      ToServiceMsg localToServiceMsg = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      localBundle = new Bundle();
      localBundle.putParcelable("req", localToServiceMsg);
      if ((bool) && (((Boolean)localToServiceMsg.getAttribute("is_pb_packet", Boolean.FALSE)).booleanValue())) {
        paramFromServiceMsg.putWupBuffer(bakc.b(paramFromServiceMsg.getWupBuffer()));
      }
      localBundle.putParcelable("rsp", paramFromServiceMsg);
      if (!"LbsShareSvr.location".equals(str)) {
        break label111;
      }
      notifyObserver(paramIntent, 1, bool, localBundle, CommonObserver.class);
    }
    label111:
    while (!"NeighborSvc.ReqGetPoint".equals(str)) {
      return;
    }
    notifyObserver(paramIntent, 2, bool, localBundle, CommonObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (paramIntent != null)
      {
        String str = paramIntent.getServiceCmd();
        paramPacket.setTimeout(paramIntent.getTimeout());
        paramPacket.setAttributes(paramIntent.getAttributes());
        paramPacket.setSSOCommand(str);
        if (!((Boolean)paramIntent.getAttribute("is_pb_packet", Boolean.FALSE)).booleanValue()) {
          break label88;
        }
        paramPacket.putSendData(bakc.a(paramIntent.getWupBuffer()));
      }
    }
    for (;;)
    {
      if (!paramIntent.isNeedCallback()) {
        paramPacket.setNoResponse();
      }
      return;
      label88:
      paramPacket.putSendData(paramIntent.getWupBuffer());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.CommonServlet
 * JD-Core Version:    0.7.0.1
 */