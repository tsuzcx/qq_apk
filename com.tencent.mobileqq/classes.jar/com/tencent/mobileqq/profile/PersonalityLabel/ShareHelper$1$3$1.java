package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.text.TextUtils;
import awlv;
import awlw;
import awly;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import xxb;

class ShareHelper$1$3$1
  implements Runnable
{
  ShareHelper$1$3$1(ShareHelper.1.3 param3, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Awlw.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Awlw.a.jdField_a_of_type_Awly.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      xxb.a(1, 2131696944);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Long == 2L)
    {
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Awlw.a.jdField_a_of_type_AndroidGraphicsBitmap, 0);
      return;
    }
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$3.jdField_a_of_type_Awlw.a.jdField_a_of_type_AndroidGraphicsBitmap, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3.1
 * JD-Core Version:    0.7.0.1
 */