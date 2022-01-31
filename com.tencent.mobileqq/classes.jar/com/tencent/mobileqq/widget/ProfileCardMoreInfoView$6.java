package com.tencent.mobileqq.widget;

import ajya;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import wzt;

class ProfileCardMoreInfoView$6
  implements Runnable
{
  ProfileCardMoreInfoView$6(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    if (localObject != null) {}
    for (localObject = ajya.a(2131708459) + wzt.a(((MessageRecord)localObject).time, true, false, true).toString();; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.jdField_a_of_type_Auuy.b = ((String)localObject);
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