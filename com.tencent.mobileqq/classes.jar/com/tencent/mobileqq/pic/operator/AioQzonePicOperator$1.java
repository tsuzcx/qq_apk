package com.tencent.mobileqq.pic.operator;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;

class AioQzonePicOperator$1
  implements Runnable
{
  AioQzonePicOperator$1(AioQzonePicOperator paramAioQzonePicOperator, PicUploadInfo paramPicUploadInfo, PicReq paramPicReq) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    Object localObject1 = new CompressInfo(((PicUploadInfo)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    CompressOperator.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((PicUploadInfo)???).jdField_h_of_type_JavaLangString = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((PicUploadInfo)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((PicUploadInfo)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    localObject1 = this.this$0.a((PicUploadInfo)???);
    if (localObject1 == null)
    {
      Logger.b(this.this$0.b, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.a;
        ??? = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((PicUploadInfo)???).jdField_h_of_type_Boolean) {
        ((MessageForPic)localObject1).cachePicToDisk();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.notifyAll();
        Logger.a(this.this$0.b, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int == 3)
        {
          Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          Logger.a(this.this$0.b, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
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
    ((TransferRequest)???).mBusiType = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
    ((TransferRequest)???).mLocalPath = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
    ((TransferRequest)???).mMd5 = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString;
    ??? = new TransferRequest.PicUpExtraInfo();
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((TransferRequest.PicUpExtraInfo)???).mIsRaw = bool;
      ((TransferRequest)???).mExtraObj = ???;
      ((TransferRequest)???).mUpCallBack = this.this$0;
      ((TransferRequest)???).mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((TransferRequest)???).mIsPresend = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Boolean;
      ((TransferRequest)???).myPresendInvalid = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.b == 1045)
      {
        ((TransferRequest)???).isQzonePic = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_h_of_type_Boolean;
        ((TransferRequest)???).photoSendParams = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Boolean) {
        break label1053;
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d) {
          break;
        }
        Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        Logger.a(this.this$0.b, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    ((ITransFileController)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)???);
    Logger.a(this.this$0.b, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b) && (!this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Boolean))
      {
        Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label1053:
      ((ITransFileController)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */