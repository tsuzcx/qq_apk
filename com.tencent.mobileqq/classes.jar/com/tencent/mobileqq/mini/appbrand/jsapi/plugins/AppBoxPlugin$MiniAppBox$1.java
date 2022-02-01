package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import acov;
import com.tencent.qphone.base.util.QLog;

class AppBoxPlugin$MiniAppBox$1
  implements Runnable
{
  AppBoxPlugin$MiniAppBox$1(AppBoxPlugin.MiniAppBox paramMiniAppBox, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      AppBoxPlugin.MiniAppBox.access$000(this.this$0).a();
      AppBoxPlugin.MiniAppBox.access$100(this.this$0, true, "operateAppBox", this.val$compId, 0, this.val$callbackId);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[minigame] MiniAppBox", 1, "adBox show Exception:", localThrowable);
      AppBoxPlugin.MiniAppBox.access$100(this.this$0, false, "operateAppBox", this.val$compId, 1003, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppBoxPlugin.MiniAppBox.1
 * JD-Core Version:    0.7.0.1
 */