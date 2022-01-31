package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.text.TextUtils;
import awqe;
import awqf;
import awqh;
import bdgc;
import bjdt;
import bjea;
import com.tencent.mobileqq.app.QQAppInterface;
import ybk;

class ShareHelper$1$2$1
  implements Runnable
{
  ShareHelper$1$2$1(ShareHelper.1.2 param2, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_Awqh.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ybk.a(1, 2131696946);
      return;
    }
    bjea localbjea = bjea.a();
    localbjea.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localbjea.b = bdgc.h(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    bjdt.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity, localbjea, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.getString(2131692303), "快来看看我的QQ个性标签吧", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */