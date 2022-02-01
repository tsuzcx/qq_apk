package com.tencent.mobileqq.intervideo;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICdnPmUpdaterFactory
  extends QRouteApi
{
  public abstract ICdnPmUpdater createCdnPmUpdater(Context paramContext, String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.ICdnPmUpdaterFactory
 * JD-Core Version:    0.7.0.1
 */