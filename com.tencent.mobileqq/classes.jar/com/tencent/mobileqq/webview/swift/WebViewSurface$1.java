package com.tencent.mobileqq.webview.swift;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class WebViewSurface$1
  implements View.OnTouchListener
{
  WebViewSurface$1(WebViewSurface paramWebViewSurface) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      if (paramView == WebViewSurface.a(this.a).o)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewSurface", 2, "vg onTouch");
        }
        paramView = new HashMap(2);
        paramView.put("X", Integer.valueOf((int)paramMotionEvent.getX()));
        paramView.put("Y", Integer.valueOf((int)paramMotionEvent.getY()));
        if (WebViewSurface.b(this.a) != null) {
          WebViewSurface.b(this.a).getPluginEngine().a(WebViewSurface.b(this.a).getUrl(), 8589934606L, paramView);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewSurface.1
 * JD-Core Version:    0.7.0.1
 */