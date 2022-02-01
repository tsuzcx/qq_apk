package com.tencent.viola.core;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import org.json.JSONObject;

class V8ViolaBridge$8
  implements Runnable
{
  V8ViolaBridge$8(V8ViolaBridge paramV8ViolaBridge, String paramString, JSONObject[] paramArrayOfJSONObject) {}
  
  public void run()
  {
    V8Object localV8Object1 = V8ViolaBridge.access$100(this.this$0).getObject("Viola");
    if (localV8Object1 == null) {
      return;
    }
    V8Object localV8Object2 = localV8Object1.getObject(this.val$key);
    this.val$result[0] = V8ViolaBridge.v8Object2JSONObject(localV8Object2);
    localV8Object2.close();
    localV8Object1.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge.8
 * JD-Core Version:    0.7.0.1
 */