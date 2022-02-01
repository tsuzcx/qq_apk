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
    this.a.b.B.dismiss();
    QQToast.makeText(this.a.b.mRuntime.b().getApplication(), 1, HardCodeUtil.a(2131913100), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.27.2
 * JD-Core Version:    0.7.0.1
 */