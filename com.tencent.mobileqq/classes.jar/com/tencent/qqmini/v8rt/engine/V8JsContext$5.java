package com.tencent.qqmini.v8rt.engine;

class V8JsContext$5
  implements Runnable
{
  V8JsContext$5(V8JsContext paramV8JsContext, String paramString1, String paramString2, String paramString3, Callback paramCallback) {}
  
  public void run()
  {
    Engine.loadScriptStringWithCodeCache(V8JsContext.access$000(this.this$0).getId(), V8JsContext.access$100(this.this$0), this.val$jsStr, this.val$scriptName, this.val$codeCacheAbsolutePath);
    Callback localCallback = this.val$callback;
    if (localCallback != null) {
      localCallback.onFinish(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.V8JsContext.5
 * JD-Core Version:    0.7.0.1
 */