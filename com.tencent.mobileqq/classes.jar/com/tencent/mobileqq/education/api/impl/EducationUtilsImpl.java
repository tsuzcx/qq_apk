package com.tencent.mobileqq.education.api.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.education.api.IEducationUtils;
import com.tencent.mobileqq.education.utils.StudyBitmapUtils;

public class EducationUtilsImpl
  implements IEducationUtils
{
  private StudyBitmapUtils mBitmapUtils = new StudyBitmapUtils();
  
  public String bitmapToBase64(Bitmap paramBitmap)
  {
    return this.mBitmapUtils.a(paramBitmap);
  }
  
  public String bitmapToBase64(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    return this.mBitmapUtils.a(paramBitmap, paramCompressFormat, paramInt);
  }
  
  public Boolean checkBitmapValidBytes(Bitmap paramBitmap, long paramLong)
  {
    return Boolean.valueOf(this.mBitmapUtils.a(paramBitmap, paramLong));
  }
  
  public Boolean checkBitmapValidSize(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return Boolean.valueOf(this.mBitmapUtils.a(paramBitmap, paramInt1, paramInt2));
  }
  
  public String getBitmapFileBase64Data(String paramString, long paramLong)
  {
    return this.mBitmapUtils.a(paramString, paramLong);
  }
  
  public int getBitmapValidCompressQuality(Bitmap paramBitmap, long paramLong)
  {
    return this.mBitmapUtils.b(paramBitmap, paramLong);
  }
  
  public String getStudyFileSaveRootPath()
  {
    return this.mBitmapUtils.a();
  }
  
  public Boolean saveBitmapToFile(Bitmap paramBitmap, String paramString)
  {
    return Boolean.valueOf(this.mBitmapUtils.a(paramBitmap, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.api.impl.EducationUtilsImpl
 * JD-Core Version:    0.7.0.1
 */