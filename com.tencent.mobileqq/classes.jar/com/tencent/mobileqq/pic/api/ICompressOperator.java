package com.tencent.mobileqq.pic.api;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICompressOperator
  extends QRouteApi
{
  public static final int TYPE_AIO_FILEPIC = 1;
  public static final int TYPE_AIO_IMAGE = 0;
  public static final int TYPE_FILEPIC_750 = 2;
  
  public abstract Bitmap clip(Bitmap paramBitmap, ThumbWidthHeightDP paramThumbWidthHeightDP);
  
  public abstract boolean compressAIOThumbnail(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt);
  
  public abstract boolean compressAIOThumbnailWithTrubo(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt);
  
  public abstract boolean decodeJpegByTrubo();
  
  public abstract int[] getCompressConfigFromServer(AppInterface paramAppInterface);
  
  public abstract Bitmap getGifTagBitmap();
  
  public abstract String getSendPhotoPath(String paramString, int paramInt);
  
  public abstract boolean start(CompressInfo paramCompressInfo);
  
  public abstract boolean startThumbnail(CompressInfo paramCompressInfo);
  
  public abstract int transformQuality(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.ICompressOperator
 * JD-Core Version:    0.7.0.1
 */