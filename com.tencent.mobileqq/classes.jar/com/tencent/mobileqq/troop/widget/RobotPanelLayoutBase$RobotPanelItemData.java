package com.tencent.mobileqq.troop.widget;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class RobotPanelLayoutBase$RobotPanelItemData
{
  public RobotPanelLayoutBase.RobotPanelItemInfoData a;
  public boolean a;
  public RobotPanelLayoutBase.RobotPanelItemInfoData b;
  public boolean b;
  
  public static RobotPanelItemData a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    RobotPanelItemData localRobotPanelItemData = new RobotPanelItemData();
    localRobotPanelItemData.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData = RobotPanelLayoutBase.RobotPanelItemInfoData.a(paramString4, paramString3);
    localRobotPanelItemData.b = RobotPanelLayoutBase.RobotPanelItemInfoData.a(paramString2, paramString1);
    localRobotPanelItemData.jdField_a_of_type_Boolean = false;
    return localRobotPanelItemData;
  }
  
  public static RobotPanelItemData a(cmd0x934.Item paramItem)
  {
    RobotPanelItemData localRobotPanelItemData = new RobotPanelItemData();
    localRobotPanelItemData.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData = RobotPanelLayoutBase.RobotPanelItemInfoData.a(paramItem.off_info);
    localRobotPanelItemData.b = RobotPanelLayoutBase.RobotPanelItemInfoData.a(paramItem.on_info);
    localRobotPanelItemData.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localRobotPanelItemData;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelItemData
 * JD-Core Version:    0.7.0.1
 */