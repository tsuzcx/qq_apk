package com.tencent.mobileqq.selectmember;

import com.tencent.qphone.base.util.QLog;

class TroopMemberListInnerFrame$4
  implements Runnable
{
  TroopMemberListInnerFrame$4(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "read troop members from database before updating data from server");
    }
    TroopMemberListInnerFrame localTroopMemberListInnerFrame = this.this$0;
    TroopMemberListInnerFrame.a(localTroopMemberListInnerFrame, localTroopMemberListInnerFrame.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.4
 * JD-Core Version:    0.7.0.1
 */