package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import znl;

class PersonalityLabelShareActivity$2$1
  implements Runnable
{
  PersonalityLabelShareActivity$2$1(PersonalityLabelShareActivity.2 param2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$2.this$0.sendBroadcast(localIntent);
      QQToast.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$2.this$0.getString(2131716559, new Object[] { this.jdField_a_of_type_JavaLangString }), 1).b(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$2.this$0.getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$2.this$0.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelShareActivity$2.this$0.b = true;
      return;
      znl.a(1, 2131716558);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity.2.1
 * JD-Core Version:    0.7.0.1
 */