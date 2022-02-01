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
    Activity localActivity = this.a;
    boolean bool = UiApiPlugin.a(localActivity, UiApiPlugin.a(localActivity, null, this.b, "qqbrowser_float_shortcut"), this.c, this.d);
    ThreadManagerV2.getUIHandlerV2().post(new UiApiPlugin.26.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.26
 * JD-Core Version:    0.7.0.1
 */