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
  private final BaseShortVideoUpOperator jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator;
  ShortVideoUploadInfo jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
  
  public SendShortVideoTask(BaseShortVideoUpOperator paramBaseShortVideoUpOperator, ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator = paramBaseShortVideoUpOperator;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo = paramShortVideoUploadInfo;
  }
  
  private void a(TransferRequest paramTransferRequest)
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramTransferRequest);
  }
  
  private void b(ShortVideoUploadInfo paramShortVideoUploadInfo, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((!paramShortVideoUploadInfo.jdField_e_of_type_Boolean) && (!paramShortVideoUploadInfo.jdField_g_of_type_Boolean))
    {
      if (!paramShortVideoUploadInfo.b)
      {
        ((IMessageFacade)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IMessageFacade.class)).setChangeAndNotify(paramMessageRecord);
        return;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.a(paramMessageRecord);
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
      }
    }
    else {
      localTransferRequest.mFileType = 6;
    }
    localTransferRequest.mUniseq = paramMessageRecord.uniseq;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = paramShortVideoUploadInfo.jdField_a_of_type_Int;
    localTransferRequest.mMd5 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramShortVideoUploadInfo.h);
    localStringBuilder.append("QQ_&_MoblieQQ_&_QQ");
    localStringBuilder.append(paramShortVideoUploadInfo.j);
    localStringBuilder.append("QQ_&_MoblieQQ_&_QQ");
    localStringBuilder.append(paramShortVideoUploadInfo.f);
    localStringBuilder.append("QQ_&_MoblieQQ_&_QQ");
    localStringBuilder.append(paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString);
    localTransferRequest.mLocalPath = localStringBuilder.toString();
    localTransferRequest.mUpCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator;
    localTransferRequest.mRec = paramMessageRecord;
    localTransferRequest.mExtraObj = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
    return localTransferRequest;
  }
  
  public void a()
  {
    ShortVideoUploadInfo localShortVideoUploadInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
    if (localShortVideoUploadInfo == null) {
      return;
    }
    Object localObject = null;
    boolean bool1 = localShortVideoUploadInfo.b;
    boolean bool2 = false;
    if (!bool1)
    {
      localObject = (MessageForShortVideo)localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject;
      bool1 = bool2;
    }
    else if (localShortVideoUploadInfo.jdField_g_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.a(localShortVideoUploadInfo);
      bool1 = true;
    }
    else
    {
      bool1 = bool2;
      if (localShortVideoUploadInfo.jdField_g_of_type_Int == 1)
      {
        localObject = (MessageForShortVideo)localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject;
        bool1 = bool2;
      }
    }
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    a(localShortVideoUploadInfo, (MessageRecord)localObject, bool1);
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    TransferRequest localTransferRequest = a(paramShortVideoUploadInfo, paramMessageRecord);
    a(localTransferRequest);
    b(paramShortVideoUploadInfo, paramMessageRecord, paramBoolean);
    paramShortVideoUploadInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.b;
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoUploadInfo, paramMessageRecord, "doSendShortVideo", localStringBuilder.toString());
    paramShortVideoUploadInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.b;
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.jdField_a_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */