package com.tencent.tissue.v8rt.engine;

class V8JsContext$2
  implements Runnable
{
  V8JsContext$2(V8JsContext paramV8JsContext, String paramString, Callback paramCallback) {}
  
  public void run()
  {
    V8JsBridge.jniEvalJs(V8JsContext.access$000(this.this$0).getId(), V8JsContext.access$100(this.this$0), this.val$js);
    if (this.val$callback != null) {
      this.val$callback.onFinish(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.V8JsContext.2
 * JD-Core Version:    0.7.0.1
 */