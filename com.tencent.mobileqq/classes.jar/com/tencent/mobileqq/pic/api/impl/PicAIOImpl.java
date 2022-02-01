package com.tencent.mobileqq.pic.api.impl;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor;
import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExplicitError;
import com.tencent.mobileqq.utils.QQTheme;

public class PicAIOImpl
  implements IPicAIO
{
  public float getAioImageRoundCorner(DownloadParams paramDownloadParams)
  {
    if (((paramDownloadParams.tag instanceof MessageForPic)) && (((MessageForPic)paramDownloadParams.tag).istroop == 10014)) {
      return 6.0F;
    }
    if (QQTheme.isNowSimpleUI()) {
      return 8.0F;
    }
    return 12.0F;
  }
  
  public String getReceivePicFailedTip(URLDrawable paramURLDrawable)
  {
    return PicDownloadExplicitError.getFailedTip(paramURLDrawable);
  }
  
  public float getRoundCorner()
  {
    if (QQTheme.isNowSimpleUI()) {
      return 8.0F;
    }
    return 12.0F;
  }
  
  public String getSendPicFailedTip(MessageForPic paramMessageForPic)
  {
    return PicUploadExplicitError.getFailedTip(paramMessageForPic);
  }
  
  public int getThumbMaxPx(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return AIOImgThumbHelper.getAioThumbMaxPx(paramBoolean1, paramBoolean2, paramInt);
  }
  
  public int getThumbMinPx(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return AIOImgThumbHelper.getAioThumbMinPx(paramBoolean1, paramBoolean2, paramInt);
  }
  
  public ThumbWidthHeightDP getThumbWidthHeightDP(MessageForPic paramMessageForPic, boolean paramBoolean)
  {
    return AIOImgThumbHelper.getThumbWidthHeightDP(paramMessageForPic, paramBoolean);
  }
  
  public void reportNormalPicMsgClickEvent(MessageForPic paramMessageForPic)
  {
    AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig localAIOPicThumbSizeConfig = AIOPicThumbSizeProcessor.a();
    if (localAIOPicThumbSizeConfig != null)
    {
      int i;
      if (localAIOPicThumbSizeConfig.b > 0.0D) {
        i = (int)(localAIOPicThumbSizeConfig.b * 100.0D);
      } else if ((!localAIOPicThumbSizeConfig.equals(new AIOPicThumbSizeProcessor().c())) && (localAIOPicThumbSizeConfig.a)) {
        i = 0;
      } else {
        i = 101;
      }
      if (paramMessageForPic.istroop == 0) {
        paramMessageForPic = "1";
      }
      for (;;)
      {
        break;
        if (UinTypeUtil.h(paramMessageForPic.istroop)) {
          paramMessageForPic = "2";
        } else if (UinTypeUtil.b(paramMessageForPic.istroop)) {
          paramMessageForPic = "3";
        } else {
          paramMessageForPic = "4";
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800B2A2", "0X800B2A2", i, 0, paramMessageForPic, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicAIOImpl
 * JD-Core Version:    0.7.0.1
 */