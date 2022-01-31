package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import bgho;
import bgkd;
import bgmu;
import com.tencent.qqmini.sdk.utils.ColorUtils;

class UIJsPlugin$1
  implements Runnable
{
  UIJsPlugin$1(UIJsPlugin paramUIJsPlugin, String paramString1, String paramString2, String paramString3, String paramString4, bgkd parambgkd, boolean paramBoolean, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = this.this$0.mMiniAppContext.a();
    bgmu localbgmu;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localbgmu = new bgmu((Context)localObject, 2131755761);
      localbgmu.setContentView(2131559342);
      if (!TextUtils.isEmpty(this.val$title)) {
        break label131;
      }
    }
    label131:
    for (localObject = null;; localObject = this.val$title)
    {
      localbgmu.a((String)localObject).a(this.val$content);
      localbgmu.b(this.val$confirmText, ColorUtils.parseColor(this.val$confirmColor), new UIJsPlugin.1.1(this));
      if (this.val$showCancel) {
        localbgmu.a(this.val$cancelText, ColorUtils.parseColor(this.val$cancelColor), new UIJsPlugin.1.2(this));
      }
      localbgmu.setCanceledOnTouchOutside(false);
      localbgmu.show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */