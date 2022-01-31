package com.tencent.qqmini.sdk.minigame.plugins;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import begz;
import bemn;
import bewt;
import bffq;

class OpenDataJsPlugin$12
  implements Runnable
{
  OpenDataJsPlugin$12(OpenDataJsPlugin paramOpenDataJsPlugin, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void run()
  {
    if ((OpenDataJsPlugin.access$400(this.this$0).a() != null) && (!OpenDataJsPlugin.access$500(this.this$0).a().isFinishing())) {
      try
      {
        bemn localbemn = new bemn(OpenDataJsPlugin.access$600(this.this$0).a(), 2131755752);
        localbemn.setContentView(2131559295);
        if (TextUtils.isEmpty(this.val$title)) {}
        for (String str = null;; str = this.val$title)
        {
          localbemn.a(str).a(this.val$content);
          localbemn.b(this.val$positiveButtonText, bffq.a("#3CC51F"), this.val$positiveButtonListener);
          if (this.val$showCancel.booleanValue()) {
            localbemn.a(this.val$cancelButtonText, bffq.a("#000000"), this.val$negativeButtonListener);
          }
          localbemn.setCanceledOnTouchOutside(true);
          localbemn.setOnCancelListener(this.val$onCancelListener);
          localbemn.show();
          return;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        bewt.a().e("OpenDataJsPlugin", "showQQCustomModel error " + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */