package com.tencent.viola.module;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.commons.HttpStatusText;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class HttpModule$1
  implements HttpModule.ResponseCallback
{
  HttpModule$1(HttpModule paramHttpModule, String paramString1, String paramString2) {}
  
  public void onResponse(HttpResponse paramHttpResponse, Map<String, String> paramMap)
  {
    int i = 1;
    if (this.val$callbackId != null)
    {
      JSONObject localJSONObject;
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          if ((paramHttpResponse == null) || ("-1".equals(paramHttpResponse.statusCode)))
          {
            localJSONObject.put("success", 0);
            localJSONObject.put("errorText", "ERR_CONNECT_FAILED");
            paramHttpResponse = Message.obtain();
            paramHttpResponse.what = 1;
            paramMap = new Bundle();
            paramMap.putString("callback", this.val$callbackId);
            paramMap.putString("resp", localJSONObject.toString());
            paramMap.putString("inctanceId", this.val$instanceId);
            paramHttpResponse.setData(paramMap);
            if (HttpModule.access$000(this.this$0) == null) {
              return;
            }
            HttpModule.access$000(this.this$0).sendMessage(paramHttpResponse);
            return;
          }
          int j = Integer.parseInt(paramHttpResponse.statusCode);
          localJSONObject.put("code", j);
          if ((j >= 200) && (j <= 299))
          {
            localJSONObject.put("success", i);
            if (paramHttpResponse.originalData != null) {
              break;
            }
            localJSONObject.put("data", null);
            localJSONObject.put("errorText", HttpStatusText.getStatusText(paramHttpResponse.statusCode));
          }
          else
          {
            i = 0;
          }
        }
        catch (JSONException paramHttpResponse)
        {
          ViolaLogUtils.e(HttpModule.TAG, "JSONException e:" + paramHttpResponse.getMessage());
          return;
        }
      }
      byte[] arrayOfByte = paramHttpResponse.originalData;
      if (paramMap != null) {}
      for (paramMap = HttpModule.getHeader(paramMap, "Content-Type");; paramMap = "")
      {
        for (;;)
        {
          paramMap = HttpModule.readAsString(arrayOfByte, paramMap);
          try
          {
            localJSONObject.put("data", this.this$0.parseData(paramMap, "json"));
          }
          catch (JSONException paramMap)
          {
            localJSONObject.put("success", 0);
            localJSONObject.put("code", -1);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.module.HttpModule.1
 * JD-Core Version:    0.7.0.1
 */