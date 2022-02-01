package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$13
  implements AdProxy.ICmdListener
{
  DataJsPlugin$13(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i = 0;
    int j;
    if (paramBoolean)
    {
      String str3;
      String str4;
      JSONObject localJSONObject2;
      try
      {
        j = paramJSONObject.getInt("retCode");
        String str1 = paramJSONObject.getString("errMsg");
        String str2 = paramJSONObject.getString("response");
        str3 = paramJSONObject.optString("adClass");
        str4 = paramJSONObject.optString("fromSDK");
        paramJSONObject = new JSONObject();
        localJSONObject2 = new JSONObject();
        QMLog.d("DataJsPlugin", "requestAdInfo. retCode = " + j);
        if (WnsConfig.getConfig("qqminiapp", "miniappadusetranscoding", 0) == 0) {
          i = 1;
        }
        if ((j == 0) || (i == 0)) {
          break label220;
        }
        i = MiniSDKConst.AdConst.getRetCodeByServerResult(j);
        try
        {
          localJSONObject2.put("ret", i);
          paramJSONObject.put("data", localJSONObject2.toString());
          if (i != -1)
          {
            this.val$req.fail(paramJSONObject, (String)MiniSDKConst.AdConst.CODE_MSG_MAP.get(Integer.valueOf(i)));
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            QMLog.e("DataJsPlugin", "JSONException: " + Log.getStackTraceString(localJSONException2));
          }
        }
        this.val$req.fail(paramJSONObject, str1);
      }
      catch (Exception paramJSONObject)
      {
        this.val$req.fail();
        return;
      }
      return;
      try
      {
        label220:
        localJSONObject2.put("data", localJSONException2);
        localJSONObject2.put("ret", j);
        localJSONObject2.put("adClass", str3);
        if (!TextUtils.isEmpty(str4)) {
          localJSONObject2.put("fromSDK", str4);
        }
        paramJSONObject.put("data", localJSONObject2.toString());
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          QMLog.i("DataJsPlugin", "requestAdInfo. retCode = " + j);
        }
      }
      this.val$req.ok(paramJSONObject);
      DataJsPlugin.access$500(this.this$0, localJSONException2, this.val$constAdType);
      return;
    }
    if (paramJSONObject != null)
    {
      i = paramJSONObject.getInt("retCode");
      paramJSONObject = paramJSONObject.getString("errMsg");
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("ret", i);
        localJSONObject1.put("errMsg", paramJSONObject);
        this.val$req.fail(localJSONObject1, "");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QMLog.e("DataJsPlugin", "requestAdInfo. retCode = " + i);
        return;
      }
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */