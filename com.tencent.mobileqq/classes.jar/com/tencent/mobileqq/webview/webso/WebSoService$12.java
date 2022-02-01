package com.tencent.mobileqq.webview.webso;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewPropertyAnimator;

final class WebSoService$12
  implements Runnable
{
  WebSoService$12(View paramView, Drawable paramDrawable) {}
  
  public void run()
  {
    ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_AndroidViewView.animate().alpha(0.0F).setDuration(300L);
    localViewPropertyAnimator.setListener(new WebSoService.12.1(this, localViewPropertyAnimator));
    localViewPropertyAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.12
 * JD-Core Version:    0.7.0.1
 */