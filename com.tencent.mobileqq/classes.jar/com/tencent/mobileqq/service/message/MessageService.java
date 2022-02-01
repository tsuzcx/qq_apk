package com.tencent.mobileqq.service.message;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MessageService
  extends BaseProtocolCoder
{
  private static String[] a = { "MessageSvc", "TransService", "StreamSvr", "ADMsgSvc", "VideoSvc", "VideoCCSvc", "OnlinePush", "KQQGroupPic", "AccostSvc", "SecretFileSvc", "MultiVideo" };
  private MessageFactorySender b = new MessageFactorySender();
  private MessageFactoryReceiver c = new MessageFactoryReceiver();
  
  public MessageService()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.b.a(localAppRuntime);
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.c.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void destroy()
  {
    this.b = null;
    this.c = null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.b.a(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageService
 * JD-Core Version:    0.7.0.1
 */