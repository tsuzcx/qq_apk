package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterObserver;

class TroopSettingActivity$38
  extends TroopLuckyCharacterObserver
{
  TroopSettingActivity$38(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)))
    {
      if (this.a.jdField_a_of_type_ArrayOfAndroidViewView == null) {
        return;
      }
      if (!paramBoolean) {
        return;
      }
      paramString1 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[49];
      if (paramString1 != null)
      {
        paramString1 = (TextView)paramString1.findViewById(2131376541);
        if ((paramString2 != null) && (paramString1 != null)) {
          paramString1.setText(paramString2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.38
 * JD-Core Version:    0.7.0.1
 */