package com.tencent.mobileqq.minigame.manager;

import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class MiniGameAuthorizeManager$3
  implements MiniAppCmdInterface
{
  MiniGameAuthorizeManager$3(MiniGameAuthorizeManager paramMiniGameAuthorizeManager, MiniGamePkg paramMiniGamePkg, String paramString1, String paramString2, String paramString3) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    String str = null;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.getJSONObject("userInfo");
        str = ((JSONObject)localObject).optString("nickName");
        localStringBuilder = new StringBuilder().append("call getUserInfo exception. ");
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject = ((JSONObject)localObject).optString("avatarUrl");
          paramJSONObject = (JSONObject)localObject;
          ThreadManager.getUIHandler().post(new MiniGameAuthorizeManager.3.1(this, paramJSONObject, str));
          return;
        }
        catch (Throwable localThrowable2)
        {
          StringBuilder localStringBuilder;
          break label56;
        }
        localThrowable1 = localThrowable1;
        str = null;
      }
      label56:
      if (paramJSONObject == null) {}
      for (paramJSONObject = "ret==null";; paramJSONObject = paramJSONObject.toString())
      {
        QLog.e("MiniGameAuthorizeManager", 1, paramJSONObject + Log.getStackTraceString(localThrowable1));
        paramJSONObject = null;
        break;
      }
      QLog.e("MiniGameAuthorizeManager", 1, "call getUserInfo failed. ");
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.MiniGameAuthorizeManager.3
 * JD-Core Version:    0.7.0.1
 */