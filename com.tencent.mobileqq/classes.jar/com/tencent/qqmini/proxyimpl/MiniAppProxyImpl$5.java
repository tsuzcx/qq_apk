package com.tencent.qqmini.proxyimpl;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.IDrawableLoadedCallBack;

class MiniAppProxyImpl$5
  implements URLDrawable.URLDrawableListener
{
  MiniAppProxyImpl$5(MiniAppProxyImpl paramMiniAppProxyImpl, MiniAppProxy.IDrawableLoadedCallBack paramIDrawableLoadedCallBack) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.val$callBack.onLoadSuccessed(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */