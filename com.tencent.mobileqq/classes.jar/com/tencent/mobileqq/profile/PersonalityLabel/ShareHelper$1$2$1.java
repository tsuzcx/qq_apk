package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.text.TextUtils;
import aylr;
import ayls;
import aylu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import yyi;

class ShareHelper$1$2$1
  implements Runnable
{
  ShareHelper$1$2$1(ShareHelper.1.2 param2, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_Aylu.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      yyi.a(1, 2131695956);
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localUserInfo.nickname = ContactUtils.getAccountNickName(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QZoneHelper.forwardToPublishMood(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity, localUserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.getString(2131691958), "快来看看我的QQ个性标签吧", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */