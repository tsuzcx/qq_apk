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
      localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      boolean bool = ((JSONObject)localObject1).has("api_name");
      if (bool)
      {
        localObject3 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject3 == null) {
          paramRequestEvent.fail("params error.");
        }
      }
    }
    catch (Exception localException1)
    {
      Object localObject1;
      Object localObject3;
      int i;
      label114:
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" error.");
      QMLog.e("PersonalizeJsPlugin", ((StringBuilder)localObject2).toString(), localException1);
      return;
    }
    try
    {
      localObject1 = ((JSONObject)localObject3).optString("uin");
      i = ((JSONObject)localObject3).optInt("set_type");
      localObject2 = ((JSONObject)localObject3).optString("item_id");
      localObject3 = ((JSONObject)localObject3).optString("busi_info");
      this.mChannelProxy.setPersonalizeInfo(this.mApkgInfo.appId, (String)localObject1, i, (String)localObject2, (String)localObject3, new PersonalizeJsPlugin.1(this, paramRequestEvent));
      return;
    }
    catch (Exception localException2)
    {
      break label114;
    }
    paramRequestEvent.fail("params error.");
    return;
    paramRequestEvent.fail("params error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PersonalizeJsPlugin
 * JD-Core Version:    0.7.0.1
 */