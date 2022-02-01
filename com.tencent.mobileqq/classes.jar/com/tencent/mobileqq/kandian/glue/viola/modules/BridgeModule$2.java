package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.InvokeCallJSCallback;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

class BridgeModule$2
  implements InvokeCallJSCallback
{
  BridgeModule$2(BridgeModule paramBridgeModule) {}
  
  public void invokeCallJS(@android.support.annotation.Nullable String paramString, @android.support.annotation.Nullable Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      invokeJS(paramString, this.a.getSuccInvokeObj(paramObject));
    }
  }
  
  public void invokeErrorCallJS(@android.support.annotation.Nullable String paramString1, @android.support.annotation.Nullable String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      invokeJS(paramString1, this.a.getFailInvokeObj(paramString2));
    }
  }
  
  public void invokeJS(@android.support.annotation.Nullable String paramString, @android.support.annotation.Nullable JSONObject paramJSONObject)
  {
    if (this.a.getViolaInstance() != null) {
      ViolaBridgeManager.getInstance().callbackJavascript(this.a.getViolaInstance().getInstanceId(), this.a.getModuleName(), "callback", paramString, paramJSONObject, true);
    }
  }
  
  public void popBack(@org.jetbrains.annotations.Nullable String paramString)
  {
    BridgeModuleHelper.e(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.2
 * JD-Core Version:    0.7.0.1
 */