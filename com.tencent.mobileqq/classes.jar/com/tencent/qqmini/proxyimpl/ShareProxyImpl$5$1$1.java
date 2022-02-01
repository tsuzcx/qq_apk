package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
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
    int i;
    if ((paramURLDrawable != null) && (paramURLDrawable.exists())) {
      i = 1;
    } else {
      i = 0;
    }
    this.a.a.dismiss();
    if (i == 0) {
      QQToast.makeText(this.a.b.a, 1, HardCodeUtil.a(2131900886), 1).show(this.a.b.a.getResources().getDimensionPixelSize(2131299920));
    }
    if (i != 0)
    {
      this.a.b.b.isLocalPic = true;
      this.a.b.b.sharePicPath = paramURLDrawable.getPath();
      ShareProxyImpl.a(this.a.b.this$0, this.a.b.b);
      return;
    }
    QLog.e("ShareProxyImpl", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5.1.1
 * JD-Core Version:    0.7.0.1
 */