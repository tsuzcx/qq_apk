package com.tencent.mobileqq.webview.ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class WebViewTitlerBar$3
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  WebViewTitlerBar$3(WebViewTitlerBar paramWebViewTitlerBar, int paramInt) {}
  
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!this.b.q) {
      return;
    }
    this.b.f.getBackground().mutate().setAlpha(paramInteger.intValue());
    this.b.o = paramInteger.intValue();
    if (this.b.o == this.a) {
      this.b.q = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTitlerBar.3
 * JD-Core Version:    0.7.0.1
 */