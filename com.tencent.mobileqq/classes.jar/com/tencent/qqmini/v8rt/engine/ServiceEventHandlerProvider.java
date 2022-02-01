package com.tencent.qqmini.v8rt.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceEventHandlerProvider
{
  public static ServiceEventHandlerProvider sInstance = new ServiceEventHandlerProvider();
  public static Map<V8JsRuntime, IServiceEventHandler> sServiceEventHandlerMap = new ConcurrentHashMap();
  
  public static ServiceEventHandlerProvider getInstance()
  {
    return sInstance;
  }
  
  public IServiceEventHandler getServiceEventHandler(V8JsRuntime paramV8JsRuntime)
  {
    return (IServiceEventHandler)sServiceEventHandlerMap.get(paramV8JsRuntime);
  }
  
  public void removeServiceEventHandler(V8JsRuntime paramV8JsRuntime)
  {
    sServiceEventHandlerMap.remove(paramV8JsRuntime);
  }
  
  public void setServiceEventHandler(V8JsRuntime paramV8JsRuntime, IServiceEventHandler paramIServiceEventHandler)
  {
    sServiceEventHandlerMap.put(paramV8JsRuntime, paramIServiceEventHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.ServiceEventHandlerProvider
 * JD-Core Version:    0.7.0.1
 */