package com.tencent.qqmini.v8rt.engine;

class V8JsContext$7
  implements Runnable
{
  V8JsContext$7(V8JsContext paramV8JsContext, String paramString, Callback paramCallback) {}
  
  public void run()
  {
    long l = V8JsBridge.jniEvalJsWithReturnPtr(V8JsContext.access$000(this.this$0).getId(), V8JsContext.access$100(this.this$0), this.val$js);
    Callback localCallback = this.val$callback;
    if (localCallback != null) {
      localCallback.onFinish(Long.valueOf(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.V8JsContext.7
 * JD-Core Version:    0.7.0.1
 */