package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

class UIJsPlugin$5
  implements Runnable
{
  UIJsPlugin$5(UIJsPlugin paramUIJsPlugin, String paramString1, String paramString2, String paramString3, String paramString4, RequestEvent paramRequestEvent, boolean paramBoolean, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = UIJsPlugin.access$1000(this.this$0).getAttachedActivity();
    MiniCustomDialog localMiniCustomDialog;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localMiniCustomDialog = new MiniCustomDialog((Context)localObject, R.style.mini_sdk_MiniAppInputDialog);
      localMiniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_temp);
      if (!TextUtils.isEmpty(this.val$title)) {
        break label133;
      }
    }
    label133:
    for (localObject = null;; localObject = this.val$title)
    {
      localMiniCustomDialog.setTitle((String)localObject).setMessage(this.val$content);
      localMiniCustomDialog.setPositiveButton(this.val$confirmText, ColorUtils.parseColor(this.val$confirmColor), new UIJsPlugin.5.1(this));
      if (this.val$showCancel) {
        localMiniCustomDialog.setNegativeButton(this.val$cancelText, ColorUtils.parseColor(this.val$cancelColor), new UIJsPlugin.5.2(this));
      }
      localMiniCustomDialog.setCanceledOnTouchOutside(false);
      localMiniCustomDialog.show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */