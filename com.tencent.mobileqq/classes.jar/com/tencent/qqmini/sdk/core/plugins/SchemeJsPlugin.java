package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import bglv;
import bgok;
import bgpg;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class SchemeJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "SchemeJsPlugin";
  
  public void openScheme(bgok parambgok)
  {
    Activity localActivity = this.mMiniAppContext.a();
    if (localActivity == null) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      if (((JSONObject)localObject).has("api_name"))
      {
        String str = ((JSONObject)localObject).optString("api_name");
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("data");
        localObject = null;
        if (localJSONObject != null) {
          localObject = bgpg.a(localJSONObject);
        }
        localObject = str + "?" + (String)localObject;
        ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openSchema(localActivity, (String)localObject, new SchemeJsPlugin.1(this, new Handler(Looper.getMainLooper()), parambgok, (String)localObject));
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("SchemeJsPlugin", parambgok.a + " error.", localException);
      return;
    }
    parambgok.a("params error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SchemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */