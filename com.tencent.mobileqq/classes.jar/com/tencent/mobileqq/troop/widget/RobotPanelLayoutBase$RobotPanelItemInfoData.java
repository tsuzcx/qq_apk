package com.tencent.mobileqq.troop.widget;

import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class RobotPanelLayoutBase$RobotPanelItemInfoData
{
  public String a;
  public String b;
  public String c;
  public int d = -1;
  public int e = -16777216;
  public int f = -7829368;
  
  public static RobotPanelItemInfoData a(String paramString1, String paramString2)
  {
    RobotPanelItemInfoData localRobotPanelItemInfoData = new RobotPanelItemInfoData();
    localRobotPanelItemInfoData.a = paramString1;
    localRobotPanelItemInfoData.b = "";
    localRobotPanelItemInfoData.c = paramString2;
    try
    {
      localRobotPanelItemInfoData.d = 0;
      localRobotPanelItemInfoData.e = 0;
      localRobotPanelItemInfoData.f = 0;
      return localRobotPanelItemInfoData;
    }
    catch (Exception paramString1) {}
    return localRobotPanelItemInfoData;
  }
  
  public static RobotPanelItemInfoData a(cmd0x934.ItemInfo paramItemInfo)
  {
    RobotPanelItemInfoData localRobotPanelItemInfoData = new RobotPanelItemInfoData();
    localRobotPanelItemInfoData.a = paramItemInfo.title.get();
    localRobotPanelItemInfoData.b = paramItemInfo.icon.get();
    localRobotPanelItemInfoData.c = paramItemInfo.url.get();
    try
    {
      localRobotPanelItemInfoData.d = Color.parseColor(paramItemInfo.color.get());
      localRobotPanelItemInfoData.e = Color.parseColor(paramItemInfo.font_color.get());
      localRobotPanelItemInfoData.f = Color.parseColor(paramItemInfo.border_color.get());
      return localRobotPanelItemInfoData;
    }
    catch (Exception paramItemInfo) {}
    return localRobotPanelItemInfoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelItemInfoData
 * JD-Core Version:    0.7.0.1
 */