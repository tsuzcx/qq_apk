package com.tencent.qqmini.sdk.core.plugins;

import android.os.SystemClock;
import bgpi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class RequestJsPlugin$RequestTask
{
  public byte[] mBody;
  public String mDataType = "json";
  public Map<String, String> mHeaders;
  public String mMethod = "GET";
  public long mRequestCreatedMillis = SystemClock.elapsedRealtime();
  public String mResponseType = "text";
  public int mTaskId = RequestJsPlugin.sRequestId.getAndIncrement();
  public String mUrl;
  
  public RequestJsPlugin$RequestTask(RequestJsPlugin paramRequestJsPlugin, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.mUrl = paramJSONObject.optString("url");
      }
      Object localObject1 = bgpi.a(paramRequestJsPlugin.mMiniAppContext, paramJSONObject, "data");
      if (localObject1 != null)
      {
        localObject1 = ((bgpi)localObject1).a;
        this.mBody = ((byte[])localObject1);
        if ((this.mBody == null) && (paramJSONObject.has("data")))
        {
          localObject1 = paramJSONObject.optString("data");
          if (localObject1 != null) {
            break label285;
          }
        }
      }
      label285:
      for (localObject1 = localObject2;; localObject1 = ((String)localObject1).getBytes())
      {
        this.mBody = ((byte[])localObject1);
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
        localObject1 = paramJSONObject.keys();
        if (this.mHeaders == null)
        {
          this.mHeaders = new HashMap();
          this.mHeaders.put("Referer", RequestJsPlugin.access$600(paramRequestJsPlugin));
        }
        while (((Iterator)localObject1).hasNext())
        {
          paramRequestJsPlugin = (String)((Iterator)localObject1).next();
          this.mHeaders.put(paramRequestJsPlugin, paramJSONObject.optString(paramRequestJsPlugin));
        }
        localObject1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin.RequestTask
 * JD-Core Version:    0.7.0.1
 */