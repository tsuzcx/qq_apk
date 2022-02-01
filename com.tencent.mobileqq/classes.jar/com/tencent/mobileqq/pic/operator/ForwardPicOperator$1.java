package com.tencent.mobileqq.pic.operator;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class ForwardPicOperator$1
  implements Runnable
{
  ForwardPicOperator$1(ForwardPicOperator paramForwardPicOperator, PicFowardInfo paramPicFowardInfo, PicReq paramPicReq) {}
  
  public void run()
  {
    Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a("doFastForward", "rec==null");
      this.this$0.a(4, this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
    ForwardPicOperator.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqPicPicReq, ((MessageForPic)localObject1).uniseq);
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.a != null) {
      ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.a;
    }
    Object localObject2 = ((MessageForPic)localObject1).path;
    boolean bool = false;
    localObject2 = new CompressInfo((String)localObject2, 0);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail((CompressInfo)localObject2);
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      ((MessageForPic)localObject1).thumbWidth = ((CompressInfo)localObject2).d;
      ((MessageForPic)localObject1).thumbHeight = ((CompressInfo)localObject2).jdField_e_of_type_Int;
    }
    ((MessageForPic)localObject1).serial();
    ((IMessageFacade)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForPic)localObject1).msgData);
    localObject1 = new TransferRequest();
    ((TransferRequest)localObject1).mSelfUin = this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    ((TransferRequest)localObject1).mPeerUin = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
    ((TransferRequest)localObject1).mSecondId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
    ((TransferRequest)localObject1).mUinType = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
    ((TransferRequest)localObject1).mFileType = 1;
    ((TransferRequest)localObject1).mUniseq = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
    ((TransferRequest)localObject1).mIsUp = true;
    ((TransferRequest)localObject1).mBusiType = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a;
    ((TransferRequest)localObject1).mLocalPath = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
    localObject2 = new TransferRequest.PicUpExtraInfo();
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 1) {
      bool = true;
    }
    ((TransferRequest.PicUpExtraInfo)localObject2).mIsRaw = bool;
    ((TransferRequest)localObject1).mExtraObj = localObject2;
    ((TransferRequest)localObject1).mUpCallBack = this.this$0;
    ((TransferRequest)localObject1).mIsFastForward = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j != 0) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k != 0) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c != 0L))
    {
      ((TransferRequest)localObject1).mMd5 = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f;
      Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
      ((TransferRequest)localObject1).mFastForwardWidth = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j;
      ((TransferRequest)localObject1).mFastForwardHeight = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k;
      ((TransferRequest)localObject1).mFastForwardFileSize = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c;
      localObject2 = (ITransFileController)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITransFileController.class, "");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((TransferRequest)localObject1).mPeerUin);
      ((StringBuilder)localObject3).append(((TransferRequest)localObject1).mUniseq);
      ((ITransFileController)localObject2).removeProcessor(((StringBuilder)localObject3).toString());
      ((ITransFileController)localObject2).transferAsync((TransferRequest)localObject1);
      localObject2 = this.this$0;
      ((ForwardPicOperator)localObject2).a(((ForwardPicOperator)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Long);
      localObject2 = this.this$0.b;
      localObject3 = this.this$0.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("end, req.mFastForwardWidth = ");
      localStringBuilder.append(((TransferRequest)localObject1).mFastForwardWidth);
      localStringBuilder.append(",req.mFastForwardHeight = ");
      localStringBuilder.append(((TransferRequest)localObject1).mFastForwardHeight);
      Logger.a((String)localObject2, (String)localObject3, "doFastForward", localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a("doFastForward", "upInfo uncomplete!");
    this.this$0.a(4, this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ForwardPicOperator.1
 * JD-Core Version:    0.7.0.1
 */