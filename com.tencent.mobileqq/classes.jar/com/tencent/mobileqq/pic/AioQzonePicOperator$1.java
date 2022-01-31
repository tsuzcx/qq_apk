package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import aumq;
import aumr;
import aung;
import aunv;
import auod;
import auos;
import ayvx;
import aywc;
import aywg;
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
  public AioQzonePicOperator$1(aumq paramaumq, auod paramauod, aunv paramaunv) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_Auod;
    Object localObject1 = new CompressInfo(((auod)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    auos.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((auod)???).h = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((auod)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((auod)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    if ((((auod)???).jdField_g_of_type_Boolean) && (((auod)???).jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject1 = (MessageForPic)((auod)???).jdField_b_of_type_JavaLangObject; localObject1 == null; localObject1 = this.this$0.a((auod)???))
    {
      aung.b(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_Aunv.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Aunv.a;
        ??? = this.jdField_a_of_type_Aunv.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((auod)???).jdField_i_of_type_Boolean) {
        aumr.b((MessageForPic)localObject1);
      }
    }
    if (this.jdField_a_of_type_Auod.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_Auod)
      {
        this.jdField_a_of_type_Auod.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_Auod.notifyAll();
        aung.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_Auod.jdField_c_of_type_Int == 3)
        {
          aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          aung.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localObject2;
    long l = System.currentTimeMillis();
    ??? = new aywc();
    ((aywc)???).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((aywc)???).c = localObject2.frienduin;
    ((aywc)???).d = localObject2.senderuin;
    ((aywc)???).jdField_a_of_type_Int = localObject2.istroop;
    ((aywc)???).jdField_b_of_type_Int = 1;
    ((aywc)???).jdField_a_of_type_Long = localObject2.uniseq;
    ((aywc)???).jdField_a_of_type_Boolean = true;
    ((aywc)???).jdField_e_of_type_Int = this.jdField_a_of_type_Auod.jdField_a_of_type_Int;
    ((aywc)???).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString;
    ((aywc)???).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Auod.jdField_f_of_type_JavaLangString;
    ??? = new aywg();
    if (this.jdField_a_of_type_Auod.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((aywg)???).jdField_a_of_type_Boolean = bool;
      ((aywc)???).jdField_a_of_type_JavaLangObject = ???;
      ((aywc)???).jdField_a_of_type_Auoq = this.this$0;
      ((aywc)???).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((aywc)???).jdField_i_of_type_Boolean = this.jdField_a_of_type_Auod.jdField_c_of_type_Boolean;
      ((aywc)???).j = this.jdField_a_of_type_Auod.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_Aunv.jdField_b_of_type_Int == 1045)
      {
        ((aywc)???).q = this.jdField_a_of_type_Auod.jdField_i_of_type_Boolean;
        ((aywc)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = this.jdField_a_of_type_Auod.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_Auod.jdField_c_of_type_Boolean) {
        break label1074;
      }
      synchronized (this.jdField_a_of_type_Auod)
      {
        if (!this.jdField_a_of_type_Auod.d) {
          break;
        }
        aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        aung.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((aywc)???);
    aung.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_Auod.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Auod.jdField_c_of_type_Boolean))
      {
        aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      aung.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label1074:
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((aywc)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */