package com.tencent.mobileqq.selectmember;

import com.tencent.qphone.base.util.QLog;

class TroopAddFrdsInnerFrame$4
  implements Runnable
{
  TroopAddFrdsInnerFrame$4(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "read troop members from database before updating data from server");
    }
    TroopAddFrdsInnerFrame localTroopAddFrdsInnerFrame = this.this$0;
    TroopAddFrdsInnerFrame.a(localTroopAddFrdsInnerFrame, localTroopAddFrdsInnerFrame.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.4
 * JD-Core Version:    0.7.0.1
 */