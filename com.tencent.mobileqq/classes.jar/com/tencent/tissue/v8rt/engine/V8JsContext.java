package com.tencent.tissue.v8rt.engine;

import android.os.ConditionVariable;

public class V8JsContext
{
  public static final int DEFAULT_CONTEXT_ID = 0;
  private final String LOG_TAG;
  private int contextId;
  private V8JsRuntime v8JsRuntime;
  
  public V8JsContext(V8JsRuntime paramV8JsRuntime, int paramInt)
  {
    this.v8JsRuntime = paramV8JsRuntime;
    this.contextId = paramInt;
    this.LOG_TAG = ("V8JsCt-" + paramV8JsRuntime.getId() + "-" + paramInt);
  }
  
  private JsRuntimeThread getJsRunner()
  {
    return this.v8JsRuntime.getJsRuntimeThread();
  }
  
  public void cleanGlobal()
  {
    JsRuntimeLoader.cleanGlobal(this);
  }
  
  public Object convertPtrJsonString(long paramLong)
  {
    if (getJsRunner().isReleased())
    {
      Logger.e(this.LOG_TAG, "convertPtrJsonString fail, thread released");
      return Integer.valueOf(0);
    }
    ConditionVariable localConditionVariable = new ConditionVariable();
    V8JsContext.8 local8 = new V8JsContext.8(this, null, localConditionVariable);
    getJsRunner().run(this, new V8JsContext.9(this, paramLong, local8));
    localConditionVariable.block();
    return local8.value;
  }
  
  public void evaluateJsAsync(String paramString, Callback paramCallback)
  {
    if (getJsRunner().isReleased())
    {
      Logger.e(this.LOG_TAG, "evaluateJsAsync fail, thread released");
      return;
    }
    getJsRunner().run(this, new V8JsContext.2(this, paramString, paramCallback));
  }
  
  public void evaluateJsAsyncWithCodeCache(String paramString1, Callback paramCallback, String paramString2, String paramString3)
  {
    if (getJsRunner().isReleased())
    {
      Logger.e(this.LOG_TAG, "evaluateJsAsync fail, thread released");
      return;
    }
    getJsRunner().run(this, new V8JsContext.5(this, paramString1, paramString2, paramString3, paramCallback));
  }
  
  public void evaluateJsAsyncWithReturn(String paramString, Callback paramCallback)
  {
    getJsRunner().run(this, new V8JsContext.4(this, paramString, paramCallback));
  }
  
  public void evaluateJsAsyncWithReturnPtr(String paramString, Callback paramCallback)
  {
    if (getJsRunner().isReleased())
    {
      Logger.e(this.LOG_TAG, "evaluateJsAsyncWithReturnPtr fail, thread released");
      return;
    }
    getJsRunner().run(this, new V8JsContext.7(this, paramString, paramCallback));
  }
  
  public void evaluateJsSync(String paramString)
  {
    if (getJsRunner().isReleased())
    {
      Logger.e(this.LOG_TAG, "evaluateJsSync fail, thread released");
      return;
    }
    ConditionVariable localConditionVariable = new ConditionVariable();
    evaluateJsAsync(paramString, new V8JsContext.1(this, localConditionVariable));
    localConditionVariable.block();
  }
  
  public long evaluateJsWithReturnPtrSync(String paramString)
  {
    if (getJsRunner().isReleased())
    {
      Logger.e(this.LOG_TAG, "evaluateJsWithReturnSync fail, thread released");
      return 0L;
    }
    ConditionVariable localConditionVariable = new ConditionVariable();
    V8JsContext.6 local6 = new V8JsContext.6(this, null, localConditionVariable);
    evaluateJsAsyncWithReturnPtr(paramString, local6);
    localConditionVariable.block();
    return ((Long)local6.value).longValue();
  }
  
  public Object evaluateJsWithReturnSync(String paramString)
  {
    if (getJsRunner().isReleased())
    {
      Logger.e(this.LOG_TAG, "evaluateJsWithReturnSync fail, thread released");
      return null;
    }
    ConditionVariable localConditionVariable = new ConditionVariable();
    V8JsContext.3 local3 = new V8JsContext.3(this, null, localConditionVariable);
    evaluateJsAsyncWithReturn(paramString, local3);
    localConditionVariable.block();
    return local3.value;
  }
  
  public int getContextId()
  {
    return this.contextId;
  }
  
  public V8JsRuntime getV8JsRuntime()
  {
    return this.v8JsRuntime;
  }
  
  public void injectAll()
  {
    injectGlobalConfig();
    injectConsole();
    injectTimer();
    injectJsBridge();
    cleanGlobal();
  }
  
  public void injectConsole()
  {
    Engine.nativeInjectConsole(this.v8JsRuntime.getId(), this.contextId);
    JsRuntimeLoader.injectBasicJs(Engine.getInstance().mEnginePathProvider, new String[] { "console.js" }, this);
  }
  
  public void injectGlobalConfig()
  {
    JsRuntimeLoader.injectGlobalConfig(this);
  }
  
  public void injectJsBridge()
  {
    Engine.nativeInjectJsBridge(this.v8JsRuntime.getId(), this.contextId);
  }
  
  public void injectNativeBuffer()
  {
    Engine.nativeInjectNativeBuffer(this.v8JsRuntime.getId(), this.contextId);
  }
  
  public void injectTimer()
  {
    Engine.nativeInjectTimer(this.v8JsRuntime.getId(), this.contextId);
    JsRuntimeLoader.injectBasicJs(Engine.getInstance().mEnginePathProvider, new String[] { "timer.js" }, this);
  }
  
  public String toString()
  {
    return "V8JsContext(" + this.v8JsRuntime.getId() + "," + this.contextId + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.V8JsContext
 * JD-Core Version:    0.7.0.1
 */