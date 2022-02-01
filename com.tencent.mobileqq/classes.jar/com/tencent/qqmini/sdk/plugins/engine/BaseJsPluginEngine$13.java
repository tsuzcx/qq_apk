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
    Object localObject2 = null;
    Object localObject1;
    if (paramBoolean)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("userInfo");
        localObject1 = paramJSONObject.getString("nickName");
        try
        {
          paramJSONObject = paramJSONObject.getString("avatarUrl");
        }
        catch (Throwable localThrowable1)
        {
          paramJSONObject = (JSONObject)localObject1;
        }
        localObject1 = new StringBuilder();
      }
      catch (Throwable localThrowable2)
      {
        paramJSONObject = null;
      }
      ((StringBuilder)localObject1).append("call getUserInfo failed. ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(localThrowable2));
      QMLog.e("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject1).toString());
      localObject1 = paramJSONObject;
      paramJSONObject = localObject2;
    }
    else
    {
      QMLog.d("JsPluginEngine[AuthGuard]", "call getUserInfo failed. ");
      paramJSONObject = null;
      localObject1 = paramJSONObject;
    }
    int i = ViewUtils.dpToPx(26.0F);
    int j = ViewUtils.dpToPx(40.0F);
    BaseJsPluginEngine.access$300(this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine).post(new BaseJsPluginEngine.13.1(this, i, paramJSONObject, j, (String)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.13
 * JD-Core Version:    0.7.0.1
 */