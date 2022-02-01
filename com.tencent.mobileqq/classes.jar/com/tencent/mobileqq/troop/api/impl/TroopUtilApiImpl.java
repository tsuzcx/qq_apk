package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.GameTroopSelectMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopUtilApiImpl
  implements ITroopUtilApi
{
  public static ArrayList<ResultRecord> convertToResultRecordList(List<GameTroopSelectMemberInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GameTroopSelectMemberInfo localGameTroopSelectMemberInfo = (GameTroopSelectMemberInfo)paramList.next();
        localArrayList.add(new ResultRecord(localGameTroopSelectMemberInfo.a, localGameTroopSelectMemberInfo.b, localGameTroopSelectMemberInfo.c, localGameTroopSelectMemberInfo.d, localGameTroopSelectMemberInfo.e, localGameTroopSelectMemberInfo.f, localGameTroopSelectMemberInfo.g, localGameTroopSelectMemberInfo.h, localGameTroopSelectMemberInfo.i));
      }
    }
    return localArrayList;
  }
  
  public int QAVHrMeeting_hrExtra(long paramLong)
  {
    return QAVHrMeeting.c(paramLong);
  }
  
  public void addLocalSetTopDataIgnore(AppRuntime paramAppRuntime, String paramString)
  {
    SharedPreUtils.k(paramAppRuntime.getApplication().getApplicationContext(), paramAppRuntime.getCurrentAccountUin(), paramString);
  }
  
  public void doReqGameFriends(AppInterface paramAppInterface, String paramString, Activity paramActivity)
  {
    ((QQGameTroopManager)paramAppInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).a(paramString, (QBaseActivity)paramActivity);
  }
  
  public void fillResultRecordLevelIcon(ArrayList<GameTroopSelectMemberInfo> paramArrayList)
  {
    QQGameTroopManager.a(convertToResultRecordList(paramArrayList));
  }
  
  public String getQQGameTroopManager_TASK_NAME_MEMBER_StringValue()
  {
    return "member";
  }
  
  public void handleGameClockData(AppInterface paramAppInterface)
  {
    ((QQGameTroopManager)paramAppInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).b();
  }
  
  public boolean hasSetTroopHead(String paramString)
  {
    return TroopUtils.b(paramString);
  }
  
  public void initTaskSet(AppInterface paramAppInterface)
  {
    ((QQGameTroopManager)paramAppInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).a();
  }
  
  public boolean isGameClockBusiness(Activity paramActivity)
  {
    return QQGameTroopManager.b(paramActivity);
  }
  
  public boolean isLocalSetTopDataIgnoreContain(AppRuntime paramAppRuntime, String paramString)
  {
    return SharedPreUtils.as(paramAppRuntime.getApplication(), paramAppRuntime.getCurrentAccountUin()).contains(paramString);
  }
  
  public boolean isNeedReqGameInfo(Activity paramActivity)
  {
    return QQGameTroopManager.a(paramActivity);
  }
  
  public boolean isUsingCameraOnVideo(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return false;
    }
    return ((QQAppInterface)paramAppRuntime).isUsingCameraOnVideo();
  }
  
  public void joinRecommendTroop(Context paramContext, Object paramObject, int paramInt)
  {
    TroopUtils.a(paramContext, paramObject, paramInt);
  }
  
  public void onDestroyForQQGameTroopManager(AppInterface paramAppInterface)
  {
    ((QQGameTroopManager)paramAppInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).onDestroy();
  }
  
  public void onOnlineRsp(AppInterface paramAppInterface, List<String> paramList)
  {
    ((QQGameTroopManager)paramAppInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).a(paramList);
  }
  
  public void onSearchBarDone(AppInterface paramAppInterface, Activity paramActivity, List<GameTroopSelectMemberInfo> paramList, int paramInt, String paramString1, String paramString2)
  {
    ((QQGameTroopManager)paramAppInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).a(paramActivity, convertToResultRecordList(paramList), paramInt, paramString1, paramString2);
  }
  
  public void openRecommendTroop(Context paramContext, Object paramObject, int paramInt1, int paramInt2)
  {
    TroopUtils.a(paramContext, paramObject, paramInt1, paramInt2);
  }
  
  public void openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    RobotUtils.a(paramContext, paramString1, paramString2);
  }
  
  public void openTroopInfoActivity(Context paramContext, Bundle paramBundle, int paramInt)
  {
    TroopUtils.a(paramContext, paramBundle, paramInt);
  }
  
  public void openTroopInfoActivity(Context paramContext, String paramString)
  {
    paramString = TroopInfoUIUtil.a(paramString, 4);
    paramString.putInt("t_s_f", 1001);
    TroopUtils.a(paramContext, paramString, 2);
  }
  
  public boolean qAVHrMeeting_isHRConf(long paramLong)
  {
    return QAVHrMeeting.b(paramLong);
  }
  
  public boolean qAVHrMeeting_isNoRight(int paramInt)
  {
    return QAVHrMeeting.a(paramInt);
  }
  
  public boolean qAVHrMeeting_isPSTNConf(long paramLong)
  {
    return QAVHrMeeting.a(paramLong);
  }
  
  public void reportFinishClick(String paramString1, ArrayList<GameTroopSelectMemberInfo> paramArrayList, String paramString2)
  {
    QQGameTroopManager.a(paramString1, convertToResultRecordList(paramArrayList), paramString2);
  }
  
  public void reqGameInfoWhenIdle(AppInterface paramAppInterface, Object paramObject, Activity paramActivity)
  {
    ((QQGameTroopManager)paramAppInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).a((PinnedDividerListView)paramObject, paramActivity);
  }
  
  public void sendReadConfirm(AppRuntime paramAppRuntime, String paramString)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.b = paramString;
    localSessionInfo.c = paramString;
    localSessionInfo.a = 1;
    ChatActivityFacade.a((QQAppInterface)paramAppRuntime, localSessionInfo);
  }
  
  public void showGroupQavActionSheet(AppInterface paramAppInterface, Context paramContext, String paramString, boolean paramBoolean)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.b = paramString;
    localSessionInfo.a = 1;
    VideoItemBuilder.a((QQAppInterface)paramAppInterface, paramContext, localSessionInfo, 10, false, paramAppInterface.getCurrentUin(), "");
  }
  
  public void smallScreenUtils_getTrace(String paramString)
  {
    SmallScreenUtils.a(paramString);
  }
  
  public void sortAndPreloadIfNeed(AppInterface paramAppInterface, String paramString)
  {
    ((QQGameTroopManager)paramAppInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).a(paramString);
  }
  
  public void updateGameView(AppInterface paramAppInterface, Activity paramActivity, Object paramObject, TextView paramTextView1, ImageView paramImageView, TextView paramTextView2)
  {
    paramAppInterface = (QQGameTroopManager)paramAppInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER);
    QQGameTroopManager.a(paramActivity, (TroopMemberInfo)paramObject, paramTextView1, paramImageView, paramTextView2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */