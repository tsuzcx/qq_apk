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
  public static String a;
  private ToServiceMsg a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GetSimpleInfoCheckUpdateItem";
  }
  
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
    Object localObject2 = null;
    getFriendInfo(this.app.getAccount());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null)
    {
      BaseProtocolCoder localBaseProtocolCoder = this.app.mqqService.lookupCoder(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
      localObject1 = localObject2;
      if (localBaseProtocolCoder != null)
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        localObject1 = localObject2;
        if (localBaseProtocolCoder.encodeReqMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localUniPacket))
        {
          localObject1 = new ReqItem();
          ((ReqItem)localObject1).eServiceID = 113;
          ((ReqItem)localObject1).vecParam = localUniPacket.encode();
        }
      }
    }
    return localObject1;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 113) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.app.getAccount(), "ProfileService.GetSimpleInfo");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.putWupBuffer(paramRespItem.vecUpdate);
      this.app.receiveToService(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localFromServiceMsg);
    }
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.profile.GetSimpleInfoCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */