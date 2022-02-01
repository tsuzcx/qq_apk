package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;

class BrandPageWebview$1
  implements StateMachine.OnStateChangeListener
{
  BrandPageWebview$1(BrandPageWebview paramBrandPageWebview) {}
  
  public void onStateChanged()
  {
    if (BrandPageWebview.access$000(this.this$0) != null)
    {
      PageWebview localPageWebview = BrandPageWebview.access$000(this.this$0);
      boolean bool;
      if (this.this$0.getCurrState() == BrandPageWebview.access$100(this.this$0)) {
        bool = true;
      } else {
        bool = false;
      }
      localPageWebview.setPageJsLoadSucc(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.1
 * JD-Core Version:    0.7.0.1
 */