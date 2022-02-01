package com.tencent.mobileqq.service.lbs;

import EncounterSvc.UserData;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class NearbyProtocolCoder
  extends BaseProtocolCoder
{
  static String[] a = { "EncounterSvc", "NeighborSvc", "VisitorSvc" };
  public UserData[] b = new UserData[2];
  AppInterface c;
  
  public NearbyProtocolCoder(AppInterface paramAppInterface)
  {
    this.c = paramAppInterface;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this.c, paramFromServiceMsg, paramToServiceMsg, this);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this, paramFromServiceMsg, paramToServiceMsg);
    }
    if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd())) {
      NearbyCmdHelper.a(paramFromServiceMsg, paramToServiceMsg);
    }
    return super.decode(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("EncounterSvc.ReqGetEncounter".equals(str)) {
      return NearbyCmdHelper.a(this.c, paramToServiceMsg, paramUniPacket, this);
    }
    if ("NeighborSvc.ReqGetPoint".equals(str)) {
      return NearbyCmdHelper.a(this, paramToServiceMsg, paramUniPacket);
    }
    if ("VisitorSvc.ReqFavorite".equals(paramToServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.lbs.NearbyProtocolCoder
 * JD-Core Version:    0.7.0.1
 */