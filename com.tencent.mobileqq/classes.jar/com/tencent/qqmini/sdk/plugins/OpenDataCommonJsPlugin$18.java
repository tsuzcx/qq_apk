package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

class OpenDataCommonJsPlugin$18
  implements Runnable
{
  OpenDataCommonJsPlugin$18(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void run()
  {
    if ((OpenDataCommonJsPlugin.access$1600(this.this$0).getAttachedActivity() != null) && (!OpenDataCommonJsPlugin.access$1700(this.this$0).getAttachedActivity().isFinishing())) {
      try
      {
        localObject = new MiniCustomDialog(OpenDataCommonJsPlugin.access$1800(this.this$0).getAttachedActivity(), R.style.mini_sdk_MiniAppInputDialog);
        ((MiniCustomDialog)localObject).setContentView(R.layout.mini_sdk_custom_dialog_temp);
        String str;
        if (TextUtils.isEmpty(this.a)) {
          str = null;
        } else {
          str = this.a;
        }
        ((MiniCustomDialog)localObject).setTitle(str).setMessage(this.b);
        ((MiniCustomDialog)localObject).setPositiveButton(this.c, ColorUtils.parseColor("#3CC51F"), this.d);
        if (this.e.booleanValue()) {
          ((MiniCustomDialog)localObject).setNegativeButton(this.f, ColorUtils.parseColor("#000000"), this.g);
        }
        ((MiniCustomDialog)localObject).setCanceledOnTouchOutside(true);
        ((MiniCustomDialog)localObject).setOnCancelListener(this.h);
        ((MiniCustomDialog)localObject).show();
        return;
      }
      catch (Throwable localThrowable)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showQQCustomModel error ");
        ((StringBuilder)localObject).append(localThrowable.getMessage());
        QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.18
 * JD-Core Version:    0.7.0.1
 */