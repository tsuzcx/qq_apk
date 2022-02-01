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

class OpenDataCommonJsPlugin$12
  implements Runnable
{
  OpenDataCommonJsPlugin$12(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void run()
  {
    if ((OpenDataCommonJsPlugin.access$1500(this.this$0).getAttachedActivity() != null) && (!OpenDataCommonJsPlugin.access$1600(this.this$0).getAttachedActivity().isFinishing())) {
      try
      {
        MiniCustomDialog localMiniCustomDialog = new MiniCustomDialog(OpenDataCommonJsPlugin.access$1700(this.this$0).getAttachedActivity(), R.style.mini_sdk_MiniAppInputDialog);
        localMiniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_temp);
        if (TextUtils.isEmpty(this.val$title)) {}
        for (String str = null;; str = this.val$title)
        {
          localMiniCustomDialog.setTitle(str).setMessage(this.val$content);
          localMiniCustomDialog.setPositiveButton(this.val$positiveButtonText, ColorUtils.parseColor("#3CC51F"), this.val$positiveButtonListener);
          if (this.val$showCancel.booleanValue()) {
            localMiniCustomDialog.setNegativeButton(this.val$cancelButtonText, ColorUtils.parseColor("#000000"), this.val$negativeButtonListener);
          }
          localMiniCustomDialog.setCanceledOnTouchOutside(true);
          localMiniCustomDialog.setOnCancelListener(this.val$onCancelListener);
          localMiniCustomDialog.show();
          return;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("OpenDataCommonJsPlugin", "showQQCustomModel error " + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */