package com.tencent.viola.core;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.utils.ViolaLogUtils;

class V8ViolaBridge$SetTimeout
  implements JavaVoidCallback
{
  V8ViolaBridge$SetTimeout(V8ViolaBridge paramV8ViolaBridge) {}
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    try
    {
      paramV8Object = V8ViolaBridge.v8Array2JSONArray(paramV8Array);
      ViolaModuleManager.callModuleMethod(ViolaSDKManager.getCurInstanceId(), "jsTimer", "setTimeout", paramV8Object);
      return;
    }
    catch (Throwable paramV8Object)
    {
      paramV8Array = new StringBuilder();
      paramV8Array.append("SetTimeout: ");
      paramV8Array.append(paramV8Object.getMessage());
      ViolaLogUtils.d("V8ViolaBridge", paramV8Array.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge.SetTimeout
 * JD-Core Version:    0.7.0.1
 */