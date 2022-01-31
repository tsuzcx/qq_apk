package com.tencent.mobileqq.webview.swift.component;

import alud;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bejc;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class SwiftBrowserTBSHandler$2
  implements Runnable
{
  public SwiftBrowserTBSHandler$2(bejc parambejc, int paramInt) {}
  
  public void run()
  {
    TextView localTextView = new TextView(this.this$0.a);
    localTextView.setBackgroundColor(2130706432);
    localTextView.setTextColor(2147483647);
    StringBuilder localStringBuilder = new StringBuilder().append(alud.a(2131715088));
    if (this.a == 0) {}
    for (String str = "系统WebView";; str = "x5 " + this.a)
    {
      localTextView.setText(str);
      this.this$0.a.addContentView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.2
 * JD-Core Version:    0.7.0.1
 */