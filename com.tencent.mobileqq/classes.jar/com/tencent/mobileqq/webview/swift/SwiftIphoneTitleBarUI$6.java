package com.tencent.mobileqq.webview.swift;

import android.text.TextUtils;
import android.widget.TextView;

class SwiftIphoneTitleBarUI$6
  implements Runnable
{
  SwiftIphoneTitleBarUI$6(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI, TextView paramTextView1, TextView paramTextView2, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a.getText().toString()))
    {
      this.b.setText(this.c);
      return;
    }
    this.this$0.c(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.6
 * JD-Core Version:    0.7.0.1
 */