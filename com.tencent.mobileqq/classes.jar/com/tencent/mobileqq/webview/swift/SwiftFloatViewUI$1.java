package com.tencent.mobileqq.webview.swift;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.widgets.Hole;

class SwiftFloatViewUI$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SwiftFloatViewUI$1(SwiftFloatViewUI paramSwiftFloatViewUI, View paramView, DisplayMetrics paramDisplayMetrics) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    } else {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    this.c.l.setHole((this.c.c.getLeft() + this.c.c.getRight()) / 2 - 1, (this.c.c.getTop() + this.c.c.getBottom()) / 2 - 1, (int)(this.b.density * 30.0F));
    this.c.l.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.1
 * JD-Core Version:    0.7.0.1
 */