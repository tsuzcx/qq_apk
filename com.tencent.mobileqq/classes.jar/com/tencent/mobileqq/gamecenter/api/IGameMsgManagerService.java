package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.gamecenter.config.GameCenterMsgBean;
import com.tencent.mobileqq.gamecenter.data.GameMsgRemoteUserItem;
import com.tencent.mobileqq.gamecenter.data.IDataVisitor;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryAIOGreetInfoRsp;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(needUin=false, process={"all"})
public abstract interface IGameMsgManagerService
  extends IRuntimeService
{
  public static final String GAMEID_GET_UNREAD_NUM = "-10001";
  public static final String GAMEID_INIT = "-10000";
  
  public abstract void addUserInfoChangedObserver(GameCenterUnissoObserver paramGameCenterUnissoObserver);
  
  public abstract void cleanSessionUnread(String paramString);
  
  public abstract GameBasicInfo findGameConfig(String paramString);
  
  public abstract GameSwitchConfig findGameSwitchConfig(String paramString);
  
  public abstract GameUserInfo findGameUserInfo(String paramString);
  
  public abstract int getAIORedDotStyle();
  
  public abstract String getAIORedDotStyleId();
  
  public abstract String getAioHippyBundleName();
  
  public abstract String getAioHippyParameters();
  
  public abstract ArrayList<String> getAioQuickReply(String paramString);
  
  public abstract String getBoxMsgSwitchId();
  
  public abstract String getFriVerifyMsg(String paramString);
  
  public abstract String getGameBuddyAppName();
  
  public abstract HashMap<String, GameDetailInfo> getGameDetailInfo(ArrayList<String> paramArrayList);
  
  public abstract String getGameMsgListUrl();
  
  public abstract String getGameMsgSettingUrl();
  
  public abstract String getGamePrefix();
  
  public abstract boolean getHasUnreadMsg();
  
  public abstract GameCenterSessionInfo getLastSessionInfo();
  
  public abstract GameCenterSessionInfo getLastSessionInfoExceptDelSession();
  
  public abstract boolean getMsgShowOnList();
  
  public abstract boolean getNeedPopMsgView();
  
  public abstract String getPlayerInfoUrl();
  
  public abstract String getRedDotConfig(String paramString);
  
  public abstract void getRemoteGameSessionList(IRemoteUserListCallback paramIRemoteUserListCallback);
  
  public abstract long getReqMsgCnt();
  
  public abstract JSONObject getSayHiDefaultConfig();
  
  public abstract IDataVisitor getSessionDelDataHelper();
  
  public abstract GameCenterSessionInfo getSessionInfoByRoleId(String paramString);
  
  public abstract GameCenterSessionInfo getSessionInfoByUin(String paramString);
  
  public abstract List<GameCenterSessionInfo> getSessionInfoList();
  
  public abstract List<GameCenterSessionInfo> getSessionInfoList(int paramInt, String paramString);
  
  public abstract boolean getShowReqMsgUnread();
  
  public abstract GameDetailInfo getSingleGameDetail(String paramString);
  
  public abstract int getUnreadCnt();
  
  public abstract int getUnreadCnt(boolean paramBoolean);
  
  public abstract int getUnreadCnt4MsgTab();
  
  public abstract HashMap<String, Integer> getUnreadForEachGame();
  
  public abstract List<String> getUnreadFriIcon();
  
  public abstract int getUnshowedUnreadCnt();
  
  public abstract int getUnshowedUnreadCntMsgBoxExclusive();
  
  public abstract int getViewType();
  
  public abstract boolean isGameBuddySwitchOpen();
  
  public abstract boolean isGameMsgBlocked(String paramString);
  
  public abstract boolean isGameMsgShowInBoxFormTabConfig();
  
  public abstract boolean isGameMsgShowInMsgBox(String paramString);
  
  public abstract boolean isGameMsgSync(String paramString);
  
  public abstract boolean isGrayOpen();
  
  public abstract boolean isInited();
  
  public abstract boolean isJumpGameProfileCard();
  
  public abstract boolean isShowInMsgBox();
  
  public abstract void notifyGameMsgSayHiInfo(int paramInt, long paramLong, String paramString, GameMsgGreeting.QueryAIOGreetInfoRsp paramQueryAIOGreetInfoRsp);
  
  public abstract void notifyReceiveGameMsgSayHiMessage(String paramString1, String paramString2);
  
  public abstract void notifyRemoteUserReady(int paramInt, ArrayList<GameMsgRemoteUserItem> paramArrayList);
  
  public abstract void notifySessionChangedBySwitch();
  
  public abstract void onGameMsgRRecv(int paramInt);
  
  public abstract void onGameSwitchChange(String paramString, int paramInt1, int paramInt2);
  
  public abstract void removeGameMsgSayHiCallback();
  
  public abstract void removeUserInfoChangedObserver(GameCenterUnissoObserver paramGameCenterUnissoObserver);
  
  public abstract void reqGameMsgSayHiInfo(String paramString1, String paramString2, IGameMsgSayHiCallback paramIGameMsgSayHiCallback);
  
  public abstract void saveOrUpdateGameBasicConfigs(ArrayList<GameBasicInfo> paramArrayList);
  
  public abstract void saveOrUpdateGameSwitchConfigs(ArrayList<GameSwitchConfig> paramArrayList);
  
  public abstract void saveOrUpdateGameUsrInfoArrays(ArrayList<GameUserInfo> paramArrayList);
  
  public abstract void setMsgShowOnList(boolean paramBoolean);
  
  public abstract void setNeedPopMsgView(boolean paramBoolean);
  
  public abstract void setPubAccRedSwitch(int paramInt);
  
  public abstract void setReaded(GameCenterSessionInfo paramGameCenterSessionInfo);
  
  public abstract void setShowReqMsgUnread(boolean paramBoolean);
  
  public abstract void setUnshowedUnreadCnt(int paramInt);
  
  public abstract void setUnshowedUnreadCntV2(int paramInt, boolean paramBoolean);
  
  public abstract PopupWindow showGameAIOStatusPopupWindow(GameDetailInfo paramGameDetailInfo, Activity paramActivity, Bundle paramBundle, View.OnClickListener paramOnClickListener);
  
  public abstract void updateMgrConfig(GameCenterMsgBean paramGameCenterMsgBean);
  
  public abstract void updateRedDotConfig(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService
 * JD-Core Version:    0.7.0.1
 */