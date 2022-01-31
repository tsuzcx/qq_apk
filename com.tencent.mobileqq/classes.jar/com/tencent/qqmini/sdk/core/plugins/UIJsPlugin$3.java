package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import bdcz;
import bdfz;
import bdik;
import bdyk;

class UIJsPlugin$3
  implements Runnable
{
  UIJsPlugin$3(UIJsPlugin paramUIJsPlugin, String paramString1, String paramString2, String paramString3, String paramString4, bdfz parambdfz, boolean paramBoolean, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = this.this$0.mMiniAppContext.a();
    bdik localbdik;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localbdik = new bdik((Context)localObject, 2131690144);
      localbdik.setContentView(2131493726);
      if (!TextUtils.isEmpty(this.val$title)) {
        break label131;
      }
    }
    label131:
    for (localObject = null;; localObject = this.val$title)
    {
      localbdik.a((String)localObject).a(this.val$content);
      localbdik.b(this.val$confirmText, bdyk.a(this.val$confirmColor), new UIJsPlugin.3.1(this));
      if (this.val$showCancel) {
        localbdik.a(this.val$cancelText, bdyk.a(this.val$cancelColor), new UIJsPlugin.3.2(this));
      }
      localbdik.setCanceledOnTouchOutside(false);
      localbdik.show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */