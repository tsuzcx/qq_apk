package com.tencent.viola.ui.context;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import java.util.List;

class DOMActionContextImpl$ApplyUpdateConsumer
  implements DomObject.Consumer
{
  private DOMActionContextImpl$ApplyUpdateConsumer(DOMActionContextImpl paramDOMActionContextImpl) {}
  
  public void accept(DomObject paramDomObject)
  {
    if (paramDomObject.hasUpdate())
    {
      paramDomObject.markUpdateSeen();
      if (!paramDomObject.isYoung())
      {
        DomObject localDomObject = paramDomObject.clone();
        if (localDomObject == null) {
          return;
        }
        DOMActionContextImpl.access$300(this.this$0).add(new DOMActionContextImpl.ApplyUpdateConsumer.1(this, localDomObject, paramDomObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl.ApplyUpdateConsumer
 * JD-Core Version:    0.7.0.1
 */