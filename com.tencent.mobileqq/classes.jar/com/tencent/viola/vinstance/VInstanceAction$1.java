package com.tencent.viola.vinstance;

import com.tencent.viola.core.ViolaInstance;

class VInstanceAction$1
  implements Runnable
{
  VInstanceAction$1(VInstanceAction paramVInstanceAction) {}
  
  public void run()
  {
    this.this$0.violaInstance.renderJSSource(this.this$0.preconditor.getServiceJsCode(), this.this$0.preconditor.getAdapter().getPageData(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.vinstance.VInstanceAction.1
 * JD-Core Version:    0.7.0.1
 */