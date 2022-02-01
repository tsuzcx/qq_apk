package com.tencent.qqmini.sdk.plugins.engine;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import org.json.JSONObject;

class BaseJsPluginEngine$13
  implements AsyncResult
{
  BaseJsPluginEngine$13(BaseJsPluginEngine paramBaseJsPluginEngine, MiniAppProxy paramMiniAppProxy, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
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
        int i;
        int j;
        QMLog.e("JsPluginEngine[AuthGuard]", "call getUserInfo failed. " + Log.getStackTraceString(localThrowable1));
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject1).getString("avatarUrl");
          i = ViewUtils.dpToPx(26.0F);
          j = ViewUtils.dpToPx(40.0F);
          BaseJsPluginEngine.access$300(this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine).post(new BaseJsPluginEngine.13.1(this, i, (String)localObject1, j, paramJSONObject));
          return;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject2;
          break label75;
        }
        localThrowable1 = localThrowable1;
        paramJSONObject = null;
      }
      label75:
      localObject2 = localObject3;
      continue;
      QMLog.d("JsPluginEngine[AuthGuard]", "call getUserInfo failed. ");
      paramJSONObject = null;
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.13
 * JD-Core Version:    0.7.0.1
 */