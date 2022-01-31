package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alud;
import com.tencent.mobileqq.mini.widget.AuthDialog;

class BaseJsPluginEngine$5$1
  implements Runnable
{
  BaseJsPluginEngine$5$1(BaseJsPluginEngine.5 param5, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.this$1.this$0.authDialog == null) || (BaseJsPluginEngine.access$300(this.this$1.this$0))) {
      return;
    }
    this.this$1.this$0.authDialog.show(this.this$1.val$miniIconUrl, this.this$1.val$miniAppName, this.this$1.val$authTitle, this.val$avatarUrl, this.val$nickName, this.this$1.val$authDesc, alud.a(2131701389), new BaseJsPluginEngine.5.1.1(this), alud.a(2131701393), new BaseJsPluginEngine.5.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.5.1
 * JD-Core Version:    0.7.0.1
 */