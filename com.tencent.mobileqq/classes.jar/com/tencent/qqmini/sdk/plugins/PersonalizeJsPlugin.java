package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
public class PersonalizeJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "PersonalizeJsPlugin";
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  
  @JsEvent({"Personalize"})
  public void personalize(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      if (((JSONObject)localObject1).has("api_name"))
      {
        Object localObject2 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject2 == null) {
          paramRequestEvent.fail("params error.");
        }
        try
        {
          localObject1 = ((JSONObject)localObject2).optString("uin");
          int i = ((JSONObject)localObject2).optInt("set_type");
          String str = ((JSONObject)localObject2).optString("item_id");
          localObject2 = ((JSONObject)localObject2).optString("busi_info");
          this.mChannelProxy.setPersonalizeInfo(this.mApkgInfo.appId, (String)localObject1, i, str, (String)localObject2, new PersonalizeJsPlugin.1(this, paramRequestEvent));
          return;
        }
        catch (Exception localException1)
        {
          paramRequestEvent.fail("params error.");
          return;
        }
      }
      paramRequestEvent.fail("params error.");
    }
    catch (Exception localException2)
    {
      QMLog.e("PersonalizeJsPlugin", paramRequestEvent.event + " error.", localException2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PersonalizeJsPlugin
 * JD-Core Version:    0.7.0.1
 */