package com.tencent.qqmini.sdk.runtime.plugin;

import bgml;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.util.ToastMessage;

class MiniAppUIJsPlugin$2
  implements Runnable
{
  MiniAppUIJsPlugin$2(MiniAppUIJsPlugin paramMiniAppUIJsPlugin, bgok parambgok, String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3) {}
  
  public void run()
  {
    ToastMessage localToastMessage = ToastMessage.a();
    if (MiniAppUIJsPlugin.access$100(this.this$0) != null) {
      localToastMessage.b(MiniAppUIJsPlugin.access$200(this.this$0));
    }
    MiniAppUIJsPlugin.access$102(this.this$0, bgml.a(MiniAppUIJsPlugin.access$300(this.this$0)).a());
    if (MiniAppUIJsPlugin.access$100(this.this$0) == null)
    {
      QMLog.w("MiniAppUIJsPlugin", "showToast event=" + this.val$req.jdField_a_of_type_JavaLangString + "， top page not found");
      this.val$req.b();
      return;
    }
    localToastMessage.jdField_a_of_type_Int = 0;
    localToastMessage.c = this.val$title;
    localToastMessage.jdField_b_of_type_Int = this.val$duration;
    localToastMessage.jdField_a_of_type_Boolean = this.val$mask;
    localToastMessage.jdField_b_of_type_JavaLangString = this.val$imagePath;
    localToastMessage.jdField_a_of_type_JavaLangString = this.val$icon;
    localToastMessage.a(MiniAppUIJsPlugin.access$400(this.this$0));
    this.val$req.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppUIJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */