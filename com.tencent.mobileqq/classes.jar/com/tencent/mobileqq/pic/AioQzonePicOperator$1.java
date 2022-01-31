package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import aumo;
import aump;
import aune;
import aunt;
import auob;
import auoq;
import ayvv;
import aywa;
import aywe;
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
  public AioQzonePicOperator$1(aumo paramaumo, auob paramauob, aunt paramaunt) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_Auob;
    Object localObject1 = new CompressInfo(((auob)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    auoq.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((auob)???).h = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((auob)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((auob)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    if ((((auob)???).jdField_g_of_type_Boolean) && (((auob)???).jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject1 = (MessageForPic)((auob)???).jdField_b_of_type_JavaLangObject; localObject1 == null; localObject1 = this.this$0.a((auob)???))
    {
      aune.b(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_Aunt.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Aunt.a;
        ??? = this.jdField_a_of_type_Aunt.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((auob)???).jdField_i_of_type_Boolean) {
        aump.b((MessageForPic)localObject1);
      }
    }
    if (this.jdField_a_of_type_Auob.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_Auob)
      {
        this.jdField_a_of_type_Auob.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_Auob.notifyAll();
        aune.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_Auob.jdField_c_of_type_Int == 3)
        {
          aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          aune.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localObject2;
    long l = System.currentTimeMillis();
    ??? = new aywa();
    ((aywa)???).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((aywa)???).c = localObject2.frienduin;
    ((aywa)???).d = localObject2.senderuin;
    ((aywa)???).jdField_a_of_type_Int = localObject2.istroop;
    ((aywa)???).jdField_b_of_type_Int = 1;
    ((aywa)???).jdField_a_of_type_Long = localObject2.uniseq;
    ((aywa)???).jdField_a_of_type_Boolean = true;
    ((aywa)???).jdField_e_of_type_Int = this.jdField_a_of_type_Auob.jdField_a_of_type_Int;
    ((aywa)???).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString;
    ((aywa)???).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Auob.jdField_f_of_type_JavaLangString;
    ??? = new aywe();
    if (this.jdField_a_of_type_Auob.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((aywe)???).jdField_a_of_type_Boolean = bool;
      ((aywa)???).jdField_a_of_type_JavaLangObject = ???;
      ((aywa)???).jdField_a_of_type_Auoo = this.this$0;
      ((aywa)???).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((aywa)???).jdField_i_of_type_Boolean = this.jdField_a_of_type_Auob.jdField_c_of_type_Boolean;
      ((aywa)???).j = this.jdField_a_of_type_Auob.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_Aunt.jdField_b_of_type_Int == 1045)
      {
        ((aywa)???).q = this.jdField_a_of_type_Auob.jdField_i_of_type_Boolean;
        ((aywa)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = this.jdField_a_of_type_Auob.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_Auob.jdField_c_of_type_Boolean) {
        break label1074;
      }
      synchronized (this.jdField_a_of_type_Auob)
      {
        if (!this.jdField_a_of_type_Auob.d) {
          break;
        }
        aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        aune.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((aywa)???);
    aune.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_Auob.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Auob.jdField_c_of_type_Boolean))
      {
        aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      aune.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label1074:
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((aywa)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */