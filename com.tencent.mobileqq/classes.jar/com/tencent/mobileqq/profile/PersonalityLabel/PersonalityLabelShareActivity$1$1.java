package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Intent;
import android.net.Uri;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import vvp;

class PersonalityLabelShareActivity$1$1
  implements Runnable
{
  PersonalityLabelShareActivity$1$1(PersonalityLabelShareActivity.1 param1, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$1.this$0.sendBroadcast(localIntent);
      bbmy.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$1.this$0.getString(2131651444, new Object[] { this.jdField_a_of_type_JavaLangString }), 1).b(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$1.this$0.getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$1.this$0.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$1.this$0.b = true;
      return;
      vvp.a(1, 2131651443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity.1.1
 * JD-Core Version:    0.7.0.1
 */