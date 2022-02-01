package com.tencent.mobileqq.imaxad;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ImaxadThirdProcessorImpl$1
  implements URLDrawable.URLDrawableListener
{
  ImaxadThirdProcessorImpl$1(ImaxadThirdProcessorImpl paramImaxadThirdProcessorImpl, AdvertisementItem paramAdvertisementItem, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("ImaxAdvertisement", 1, "s_forShare Bitmap onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("ImaxAdvertisement", 1, "s_forShare Bitmap FAILED, no more action ...");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ((IShortVideoShareUtil)QRoute.api(IShortVideoShareUtil.class)).drawableToBitmap(paramURLDrawable);
    ImaxadThirdProcessorImpl.a(this.g, this.a, this.b, this.c, this.d, paramURLDrawable, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxadThirdProcessorImpl.1
 * JD-Core Version:    0.7.0.1
 */