package com.tencent.mobileqq.troop.quickat.ui;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.qphone.base.util.QLog;

class AtPanel$1
  extends TroopBusinessObserver
{
  AtPanel$1(AtPanel paramAtPanel) {}
  
  public void onTroopMemberUpdate()
  {
    super.onTroopMemberUpdate();
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onTroopMemberUpdate: invoked. ");
    }
    AtPanel.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtPanel.1
 * JD-Core Version:    0.7.0.1
 */