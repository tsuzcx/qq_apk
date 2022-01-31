package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import bdcz;
import bdfz;
import bdit;
import bdjb;
import bdnw;

class UIJsPlugin$1
  implements Runnable
{
  UIJsPlugin$1(UIJsPlugin paramUIJsPlugin, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, bdfz parambdfz) {}
  
  public void run()
  {
    if ("loading".equals(this.val$icon))
    {
      if (UIJsPlugin.access$000(this.this$0) == null) {
        UIJsPlugin.access$002(this.this$0, new bdjb(this.this$0.mMiniAppContext.a(), (ViewGroup)this.this$0.mMiniAppContext.a().findViewById(16908290)));
      }
      for (;;)
      {
        UIJsPlugin.access$000(this.this$0).a(0, this.val$icon, this.val$imagePath, this.val$title, this.val$duration, this.val$mask);
        this.val$req.a();
        return;
        UIJsPlugin.access$000(this.this$0).a();
      }
    }
    for (;;)
    {
      try
      {
        UIJsPlugin.access$102(this.this$0, new bdit(this.this$0.mMiniAppContext.a()));
        if (TextUtils.isEmpty(this.val$imagePath)) {
          break label236;
        }
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.val$imagePath);
        UIJsPlugin.access$100(this.this$0).a(localBitmapDrawable);
        UIJsPlugin.access$100(this.this$0).a(this.val$title);
        UIJsPlugin.access$100(this.this$0).c(this.val$duration);
        UIJsPlugin.access$100(this.this$0).a();
      }
      catch (Throwable localThrowable)
      {
        bdnw.d("UIJsPlugin", "showToastView error.", localThrowable);
      }
      break;
      label236:
      if ("none".equals(this.val$icon)) {
        UIJsPlugin.access$100(this.this$0).b(-1);
      } else {
        UIJsPlugin.access$100(this.this$0).a(bdjb.a(this.val$icon));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */