package com.tencent.viola.ui.context;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import com.tencent.viola.ui.dom.Style;
import java.util.concurrent.ConcurrentHashMap;

class DOMActionContextImpl$ApplyStyleConsumer
  implements DomObject.Consumer
{
  final ConcurrentHashMap<String, DomObject> mRegistry;
  
  DOMActionContextImpl$ApplyStyleConsumer(ConcurrentHashMap<String, DomObject> paramConcurrentHashMap)
  {
    Object localObject;
    this.mRegistry = localObject;
  }
  
  public void accept(DomObject paramDomObject)
  {
    paramDomObject.getStyle();
    if (paramDomObject.getStyle().size() > 0) {
      paramDomObject.applyStyleToNode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl.ApplyStyleConsumer
 * JD-Core Version:    0.7.0.1
 */