package com.tentcent.timi.game.net.impl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.Logger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class NetCore
{
  public static void a(AppRuntime paramAppRuntime, NewIntent paramNewIntent, Class<? extends MessageMicro> paramClass, RequestListener paramRequestListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendRequest appRuntime:");
    ((StringBuilder)localObject).append(paramAppRuntime);
    Logger.a("NetCore", ((StringBuilder)localObject).toString());
    if (paramNewIntent == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("sendRequest but NewIntent is null! ");
      paramAppRuntime.append(paramNewIntent);
      paramAppRuntime.append(" - ");
      paramAppRuntime.append(paramClass);
      Logger.a("NetCore", paramAppRuntime.toString(), new Exception());
      if (paramRequestListener != null) {
        paramRequestListener.a(false, -11, -1, 0, "", "NewIntent is null", null, null);
      }
      return;
    }
    localObject = paramAppRuntime;
    if (paramAppRuntime == null) {
      localObject = TimiGameActivityManager.c();
    }
    if (localObject == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("sendRequest but runtime is null! ");
      paramAppRuntime.append(paramNewIntent);
      paramAppRuntime.append(" - ");
      paramAppRuntime.append(paramClass);
      Logger.a("NetCore", paramAppRuntime.toString(), new Exception());
      if (paramRequestListener != null) {
        paramRequestListener.a(false, -22, -1, 0, "", "AppRunTime is null", null, null);
      }
      return;
    }
    paramNewIntent.setObserver(new NetCore.1(paramRequestListener, paramClass));
    ((AppRuntime)localObject).startServlet(paramNewIntent);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("startServlet appRuntime:");
    paramAppRuntime.append(localObject);
    Logger.a("NetCore", paramAppRuntime.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tentcent.timi.game.net.impl.NetCore
 * JD-Core Version:    0.7.0.1
 */