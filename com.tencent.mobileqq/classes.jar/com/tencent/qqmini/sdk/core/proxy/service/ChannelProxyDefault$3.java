package com.tencent.qqmini.sdk.core.proxy.service;

import android.util.Base64;
import beks;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class ChannelProxyDefault$3
  implements RequestProxy.RequestListener
{
  ChannelProxyDefault$3(ChannelProxyDefault paramChannelProxyDefault, AsyncResult paramAsyncResult, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    besl.d("ChannelProxyDefault", "onRequestFailed ");
    if (this.val$listener != null) {
      this.val$listener.onReceiveResult(false, null);
    }
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        if (paramArrayOfByte == null) {
          continue;
        }
        if (!this.val$returnAsJSON) {
          continue;
        }
        localJSONObject.put("data", new JSONObject(new String(paramArrayOfByte)));
      }
      catch (Throwable paramArrayOfByte)
      {
        JSONObject localJSONObject;
        besl.d("ChannelProxyDefault", "handleMessage wnsCgiRequest exception ", paramArrayOfByte);
        if (this.val$listener == null) {
          return;
        }
        this.val$listener.onReceiveResult(false, null);
        return;
        paramArrayOfByte = new String(paramArrayOfByte);
        continue;
        localJSONObject.put("data", "");
        continue;
      }
      localJSONObject.put("statusCode", paramInt);
      localJSONObject.put("wnsCode", 0);
      localJSONObject.put("header", beks.a(paramMap));
      if (this.val$listener == null) {
        return;
      }
      this.val$listener.onReceiveResult(true, localJSONObject);
      return;
      if (!this.val$rspBase64) {
        continue;
      }
      paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 0);
      localJSONObject.put("data", paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.3
 * JD-Core Version:    0.7.0.1
 */