package com.tencent.mobileqq.troop.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.GameTroopSelectMemberInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ITroopUtilApi
  extends QRouteApi
{
  public static final String GAME_H5_SELECT_GAME_APPID = "GAME_H5_SELECT_GAME_APPID";
  public static final int GAME_SELECT_SEARCH_TYPE_ACTION = 2;
  public static final int GAME_SELECT_SEARCH_TYPE_CLICK = 3;
  public static final int GAME_SELECT_SEARCH_TYPE_INIT = 1;
  public static final int TYPE_GUEST_VISTOR = 2;
  
  public abstract int QAVHrMeeting_hrExtra(long paramLong);
  
  public abstract void addLocalSetTopDataIgnore(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void doReqGameFriends(AppInterface paramAppInterface, String paramString, Activity paramActivity);
  
  public abstract void fillResultRecordLevelIcon(ArrayList<GameTroopSelectMemberInfo> paramArrayList);
  
  public abstract String getQQGameTroopManager_TASK_NAME_MEMBER_StringValue();
  
  public abstract void handleGameClockData(AppInterface paramAppInterface);
  
  public abstract boolean hasSetTroopHead(String paramString);
  
  public abstract void initTaskSet(AppInterface paramAppInterface);
  
  public abstract boolean isGameClockBusiness(Activity paramActivity);
  
  public abstract boolean isLocalSetTopDataIgnoreContain(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean isNeedReqGameInfo(Activity paramActivity);
  
  public abstract void joinRecommendTroop(Context paramContext, Object paramObject, int paramInt);
  
  public abstract void onDestroyForQQGameTroopManager(AppInterface paramAppInterface);
  
  public abstract void onOnlineRsp(AppInterface paramAppInterface, List<String> paramList);
  
  public abstract void onSearchBarDone(AppInterface paramAppInterface, Activity paramActivity, List<GameTroopSelectMemberInfo> paramList, int paramInt, String paramString1, String paramString2);
  
  public abstract void openRecommendTroop(Context paramContext, Object paramObject, int paramInt1, int paramInt2);
  
  public abstract void openRobotProfileCard(Context paramContext, String paramString1, String paramString2);
  
  public abstract void openTroopInfoActivity(Context paramContext, Bundle paramBundle, int paramInt);
  
  public abstract void openTroopInfoActivity(Context paramContext, String paramString);
  
  public abstract boolean qAVHrMeeting_isHRConf(long paramLong);
  
  public abstract boolean qAVHrMeeting_isNoRight(int paramInt);
  
  public abstract boolean qAVHrMeeting_isPSTNConf(long paramLong);
  
  public abstract void reportFinishClick(String paramString1, ArrayList<GameTroopSelectMemberInfo> paramArrayList, String paramString2);
  
  public abstract void reqGameInfoWhenIdle(AppInterface paramAppInterface, Object paramObject, Activity paramActivity);
  
  public abstract void smallScreenUtils_getTrace(String paramString);
  
  public abstract void sortAndPreloadIfNeed(AppInterface paramAppInterface, String paramString);
  
  public abstract void updateGameView(AppInterface paramAppInterface, Activity paramActivity, Object paramObject, TextView paramTextView1, ImageView paramImageView, TextView paramTextView2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopUtilApi
 * JD-Core Version:    0.7.0.1
 */