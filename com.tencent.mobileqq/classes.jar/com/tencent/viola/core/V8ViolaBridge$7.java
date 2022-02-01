package com.tencent.viola.core;

import com.eclipsesource.v8.V8;

class V8ViolaBridge$7
  implements Runnable
{
  V8ViolaBridge$7(V8ViolaBridge paramV8ViolaBridge) {}
  
  public void run()
  {
    if (V8ViolaBridge.access$500(this.this$0) != null) {
      V8ViolaBridge.access$100(this.this$0).removeReferenceHandler(V8ViolaBridge.access$500(this.this$0));
    }
    V8ViolaBridge.access$100(this.this$0).close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge.7
 * JD-Core Version:    0.7.0.1
 */