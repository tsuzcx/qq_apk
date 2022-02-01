package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import aziz;
import azja;
import azjq;
import azke;
import azkn;
import azlg;
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
  public AioQzonePicOperator$1(aziz paramaziz, azkn paramazkn, azke paramazke) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_Azkn;
    Object localObject1 = new CompressInfo(((azkn)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    azlg.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((azkn)???).h = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((azkn)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((azkn)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    if ((((azkn)???).jdField_g_of_type_Boolean) && (((azkn)???).jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject1 = (MessageForPic)((azkn)???).jdField_b_of_type_JavaLangObject; localObject1 == null; localObject1 = this.this$0.a((azkn)???))
    {
      azjq.b(this.this$0.b, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_Azke.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Azke.a;
        ??? = this.jdField_a_of_type_Azke.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((azkn)???).i) {
        azja.b((MessageForPic)localObject1);
      }
    }
    if (this.jdField_a_of_type_Azkn.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_Azkn)
      {
        this.jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_Azkn.notifyAll();
        azjq.a(this.this$0.b, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_Azkn.jdField_c_of_type_Int == 3)
        {
          azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          azjq.a(this.this$0.b, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
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
    ((TransferRequest)???).mBusiType = this.jdField_a_of_type_Azkn.jdField_a_of_type_Int;
    ((TransferRequest)???).mLocalPath = this.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString;
    ((TransferRequest)???).mMd5 = this.jdField_a_of_type_Azkn.jdField_f_of_type_JavaLangString;
    ??? = new TransferRequest.PicUpExtraInfo();
    if (this.jdField_a_of_type_Azkn.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((TransferRequest.PicUpExtraInfo)???).mIsRaw = bool;
      ((TransferRequest)???).mExtraObj = ???;
      ((TransferRequest)???).mUpCallBack = this.this$0;
      ((TransferRequest)???).mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((TransferRequest)???).mIsPresend = this.jdField_a_of_type_Azkn.jdField_c_of_type_Boolean;
      ((TransferRequest)???).myPresendInvalid = this.jdField_a_of_type_Azkn.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_Azke.b == 1045)
      {
        ((TransferRequest)???).isQzonePic = this.jdField_a_of_type_Azkn.i;
        ((TransferRequest)???).photoSendParams = this.jdField_a_of_type_Azkn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_Azkn.jdField_c_of_type_Boolean) {
        break label1074;
      }
      synchronized (this.jdField_a_of_type_Azkn)
      {
        if (!this.jdField_a_of_type_Azkn.d) {
          break;
        }
        azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        azjq.a(this.this$0.b, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync((TransferRequest)???);
    azjq.a(this.this$0.b, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_Azkn.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Azkn.jdField_c_of_type_Boolean))
      {
        azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
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