package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class CustomHeightFragment$ConfessUIStyleHandler
  extends SwiftBrowserUIStyleHandler
{
  CustomHeightFragment$ConfessUIStyleHandler(CustomHeightFragment paramCustomHeightFragment) {}
  
  public void bI_()
  {
    if (this.b.a() != null)
    {
      WebView localWebView = this.b.a();
      localWebView.setId(2131450088);
      if (this.F != -1) {
        localWebView.setBackgroundColor(this.F);
      }
      Object localObject = (Activity)localWebView.getContext();
      int i;
      if ((((Activity)localObject).getIntent() != null) && (((Activity)localObject).getIntent().getExtras() != null)) {
        i = ((Activity)localObject).getIntent().getExtras().getInt("customheight", 0);
      } else {
        i = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initWebViewInContentView height=");
        ((StringBuilder)localObject).append(i);
        QLog.i("SwiftBrowserUIStyleHandler", 2, ((StringBuilder)localObject).toString());
      }
      if (i != 0)
      {
        if ((this.u instanceof RelativeLayout))
        {
          localObject = new RelativeLayout.LayoutParams(-1, i);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.u.addView(localWebView, 0, (ViewGroup.LayoutParams)localObject);
        }
        else
        {
          this.u.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, i));
        }
        this.u.setOnClickListener(new CustomHeightFragment.ConfessUIStyleHandler.1(this));
        return;
      }
      this.u.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CustomHeightFragment.ConfessUIStyleHandler
 * JD-Core Version:    0.7.0.1
 */