package com.tencent.timi.game.rescontroller.impl;

import android.os.Bundle;
import com.tencent.timi.game.rescontroller.api.TimiGameResControllerApi.IResAvaliableCallback;
import com.tencent.timi.game.utils.Logger;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class TimiGameResClientIPC$1
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess())
    {
      paramEIPCResult = paramEIPCResult.data.getString("KEY_RES_AVALIABLE");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ResUseBy:");
      localStringBuilder.append(paramEIPCResult);
      Logger.b("TimiGameResSceneClientIPC", 4, localStringBuilder.toString());
      this.a.a(paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.rescontroller.impl.TimiGameResClientIPC.1
 * JD-Core Version:    0.7.0.1
 */