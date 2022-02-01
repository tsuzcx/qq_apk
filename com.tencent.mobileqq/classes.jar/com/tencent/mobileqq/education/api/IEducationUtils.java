package com.tencent.mobileqq.education.api;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEducationUtils
  extends QRouteApi
{
  public abstract String bitmapToBase64(Bitmap paramBitmap);
  
  public abstract String bitmapToBase64(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt);
  
  public abstract Boolean checkBitmapValidBytes(Bitmap paramBitmap, long paramLong);
  
  public abstract Boolean checkBitmapValidSize(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public abstract String getBitmapFileBase64Data(String paramString, long paramLong);
  
  public abstract int getBitmapValidCompressQuality(Bitmap paramBitmap, long paramLong);
  
  public abstract String getStudyFileSaveRootPath();
  
  public abstract Boolean saveBitmapToFile(Bitmap paramBitmap, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.api.IEducationUtils
 * JD-Core Version:    0.7.0.1
 */