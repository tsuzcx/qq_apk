package com.tencent.mobileqq.troop.selecttroopmember;

import com.tencent.qphone.base.util.QLog;

class TroopMemberDataProvider$3
  implements Runnable
{
  TroopMemberDataProvider$3(TroopMemberDataProvider paramTroopMemberDataProvider) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberDataProvider", 2, "read troop members from database before updating data from server");
    }
    TroopMemberDataProvider localTroopMemberDataProvider = this.this$0;
    TroopMemberDataProvider.a(localTroopMemberDataProvider, localTroopMemberDataProvider.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.3
 * JD-Core Version:    0.7.0.1
 */