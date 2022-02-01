package com.tencent.mtt.hippy.views.modal;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class HippyModalHostView$1
  implements DialogInterface.OnShowListener
{
  HippyModalHostView$1(HippyModalHostView paramHippyModalHostView) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    HippyModalHostView.access$000(this.this$0).onShow(paramDialogInterface);
    if (HippyModalHostView.access$100(this.this$0) == 1)
    {
      paramDialogInterface = ObjectAnimator.ofFloat(HippyModalHostView.access$200(this.this$0), "alpha", new float[] { 0.0F, 1.0F });
      paramDialogInterface.setDuration(200L);
      paramDialogInterface.start();
    }
    while (HippyModalHostView.access$100(this.this$0) != 2) {
      return;
    }
    paramDialogInterface = ObjectAnimator.ofFloat(HippyModalHostView.access$200(this.this$0), "translationY", new float[] { 0.0F });
    paramDialogInterface.setDuration(200L);
    paramDialogInterface.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostView.1
 * JD-Core Version:    0.7.0.1
 */