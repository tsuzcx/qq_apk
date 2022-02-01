package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

public class SendShortVideoTask
  implements Runnable
{
  ShortVideoUploadInfo a;
  private final BaseShortVideoUpOperator b;
  
  public SendShortVideoTask(BaseShortVideoUpOperator paramBaseShortVideoUpOperator, ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    this.b = paramBaseShortVideoUpOperator;
    this.a = paramShortVideoUploadInfo;
  }
  
  private void a(TransferRequest paramTransferRequest)
  {
    ((ITransFileController)this.b.a.getRuntimeService(ITransFileController.class)).transferAsync(paramTransferRequest);
  }
  
  private void b(ShortVideoUploadInfo paramShortVideoUploadInfo, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((!paramShortVideoUploadInfo.B) && (!paramShortVideoUploadInfo.D))
    {
      if (!paramShortVideoUploadInfo.w)
      {
        ((IMessageFacade)this.b.a.getRuntimeService(IMessageFacade.class)).setChangeAndNotify(paramMessageRecord);
        return;
      }
      if (paramBoolean) {
        this.b.a(paramMessageRecord);
      }
    }
  }
  
  public TransferRequest a(ShortVideoUploadInfo paramShortVideoUploadInfo, MessageRecord paramMessageRecord)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = paramMessageRecord.selfuin;
    localTransferRequest.mPeerUin = paramMessageRecord.frienduin;
    localTransferRequest.mUinType = paramMessageRecord.istroop;
    if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1008))
    {
      if (paramMessageRecord.istroop == 3000) {
        localTransferRequest.mFileType = 17;
      } else if (paramMessageRecord.istroop == 1) {
        localTransferRequest.mFileType = 9;
      } else if (paramMessageRecord.istroop == 10014) {
        localTransferRequest.mFileType = 67;
      }
    }
    else {
      localTransferRequest.mFileType = 6;
    }
    localTransferRequest.mUniseq = paramMessageRecord.uniseq;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = paramShortVideoUploadInfo.b;
    localTransferRequest.mMd5 = paramShortVideoUploadInfo.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramShortVideoUploadInfo.l);
    localStringBuilder.append("QQ_&_MoblieQQ_&_QQ");
    localStringBuilder.append(paramShortVideoUploadInfo.n);
    localStringBuilder.append("QQ_&_MoblieQQ_&_QQ");
    localStringBuilder.append(paramShortVideoUploadInfo.r);
    localStringBuilder.append("QQ_&_MoblieQQ_&_QQ");
    localStringBuilder.append(paramShortVideoUploadInfo.k);
    localTransferRequest.mLocalPath = localStringBuilder.toString();
    localTransferRequest.mUpCallBack = this.b;
    localTransferRequest.mRec = paramMessageRecord;
    localTransferRequest.mExtraObj = this.a;
    return localTransferRequest;
  }
  
  public void a()
  {
    ShortVideoUploadInfo localShortVideoUploadInfo = this.a;
    if (localShortVideoUploadInfo == null) {
      return;
    }
    Object localObject = null;
    boolean bool1 = localShortVideoUploadInfo.w;
    boolean bool2 = false;
    if (!bool1)
    {
      localObject = (MessageForShortVideo)localShortVideoUploadInfo.s;
      bool1 = bool2;
    }
    else if (localShortVideoUploadInfo.t == 0)
    {
      localObject = this.b.a(localShortVideoUploadInfo);
      bool1 = true;
    }
    else
    {
      bool1 = bool2;
      if (localShortVideoUploadInfo.t == 1)
      {
        localObject = (MessageForShortVideo)localShortVideoUploadInfo.s;
        bool1 = bool2;
      }
    }
    if (localObject == null) {
      return;
    }
    this.b.f = ((MessageRecord)localObject);
    a(localShortVideoUploadInfo, (MessageRecord)localObject, bool1);
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    TransferRequest localTransferRequest = a(paramShortVideoUploadInfo, paramMessageRecord);
    a(localTransferRequest);
    b(paramShortVideoUploadInfo, paramMessageRecord, paramBoolean);
    paramShortVideoUploadInfo = this.b.e;
    paramMessageRecord = this.b.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoUploadInfo, paramMessageRecord, "doSendShortVideo", localStringBuilder.toString());
    paramShortVideoUploadInfo = this.b.e;
    paramMessageRecord = this.b.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TransferRequest: ");
    localStringBuilder.append(localTransferRequest.toString());
    Logger.a(paramShortVideoUploadInfo, paramMessageRecord, "doSendShortVideo.start", localStringBuilder.toString());
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */