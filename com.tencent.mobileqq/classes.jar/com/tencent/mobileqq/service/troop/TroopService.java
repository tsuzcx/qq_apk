package com.tencent.mobileqq.service.troop;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class TroopService
  extends BaseProtocolCoder
{
  private static String[] a = { "QQServiceTroopSvc" };
  private TroopSender b;
  private TroopReceiver c = new TroopReceiver();
  
  public TroopService(AppInterface paramAppInterface)
  {
    this.b = new TroopSender(paramAppInterface);
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.c.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.b.a(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.troop.TroopService
 * JD-Core Version:    0.7.0.1
 */