package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class SwiftBrowserTBSHandler$1
  implements Runnable
{
  SwiftBrowserTBSHandler$1(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, int paramInt) {}
  
  public void run()
  {
    TextView localTextView = new TextView(this.this$0.a);
    localTextView.setBackgroundColor(2130706432);
    localTextView.setTextColor(2147483647);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localTextView.getResources().getString(2131911998));
    Object localObject;
    if (this.a == 0)
    {
      localObject = "系统WebView";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("x5 ");
      ((StringBuilder)localObject).append(this.a);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localTextView.setText(localStringBuilder.toString());
    this.this$0.a.addContentView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.1
 * JD-Core Version:    0.7.0.1
 */