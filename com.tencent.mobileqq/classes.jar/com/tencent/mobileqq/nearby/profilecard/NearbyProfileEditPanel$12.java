package com.tencent.mobileqq.nearby.profilecard;

import android.widget.TextView;
import avnl;
import com.tencent.mobileqq.widget.BounceScrollView;

public class NearbyProfileEditPanel$12
  implements Runnable
{
  public NearbyProfileEditPanel$12(avnl paramavnl) {}
  
  public void run()
  {
    int i = this.this$0.h.getTop();
    int j = (int)(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a * 20.0F);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollTo(0, i - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.12
 * JD-Core Version:    0.7.0.1
 */