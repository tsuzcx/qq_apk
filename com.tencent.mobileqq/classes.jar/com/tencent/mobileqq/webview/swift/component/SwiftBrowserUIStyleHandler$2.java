package com.tencent.mobileqq.webview.swift.component;

import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

class SwiftBrowserUIStyleHandler$2
  implements TouchWebView.OnScrollChangedListener
{
  SwiftBrowserUIStyleHandler$2(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (System.currentTimeMillis() - this.a.e > 1000L)
    {
      paramInt1 = paramInt2 - paramInt4;
      if (paramInt1 > 0)
      {
        if (Math.abs(paramInt1) > 50)
        {
          this.a.b(false);
          this.a.e = System.currentTimeMillis();
        }
      }
      else if (Math.abs(paramInt1) > 50)
      {
        this.a.b(true);
        this.a.e = System.currentTimeMillis();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.2
 * JD-Core Version:    0.7.0.1
 */