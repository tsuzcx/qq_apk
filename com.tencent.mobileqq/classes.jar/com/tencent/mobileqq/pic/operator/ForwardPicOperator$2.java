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

class ForwardPicOperator$2
  implements Runnable
{
  ForwardPicOperator$2(ForwardPicOperator paramForwardPicOperator, PicReq paramPicReq) {}
  
  public void run()
  {
    PicFowardInfo localPicFowardInfo = this.a.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo;
    Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      localPicFowardInfo.a("doForward", "rec==null");
      this.this$0.a(4, localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
    ForwardPicOperator.a(this.this$0, this.a, ((MessageForPic)localObject1).uniseq);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      ((MessageForPic)localObject1).picExtraData = this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    CompressOperator.b((CompressInfo)localObject2);
    TransferRequest.PicUpExtraInfo localPicUpExtraInfo;
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
      localObject2 = new TransferRequest();
      ((TransferRequest)localObject2).mSelfUin = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((TransferRequest)localObject2).mPeerUin = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((TransferRequest)localObject2).mSecondId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((TransferRequest)localObject2).mUinType = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((TransferRequest)localObject2).mFileType = 1;
      ((TransferRequest)localObject2).mUniseq = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((TransferRequest)localObject2).mIsUp = true;
      ((TransferRequest)localObject2).mBusiType = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a;
      ((TransferRequest)localObject2).mLocalPath = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
      localPicUpExtraInfo = new TransferRequest.PicUpExtraInfo();
      if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l != 1) {
        break label495;
      }
    }
    label495:
    for (boolean bool = true;; bool = false)
    {
      localPicUpExtraInfo.mIsRaw = bool;
      ((TransferRequest)localObject2).mRec = ((MessageRecord)localObject1);
      ((TransferRequest)localObject2).mExtraObj = localPicUpExtraInfo;
      ((TransferRequest)localObject2).mUpCallBack = this.this$0;
      localObject1 = (ITransFileController)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
      ((ITransFileController)localObject1).removeProcessor(((TransferRequest)localObject2).mPeerUin + ((TransferRequest)localObject2).mUniseq);
      ((ITransFileController)localObject1).transferAsync((TransferRequest)localObject2);
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Long);
      Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "end");
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ForwardPicOperator.2
 * JD-Core Version:    0.7.0.1
 */