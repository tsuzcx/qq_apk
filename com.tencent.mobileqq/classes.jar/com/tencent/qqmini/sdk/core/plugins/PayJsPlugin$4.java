package com.tencent.qqmini.sdk.core.plugins;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayRsp;
import bdfz;
import bdnw;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$4
  implements AsyncResult
{
  PayJsPlugin$4(PayJsPlugin paramPayJsPlugin, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      paramJSONObject = new JSONObject();
      try
      {
        paramJSONObject.put("resultCode", -4);
        paramJSONObject.put("resultMsg", "消耗系统错误");
        PayJsPlugin.access$200(this.this$0, this.val$req, paramJSONObject, "");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        bdnw.d("PayJsPlugin", "invokeMidasConsume JSONException ", paramJSONObject);
        return;
      }
    }
    try
    {
      MiniAppMidasPay.StGamePayRsp localStGamePayRsp = (MiniAppMidasPay.StGamePayRsp)paramJSONObject.get("response");
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      int i = paramJSONObject.getInt("resultCode");
      String str = paramJSONObject.getString("errMsg");
      JSONObject localJSONObject3 = new JSONObject(new HashMap());
      localJSONObject2.put("attachInfo", localStGamePayRsp.extInfo.attachInfo.get());
      localJSONObject2.put("mapInfo", localJSONObject3);
      localJSONObject1.put("resultCode", i);
      localJSONObject1.put("resultMsg", str);
      localJSONObject1.put("extInfo", localJSONObject2);
      bdnw.a("PayJsPlugin", "invokeMidasConsume receive isSuc= " + paramBoolean + " resObj=" + paramJSONObject.toString());
      PayJsPlugin.access$300(this.this$0, this.val$req, paramJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      bdnw.d("PayJsPlugin", "invokeMidasConsume JSONException ", paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */