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
      this.a.c().a(i);
    }
    else
    {
      i = -1;
    }
    NetManager.a(this.c, this.a, this.b, paramInt, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.manager.NetManager.1
 * JD-Core Version:    0.7.0.1
 */