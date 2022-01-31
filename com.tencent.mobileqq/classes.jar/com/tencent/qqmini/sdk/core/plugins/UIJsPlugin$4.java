package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import begz;
import beka;
import bemn;
import bffq;

class UIJsPlugin$4
  implements Runnable
{
  UIJsPlugin$4(UIJsPlugin paramUIJsPlugin, String paramString1, String paramString2, String paramString3, String paramString4, beka parambeka, boolean paramBoolean, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = this.this$0.mMiniAppContext.a();
    bemn localbemn;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localbemn = new bemn((Context)localObject, 2131755752);
      localbemn.setContentView(2131559295);
      if (!TextUtils.isEmpty(this.val$title)) {
        break label131;
      }
    }
    label131:
    for (localObject = null;; localObject = this.val$title)
    {
      localbemn.a((String)localObject).a(this.val$content);
      localbemn.b(this.val$confirmText, bffq.a(this.val$confirmColor), new UIJsPlugin.4.1(this));
      if (this.val$showCancel) {
        localbemn.a(this.val$cancelText, bffq.a(this.val$cancelColor), new UIJsPlugin.4.2(this));
      }
      localbemn.setCanceledOnTouchOutside(false);
      localbemn.show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */