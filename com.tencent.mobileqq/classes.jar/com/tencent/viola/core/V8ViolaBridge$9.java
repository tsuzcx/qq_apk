package com.tencent.viola.core;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import java.util.ArrayList;
import org.json.JSONObject;

class V8ViolaBridge$9
  implements Runnable
{
  V8ViolaBridge$9(V8ViolaBridge paramV8ViolaBridge, JSONObject paramJSONObject, String paramString) {}
  
  public void run()
  {
    V8Object localV8Object1 = V8ViolaBridge.access$100(this.this$0).getObject("Viola");
    if (localV8Object1 == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    V8Object localV8Object2 = V8ViolaBridge.jSONObject2V8Object(V8ViolaBridge.access$100(this.this$0), this.val$var, localArrayList);
    localV8Object1.add(this.val$key, localV8Object2);
    V8ViolaBridge.access$400(this.this$0, localArrayList);
    localV8Object2.close();
    localV8Object1.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge.9
 * JD-Core Version:    0.7.0.1
 */