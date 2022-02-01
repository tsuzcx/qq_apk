package com.tencent.mobileqq.imaxad.inject;

import android.content.Context;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;

public abstract interface IImaxadThirdProcessor
{
  public abstract long a();
  
  public abstract URLDrawable a(String paramString);
  
  public abstract void a(AdvertisementItem paramAdvertisementItem, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void a(AdvertisementItem paramAdvertisementItem, URLDrawable paramURLDrawable, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public abstract void a(AppInterface paramAppInterface, int paramInt, AdvertisementItem paramAdvertisementItem);
  
  public abstract void b(AdvertisementItem paramAdvertisementItem, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.inject.IImaxadThirdProcessor
 * JD-Core Version:    0.7.0.1
 */