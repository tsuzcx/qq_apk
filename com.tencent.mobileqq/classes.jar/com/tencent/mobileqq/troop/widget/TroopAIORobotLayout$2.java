package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.Callback;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

class TroopAIORobotLayout$2
  implements TroopRobotManager.Callback
{
  TroopAIORobotLayout$2(TroopAIORobotLayout paramTroopAIORobotLayout, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    if (paramInt == 0) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.getContext(), 1, HardCodeUtil.a(2131715028) + "", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotLayout.2
 * JD-Core Version:    0.7.0.1
 */