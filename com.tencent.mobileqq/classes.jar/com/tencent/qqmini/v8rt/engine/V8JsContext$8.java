package com.tencent.qqmini.v8rt.engine;

import android.os.ConditionVariable;

class V8JsContext$8
  extends ValueCallback
{
  V8JsContext$8(V8JsContext paramV8JsContext, Object paramObject, ConditionVariable paramConditionVariable)
  {
    super(paramObject);
  }
  
  public void onFinish(Object paramObject)
  {
    this.value = paramObject;
    this.val$cond.open();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.V8JsContext.8
 * JD-Core Version:    0.7.0.1
 */