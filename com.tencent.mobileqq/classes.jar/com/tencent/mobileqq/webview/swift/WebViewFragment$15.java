package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import axqw;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class WebViewFragment$15
  implements TeleScreenRunnable
{
  WebViewFragment$15(WebViewFragment paramWebViewFragment, Intent paramIntent, boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        WebViewFragment.a(this.this$0, this.jdField_a_of_type_AndroidContentIntent);
        if ((!this.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
          break;
        }
        boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("keyIsDownLoad", false);
        WebViewFragment.a(this.this$0).finish();
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "forcedClosedAfterJump appName=" + this.jdField_a_of_type_JavaLangString);
        }
        String str1;
        if ((this.b) && (!bool))
        {
          if (this.jdField_a_of_type_Long == -1L)
          {
            str1 = "";
            axqw.b(null, "dc00898", "", "", "0X800A86A", "0X800A86A", 0, 0, str1, "", "", "");
            return;
          }
          str1 = String.valueOf(this.jdField_a_of_type_Long);
          continue;
        }
        if (!this.b) {
          break;
        }
        if (this.jdField_a_of_type_Long == -1L)
        {
          str1 = "";
          axqw.b(null, "dc00898", "", "", "0X800A86B", "0X800A86B", 0, 0, str1, "", "", "");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("WebLog_WebViewFragment", 1, localThrowable, new Object[0]);
        return;
      }
      long l = this.jdField_a_of_type_Long;
      String str2 = String.valueOf(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.15
 * JD-Core Version:    0.7.0.1
 */