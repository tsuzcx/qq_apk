package com.tencent.mobileqq.minigame.ui;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayRsp;
import ajyc;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class MiniGamePayFragment$2
  implements MiniAppCmdInterface
{
  MiniGamePayFragment$2(MiniGamePayFragment paramMiniGamePayFragment, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      paramJSONObject = new JSONObject();
      try
      {
        paramJSONObject.put("resultCode", -4);
        paramJSONObject.put("resultMsg", ajyc.a(2131706845));
        if (paramJSONObject != null) {}
        for (paramJSONObject = paramJSONObject.toString(); paramJSONObject != null; paramJSONObject = "")
        {
          MiniGamePayFragment.access$000(this.this$0, this.val$event, paramJSONObject, this.val$seq);
          return;
        }
        QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasConsume receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasConsume JSONException ", paramJSONObject);
        return;
      }
    }
    else
    {
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
        QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasConsume receive isSuc= " + paramBoolean + " resObj=" + localJSONObject1.toString());
        MiniGamePayFragment.access$000(this.this$0, this.val$event, localJSONObject1.toString(), this.val$seq);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasConsume JSONException ", paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGamePayFragment.2
 * JD-Core Version:    0.7.0.1
 */