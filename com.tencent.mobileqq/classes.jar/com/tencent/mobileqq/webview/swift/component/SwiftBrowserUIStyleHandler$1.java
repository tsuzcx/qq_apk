package com.tencent.mobileqq.webview.swift.component;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import anvx;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;

class SwiftBrowserUIStyleHandler$1
  implements TouchWebView.OnOverScrollHandler
{
  SwiftBrowserUIStyleHandler$1(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler, TouchWebView paramTouchWebView, RefreshView paramRefreshView) {}
  
  public void onBack()
  {
    this.this$0.isWebViewOverScroll = false;
    this.val$fRefreshView.onBack();
    this.this$0.setBottomBarVisible(true);
  }
  
  public void onOverScroll(int paramInt)
  {
    Object localObject;
    if (!this.this$0.isWebViewOverScroll)
    {
      this.this$0.isWebViewOverScroll = true;
      localObject = this.val$webview.getUrl();
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = Uri.parse((String)localObject);
      if ((localObject != null) && (((Uri)localObject).isHierarchical())) {
        this.this$0.urlText.setText(anvx.a(2131714076) + ((Uri)localObject).getHost() + anvx.a(2131714069));
      }
      this.this$0.urlText.setVisibility(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.this$0.urlText.setVisibility(8);
      }
    }
    this.val$fRefreshView.onOverScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.1
 * JD-Core Version:    0.7.0.1
 */