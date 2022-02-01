package com.tencent.viola.ui.context;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import java.util.concurrent.ConcurrentHashMap;

class DOMActionContextImpl$RemoveElementConsumer
  implements DomObject.Consumer
{
  final ConcurrentHashMap<String, DomObject> mRegistry;
  
  DOMActionContextImpl$RemoveElementConsumer(ConcurrentHashMap<String, DomObject> paramConcurrentHashMap)
  {
    this.mRegistry = paramConcurrentHashMap;
  }
  
  public void accept(DomObject paramDomObject)
  {
    this.mRegistry.remove(paramDomObject.getRef());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl.RemoveElementConsumer
 * JD-Core Version:    0.7.0.1
 */