package com.tencent.mobileqq.triton.bridge.plugins;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSPlugin;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.utils.ApiUtil;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public abstract class TTInnerJSAbsPlugin
  implements ITTJSPlugin
{
  private final Set<String> EVENT_SET = new HashSet();
  private TTEngine mTritonEngine;
  
  TTInnerJSAbsPlugin(TTEngine paramTTEngine)
  {
    if (paramTTEngine == null) {
      throw new IllegalArgumentException("can't constructor InnerPlugin with null tritonEngine");
    }
    this.mTritonEngine = paramTTEngine;
  }
  
  public void callbackJsEventFail(ITTJSRuntime paramITTJSRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    callbackJsEventFail(paramITTJSRuntime, paramString, paramJSONObject, null, paramInt);
  }
  
  public void callbackJsEventFail(ITTJSRuntime paramITTJSRuntime, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    if (paramITTJSRuntime != null)
    {
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, paramJSONObject, paramString2);
      if (paramString1 == null) {
        break label30;
      }
    }
    label30:
    for (paramString1 = paramString1.toString();; paramString1 = "")
    {
      evaluateJs(paramITTJSRuntime, paramInt, paramString1);
      return;
    }
  }
  
  public void callbackJsEventOK(ITTJSRuntime paramITTJSRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (paramITTJSRuntime != null)
    {
      paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
      if (paramString == null) {
        break label28;
      }
    }
    label28:
    for (paramString = paramString.toString();; paramString = "")
    {
      evaluateJs(paramITTJSRuntime, paramInt, paramString);
      return;
    }
  }
  
  public void evaluateJs(ITTJSRuntime paramITTJSRuntime, int paramInt, String paramString)
  {
    if (paramITTJSRuntime != null) {
      paramITTJSRuntime.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public void evaluateSubscribeJs(ITTJSRuntime paramITTJSRuntime, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    while (paramITTJSRuntime == null) {
      return;
    }
    paramITTJSRuntime.evaluateSubscribeJs(paramString1, paramString2);
  }
  
  public Set<String> getEventMap()
  {
    return this.EVENT_SET;
  }
  
  public TTEngine getTritonEngine()
  {
    return this.mTritonEngine;
  }
  
  public String handleScriptRequest(String paramString1, String paramString2, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    return null;
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.plugins.TTInnerJSAbsPlugin
 * JD-Core Version:    0.7.0.1
 */