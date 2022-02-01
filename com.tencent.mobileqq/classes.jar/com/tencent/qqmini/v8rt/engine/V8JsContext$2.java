package com.tencent.qqmini.v8rt.engine;

class V8JsContext$2
  implements Runnable
{
  V8JsContext$2(V8JsContext paramV8JsContext, String paramString, Callback paramCallback) {}
  
  public void run()
  {
    V8JsBridge.jniEvalJs(V8JsContext.access$000(this.this$0).getId(), V8JsContext.access$100(this.this$0), this.val$js);
    Callback localCallback = this.val$callback;
    if (localCallback != null) {
      localCallback.onFinish(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.V8JsContext.2
 * JD-Core Version:    0.7.0.1
 */