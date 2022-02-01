package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SwiftIphoneTitleBarUI$7
  implements RadioGroup.OnCheckedChangeListener
{
  SwiftIphoneTitleBarUI$7(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if ((this.a.O != null) && (!TextUtils.isEmpty(this.a.O.a)))
    {
      this.a.O.a(paramInt);
    }
    else
    {
      TouchWebView localTouchWebView = this.a.a.l();
      if (localTouchWebView != null)
      {
        Object localObject2 = localTouchWebView.getUrl();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (this.a.c != null) {
            localObject1 = this.a.c.getStringExtra("url");
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("subIndex=");
          ((StringBuilder)localObject2).append(paramInt);
          localTouchWebView.loadUrl(((String)localObject1).replaceAll("(?<=[?&])subIndex=[^&]*", ((StringBuilder)localObject2).toString()));
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.7
 * JD-Core Version:    0.7.0.1
 */