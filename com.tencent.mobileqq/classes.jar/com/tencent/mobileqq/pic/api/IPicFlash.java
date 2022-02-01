package com.tencent.mobileqq.pic.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPicFlash
  extends QRouteApi
{
  public static final int FLASH_PIC_BUBBLE_HEIGHT = 102;
  public static final int FLASH_PIC_BUBBLE_WIDTH = 130;
  
  public abstract DownloadParams.DecodeHandler getFlashPicDecodeHandler();
  
  public abstract Drawable getFlashPicReadedDrawable();
  
  public abstract Bitmap getMosaicBitmap(Bitmap paramBitmap, int paramInt);
  
  public abstract boolean isFlashPicMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isFlashPicMsgReaded(MessageRecord paramMessageRecord);
  
  public abstract void setFlashPicFlag(MessageRecord paramMessageRecord, boolean paramBoolean);
  
  public abstract void setFlashPicMsgReaded(MessageRecord paramMessageRecord);
  
  public abstract boolean showFlashPicOption(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IPicFlash
 * JD-Core Version:    0.7.0.1
 */