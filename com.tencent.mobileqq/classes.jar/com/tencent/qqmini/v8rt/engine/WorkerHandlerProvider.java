package com.tencent.qqmini.v8rt.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WorkerHandlerProvider
{
  public static WorkerHandlerProvider sInstance = new WorkerHandlerProvider();
  public static Map<V8JsRuntime, IWorkerEventHandler> sWorkerHandlerProvider = new ConcurrentHashMap();
  
  public static WorkerHandlerProvider getInstance()
  {
    return sInstance;
  }
  
  public IWorkerEventHandler getWorkerHandler(V8JsRuntime paramV8JsRuntime)
  {
    return (IWorkerEventHandler)sWorkerHandlerProvider.get(paramV8JsRuntime);
  }
  
  public void removeWorkerHandler(V8JsRuntime paramV8JsRuntime)
  {
    sWorkerHandlerProvider.remove(paramV8JsRuntime);
  }
  
  public void setWorkerHandler(V8JsRuntime paramV8JsRuntime, IWorkerEventHandler paramIWorkerEventHandler)
  {
    sWorkerHandlerProvider.put(paramV8JsRuntime, paramIWorkerEventHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.WorkerHandlerProvider
 * JD-Core Version:    0.7.0.1
 */