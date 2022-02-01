package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.widget.QMultiImageTextView;

class TroopSettingActivity$50$1
  implements Runnable
{
  TroopSettingActivity$50$1(TroopSettingActivity.50 param50) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      QFormSimpleItem localQFormSimpleItem = (QFormSimpleItem)this.a.this$0.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localQFormSimpleItem != null)
      {
        if (!TextUtils.equals(localQFormSimpleItem.a().getText(), this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick)) {
          if (TextUtils.isEmpty(this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick))
          {
            localQFormSimpleItem.setRightText(this.a.this$0.getString(2131697580));
          }
          else
          {
            SpannableString localSpannableString = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick, 16);
            localQFormSimpleItem.setRightText(localSpannableString);
            ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(TroopSettingActivity.a(this.a.this$0), localQFormSimpleItem.a(), localSpannableString);
          }
        }
        if (localQFormSimpleItem.a() != null) {
          localQFormSimpleItem.a().setCompoundDrawablePadding(ViewUtils.b(9.0F));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.50.1
 * JD-Core Version:    0.7.0.1
 */