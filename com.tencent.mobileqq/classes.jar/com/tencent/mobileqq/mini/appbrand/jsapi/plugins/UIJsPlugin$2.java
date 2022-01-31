package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import bemw;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.ToastView;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.qphone.base.util.QLog;

class UIJsPlugin$2
  implements Runnable
{
  UIJsPlugin$2(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, int paramInt2) {}
  
  public void run()
  {
    if ((this.val$webview instanceof GameJsRuntime))
    {
      if ("loading".equals(this.val$icon))
      {
        if (UIJsPlugin.access$000(this.this$0) == null) {
          UIJsPlugin.access$002(this.this$0, new ToastView(this.this$0.jsPluginEngine.getActivityContext(), (ViewGroup)this.this$0.jsPluginEngine.getActivityContext().findViewById(16908290)));
        }
        for (;;)
        {
          UIJsPlugin.access$000(this.this$0).show(0, this.val$icon, this.val$imagePath, this.val$title, this.val$duration, this.val$mask);
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
          return;
          UIJsPlugin.access$000(this.this$0).hide();
        }
      }
      for (;;)
      {
        try
        {
          bemw localbemw = new bemw(this.this$0.jsPluginEngine.getActivityContext());
          if (TextUtils.isEmpty(this.val$imagePath)) {
            break label232;
          }
          localbemw.a(new BitmapDrawable(this.val$imagePath));
          localbemw.a(this.val$title);
          localbemw.c(this.val$duration);
          localbemw.a();
          UIJsPlugin.access$102(this.this$0, localbemw);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[mini] UIJsPlugin", 1, "showToastView error.", localThrowable);
        }
        break;
        label232:
        if ("none".equals(this.val$icon)) {
          localThrowable.b(-1);
        } else {
          localThrowable.a(ToastView.getIconRes(this.val$icon));
        }
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
    this.this$0.lastPage.showToastView(0, this.val$icon, this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().getFilePath(this.val$imagePath), this.val$title, this.val$duration, this.val$mask);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */