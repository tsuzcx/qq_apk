package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class SwiftBrowserLongClickHandler$5
  implements Runnable
{
  SwiftBrowserLongClickHandler$5(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(this.a);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    this.this$0.f.sendBroadcast(localIntent);
    if ((this.this$0.d != null) && (this.this$0.d.isShowing())) {
      this.this$0.d.dismiss();
    }
    QQToast.makeText(this.this$0.f.getApplicationContext(), 2, this.this$0.f.getString(2131914171, new Object[] { this.a }), 1).show(this.this$0.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.5
 * JD-Core Version:    0.7.0.1
 */