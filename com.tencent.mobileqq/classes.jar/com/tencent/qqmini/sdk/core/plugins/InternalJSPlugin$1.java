package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import begz;
import beig;
import beka;
import beuc;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

class InternalJSPlugin$1
  implements Runnable
{
  InternalJSPlugin$1(InternalJSPlugin paramInternalJSPlugin, beka parambeka) {}
  
  public void run()
  {
    Object localObject2 = beig.a(this.this$0.mContext, String.valueOf(beuc.a().a()), this.this$0.mMiniAppContext.a().appId);
    String[] arrayOfString;
    if (localObject2 != null)
    {
      arrayOfString = ((beig)localObject2).a("");
      ((beig)localObject2).a();
    }
    for (;;)
    {
      if ((arrayOfString != null) && (arrayOfString.length == 2) && (TextUtils.isEmpty(arrayOfString[1]))) {
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getMiniAppStoreAppList(1, new InternalJSPlugin.1.1(this));
      }
      if ((arrayOfString != null) && (arrayOfString.length == 2))
      {
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("data", arrayOfString[0]);
          ((JSONObject)localObject2).put("dataType", arrayOfString[1]);
          this.val$req.a((JSONObject)localObject2);
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
      this.val$req.b();
      return;
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.1
 * JD-Core Version:    0.7.0.1
 */