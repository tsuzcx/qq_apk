package com.tencent.qqmini.sdk.core.plugins;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyRsp;
import bdnw;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$5
  implements AsyncResult
{
  PayJsPlugin$5(PayJsPlugin paramPayJsPlugin, PayJsPlugin.IStarQueryListener paramIStarQueryListener) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bdnw.a("PayJsPlugin", "invokeMidasQuery receive isSuc= " + paramBoolean + " ret=" + paramJSONObject);
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("resultCode", -1);
        paramJSONObject.put("errMsg", "系统错误");
        if (this.val$listener != null) {
          this.val$listener.onResult(false, paramJSONObject);
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        bdnw.d("PayJsPlugin", "invokeMidasQuery JSONException ", paramJSONObject);
        return;
      }
      try
      {
        MiniAppMidasPay.StQueryStarCurrencyRsp localStQueryStarCurrencyRsp = (MiniAppMidasPay.StQueryStarCurrencyRsp)paramJSONObject.get("response");
        int i = paramJSONObject.getInt("resultCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject(new HashMap());
        localJSONObject2.put("attachInfo", localStQueryStarCurrencyRsp.extInfo.attachInfo.get());
        localJSONObject2.put("mapInfo", localJSONObject3);
        localJSONObject1.put("resultCode", i);
        localJSONObject1.put("errMsg", paramJSONObject);
        localJSONObject1.put("extInfo", localJSONObject2);
        localJSONObject1.put("rechargeNum", localStQueryStarCurrencyRsp.rechargeNum.get());
        localJSONObject1.put("remainder", localStQueryStarCurrencyRsp.remainder.get());
        bdnw.a("PayJsPlugin", "invokeMidasQuery receive isSuc= " + paramBoolean + " resObj=" + localJSONObject1.toString());
        if (this.val$listener != null)
        {
          this.val$listener.onResult(true, localJSONObject1);
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        bdnw.d("PayJsPlugin", "invokeMidasQuery failed", paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */