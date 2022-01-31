package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.text.TextUtils;
import auuh;
import auui;
import auuk;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import wim;

class ShareHelper$1$3$1
  implements Runnable
{
  ShareHelper$1$3$1(ShareHelper.1.3 param3, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Auui.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Auui.a.jdField_a_of_type_Auuk.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      wim.a(1, 2131696768);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Long == 2L)
    {
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Auui.a.jdField_a_of_type_AndroidGraphicsBitmap, 0);
      return;
    }
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Auui.a.jdField_a_of_type_AndroidGraphicsBitmap, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3.1
 * JD-Core Version:    0.7.0.1
 */