package com.tencent.mobileqq.now;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class NowProtocolCoder
  extends BaseProtocolCoder
{
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    try
    {
      if ("NowChannelSvc.query".equals(paramToServiceMsg))
      {
        paramToServiceMsg = a(paramFromServiceMsg.getWupBuffer(), "rsp", new ChannelResponse());
        return paramToServiceMsg;
      }
    }
    catch (Throwable paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("NowProtocolCoder", 2, "", paramToServiceMsg);
      }
    }
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("NowChannelSvc.query".equals(str))
    {
      paramUniPacket.setServantName("Wallet.NowChannelServer.NowChannelObj");
      paramUniPacket.setFuncName("query");
      paramUniPacket.put("req", (ChannelRequest)paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    if ("NowChannelSvc.reportAction".equals(str))
    {
      paramUniPacket.setServantName("Wallet.NowChannelServer.NowChannelObj");
      paramUniPacket.setFuncName("reportAction");
      paramUniPacket.put("req", (ReportReq)paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    return false;
  }
  
  public String[] a()
  {
    return NowAppHelper.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowProtocolCoder
 * JD-Core Version:    0.7.0.1
 */