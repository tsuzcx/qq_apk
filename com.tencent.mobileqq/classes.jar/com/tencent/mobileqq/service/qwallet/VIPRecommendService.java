package com.tencent.mobileqq.service.qwallet;

import VipRecommend.MQQ.CommPayInfo;
import VipRecommend.MQQ.UserInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VIPRecommendService
  extends BaseProtocolCoder
{
  public String[] cmdHeaderPrefix()
  {
    return new String[] { "VipPayLogicServer" };
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("VipPayLogicServer.getCommPayInfo ".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramFromServiceMsg == null) {
        return null;
      }
      paramToServiceMsg = new UniPacket(true);
    }
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (CommPayInfo)paramToServiceMsg.getByClass("payInfo", new CommPayInfo());
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
    paramUniPacket.setServantName("MQQ.VipPayLogicServer.VipPayLogicObj");
    paramUniPacket.setFuncName("getCommPayInfo");
    paramUniPacket.put("userInfo", (UserInfo)paramToServiceMsg.extraData.getSerializable("VIPRecommendPayRequest"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.qwallet.VIPRecommendService
 * JD-Core Version:    0.7.0.1
 */