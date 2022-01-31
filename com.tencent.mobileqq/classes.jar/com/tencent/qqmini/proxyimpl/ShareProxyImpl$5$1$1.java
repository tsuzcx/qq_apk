package com.tencent.qqmini.proxyimpl;

import alud;
import android.app.Activity;
import android.content.res.Resources;
import bety;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ShareProxyImpl$5$1$1
  implements URLDrawable.URLDrawableListener
{
  ShareProxyImpl$5$1$1(ShareProxyImpl.5.1 param1) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("ShareProxyImpl", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("ShareProxyImpl", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if ((paramURLDrawable != null) && (paramURLDrawable.exists())) {}
    for (int i = 1;; i = 0)
    {
      this.this$2.val$loadingDialog.dismiss();
      if (i == 0) {
        QQToast.a(this.this$2.this$1.val$activity, 1, alud.a(2131703128), 1).b(this.this$2.this$1.val$activity.getResources().getDimensionPixelSize(2131298914));
      }
      if (i == 0) {
        break;
      }
      this.this$2.this$1.val$shareData.isLocalPic = true;
      this.this$2.this$1.val$shareData.sharePicPath = paramURLDrawable.getPath();
      this.this$2.this$1.this$0.shareLocalPicMessage(this.this$2.this$1.val$shareData);
      return;
    }
    QLog.e("ShareProxyImpl", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5.1.1
 * JD-Core Version:    0.7.0.1
 */