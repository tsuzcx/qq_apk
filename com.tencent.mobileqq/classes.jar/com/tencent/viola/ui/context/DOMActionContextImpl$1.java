package com.tencent.viola.ui.context;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;

class DOMActionContextImpl$1
  implements DomObject.Consumer
{
  DOMActionContextImpl$1(DOMActionContextImpl paramDOMActionContextImpl) {}
  
  public void accept(DomObject paramDomObject)
  {
    if (paramDomObject.hasUpdate())
    {
      if (DOMActionContextImpl.access$300(this.this$0)) {
        return;
      }
      paramDomObject.layoutBefore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl.1
 * JD-Core Version:    0.7.0.1
 */