package com.tencent.mobileqq.vas.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IVasH5PayUtil
  extends QRouteApi
{
  public abstract void openH5Page(String paramString1, String paramString2, Context paramContext);
  
  public abstract void openH5PayByURL(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IVasH5PayUtil
 * JD-Core Version:    0.7.0.1
 */