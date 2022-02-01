package com.tencent.viola.core;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.module.DomModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class V8ViolaBridge$CallNative
  implements JavaVoidCallback
{
  V8ViolaBridge$CallNative(V8ViolaBridge paramV8ViolaBridge) {}
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramV8Object = paramV8Array.getString(0);
        Object localObject1 = paramV8Array.getArray(1);
        paramV8Array = V8ViolaBridge.v8Array2JSONArray((V8Array)localObject1);
        ((V8Array)localObject1).close();
        if (i < paramV8Array.length())
        {
          localObject1 = paramV8Array.getJSONObject(i);
          Object localObject2 = ((JSONObject)localObject1).get("args");
          boolean bool = ((JSONObject)localObject1).has("module");
          if (bool)
          {
            if ("dom".equals(((JSONObject)localObject1).getString("module")))
            {
              DomModule localDomModule = ViolaModuleManager.getDomModule(paramV8Object);
              if (localDomModule != null) {
                localDomModule.invokeDomMethod(((JSONObject)localObject1).getString("method"), localObject2);
              }
            }
            else
            {
              ViolaBridgeManager.getInstance().callNativeModule(paramV8Object, ((JSONObject)localObject1).getString("module"), ((JSONObject)localObject1).getString("method"), (JSONArray)localObject2, null);
            }
          }
          else if (((JSONObject)localObject1).has("component")) {
            ViolaBridgeManager.getInstance().callNativeComponent(paramV8Object, ((JSONObject)localObject1).getString("component"), ((JSONObject)localObject1).getString("method"), (JSONArray)localObject2);
          }
        }
        else
        {
          paramV8Object = new StringBuilder();
          paramV8Object.append("callSerializableNative params :");
          paramV8Object.append(paramV8Array.toString());
          ViolaLogUtils.d("V8ViolaBridge", paramV8Object.toString());
          return;
        }
      }
      catch (Exception paramV8Object)
      {
        paramV8Array = new StringBuilder();
        paramV8Array.append("callSerializableNative Exception e:");
        paramV8Array.append(paramV8Object.getMessage());
        ViolaLogUtils.e("V8ViolaBridge", paramV8Array.toString());
        return;
      }
      catch (JSONException paramV8Object)
      {
        paramV8Array = new StringBuilder();
        paramV8Array.append("callSerializableNative JSONException e:");
        paramV8Array.append(paramV8Object.getMessage());
        ViolaLogUtils.e("V8ViolaBridge", paramV8Array.toString());
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge.CallNative
 * JD-Core Version:    0.7.0.1
 */