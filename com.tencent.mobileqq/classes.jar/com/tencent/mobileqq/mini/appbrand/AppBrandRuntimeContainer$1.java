package com.tencent.mobileqq.mini.appbrand;

import android.widget.FrameLayout;
import com.tencent.mobileqq.mini.appbrand.ui.DebugLayout;

class AppBrandRuntimeContainer$1
  implements Runnable
{
  AppBrandRuntimeContainer$1(AppBrandRuntimeContainer paramAppBrandRuntimeContainer) {}
  
  public void run()
  {
    AppBrandRuntimeContainer.access$000(this.this$0).setVisibility(0);
    AppBrandRuntimeContainer.access$000(this.this$0).bringToFront();
    AppBrandRuntimeContainer.access$100(this.this$0).requestLayout();
    AppBrandRuntimeContainer.access$100(this.this$0).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer.1
 * JD-Core Version:    0.7.0.1
 */