package com.tencent.mobileqq.ocr.api;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.RectF;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IOCR
  extends QRouteApi
{
  public abstract boolean checkImageFormat(String paramString);
  
  public abstract boolean compressImage(String paramString1, String paramString2);
  
  public abstract String getCachePath(String paramString);
  
  public abstract String getImagePath(String paramString, boolean paramBoolean);
  
  public abstract String getImageUtilOCRPATH();
  
  public abstract void report(String paramString, int paramInt);
  
  public abstract Bitmap safeDecode(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2);
  
  public abstract String savePreviewImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract String savePreviewImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract String savePreviewImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, RectF paramRectF, boolean paramBoolean);
  
  public abstract void startOCRTextSearchActivity(QBaseActivity paramQBaseActivity, String paramString);
  
  public abstract void startOcrPerformFragment(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract int takeDistance(Point paramPoint1, Point paramPoint2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.IOCR
 * JD-Core Version:    0.7.0.1
 */