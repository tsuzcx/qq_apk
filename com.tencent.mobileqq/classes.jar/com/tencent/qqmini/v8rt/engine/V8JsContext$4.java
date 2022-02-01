package com.tencent.qqmini.v8rt.engine;

class V8JsContext$4
  implements Runnable
{
  V8JsContext$4(V8JsContext paramV8JsContext, String paramString, Callback paramCallback) {}
  
  public void run()
  {
    Object localObject = V8JsBridge.jniEvalJsWithReturn(V8JsContext.access$000(this.this$0).getId(), V8JsContext.access$100(this.this$0), this.val$js);
    this.val$callback.onFinish(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.V8JsContext.4
 * JD-Core Version:    0.7.0.1
 */