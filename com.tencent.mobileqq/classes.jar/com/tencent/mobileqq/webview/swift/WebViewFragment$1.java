package com.tencent.mobileqq.webview.swift;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;

class WebViewFragment$1
  implements View.OnLayoutChangeListener
{
  private Rect b = new Rect();
  private Rect c = new Rect();
  
  WebViewFragment$1(WebViewFragment paramWebViewFragment) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.b.set(this.c);
    paramView.getWindowVisibleDisplayFrame(this.c);
    if (this.b.width() == this.c.width())
    {
      paramInt1 = this.b.height() - this.c.height();
      if (paramInt1 < -100)
      {
        this.a.webViewKernel.a(8589934614L, null);
        return;
      }
      if (paramInt1 > 100) {
        this.a.webViewKernel.a(8589934613L, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */