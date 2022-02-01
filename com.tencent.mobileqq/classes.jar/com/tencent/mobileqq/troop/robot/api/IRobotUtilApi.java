package com.tencent.mobileqq.troop.robot.api;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IRobotUtilApi
  extends QRouteApi
{
  public static final String SP_HISTORY_ROBOT_UIN_RED_LIST = "sp_history_robot_red_list";
  public static final String SP_NEW_ROBOT_UIN_RED_LIST = "sp_new_robot_red_list";
  public static final String SP_ROBOT_IN_TROOP_NAME = "sp_robot_in_troop";
  public static final String SP_ROBOT_RED_BE_ROLE_FOR_MEMBER = "sp_robot_red_limit_role_for_member";
  public static final String SP_ROBOT_RED_INFO_EXPIRE_TIME = "sp_robot_red_expire_time";
  public static final String SP_ROBOT_RED_INFO_UPDATE_TIME = "sp_robot_red_update_time";
  public static final String SP_ROBOT_RED_IN_TROOP_AIO = "sp_robot_red_int_troop_aio";
  public static final String SP_ROBOT_RED_ITEM_IN_CHAT_SETTING = "sp_robot_red_item_int_chat_setting";
  public static final String UIN_LIST_SEPARATOR = "_";
  
  public abstract ArrayList<String> SplitUinListFromString(String paramString);
  
  public abstract String convertUinListToString(ArrayList<String> paramArrayList);
  
  public abstract boolean getBeAllMemberShowRed(AppRuntime paramAppRuntime);
  
  public abstract ArrayList<String> getHistoryRobotListFromSp(AppRuntime paramAppRuntime);
  
  public abstract boolean getIfRobotRedInfoNeedUpdate(AppRuntime paramAppRuntime);
  
  public abstract boolean getIfTheRightRoleInTroopShowRobotRedDot(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean getNeedShowRobotRedDotAio(AppRuntime paramAppRuntime, String paramString);
  
  public abstract ArrayList<String> getNewRobotListFromSp(AppRuntime paramAppRuntime);
  
  public abstract String getRobotAioBar(Context paramContext, String paramString);
  
  public abstract boolean getRobotItemRedShowed(AppRuntime paramAppRuntime);
  
  public abstract String getRobotProfileUrl(String paramString1, String paramString2);
  
  public abstract SharedPreferences getRobotSP(AppRuntime paramAppRuntime);
  
  public abstract String getRobotVoiceTail(Context paramContext, String paramString);
  
  public abstract boolean isRobotSwitchOn(AppRuntime paramAppRuntime);
  
  public abstract void openRobotProfileCard(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean setHistoryRobotListToSp(AppRuntime paramAppRuntime, ArrayList<String> paramArrayList);
  
  public abstract void setNeedShowRobotRedDotAio(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract boolean setNewRobotListToSp(AppRuntime paramAppRuntime, ArrayList<String> paramArrayList);
  
  public abstract void setRobotItemRedShowed(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void setRobotRedForAllMembers(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void setRobotRedInfoUpdate(AppRuntime paramAppRuntime, long paramLong);
  
  public abstract void updateRobotAioBar(Context paramContext, String paramString1, String paramString2);
  
  public abstract void updateRobotVoiceTail(Context paramContext, String paramString1, String paramString2);
  
  public abstract void updateTroopRobotConfig(boolean paramBoolean, String paramString);
  
  public abstract void updateTroopRobotPanelVersion(Context paramContext, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.IRobotUtilApi
 * JD-Core Version:    0.7.0.1
 */