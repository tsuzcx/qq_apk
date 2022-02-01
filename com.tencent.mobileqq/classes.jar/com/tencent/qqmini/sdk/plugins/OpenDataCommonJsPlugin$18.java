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
        MiniCustomDialog localMiniCustomDialog = new MiniCustomDialog(OpenDataCommonJsPlugin.access$1800(this.this$0).getAttachedActivity(), R.style.mini_sdk_MiniAppInputDialog);
        localMiniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_temp);
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
        for (String str = null;; str = this.jdField_a_of_type_JavaLangString)
        {
          localMiniCustomDialog.setTitle(str).setMessage(this.jdField_b_of_type_JavaLangString);
          localMiniCustomDialog.setPositiveButton(this.c, ColorUtils.parseColor("#3CC51F"), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
          if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            localMiniCustomDialog.setNegativeButton(this.d, ColorUtils.parseColor("#000000"), this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
          }
          localMiniCustomDialog.setCanceledOnTouchOutside(true);
          localMiniCustomDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.18
 * JD-Core Version:    0.7.0.1
 */