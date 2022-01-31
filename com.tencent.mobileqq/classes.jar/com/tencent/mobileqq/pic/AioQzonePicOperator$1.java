package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import awig;
import awih;
import awiw;
import awjl;
import awju;
import awkj;
import bayf;
import bayk;
import bayo;
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
  public AioQzonePicOperator$1(awig paramawig, awju paramawju, awjl paramawjl) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    ??? = this.jdField_a_of_type_Awju;
    Object localObject1 = new CompressInfo(((awju)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath, 0);
    awkj.b((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).jdField_e_of_type_JavaLangString != null)
    {
      ((awju)???).h = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      ((awju)???).jdField_e_of_type_Int = ((CompressInfo)localObject1).d;
      ((awju)???).jdField_f_of_type_Int = ((CompressInfo)localObject1).jdField_e_of_type_Int;
    }
    if ((((awju)???).jdField_g_of_type_Boolean) && (((awju)???).jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject1 = (MessageForPic)((awju)???).jdField_b_of_type_JavaLangObject; localObject1 == null; localObject1 = this.this$0.a((awju)???))
    {
      awiw.b(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.jdField_a_of_type_Awjl.a != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.jdField_a_of_type_Awjl.a;
        ??? = this.jdField_a_of_type_Awjl.a;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().a((MessageRecord)localObject1);
        }
      }
      if (!((awju)???).jdField_i_of_type_Boolean) {
        awih.b((MessageForPic)localObject1);
      }
    }
    if (this.jdField_a_of_type_Awju.jdField_c_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_Awju)
      {
        this.jdField_a_of_type_Awju.jdField_a_of_type_JavaLangObject = localObject1;
        this.jdField_a_of_type_Awju.notifyAll();
        awiw.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.jdField_a_of_type_Awju.jdField_c_of_type_Int == 3)
        {
          awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          awiw.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + this.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localObject2;
    long l = System.currentTimeMillis();
    ??? = new bayk();
    ((bayk)???).jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((bayk)???).c = localObject2.frienduin;
    ((bayk)???).d = localObject2.senderuin;
    ((bayk)???).jdField_a_of_type_Int = localObject2.istroop;
    ((bayk)???).jdField_b_of_type_Int = 1;
    ((bayk)???).jdField_a_of_type_Long = localObject2.uniseq;
    ((bayk)???).jdField_a_of_type_Boolean = true;
    ((bayk)???).jdField_e_of_type_Int = this.jdField_a_of_type_Awju.jdField_a_of_type_Int;
    ((bayk)???).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString;
    ((bayk)???).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Awju.jdField_f_of_type_JavaLangString;
    ??? = new bayo();
    if (this.jdField_a_of_type_Awju.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((bayo)???).jdField_a_of_type_Boolean = bool;
      ((bayk)???).jdField_a_of_type_JavaLangObject = ???;
      ((bayk)???).jdField_a_of_type_Awkh = this.this$0;
      ((bayk)???).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((bayk)???).jdField_i_of_type_Boolean = this.jdField_a_of_type_Awju.jdField_c_of_type_Boolean;
      ((bayk)???).j = this.jdField_a_of_type_Awju.jdField_e_of_type_Boolean;
      if (this.jdField_a_of_type_Awjl.jdField_b_of_type_Int == 1045)
      {
        ((bayk)???).q = this.jdField_a_of_type_Awju.jdField_i_of_type_Boolean;
        ((bayk)???).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = this.jdField_a_of_type_Awju.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams;
      }
      if (!this.jdField_a_of_type_Awju.jdField_c_of_type_Boolean) {
        break label1074;
      }
      synchronized (this.jdField_a_of_type_Awju)
      {
        if (!this.jdField_a_of_type_Awju.d) {
          break;
        }
        awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        awiw.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((bayk)???);
    awiw.a(this.this$0.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + this.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString + ",uuid:" + this.this$0.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_Awju.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Awju.jdField_c_of_type_Boolean))
      {
        awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        this.this$0.a(localMessageRecord);
      }
      awiw.a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label1074:
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((bayk)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */