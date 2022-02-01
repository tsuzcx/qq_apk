package com.tencent.mobileqq.forward;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;

class ForwardPreviewTextController$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ForwardPreviewTextController$1(ForwardPreviewTextController paramForwardPreviewTextController) {}
  
  public void onGlobalLayout()
  {
    if (ForwardPreviewTextController.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        ForwardPreviewTextController.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((ForwardPreviewTextController.a(this.a) != null) && (this.a.a != null))
      {
        if (ForwardPreviewTextController.a(this.a).getLineCount() > 1) {
          ForwardPreviewTextController.a(this.a).setGravity(19);
        } else {
          ForwardPreviewTextController.a(this.a).setGravity(17);
        }
        if (ForwardPreviewTextController.a(this.a).getHeight() >= ViewUtils.a(ForwardPreviewTextController.a(this.a) + 2))
        {
          this.a.a.setMaxHeight(ViewUtils.a(450.0F));
          this.a.a.requestLayout();
          if (QLog.isColorLevel()) {
            QLog.d("ForwardPreviewTextController", 2, " reset height ");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTextController.1
 * JD-Core Version:    0.7.0.1
 */