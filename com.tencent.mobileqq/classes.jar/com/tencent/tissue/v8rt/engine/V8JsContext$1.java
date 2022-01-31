package com.tencent.tissue.v8rt.engine;

import android.os.ConditionVariable;

class V8JsContext$1
  implements Callback
{
  V8JsContext$1(V8JsContext paramV8JsContext, ConditionVariable paramConditionVariable) {}
  
  public void onFinish(Object paramObject)
  {
    this.val$cond.open();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.V8JsContext.1
 * JD-Core Version:    0.7.0.1
 */