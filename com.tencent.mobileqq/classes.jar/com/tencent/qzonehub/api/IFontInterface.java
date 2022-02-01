package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFontInterface
  extends QRouteApi
{
  public abstract String getFullTypeFont(int paramInt, String paramString1, String paramString2, IFullTypeResult paramIFullTypeResult);
  
  public abstract String getTrueTypeFont(int paramInt, String paramString1, String paramString2, boolean paramBoolean, ITrueTypeResult paramITrueTypeResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.IFontInterface
 * JD-Core Version:    0.7.0.1
 */