package com.tencent.mobileqq.troop.troopnotification;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.ITroopNotificationLoadDBListener;

class TroopNotificationRecordMessageController$2
  implements ThreadExcutor.IThreadListener
{
  TroopNotificationRecordMessageController$2(TroopNotificationRecordMessageController paramTroopNotificationRecordMessageController, ITroopNotificationService.ITroopNotificationLoadDBListener paramITroopNotificationLoadDBListener) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    ITroopNotificationService.ITroopNotificationLoadDBListener localITroopNotificationLoadDBListener = this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopNotificationService$ITroopNotificationLoadDBListener;
    if (localITroopNotificationLoadDBListener != null) {
      localITroopNotificationLoadDBListener.a();
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationRecordMessageController.2
 * JD-Core Version:    0.7.0.1
 */