package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.b.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

final class p
  extends b
{
  p(f paramf, WeakReference paramWeakReference, String paramString, File paramFile) {}
  
  public void a(int paramInt1, byte[] paramArrayOfByte, Map paramMap, int paramInt2)
  {
    paramMap = (BaseAppBrandWebview)this.a.get();
    if (paramMap == null) {
      return;
    }
    if (paramInt1 == 200) {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("uploadTaskId", this.b);
        localJSONObject.put("progress", 100);
        localJSONObject.put("totalBytesSent", this.c.length());
        localJSONObject.put("totalBytesExpectedToSend", this.c.length());
        localJSONObject.put("state", "progressUpdate");
        paramMap.evaluteJs("WeixinJSBridge.subscribeHandler(\"onUploadTaskStateChange\", " + localJSONObject + ")");
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        localJSONObject = new JSONObject();
        localJSONObject.put("data", paramArrayOfByte);
        localJSONObject.put("uploadTaskId", this.b);
        localJSONObject.put("statusCode", 200);
        localJSONObject.put("state", "success");
        paramMap.evaluteJs("WeixinJSBridge.subscribeHandler(\"onUploadTaskStateChange\", " + localJSONObject + ")");
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uploadTaskId", this.b);
          localJSONObject.put("state", "fail");
          localJSONObject.put("errMsg", paramArrayOfByte.getMessage());
          paramMap.evaluteJs("WeixinJSBridge.subscribeHandler(\"onUploadTaskStateChange\", " + localJSONObject + ")");
          return;
        }
        catch (Throwable paramArrayOfByte)
        {
          return;
        }
      }
    }
    paramArrayOfByte = new JSONObject();
    paramArrayOfByte.put("uploadTaskId", this.b);
    paramArrayOfByte.put("state", "fail");
    paramArrayOfByte.put("errMsg", "resCode:" + paramInt1);
    paramMap.evaluteJs("WeixinJSBridge.subscribeHandler(\"onUploadTaskStateChange\", " + paramArrayOfByte + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.p
 * JD-Core Version:    0.7.0.1
 */