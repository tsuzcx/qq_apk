package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import awdx;
import awdy;
import awen;
import awfc;
import awfl;
import awga;
import batw;
import baub;
import bauf;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.qphone.base.util.QLog;

public class AioQzonePicOperator$1
  implements Runnable
{
  public AioQzonePicOperator$1(awdx paramawdx, awfl paramawfl, awfc paramawfc) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_Awfl;
    Object localObject1 = new CompressInfo(((awfl)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    awga.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((awfl)???).h = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((awfl)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((awfl)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    if ((((awfl)???).jdField_g_of_type_Boolean) && (((awfl)???).jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject1 = (MessageForPic)((awfl)???).jdField_b_of_type_JavaLangObject; localObject1 == null; localObject1 = this.this$0.a((awfl)???))
    {
      awen.b(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_Awfc.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Awfc.a;
        ??? = this.jdField_a_of_type_Awfc.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((awfl)???).jdField_i_of_type_Boolean) {
        awdy.b((MessageForPic)localObject1);
      }
    }
    if (this.jdField_a_of_type_Awfl.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_Awfl)
      {
        this.jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_Awfl.notifyAll();
        awen.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_Awfl.jdField_c_of_type_Int == 3)
        {
          awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          awen.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localObject2;
    long l = System.currentTimeMillis();
    ??? = new baub();
    ((baub)???).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((baub)???).c = localObject2.frienduin;
    ((baub)???).d = localObject2.senderuin;
    ((baub)???).jdField_a_of_type_Int = localObject2.istroop;
    ((baub)???).jdField_b_of_type_Int = 1;
    ((baub)???).jdField_a_of_type_Long = localObject2.uniseq;
    ((baub)???).jdField_a_of_type_Boolean = true;
    ((baub)???).jdField_e_of_type_Int = this.jdField_a_of_type_Awfl.jdField_a_of_type_Int;
    ((baub)???).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString;
    ((baub)???).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Awfl.jdField_f_of_type_JavaLangString;
    ??? = new bauf();
    if (this.jdField_a_of_type_Awfl.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((bauf)???).jdField_a_of_type_Boolean = bool;
      ((baub)???).jdField_a_of_type_JavaLangObject = ???;
      ((baub)???).jdField_a_of_type_Awfy = this.this$0;
      ((baub)???).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((baub)???).jdField_i_of_type_Boolean = this.jdField_a_of_type_Awfl.jdField_c_of_type_Boolean;
      ((baub)???).j = this.jdField_a_of_type_Awfl.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_Awfc.jdField_b_of_type_Int == 1045)
      {
        ((baub)???).q = this.jdField_a_of_type_Awfl.jdField_i_of_type_Boolean;
        ((baub)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = this.jdField_a_of_type_Awfl.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_Awfl.jdField_c_of_type_Boolean) {
        break label1074;
      }
      synchronized (this.jdField_a_of_type_Awfl)
      {
        if (!this.jdField_a_of_type_Awfl.d) {
          break;
        }
        awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        awen.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((baub)???);
    awen.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_Awfl.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Awfl.jdField_c_of_type_Boolean))
      {
        awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      awen.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label1074:
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((baub)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */