package com.tencent.mobileqq.webview;

import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;

class WebSecurityPluginV2$3
  implements SoftKeyboardObserver.OnSoftKeyboardToggledListener
{
  WebSecurityPluginV2$3(WebSecurityPluginV2 paramWebSecurityPluginV2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.a.mRuntime.a(this.a.mRuntime.a());
    if (paramBoolean) {
      if (this.a.a)
      {
        if ((localObject != null) && ((localObject instanceof WebUiUtils.WebTitleBarInterface))) {
          ((WebUiUtils.WebTitleBarInterface)localObject).setWarnToastVisible(true, 1, 2131691537);
        }
      }
      else {
        WebSecurityPluginV2.a(this.a);
      }
    }
    while ((localObject == null) || (!(localObject instanceof WebUiUtils.WebTitleBarInterface))) {
      for (;;)
      {
        return;
        localObject = QQToast.a(BaseApplicationImpl.getContext(), 1, 2131691537, 1);
        ((QQToast)localObject).b(((QQToast)localObject).b());
      }
    }
    ((WebUiUtils.WebTitleBarInterface)localObject).setWarnToastVisible(false, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPluginV2.3
 * JD-Core Version:    0.7.0.1
 */