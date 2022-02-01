package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class UIJsPlugin$12
  implements Runnable
{
  UIJsPlugin$12(UIJsPlugin paramUIJsPlugin, String paramString1, String paramString2, String paramString3, String paramString4, JsRuntime paramJsRuntime, String paramString5, int paramInt, boolean paramBoolean, String paramString6, String paramString7) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog;
    if ((this.this$0.jsPluginEngine.getActivityContext() != null) && (this.this$0.jsPluginEngine.getActivityContext().getActivity() != null) && (!this.this$0.jsPluginEngine.getActivityContext().getActivity().isFinishing()))
    {
      localQQCustomDialog = new QQCustomDialog(this.this$0.jsPluginEngine.getActivityContext(), 2131755826);
      localQQCustomDialog.setContentView(2131559385);
      if (!TextUtils.isEmpty(this.val$title)) {
        break label216;
      }
    }
    label216:
    for (String str = null;; str = this.val$title)
    {
      localQQCustomDialog.setTitle(str).setMessage(this.val$content);
      localQQCustomDialog.setOwnerActivity(this.this$0.jsPluginEngine.getActivityContext());
      localQQCustomDialog.setPositiveButton(this.val$confirmText, ColorUtils.parseColor(this.val$confirmColor), new UIJsPlugin.12.1(this));
      if (this.val$showCancel) {
        localQQCustomDialog.setNegativeButton(this.val$cancelText, ColorUtils.parseColor(this.val$cancelColor), new UIJsPlugin.12.2(this));
      }
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      localQQCustomDialog.show();
      if ((this.this$0.jsPluginEngine.getActivityContext().getActivity() instanceof GameActivity)) {
        ((GameActivity)this.this$0.jsPluginEngine.getActivityContext().getActivity()).hideKeyBoard();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */