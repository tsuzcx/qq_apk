package com.tencent.mobileqq.richmedia.ordersend;

import android.text.TextUtils;
import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

@KeepClassConstructor
public class MediaMsgController
  implements IMediaMsgApi
{
  private QQAppInterface a;
  
  public MediaMsgController()
  {
    this.a = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
  
  public MediaMsgController(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
      if ((paramMessageRecord instanceof BaseTransProcessor))
      {
        i = ((BaseTransProcessor)paramMessageRecord).getCurrentProgress();
        break label50;
      }
    }
    int i = -1;
    label50:
    if (QLog.isColorLevel()) {
      QLog.d("MediaMsgController", 2, new Object[] { "getUploadProgress:", Integer.valueOf(i) });
    }
    return i;
  }
  
  public void a(long paramLong)
  {
    VideoCompressProcessor.a().a(paramLong);
  }
  
  public void a(View paramView, Callback paramCallback)
  {
    FileTransferManager localFileTransferManager = FileTransferManager.a(this.a);
    if (localFileTransferManager != null) {
      localFileTransferManager.a(paramView, paramCallback);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver, IOrderMediaMsgService.IMsgSendingListener paramIMsgSendingListener)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramIMsgSendingListener != null) {
      paramIMsgSendingListener.onSendBegin(paramMessageRecord);
    }
    paramBaseMessageObserver = new MediaMsgController.1(this, paramBaseMessageObserver, paramMessageRecord);
    this.a.getMessageFacade().b(paramMessageRecord, paramBaseMessageObserver);
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 1004) || (paramInt == 1005) || (paramInt == 2005) || (paramInt == 5001) || (paramInt == 5002);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    File localFile = new File(paramString);
    if ((localFile.exists()) && (GifDrawable.isGifFile(localFile)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaMsgController", 2, "isDoutuPic gifFile");
      }
      return true;
    }
    int i = ((IPicUtil)QRoute.api(IPicUtil.class)).getImageType(paramString);
    if ((i != 2000) && (i != 3)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MediaMsgController", 2, new Object[] { "isDoutuPic imageType:", Integer.valueOf(i) });
    }
    return true;
  }
  
  public String b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      return ((MessageForShortVideo)paramMessageRecord).videoFileName;
    }
    if ((paramMessageRecord instanceof MessageForPic)) {
      return ((MessageForPic)paramMessageRecord).path;
    }
    return null;
  }
  
  public boolean b(int paramInt)
  {
    return (paramInt == -2000) || (paramInt == -2022) || (paramInt == -1035) || (paramInt == -1036);
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.extraflag == 32768)) {
      return true;
    }
    int j = 0;
    int i;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      i = ((MessageForShortVideo)paramMessageRecord).videoFileStatus;
    }
    else
    {
      i = j;
      if ((paramMessageRecord instanceof MessageForPic))
      {
        i = j;
        if (((MessageForPic)paramMessageRecord).size <= 0L)
        {
          j = f(paramMessageRecord);
          i = j;
          if (j == -1) {
            return true;
          }
        }
      }
    }
    return a(i);
  }
  
  public void d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      if (this.a == null) {
        return;
      }
      long l = System.currentTimeMillis();
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        this.a.getMessageFacade().a(paramMessageRecord);
      }
      else
      {
        ((ISVIPHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramMessageRecord);
        this.a.getMessageFacade().a(paramMessageRecord, this.a.getCurrentAccountUin());
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMsg cost:");
        localStringBuilder.append(System.currentTimeMillis() - l);
        localStringBuilder.append(" uniseq = ");
        localStringBuilder.append(paramMessageRecord.uniseq);
        localStringBuilder.append(", msgtype = ");
        localStringBuilder.append(paramMessageRecord.msgtype);
        QLog.d("MediaMsgController", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean e(MessageRecord paramMessageRecord)
  {
    if (g(paramMessageRecord))
    {
      h(paramMessageRecord);
      return true;
    }
    return false;
  }
  
  public int f(MessageRecord paramMessageRecord)
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
  
  public boolean g(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      Object localObject = (MessageForShortVideo)paramMessageRecord;
      if ((((MessageForShortVideo)localObject).busiType == 0) && (((MessageForShortVideo)localObject).videoFileStatus != 998) && (TextUtils.isEmpty(((MessageForShortVideo)localObject).md5)))
      {
        bool = true;
        if (!QLog.isColorLevel()) {
          return bool;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isVideoNeedPreCompress is true, ");
        ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
        QLog.d("MediaMsgController", 2, ((StringBuilder)localObject).toString());
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  protected void h(MessageRecord paramMessageRecord)
  {
    Object localObject = this.a;
    localObject = new VideoCompressProcessor.CompressTask((QQAppInterface)localObject, ((QQAppInterface)localObject).getApplication(), (MessageForShortVideo)paramMessageRecord, null);
    VideoCompressProcessor.a().a(paramMessageRecord.uniseq, (VideoCompressProcessor.CompressTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.MediaMsgController
 * JD-Core Version:    0.7.0.1
 */