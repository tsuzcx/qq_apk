package com.tencent.timi.game.rescontroller.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.timi.game.utils.Logger;
import eipc.EIPCResult;

public class TimiGameResServerIPC
  extends QIPCModule
{
  private ResSceneManager a;
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("action:");
    ((StringBuilder)localObject).append(paramString);
    Logger.b("TimiGameResSceneServerIPC", 4, ((StringBuilder)localObject).toString());
    int i = paramString.hashCode();
    if (i != -2107184604)
    {
      if (i != -581444552)
      {
        if ((i == 1220661548) && (paramString.equals("ACTION_REG_RES")))
        {
          i = 1;
          break label113;
        }
      }
      else if (paramString.equals("ACTION_UN_REG_RES"))
      {
        i = 2;
        break label113;
      }
    }
    else if (paramString.equals("ACTION_QUERY_RES_AVALIABLE"))
    {
      i = 0;
      break label113;
    }
    i = -1;
    label113:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramString = paramBundle.getString("KEY_RES_NAME");
          this.a.a(paramString);
          callbackResult(paramInt, EIPCResult.createSuccessResult(new Bundle()));
        }
      }
      else
      {
        paramString = paramBundle.getString("KEY_RES_NAME");
        paramBundle = paramBundle.getString("KEY_SCENE");
        localObject = this.a.a(paramString, paramBundle);
        if ((localObject != null) && (!((String)localObject).equals(paramBundle)))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("KEY_RES_NAME", paramString);
          ((Bundle)localObject).putString("KEY_NEW_SCENE", paramBundle);
          QIPCServerHelper.getInstance().callClient(TimiGameResSceneRemoteHelper.b(), "TimiGameResSceneRemoteClient", "ACTION_ON_OTHER_SCENE_REG_RES", (Bundle)localObject, null);
          QIPCServerHelper.getInstance().callClient(TimiGameResSceneRemoteHelper.c(), "TimiGameResSceneRemoteClient", "ACTION_ON_OTHER_SCENE_REG_RES", (Bundle)localObject, null);
        }
        this.a.b(paramString, paramBundle);
        callbackResult(paramInt, EIPCResult.createSuccessResult(new Bundle()));
      }
    }
    else
    {
      paramString = paramBundle.getString("KEY_RES_NAME");
      paramBundle = paramBundle.getString("KEY_SCENE");
      localObject = new Bundle();
      ((Bundle)localObject).putString("KEY_RES_AVALIABLE", this.a.a(paramString, paramBundle));
      callbackResult(paramInt, EIPCResult.createSuccessResult((Bundle)localObject));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.rescontroller.impl.TimiGameResServerIPC
 * JD-Core Version:    0.7.0.1
 */