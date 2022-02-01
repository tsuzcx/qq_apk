package com.tencent.mobileqq.pic.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.richmedia.dc.PhotoUtils;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import java.util.ArrayList;

public class PicUtilImpl
  implements IPicUtil
{
  public boolean compressQuality(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    return Utils.a(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
  }
  
  public Bitmap getExifBitmap(String paramString, Bitmap paramBitmap)
  {
    return new ExifBitmapCreator(paramString).creatBitmap(paramBitmap);
  }
  
  public int getImageType(String paramString)
  {
    return PicBusUtil.c(paramString);
  }
  
  public ArrayList<Integer> getSliceInfos(String paramString)
  {
    return PicBusUtil.b(paramString);
  }
  
  public boolean isDynamicImg(int paramInt)
  {
    return (paramInt >= 2000) || (paramInt == 3);
  }
  
  public boolean isLongPic(int paramInt1, int paramInt2)
  {
    return PhotoUtils.a(paramInt1, paramInt2);
  }
  
  public boolean isProgressiveJpeg(String paramString)
  {
    return PicBusUtil.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicUtilImpl
 * JD-Core Version:    0.7.0.1
 */