package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import anni;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.mobileqq.mini.widget.AuthDialog.AuthDialogResBuilder;

class BaseJsPluginEngine$6$1
  implements Runnable
{
  BaseJsPluginEngine$6$1(BaseJsPluginEngine.6 param6, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.this$1.this$0.authDialog == null) || (BaseJsPluginEngine.access$300(this.this$1.this$0))) {
      return;
    }
    AuthDialog.AuthDialogResBuilder localAuthDialogResBuilder = new AuthDialog.AuthDialogResBuilder();
    localAuthDialogResBuilder.setMiniAppIconUrl(this.this$1.val$miniIconUrl).setMiniAppName(this.this$1.val$miniAppName).setAuthTitle(this.this$1.val$authTitle).setUserIconUrl(this.val$avatarUrl).setUserName(this.val$nickName).setAuthDesc(this.this$1.val$authDesc).setLeftBtnText(anni.a(2131699813)).setLeftBtnClickListener(new BaseJsPluginEngine.6.1.2(this)).setRightBtnText(anni.a(2131699817)).setRightBtnClickListener(new BaseJsPluginEngine.6.1.1(this));
    this.this$1.this$0.authDialog.show(localAuthDialogResBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.6.1
 * JD-Core Version:    0.7.0.1
 */