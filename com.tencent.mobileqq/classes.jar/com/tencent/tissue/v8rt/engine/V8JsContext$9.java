package com.tencent.tissue.v8rt.engine;

class V8JsContext$9
  implements Runnable
{
  V8JsContext$9(V8JsContext paramV8JsContext, long paramLong, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    Object localObject = V8JsBridge.jniPtrJsonString(this.val$ptr, V8JsContext.access$100(this.this$0));
    this.val$cb.onFinish(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.V8JsContext.9
 * JD-Core Version:    0.7.0.1
 */