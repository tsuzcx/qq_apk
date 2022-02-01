package com.tencent.treasurecard.manager;

import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;

class NetManager$3
  implements INetCallBack
{
  NetManager$3(NetManager paramNetManager, INetCallBack paramINetCallBack1, TcSdkManager paramTcSdkManager, INetCallBack paramINetCallBack2) {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      this.a.a(paramInt, "pcIdRequest is failed");
      return;
    }
    if (!(paramObject instanceof String))
    {
      this.a.a(paramInt, "pcId is error");
      return;
    }
    CacheManager localCacheManager = this.b.c();
    paramObject = (String)paramObject;
    localCacheManager.a(paramObject);
    this.d.a.b(paramObject, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.manager.NetManager.3
 * JD-Core Version:    0.7.0.1
 */