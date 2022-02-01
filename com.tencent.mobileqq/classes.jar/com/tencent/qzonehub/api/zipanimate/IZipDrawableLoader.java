package com.tencent.qzonehub.api.zipanimate;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;

@QAPI(process={"all"})
public abstract interface IZipDrawableLoader
  extends QRouteApi
{
  public abstract ZipDrawableLoaderInterface getZipDrawableLoader(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader
 * JD-Core Version:    0.7.0.1
 */