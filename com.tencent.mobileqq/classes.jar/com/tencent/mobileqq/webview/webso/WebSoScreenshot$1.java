package com.tencent.mobileqq.webview.webso;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewPropertyAnimator;

final class WebSoScreenshot$1
  implements Runnable
{
  WebSoScreenshot$1(View paramView, Drawable paramDrawable) {}
  
  public void run()
  {
    ViewPropertyAnimator localViewPropertyAnimator = this.a.animate().alpha(0.0F).setDuration(300L);
    localViewPropertyAnimator.setListener(new WebSoScreenshot.1.1(this, localViewPropertyAnimator));
    localViewPropertyAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoScreenshot.1
 * JD-Core Version:    0.7.0.1
 */