package com.tencent.treasurecard.manager;

import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;

class NetManager$4
  implements INetCallBack
{
  NetManager$4(NetManager paramNetManager, INetCallBack paramINetCallBack1, INetCallBack paramINetCallBack2) {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      this.a.a(paramInt, "signRequest is failed");
      return;
    }
    if (!(paramObject instanceof String))
    {
      this.a.a(paramInt, "url is error");
      return;
    }
    this.c.a.a((String)paramObject, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.manager.NetManager.4
 * JD-Core Version:    0.7.0.1
 */