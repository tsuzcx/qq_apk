package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import azpf;
import azpg;
import azpw;
import azqk;
import azqt;
import azrm;
import beyb;
import beyg;
import beyk;
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
  public AioQzonePicOperator$1(azpf paramazpf, azqt paramazqt, azqk paramazqk) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_Azqt;
    Object localObject1 = new CompressInfo(((azqt)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    azrm.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((azqt)???).h = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((azqt)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((azqt)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    if ((((azqt)???).jdField_g_of_type_Boolean) && (((azqt)???).jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject1 = (MessageForPic)((azqt)???).jdField_b_of_type_JavaLangObject; localObject1 == null; localObject1 = this.this$0.a((azqt)???))
    {
      azpw.b(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_Azqk.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Azqk.a;
        ??? = this.jdField_a_of_type_Azqk.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((azqt)???).i) {
        azpg.b((MessageForPic)localObject1);
      }
    }
    if (this.jdField_a_of_type_Azqt.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_Azqt)
      {
        this.jdField_a_of_type_Azqt.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_Azqt.notifyAll();
        azpw.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_Azqt.jdField_c_of_type_Int == 3)
        {
          azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          azpw.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localObject2;
    long l = System.currentTimeMillis();
    ??? = new beyg();
    ((beyg)???).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((beyg)???).c = localObject2.frienduin;
    ((beyg)???).d = localObject2.senderuin;
    ((beyg)???).jdField_a_of_type_Int = localObject2.istroop;
    ((beyg)???).jdField_b_of_type_Int = 1;
    ((beyg)???).jdField_a_of_type_Long = localObject2.uniseq;
    ((beyg)???).jdField_a_of_type_Boolean = true;
    ((beyg)???).jdField_e_of_type_Int = this.jdField_a_of_type_Azqt.jdField_a_of_type_Int;
    ((beyg)???).i = this.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString;
    ((beyg)???).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Azqt.jdField_f_of_type_JavaLangString;
    ??? = new beyk();
    if (this.jdField_a_of_type_Azqt.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((beyk)???).jdField_a_of_type_Boolean = bool;
      ((beyg)???).jdField_a_of_type_JavaLangObject = ???;
      ((beyg)???).jdField_a_of_type_Azrg = this.this$0;
      ((beyg)???).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((beyg)???).j = this.jdField_a_of_type_Azqt.jdField_c_of_type_Boolean;
      ((beyg)???).k = this.jdField_a_of_type_Azqt.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_Azqk.jdField_b_of_type_Int == 1045)
      {
        ((beyg)???).q = this.jdField_a_of_type_Azqt.i;
        ((beyg)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = this.jdField_a_of_type_Azqt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_Azqt.jdField_c_of_type_Boolean) {
        break label1074;
      }
      synchronized (this.jdField_a_of_type_Azqt)
      {
        if (!this.jdField_a_of_type_Azqt.d) {
          break;
        }
        azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        azpw.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((beyg)???);
    azpw.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_Azqt.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Azqt.jdField_c_of_type_Boolean))
      {
        azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      azpw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label1074:
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((beyg)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */