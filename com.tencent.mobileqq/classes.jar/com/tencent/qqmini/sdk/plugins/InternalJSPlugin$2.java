package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import org.json.JSONException;
import org.json.JSONObject;

class InternalJSPlugin$2
  implements Runnable
{
  InternalJSPlugin$2(InternalJSPlugin paramInternalJSPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    Object localObject = Storage.open(InternalJSPlugin.access$000(this.this$0), String.valueOf(LoginManager.getInstance().getAccount()), InternalJSPlugin.access$100(this.this$0).getMiniAppInfo().appId);
    String[] arrayOfString;
    if (localObject != null)
    {
      arrayOfString = ((Storage)localObject).read("");
      ((Storage)localObject).close();
    }
    else
    {
      arrayOfString = null;
    }
    if ((arrayOfString != null) && (arrayOfString.length == 2) && (TextUtils.isEmpty(arrayOfString[1]))) {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getMiniAppStoreAppList(1, new InternalJSPlugin.2.1(this));
    }
    if ((arrayOfString != null) && (arrayOfString.length == 2))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("data", arrayOfString[0]);
        ((JSONObject)localObject).put("dataType", arrayOfString[1]);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      this.val$req.ok((JSONObject)localObject);
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.2
 * JD-Core Version:    0.7.0.1
 */