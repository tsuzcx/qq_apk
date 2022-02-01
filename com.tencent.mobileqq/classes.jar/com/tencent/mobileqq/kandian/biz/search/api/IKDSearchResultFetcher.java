package com.tencent.mobileqq.kandian.biz.search.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IKDSearchResultFetcher
  extends QRouteApi
{
  public abstract void jumpToNativeSearchResultPage(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.api.IKDSearchResultFetcher
 * JD-Core Version:    0.7.0.1
 */