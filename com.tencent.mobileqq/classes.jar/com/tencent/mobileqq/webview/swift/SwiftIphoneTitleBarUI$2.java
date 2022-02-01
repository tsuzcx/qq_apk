package com.tencent.mobileqq.webview.swift;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class SwiftIphoneTitleBarUI$2
  implements TouchWebView.OnScrollChangedListener
{
  SwiftIphoneTitleBarUI$2(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    paramView = this.a;
    paramView.b = paramInt2;
    paramView.a(paramView.b, this.a.f);
    paramView = this.a.a.a();
    if ((paramView != null) && (!TextUtils.isEmpty(this.a.d))) {
      paramView.callJs(this.a.d, new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(paramInt3), String.valueOf(paramInt4) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.2
 * JD-Core Version:    0.7.0.1
 */