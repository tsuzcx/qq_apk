package com.tencent.mobileqq.troop.service.api;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

@QAPI(process={"all"})
public abstract interface IBizTroopServiceApi
  extends QRouteApi
{
  public abstract Object handleDecode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract boolean handleRequest(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.service.api.IBizTroopServiceApi
 * JD-Core Version:    0.7.0.1
 */