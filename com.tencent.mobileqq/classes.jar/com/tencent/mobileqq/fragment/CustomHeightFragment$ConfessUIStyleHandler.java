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
  
  public void a()
  {
    WebView localWebView;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
    {
      localWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
      localWebView.setId(2131381863);
      if (this.b != -1) {
        localWebView.setBackgroundColor(this.b);
      }
      localObject = (Activity)localWebView.getContext();
      if ((((Activity)localObject).getIntent() == null) || (((Activity)localObject).getIntent().getExtras() == null)) {
        break label210;
      }
    }
    label210:
    for (int i = ((Activity)localObject).getIntent().getExtras().getInt("customheight", 0);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserUIStyleHandler", 2, "initWebViewInContentView height=" + i);
      }
      if (i != 0)
      {
        if ((this.c instanceof RelativeLayout))
        {
          localObject = new RelativeLayout.LayoutParams(-1, i);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.c.addView(localWebView, 0, (ViewGroup.LayoutParams)localObject);
        }
        for (;;)
        {
          this.c.setOnClickListener(new CustomHeightFragment.ConfessUIStyleHandler.1(this));
          return;
          this.c.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, i));
        }
      }
      this.c.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CustomHeightFragment.ConfessUIStyleHandler
 * JD-Core Version:    0.7.0.1
 */