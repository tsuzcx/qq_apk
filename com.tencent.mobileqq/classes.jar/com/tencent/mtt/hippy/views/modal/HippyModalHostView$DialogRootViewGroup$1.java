package com.tencent.mtt.hippy.views.modal;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.dom.DomManager;

class HippyModalHostView$DialogRootViewGroup$1
  implements Runnable
{
  HippyModalHostView$DialogRootViewGroup$1(HippyModalHostView.DialogRootViewGroup paramDialogRootViewGroup, HippyEngineContext paramHippyEngineContext, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    HippyEngineContext localHippyEngineContext = this.val$engineContext;
    if ((localHippyEngineContext != null) && (localHippyEngineContext.getDomManager() != null)) {
      this.val$engineContext.getDomManager().updateNodeSize(this.val$id, this.val$w, this.val$h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostView.DialogRootViewGroup.1
 * JD-Core Version:    0.7.0.1
 */