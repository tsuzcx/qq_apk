package com.tencent.mobileqq.sharehelper.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ShareActionHelperImpl$6
  implements Runnable
{
  ShareActionHelperImpl$6(ShareActionHelperImpl paramShareActionHelperImpl, String paramString1, int paramInt, QQProgressDialog paramQQProgressDialog, Map paramMap, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.this$0.dispatchBeforeSharePicToWX(this.a, this.b);
    Object localObject = this.c;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.c.dismiss();
    }
    localObject = (Bitmap)this.d.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str = this.e;
    int i;
    if (this.b == 9) {
      i = 0;
    } else {
      i = 1;
    }
    localWXShareHelper.a(str, (Bitmap)localObject, i, false, this.f);
    QLog.d("ShareActionHelperImpl", 1, "shareToWeChat success");
    this.this$0.dispatchAfterSharePicToWX(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.6
 * JD-Core Version:    0.7.0.1
 */