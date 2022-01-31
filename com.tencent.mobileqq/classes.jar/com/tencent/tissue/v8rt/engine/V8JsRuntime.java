package com.tencent.tissue.v8rt.engine;

public class V8JsRuntime
{
  private V8JsContext defaultJsContext;
  private int engineId;
  private final JsRuntimeThread jsRuntimeThread;
  
  public V8JsRuntime(int paramInt)
  {
    this.engineId = paramInt;
    this.jsRuntimeThread = new JsRuntimeThread(paramInt);
    this.defaultJsContext = new V8JsContext(this, 0);
  }
  
  public V8JsContext getDefaultContext()
  {
    return this.defaultJsContext;
  }
  
  public int getId()
  {
    return this.engineId;
  }
  
  public JsRuntimeThread getJsRuntimeThread()
  {
    return this.jsRuntimeThread;
  }
  
  public void release()
  {
    this.jsRuntimeThread.release();
    Engine.getInstance().removeJsRuntime(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.V8JsRuntime
 * JD-Core Version:    0.7.0.1
 */