package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$4
  implements AsyncResult
{
  PayJsPlugin$4(PayJsPlugin paramPayJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      int i = paramJSONObject.optInt("result");
      Object localObject = paramJSONObject.optString("errMsg");
      String str = paramJSONObject.optString("firstRefer");
      paramJSONObject = paramJSONObject.optString("firstVia");
      try
      {
        this.val$paramsObject.put("firstRefer", str);
        this.val$paramsObject.put("firstVia", paramJSONObject);
      }
      catch (JSONException paramJSONObject)
      {
        QMLog.e("PayJsPlugin", "put refer via error ", paramJSONObject);
      }
      if (i == 1)
      {
        paramJSONObject = PayJsPlugin.access$1200(this.this$0, this.val$paramsObject);
        localObject = this.this$0;
        PayJsPlugin.access$1400((PayJsPlugin)localObject, PayJsPlugin.access$1300((PayJsPlugin)localObject).getAttachedActivity(), this.val$req, paramJSONObject);
        return;
      }
      if ((i == 0) || (i == 2))
      {
        AppBrandTask.runTaskOnUiThread(new PayJsPlugin.4.1(this, (String)localObject));
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("handleNativeRequest result = ");
        paramJSONObject.append(i);
        QMLog.e("PayJsPlugin", paramJSONObject.toString());
        PayJsPlugin.access$700(this.this$0, this.val$req, null, (String)localObject);
      }
    }
    else
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("checkOfferId isSuc = ");
      paramJSONObject.append(paramBoolean);
      QMLog.e("PayJsPlugin", paramJSONObject.toString());
      PayJsPlugin.access$700(this.this$0, this.val$req, null, "checkOfferId fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */