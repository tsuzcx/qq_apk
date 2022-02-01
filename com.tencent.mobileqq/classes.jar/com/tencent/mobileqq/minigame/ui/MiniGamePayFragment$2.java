package com.tencent.mobileqq.minigame.ui;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayRsp;
import com.tencent.mobileqq.app.HardCodeUtil;
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
        paramJSONObject.put("resultMsg", HardCodeUtil.a(2131904727));
        paramJSONObject = paramJSONObject.toString();
        if (paramJSONObject != null)
        {
          MiniGamePayFragment.access$000(this.this$0, this.val$event, paramJSONObject, this.val$seq);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasConsume JSONException ", paramJSONObject);
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invokeMidasConsume receive isSuc= ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" ret=");
    ((StringBuilder)localObject).append(String.valueOf(paramJSONObject));
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = (MiniAppMidasPay.StGamePayRsp)paramJSONObject.get("response");
      int i = paramJSONObject.getInt("resultCode");
      String str = paramJSONObject.getString("errMsg");
      paramJSONObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject(new HashMap());
      localJSONObject1.put("attachInfo", ((MiniAppMidasPay.StGamePayRsp)localObject).extInfo.attachInfo.get());
      localJSONObject1.put("mapInfo", localJSONObject2);
      paramJSONObject.put("resultCode", i);
      paramJSONObject.put("extInfo", localJSONObject1);
      paramJSONObject.put("resultMsg", str);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invokeMidasConsume receive isSuc= ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" resObj=");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, ((StringBuilder)localObject).toString());
      MiniGamePayFragment.access$000(this.this$0, this.val$event, paramJSONObject.toString(), this.val$seq);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasConsume JSONException ", paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGamePayFragment.2
 * JD-Core Version:    0.7.0.1
 */