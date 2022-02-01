package com.tencent.treasurecard.manager;

import android.text.TextUtils;
import com.tencent.treasurecard.bean.TreasureCard;
import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;
import com.tencent.xaction.log.QLog;

public class NetManager
{
  public INetRequest a;
  
  private void a(TcSdkManager paramTcSdkManager, INetCallBack paramINetCallBack, int paramInt1, int paramInt2)
  {
    paramTcSdkManager.a(paramInt1, paramInt2);
    if (paramINetCallBack != null) {
      paramINetCallBack.a(paramInt1, Integer.valueOf(paramInt2));
    }
    paramTcSdkManager.d().b();
  }
  
  private boolean a(String paramString)
  {
    if (this.a == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" mRequestImpl is null");
      QLog.a("TcSdkManager", 1, localStringBuilder.toString(), null);
      return true;
    }
    return false;
  }
  
  private void b(INetCallBack paramINetCallBack)
  {
    Object localObject = (TcSdkManager)TcSdkManager.b();
    NetManager.2 local2 = new NetManager.2(this, paramINetCallBack);
    paramINetCallBack = new NetManager.4(this, paramINetCallBack, new NetManager.3(this, paramINetCallBack, (TcSdkManager)localObject, local2));
    localObject = ((TcSdkManager)localObject).c().b();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.a.b((String)localObject, local2);
      return;
    }
    this.a.a(paramINetCallBack);
  }
  
  public void a(INetCallBack paramINetCallBack)
  {
    if (a("queryCardInfo")) {
      return;
    }
    TcSdkManager localTcSdkManager = (TcSdkManager)TcSdkManager.b();
    if (!this.a.b())
    {
      a(localTcSdkManager, paramINetCallBack, 1002, 0);
      QLog.a("TcSdkManager", 1, "not mobile operator On Request", null);
      return;
    }
    if (a())
    {
      a(localTcSdkManager, paramINetCallBack, 0, localTcSdkManager.c().a().a);
      return;
    }
    b(new NetManager.1(this, localTcSdkManager, paramINetCallBack));
  }
  
  public void a(INetRequest paramINetRequest)
  {
    this.a = paramINetRequest;
  }
  
  public boolean a()
  {
    return (a("isLimitReq")) || (this.a.a());
  }
  
  public void b()
  {
    if (a("queryActiveInfo")) {
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.manager.NetManager
 * JD-Core Version:    0.7.0.1
 */