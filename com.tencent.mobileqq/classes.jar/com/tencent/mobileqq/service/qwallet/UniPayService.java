package com.tencent.mobileqq.service.qwallet;

import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class UniPayService
  extends BaseProtocolCoder
{
  public String[] cmdHeaderPrefix()
  {
    return new String[] { "VipSTCheckServer" };
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (UniPayResponse)paramToServiceMsg.getByClass("stResponse", new UniPayResponse());
      return paramToServiceMsg;
    }
    catch (RuntimeException|Exception paramToServiceMsg) {}
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.VipSTCheckServer.VipSTCheckObj");
    paramUniPacket.setFuncName("mobileUniPayCheck");
    paramUniPacket.put("stRequest", (UniPayRequest)paramToServiceMsg.extraData.getSerializable("UniPayRequest"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.qwallet.UniPayService
 * JD-Core Version:    0.7.0.1
 */