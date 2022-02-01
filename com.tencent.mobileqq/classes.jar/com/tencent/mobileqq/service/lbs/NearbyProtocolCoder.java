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
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { "EncounterSvc", "NeighborSvc", "VisitorSvc" };
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public UserData[] a;
  
  public NearbyProtocolCoder(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ArrayOfEncounterSvcUserData = new UserData[2];
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramFromServiceMsg, paramToServiceMsg, this);
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
      return NearbyCmdHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramToServiceMsg, paramUniPacket, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.lbs.NearbyProtocolCoder
 * JD-Core Version:    0.7.0.1
 */