package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.PayResponse;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$11
  implements PayProxy.IPayResultCallBack
{
  PayJsPlugin$11(PayJsPlugin paramPayJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onPayCallBack(PayProxy.PayResponse paramPayResponse)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("resultCode", paramPayResponse.getResultCode());
      label19:
      if ((paramPayResponse.getResultCode() == 0) && (paramPayResponse.getPayState() == 0))
      {
        PayJsPlugin.access$1600(this.this$0, this.val$req, (JSONObject)localObject);
      }
      else if ((paramPayResponse.getResultCode() != 2) && (paramPayResponse.getPayState() != 1))
      {
        String str = paramPayResponse.getResultMsg();
        PayJsPlugin.access$700(this.this$0, this.val$req, (JSONObject)localObject, str);
      }
      else
      {
        PayJsPlugin.access$000(this.this$0, this.val$req, (JSONObject)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMidasMonthCardPay onPayCallBack, , resultCode = ");
      ((StringBuilder)localObject).append(paramPayResponse.getResultCode());
      ((StringBuilder)localObject).append(", resultMsg = ");
      ((StringBuilder)localObject).append(paramPayResponse.getResultMsg());
      ((StringBuilder)localObject).append("extendInfo = ");
      ((StringBuilder)localObject).append(paramPayResponse.getExtendInfo());
      QMLog.i("PayJsPlugin", ((StringBuilder)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      break label19;
    }
  }
  
  public void payNeedLogin()
  {
    QMLog.e("PayJsPlugin", "handleMidasMonthCardPay payNeedLogin");
    PayJsPlugin.access$700(this.this$0, this.val$req, null, "payNeedLogin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */