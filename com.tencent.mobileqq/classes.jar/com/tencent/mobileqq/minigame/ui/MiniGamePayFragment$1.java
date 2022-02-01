package com.tencent.mobileqq.minigame.ui;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyRsp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniGamePayFragment$1
  implements MiniAppCmdInterface
{
  MiniGamePayFragment$1(MiniGamePayFragment paramMiniGamePayFragment, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, COMM.StCommonExt paramStCommonExt, int paramInt4) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("invokeMidasQuery receive isSuc= ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(" ret=");
    ((StringBuilder)localObject1).append(String.valueOf(paramJSONObject));
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new JSONObject();
    if (paramJSONObject == null)
    {
      try
      {
        ((JSONObject)localObject1).put("resultCode", -1);
        ((JSONObject)localObject1).put("errMsg", HardCodeUtil.a(2131706883));
        paramJSONObject = ((JSONObject)localObject1).toString();
        if (paramJSONObject != null)
        {
          MiniGamePayFragment.access$000(this.this$0, this.val$event, paramJSONObject, this.val$seq);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery JSONException ", paramJSONObject);
      }
      return;
    }
    try
    {
      Object localObject2 = (MiniAppMidasPay.StQueryStarCurrencyRsp)paramJSONObject.get("response");
      int i = paramJSONObject.getInt("resultCode");
      paramJSONObject = paramJSONObject.getString("errMsg");
      int j = ((MiniAppMidasPay.StQueryStarCurrencyRsp)localObject2).remainder.get();
      int k = ((MiniAppMidasPay.StQueryStarCurrencyRsp)localObject2).rechargeNum.get();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("invokeMidasQuery receive resultCode= ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" errMsg=");
      ((StringBuilder)localObject2).append(paramJSONObject);
      ((StringBuilder)localObject2).append(" rechargeNum:");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(" remainder:");
      ((StringBuilder)localObject2).append(j);
      QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, ((StringBuilder)localObject2).toString());
      if ((i == 0) && (k <= 0))
      {
        this.this$0.invokeMidasConsume(this.val$appId, this.val$prepayId, this.val$starCurrency, j, k, this.val$payChannel, this.val$extInfo, this.val$event, this.val$seq, this.val$setEnv);
      }
      else
      {
        ((JSONObject)localObject1).put("resultCode", -3);
        ((JSONObject)localObject1).put("errMsg", HardCodeUtil.a(2131706884));
      }
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery failed", paramJSONObject);
      try
      {
        ((JSONObject)localObject1).put("resultCode", -3);
        ((JSONObject)localObject1).put("errMsg", HardCodeUtil.a(2131706882));
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery JSONerror", paramJSONObject);
      }
    }
    MiniGamePayFragment.access$000(this.this$0, this.val$event, ((JSONObject)localObject1).toString(), this.val$seq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGamePayFragment.1
 * JD-Core Version:    0.7.0.1
 */