package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class ForwardShortVideoTask
  implements Runnable
{
  ShortVideoForwardInfo a;
  private final BaseShortVideoUpOperator b;
  
  public ForwardShortVideoTask(BaseShortVideoUpOperator paramBaseShortVideoUpOperator, ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    this.b = paramBaseShortVideoUpOperator;
    this.a = paramShortVideoForwardInfo;
  }
  
  public TransferRequest a(ShortVideoForwardInfo paramShortVideoForwardInfo, MessageRecord paramMessageRecord)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = paramMessageRecord.selfuin;
    localTransferRequest.mPeerUin = paramMessageRecord.frienduin;
    localTransferRequest.mUinType = paramMessageRecord.istroop;
    localTransferRequest.mFileType = 20;
    localTransferRequest.mExtraObj = paramShortVideoForwardInfo;
    localTransferRequest.mUniseq = paramMessageRecord.uniseq;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = 0;
    localTransferRequest.mMd5 = paramShortVideoForwardInfo.i;
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append(paramShortVideoForwardInfo.p);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.q);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.u);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.k);
    localTransferRequest.mLocalPath = paramMessageRecord.toString();
    paramShortVideoForwardInfo = this.b;
    localTransferRequest.mUpCallBack = paramShortVideoForwardInfo;
    localTransferRequest.mRec = paramShortVideoForwardInfo.f;
    return localTransferRequest;
  }
  
  public void a()
  {
    ShortVideoForwardInfo localShortVideoForwardInfo = this.a;
    if (localShortVideoForwardInfo == null) {
      return;
    }
    Object localObject = null;
    long l = localShortVideoForwardInfo.g;
    int i = localShortVideoForwardInfo.G;
    boolean bool;
    if (localShortVideoForwardInfo.w == 3)
    {
      localObject = this.b.a(localShortVideoForwardInfo);
      bool = true;
    }
    else
    {
      if (localShortVideoForwardInfo.w == 4) {
        localObject = (MessageForShortVideo)localShortVideoForwardInfo.v;
      }
      bool = false;
    }
    if (localObject == null) {
      return;
    }
    a(localShortVideoForwardInfo, (MessageRecord)localObject, l, i, bool);
  }
  
  public void a(ShortVideoForwardInfo paramShortVideoForwardInfo, MessageRecord paramMessageRecord, long paramLong, int paramInt, boolean paramBoolean)
  {
    ((IForwardOrderManager)QRoute.api(IForwardOrderManager.class)).mapUniSeqId(paramMessageRecord.uniseq, paramLong, paramInt);
    this.b.f = paramMessageRecord;
    paramLong = System.currentTimeMillis();
    TransferRequest localTransferRequest = a(paramShortVideoForwardInfo, paramMessageRecord);
    a(localTransferRequest);
    if (paramBoolean) {
      this.b.a(paramMessageRecord, paramShortVideoForwardInfo.P);
    }
    paramShortVideoForwardInfo = this.b.e;
    paramMessageRecord = this.b.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - paramLong);
    Logger.a(paramShortVideoForwardInfo, paramMessageRecord, "doForwardShortVideo", localStringBuilder.toString());
    paramShortVideoForwardInfo = this.b.e;
    paramMessageRecord = this.b.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TransferRequest: ");
    localStringBuilder.append(localTransferRequest.toString());
    Logger.a(paramShortVideoForwardInfo, paramMessageRecord, "doForwardShortVideo.start", localStringBuilder.toString());
  }
  
  public void a(TransferRequest paramTransferRequest)
  {
    ((ITransFileController)this.b.a.getRuntimeService(ITransFileController.class)).transferAsync(paramTransferRequest);
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */