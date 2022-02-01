package com.tencent.mobileqq.troop.troopcard;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.avatar.TroopAvatarManger;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class TroopInfoActivity$33
  implements Observer
{
  TroopInfoActivity$33(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (!(paramObject instanceof TroopUploadingThread.UploadState)) {
      return;
    }
    paramObservable = (TroopUploadingThread.UploadState)paramObject;
    if (paramObservable.a == 1)
    {
      boolean bool;
      if (paramObservable.d == 1) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("update isAvatar=%b", new Object[] { Boolean.valueOf(bool) }));
      }
      if (bool)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead = true;
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop = false;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isUseClassAvatar) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isUseClassAvatar = false;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead = true;
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop;
          if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isUseClassAvatar()) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.setUseClassAvatar(false);
          }
          this.a.d();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "pullAvatarList");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
      if (this.a.isResume()) {
        this.a.runOnUiThread(new TroopInfoActivity.33.1(this, paramObservable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.33
 * JD-Core Version:    0.7.0.1
 */