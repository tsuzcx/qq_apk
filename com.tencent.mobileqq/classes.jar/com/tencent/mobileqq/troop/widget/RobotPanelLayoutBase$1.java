package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService.Callback;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

class RobotPanelLayoutBase$1
  implements ITroopRobotService.Callback
{
  RobotPanelLayoutBase$1(RobotPanelLayoutBase paramRobotPanelLayoutBase, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    if (paramInt == 0) {
      return;
    }
    paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131713405));
    localStringBuilder.append("");
    QQToast.a(paramRspBody, 1, localStringBuilder.toString(), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.1
 * JD-Core Version:    0.7.0.1
 */