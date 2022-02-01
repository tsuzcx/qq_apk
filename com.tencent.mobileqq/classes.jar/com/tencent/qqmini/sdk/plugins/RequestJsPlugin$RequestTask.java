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
    if (paramJSONObject == null) {
      return;
    }
    this.mUrl = paramJSONObject.optString("url", "");
    if (paramJSONObject.has("origin_url")) {
      this.mOriginUrl = paramJSONObject.optString("origin_url");
    } else {
      this.mOriginUrl = this.mUrl;
    }
    this.mMethod = paramJSONObject.optString("method", this.mMethod);
    this.mDataType = paramJSONObject.optString("dataType", this.mDataType);
    this.mResponseType = paramJSONObject.optString("responseType", this.mResponseType);
    RequestJsPlugin.access$1300(this.mHeaders, paramJSONObject);
    this.mHeaders.put("Referer", RequestJsPlugin.access$1000(paramRequestJsPlugin));
    this.mHeaders.put("User-Agent", QUAUtil.getRequestUA());
    processBody(paramJSONObject);
  }
  
  private void processBody(JSONObject paramJSONObject)
  {
    Object localObject1 = NativeBuffer.unpackNativeBuffer(this.mJsService, paramJSONObject, "data");
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((NativeBuffer)localObject1).buf;
    } else {
      localObject1 = null;
    }
    this.mBody = ((byte[])localObject1);
    if ((this.mBody == null) && (paramJSONObject.has("data")))
    {
      paramJSONObject = paramJSONObject.optString("data");
      if (paramJSONObject == null) {
        paramJSONObject = localObject2;
      } else {
        paramJSONObject = paramJSONObject.getBytes();
      }
      this.mBody = paramJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.RequestTask
 * JD-Core Version:    0.7.0.1
 */