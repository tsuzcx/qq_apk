package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.text.TextUtils;
import atwi;
import atwj;
import atwl;
import babh;
import bfpr;
import bfpy;
import com.tencent.mobileqq.app.QQAppInterface;
import vvp;

class ShareHelper$1$2$1
  implements Runnable
{
  ShareHelper$1$2$1(ShareHelper.1.2 param2, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_Atwl.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      vvp.a(1, 2131631056);
      return;
    }
    bfpy localbfpy = bfpy.a();
    localbfpy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localbfpy.b = babh.h(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    bfpr.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity, localbfpy, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.getString(2131626640), "快来看看我的QQ个性标签吧", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */