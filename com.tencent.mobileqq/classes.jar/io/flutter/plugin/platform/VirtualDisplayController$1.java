package io.flutter.plugin.platform;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class VirtualDisplayController$1
  implements View.OnAttachStateChangeListener
{
  VirtualDisplayController$1(VirtualDisplayController paramVirtualDisplayController, View paramView, Runnable paramRunnable) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    VirtualDisplayController.OneTimeOnDrawListener.schedule(this.val$embeddedView, new VirtualDisplayController.1.1(this));
    this.val$embeddedView.removeOnAttachStateChangeListener(this);
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugin.platform.VirtualDisplayController.1
 * JD-Core Version:    0.7.0.1
 */