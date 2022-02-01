package com.tencent.viola.core;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class V8ViolaBridge$1
  implements Runnable
{
  V8ViolaBridge$1(V8ViolaBridge paramV8ViolaBridge, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$data);
    }
    catch (JSONException localJSONException)
    {
      ViolaLogUtils.e("V8ViolaBridge", localJSONException.getMessage());
      localObject = null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = V8ViolaBridge.jSONObject2V8Object(V8ViolaBridge.access$100(this.this$0), (JSONObject)localObject, localArrayList);
    V8ViolaBridge.access$100(this.this$0).add("ViolaEnv", (V8Value)localObject);
    V8ViolaBridge.access$100(this.this$0).registerJavaMethod(V8ViolaBridge.access$200(this.this$0), "callNative");
    V8ViolaBridge.access$100(this.this$0).registerJavaMethod(V8ViolaBridge.access$300(this.this$0), "setTimeout");
    V8ViolaBridge.access$100(this.this$0).executeScript(this.val$code, "main.js", 0);
    V8ViolaBridge.access$400(this.this$0, localArrayList);
    ((V8Object)localObject).close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge.1
 * JD-Core Version:    0.7.0.1
 */