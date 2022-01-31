package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.ToastView;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.qphone.base.util.QLog;

class UIJsPlugin$3
  implements Runnable
{
  UIJsPlugin$3(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, String paramString1, boolean paramBoolean, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.val$webview instanceof GameJsRuntime))
    {
      if (UIJsPlugin.access$000(this.this$0) == null)
      {
        ViewGroup localViewGroup2 = (ViewGroup)this.this$0.jsPluginEngine.getActivityContext().findViewById(2131370270);
        ViewGroup localViewGroup1 = localViewGroup2;
        if (localViewGroup2 == null) {
          localViewGroup1 = (ViewGroup)this.this$0.jsPluginEngine.getActivityContext().findViewById(16908290);
        }
        UIJsPlugin.access$002(this.this$0, new ToastView(this.this$0.jsPluginEngine.getActivityContext(), localViewGroup1));
      }
      for (;;)
      {
        UIJsPlugin.access$000(this.this$0).show(1, "loading", null, this.val$title, -1, this.val$mask);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
        return;
        UIJsPlugin.access$000(this.this$0).hide();
      }
    }
    if (this.this$0.lastPage != null) {
      this.this$0.lastPage.hideToastView();
    }
    this.this$0.lastPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getCurrentPage();
    if (this.this$0.lastPage == null)
    {
      QLog.w("[mini] UIJsPlugin", 2, "handleNativeRequest event=" + this.val$event + "， top page not found");
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    this.this$0.lastPage.showToastView(1, "loading", null, this.val$title, -1, this.val$mask);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */