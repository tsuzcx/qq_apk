package com.tencent.mobileqq.nearby.profilecard;

import android.widget.TextView;
import avkg;
import com.tencent.mobileqq.widget.BounceScrollView;

public class NearbyProfileEditTribePanel$8
  implements Runnable
{
  public NearbyProfileEditTribePanel$8(avkg paramavkg) {}
  
  public void run()
  {
    int i = this.this$0.i.getTop();
    int j = (int)(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a * 20.0F);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollTo(0, i - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.8
 * JD-Core Version:    0.7.0.1
 */