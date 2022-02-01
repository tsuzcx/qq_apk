package com.tencent.mobileqq.pic.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IPicUtil
  extends QRouteApi
{
  public abstract boolean compressQuality(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo);
  
  public abstract Bitmap getExifBitmap(String paramString, Bitmap paramBitmap);
  
  public abstract int getImageType(String paramString);
  
  public abstract ArrayList<Integer> getSliceInfos(String paramString);
  
  public abstract boolean isDynamicImg(int paramInt);
  
  public abstract boolean isLongPic(int paramInt1, int paramInt2);
  
  public abstract boolean isProgressiveJpeg(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IPicUtil
 * JD-Core Version:    0.7.0.1
 */