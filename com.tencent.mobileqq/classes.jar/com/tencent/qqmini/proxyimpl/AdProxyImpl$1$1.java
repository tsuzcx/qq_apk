package com.tencent.qqmini.proxyimpl;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.ICmdListener;
import org.json.JSONException;
import org.json.JSONObject;

class AdProxyImpl$1$1
  implements MiniAppCmdInterface
{
  AdProxyImpl$1$1(AdProxyImpl.1 param1) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.this$1.val$listener != null) {
        this.this$1.val$listener.onCmdListener(false, paramJSONObject);
      }
    }
    JSONObject localJSONObject;
    label217:
    do
    {
      do
      {
        for (;;)
        {
          return;
          localJSONObject = new JSONObject();
          try
          {
            Object localObject = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
            int i = paramJSONObject.getInt("retCode");
            paramJSONObject = paramJSONObject.getString("errMsg");
            localObject = ((MiniAppAd.StGetAdRsp)localObject).strAdsJson.get();
            QLog.d("AdProxyImpl", 1, "getADInfo receive retCode= " + i + " errMsg=" + paramJSONObject + " adJson=" + (String)localObject);
            localJSONObject.put("retCode", i);
            localJSONObject.put("errMsg", paramJSONObject);
            localJSONObject.put("response", localObject);
            if ((i != 0) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label217;
            }
            if (this.this$1.val$listener != null)
            {
              this.this$1.val$listener.onCmdListener(true, localJSONObject);
              return;
            }
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
          }
        }
      } while (this.this$1.val$listener == null);
      this.this$1.val$listener.onCmdListener(false, null);
      return;
    } while (this.this$1.val$listener == null);
    this.this$1.val$listener.onCmdListener(false, localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */