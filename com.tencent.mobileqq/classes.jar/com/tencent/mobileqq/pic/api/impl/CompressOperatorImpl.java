package com.tencent.mobileqq.pic.api.impl;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.pic.operator.CompressPicOperator;

public class CompressOperatorImpl
  implements ICompressOperator
{
  public Bitmap clip(Bitmap paramBitmap, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    return Utils.a(paramBitmap, paramThumbWidthHeightDP);
  }
  
  public boolean compressAIOThumbnail(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    return Utils.a(paramString1, paramString2, paramBoolean, paramString3, paramInt, null);
  }
  
  public boolean compressAIOThumbnailWithTrubo(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    return Utils.a(paramString1, paramString2, paramBoolean, paramString3, paramInt);
  }
  
  public boolean decodeJpegByTrubo()
  {
    return Utils.a();
  }
  
  public int[] getCompressConfigFromServer(AppInterface paramAppInterface)
  {
    return CompressPicOperator.a(paramAppInterface);
  }
  
  public Bitmap getGifTagBitmap()
  {
    return Utils.c();
  }
  
  public String getSendPhotoPath(String paramString, int paramInt)
  {
    return Utils.a(paramString, paramInt);
  }
  
  public boolean start(CompressInfo paramCompressInfo)
  {
    return CompressOperator.a(paramCompressInfo);
  }
  
  public boolean startThumbnail(CompressInfo paramCompressInfo)
  {
    return CompressOperator.b(paramCompressInfo);
  }
  
  public int transformQuality(int paramInt)
  {
    return CompressOperator.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.CompressOperatorImpl
 * JD-Core Version:    0.7.0.1
 */