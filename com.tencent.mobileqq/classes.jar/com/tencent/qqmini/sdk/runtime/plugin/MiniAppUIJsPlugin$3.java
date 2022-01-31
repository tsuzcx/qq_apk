package com.tencent.qqmini.sdk.runtime.plugin;

import bgml;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.util.ToastMessage;

class MiniAppUIJsPlugin$3
  implements Runnable
{
  MiniAppUIJsPlugin$3(MiniAppUIJsPlugin paramMiniAppUIJsPlugin, bgok parambgok, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    ToastMessage localToastMessage = ToastMessage.a();
    if (MiniAppUIJsPlugin.access$100(this.this$0) != null) {
      localToastMessage.b(MiniAppUIJsPlugin.access$500(this.this$0));
    }
    MiniAppUIJsPlugin.access$102(this.this$0, bgml.a(MiniAppUIJsPlugin.access$600(this.this$0)).a());
    if (MiniAppUIJsPlugin.access$100(this.this$0) == null)
    {
      QMLog.w("MiniAppUIJsPlugin", "showLoading event=" + this.val$req.jdField_a_of_type_JavaLangString + "， top page not found");
      this.val$req.b();
      return;
    }
    localToastMessage.jdField_a_of_type_Int = 1;
    localToastMessage.c = this.val$title;
    localToastMessage.b = -1;
    localToastMessage.jdField_a_of_type_Boolean = this.val$mask;
    localToastMessage.jdField_a_of_type_JavaLangString = "loading";
    localToastMessage.a(MiniAppUIJsPlugin.access$700(this.this$0));
    this.val$req.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppUIJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */