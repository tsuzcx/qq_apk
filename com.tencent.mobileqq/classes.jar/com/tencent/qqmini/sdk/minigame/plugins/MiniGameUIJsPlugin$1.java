package com.tencent.qqmini.sdk.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import bgho;
import bgkd;
import bgnf;
import bgnw;
import com.tencent.qqmini.sdk.log.QMLog;

class MiniGameUIJsPlugin$1
  implements Runnable
{
  MiniGameUIJsPlugin$1(MiniGameUIJsPlugin paramMiniGameUIJsPlugin, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, bgkd parambgkd) {}
  
  public void run()
  {
    Object localObject = MiniGameUIJsPlugin.access$000(this.this$0).a();
    if ((localObject == null) || (((Activity)localObject).isFinishing()))
    {
      QMLog.w("MiniGameUIJsPlugin", "showToast(). Do nothing, activity is null or finishing");
      return;
    }
    if ("loading".equals(this.val$icon))
    {
      MiniGameUIJsPlugin.access$102(this.this$0, new bgnw((Context)localObject, (ViewGroup)((Activity)localObject).findViewById(16908290)));
      MiniGameUIJsPlugin.access$100(this.this$0).a(0, this.val$icon, this.val$imagePath, this.val$title, this.val$duration, this.val$mask);
      this.val$req.a();
      return;
    }
    for (;;)
    {
      try
      {
        MiniGameUIJsPlugin.access$202(this.this$0, new bgnf((Context)localObject));
        if (TextUtils.isEmpty(this.val$imagePath)) {
          break label212;
        }
        localObject = new BitmapDrawable(this.val$imagePath);
        MiniGameUIJsPlugin.access$200(this.this$0).a((Drawable)localObject);
        MiniGameUIJsPlugin.access$200(this.this$0).a(this.val$title);
        MiniGameUIJsPlugin.access$200(this.this$0).c(this.val$duration);
        MiniGameUIJsPlugin.access$200(this.this$0).a();
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("MiniGameUIJsPlugin", "showToastView error.", localThrowable);
      }
      break;
      label212:
      if ("none".equals(this.val$icon)) {
        MiniGameUIJsPlugin.access$200(this.this$0).b(-1);
      } else {
        MiniGameUIJsPlugin.access$200(this.this$0).a(bgnw.a(this.val$icon));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.MiniGameUIJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */