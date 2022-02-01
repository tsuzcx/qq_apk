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
    Object localObject2 = Storage.open(InternalJSPlugin.access$000(this.this$0), String.valueOf(LoginManager.getInstance().getAccount()), InternalJSPlugin.access$100(this.this$0).getMiniAppInfo().appId);
    String[] arrayOfString;
    if (localObject2 != null)
    {
      arrayOfString = ((Storage)localObject2).read("");
      ((Storage)localObject2).close();
    }
    for (;;)
    {
      if ((arrayOfString != null) && (arrayOfString.length == 2) && (TextUtils.isEmpty(arrayOfString[1]))) {
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getMiniAppStoreAppList(1, new InternalJSPlugin.2.1(this));
      }
      if ((arrayOfString != null) && (arrayOfString.length == 2))
      {
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("data", arrayOfString[0]);
          ((JSONObject)localObject2).put("dataType", arrayOfString[1]);
          this.val$req.ok((JSONObject)localObject2);
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
      this.val$req.fail();
      return;
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.2
 * JD-Core Version:    0.7.0.1
 */