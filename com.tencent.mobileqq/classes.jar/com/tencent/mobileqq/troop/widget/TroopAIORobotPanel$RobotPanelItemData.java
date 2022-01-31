package com.tencent.mobileqq.troop.widget;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class TroopAIORobotPanel$RobotPanelItemData
{
  public TroopAIORobotPanel.RobotPanelItemInfoData a;
  public boolean a;
  public TroopAIORobotPanel.RobotPanelItemInfoData b;
  public boolean b;
  
  public static RobotPanelItemData a(cmd0x934.Item paramItem)
  {
    RobotPanelItemData localRobotPanelItemData = new RobotPanelItemData();
    localRobotPanelItemData.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$RobotPanelItemInfoData = TroopAIORobotPanel.RobotPanelItemInfoData.a(paramItem.off_info);
    localRobotPanelItemData.b = TroopAIORobotPanel.RobotPanelItemInfoData.a(paramItem.on_info);
    localRobotPanelItemData.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localRobotPanelItemData;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.RobotPanelItemData
 * JD-Core Version:    0.7.0.1
 */