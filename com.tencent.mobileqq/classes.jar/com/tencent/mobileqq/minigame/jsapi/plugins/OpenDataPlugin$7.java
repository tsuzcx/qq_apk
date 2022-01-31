package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import bafb;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameLog;

class OpenDataPlugin$7
  implements Runnable
{
  OpenDataPlugin$7(OpenDataPlugin paramOpenDataPlugin, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, Boolean paramBoolean, String paramString4) {}
  
  public void run()
  {
    if ((this.this$0.jsPluginEngine.getActivityContext() != null) && (this.this$0.jsPluginEngine.getActivityContext().getActivity() != null) && (!this.this$0.jsPluginEngine.getActivityContext().getActivity().isFinishing())) {
      try
      {
        bafb localbafb = new bafb(this.this$0.jsPluginEngine.getActivityContext(), 2131690181);
        localbafb.setContentView(2131493682);
        if (TextUtils.isEmpty(this.val$title)) {}
        for (String str = null;; str = this.val$title)
        {
          localbafb.setTitle(str).setMessage(this.val$content);
          localbafb.setPositiveButton(this.val$positiveButtonText, ColorUtils.parseColor("#3CC51F"), this.val$positiveButtonListener);
          if (this.val$showCancel.booleanValue()) {
            localbafb.setNegativeButton(this.val$cancelButtonText, ColorUtils.parseColor("#000000"), new OpenDataPlugin.7.1(this));
          }
          localbafb.setCanceledOnTouchOutside(true);
          localbafb.show();
          if (!(this.this$0.jsPluginEngine.getActivityContext().getActivity() instanceof GameActivity)) {
            break;
          }
          ((GameActivity)this.this$0.jsPluginEngine.getActivityContext().getActivity()).hideKeyBoard();
          return;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        GameLog.getInstance().e("OpenDataPlugin", "showQQCustomModel error " + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.7
 * JD-Core Version:    0.7.0.1
 */