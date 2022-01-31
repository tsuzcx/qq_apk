package com.tencent.mobileqq.widget;

import android.widget.TextView;
import bdkf;
import java.lang.ref.WeakReference;

class ProfileCardMoreInfoView$13$1
  implements Runnable
{
  ProfileCardMoreInfoView$13$1(ProfileCardMoreInfoView.13 param13, boolean paramBoolean) {}
  
  public void run()
  {
    TextView localTextView;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$13.a != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$13.a.get() != null))
    {
      localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView$13.a.get();
      if (this.jdField_a_of_type_Boolean)
      {
        localTextView.setCompoundDrawablePadding(bdkf.b(3.0F));
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841879, 0);
      }
    }
    else
    {
      return;
    }
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.13.1
 * JD-Core Version:    0.7.0.1
 */