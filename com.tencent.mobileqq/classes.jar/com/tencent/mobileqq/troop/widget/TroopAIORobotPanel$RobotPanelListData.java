package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class TroopAIORobotPanel$RobotPanelListData
{
  public String a;
  public ArrayList a;
  
  public static RobotPanelListData a(cmd0x934.List paramList)
  {
    RobotPanelListData localRobotPanelListData = new RobotPanelListData();
    localRobotPanelListData.jdField_a_of_type_JavaLangString = paramList.name.get();
    localRobotPanelListData.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localRobotPanelListData.jdField_a_of_type_JavaUtilArrayList.add(TroopAIORobotPanel.RobotPanelItemData.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localRobotPanelListData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.RobotPanelListData
 * JD-Core Version:    0.7.0.1
 */