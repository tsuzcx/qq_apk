package com.tencent.mobileqq.troop.service.api.impl;

import GeneralSettings.ReqGetSettings;
import GeneralSettings.ReqHeader;
import GeneralSettings.ReqSetSettings;
import GeneralSettings.RespGetSettings;
import GeneralSettings.RespHeader;
import GeneralSettings.RespSetSettings;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.troop.service.api.IBizTroopServiceApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public class BizTroopServiceApiImpl
  extends BaseProtocolCoder
  implements IBizTroopServiceApi
{
  public static final String WUP_PROFILE_SERVANTNAME = "KQQ.ProfileService.ProfileServantObj";
  
  private Object decodeGeneralSettings(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    paramFromServiceMsg = (RespGetSettings)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetSettings", new RespGetSettings());
    if (paramToServiceMsg == null) {
      return null;
    }
    if (paramToServiceMsg.Result != 0) {
      return null;
    }
    return paramFromServiceMsg;
  }
  
  private Object decodeSetGeneralSettings(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    paramFromServiceMsg = (RespSetSettings)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetSettings", new RespSetSettings());
    if (paramToServiceMsg == null) {
      return null;
    }
    if (paramToServiceMsg.Result != 0) {
      return null;
    }
    return paramFromServiceMsg;
  }
  
  private boolean handleGetGeneralSettings(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
    paramToServiceMsg = new ReqGetSettings(paramToServiceMsg.extraData.getInt("Revision"), (ArrayList)localObject, paramToServiceMsg.extraData.getLong("Offset"), paramToServiceMsg.extraData.getLong("Count"));
    localObject = new ReqHeader(0);
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ReqGetSettings");
    paramUniPacket.put("ReqHeader", localObject);
    paramUniPacket.put("ReqGetSettings", paramToServiceMsg);
    return true;
  }
  
  private boolean handleSetGeneralSettings(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new ReqSetSettings((ArrayList)paramToServiceMsg.extraData.getSerializable("Settings"));
    ReqHeader localReqHeader = new ReqHeader(0);
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ReqSetSettings");
    paramUniPacket.put("ReqHeader", localReqHeader);
    paramUniPacket.put("ReqSetSettings", paramToServiceMsg);
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return new String[0];
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return false;
  }
  
  public Object handleDecode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("ProfileService.ReqGetSettings".equals(str)) {
      return decodeGeneralSettings(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ProfileService.ReqSetSettings".equals(str)) {
      return decodeSetGeneralSettings(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public boolean handleRequest(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("ProfileService.ReqGetSettings".equals(str)) {
      return handleGetGeneralSettings(paramToServiceMsg, paramUniPacket);
    }
    if ("ProfileService.ReqSetSettings".equals(str)) {
      return handleSetGeneralSettings(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.service.api.impl.BizTroopServiceApiImpl
 * JD-Core Version:    0.7.0.1
 */