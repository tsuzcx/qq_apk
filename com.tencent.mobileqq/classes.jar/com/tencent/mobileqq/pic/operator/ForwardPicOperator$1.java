package com.tencent.mobileqq.pic.operator;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
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
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    CompressOperator.b((CompressInfo)localObject2);
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (GeneralConfigUtils.a())
      {
        ((MessageForPic)localObject1).bigThumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
        ((MessageForPic)localObject1).thumbWidth = ((CompressInfo)localObject2).d;
        ((MessageForPic)localObject1).thumbHeight = ((CompressInfo)localObject2).jdField_e_of_type_Int;
      }
    }
    else
    {
      ((MessageForPic)localObject1).serial();
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForPic)localObject1).msgData);
      localObject1 = new TransferRequest();
      ((TransferRequest)localObject1).mSelfUin = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((TransferRequest)localObject1).mPeerUin = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((TransferRequest)localObject1).mSecondId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((TransferRequest)localObject1).mUinType = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((TransferRequest)localObject1).mFileType = 1;
      ((TransferRequest)localObject1).mUniseq = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((TransferRequest)localObject1).mIsUp = true;
      ((TransferRequest)localObject1).mBusiType = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a;
      ((TransferRequest)localObject1).mLocalPath = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
      localObject2 = new TransferRequest.PicUpExtraInfo();
      if (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l != 1) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      ((TransferRequest.PicUpExtraInfo)localObject2).mIsRaw = bool;
      ((TransferRequest)localObject1).mExtraObj = localObject2;
      ((TransferRequest)localObject1).mUpCallBack = this.this$0;
      ((TransferRequest)localObject1).mIsFastForward = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j != 0) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k != 0) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c != 0L)) {
        break label467;
      }
      this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
    label467:
    ((TransferRequest)localObject1).mMd5 = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f;
    Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((TransferRequest)localObject1).mFastForwardWidth = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j;
    ((TransferRequest)localObject1).mFastForwardHeight = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k;
    ((TransferRequest)localObject1).mFastForwardFileSize = this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c;
    localObject2 = (ITransFileController)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    ((ITransFileController)localObject2).removeProcessor(((TransferRequest)localObject1).mPeerUin + ((TransferRequest)localObject1).mUniseq);
    ((ITransFileController)localObject2).transferAsync((TransferRequest)localObject1);
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Long);
    Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "end, req.mFastForwardWidth = " + ((TransferRequest)localObject1).mFastForwardWidth + ",req.mFastForwardHeight = " + ((TransferRequest)localObject1).mFastForwardHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ForwardPicOperator.1
 * JD-Core Version:    0.7.0.1
 */