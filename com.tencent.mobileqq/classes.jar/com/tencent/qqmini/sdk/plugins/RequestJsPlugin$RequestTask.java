package com.tencent.qqmini.sdk.plugins;

import android.os.SystemClock;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class RequestJsPlugin$RequestTask
{
  public byte[] mBody;
  public String mDataType = "json";
  public Map<String, String> mHeaders;
  public String mMethod = "GET";
  public String mOriginUrl;
  public long mRequestCreatedMillis = SystemClock.elapsedRealtime();
  public String mResponseType = "text";
  public int mTaskId = RequestProxy.getRequestSocketId();
  public String mUrl;
  
  public RequestJsPlugin$RequestTask(RequestJsPlugin paramRequestJsPlugin, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.mUrl = paramJSONObject.optString("url");
      }
      if (paramJSONObject.has("origin_url"))
      {
        this.mOriginUrl = paramJSONObject.optString("origin_url");
        localObject1 = NativeBuffer.unpackNativeBuffer(RequestJsPlugin.access$2500(paramRequestJsPlugin), paramJSONObject, "data");
        if (localObject1 == null) {
          break label307;
        }
        localObject1 = ((NativeBuffer)localObject1).buf;
        label106:
        this.mBody = ((byte[])localObject1);
        if ((this.mBody == null) && (paramJSONObject.has("data")))
        {
          localObject1 = paramJSONObject.optString("data");
          if (localObject1 != null) {
            break label312;
          }
        }
      }
      label307:
      label312:
      for (Object localObject1 = localObject2;; localObject1 = ((String)localObject1).getBytes())
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
          this.mHeaders.put("Referer", RequestJsPlugin.access$2600(paramRequestJsPlugin));
        }
        while (((Iterator)localObject1).hasNext())
        {
          paramRequestJsPlugin = (String)((Iterator)localObject1).next();
          this.mHeaders.put(paramRequestJsPlugin, paramJSONObject.optString(paramRequestJsPlugin));
        }
        this.mOriginUrl = this.mUrl;
        break;
        localObject1 = null;
        break label106;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.RequestTask
 * JD-Core Version:    0.7.0.1
 */