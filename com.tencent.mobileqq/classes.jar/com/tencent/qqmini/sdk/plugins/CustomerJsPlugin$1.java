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
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openRobotProfileCard(CustomerJsPlugin.access$000(this.this$0).getAttachedActivity(), null, (String)localObject))
          {
            paramJSONObject = CustomerJsPlugin.access$100(this.this$0);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("暂不支持在");
            ((StringBuilder)localObject).append(QUAUtil.getApplicationName(CustomerJsPlugin.access$200(this.this$0)));
            ((StringBuilder)localObject).append("中下载应用");
            MiniToast.makeText(paramJSONObject, 0, ((StringBuilder)localObject).toString(), 1);
            this.val$req.fail("app not implement");
            return;
          }
          this.val$req.ok(paramJSONObject);
          return;
        }
      }
      this.val$req.fail("batchGetContact failed.");
      return;
    }
    QMLog.e("CustomerJsPlugin", "getRobotUin failed: ");
    this.val$req.fail("batchGetContact failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.CustomerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */