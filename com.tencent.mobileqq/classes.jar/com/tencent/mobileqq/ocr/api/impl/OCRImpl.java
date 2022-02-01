package com.tencent.mobileqq.ocr.api.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.RectF;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gallery.picocr.PicOrcUtils;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.OCRPerformUtil;
import com.tencent.mobileqq.ocr.OcrImageUtil;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;

public class OCRImpl
  implements IOCR
{
  public boolean checkImageFormat(String paramString)
  {
    return OcrImageUtil.a(paramString);
  }
  
  public boolean compressImage(String paramString1, String paramString2)
  {
    return OcrImageUtil.a(paramString1, paramString2);
  }
  
  public String getCachePath(String paramString)
  {
    return OcrImageUtil.a(paramString);
  }
  
  public String getImagePath(String paramString, boolean paramBoolean)
  {
    return OcrImageUtil.a(paramString, paramBoolean);
  }
  
  public String getImageUtilOCRPATH()
  {
    return OcrImageUtil.a;
  }
  
  public void report(String paramString, int paramInt)
  {
    OCRPerformUtil.a(paramString, paramInt);
  }
  
  public Bitmap safeDecode(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return PicOrcUtils.a(paramString, paramOptions, paramInt1, paramInt2);
  }
  
  public String savePreviewImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return OcrImageUtil.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public String savePreviewImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return OcrImageUtil.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public String savePreviewImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, RectF paramRectF, boolean paramBoolean)
  {
    return OcrImageUtil.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramRectF, paramBoolean);
  }
  
  public void startOCRTextSearchActivity(QBaseActivity paramQBaseActivity, String paramString)
  {
    OCRTextSearchActivity.a(paramQBaseActivity, paramString);
  }
  
  public void startOcrPerformFragment(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    OCRPerformFragment.a(paramActivity, paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public int takeDistance(Point paramPoint1, Point paramPoint2)
  {
    return OCRPerformUtil.a(paramPoint1, paramPoint2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.OCRImpl
 * JD-Core Version:    0.7.0.1
 */