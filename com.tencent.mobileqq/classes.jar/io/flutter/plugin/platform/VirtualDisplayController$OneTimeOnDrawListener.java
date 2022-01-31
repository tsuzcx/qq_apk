package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;

@TargetApi(16)
class VirtualDisplayController$OneTimeOnDrawListener
  implements ViewTreeObserver.OnDrawListener
{
  Runnable mOnDrawRunnable;
  final View mView;
  
  VirtualDisplayController$OneTimeOnDrawListener(View paramView, Runnable paramRunnable)
  {
    this.mView = paramView;
    this.mOnDrawRunnable = paramRunnable;
  }
  
  static void schedule(View paramView, Runnable paramRunnable)
  {
    paramRunnable = new OneTimeOnDrawListener(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnDrawListener(paramRunnable);
  }
  
  public void onDraw()
  {
    if (this.mOnDrawRunnable == null) {
      return;
    }
    this.mOnDrawRunnable.run();
    this.mOnDrawRunnable = null;
    this.mView.post(new VirtualDisplayController.OneTimeOnDrawListener.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.plugin.platform.VirtualDisplayController.OneTimeOnDrawListener
 * JD-Core Version:    0.7.0.1
 */