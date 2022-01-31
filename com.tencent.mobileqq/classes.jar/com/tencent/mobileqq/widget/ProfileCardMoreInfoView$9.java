package com.tencent.mobileqq.widget;

import alpo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import yom;

class ProfileCardMoreInfoView$9
  implements Runnable
{
  ProfileCardMoreInfoView$9(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    if (localObject != null) {}
    for (localObject = alpo.a(2131708831) + yom.a(((MessageRecord)localObject).time, true, false, true).toString();; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.jdField_a_of_type_Awmk.b = ((String)localObject);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new ProfileCardMoreInfoView.9.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.9
 * JD-Core Version:    0.7.0.1
 */