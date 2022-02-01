package com.tencent.mobileqq.troop.selecttroopmember;

import com.tencent.qphone.base.util.QLog;

class TroopMemberDataProvider$4
  implements Runnable
{
  TroopMemberDataProvider$4(TroopMemberDataProvider paramTroopMemberDataProvider) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberDataProvider", 2, "read troop members from database before updating data from server");
    }
    TroopMemberDataProvider.a(this.this$0, this.this$0.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.4
 * JD-Core Version:    0.7.0.1
 */