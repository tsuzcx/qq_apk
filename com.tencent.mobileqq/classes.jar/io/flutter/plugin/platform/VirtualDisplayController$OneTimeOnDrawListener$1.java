package io.flutter.plugin.platform;

import android.view.View;
import android.view.ViewTreeObserver;

class VirtualDisplayController$OneTimeOnDrawListener$1
  implements Runnable
{
  VirtualDisplayController$OneTimeOnDrawListener$1(VirtualDisplayController.OneTimeOnDrawListener paramOneTimeOnDrawListener) {}
  
  public void run()
  {
    this.this$0.mView.getViewTreeObserver().removeOnDrawListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.VirtualDisplayController.OneTimeOnDrawListener.1
 * JD-Core Version:    0.7.0.1
 */