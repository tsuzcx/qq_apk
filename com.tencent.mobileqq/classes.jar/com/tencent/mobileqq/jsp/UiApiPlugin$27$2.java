package com.tencent.mobileqq.jsp;

import android.app.ProgressDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;

class UiApiPlugin$27$2
  implements Runnable
{
  UiApiPlugin$27$2(UiApiPlugin.27 param27) {}
  
  public void run()
  {
    this.a.a.b.dismiss();
    QQToast.a(this.a.a.mRuntime.a().getApplication(), 1, HardCodeUtil.a(2131715628), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.27.2
 * JD-Core Version:    0.7.0.1
 */