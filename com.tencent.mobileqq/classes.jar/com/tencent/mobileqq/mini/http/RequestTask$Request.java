package com.tencent.mobileqq.mini.http;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
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
  public long mRequestCreatedMillis;
  public String mResponseType = "text";
  public int mTaskId = sId.getAndIncrement();
  public int mTimeOut;
  public String mUin;
  public String mUrl;
  public String referer = "https://appservice.qq.com/{appid}/{version}/page-frame.html";
  public String ua = "QQ/MiniApp";
  
  public RequestTask$Request(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    this.referer = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      this.ua = paramString2;
    }
    this.mRequestCreatedMillis = SystemClock.elapsedRealtime();
    merge(paramJSONObject);
  }
  
  public void merge(JSONObject paramJSONObject)
  {
    String str = null;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.mUrl = paramJSONObject.optString("url");
      }
      Object localObject = NativeBuffer.unpackNativeBuffer(paramJSONObject, "data", GameLoadManager.g().getGameEngine().getNativeBufferPool());
      if (localObject != null)
      {
        localObject = ((NativeBuffer)localObject).buf;
        this.mBody = ((byte[])localObject);
        if ((this.mBody == null) && (paramJSONObject.has("data")))
        {
          localObject = paramJSONObject.optString("data");
          if (localObject != null) {
            break label262;
          }
        }
      }
      label262:
      for (localObject = str;; localObject = ((String)localObject).getBytes())
      {
        this.mBody = ((byte[])localObject);
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
        localObject = paramJSONObject.keys();
        if (this.mHeaders == null)
        {
          this.mHeaders = new HashMap();
          this.mHeaders.put("Referer", this.referer);
          this.mHeaders.put("User-Agent", this.ua);
        }
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          this.mHeaders.put(str, paramJSONObject.optString(str));
        }
        localObject = null;
        break;
      }
    }
  }
  
  public boolean preParse()
  {
    return (!TextUtils.isEmpty(this.mUrl)) && (!TextUtils.isEmpty(this.mMethod));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.RequestTask.Request
 * JD-Core Version:    0.7.0.1
 */