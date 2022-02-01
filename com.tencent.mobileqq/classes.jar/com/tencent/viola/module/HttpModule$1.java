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
    if (this.val$callbackId != null) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if ((paramHttpResponse != null) && (!"-1".equals(paramHttpResponse.statusCode)))
        {
          i = Integer.parseInt(paramHttpResponse.statusCode);
          ((JSONObject)localObject).put("code", i);
          if ((i < 200) || (i > 299)) {
            break label328;
          }
          i = 1;
          ((JSONObject)localObject).put("success", i);
          byte[] arrayOfByte = paramHttpResponse.originalData;
          if (arrayOfByte == null)
          {
            ((JSONObject)localObject).put("data", null);
          }
          else
          {
            arrayOfByte = paramHttpResponse.originalData;
            if (paramMap == null) {
              break label333;
            }
            paramMap = HttpModule.getHeader(paramMap, "Content-Type");
            paramMap = HttpModule.readAsString(arrayOfByte, paramMap);
          }
        }
      }
      catch (JSONException paramHttpResponse)
      {
        paramMap = HttpModule.TAG;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("JSONException e:");
        ((StringBuilder)localObject).append(paramHttpResponse.getMessage());
        ViolaLogUtils.e(paramMap, ((StringBuilder)localObject).toString());
      }
      try
      {
        ((JSONObject)localObject).put("data", this.this$0.parseData(paramMap, "json"));
      }
      catch (JSONException paramMap)
      {
        continue;
      }
      ((JSONObject)localObject).put("success", 0);
      ((JSONObject)localObject).put("code", -1);
      ((JSONObject)localObject).put("errorText", HttpStatusText.getStatusText(paramHttpResponse.statusCode));
      continue;
      ((JSONObject)localObject).put("success", 0);
      ((JSONObject)localObject).put("errorText", "ERR_CONNECT_FAILED");
      paramHttpResponse = Message.obtain();
      paramHttpResponse.what = 1;
      paramMap = new Bundle();
      paramMap.putString("callback", this.val$callbackId);
      paramMap.putString("resp", ((JSONObject)localObject).toString());
      paramMap.putString("inctanceId", this.val$instanceId);
      paramHttpResponse.setData(paramMap);
      if (HttpModule.access$000(this.this$0) != null)
      {
        HttpModule.access$000(this.this$0).sendMessage(paramHttpResponse);
        return;
      }
      return;
      label328:
      int i = 0;
      continue;
      label333:
      paramMap = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.module.HttpModule.1
 * JD-Core Version:    0.7.0.1
 */