package com.tencent.mobileqq.qqfavor.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFavoriteOCR
  extends QRouteApi
{
  public abstract void favorite(Activity paramActivity, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfavor.api.IFavoriteOCR
 * JD-Core Version:    0.7.0.1
 */