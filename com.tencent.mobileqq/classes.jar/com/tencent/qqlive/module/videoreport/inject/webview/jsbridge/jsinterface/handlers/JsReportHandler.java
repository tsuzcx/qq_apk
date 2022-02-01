package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.IJsObjectHandler;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JsReportHandler
  extends BaseJsHandler
  implements IJsObjectHandler
{
  private static final String KEY_APP_KEY = "appKey";
  private static final String KEY_EVENT_ID = "eventId";
  private static final String KEY_PARAMS = "params";
  
  public JsReportHandler(WeakReference<Object> paramWeakReference)
  {
    super(paramWeakReference);
  }
  
  private String getAppKey(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    return paramJSONObject.optString("appKey", "");
  }
  
  private String getEventId(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    return paramJSONObject.optString("eventId", "");
  }
  
  private JSONObject getParams(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    return paramJSONObject.optJSONObject("params");
  }
  
  private void reportEvent(String paramString1, Map<String, Object> paramMap, String paramString2, String paramString3)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString2)) {
      bool = VideoReportInner.getInstance().reportEvent(paramString1, paramMap);
    } else {
      bool = VideoReportInner.getInstance().reportEventWithoutFormat(paramString1, paramMap, paramString2);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      if (bool)
      {
        callback(paramString3, "200", "success", null);
        return;
      }
      callback(paramString3, "500", "fail", null);
    }
  }
  
  private Map<String, Object> wrapJsonToMap(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str2 = String.valueOf(localIterator.next());
      Object localObject;
      try
      {
        String str1 = paramJSONObject.get(str2).toString();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject = null;
      }
      localHashMap.put(str2, localObject);
    }
    return localHashMap;
  }
  
  public void handle(String paramString, JSONObject paramJSONObject)
  {
    paramString = getEventId(paramJSONObject);
    String str = getAppKey(paramJSONObject);
    JSONObject localJSONObject = getParams(paramJSONObject);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    reportEvent(paramString, wrapJsonToMap(localJSONObject), str, getCallbackId(paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.JsReportHandler
 * JD-Core Version:    0.7.0.1
 */