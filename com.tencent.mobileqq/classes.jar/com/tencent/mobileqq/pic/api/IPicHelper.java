package com.tencent.mobileqq.pic.api;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;

@QAPI(process={"all"})
public abstract interface IPicHelper
  extends QRouteApi
{
  public abstract void cachePicToDisk(MessageForPic paramMessageForPic);
  
  public abstract String getBiggestFilePath(MessageForPic paramMessageForPic);
  
  public abstract URLDrawable getDrawable(PicUiInterface paramPicUiInterface, int paramInt, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions);
  
  public abstract int getFileSizeType(String paramString, boolean paramBoolean);
  
  public abstract String getMsgSummaryForAnimationPic(MessageForPic paramMessageForPic);
  
  public abstract URL getURL(PicDownloadInfo paramPicDownloadInfo, int paramInt, String paramString);
  
  public abstract URL getURL(PicUiInterface paramPicUiInterface, int paramInt, String paramString);
  
  public abstract URL getURL(PicUploadInfo paramPicUploadInfo, int paramInt, String paramString);
  
  public abstract URL getURL(String paramString, int paramInt);
  
  public abstract boolean isEmotion(MessageForPic paramMessageForPic);
  
  public abstract void parseDbMsgOldVersion(MessageForPic paramMessageForPic, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IPicHelper
 * JD-Core Version:    0.7.0.1
 */