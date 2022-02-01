package com.tencent.mobileqq.richmedia.ordersend;

import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.io.File;

public class MediaMsgController
{
  private QQAppInterface a;
  
  public MediaMsgController(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -2000) || (paramInt == -2022) || (paramInt == -1035) || (paramInt == -1036);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1004) || (paramInt == 1005) || (paramInt == 2005) || (paramInt == 5001) || (paramInt == 5002);
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
      if ((paramMessageRecord instanceof BaseTransProcessor)) {
        return (int)((BaseTransProcessor)paramMessageRecord).getFileStatus();
      }
    }
    return -1;
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    VideoCompressProcessor.CompressTask localCompressTask = new VideoCompressProcessor.CompressTask(this.a, this.a.getApplication(), paramMessageForShortVideo, null);
    VideoCompressProcessor.a().a(paramMessageForShortVideo.uniseq, localCompressTask);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.a == null)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      if ((paramMessageRecord instanceof MessageForMixedMsg)) {
        this.a.getMessageFacade().a(paramMessageRecord);
      }
      while (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMsg cost:").append(System.currentTimeMillis() - l).append(" uniseq = ").append(paramMessageRecord.uniseq).append(", msgtype = ").append(paramMessageRecord.msgtype);
        QLog.d("MediaMsgController", 2, localStringBuilder.toString());
        return;
        ((SVIPHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramMessageRecord);
        this.a.getMessageFacade().a(paramMessageRecord, this.a.getCurrentAccountUin());
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, OrderMediaMsgManager.IMsgSendingListener paramIMsgSendingListener)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramIMsgSendingListener != null) {
      paramIMsgSendingListener.onSendBegin(paramMessageRecord);
    }
    this.a.getMessageFacade().b(paramMessageRecord, paramMessageObserver);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.extraflag == 32768)) {
      return true;
    }
    int i;
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      i = ((MessageForShortVideo)paramMessageRecord).videoFileStatus;
    }
    for (;;)
    {
      return b(i);
      if (((paramMessageRecord instanceof MessageForPic)) && (((MessageForPic)paramMessageRecord).size <= 0L))
      {
        int j = a(paramMessageRecord);
        i = j;
        if (j == -1) {
          return true;
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      File localFile = new File(paramString);
      if ((localFile.exists()) && (GifDrawable.isGifFile(localFile)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaMsgController", 2, "isDoutuPic gifFile");
        }
        return true;
      }
      i = PeakUtils.a(paramString);
    } while ((i != 2000) && (i != 3));
    if (QLog.isColorLevel()) {
      QLog.d("MediaMsgController", 2, new Object[] { "isDoutuPic imageType:", Integer.valueOf(i) });
    }
    return true;
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
      if (!(paramMessageRecord instanceof BaseTransProcessor)) {}
    }
    for (int i = ((BaseTransProcessor)paramMessageRecord).getCurrentProgress();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaMsgController", 2, new Object[] { "getUploadProgress:", Integer.valueOf(i) });
      }
      return i;
    }
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramMessageRecord;
      if ((localMessageForShortVideo.busiType == 0) && (localMessageForShortVideo.videoFileStatus != 998) && (TextUtils.isEmpty(localMessageForShortVideo.md5)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaMsgController", 2, "isVideoNeedPreCompress is true, " + paramMessageRecord.uniseq);
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if (b(paramMessageRecord))
    {
      bool = true;
      a((MessageForShortVideo)paramMessageRecord);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.MediaMsgController
 * JD-Core Version:    0.7.0.1
 */