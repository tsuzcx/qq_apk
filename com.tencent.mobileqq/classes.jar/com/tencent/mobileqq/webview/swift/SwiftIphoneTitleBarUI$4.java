package com.tencent.mobileqq.webview.swift;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class SwiftIphoneTitleBarUI$4
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  SwiftIphoneTitleBarUI$4(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI, View paramView, int paramInt) {}
  
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!this.c.b.G) {
      return;
    }
    this.a.getBackground().mutate().setAlpha(paramInteger.intValue());
    this.c.b.H = paramInteger.intValue();
    if (this.c.b.H == this.b) {
      this.c.b.G = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.4
 * JD-Core Version:    0.7.0.1
 */