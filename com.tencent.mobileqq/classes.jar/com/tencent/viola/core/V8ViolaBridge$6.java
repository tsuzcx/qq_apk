package com.tencent.viola.core;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.tencent.viola.utils.ViolaUtils;

class V8ViolaBridge$6
  implements Runnable
{
  V8ViolaBridge$6(V8ViolaBridge paramV8ViolaBridge, String paramString) {}
  
  public void run()
  {
    V8Array localV8Array = new V8Array(V8ViolaBridge.access$100(this.this$0));
    localV8Array.push(this.val$instanceId);
    V8ViolaBridge.access$100(this.this$0).executeFunction("destroyInstance", localV8Array);
    localV8Array.close();
    if (ViolaUtils.triggerV8GcWhenDestroy()) {
      V8ViolaBridge.access$100(this.this$0).lowMemoryNotification();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge.6
 * JD-Core Version:    0.7.0.1
 */