package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.text.TextUtils;
import azxc;
import azxd;
import azxf;
import bhlg;
import bmtd;
import bmtk;
import com.tencent.mobileqq.app.QQAppInterface;
import zyx;

class ShareHelper$1$2$1
  implements Runnable
{
  ShareHelper$1$2$1(ShareHelper.1.2 param2, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_Azxf.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      zyx.a(1, 2131695816);
      return;
    }
    bmtk localbmtk = bmtk.a();
    localbmtk.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localbmtk.b = bhlg.h(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    bmtd.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity, localbmtk, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$2.a.a.jdField_a_of_type_AndroidAppActivity.getString(2131691912), "快来看看我的QQ个性标签吧", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */