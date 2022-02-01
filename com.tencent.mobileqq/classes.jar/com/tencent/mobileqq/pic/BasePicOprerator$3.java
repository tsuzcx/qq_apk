package com.tencent.mobileqq.pic;

import ayco;
import ayde;
import aydn;
import ayds;
import ayeb;
import ayeu;
import bcdo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;

public class BasePicOprerator$3
  implements Runnable
{
  public BasePicOprerator$3(ayco paramayco, ayds paramayds) {}
  
  public void run()
  {
    aydn localaydn = this.a.jdField_a_of_type_Aydn;
    ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      localaydn.a("doForward", "rec==null");
      this.this$0.a(4, localaydn.jdField_a_of_type_Aydp);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = localaydn.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString;
    ayco.a(this.this$0, this.a, ((MessageForPic)localObject1).uniseq);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      ((MessageForPic)localObject1).picExtraData = this.a.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    ayeu.b((CompressInfo)localObject2);
    TransferRequest.PicUpExtraInfo localPicUpExtraInfo;
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (bcdo.a())
      {
        ((MessageForPic)localObject1).bigThumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
        ((MessageForPic)localObject1).thumbWidth = ((CompressInfo)localObject2).d;
        ((MessageForPic)localObject1).thumbHeight = ((CompressInfo)localObject2).jdField_e_of_type_Int;
      }
    }
    else
    {
      ((MessageForPic)localObject1).serial();
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForPic)localObject1).msgData);
      localObject2 = new TransferRequest();
      ((TransferRequest)localObject2).mSelfUin = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((TransferRequest)localObject2).mPeerUin = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((TransferRequest)localObject2).mSecondId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((TransferRequest)localObject2).mUinType = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((TransferRequest)localObject2).mFileType = 1;
      ((TransferRequest)localObject2).mUniseq = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((TransferRequest)localObject2).mIsUp = true;
      ((TransferRequest)localObject2).mBusiType = localaydn.jdField_a_of_type_Ayeb.a;
      ((TransferRequest)localObject2).mLocalPath = localaydn.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString;
      localPicUpExtraInfo = new TransferRequest.PicUpExtraInfo();
      if (localaydn.jdField_a_of_type_Ayeb.l != 1) {
        break label486;
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      localPicUpExtraInfo.mIsRaw = bool;
      ((TransferRequest)localObject2).mRec = ((MessageRecord)localObject1);
      ((TransferRequest)localObject2).mExtraObj = localPicUpExtraInfo;
      ((TransferRequest)localObject2).mUpCallBack = this.this$0;
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
      ((TransFileController)localObject1).removeProcessor(((TransferRequest)localObject2).mPeerUin + ((TransferRequest)localObject2).mUniseq);
      ((TransFileController)localObject1).transferAsync((TransferRequest)localObject2);
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localaydn.jdField_a_of_type_Ayeb.jdField_g_of_type_Long);
      ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForward", "end");
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.3
 * JD-Core Version:    0.7.0.1
 */