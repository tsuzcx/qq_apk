package com.tencent.mobileqq.qqemoticon.api;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITextUtilsApi
  extends QRouteApi
{
  public abstract String emoticonToTextForTalkBack(String paramString);
  
  public abstract Drawable getResourceDrawableThroughImageCache(Resources paramResources, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi
 * JD-Core Version:    0.7.0.1
 */