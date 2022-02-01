package com.tencent.mobileqq.troop.troopcard;

import android.os.Handler;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.util.Utils;

class TroopInfoActivity$19
  extends AvatarObserver
{
  TroopInfoActivity$19(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin))) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.19
 * JD-Core Version:    0.7.0.1
 */