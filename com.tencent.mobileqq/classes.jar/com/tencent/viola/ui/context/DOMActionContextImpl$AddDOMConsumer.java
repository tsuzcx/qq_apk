package com.tencent.viola.ui.context;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import java.util.concurrent.ConcurrentHashMap;

class DOMActionContextImpl$AddDOMConsumer
  implements DomObject.Consumer
{
  final ConcurrentHashMap<String, DomObject> mRegistry;
  
  DOMActionContextImpl$AddDOMConsumer(ConcurrentHashMap<String, DomObject> paramConcurrentHashMap)
  {
    Object localObject;
    this.mRegistry = localObject;
  }
  
  public void accept(DomObject paramDomObject)
  {
    this.mRegistry.put(paramDomObject.getRef(), paramDomObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl.AddDOMConsumer
 * JD-Core Version:    0.7.0.1
 */