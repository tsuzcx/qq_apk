package com.tencent.mobileqq.service.discussion;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class DiscussionService
  extends BaseProtocolCoder
{
  private static String[] a = { "QQServiceDiscussSvc" };
  private DiscussionReceiver b = new DiscussionReceiver();
  private DiscussionSender c = new DiscussionSender();
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.b.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void decodeRespMsg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.c.a(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.discussion.DiscussionService
 * JD-Core Version:    0.7.0.1
 */