package com.tencent.mobileqq.mini.entry;

import android.text.TextUtils;
import bfbm;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONException;
import org.json.JSONObject;

final class MiniAppUtils$2
  implements Runnable
{
  MiniAppUtils$2(BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = Storage.open(this.val$jsPluginEngine.activityContext, String.valueOf(bfbm.a().a()), this.val$jsPluginEngine.appBrandRuntime.getApkgInfo().appId);
    String[] arrayOfString;
    if (localObject2 != null)
    {
      arrayOfString = ((Storage)localObject2).read("");
      ((Storage)localObject2).close();
    }
    for (;;)
    {
      if ((arrayOfString != null) && (arrayOfString.length == 2) && (TextUtils.isEmpty(arrayOfString[1])))
      {
        MiniAppCmdUtil.getInstance().getMiniAppStoreAppList(1, new MiniAppUtils.2.1(this));
        return;
      }
      if ((arrayOfString != null) && (arrayOfString.length == 2))
      {
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("data", arrayOfString[0]);
          ((JSONObject)localObject2).put("dataType", arrayOfString[1]);
          this.val$jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, this.val$eventName, (JSONObject)localObject2, this.val$callBackId);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
      this.val$jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, this.val$eventName, null, this.val$callBackId);
      return;
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.2
 * JD-Core Version:    0.7.0.1
 */