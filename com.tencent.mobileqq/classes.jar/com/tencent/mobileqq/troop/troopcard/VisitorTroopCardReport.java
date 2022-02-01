package com.tencent.mobileqq.troop.troopcard;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.TroopReportor;

public class VisitorTroopCardReport
{
  public static void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    try
    {
      ReportController.b(null, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
    }
    catch (ClassCastException paramObject)
    {
      String str;
      paramObject.printStackTrace();
      return;
    }
    ReportController.b(null, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, (String)paramObject, "", "", "");
    return;
    paramObject = (Object[])paramObject;
    ReportController.b(null, "dc00898", "", "", "0X800A525", "0X800A525", ((Integer)paramObject[0]).intValue(), 0, (String)paramObject[1], "", "", "");
    return;
    ReportController.b(null, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_objgrp", 0, 0, (String)paramObject, "", "", "");
    return;
    paramObject = (Object[])paramObject;
    ReportController.b(null, "P_CliOper", "Grp_set", "", "Grp_Visdata", "Clk_data", 0, 0, (String)paramObject[0], (String)paramObject[1], "", "");
    return;
    paramObject = (Object[])paramObject;
    ReportController.b(null, "dc00899", "Grp_recom", "", "set_page", "recom_exp", 0, 0, (String)paramObject[0], "", (String)paramObject[1], "");
    return;
    paramObject = (Object[])paramObject;
    ReportController.b(null, "dc00899", "Grp_recom", "", "set_page", "page_exp", 0, 0, (String)paramObject[0], "", (String)paramObject[1], "");
    return;
    ReportController.b(null, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
    return;
    paramObject = (Object[])paramObject;
    TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_join", 0, 0, new String[] { (String)paramObject[0], (String)paramObject[1] });
    return;
    ReportController.b(null, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
    return;
    ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
    return;
    paramObject = (Object[])paramObject;
    ReportController.b(null, "dc00898", "", "", "0X800A527", "0X800A527", ((Integer)paramObject[0]).intValue(), 0, (String)paramObject[1], "", "", "");
    return;
    ReportController.b(null, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
    return;
    ReportController.b(null, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
    return;
    ReportController.b(null, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, (String)paramObject, "", "", "");
    return;
    ReportController.b(null, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, (String)paramObject, "", "", "");
    return;
    paramObject = (Object[])paramObject;
    ReportController.b(null, "dc00898", "", "", "0X800A526", "0X800A526", ((Integer)paramObject[0]).intValue(), 0, (String)paramObject[1], "", "", "");
    return;
    ReportController.b(null, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, (String)paramObject, "", "", "");
    return;
    paramObject = (Object[])paramObject;
    str = (String)paramObject[0];
    if (((Boolean)paramObject[1]).booleanValue())
    {
      paramObject = "0";
    }
    else
    {
      if (!((Boolean)paramObject[2]).booleanValue()) {
        break label819;
      }
      paramObject = "1";
      break label816;
      ReportController.b(null, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, "0", paramObject, "");
      return;
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A57F", 2, 0, "", "", "", "");
      return;
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
      return;
    }
    for (;;)
    {
      label816:
      break;
      label819:
      paramObject = "2";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardReport
 * JD-Core Version:    0.7.0.1
 */