package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IAppUpdateListener;
import org.json.JSONException;
import org.json.JSONObject;

class UpdateAppJsPlugin$1
  implements MiniAppProxy.IAppUpdateListener
{
  UpdateAppJsPlugin$1(UpdateAppJsPlugin paramUpdateAppJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onGetAppUpdateResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("updateMsg", paramString);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      this.val$req.ok(localJSONObject);
      return;
    }
    this.val$req.fail(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UpdateAppJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */