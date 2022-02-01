package com.tencent.qqmini.sdk.plugins.engine;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.widget.AuthDialog;
import com.tencent.qqmini.sdk.widget.AuthDialog.AuthDialogResBuilder;

class BaseJsPluginEngine$13$1
  implements Runnable
{
  BaseJsPluginEngine$13$1(BaseJsPluginEngine.13 param13, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    if (this.e.i.authDialog == null) {
      return;
    }
    AuthDialog.AuthDialogResBuilder localAuthDialogResBuilder = new AuthDialog.AuthDialogResBuilder();
    Object localObject1 = this.e.a;
    Object localObject2 = this.e.b;
    Object localObject3 = this.e.c;
    int i = this.a;
    localObject1 = localAuthDialogResBuilder.setMiniAppIconUrl(((MiniAppProxy)localObject1).getDrawable((Context)localObject2, (String)localObject3, i, i, null)).setMiniAppName(this.e.d).setAuthTitle(this.e.e);
    localObject2 = this.e.a;
    localObject3 = this.e.b;
    String str = this.b;
    i = this.c;
    ((AuthDialog.AuthDialogResBuilder)localObject1).setUserIconUrl(((MiniAppProxy)localObject2).getDrawable((Context)localObject3, str, i, i, null)).setUserName(this.d).setAuthDesc(this.e.f).setReportSubAction(this.e.g).setMiniAppInfo(this.e.i.mMiniAppContext.getMiniAppInfo()).setLeftBtnText(this.e.h).setLeftBtnClickListener(new BaseJsPluginEngine.13.1.2(this)).setRightBtnText("允许").setRightBtnClickListener(new BaseJsPluginEngine.13.1.1(this));
    this.e.i.authDialog.setCanceledOnTouchOutside(false);
    this.e.i.authDialog.show(localAuthDialogResBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.13.1
 * JD-Core Version:    0.7.0.1
 */