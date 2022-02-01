package com.tencent.treasurecard.manager;

import com.tencent.treasurecard.bean.UserInfoRsp;
import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;

class NetManager$3
  implements INetCallBack
{
  NetManager$3(NetManager paramNetManager, INetCallBack paramINetCallBack1, INetCallBack paramINetCallBack2) {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentTreasurecardNetINetCallBack.a(paramInt, "pcIdRequest is failed");
      return;
    }
    if (!(paramObject instanceof String))
    {
      this.jdField_a_of_type_ComTencentTreasurecardNetINetCallBack.a(paramInt, "userInfo is error");
      return;
    }
    paramObject = new UserInfoRsp().a((String)paramObject);
    this.jdField_a_of_type_ComTencentTreasurecardManagerNetManager.a.b(paramObject.g, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.treasurecard.manager.NetManager.3
 * JD-Core Version:    0.7.0.1
 */