package com.tencent.mobileqq.triton.bridge.plugins;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.utils.SystemInfoManager;
import java.util.Arrays;
import java.util.Set;
import org.json.JSONObject;

public class SystemPlugin
  extends TTInnerJSAbsPlugin
{
  private static final String TAG = "SystemPlugin";
  
  public SystemPlugin(TTEngine paramTTEngine)
  {
    super(paramTTEngine);
    getEventMap().addAll(Arrays.asList(new String[] { "getSystemInfo", "getSystemInfoSync" }));
  }
  
  public String handleScriptRequest(String paramString1, String paramString2, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    TTLog.d("SystemPlugin", "handleScriptRequest() called with: eventName = [" + paramString1 + "], jsonParams = [" + paramString2 + "], callbackId = [" + paramInt + "], jsRuntime = [" + paramITTJSRuntime + "]");
    if (("getSystemInfo".equals(paramString1)) || ("getSystemInfoSync".equals(paramString1)))
    {
      paramString2 = getTritonEngine().getSystemInfoManager().getSystemInfo();
      if ("getSystemInfoSync".equals(paramString1)) {
        return paramString2.toString();
      }
      paramITTJSRuntime.evaluateCallbackJs(paramInt, paramString2.toString());
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.plugins.SystemPlugin
 * JD-Core Version:    0.7.0.1
 */