package com.tencent.qqmini.sdk.core.plugins.engine;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class BaseJsPluginEngine$4
  implements AsyncResult
{
  BaseJsPluginEngine$4(BaseJsPluginEngine paramBaseJsPluginEngine, MiniAppProxy paramMiniAppProxy, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject3 = null;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        Object localObject1 = paramJSONObject.getJSONObject("userInfo");
        paramJSONObject = ((JSONObject)localObject1).getString("nickName");
        QMLog.e("JsPluginEngine[AuthGuard]", "call getUserInfo failed. " + Log.getStackTraceString(localThrowable1));
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject1).getString("avatarUrl");
          BaseJsPluginEngine.access$500(this.this$0).post(new BaseJsPluginEngine.4.1(this, (String)localObject1, paramJSONObject));
          return;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject2;
          break label53;
        }
        localThrowable1 = localThrowable1;
        paramJSONObject = null;
      }
      label53:
      localObject2 = localObject3;
      continue;
      QMLog.d("JsPluginEngine[AuthGuard]", "call getUserInfo failed. ");
      paramJSONObject = null;
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.4
 * JD-Core Version:    0.7.0.1
 */