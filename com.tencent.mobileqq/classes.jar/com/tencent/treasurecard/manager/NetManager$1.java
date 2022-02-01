package com.tencent.treasurecard.manager;

import com.tencent.treasurecard.net.INetCallBack;

class NetManager$1
  implements INetCallBack
{
  NetManager$1(NetManager paramNetManager, TcSdkManager paramTcSdkManager, INetCallBack paramINetCallBack) {}
  
  public void a(int paramInt, Object paramObject)
  {
    int i;
    if ((paramInt == 0) && ((paramObject instanceof Integer)))
    {
      i = ((Integer)paramObject).intValue();
      this.jdField_a_of_type_ComTencentTreasurecardManagerTcSdkManager.a.a(i);
    }
    else
    {
      i = -1;
    }
    this.jdField_a_of_type_ComTencentTreasurecardManagerTcSdkManager.a(paramInt, i);
    paramObject = this.jdField_a_of_type_ComTencentTreasurecardNetINetCallBack;
    if (paramObject != null) {
      paramObject.a(paramInt, Integer.valueOf(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.treasurecard.manager.NetManager.1
 * JD-Core Version:    0.7.0.1
 */