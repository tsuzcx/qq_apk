package com.tencent.mobileqq.compatible;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class TempServlet
  extends MSFServlet
{
  public String[] getPreferSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush", "MessageSvc.RequestPushStatus", "MessageSvc.PushNotify", "MessageSvc.PushForceOffline", "ADMsgSvc.PushMsg", "MessageSvc.PushReaded", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushBindUinGroupMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", "NearFieldTranFileSvr.NotifyList", "StatSvc.SvcReqMSFLoginNotify", "baseSdk.Msf.NotifyResp", "NearFieldDiscussSvr.NotifyList", "RegPrxySvc.QueryIpwdStat", "ImStatus.ReqPushStatus", "MessageSvc.PushGroupMsg", "RegPrxySvc.PushParam", "AccostSvc.SvrMsg" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    for (;;)
    {
      if ((getAppRuntime() instanceof BaseQQAppInterface)) {
        ((AppInterface)getAppRuntime()).receiveToService(paramIntent, paramFromServiceMsg);
      }
      return;
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.compatible.TempServlet
 * JD-Core Version:    0.7.0.1
 */