package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdcz;
import bdeg;
import bdfz;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

class InternalJSPlugin$1
  implements Runnable
{
  InternalJSPlugin$1(InternalJSPlugin paramInternalJSPlugin, bdfz parambdfz) {}
  
  public void run()
  {
    Object localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    String[] arrayOfString = null;
    localObject = bdeg.a(this.this$0.mContext, String.valueOf(((MiniAppProxy)localObject).getAccount()), this.this$0.mMiniAppContext.a().appId);
    if (localObject != null)
    {
      arrayOfString = ((bdeg)localObject).a("");
      ((bdeg)localObject).a();
    }
    if ((arrayOfString != null) && (arrayOfString.length == 2) && (TextUtils.isEmpty(arrayOfString[1]))) {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getMiniAppStoreAppList(1, new InternalJSPlugin.1.1(this));
    }
    if ((arrayOfString != null) && (arrayOfString.length == 2))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("data", arrayOfString[0]);
        ((JSONObject)localObject).put("dataType", arrayOfString[1]);
        this.val$req.a((JSONObject)localObject);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.1
 * JD-Core Version:    0.7.0.1
 */