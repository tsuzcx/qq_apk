package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

class JsContext$2
  implements ValueCallback<IX5JsError>
{
  JsContext$2(JsContext paramJsContext) {}
  
  public void onReceiveValue(IX5JsError paramIX5JsError)
  {
    JsContext.access$000(this.this$0).handleException(this.this$0, new JsError(paramIX5JsError));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsContext.2
 * JD-Core Version:    0.7.0.1
 */