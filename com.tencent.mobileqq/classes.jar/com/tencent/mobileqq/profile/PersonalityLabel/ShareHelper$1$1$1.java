package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aryv;
import awqe;
import awqf;
import awqh;
import ybk;

class ShareHelper$1$1$1
  implements Runnable
{
  ShareHelper$1$1$1(ShareHelper.1.1 param1, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$1.a.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$1.a.a.jdField_a_of_type_Awqh.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ybk.a(1, 2131696946);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_thumb", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_extra", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt(aryv.e, 1);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    aryv.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$1$1.a.a.jdField_a_of_type_AndroidAppActivity, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1.1
 * JD-Core Version:    0.7.0.1
 */