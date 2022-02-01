package com.tencent.mobileqq.mini.network.http;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class RequestTask$Request
{
  public static AtomicInteger sId = new AtomicInteger();
  public String mAppName;
  public byte[] mBody;
  public HttpCallBack mCallback;
  public String mDataType = "json";
  public Map<String, String> mHeaders;
  public String mMethod = "GET";
  public String mOriginUrl;
  public long mRequestCreatedMillis;
  public String mResponseType = "text";
  public int mTaskId = sId.getAndIncrement();
  public int mTimeOut;
  public String mUin;
  public String mUrl;
  public String referer = "https://appservice.qq.com/{appid}/{version}/page-frame.html";
  public String ua = "QQ/MiniApp";
  
  public RequestTask$Request(JSONObject paramJSONObject, String paramString1, String paramString2, JsRuntime paramJsRuntime)
  {
    this.referer = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      this.ua = paramString2;
    }
    this.mRequestCreatedMillis = SystemClock.elapsedRealtime();
    merge(paramJSONObject, paramJsRuntime);
  }
  
  public void merge(JSONObject paramJSONObject, JsRuntime paramJsRuntime)
  {
    String str = null;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.mUrl = paramJSONObject.optString("url");
      }
      if (paramJSONObject.has("origin_url"))
      {
        this.mOriginUrl = paramJSONObject.optString("origin_url");
        paramJsRuntime = NativeBuffer.unpackNativeBuffer(paramJSONObject, "data", paramJsRuntime);
        if (paramJsRuntime == null) {
          break label277;
        }
        paramJsRuntime = paramJsRuntime.buf;
        label61:
        this.mBody = paramJsRuntime;
        if ((this.mBody == null) && (paramJSONObject.has("data")))
        {
          paramJsRuntime = paramJSONObject.optString("data");
          if (paramJsRuntime != null) {
            break label282;
          }
        }
      }
      label277:
      label282:
      for (paramJsRuntime = str;; paramJsRuntime = paramJsRuntime.getBytes())
      {
        this.mBody = paramJsRuntime;
        if (paramJSONObject.has("method")) {
          this.mMethod = paramJSONObject.optString("method");
        }
        if (paramJSONObject.has("dataType")) {
          this.mDataType = paramJSONObject.optString("dataType");
        }
        if (paramJSONObject.has("responseType")) {
          this.mResponseType = paramJSONObject.optString("responseType");
        }
        if (!paramJSONObject.has("header")) {
          return;
        }
        paramJSONObject = paramJSONObject.optJSONObject("header");
        paramJsRuntime = paramJSONObject.keys();
        if (this.mHeaders == null)
        {
          this.mHeaders = new HashMap();
          this.mHeaders.put("Referer", this.referer);
          this.mHeaders.put("User-Agent", this.ua);
        }
        while (paramJsRuntime.hasNext())
        {
          str = (String)paramJsRuntime.next();
          this.mHeaders.put(str, paramJSONObject.optString(str));
        }
        this.mOriginUrl = this.mUrl;
        break;
        paramJsRuntime = null;
        break label61;
      }
    }
  }
  
  public boolean preParse()
  {
    return (!TextUtils.isEmpty(this.mUrl)) && (!TextUtils.isEmpty(this.mMethod));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.RequestTask.Request
 * JD-Core Version:    0.7.0.1
 */