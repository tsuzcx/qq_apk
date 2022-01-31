package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.text.TextUtils;
import auuj;
import auuk;
import auum;
import bbcz;
import bgyp;
import bgyw;
import com.tencent.mobileqq.app.QQAppInterface;
import wij;

class ShareHelper$1$2$1
  implements Runnable
{
  ShareHelper$1$2$1(ShareHelper.1.2 param2, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_Auum.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      wij.a(1, 2131696769);
      return;
    }
    bgyw localbgyw = bgyw.a();
    localbgyw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localbgyw.b = bbcz.h(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    bgyp.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity, localbgyw, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.getString(2131692226), "快来看看我的QQ个性标签吧", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */