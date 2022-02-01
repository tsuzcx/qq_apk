package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopAdminList$2
  extends FriendListObserver
{
  TroopAdminList$2(TroopAdminList paramTroopAdminList) {}
  
  protected void onUpdateFriendInfoFinished(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAdminList", 2, "onUpdateFriendInfoFinished ");
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.2
 * JD-Core Version:    0.7.0.1
 */