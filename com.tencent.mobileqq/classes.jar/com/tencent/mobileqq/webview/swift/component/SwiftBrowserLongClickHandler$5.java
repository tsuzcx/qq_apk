package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import bgwg;
import bhht;
import com.tencent.mobileqq.widget.QQToast;

public class SwiftBrowserLongClickHandler$5
  implements Runnable
{
  public SwiftBrowserLongClickHandler$5(bgwg parambgwg, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.parse("file://" + this.a));
    this.this$0.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
    if ((this.this$0.jdField_a_of_type_Bhht != null) && (this.this$0.jdField_a_of_type_Bhht.isShowing())) {
      this.this$0.jdField_a_of_type_Bhht.dismiss();
    }
    QQToast.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131716200, new Object[] { this.a }), 1).b(this.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.5
 * JD-Core Version:    0.7.0.1
 */