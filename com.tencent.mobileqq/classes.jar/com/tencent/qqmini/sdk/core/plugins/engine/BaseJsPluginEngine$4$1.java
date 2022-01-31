package com.tencent.qqmini.sdk.core.plugins.engine;

import bemg;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;

class BaseJsPluginEngine$4$1
  implements Runnable
{
  BaseJsPluginEngine$4$1(BaseJsPluginEngine.4 param4, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.this$1.this$0.authDialog == null) {
      return;
    }
    this.this$1.this$0.authDialog.a(this.this$1.val$miniAppProxy.getDrawable(this.this$1.val$context, this.this$1.val$miniIconUrl, 0, 0, null), this.this$1.val$miniAppName, this.this$1.val$authTitle, this.this$1.val$miniAppProxy.getDrawable(this.this$1.val$context, this.val$avatarUrl, 0, 0, null), this.val$nickName, this.this$1.val$authDesc, "取消", new BaseJsPluginEngine.4.1.1(this), "允许", new BaseJsPluginEngine.4.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.4.1
 * JD-Core Version:    0.7.0.1
 */