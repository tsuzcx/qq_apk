package com.tencent.mobileqq.troop.robot.api;

import android.content.Context;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory;
import com.tencent.mobileqq.troop.robot.TroopRobotData;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

@Service(process={"all"})
public abstract interface ITroopRobotService
  extends IRuntimeService
{
  public static final String C2C_FAKE_TROOP_UIN = "1";
  public static final String ITEM_EMOJI = "emoji";
  public static final String ITEM_IMAGE = "image";
  public static final String ITEM_VOICE = "voice";
  public static final int REQ_TIME_OUT = 12000;
  public static final String ROBOT_NEWS_CLASS_ID = "robot_news_class_id";
  public static final String ROBOT_SHORT_LINK_DESCRIPTION = "robot_short_link_description";
  public static final String ROBOT_SHORT_LINK_PROCESSED = "robot_processed";
  public static final String ROBOT_SHORT_LINK_URL = "robot_short_link_url";
  
  public abstract boolean checkAndProcessJumpRobotPage(Context paramContext, String paramString, long paramLong);
  
  public abstract void closeTalking();
  
  public abstract void configRobotFromServer(JSONObject paramJSONObject);
  
  public abstract oidb_0x496.RobotSubscribeCategory findSubscribeCategory(int paramInt);
  
  public abstract String generateMoreDetailMsg(MessageRecord paramMessageRecord);
  
  public abstract ArrayList<TroopRobotInfo> getAddedTroopRobotsForTroopCard(long paramLong);
  
  public abstract ArrayList<TroopRobotInfo> getAllAddedRobots(long paramLong);
  
  public abstract ArrayList<TroopRobotInfo> getAllTroopRobots(long paramLong);
  
  public abstract ArrayList<TroopRobotInfo> getAllUnAddedRobots(long paramLong);
  
  public abstract ArrayList<String> getCurrentRobotAioConfig();
  
  public abstract String getMessageKey(MessageRecord paramMessageRecord);
  
  public abstract String getRobotVoiceTail(String paramString);
  
  public abstract String getRobotWarning();
  
  public abstract String getTalkingNickName();
  
  public abstract String getTalkingRobotUin();
  
  public abstract TroopRobotData getTroopRobotData(long paramLong);
  
  public abstract int getTroopRobotMaxNum(long paramLong);
  
  public abstract String getUserVoiceTail(String paramString);
  
  public abstract boolean hasNext(MessageRecord paramMessageRecord);
  
  public abstract boolean hasProcessedMoreDetail(MessageRecord paramMessageRecord);
  
  public abstract boolean hasRobotNewsClassId(MessageRecord paramMessageRecord);
  
  public abstract boolean isEndingMsg(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean isRobotSwichOn();
  
  public abstract boolean isRobotTroop(String paramString);
  
  public abstract boolean isRobotUin(long paramLong);
  
  public abstract boolean isRobotUin(String paramString);
  
  public abstract boolean isRobotUinNeedShowRed(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract boolean isTalking();
  
  public abstract boolean isTalkingMsg(String paramString1, String paramString2, String paramString3);
  
  public abstract void markStart(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3);
  
  public abstract void onGetAddedRobot(long paramLong, ArrayList<TroopRobotInfo> paramArrayList);
  
  public abstract void onGetAllRobot(long paramLong, ArrayList<TroopRobotInfo> paramArrayList, int paramInt);
  
  public abstract void onGetRobotRedInfo(AppRuntime paramAppRuntime, long paramLong, ArrayList<String> paramArrayList);
  
  public abstract void onSetTroopRobot(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void openTalking(String paramString1, String paramString2);
  
  public abstract void openTalking(String paramString1, String paramString2, String paramString3);
  
  public abstract void preProcessMessageMoreDetail(MessageRecord paramMessageRecord);
  
  public abstract byte[] readRobotConfig();
  
  public abstract byte[] readRobotPanelData(String paramString1, String paramString2);
  
  public abstract void release(String paramString1, String paramString2, String paramString3);
  
  public abstract void removeRobotUinInRed(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void reqGrayTips(long paramLong1, long paramLong2, String paramString, ITroopRobotService.Callback paramCallback);
  
  public abstract void reqGrayTips(long paramLong, String paramString, ITroopRobotService.Callback paramCallback);
  
  public abstract void reqGrayTipsInner(int paramInt, long paramLong1, long paramLong2, String paramString, ITroopRobotService.Callback paramCallback);
  
  public abstract void reqPanelList(long paramLong, int paramInt, ITroopRobotService.Callback paramCallback);
  
  public abstract void reqPanelList(long paramLong1, long paramLong2, int paramInt, ITroopRobotService.Callback paramCallback);
  
  public abstract void reqPanelListInner(int paramInt1, long paramLong1, long paramLong2, int paramInt2, ITroopRobotService.Callback paramCallback);
  
  public abstract void saveRobotConfig(oidb_0x496.Robot paramRobot);
  
  public abstract void saveRobotPanelData(String paramString1, String paramString2, cmd0x934.RspBody paramRspBody);
  
  public abstract void sendContent(long paramLong1, long paramLong2, String paramString, ITroopRobotService.Callback paramCallback);
  
  public abstract void sendContent(long paramLong, String paramString, ITroopRobotService.Callback paramCallback);
  
  public abstract void sendContentInner(int paramInt, long paramLong1, long paramLong2, String paramString, ITroopRobotService.Callback paramCallback);
  
  public abstract void setCurrentAtRobotUin(String paramString);
  
  public abstract void setOnTalkingChangeListener(ITroopRobotService.OnTalkingChangeListener paramOnTalkingChangeListener);
  
  public abstract void setRobotConfig(oidb_0x496.Robot paramRobot);
  
  public abstract void updateConfig(boolean paramBoolean, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.ITroopRobotService
 * JD-Core Version:    0.7.0.1
 */