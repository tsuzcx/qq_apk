package com.tencent.viola.core;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;

class V8ViolaBridge$3
  implements Runnable
{
  V8ViolaBridge$3(V8ViolaBridge paramV8ViolaBridge, String paramString1, String paramString2) {}
  
  public void run()
  {
    V8Array localV8Array = new V8Array(V8ViolaBridge.access$100(this.this$0));
    localV8Array.push(this.val$instanceId).push(this.val$code);
    V8ViolaBridge.access$100(this.this$0).executeFunction("callJS", localV8Array);
    localV8Array.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge.3
 * JD-Core Version:    0.7.0.1
 */