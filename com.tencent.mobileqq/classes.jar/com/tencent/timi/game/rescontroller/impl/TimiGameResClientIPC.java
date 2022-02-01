package com.tencent.timi.game.rescontroller.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.timi.game.rescontroller.api.TimiGameResControllerApi.IResStateListener;
import com.tencent.timi.game.utils.Logger;
import eipc.EIPCResult;
import java.util.HashMap;

public class TimiGameResClientIPC
  extends QIPCModule
{
  HashMap<String, TimiGameResControllerApi.IResStateListener> a;
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (this.a.containsKey(paramString1))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("占用资源：");
        ((StringBuilder)localObject).append(paramString1);
        Logger.c("TimiGameResSceneClientIPC", 4, ((StringBuilder)localObject).toString());
        localObject = (TimiGameResControllerApi.IResStateListener)this.a.get(paramString1);
        if (localObject != null) {
          if (((TimiGameResControllerApi.IResStateListener)localObject).b(paramString1, paramString2))
          {
            paramString2 = new StringBuilder();
            paramString2.append("已经释放资源：");
            paramString2.append(paramString1);
            Logger.a("TimiGameResSceneClientIPC", 4, paramString2.toString());
            this.a.remove(paramString1);
            callbackResult(paramInt, EIPCResult.createSuccessResult(new Bundle()));
          }
          else
          {
            Logger.c("TimiGameResSceneClientIPC", 4, "未能释放scene");
            callbackResult(paramInt, EIPCResult.createExceptionResult(null));
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, TimiGameResControllerApi.IResStateListener paramIResStateListener)
  {
    this.a.put(paramString, paramIResStateListener);
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.a.remove(paramString1);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action:");
    localStringBuilder.append(paramString);
    Logger.b("TimiGameResSceneClientIPC", 4, localStringBuilder.toString());
    int i;
    if ((paramString.hashCode() == 670605340) && (paramString.equals("ACTION_ON_OTHER_SCENE_REG_RES"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i == 0) {
      a(paramInt, paramBundle.getString("KEY_RES_NAME"), paramBundle.getString("KEY_NEW_SCENE"));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.rescontroller.impl.TimiGameResClientIPC
 * JD-Core Version:    0.7.0.1
 */