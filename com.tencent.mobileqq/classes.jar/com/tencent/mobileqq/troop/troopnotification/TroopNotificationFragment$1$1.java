package com.tencent.mobileqq.troop.troopnotification;

import android.widget.ImageView;
import android.widget.TextView;

class TroopNotificationFragment$1$1
  implements Runnable
{
  TroopNotificationFragment$1$1(TroopNotificationFragment.1 param1, int paramInt) {}
  
  public void run()
  {
    if (TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment$1.this$0) != null)
    {
      if (this.jdField_a_of_type_Int > 0)
      {
        TextView localTextView = TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment$1.this$0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localTextView.setText(localStringBuilder.toString());
        TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment$1.this$0).setVisibility(0);
        TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment$1.this$0).setVisibility(0);
        return;
      }
      TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment$1.this$0).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.1.1
 * JD-Core Version:    0.7.0.1
 */