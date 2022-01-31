package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;

class UiApiPlugin$26
  implements Runnable
{
  UiApiPlugin$26(UiApiPlugin paramUiApiPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    boolean bool = UiApiPlugin.a(this.jdField_a_of_type_AndroidAppActivity, UiApiPlugin.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_JavaLangString, "qqbrowser_float_shortcut"), this.b, this.c);
    ThreadManagerV2.getUIHandlerV2().post(new UiApiPlugin.26.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.26
 * JD-Core Version:    0.7.0.1
 */