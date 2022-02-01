package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import ayws;
import aywt;
import ayxi;
import ayxx;
import ayyg;
import ayyz;
import bdzi;
import bdzn;
import bdzr;
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
  public AioQzonePicOperator$1(ayws paramayws, ayyg paramayyg, ayxx paramayxx) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_Ayyg;
    Object localObject1 = new CompressInfo(((ayyg)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    ayyz.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((ayyg)???).h = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((ayyg)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((ayyg)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    if ((((ayyg)???).jdField_g_of_type_Boolean) && (((ayyg)???).jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject1 = (MessageForPic)((ayyg)???).jdField_b_of_type_JavaLangObject; localObject1 == null; localObject1 = this.this$0.a((ayyg)???))
    {
      ayxi.b(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_Ayxx.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Ayxx.a;
        ??? = this.jdField_a_of_type_Ayxx.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((ayyg)???).jdField_i_of_type_Boolean) {
        aywt.b((MessageForPic)localObject1);
      }
    }
    if (this.jdField_a_of_type_Ayyg.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_Ayyg)
      {
        this.jdField_a_of_type_Ayyg.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_Ayyg.notifyAll();
        ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_Ayyg.jdField_c_of_type_Int == 3)
        {
          ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localObject2;
    long l = System.currentTimeMillis();
    ??? = new bdzn();
    ((bdzn)???).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((bdzn)???).c = localObject2.frienduin;
    ((bdzn)???).d = localObject2.senderuin;
    ((bdzn)???).jdField_a_of_type_Int = localObject2.istroop;
    ((bdzn)???).jdField_b_of_type_Int = 1;
    ((bdzn)???).jdField_a_of_type_Long = localObject2.uniseq;
    ((bdzn)???).jdField_a_of_type_Boolean = true;
    ((bdzn)???).jdField_e_of_type_Int = this.jdField_a_of_type_Ayyg.jdField_a_of_type_Int;
    ((bdzn)???).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString;
    ((bdzn)???).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Ayyg.jdField_f_of_type_JavaLangString;
    ??? = new bdzr();
    if (this.jdField_a_of_type_Ayyg.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((bdzr)???).jdField_a_of_type_Boolean = bool;
      ((bdzn)???).jdField_a_of_type_JavaLangObject = ???;
      ((bdzn)???).jdField_a_of_type_Ayyt = this.this$0;
      ((bdzn)???).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((bdzn)???).jdField_i_of_type_Boolean = this.jdField_a_of_type_Ayyg.jdField_c_of_type_Boolean;
      ((bdzn)???).j = this.jdField_a_of_type_Ayyg.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_Ayxx.jdField_b_of_type_Int == 1045)
      {
        ((bdzn)???).p = this.jdField_a_of_type_Ayyg.jdField_i_of_type_Boolean;
        ((bdzn)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = this.jdField_a_of_type_Ayyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_Ayyg.jdField_c_of_type_Boolean) {
        break label1074;
      }
      synchronized (this.jdField_a_of_type_Ayyg)
      {
        if (!this.jdField_a_of_type_Ayyg.d) {
          break;
        }
        ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((bdzn)???);
    ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_Ayyg.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Ayyg.jdField_c_of_type_Boolean))
      {
        ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      ayxi.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label1074:
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((bdzn)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */