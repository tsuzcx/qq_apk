package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import aycn;
import ayco;
import ayde;
import ayds;
import ayeb;
import ayeu;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.qphone.base.util.QLog;

public class AioQzonePicOperator$1
  implements Runnable
{
  public AioQzonePicOperator$1(aycn paramaycn, ayeb paramayeb, ayds paramayds) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_Ayeb;
    Object localObject1 = new CompressInfo(((ayeb)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    ayeu.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((ayeb)???).h = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((ayeb)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((ayeb)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    if ((((ayeb)???).jdField_g_of_type_Boolean) && (((ayeb)???).jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject1 = (MessageForPic)((ayeb)???).jdField_b_of_type_JavaLangObject; localObject1 == null; localObject1 = this.this$0.a((ayeb)???))
    {
      ayde.b(this.this$0.b, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_Ayds.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Ayds.a;
        ??? = this.jdField_a_of_type_Ayds.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((ayeb)???).i) {
        ayco.b((MessageForPic)localObject1);
      }
    }
    if (this.jdField_a_of_type_Ayeb.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_Ayeb)
      {
        this.jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_Ayeb.notifyAll();
        ayde.a(this.this$0.b, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_Ayeb.jdField_c_of_type_Int == 3)
        {
          ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          ayde.a(this.this$0.b, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localObject2;
    long l = System.currentTimeMillis();
    ??? = new TransferRequest();
    ((TransferRequest)???).mSelfUin = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((TransferRequest)???).mPeerUin = localObject2.frienduin;
    ((TransferRequest)???).mSecondId = localObject2.senderuin;
    ((TransferRequest)???).mUinType = localObject2.istroop;
    ((TransferRequest)???).mFileType = 1;
    ((TransferRequest)???).mUniseq = localObject2.uniseq;
    ((TransferRequest)???).mIsUp = true;
    ((TransferRequest)???).mBusiType = this.jdField_a_of_type_Ayeb.jdField_a_of_type_Int;
    ((TransferRequest)???).mLocalPath = this.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString;
    ((TransferRequest)???).mMd5 = this.jdField_a_of_type_Ayeb.jdField_f_of_type_JavaLangString;
    ??? = new TransferRequest.PicUpExtraInfo();
    if (this.jdField_a_of_type_Ayeb.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((TransferRequest.PicUpExtraInfo)???).mIsRaw = bool;
      ((TransferRequest)???).mExtraObj = ???;
      ((TransferRequest)???).mUpCallBack = this.this$0;
      ((TransferRequest)???).mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((TransferRequest)???).mIsPresend = this.jdField_a_of_type_Ayeb.jdField_c_of_type_Boolean;
      ((TransferRequest)???).myPresendInvalid = this.jdField_a_of_type_Ayeb.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_Ayds.b == 1045)
      {
        ((TransferRequest)???).isQzonePic = this.jdField_a_of_type_Ayeb.i;
        ((TransferRequest)???).photoSendParams = this.jdField_a_of_type_Ayeb.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_Ayeb.jdField_c_of_type_Boolean) {
        break label1074;
      }
      synchronized (this.jdField_a_of_type_Ayeb)
      {
        if (!this.jdField_a_of_type_Ayeb.d) {
          break;
        }
        ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        ayde.a(this.this$0.b, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync((TransferRequest)???);
    ayde.a(this.this$0.b, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_Ayeb.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Ayeb.jdField_c_of_type_Boolean))
      {
        ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label1074:
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync((TransferRequest)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */