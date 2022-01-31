package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgok;
import bgpg;
import com.tencent.qqmini.sdk.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.core.proxy.PayProxy.PayResponse;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$9
  implements PayProxy.IPayResultCallBack
{
  PayJsPlugin$9(PayJsPlugin paramPayJsPlugin, bgok parambgok) {}
  
  public void onPayCallBack(PayProxy.PayResponse paramPayResponse)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", paramPayResponse.getResultCode());
      String str = paramPayResponse.getExtendInfo();
      if ((!TextUtils.isEmpty(str)) && (bgpg.a(str))) {
        localJSONObject.put("data", new JSONObject(str).optJSONObject("data"));
      }
      label58:
      if ((paramPayResponse.getResultCode() == 0) && (paramPayResponse.getPayState() == 0)) {
        PayJsPlugin.access$300(this.this$0, this.val$req, localJSONObject);
      }
      for (;;)
      {
        QMLog.i("PayJsPlugin", "handleMidasGoodsPay onPayCallBack, , resultCode = " + paramPayResponse.getResultCode() + ", resultMsg = " + paramPayResponse.getResultMsg() + "extendInfo = " + paramPayResponse.getExtendInfo());
        return;
        if ((paramPayResponse.getResultCode() == 2) || (paramPayResponse.getPayState() == 1))
        {
          PayJsPlugin.access$000(this.this$0, this.val$req, localJSONObject);
        }
        else
        {
          str = paramPayResponse.getResultMsg();
          PayJsPlugin.access$200(this.this$0, this.val$req, localJSONObject, str);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      break label58;
    }
  }
  
  public void payNeedLogin()
  {
    QMLog.e("PayJsPlugin", "handleMidasMonthCardPay payNeedLogin");
    PayJsPlugin.access$200(this.this$0, this.val$req, null, "payNeedLogin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */