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
    DomObject localDomObject;
    if (paramDomObject.hasUpdate())
    {
      paramDomObject.markUpdateSeen();
      if (!paramDomObject.isYoung())
      {
        localDomObject = paramDomObject.clone();
        if (localDomObject != null) {
          break label28;
        }
      }
    }
    return;
    label28:
    DOMActionContextImpl.access$300(this.this$0).add(new DOMActionContextImpl.ApplyUpdateConsumer.1(this, localDomObject, paramDomObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl.ApplyUpdateConsumer
 * JD-Core Version:    0.7.0.1
 */