package com.tencent.mobileqq.util;

import android.content.Intent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CommonModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.profilecommon.processor.AvatarHistoryNumProcessor;
import com.tencent.mobileqq.profilecommon.utils.ProfileCommonUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

class ProfileCardUtil$1$1
  implements UpCallBack
{
  ProfileCardUtil$1$1(ProfileCardUtil.1 param1, boolean paramBoolean, String paramString) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    int j = 0;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (paramSendResult != null) {
        break label70;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
      if (paramSendResult != null) {
        break label76;
      }
    }
    label70:
    label76:
    for (int i = -99;; i = paramSendResult.a)
    {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      if (paramSendResult != null) {
        break label84;
      }
      return;
      bool = false;
      break;
    }
    label84:
    if (paramSendResult.a == 0)
    {
      bool = true;
      label94:
      localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localObject == null) {
        break label231;
      }
      ((CardHandler)localObject).a(bool, this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramSendResult.b);
      if (bool) {
        break label238;
      }
      ProfileCardUtil.a("TransferRequest.onSend", paramSendResult.b, paramSendResult.toString());
      if (!"FROM_MINI_APP".equals(this.jdField_a_of_type_JavaLangString)) {
        break label361;
      }
      if (!bool) {
        break label363;
      }
      i = j;
      if (!bool) {
        break label370;
      }
    }
    label138:
    label156:
    label175:
    label231:
    label238:
    label370:
    for (paramSendResult = "ok";; paramSendResult = "upload failed")
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_code", i);
      this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_desc", paramSendResult);
      CommonModule.a().a(this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_AndroidContentIntent);
      return;
      bool = false;
      break label94;
      FaceUtil.a(null);
      break label138;
      if (((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.jdField_a_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new ProfileCardUtil.1.1.1(this));
      }
      if (SharedPreUtils.ag(this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 2) {
        break label156;
      }
      paramSendResult = (AvatarHistoryNumProcessor)ProfileCommonUtils.a(AvatarHistoryNumProcessor.class, this.jdField_a_of_type_ComTencentMobileqqUtilProfileCardUtil$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramSendResult == null) {
        break label156;
      }
      paramSendResult.a();
      break label156;
      break;
      i = -10002;
      break label175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1.1
 * JD-Core Version:    0.7.0.1
 */