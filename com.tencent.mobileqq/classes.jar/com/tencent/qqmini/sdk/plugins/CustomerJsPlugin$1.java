package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

class CustomerJsPlugin$1
  implements AsyncResult
{
  CustomerJsPlugin$1(CustomerJsPlugin paramCustomerJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      Object localObject = paramJSONObject.opt("robotUin");
      if (((localObject instanceof String)) && (!TextUtils.isEmpty((String)localObject)))
      {
        if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openRobotProfileCard(CustomerJsPlugin.access$000(this.this$0).getAttachedActivity(), null, (String)localObject))
        {
          MiniToast.makeText(CustomerJsPlugin.access$100(this.this$0), 0, "暂不支持在" + QUAUtil.getApplicationName(CustomerJsPlugin.access$200(this.this$0)) + "中下载应用", 1);
          this.val$req.fail("app not implement");
          return;
        }
        this.val$req.ok(paramJSONObject);
        return;
      }
      this.val$req.fail("batchGetContact failed.");
      return;
    }
    QMLog.e("CustomerJsPlugin", "getRobotUin failed: ");
    this.val$req.fail("batchGetContact failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.CustomerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */