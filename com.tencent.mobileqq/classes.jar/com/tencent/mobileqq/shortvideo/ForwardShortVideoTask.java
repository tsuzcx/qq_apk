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
  private final BaseShortVideoUpOperator jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator;
  ShortVideoForwardInfo jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo;
  
  public ForwardShortVideoTask(BaseShortVideoUpOperator paramBaseShortVideoUpOperator, ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator = paramBaseShortVideoUpOperator;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo = paramShortVideoForwardInfo;
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
    localTransferRequest.mMd5 = paramShortVideoForwardInfo.e;
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append(paramShortVideoForwardInfo.h);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.i);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.j);
    paramMessageRecord.append("QQ_&_MoblieQQ_&_QQ");
    paramMessageRecord.append(paramShortVideoForwardInfo.g);
    localTransferRequest.mLocalPath = paramMessageRecord.toString();
    paramShortVideoForwardInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator;
    localTransferRequest.mUpCallBack = paramShortVideoForwardInfo;
    localTransferRequest.mRec = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    return localTransferRequest;
  }
  
  public void a()
  {
    ShortVideoForwardInfo localShortVideoForwardInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo;
    if (localShortVideoForwardInfo == null) {
      return;
    }
    Object localObject = null;
    long l = localShortVideoForwardInfo.jdField_a_of_type_Long;
    int i = localShortVideoForwardInfo.p;
    boolean bool;
    if (localShortVideoForwardInfo.k == 3)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.a(localShortVideoForwardInfo);
      bool = true;
    }
    else
    {
      if (localShortVideoForwardInfo.k == 4) {
        localObject = (MessageForShortVideo)localShortVideoForwardInfo.jdField_a_of_type_JavaLangObject;
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
    this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    paramLong = System.currentTimeMillis();
    TransferRequest localTransferRequest = a(paramShortVideoForwardInfo, paramMessageRecord);
    a(localTransferRequest);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.a(paramMessageRecord, paramShortVideoForwardInfo.b);
    }
    paramShortVideoForwardInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.b;
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - paramLong);
    Logger.a(paramShortVideoForwardInfo, paramMessageRecord, "doForwardShortVideo", localStringBuilder.toString());
    paramShortVideoForwardInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.b;
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TransferRequest: ");
    localStringBuilder.append(localTransferRequest.toString());
    Logger.a(paramShortVideoForwardInfo, paramMessageRecord, "doForwardShortVideo.start", localStringBuilder.toString());
  }
  
  public void a(TransferRequest paramTransferRequest)
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramTransferRequest);
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */