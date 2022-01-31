package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayRsp;
import alud;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$8
  implements MiniAppCmdInterface
{
  PayJsPlugin$8(PayJsPlugin paramPayJsPlugin, int paramInt, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      paramJSONObject = new JSONObject();
      try
      {
        paramJSONObject.put("resultCode", -4);
        paramJSONObject.put("resultMsg", alud.a(2131708298));
        PayJsPlugin.access$200(this.this$0, this.val$seq, this.val$event, paramJSONObject, "");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("PayJsPlugin", 1, "invokeMidasConsume JSONException ", paramJSONObject);
        return;
      }
    }
    QLog.d("PayJsPlugin", 1, "invokeMidasConsume receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    try
    {
      MiniAppMidasPay.StGamePayRsp localStGamePayRsp = (MiniAppMidasPay.StGamePayRsp)paramJSONObject.get("response");
      int i = paramJSONObject.getInt("resultCode");
      paramJSONObject = paramJSONObject.getString("errMsg");
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject(new HashMap());
      localJSONObject2.put("attachInfo", localStGamePayRsp.extInfo.attachInfo.get());
      localJSONObject2.put("mapInfo", localJSONObject3);
      localJSONObject1.put("resultCode", i);
      localJSONObject1.put("extInfo", localJSONObject2);
      localJSONObject1.put("resultMsg", paramJSONObject);
      QLog.d("PayJsPlugin", 1, "invokeMidasConsume receive isSuc= " + paramBoolean + " resObj=" + localJSONObject1.toString());
      PayJsPlugin.access$400(this.this$0, this.val$seq, this.val$event, localJSONObject1);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("PayJsPlugin", 1, "invokeMidasConsume JSONException ", paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */