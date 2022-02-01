package com.tencent.treasurecard.manager;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.treasurecard.api.ITcSdkContext;
import com.tencent.treasurecard.api.ITcSdkContext.OnCardStateChangeListener;
import com.tencent.treasurecard.common.NetworkReceiver;
import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;
import com.tencent.xaction.log.QLog;

public class TcSdkManager
  implements ITcSdkContext
{
  private static ITcSdkContext a;
  private NetManager b = new NetManager();
  private CacheManager c = new CacheManager();
  private NetworkReceiver d;
  private Context e;
  private ITcSdkContext.OnCardStateChangeListener f;
  
  public static ITcSdkContext b()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TcSdkManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a()
  {
    this.c.a("");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ITcSdkContext.OnCardStateChangeListener localOnCardStateChangeListener = this.f;
    if (localOnCardStateChangeListener != null) {
      localOnCardStateChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong)
  {
    CacheManager.a = paramLong;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.a("TcSdkManager", 1, "SDK init error, Context is must", null);
      return;
    }
    this.e = paramContext.getApplicationContext();
    if (this.d == null)
    {
      paramContext = new IntentFilter();
      paramContext.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.d = new NetworkReceiver();
      this.e.registerReceiver(this.d, paramContext);
    }
  }
  
  public void a(ITcSdkContext.OnCardStateChangeListener paramOnCardStateChangeListener)
  {
    this.f = paramOnCardStateChangeListener;
  }
  
  public void a(INetCallBack paramINetCallBack)
  {
    this.b.a(paramINetCallBack);
  }
  
  public void a(INetRequest paramINetRequest)
  {
    this.b.a(paramINetRequest);
  }
  
  public CacheManager c()
  {
    return this.c;
  }
  
  public NetManager d()
  {
    return this.b;
  }
  
  public Context e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.manager.TcSdkManager
 * JD-Core Version:    0.7.0.1
 */