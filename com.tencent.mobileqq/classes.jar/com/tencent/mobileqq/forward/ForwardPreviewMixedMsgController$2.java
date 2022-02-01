package com.tencent.mobileqq.forward;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class ForwardPreviewMixedMsgController$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ForwardPreviewMixedMsgController$2(ForwardPreviewMixedMsgController paramForwardPreviewMixedMsgController) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    ForwardPreviewMixedMsgController.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewMixedMsgController.2
 * JD-Core Version:    0.7.0.1
 */