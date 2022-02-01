package com.tencent.viola.ui.component;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;

class VPage$1
  implements View.OnAttachStateChangeListener
{
  VPage$1(VPage paramVPage) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    VPage.access$000(this.this$0).forceLayout();
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VPage.1
 * JD-Core Version:    0.7.0.1
 */