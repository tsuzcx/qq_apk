package com.tencent.qqmini.sdk.minigame.plugins;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import behq;
import bene;
import bexk;
import bfgh;

class OpenDataJsPlugin$12
  implements Runnable
{
  OpenDataJsPlugin$12(OpenDataJsPlugin paramOpenDataJsPlugin, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void run()
  {
    if ((OpenDataJsPlugin.access$400(this.this$0).a() != null) && (!OpenDataJsPlugin.access$500(this.this$0).a().isFinishing())) {
      try
      {
        bene localbene = new bene(OpenDataJsPlugin.access$600(this.this$0).a(), 2131755752);
        localbene.setContentView(2131559295);
        if (TextUtils.isEmpty(this.val$title)) {}
        for (String str = null;; str = this.val$title)
        {
          localbene.a(str).a(this.val$content);
          localbene.b(this.val$positiveButtonText, bfgh.a("#3CC51F"), this.val$positiveButtonListener);
          if (this.val$showCancel.booleanValue()) {
            localbene.a(this.val$cancelButtonText, bfgh.a("#000000"), this.val$negativeButtonListener);
          }
          localbene.setCanceledOnTouchOutside(true);
          localbene.setOnCancelListener(this.val$onCancelListener);
          localbene.show();
          return;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        bexk.a().e("OpenDataJsPlugin", "showQQCustomModel error " + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */