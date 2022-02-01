package com.tencent.timi.game.rescontroller.impl;

import com.tencent.timi.game.rescontroller.api.TimiGameResControllerApi.IResStateListener;
import com.tencent.timi.game.utils.Logger;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class TimiGameResClientIPC$2
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess())
    {
      TimiGameResClientIPC.a(TimiGameResSceneRemoteHelper.a(), this.a, this.b);
      this.b.a();
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("ResRegSuccess:");
      paramEIPCResult.append(this.a);
      Logger.b("TimiGameResSceneClientIPC", 4, paramEIPCResult.toString());
      return;
    }
    this.b.a(this.a, this.c);
    paramEIPCResult = new StringBuilder();
    paramEIPCResult.append("ResRegError:");
    paramEIPCResult.append(this.a);
    Logger.c("TimiGameResSceneClientIPC", 4, paramEIPCResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.rescontroller.impl.TimiGameResClientIPC.2
 * JD-Core Version:    0.7.0.1
 */