package com.tencent.mobileqq.pic;

import azja;
import azjq;
import azjz;
import azke;
import azkn;
import azlg;
import bdkj;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;

public class BasePicOprerator$2
  implements Runnable
{
  public BasePicOprerator$2(azja paramazja, azjz paramazjz, azke paramazke) {}
  
  public void run()
  {
    azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "start");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_Azjz.a("doFastForward", "rec==null");
      this.this$0.a(4, this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkb);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((MessageForPic)localObject1).path = this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString;
    azja.a(this.this$0, this.jdField_a_of_type_Azke, ((MessageForPic)localObject1).uniseq);
    if (this.jdField_a_of_type_Azke.a != null) {
      ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Azke.a;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    azlg.b((CompressInfo)localObject2);
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (bdkj.a())
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
      localObject1 = new TransferRequest();
      ((TransferRequest)localObject1).mSelfUin = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((TransferRequest)localObject1).mPeerUin = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((TransferRequest)localObject1).mSecondId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((TransferRequest)localObject1).mUinType = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((TransferRequest)localObject1).mFileType = 1;
      ((TransferRequest)localObject1).mUniseq = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((TransferRequest)localObject1).mIsUp = true;
      ((TransferRequest)localObject1).mBusiType = this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.a;
      ((TransferRequest)localObject1).mLocalPath = this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString;
      localObject2 = new TransferRequest.PicUpExtraInfo();
      if (this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.l != 1) {
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
      if ((this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.f != null) && (this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.j != 0) && (this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.k != 0) && (this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.c != 0L)) {
        break label467;
      }
      this.jdField_a_of_type_Azjz.a("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkb);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
    label467:
    ((TransferRequest)localObject1).mMd5 = this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.f;
    azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((TransferRequest)localObject1).mFastForwardWidth = this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.j;
    ((TransferRequest)localObject1).mFastForwardHeight = this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.k;
    ((TransferRequest)localObject1).mFastForwardFileSize = this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.c;
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    ((TransFileController)localObject2).removeProcessor(((TransferRequest)localObject1).mPeerUin + ((TransferRequest)localObject1).mUniseq);
    ((TransFileController)localObject2).transferAsync((TransferRequest)localObject1);
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.jdField_g_of_type_Long);
    azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doFastForward", "end, req.mFastForwardWidth = " + ((TransferRequest)localObject1).mFastForwardWidth + ",req.mFastForwardHeight = " + ((TransferRequest)localObject1).mFastForwardHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.2
 * JD-Core Version:    0.7.0.1
 */