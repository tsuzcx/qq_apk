package com.tencent.mobileqq.webview.swift.component;

import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;

class SwiftBrowserTBSHandler$1
  implements Runnable
{
  SwiftBrowserTBSHandler$1(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, int paramInt) {}
  
  public void run()
  {
    TextView localTextView = new TextView(this.this$0.a);
    localTextView.setBackgroundColor(2130706432);
    localTextView.setTextColor(2147483647);
    StringBuilder localStringBuilder = new StringBuilder().append(HardCodeUtil.a(2131714572));
    if (this.a == 0) {}
    for (String str = "系统WebView";; str = "x5 " + this.a)
    {
      localTextView.setText(str);
      this.this$0.a.addContentView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.1
 * JD-Core Version:    0.7.0.1
 */