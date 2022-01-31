package com.tencent.mobileqq.widget;

import ajyc;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import wzw;

class ProfileCardMoreInfoView$6
  implements Runnable
{
  ProfileCardMoreInfoView$6(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    if (localObject != null) {}
    for (localObject = ajyc.a(2131708448) + wzw.a(((MessageRecord)localObject).time, true, false, true).toString();; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.jdField_a_of_type_Auuw.b = ((String)localObject);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new ProfileCardMoreInfoView.6.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.6
 * JD-Core Version:    0.7.0.1
 */