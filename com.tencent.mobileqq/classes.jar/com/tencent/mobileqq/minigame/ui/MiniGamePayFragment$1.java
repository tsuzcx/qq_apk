package com.tencent.mobileqq.minigame.ui;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyRsp;
import ajjy;
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
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject == null) {
      try
      {
        localJSONObject.put("resultCode", -1);
        localJSONObject.put("errMsg", ajjy.a(2131641062));
        if (localJSONObject != null) {}
        for (paramJSONObject = localJSONObject.toString(); paramJSONObject != null; paramJSONObject = "")
        {
          MiniGamePayFragment.access$000(this.this$0, this.val$event, paramJSONObject, this.val$seq);
          return;
        }
        try
        {
          localStQueryStarCurrencyRsp = (MiniAppMidasPay.StQueryStarCurrencyRsp)paramJSONObject.get("response");
          i = paramJSONObject.getInt("resultCode");
          paramJSONObject = paramJSONObject.getString("errMsg");
          j = localStQueryStarCurrencyRsp.remainder.get();
          k = localStQueryStarCurrencyRsp.rechargeNum.get();
          QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery receive resultCode= " + i + " errMsg=" + paramJSONObject + " rechargeNum:" + k + " remainder:" + j);
          if ((i == 0) && (k <= 0)) {
            this.this$0.invokeMidasConsume(this.val$appId, this.val$prepayId, this.val$starCurrency, j, k, this.val$payChannel, this.val$extInfo, this.val$event, this.val$seq, this.val$setEnv);
          }
        }
        catch (Throwable paramJSONObject)
        {
          for (;;)
          {
            QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery failed", paramJSONObject);
            try
            {
              localJSONObject.put("resultCode", -3);
              localJSONObject.put("errMsg", ajjy.a(2131641061));
            }
            catch (JSONException paramJSONObject)
            {
              QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery JSONerror", paramJSONObject);
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery JSONException ", paramJSONObject);
        return;
      }
    }
    for (;;)
    {
      MiniAppMidasPay.StQueryStarCurrencyRsp localStQueryStarCurrencyRsp;
      int i;
      int j;
      int k;
      MiniGamePayFragment.access$000(this.this$0, this.val$event, localJSONObject.toString(), this.val$seq);
      return;
      localJSONObject.put("resultCode", -3);
      localJSONObject.put("errMsg", ajjy.a(2131641063));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGamePayFragment.1
 * JD-Core Version:    0.7.0.1
 */