package com.tencent.qqmini.sdk.plugins;

import android.os.SystemClock;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class RequestJsPlugin$RequestTask
{
  public byte[] mBody;
  public String mDataType = "json";
  public Map<String, String> mHeaders = new HashMap();
  private final IJsService mJsService;
  public String mMethod = "GET";
  public String mOriginUrl;
  public long mRequestCreatedMillis;
  public String mResponseType = "text";
  public int mTaskId;
  public String mUrl;
  
  public RequestJsPlugin$RequestTask(RequestJsPlugin paramRequestJsPlugin, IJsService paramIJsService, JSONObject paramJSONObject)
  {
    this.mJsService = paramIJsService;
    this.mTaskId = RequestProxy.getRequestSocketId();
    this.mRequestCreatedMillis = SystemClock.elapsedRealtime();
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.mUrl = paramJSONObject.optString("url");
      }
      if (!paramJSONObject.has("origin_url")) {
        break label259;
      }
      this.mOriginUrl = paramJSONObject.optString("origin_url");
      paramIJsService = NativeBuffer.unpackNativeBuffer(this.mJsService, paramJSONObject, "data");
      if (paramIJsService == null) {
        break label270;
      }
      paramIJsService = paramIJsService.buf;
      label122:
      this.mBody = paramIJsService;
      if ((this.mBody == null) && (paramJSONObject.has("data")))
      {
        paramIJsService = paramJSONObject.optString("data");
        if (paramIJsService != null) {
          break label275;
        }
      }
    }
    label259:
    label270:
    label275:
    for (paramIJsService = localObject;; paramIJsService = paramIJsService.getBytes())
    {
      this.mBody = paramIJsService;
      if (paramJSONObject.has("method")) {
        this.mMethod = paramJSONObject.optString("method");
      }
      if (paramJSONObject.has("dataType")) {
        this.mDataType = paramJSONObject.optString("dataType");
      }
      if (paramJSONObject.has("responseType")) {
        this.mResponseType = paramJSONObject.optString("responseType");
      }
      RequestJsPlugin.access$2100(this.mHeaders, paramJSONObject);
      this.mHeaders.put("Referer", RequestJsPlugin.access$2200(paramRequestJsPlugin));
      this.mHeaders.put("User-Agent", QUAUtil.getRequestUA());
      return;
      this.mOriginUrl = this.mUrl;
      break;
      paramIJsService = null;
      break label122;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.RequestTask
 * JD-Core Version:    0.7.0.1
 */