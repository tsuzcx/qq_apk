package com.tencent.mobileqq.troop.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;

class TroopBarReplyActivity$12
  implements DialogInterface.OnClickListener
{
  TroopBarReplyActivity$12(TroopBarReplyActivity paramTroopBarReplyActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.f();
      return;
    case 2: 
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.12.1(this), 200L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.b(4);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.e();
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      TroopBarReplyActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.b, true);
      InputMethodUtil.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.12.2(this), 200L);
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.b(3);
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.12.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.12
 * JD-Core Version:    0.7.0.1
 */