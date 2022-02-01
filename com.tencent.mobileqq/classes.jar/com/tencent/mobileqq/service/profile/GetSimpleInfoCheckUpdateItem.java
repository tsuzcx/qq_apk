package com.tencent.mobileqq.service.profile;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.MobileQQServiceExtend;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class GetSimpleInfoCheckUpdateItem
  extends FriendListHandler
  implements CheckUpdateItemInterface
{
  public static String a = "GetSimpleInfoCheckUpdateItem";
  private ToServiceMsg a;
  
  public GetSimpleInfoCheckUpdateItem(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    getFriendInfo(this.app.getAccount());
    if (this.a != null)
    {
      Object localObject = this.app.mqqService.lookupCoder(this.a.getServiceCmd());
      if (localObject != null)
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        if (((BaseProtocolCoder)localObject).encodeReqMsg(this.a, localUniPacket))
        {
          localObject = new ReqItem();
          ((ReqItem)localObject).eServiceID = 113;
          ((ReqItem)localObject).vecParam = localUniPacket.encode();
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 113) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.app.getAccount(), "ProfileService.GetSimpleInfo");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.putWupBuffer(paramRespItem.vecUpdate);
      this.app.receiveToService(this.a, localFromServiceMsg);
    }
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.profile.GetSimpleInfoCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */