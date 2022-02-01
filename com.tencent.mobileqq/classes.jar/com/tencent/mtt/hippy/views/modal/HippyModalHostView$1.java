package com.tencent.mtt.hippy.views.modal;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class HippyModalHostView$1
  implements DialogInterface.OnShowListener
{
  HippyModalHostView$1(HippyModalHostView paramHippyModalHostView) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    HippyModalHostView.access$000(this.this$0).onShow(paramDialogInterface);
    int i = HippyModalHostView.access$100(this.this$0);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          paramDialogInterface = null;
        }
        else
        {
          paramDialogInterface = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F });
          PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("translationY", new float[] { 0.0F });
          paramDialogInterface = ObjectAnimator.ofPropertyValuesHolder(HippyModalHostView.access$200(this.this$0), new PropertyValuesHolder[] { paramDialogInterface, localPropertyValuesHolder });
        }
      }
      else {
        paramDialogInterface = ObjectAnimator.ofFloat(HippyModalHostView.access$200(this.this$0), "translationY", new float[] { 0.0F });
      }
    }
    else {
      paramDialogInterface = ObjectAnimator.ofFloat(HippyModalHostView.access$200(this.this$0), "alpha", new float[] { 0.0F, 1.0F });
    }
    if (paramDialogInterface != null)
    {
      paramDialogInterface.setDuration(200L);
      paramDialogInterface.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostView.1
 * JD-Core Version:    0.7.0.1
 */