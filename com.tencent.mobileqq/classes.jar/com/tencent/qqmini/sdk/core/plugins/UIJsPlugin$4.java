package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import behq;
import bekr;
import bene;
import bfgh;

class UIJsPlugin$4
  implements Runnable
{
  UIJsPlugin$4(UIJsPlugin paramUIJsPlugin, String paramString1, String paramString2, String paramString3, String paramString4, bekr parambekr, boolean paramBoolean, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = this.this$0.mMiniAppContext.a();
    bene localbene;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localbene = new bene((Context)localObject, 2131755752);
      localbene.setContentView(2131559295);
      if (!TextUtils.isEmpty(this.val$title)) {
        break label131;
      }
    }
    label131:
    for (localObject = null;; localObject = this.val$title)
    {
      localbene.a((String)localObject).a(this.val$content);
      localbene.b(this.val$confirmText, bfgh.a(this.val$confirmColor), new UIJsPlugin.4.1(this));
      if (this.val$showCancel) {
        localbene.a(this.val$cancelText, bfgh.a(this.val$cancelColor), new UIJsPlugin.4.2(this));
      }
      localbene.setCanceledOnTouchOutside(false);
      localbene.show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */