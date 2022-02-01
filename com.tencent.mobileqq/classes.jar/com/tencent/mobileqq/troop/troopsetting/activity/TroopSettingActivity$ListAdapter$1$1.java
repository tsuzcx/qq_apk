package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;

class TroopSettingActivity$ListAdapter$1$1
  implements Runnable
{
  TroopSettingActivity$ListAdapter$1$1(TroopSettingActivity.ListAdapter.1 param1, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter$1.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter.a.c) {
      return;
    }
    if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter$1.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ViewHolder.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter$1.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SpannableString localSpannableString = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.jdField_a_of_type_JavaLangString, 12);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter$1.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(TroopSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter$1.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter.a), this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter$1.jdField_a_of_type_AndroidWidgetTextView, localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.ListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */