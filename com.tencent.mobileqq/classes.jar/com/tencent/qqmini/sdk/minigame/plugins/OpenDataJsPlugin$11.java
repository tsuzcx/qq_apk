package com.tencent.qqmini.sdk.minigame.plugins;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import bgho;
import bgmu;
import bgwc;
import com.tencent.qqmini.sdk.utils.ColorUtils;

class OpenDataJsPlugin$11
  implements Runnable
{
  OpenDataJsPlugin$11(OpenDataJsPlugin paramOpenDataJsPlugin, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void run()
  {
    if ((OpenDataJsPlugin.access$900(this.this$0).a() != null) && (!OpenDataJsPlugin.access$1000(this.this$0).a().isFinishing())) {
      try
      {
        bgmu localbgmu = new bgmu(OpenDataJsPlugin.access$1100(this.this$0).a(), 2131755761);
        localbgmu.setContentView(2131559342);
        if (TextUtils.isEmpty(this.val$title)) {}
        for (String str = null;; str = this.val$title)
        {
          localbgmu.a(str).a(this.val$content);
          localbgmu.b(this.val$positiveButtonText, ColorUtils.parseColor("#3CC51F"), this.val$positiveButtonListener);
          if (this.val$showCancel.booleanValue()) {
            localbgmu.a(this.val$cancelButtonText, ColorUtils.parseColor("#000000"), this.val$negativeButtonListener);
          }
          localbgmu.setCanceledOnTouchOutside(true);
          localbgmu.setOnCancelListener(this.val$onCancelListener);
          localbgmu.show();
          return;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        bgwc.a().e("OpenDataJsPlugin", "showQQCustomModel error " + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */