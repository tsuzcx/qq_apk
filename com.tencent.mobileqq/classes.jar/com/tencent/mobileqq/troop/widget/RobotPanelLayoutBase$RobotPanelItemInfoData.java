package com.tencent.mobileqq.troop.widget;

import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class RobotPanelLayoutBase$RobotPanelItemInfoData
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public RobotPanelLayoutBase$RobotPanelItemInfoData()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static RobotPanelItemInfoData a(String paramString1, String paramString2)
  {
    RobotPanelItemInfoData localRobotPanelItemInfoData = new RobotPanelItemInfoData();
    localRobotPanelItemInfoData.jdField_a_of_type_JavaLangString = paramString1;
    localRobotPanelItemInfoData.jdField_b_of_type_JavaLangString = "";
    localRobotPanelItemInfoData.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localRobotPanelItemInfoData.jdField_a_of_type_Int = 0;
      localRobotPanelItemInfoData.jdField_b_of_type_Int = 0;
      localRobotPanelItemInfoData.jdField_c_of_type_Int = 0;
      return localRobotPanelItemInfoData;
    }
    catch (Exception paramString1) {}
    return localRobotPanelItemInfoData;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelItemInfoData
 * JD-Core Version:    0.7.0.1
 */