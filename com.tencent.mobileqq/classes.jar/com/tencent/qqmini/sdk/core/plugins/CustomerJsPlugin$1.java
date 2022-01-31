package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgho;
import bgkd;
import bgnf;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONObject;

class CustomerJsPlugin$1
  implements AsyncResult
{
  CustomerJsPlugin$1(CustomerJsPlugin paramCustomerJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      Object localObject = paramJSONObject.opt("robotUin");
      if (((localObject instanceof String)) && (!TextUtils.isEmpty((String)localObject)))
      {
        if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openRobotProfileCard(this.this$0.mMiniAppContext.a(), null, (String)localObject))
        {
          bgnf.a(this.this$0.mContext, 0, "暂不支持在" + QUAUtil.getApplicationName(this.this$0.mContext) + "中下载应用", 1);
          this.val$req.a("app not implement");
          return;
        }
        this.val$req.a(paramJSONObject);
        return;
      }
      this.val$req.a("batchGetContact failed.");
      return;
    }
    QMLog.e("CustomerJsPlugin", "getRobotUin failed: ");
    this.val$req.a("batchGetContact failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.CustomerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */