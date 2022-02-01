package com.tencent.mobileqq.service;

import VIP.AIOKeyWordReq;
import VIP.AIOSendReq;
import VIP.AIOSendRes;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VIPAioSendService
  extends BaseProtocolCoder
{
  public String[] cmdHeaderPrefix()
  {
    return new String[] { "AIOSendSvc" };
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((!VIPAioSendHandler.a.equals(paramToServiceMsg.getServiceCmd())) && (!VIPAioSendHandler.b.equals(paramToServiceMsg.getServiceCmd()))) {
      return null;
    }
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (AIOSendRes)paramToServiceMsg.getByClass("response", new AIOSendRes());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      return null;
    }
    catch (Exception paramToServiceMsg) {}
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VIP.AIOSendTipsServer.AIOSendTipsObj");
    if (VIPAioSendHandler.a.equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setFuncName("CheckPopGrayStips");
      paramUniPacket.put("request", (AIOSendReq)paramToServiceMsg.extraData.getSerializable("VIPAioSendRequest"));
    }
    else if (VIPAioSendHandler.b.equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setFuncName("getUserKeyWordStips");
      paramUniPacket.put("request", (AIOKeyWordReq)paramToServiceMsg.extraData.getSerializable("VIPAioSendRequest"));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.VIPAioSendService
 * JD-Core Version:    0.7.0.1
 */