package com.tentcent.timi.game.net.impl;

import android.content.Context;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class NetImpl
  implements NetApi
{
  private <T extends MessageMicro> void a(AppRuntime paramAppRuntime, NewIntent paramNewIntent, Class<T> paramClass, RequestListener<T> paramRequestListener)
  {
    NetCore.a(paramAppRuntime, paramNewIntent, paramClass, paramRequestListener);
  }
  
  public void a(Context paramContext) {}
  
  public <T extends MessageMicro> void a(NewIntent paramNewIntent, Class<T> paramClass, RequestListener<T> paramRequestListener)
  {
    a(TimiGameActivityManager.c(), paramNewIntent, paramClass, paramRequestListener);
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tentcent.timi.game.net.impl.NetImpl
 * JD-Core Version:    0.7.0.1
 */