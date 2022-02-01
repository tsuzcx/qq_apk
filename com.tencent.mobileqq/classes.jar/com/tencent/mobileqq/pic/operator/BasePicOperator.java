package com.tencent.mobileqq.pic.operator;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class BasePicOperator
  extends AbstractPicOperator
{
  protected MessageRecord i;
  
  protected AbstractPicOperator a(PicReq paramPicReq)
  {
    AbstractPicOperator localAbstractPicOperator = PicBusiManager.b(paramPicReq.a, paramPicReq.b);
    localAbstractPicOperator.a = this.a;
    localAbstractPicOperator.b = this.b;
    localAbstractPicOperator.c = paramPicReq;
    return localAbstractPicOperator;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    paramMessageForPic = ((IPicHelper)QRoute.api(IPicHelper.class)).getDrawable(paramMessageForPic, 65537, null, null);
    paramMessageForPic.downloadImediatly();
    ThreadManagerV2.getUIHandlerV2().post(new BasePicOperator.1(this, paramMessageForPic));
    paramMessageForPic = this.b;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(paramMessageForPic, str, "preload thumb", localStringBuilder.toString());
  }
  
  protected void a(MessageRecord paramMessageRecord, long paramLong)
  {
    ((IOrderMediaMsgService)this.e.getRuntimeService(IOrderMediaMsgService.class, "")).updateMediaMsgByUniseq(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    ((IOrderMediaMsgService)this.e.getRuntimeService(IOrderMediaMsgService.class, "")).addOrderMsg(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  protected void b(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    paramPicUploadInfo = paramPicUploadInfo.r;
    int j = paramPicUploadInfo.size();
    int k;
    if (j == 10)
    {
      j = 9;
      k = 4;
    }
    else if (j == 6)
    {
      j = 5;
      k = 5;
    }
    else
    {
      j = -1;
      k = -1;
    }
    if (j != -1)
    {
      paramMessageForPic.mDownloadLength = ((Integer)paramPicUploadInfo.get(j)).intValue();
      paramMessageForPic.mShowLength = ((Integer)paramPicUploadInfo.get(k)).intValue();
    }
    if (QLog.isColorLevel())
    {
      paramPicUploadInfo = new StringBuilder();
      paramPicUploadInfo.append("AioPicOperator.loadPgInfo():showLen ");
      paramPicUploadInfo.append(paramMessageForPic.mShowLength);
      paramPicUploadInfo.append(", downloadLen ");
      paramPicUploadInfo.append(paramMessageForPic.mDownloadLength);
      QLog.d("peak_pgjpeg", 2, paramPicUploadInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.BasePicOperator
 * JD-Core Version:    0.7.0.1
 */