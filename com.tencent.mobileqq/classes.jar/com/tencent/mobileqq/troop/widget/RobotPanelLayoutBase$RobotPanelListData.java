package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class RobotPanelLayoutBase$RobotPanelListData
{
  public String a;
  public ArrayList<RobotPanelLayoutBase.RobotPanelItemData> b;
  
  public static RobotPanelListData a(cmd0x934.List paramList)
  {
    RobotPanelListData localRobotPanelListData = new RobotPanelListData();
    localRobotPanelListData.a = paramList.name.get();
    localRobotPanelListData.b = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localRobotPanelListData.b.add(RobotPanelLayoutBase.RobotPanelItemData.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localRobotPanelListData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelListData
 * JD-Core Version:    0.7.0.1
 */