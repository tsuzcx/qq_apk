package com.tencent.mobileqq.pic.api;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IPicAIO
  extends QRouteApi
{
  public static final float AIO_IMAGE_ROUND_CORNER = 12.0F;
  public static final float AIO_IMAGE_ROUND_CORNER_SIMPLE = 8.0F;
  
  public abstract float getAioImageRoundCorner(DownloadParams paramDownloadParams);
  
  public abstract String getReceivePicFailedTip(URLDrawable paramURLDrawable);
  
  public abstract float getRoundCorner();
  
  public abstract String getSendPicFailedTip(MessageForPic paramMessageForPic);
  
  public abstract int getThumbMaxPx(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract int getThumbMinPx(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract ThumbWidthHeightDP getThumbWidthHeightDP(MessageForPic paramMessageForPic, boolean paramBoolean);
  
  public abstract void reportNormalPicMsgClickEvent(MessageForPic paramMessageForPic);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IPicAIO
 * JD-Core Version:    0.7.0.1
 */