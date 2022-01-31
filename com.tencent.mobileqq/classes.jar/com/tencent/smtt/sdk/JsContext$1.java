package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;

class JsContext$1
  implements ValueCallback<IX5JsValue>
{
  JsContext$1(JsContext paramJsContext, ValueCallback paramValueCallback) {}
  
  public void onReceiveValue(IX5JsValue paramIX5JsValue)
  {
    ValueCallback localValueCallback = this.val$resultCallback;
    if (paramIX5JsValue == null) {}
    for (paramIX5JsValue = null;; paramIX5JsValue = new JsValue(this.this$0, paramIX5JsValue))
    {
      localValueCallback.onReceiveValue(paramIX5JsValue);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsContext.1
 * JD-Core Version:    0.7.0.1
 */