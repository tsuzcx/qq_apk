package com.tencent.mobileqq.webview.swift.component;

import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

class SwiftBrowserScreenShotHandler$5
  implements Animation.AnimationListener
{
  SwiftBrowserScreenShotHandler$5(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->on hideAnimationEnd!");
    }
    this.a.g.setVisibility(8);
    if ((this.a.h != null) && (!this.a.h.isRecycled())) {
      this.a.h = null;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.5
 * JD-Core Version:    0.7.0.1
 */