package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyRsp;
import anzj;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$12
  implements MiniAppCmdInterface
{
  PayJsPlugin$12(PayJsPlugin paramPayJsPlugin, int paramInt, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("PayJsPlugin", 1, "invokeMidasQuery receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      paramJSONObject = new JSONObject();
      try
      {
        paramJSONObject.put("resultCode", -1);
        PayJsPlugin.access$200(this.this$0, this.val$seq, this.val$event, null, anzj.a(2131706783));
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("PayJsPlugin", 1, "invokeMidasQuery JSONException ", paramJSONObject);
        return;
      }
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
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("rechargeNum", String.valueOf(localStQueryStarCurrencyRsp.rechargeNum.get()));
      localJSONObject1.put("remainder", String.valueOf(localStQueryStarCurrencyRsp.remainder.get()));
      localJSONObject1.put("errMsg", paramJSONObject);
      QLog.d("PayJsPlugin", 1, "invokeMidasQuery receive isSuc= " + paramBoolean + " resObj=" + localJSONObject1.toString());
      PayJsPlugin.access$500(this.this$0, this.val$seq, this.val$event, localJSONObject1);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("PayJsPlugin", 1, "invokeMidasQuery failed", paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */