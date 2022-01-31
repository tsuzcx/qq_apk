package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import begz;
import beka;
import bemw;
import besl;
import bfgt;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import org.json.JSONObject;

class CustomerJsPlugin$1
  implements AsyncResult
{
  CustomerJsPlugin$1(CustomerJsPlugin paramCustomerJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      Object localObject = paramJSONObject.opt("robotUin");
      if (((localObject instanceof String)) && (!TextUtils.isEmpty((String)localObject)))
      {
        if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openRobotProfileCard(this.this$0.mMiniAppContext.a(), null, (String)localObject))
        {
          bemw.a(this.this$0.mContext, 0, "暂不支持在" + bfgt.a(this.this$0.mContext) + "中下载应用", 1);
          this.val$req.a("app not implement");
          return;
        }
        this.val$req.a(paramJSONObject);
        return;
      }
      this.val$req.a("batchGetContact failed.");
      return;
    }
    besl.d("CustomerJsPlugin", "getRobotUin failed: ");
    this.val$req.a("batchGetContact failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.CustomerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */