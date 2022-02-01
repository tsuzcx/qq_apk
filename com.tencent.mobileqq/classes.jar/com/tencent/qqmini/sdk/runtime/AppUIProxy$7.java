package com.tencent.qqmini.sdk.runtime;

import android.view.ViewGroup;
import com.tencent.qqmini.sdk.manager.PreloadResource;

class AppUIProxy$7
  implements Runnable
{
  AppUIProxy$7(AppUIProxy paramAppUIProxy) {}
  
  public void run()
  {
    if (AppUIProxy.access$500(this.this$0) == null) {
      AppUIProxy.access$502(this.this$0, PreloadResource.g().getAppDebugUI(this.this$0.mActivity));
    }
    if (this.this$0.mRootLayout != null)
    {
      if (AppUIProxy.access$500(this.this$0).getParent() != null) {
        ((ViewGroup)AppUIProxy.access$500(this.this$0).getParent()).removeView(AppUIProxy.access$500(this.this$0));
      }
      this.this$0.mRootLayout.addView(AppUIProxy.access$500(this.this$0));
      AppUIProxy.access$500(this.this$0).setVisibility(0);
      this.this$0.mRootLayout.requestLayout();
      this.this$0.mRootLayout.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.7
 * JD-Core Version:    0.7.0.1
 */