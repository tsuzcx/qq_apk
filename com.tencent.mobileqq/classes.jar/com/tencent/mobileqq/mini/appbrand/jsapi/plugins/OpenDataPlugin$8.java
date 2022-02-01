package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.utils.QQCustomDialog;

class OpenDataPlugin$8
  implements Runnable
{
  OpenDataPlugin$8(OpenDataPlugin paramOpenDataPlugin, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void run()
  {
    if ((this.this$0.jsPluginEngine.getActivityContext() != null) && (this.this$0.jsPluginEngine.getActivityContext().getActivity() != null) && (!this.this$0.jsPluginEngine.getActivityContext().getActivity().isFinishing())) {
      try
      {
        QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.this$0.jsPluginEngine.getActivityContext(), 2131755826);
        localQQCustomDialog.setContentView(2131559385);
        if (TextUtils.isEmpty(this.val$title)) {}
        for (String str = null;; str = this.val$title)
        {
          localQQCustomDialog.setTitle(str).setMessage(this.val$content);
          localQQCustomDialog.setPositiveButton(this.val$positiveButtonText, ColorUtils.parseColor("#3CC51F"), this.val$positiveButtonListener);
          if (this.val$showCancel.booleanValue()) {
            localQQCustomDialog.setNegativeButton(this.val$cancelButtonText, ColorUtils.parseColor("#000000"), this.val$negativeButtonListener);
          }
          localQQCustomDialog.setCanceledOnTouchOutside(true);
          localQQCustomDialog.setOnCancelListener(this.val$onCancelListener);
          localQQCustomDialog.show();
          if (!(this.this$0.jsPluginEngine.getActivityContext().getActivity() instanceof GameActivity)) {
            break;
          }
          ((GameActivity)this.this$0.jsPluginEngine.getActivityContext().getActivity()).hideKeyBoard();
          return;
        }
        if ((this.this$0.jsPluginEngine instanceof JsPluginEngine))
        {
          MiniAppStateManager.getInstance().notifyChange("hideInput");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        GameLog.getInstance().e("OpenDataPlugin", "showQQCustomModel error " + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OpenDataPlugin.8
 * JD-Core Version:    0.7.0.1
 */