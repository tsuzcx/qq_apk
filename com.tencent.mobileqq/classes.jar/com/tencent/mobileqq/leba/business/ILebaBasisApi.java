package com.tencent.mobileqq.leba.business;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ILebaBasisApi
  extends QRouteApi
{
  public abstract boolean isLocaleUpdatedByUser();
  
  public abstract void jumpByScheme(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.ILebaBasisApi
 * JD-Core Version:    0.7.0.1
 */