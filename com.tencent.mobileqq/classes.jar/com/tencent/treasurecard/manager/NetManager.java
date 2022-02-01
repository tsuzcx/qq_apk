package com.tencent.treasurecard.manager;

import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;
import com.tencent.xaction.log.QLog;

public class NetManager
{
  public INetRequest a;
  
  private void b(INetCallBack paramINetCallBack)
  {
    if (this.a == null)
    {
      QLog.a("TcSdkManager", 1, "IRequest not impl", null);
      return;
    }
    if (paramINetCallBack == null)
    {
      QLog.a("TcSdkManager", 1, "callBack is null", null);
      return;
    }
    paramINetCallBack = new NetManager.4(this, paramINetCallBack, new NetManager.3(this, paramINetCallBack, new NetManager.2(this, paramINetCallBack)));
    this.a.a(paramINetCallBack);
  }
  
  public void a()
  {
    INetRequest localINetRequest = this.a;
    if (localINetRequest == null)
    {
      QLog.a("TcSdkManager", 1, "IRequest not impl", null);
      return;
    }
    localINetRequest.a();
  }
  
  public void a(INetCallBack paramINetCallBack)
  {
    TcSdkManager localTcSdkManager = (TcSdkManager)TcSdkManager.a();
    localTcSdkManager.a.b(new NetManager.1(this, localTcSdkManager, paramINetCallBack));
  }
  
  public void a(INetRequest paramINetRequest)
  {
    this.a = paramINetRequest;
  }
  
  public boolean a()
  {
    return this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.treasurecard.manager.NetManager
 * JD-Core Version:    0.7.0.1
 */