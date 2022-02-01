package com.tencent.timi.game.utils;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.app.ISingletonLifeCycle;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NetEventManager
  implements ISingletonLifeCycle
{
  private static volatile NetEventManager a;
  private List<INetInfoHandler> b = new CopyOnWriteArrayList();
  
  public static NetEventManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new NetEventManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(INetInfoHandler paramINetInfoHandler)
  {
    if (!this.b.contains(paramINetInfoHandler))
    {
      this.b.add(paramINetInfoHandler);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), paramINetInfoHandler);
    }
  }
  
  public void b(INetInfoHandler paramINetInfoHandler)
  {
    this.b.remove(paramINetInfoHandler);
    AppNetConnInfo.unregisterNetInfoHandler(paramINetInfoHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.NetEventManager
 * JD-Core Version:    0.7.0.1
 */