package com.tencent.mobileqq.troop.widget;

import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class TroopAIORobotPanel$RobotPanelItemInfoData
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public TroopAIORobotPanel$RobotPanelItemInfoData()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static RobotPanelItemInfoData a(cmd0x934.ItemInfo paramItemInfo)
  {
    RobotPanelItemInfoData localRobotPanelItemInfoData = new RobotPanelItemInfoData();
    localRobotPanelItemInfoData.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localRobotPanelItemInfoData.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localRobotPanelItemInfoData.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localRobotPanelItemInfoData.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localRobotPanelItemInfoData.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localRobotPanelItemInfoData.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localRobotPanelItemInfoData;
    }
    catch (Exception paramItemInfo) {}
    return localRobotPanelItemInfoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.RobotPanelItemInfoData
 * JD-Core Version:    0.7.0.1
 */