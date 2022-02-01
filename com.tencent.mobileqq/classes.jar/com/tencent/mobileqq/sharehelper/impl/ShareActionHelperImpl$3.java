package com.tencent.mobileqq.sharehelper.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ShareActionHelperImpl$3
  implements Runnable
{
  ShareActionHelperImpl$3(ShareActionHelperImpl paramShareActionHelperImpl, String paramString1, int paramInt, QQProgressDialog paramQQProgressDialog, Map paramMap, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    this.this$0.dispatchBeforeShareLinkToWX(this.a, this.b);
    Object localObject = this.c;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.c.dismiss();
    }
    localObject = (Bitmap)this.d.remove("image");
    int i;
    if (this.b == 9) {
      i = 0;
    } else {
      i = 1;
    }
    WXShareHelper.a().a(this.e, this.f, (Bitmap)localObject, this.g, this.h, i);
    QLog.d("ShareActionHelperImpl", 1, "shareLinkToWeChat success");
    this.this$0.dispatchAfterShareLinkToWX(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.3
 * JD-Core Version:    0.7.0.1
 */