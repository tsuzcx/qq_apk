package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import atoq;
import ator;
import atpg;
import atpv;
import atqd;
import atqs;
import axvo;
import axvt;
import axvx;
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
  public AioQzonePicOperator$1(atoq paramatoq, atqd paramatqd, atpv paramatpv) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_Atqd;
    Object localObject1 = new CompressInfo(((atqd)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    atqs.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((atqd)???).h = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((atqd)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((atqd)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    if ((((atqd)???).jdField_g_of_type_Boolean) && (((atqd)???).jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject1 = (MessageForPic)((atqd)???).jdField_b_of_type_JavaLangObject; localObject1 == null; localObject1 = this.this$0.a((atqd)???))
    {
      atpg.b(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_Atpv.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Atpv.a;
        ??? = this.jdField_a_of_type_Atpv.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((atqd)???).jdField_i_of_type_Boolean) {
        ator.b((MessageForPic)localObject1);
      }
    }
    if (this.jdField_a_of_type_Atqd.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_Atqd)
      {
        this.jdField_a_of_type_Atqd.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_Atqd.notifyAll();
        atpg.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_Atqd.jdField_c_of_type_Int == 3)
        {
          atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          atpg.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localObject2;
    long l = System.currentTimeMillis();
    ??? = new axvt();
    ((axvt)???).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((axvt)???).c = localObject2.frienduin;
    ((axvt)???).d = localObject2.senderuin;
    ((axvt)???).jdField_a_of_type_Int = localObject2.istroop;
    ((axvt)???).jdField_b_of_type_Int = 1;
    ((axvt)???).jdField_a_of_type_Long = localObject2.uniseq;
    ((axvt)???).jdField_a_of_type_Boolean = true;
    ((axvt)???).jdField_e_of_type_Int = this.jdField_a_of_type_Atqd.jdField_a_of_type_Int;
    ((axvt)???).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString;
    ((axvt)???).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Atqd.jdField_f_of_type_JavaLangString;
    ??? = new axvx();
    if (this.jdField_a_of_type_Atqd.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((axvx)???).jdField_a_of_type_Boolean = bool;
      ((axvt)???).jdField_a_of_type_JavaLangObject = ???;
      ((axvt)???).jdField_a_of_type_Atqq = this.this$0;
      ((axvt)???).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((axvt)???).jdField_i_of_type_Boolean = this.jdField_a_of_type_Atqd.jdField_c_of_type_Boolean;
      ((axvt)???).j = this.jdField_a_of_type_Atqd.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_Atpv.jdField_b_of_type_Int == 1045)
      {
        ((axvt)???).q = this.jdField_a_of_type_Atqd.jdField_i_of_type_Boolean;
        ((axvt)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = this.jdField_a_of_type_Atqd.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_Atqd.jdField_c_of_type_Boolean) {
        break label1074;
      }
      synchronized (this.jdField_a_of_type_Atqd)
      {
        if (!this.jdField_a_of_type_Atqd.d) {
          break;
        }
        atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        atpg.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((axvt)???);
    atpg.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_Atqd.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Atqd.jdField_c_of_type_Boolean))
      {
        atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      atpg.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label1074:
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((axvt)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */