package com.tencent.mobileqq.minigame.debug;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQDebugWebSocket$ProfileJsPlugin
  extends BaseJsPlugin
{
  private static final String API_TIME_PERFORMANCE_REAULT = "timePerformanceResult";
  public static final String TAG = "[mini] ProfileJsPlugin";
  private Set<String> eventMap;
  
  public QQDebugWebSocket$ProfileJsPlugin(QQDebugWebSocket paramQQDebugWebSocket) {}
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if ("timePerformanceResult".equals(paramString1)) {}
    try
    {
      Object localObject1 = new JSONObject(paramString2);
      Object localObject2 = ((JSONObject)localObject1).optString("result", "");
      int i = ((JSONObject)localObject1).optInt("id", -1);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new JSONArray((String)localObject2);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("id", i);
        ((JSONObject)localObject2).put("result", localObject1);
        localObject1 = QQDebugWebSocket.access$800(this.this$0, ((JSONObject)localObject2).toString());
        this.this$0.sendQQDebugMethodMsg("DebugMessageClient", (String)localObject1);
      }
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("[mini] ProfileJsPlugin", 1, "qq API_TIME_PERFORMANCE_REAULT:", localJSONException);
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    this.eventMap = new HashSet();
    this.eventMap.add("timePerformanceResult");
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.QQDebugWebSocket.ProfileJsPlugin
 * JD-Core Version:    0.7.0.1
 */