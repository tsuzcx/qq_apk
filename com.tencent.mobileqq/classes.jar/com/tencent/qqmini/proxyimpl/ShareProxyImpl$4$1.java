package com.tencent.qqmini.proxyimpl;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ShareProxyImpl$4$1
  implements URLDrawable.URLDrawableListener
{
  ShareProxyImpl$4$1(ShareProxyImpl.4 param4, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadCanceled get an exception when handling URLbmp:");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadFialed when handling URLbmp");
    ShareProxyImpl.a(this.b.f, this.b.c, this.b.a, this.b.d, this.b.e, this.b.c.name, this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadProgressed get an exception when handling URLbmp:");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.drawableToBitmap(paramURLDrawable.getCurrDrawable());
    if (paramURLDrawable != null) {
      ShareProxyImpl.a(this.b.f, this.b.c, this.b.d, this.b.e, this.b.c.name, ShareProxyImpl.a(this.b.f, paramURLDrawable), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.4.1
 * JD-Core Version:    0.7.0.1
 */