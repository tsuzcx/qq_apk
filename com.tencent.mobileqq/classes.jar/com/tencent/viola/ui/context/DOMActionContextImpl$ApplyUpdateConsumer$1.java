package com.tencent.viola.ui.context;

import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.ui.action.IRenderTask;
import com.tencent.viola.ui.dom.DomObject;

class DOMActionContextImpl$ApplyUpdateConsumer$1
  implements IRenderTask
{
  DOMActionContextImpl$ApplyUpdateConsumer$1(DOMActionContextImpl.ApplyUpdateConsumer paramApplyUpdateConsumer, DomObject paramDomObject1, DomObject paramDomObject2) {}
  
  public void execute()
  {
    if (DOMActionContextImpl.access$100(this.this$1.this$0) != null)
    {
      DOMActionContextImpl.access$100(this.this$1.this$0).setLayout(DOMActionContextImpl.access$200(this.this$1.this$0), this.val$copy.getRef(), this.val$dom);
      if (this.val$copy.getExtra() != null) {
        DOMActionContextImpl.access$100(this.this$1.this$0).setExtra(DOMActionContextImpl.access$200(this.this$1.this$0), this.val$copy.getRef(), this.val$copy.getExtra());
      }
    }
  }
  
  public String toString()
  {
    return "setLayout & setExtra";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl.ApplyUpdateConsumer.1
 * JD-Core Version:    0.7.0.1
 */